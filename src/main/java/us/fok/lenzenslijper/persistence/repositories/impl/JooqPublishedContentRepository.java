package us.fok.lenzenslijper.persistence.repositories.impl;

import org.springframework.transaction.support.TransactionTemplate;
import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;
import us.fok.lenzenslijper.models.dto.ReleasedRevisionSummary;
import us.fok.lenzenslijper.models.pagination.ListPaginator;
import us.fok.lenzenslijper.models.pagination.PaginatedList;
import us.fok.lenzenslijper.persistence.transactions.data.*;
import us.fok.lenzenslijper.persistence.transactions.published.*;
import us.fok.lenzenslijper.persistence.transactions.released.TitlesPageReader;
import us.fok.lenzenslijper.presenters.CollectionMembersPresenter;
import us.fok.lenzenslijper.presenters.DocumentDetailPresenter;
import us.fok.lenzenslijper.presenters.EntityDetailPresenter;
import us.fok.lenzenslijper.presenters.EventParticipationsPresenter;
import us.fok.lenzenslijper.selectors.*;
import us.fok.lenzenslijper.views.DocumentDetailView;
import us.fok.lenzenslijper.views.EntityDetailView;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

public class JooqPublishedContentRepository extends AbstractJooqRepository {

    public JooqPublishedContentRepository(DataSource dataSource, SchemaDictionary dictionary) {
        super(dataSource, dictionary);
    }

    public PaginatedList<ProjectUserDocumentSummary> fetchDocumentSummaries(DocumentsSelector selector) {
        TransactionTemplate tx = buildReadOnlyTransactionTemplate("fetch published document summaries");
        DocumentPageData data = tx.execute(new DocumentsPageReader(this, selector));
        ListPaginator<ProjectUserDocumentSummary> paginator = new ListPaginator<ProjectUserDocumentSummary>(data.getDocuments());
        return selector.isSelectAll() ?
            paginator.paginateAll() :
            paginator.paginate(data.getCount(), selector.getOffset(), selector.getLimit());
    }

    public PaginatedList<String> fetchTitles(ReleasedTitleSelector selector) {
        TransactionTemplate tx = buildReadOnlyTransactionTemplate("fetch published titles");
        ReleasedTitlePageData data = tx.execute(new TitlesPageReader(this, selector));
        ListPaginator<String> paginator = new ListPaginator<String>(data.getTitles());
        return selector.isSelectAll() ?
            paginator.paginateAll() :
            paginator.paginate(data.getCount(), selector.getOffset(), selector.getLimit());
    }

    public DocumentDetailView fetchDocument(UUID linkableId, UUID revisionId) {
        String txDesc = "fetch published document:" + linkableId + "@" + (revisionId == null ? "HEAD" : revisionId);
        TransactionTemplate tx = buildReadOnlyTransactionTemplate(txDesc);
        DocumentDetailData data = tx.execute(new DocumentDetailReader(this, linkableId, revisionId));
        return data == null ? null : new DocumentDetailPresenter(getSchemaDictionary()).makeView(data);
    }

    public PaginatedList<DocumentDetailView> fetchCollectionMembers(UUID linkableId, UUID revisionId, MembersSelector selector) {
        String txDesc = "fetch published members:" + linkableId + "@" + (revisionId == null ? "HEAD" : revisionId);
        TransactionTemplate tx = buildReadOnlyTransactionTemplate(txDesc);
        MemberDocumentsPageData data = tx.execute(new MemberDocumentsPageReader(this, linkableId, revisionId, selector));
        List<DocumentDetailView> views = new CollectionMembersPresenter(getSchemaDictionary()).makeViews(data);
        ListPaginator<DocumentDetailView> paginator = new ListPaginator<DocumentDetailView>(views);
        return selector.isSelectAll() ?
            paginator.paginateAll() :
            paginator.paginate(data.getCount(), selector.getOffset(), selector.getLimit());
    }

    public EntityDetailView fetchEntity(UUID entityId) {
        TransactionTemplate tx = buildReadOnlyTransactionTemplate("fetch published entity:" + entityId);
        EntityDetailData data = tx.execute(new EntityDetailReader(this, entityId));
        return data == null ? null : new EntityDetailPresenter(getSchemaDictionary()).makeView(data);
    }

    public PaginatedList<ReleasedRevisionSummary> fetchReleasedRevisions(ReleasedRevisionSelector selector) {
        TransactionTemplate tx = buildReadOnlyTransactionTemplate("fetch published revisions: " + selector.getDocumentLinkableId());
        RevisionPageData data = tx.execute(new RevisionsPageReader(this, selector));
        ListPaginator<ReleasedRevisionSummary> paginator = new ListPaginator<ReleasedRevisionSummary>(data.getRevisions());
        return selector.isSelectAll() ?
            paginator.paginateAll() :
            paginator.paginate(data.getCount(), selector.getOffset(), selector.getLimit());
    }

}
