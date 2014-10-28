package us.fok.lenzenslijper.persistence.repositories;

import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.models.dto.*;
import us.fok.lenzenslijper.models.immutable.*;
import us.fok.lenzenslijper.models.pagination.PaginatedList;
import us.fok.lenzenslijper.views.*;
import us.fok.lenzenslijper.views.ConceptNestableView;
import us.fok.lenzenslijper.selectors.*;
import us.fok.lenzenslijper.views.geojson.FeatureCollection;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface ConsolidatedRepository {

    // domain

    SchemaDictionary getSchemaDictionary();

    // projects

    PaginatedList<ProjectWithMode> fetchVisibleProjectsWithMode(ProjectsSelector selector);
    PaginatedList<ProjectWithMode> fetchWritableProjectsWithMode(ProjectsSelector selector);
    ProjectWithMode fetchGloballyVisibleProjectWithMode(String branchSlug);

    // users

    PaginatedList<UserView> fetchUsers(UsersSelector selector);
    UUID fetchUserId(String username);

    // published documents

    PaginatedList<ProjectUserDocumentSummary> fetchPublishedDocumentSummaries(DocumentsSelector selector);

    DocumentDetailView fetchPublishedDocument(UUID linkableId, UUID revisionId);
    PaginatedList<DocumentDetailView> fetchPublishedMembers(UUID linkableId, UUID revisionId, MembersSelector selector);

    PaginatedList<ReleasedRevisionSummary> fetchReleasedRevisions(ReleasedRevisionSelector selector);

    // released titles

    PaginatedList<String> fetchReleasedTitles(ReleasedTitleSelector selector);

    // published entities

    EntityDetailView fetchPublishedEntity(UUID entityId);

    // concepts

    PaginatedList<ConceptSummaryView> fetchConcepts(ConceptsSelector pagination);
    ConceptNestableView fetchConceptSet(UUID conceptSetId);

    UUID fetchPublicConceptLinkableId(String slug);

    // GIS

    FeatureCollection fetchPublishedGeography(UUID linkableId, UUID revisionId);

    // ontology

    List<LinkTypeRecord> fetchLinkTypes(UUID conceptId, UUID rangeConceptId, Integer targetTypeId);

    // editing

    RevisionReceipt insertDocumentRevision(TransferDocumentRevision revision);
    Timestamp insertRevisionAssessment(UUID revisionId, TransferAssessment assessment);

}
