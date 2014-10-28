package us.fok.lenzenslijper.persistence.transactions.published;

import org.jooq.*;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import us.fok.lenzenslijper.models.dto.ReleasedRevisionSummary;
import us.fok.lenzenslijper.persistence.engines.JooqContext;
import us.fok.lenzenslijper.persistence.transactions.data.RevisionPageData;
import us.fok.lenzenslijper.selectors.ReleasedRevisionSelector;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import static org.jooq.impl.DSL.count;
import static us.fok.lenzenslijper.models.jooq.Tables.*;

public class RevisionsPageReader implements TransactionCallback<RevisionPageData> {

    private final JooqContext context;
    private final ReleasedRevisionSelector selector;

    public RevisionsPageReader(JooqContext context, ReleasedRevisionSelector selector) {
        this.context = context;
        this.selector = selector;
    }

    @Override
    public RevisionPageData doInTransaction(TransactionStatus transactionStatus) {
        return new RevisionPageData(fetchReleasedRevisions(), countReleasedRevisions());
    }

    private List<ReleasedRevisionSummary> fetchReleasedRevisions() {
        SelectSelectStep<Record5<UUID, String,Timestamp, String, Timestamp>> projection =
            ReleasedRevisionSummary.projection(context.jooq());
        return configureReleasedRevisionSelection(projection).fetchInto(ReleasedRevisionSummary.class);
    }

    public <T extends Record> SelectFinalStep<T> configureReleasedRevisionSelection(SelectSelectStep<T> projection) {
        SelectJoinStep<T> joinedRelation = joinReleasedRevisionsWithRevisionsAndUsers(projection);
        SelectOrderByStep<T> orderableRelation = applySelectorConditions(joinedRelation);
        SelectLimitStep<T> limitableRelation = applySelectorOrder(orderableRelation);
        return applySelectorOffsetAndLimit(limitableRelation);
    }

    private <T extends Record> SelectJoinStep<T> joinReleasedRevisionsWithRevisionsAndUsers(SelectSelectStep<T> projection) {
        return projection.
            from(RELEASED_REVISION_SUMMARIES).
            join(LINKABLES).
                on(LINKABLES.DOCUMENT_ID.eq(RELEASED_REVISION_SUMMARIES.DOCUMENT_ID)).
            join(REVISIONS).
                on(REVISIONS.REVISION_ID.eq(RELEASED_REVISION_SUMMARIES.REVISION_ID)).
            leftOuterJoin(USERS).
                on(USERS.USER_ID.eq(REVISIONS.USER_ID));
    }

    private <T extends Record> SelectOrderByStep<T> applySelectorConditions(SelectJoinStep<T> projection) {
        return projection.where(LINKABLES.LINKABLE_ID.eq(selector.getDocumentLinkableId())).
            and(RELEASED_REVISION_SUMMARIES.RELEASE_TAG_ID.eq(selector.getReleaseTagId()));
    }

    private <T extends Record> SelectLimitStep<T> applySelectorOrder(SelectOrderByStep<T> selection) {
        SelectLimitStep<T> limitStep;
        switch(selector.getSort()) {
            case OLDEST:
                limitStep = selection.orderBy(RELEASED_REVISION_SUMMARIES.CREATED.asc());
                break;
            case LATEST:
            default:
                limitStep = selection.orderBy(RELEASED_REVISION_SUMMARIES.CREATED.asc());
                break;
        }
        return limitStep;
    }

    private <T extends Record> SelectFinalStep<T> applySelectorOffsetAndLimit(SelectLimitStep<T> selection) {
        return selector.isLimited() ?
            selection.limit(defaultZero(selector.getOffset()), selector.getLimit()) :
            selection;
    }

    private int countReleasedRevisions() {
        SelectSelectStep<Record1<Integer>> countProjection = context.jooq().selectCount();
        SelectJoinStep<Record1<Integer>> countRelation = countProjection.
            from(RELEASED_REVISION_SUMMARIES).
            join(LINKABLES).
            on(LINKABLES.DOCUMENT_ID.eq(RELEASED_REVISION_SUMMARIES.DOCUMENT_ID));
        return applySelectorConditions(countRelation).fetchOne(count());
    }

    private int defaultZero(Integer optional) {
        return optional == null ? 0 : optional.intValue();
    }

}
