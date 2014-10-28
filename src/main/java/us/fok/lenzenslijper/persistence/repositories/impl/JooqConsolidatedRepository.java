package us.fok.lenzenslijper.persistence.repositories.impl;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.models.dto.*;
import us.fok.lenzenslijper.models.immutable.ProjectWithMode;
import us.fok.lenzenslijper.models.pagination.PaginatedList;
import us.fok.lenzenslijper.views.*;
import us.fok.lenzenslijper.views.ConceptNestableView;
import us.fok.lenzenslijper.selectors.*;
import us.fok.lenzenslijper.persistence.repositories.ConsolidatedRepository;
import us.fok.lenzenslijper.views.geojson.FeatureCollection;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.*;

@org.springframework.stereotype.Repository
public class JooqConsolidatedRepository implements ConsolidatedRepository {

    private final SchemaDictionary dictionary;
    private final JooqProjectsRepository projects;
    private final JooqUsersRepository users;
    private final JooqConceptsRepository concepts;
    private final JooqContentRepository content;
    private final JooqPublishedContentRepository publications;
    private final JooqGeographyRepository geography;
    private final JooqOntologyRepository ontology;

    public JooqConsolidatedRepository(DataSource dataSource) {
        this.dictionary   = new SchemaDictionary(makeDslContext(dataSource));
        this.projects     = new JooqProjectsRepository(dataSource, dictionary);
        this.users        = new JooqUsersRepository(dataSource, dictionary);
        this.concepts     = new JooqConceptsRepository(dataSource, dictionary);
        this.content      = new JooqContentRepository(dataSource, dictionary);
        this.publications = new JooqPublishedContentRepository(dataSource, dictionary);
        this.geography    = new JooqGeographyRepository(dataSource, dictionary);
        this.ontology     = new JooqOntologyRepository(dataSource, dictionary);
    }

    // domain

    @Override
    public SchemaDictionary getSchemaDictionary() {
        return dictionary;
    }

    // projects

    @Override
    public PaginatedList<ProjectWithMode> fetchVisibleProjectsWithMode(ProjectsSelector selector) {
        return projects.fetchVisibleProjectsPaginated(selector);
    }

    @Override
    public PaginatedList<ProjectWithMode> fetchWritableProjectsWithMode(ProjectsSelector selector) {
        return projects.fetchWritableProjectsPaginated(selector);
    }

    @Override
    public ProjectWithMode fetchGloballyVisibleProjectWithMode(String branchSlug) {
        return projects.fetchVisibleProjectWithMode(branchSlug);
    }

    // users

    @Override
    public PaginatedList<UserView> fetchUsers(UsersSelector selector) {
        return users.fetchUsers(selector);
    }

    @Override
    public UUID fetchUserId(String username) {
        return users.fetchUserId(username);
    }

    // published documents

    @Override
    public PaginatedList<ProjectUserDocumentSummary> fetchPublishedDocumentSummaries(DocumentsSelector selector) {
        return publications.fetchDocumentSummaries(selector);
    }

    @Override
    public DocumentDetailView fetchPublishedDocument(UUID linkableId, UUID revisionId) {
        return publications.fetchDocument(linkableId, revisionId);
    }

    @Override
    public PaginatedList<DocumentDetailView> fetchPublishedMembers(UUID linkableId, UUID revisionId, MembersSelector selector) {
        return publications.fetchCollectionMembers(linkableId, revisionId, selector);
    }


    @Override
    public PaginatedList<ReleasedRevisionSummary> fetchReleasedRevisions(ReleasedRevisionSelector selector) {
        return publications.fetchReleasedRevisions(selector);
    }

    // released titles

    @Override
    public PaginatedList<String> fetchReleasedTitles(ReleasedTitleSelector selector) {
        return publications.fetchTitles(selector);
    }

    // published entities

    @Override
    public EntityDetailView fetchPublishedEntity(UUID entityId) {
        return publications.fetchEntity(entityId);
    }

    // concepts

    @Override
    public PaginatedList<ConceptSummaryView> fetchConcepts(ConceptsSelector selector) {
        return concepts.fetchConcepts(selector);
    }

    @Override
    public ConceptNestableView fetchConceptSet(UUID conceptSetId) {
        return concepts.fetchConceptSet(conceptSetId);
    }

    @Override
    public UUID fetchPublicConceptLinkableId(String slug) {
        return concepts.fetchPublicConceptLinkableId(slug);
    }

    // GIS

    @Override
    public FeatureCollection fetchPublishedGeography(UUID linkableId, UUID revisionId) {
        return geography.fetchGeographicalFeaturesContext(linkableId, revisionId);
    }

    // ontolohy

    @Override
    public List<LinkTypeRecord> fetchLinkTypes(UUID domainConceptId, UUID rangeConceptId, Integer targetTypeId) {
        return ontology.fetchLinkTypes(domainConceptId, rangeConceptId, targetTypeId);
    }

    // editing

    @Override
    public RevisionReceipt insertDocumentRevision(TransferDocumentRevision revision) {
        if (revision.getParentRevisionId() == null) {
            return content.insertAssessedDocument(revision);
            //return content.insertDocument(revision);
        }
        else {
            return content.insertAssessedRevision(revision);
            //return content.insertRevision(revision);
        }
    }

    @Override
    public Timestamp insertRevisionAssessment(UUID revisionId, TransferAssessment assessment) {
        return content.insertAsssessment(revisionId, assessment);
    }

    ////

    private DSLContext makeDslContext(DataSource dataSource) {
        return DSL.using(dataSource, SQLDialect.POSTGRES);
    }

}
