package us.fok.lenzenslijper.persistence.transactions;

import org.jooq.*;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import us.fok.lenzenslijper.persistence.engines.JooqContext;
import us.fok.lenzenslijper.persistence.transactions.data.UserPageData;
import us.fok.lenzenslijper.selectors.UsersSelector;
import us.fok.lenzenslijper.views.UserView;

import java.util.List;

import static org.jooq.impl.DSL.count;
import static us.fok.lenzenslijper.models.jooq.Tables.USERS;

public class UserPageReader implements TransactionCallback<UserPageData> {

    private final JooqContext context;
    private final UsersSelector selector;

    public UserPageReader(JooqContext context, UsersSelector selector) {
        this.context = context;
        this.selector = selector;
    }

    @Override
    public UserPageData doInTransaction(TransactionStatus transactionStatus) {
        List<UserView> users = fetchUsers();
        Integer userCount = selector.isSelectAll() ? users.size() : countUsers();
        return new UserPageData(users, userCount);
    }

    private List<UserView> fetchUsers() {
        SelectOrderByStep<? extends Record> orderableSelection = selectUserViewProjectionFromUsers();
        SelectLimitStep<? extends Record> limitableSelection = applyOrder(orderableSelection);
        SelectFinalStep<? extends Record> fetchableSelection = limitSelection(limitableSelection);
        return fetchableSelection.fetchInto(UserView.class);
    }

    private SelectOrderByStep<? extends Record> selectUserViewProjectionFromUsers() {
        return context.jooq().
            select(USERS.USERNAME, USERS.NAME).
            from(USERS); // LAST SIGN IN AT ???
    }

    private <T extends Record> SelectLimitStep<T> applyOrder(SelectOrderByStep<T> joinStep) {
       return joinStep.orderBy(USERS.USERNAME);
    }

    private <T extends Record> SelectFinalStep<T> limitSelection(SelectLimitStep<T> selection) {
        return selector.isLimited() ?
            offsetSelection(selection.limit(selector.getLimit())) :
            selection;
    }

    private <T extends Record> SelectFinalStep<T> offsetSelection(SelectOffsetStep<T> selection) {
        return selector.hasNonZeroOffset() ?
            selection.offset(selector.getOffset()) :
            selection;
    }

    private int countUsers() {
        return context.jooq().
            selectCount().
            from(USERS).
            fetchOne(count());
    }

}
