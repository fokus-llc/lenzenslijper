package us.fok.lenzenslijper.persistence.transactions.released;

import org.jooq.*;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import us.fok.lenzenslijper.persistence.engines.JooqContext;
import us.fok.lenzenslijper.persistence.transactions.data.ReleasedTitlePageData;
import us.fok.lenzenslijper.selectors.ReleasedTitleSelector;

import java.util.List;

import static org.jooq.impl.DSL.count;
import static us.fok.lenzenslijper.models.jooq.Tables.RELEASED_TITLE_SUMMARIES;

public class TitlesPageReader implements TransactionCallback<ReleasedTitlePageData> {

    private final JooqContext context;
    private final ReleasedTitleSelector selector;

    public TitlesPageReader(JooqContext context, ReleasedTitleSelector selector) {
        this.context = context;
        this.selector = selector;
    }

    @Override
    public ReleasedTitlePageData doInTransaction(TransactionStatus transactionStatus) {
        return new ReleasedTitlePageData(fetchTitles(), countTitles());
    }

    private List<String> fetchTitles() {
        SelectSelectStep<Record1<String>> projection = context.jooq().selectDistinct(RELEASED_TITLE_SUMMARIES.TITLE);
        return configureRelation(projection).fetch(RELEASED_TITLE_SUMMARIES.TITLE);
    }

    private <T extends Record> SelectFinalStep<T> configureRelation(SelectSelectStep<T> projection) {
        SelectWhereStep<T> relation = projection.from(RELEASED_TITLE_SUMMARIES);
        SelectConditionStep<T> orderableRelation = applyConditions(relation);
        SelectLimitStep<T> limitableRelation = orderableRelation.orderBy(RELEASED_TITLE_SUMMARIES.TITLE);
        return selector.isLimited() ?
            limitableRelation.limit(selector.getOffset(), selector.getLimit()) :
            limitableRelation;
    }

    private <T extends Record> SelectConditionStep<T> applyConditions(SelectWhereStep<T> relation) {
        SelectConditionStep<T> releasedRelation = relation.
            where(RELEASED_TITLE_SUMMARIES.RELEASE_TAG_ID.eq(selector.getReleaseTagId()));
        String prefix = selector.getPrefix();
        return (prefix == null || prefix.equals("")) ?
            releasedRelation :
            releasedRelation.and(RELEASED_TITLE_SUMMARIES.TITLE.likeIgnoreCase(sqlLikePrefix(selector.getPrefix())));
    }

    private String sqlLikePrefix(String prefix) {
        return prefix + "%";
    }

    private int countTitles() {
        SelectSelectStep<Record1<Integer>> projection = context.jooq().selectCount();
        SelectWhereStep<Record1<Integer>> relation = projection.from(RELEASED_TITLE_SUMMARIES);
        SelectFinalStep<Record1<Integer>> fetchableRelation = applyConditions(relation);
        return fetchableRelation.fetchOne(count());
    }

}
