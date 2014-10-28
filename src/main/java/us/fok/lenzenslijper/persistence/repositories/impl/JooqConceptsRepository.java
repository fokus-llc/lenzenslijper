package us.fok.lenzenslijper.persistence.repositories.impl;

import org.springframework.transaction.support.TransactionTemplate;
import us.fok.lenzenslijper.domain.Privilege;
import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.models.pagination.ListPaginator;
import us.fok.lenzenslijper.models.pagination.PaginatedList;
import us.fok.lenzenslijper.persistence.transactions.*;
import us.fok.lenzenslijper.persistence.transactions.data.ConceptsPageData;
import us.fok.lenzenslijper.selectors.ConceptsSelector;
import us.fok.lenzenslijper.selectors.PaginatedSelector;
import us.fok.lenzenslijper.views.ConceptNestableView;
import us.fok.lenzenslijper.views.ConceptSummaryView;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

import static org.jooq.impl.DSL.bitOr;
import static us.fok.lenzenslijper.models.jooq.Tables.*;

public class JooqConceptsRepository extends AbstractJooqRepository {

    public JooqConceptsRepository(DataSource dataSource, SchemaDictionary dictionary) {
        super(dataSource, dictionary);
    }

    public PaginatedList<ConceptSummaryView> fetchConcepts(ConceptsSelector selector) {
        TransactionTemplate tx = buildReadOnlyTransactionTemplate("fetch concepts");
        ConceptsPageData data = tx.execute(new ConceptsPageReader(this, selector));
        return paginateConcepts(data.getConcepts(), selector, data.getCount());
    }

    private PaginatedList<ConceptSummaryView> paginateConcepts(List<ConceptSummaryView> concepts, PaginatedSelector selector, int count) {
        ListPaginator<ConceptSummaryView> paginator = new ListPaginator<ConceptSummaryView>(concepts);
        return selector.isSelectAll() ?
            paginator.paginateAll() :
            paginator.paginate(count, selector.getOffset(), selector.getLimit());

    }

    public ConceptNestableView fetchConceptSet(UUID conceptSetId) {
        TransactionTemplate tx = buildReadOnlyTransactionTemplate("fetch concept set");
        return tx.execute(new ConceptSetReader(this, conceptSetId));
    }

    public UUID fetchPublicConceptLinkableId(String slug) {
        return jooq().
            select(LINKABLES.LINKABLE_ID).
            from(LINKABLES).
            join(CONCEPTS).
                on(CONCEPTS.CONCEPT_ID.eq(LINKABLES.CONCEPT_ID)).
            join(PROJECTS).
                on(PROJECTS.PROJECT_ID.eq(CONCEPTS.PROJECT_ID)).
            where(CONCEPTS.SLUG.eq(slug)).
                and(bitOr(PROJECTS.DEFAULT_MODE, Privilege.DIRECTORY.getValue()).ne(0)).
            fetchOne(LINKABLES.LINKABLE_ID);
    }

}
