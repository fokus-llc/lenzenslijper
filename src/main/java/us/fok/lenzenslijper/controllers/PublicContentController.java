package us.fok.lenzenslijper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import us.fok.lenzenslijper.domain.SystemSchemaConstants;
import us.fok.lenzenslijper.models.dto.LinkTypeRecord;
import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;
import us.fok.lenzenslijper.models.immutable.*;
import us.fok.lenzenslijper.models.dto.ReleasedRevisionSummary;
import us.fok.lenzenslijper.models.pagination.ListPaginator;
import us.fok.lenzenslijper.views.ConceptNestableView;
import us.fok.lenzenslijper.presenters.DocumentSummaryPresenter;
import us.fok.lenzenslijper.models.pagination.PaginatedList;
import us.fok.lenzenslijper.selectors.*;
import us.fok.lenzenslijper.views.*;
import us.fok.lenzenslijper.persistence.repositories.ConsolidatedRepository;
import us.fok.lenzenslijper.views.geojson.FeatureCollection;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

import static us.fok.lenzenslijper.util.StringUtilities.stringIsPresent;
import static us.fok.lenzenslijper.util.NumericUtilities.constrainInteger;

@Controller
@Path("public")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8") // NOTE: ignored on CORS requests
public class PublicContentController {

    private static final String SORT_BY_NAME   = "name";
    private static final String SORT_BY_OLDEST = "oldest";
    private static final String SORT_BY_RECENT = "recent";

    private final ConsolidatedRepository repo;

    @Autowired
    public PublicContentController(ConsolidatedRepository repo) {
        this.repo = repo;
    }

    @GET @Path("projects")
    public PaginatedList<ProjectWithMode> projects(@QueryParam("sort") String sortName,
                                                   @QueryParam("limit") Integer limit,
                                                   @QueryParam("offset") Integer offset) {
        ProjectsSelector selector = new ProjectsSelector(constrainInteger(limit, null, 1, 100),
                                                         constrainInteger(offset, 0, 0, null));
        if (SORT_BY_RECENT.equals(sortName)) {
            selector.setSortOrder(ProjectsSelector.Sort.RECENT_ACTIVITY);
        }
        return repo.fetchVisibleProjectsWithMode(selector);
    }

    @GET @Path("projects/{slug: [a-z0-9-]*}")
    public ProjectWithMode project(@PathParam("slug") String projectSlug) {
        return fetchVisibleProjectOrBust(projectSlug);
    }

    @GET @Path("documents")
    public PaginatedList<DocumentSummaryView> publishedDocuments(@QueryParam("project") String projectSlug,
                                                                 @QueryParam("prefix") String prefix,
                                                                 @QueryParam("document_type") String documentTypeName,
                                                                 @QueryParam("entity_type") String prototypeConceptSlug,
                                                                 @QueryParam("concept") String conceptSlug,
                                                                 @QueryParam("sort") String sortName,
                                                                 @QueryParam("limit") Integer limit,
                                                                 @QueryParam("offset") Integer offset) {
        DocumentsSelector selector = new DocumentsSelector();
        configureDocumentsSelector(selector, projectSlug, prefix, documentTypeName, prototypeConceptSlug, conceptSlug, sortName, limit, offset);
        PaginatedList<ProjectUserDocumentSummary> documents = repo.fetchPublishedDocumentSummaries(selector);
        return presentProjectUserDocuments(documents);
    }

    private void configureDocumentsSelector(DocumentsSelector selector, String projectSlug, String prefix, String documentTypeName, String prototypeConceptSlug, String conceptSlug, String sortName, Integer limit, Integer offset) {

        if (stringIsPresent(projectSlug)) {
            ProjectWithMode project = fetchVisibleProjectOrBust(projectSlug);
            selector.setProjectId(project.getId());
        }

        if (stringIsPresent(prefix)) {
            selector.setPrefix(prefix);
        }

        if (stringIsPresent(documentTypeName)) {
            int documentTypeId = getDocumentTypeIdOrBust(documentTypeName);
            selector.setDocumentTypeId(documentTypeId);
        }

        if (stringIsPresent(prototypeConceptSlug)) {
            UUID conceptId = getCoreConceptIdOrBust(prototypeConceptSlug);
            selector.setPrototypeConceptId(conceptId);
        }

        if (stringIsPresent(conceptSlug)) {
            UUID conceptLinkableId = getPublicConceptLinkableIdOrBust(conceptSlug);
            selector.setRelatedConceptLinkableId(conceptLinkableId);
        }

        selector.setSort(SORT_BY_NAME.equals(sortName) ? ContentSelector.Sort.NAME : ContentSelector.Sort.RECENT);

        selector.setLimit(constrainInteger(limit, 10, 1, 100));
        selector.setOffset(constrainInteger(offset, 0, 0, null));
    }

    private UUID getPublicConceptLinkableIdOrBust(String conceptSlug) {
        UUID conceptLinkableId = repo.fetchPublicConceptLinkableId(conceptSlug);
        if (conceptLinkableId == null) {
            raise(Response.Status.NOT_FOUND, "Concept '" + conceptSlug + "' not found");
        }
        return conceptLinkableId;
    }

    private PaginatedList<DocumentSummaryView> presentProjectUserDocuments(PaginatedList<ProjectUserDocumentSummary> documents) {
        List<DocumentSummaryView> views = new DocumentSummaryPresenter(repo.getSchemaDictionary()).summarize(documents.getItems());
        return repaginate(views, documents);
    }

    private <T> PaginatedList<T> repaginate(List<T> mappedItems, PaginatedList<?> original) {
        ListPaginator<T> paginator = new ListPaginator<T>(mappedItems);
        return paginator.paginate(original.getCount(), original.getOffset(), original.getLimit());
    }

    @GET @Path("linked/documents/{uuid: [a-f0-9-]*}")
    public DocumentDetailView publishedLinkedDocument(@PathParam("uuid") UUID linkableId) {
        DocumentDetailView documentView = repo.fetchPublishedDocument(linkableId, null);
        if (documentView == null) {
            raise(Response.Status.NOT_FOUND, "Document " + linkableId + " not found");
        }
        return documentView;
    }

    @GET @Path("linked/documents/{uuid: [a-f0-9-]*}/revisions/{revisionId: [a-f0-9-]*}")
    public DocumentDetailView publishedRevision(@PathParam("uuid") UUID linkableId,
                                                @PathParam("revisionId") UUID revisionId) {
        DocumentDetailView documentView = repo.fetchPublishedDocument(linkableId, revisionId);
        if (documentView == null) {
            raise(Response.Status.NOT_FOUND, "Document " + linkableId + "@" + revisionId + " not found");
        }
        return documentView;
    }

    @GET @Path("linked/documents/{uuid: [a-f0-9-]*}/members")
    public PaginatedList<DocumentDetailView> publishedDocumentMembers(@PathParam("uuid") UUID linkableId,
                                                                      @QueryParam("concept") String concept,
                                                                      @QueryParam("limit") Integer limit,
                                                                      @QueryParam("offset") Integer offset) {
        PaginatedList<DocumentDetailView> memberViews =
            repo.fetchPublishedMembers(linkableId, null, configureMembersSelector(limit, offset, concept));
        if (memberViews == null) {
            raise(Response.Status.NOT_FOUND, "Collection document " + linkableId + " not found");
        }
        return memberViews;
    }

    private MembersSelector configureMembersSelector(Integer limit, Integer offset, String conceptSlug) {
        MembersSelector selector = new MembersSelector(constrainInteger(limit, 10, 1, 100),
                                                       constrainInteger(offset, 0, 0, null));
        selector.setConceptSlug(conceptSlug);
        return selector;
    }

    @GET @Path("linked/documents/{uuid: [a-f0-9-]*}/revisions/{revisionId: [a-f0-9-]*}/members")
    public PaginatedList<DocumentDetailView> publishedRevisionMembers(@PathParam("uuid") UUID linkableId,
                                                                      @PathParam("revisionId") UUID revisionId,
                                                                      @QueryParam("concept") String concept,
                                                                      @QueryParam("limit") Integer limit,
                                                                      @QueryParam("offset") Integer offset) {
        PaginatedList<DocumentDetailView> memberViews =
            repo.fetchPublishedMembers(linkableId, revisionId, configureMembersSelector(limit, offset, concept));
        if (memberViews == null) {
            raise(Response.Status.NOT_FOUND, "Document " + linkableId + "@" + revisionId + " not found");
        }
        return memberViews;
    }

    @GET @Path("linked/documents/{uuid: [a-f0-9-]*}/revisions")
    public PaginatedList<ReleasedRevisionSummary> publishedDocumentRevisions(@PathParam("uuid") UUID linkableId,
                                                                             @QueryParam("sort") String sortName,
                                                                             @QueryParam("limit") Integer limit,
                                                                             @QueryParam("offset") Integer offset) {
        ReleasedRevisionSelector selector = new ReleasedRevisionSelector(linkableId, SystemSchemaConstants.RELEASE_TAG_ID_PUBLISHED);
        configurePublishedRevisionsSelector(selector, sortName, limit, offset);
        return repo.fetchReleasedRevisions(selector);
    }

    private ReleasedRevisionSelector configurePublishedRevisionsSelector(ReleasedRevisionSelector selector, String sortName, Integer limit, Integer offset) {
        selector.setSort(SORT_BY_OLDEST.equals(sortName) ? ReleasedRevisionSelector.Sort.OLDEST : ReleasedRevisionSelector.Sort.LATEST);
        selector.setLimit(constrainInteger(limit, 10, 1, 100));
        selector.setOffset(constrainInteger(offset, 0, 0, null));
        return selector;
    }

    @GET @Path("linked/documents/{uuid: [a-f0-9-]*}/revisions/{revisionId: [a-f0-9-]*}/geography")
    public FeatureCollection publishedRevisionGeography(@PathParam("uuid") UUID linkableId,
                                                        @PathParam("revisionId") UUID revisionId) {
        return repo.fetchPublishedGeography(linkableId, revisionId);
    }

    @GET @Path("linked/documents/{uuid: [a-f0-9-]*}/geography")
    public FeatureCollection geography(@PathParam("uuid") UUID linkableId) {
        return repo.fetchPublishedGeography(linkableId, null);
    }

    @GET @Path("titles")
    public PaginatedList<String> publishedTitles(@QueryParam("prefix") String prefix,
                                                 @QueryParam("limit") Integer limit,
                                                 @QueryParam("offset") Integer offset) {
        ReleasedTitleSelector selector =
            new ReleasedTitleSelector(prefix,
                                      SystemSchemaConstants.RELEASE_TAG_ID_PUBLISHED,
                                      constrainInteger(offset, 0, 0, null),
                                      limit);
        return repo.fetchReleasedTitles(selector);
    }

    @GET @Path("concepts")
    public PaginatedList<ConceptSummaryView> concepts(@QueryParam("project") String projectSlug,
                                                      @QueryParam("parent") String parentConceptSlug,
                                                      @QueryParam("prefix") String prefix,
                                                      @QueryParam("limit") Integer limit,
                                                      @QueryParam("offset") Integer offset) {
        ConceptsSelector selector = new ConceptsSelector(constrainInteger(limit, null, 1, 100),
                                                         constrainInteger(offset, 0, 0, null));
        configureConceptsSelector(selector, projectSlug, parentConceptSlug, prefix);
        return repo.fetchConcepts(selector);
    }

    private void configureConceptsSelector(ConceptsSelector selector, String projectSlug, String parentConceptSlug, String prefix) {
        if (stringIsPresent(projectSlug)) {
            ProjectWithMode project = fetchVisibleProjectOrBust(projectSlug);
            selector.setProjectId(project.getId());
        }
        if (stringIsPresent(parentConceptSlug)) {
            UUID parentConceptId = getCoreConceptIdOrBust(parentConceptSlug);
            selector.setParentConceptId(parentConceptId);
        }
        if (stringIsPresent(prefix)) {
            selector.setPrefix(prefix);
        }
    }

    @GET @Path("concept-sets/{uuid: [a-f0-9-]*}")
    public ConceptNestableView conceptSets(@PathParam("uuid") UUID conceptSetId) {
        return repo.fetchConceptSet(conceptSetId);
    }

    @GET @Path("link-types")
    public List<LinkTypeRecord> outgoingLinkTypes(@QueryParam("domain") String domainPrototypeConceptSlug,
                                                  @QueryParam("range") String rangePrototypeConceptSlug,
                                                  @QueryParam("target-type") String targetTypeSlug) {
        UUID domainConceptId = null;
        if (stringIsPresent(domainPrototypeConceptSlug)) {
            domainConceptId = getCoreConceptIdOrBust(domainPrototypeConceptSlug);
        }
        UUID rangeConceptId = null;
        if (stringIsPresent(rangePrototypeConceptSlug)) {
            rangeConceptId = getCoreConceptIdOrBust(rangePrototypeConceptSlug);
        }

        Integer targetTypeId = null;
        if (stringIsPresent(targetTypeSlug)) {
            targetTypeId = getLinkTargetTypeIdOrBust(targetTypeSlug);
        }
        return repo.fetchLinkTypes(domainConceptId, rangeConceptId, targetTypeId);
    }

    /* * */

    private ProjectWithMode fetchVisibleProjectOrBust(String projectSlug) {
        if (projectSlug == null) {
            raise(Response.Status.BAD_REQUEST, "Project must be specified");
        }
        ProjectWithMode project = repo.fetchGloballyVisibleProjectWithMode(projectSlug);
        if (project == null) {
            raise(Response.Status.NOT_FOUND, "Unknown project: '" + projectSlug + "'");
        }
        return project;
    }

    private int getDocumentTypeIdOrBust(String documentTypeName) {
        if (documentTypeName == null) {
            raise(Response.Status.BAD_REQUEST, "Document type must be specified");
        }
        Integer documentTypeId = repo.getSchemaDictionary().getDocumentTypeId(documentTypeName);
        if (documentTypeId == null) {
            raise(Response.Status.NOT_FOUND, "Unknown document type: '" + documentTypeName + "'");
        }
        return documentTypeId;
    }

    private UUID getCoreConceptIdOrBust(String conceptSlug) {
        UUID conceptId = repo.getSchemaDictionary().getCoreConceptId(conceptSlug);
        if (conceptId == null) {
            raise(Response.Status.NOT_FOUND, "Unknown concept: '" + conceptSlug + "'");
        }
        return conceptId;
    }

    private int getLinkTargetTypeIdOrBust(String targetTypeSlug) {
        Integer targetTypeId = repo.getSchemaDictionary().getLinkTargetTypeId(targetTypeSlug);
        if (targetTypeId == null) {
            raise(Response.Status.NOT_FOUND, "Unknown link target type: '" + targetTypeSlug + "'");
        }
        return targetTypeId;
    }

    private void raise(Response.Status status, String message) {
        throw new WebApplicationException(message, status);
    }

}
