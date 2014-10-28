package us.fok.lenzenslijper.persistence.repositories.impl;

import org.springframework.transaction.support.TransactionTemplate;
import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.models.pagination.ListPaginator;
import us.fok.lenzenslijper.models.pagination.PaginatedList;
import us.fok.lenzenslijper.persistence.transactions.data.UserPageData;
import us.fok.lenzenslijper.persistence.transactions.UserPageReader;
import us.fok.lenzenslijper.selectors.UsersSelector;
import us.fok.lenzenslijper.views.UserView;

import javax.sql.DataSource;
import java.util.UUID;

import static us.fok.lenzenslijper.models.jooq.Tables.*;

public class JooqUsersRepository extends AbstractJooqRepository {

    public JooqUsersRepository(DataSource dataSource, SchemaDictionary dictionary) {
        super(dataSource, dictionary);
    }

    public PaginatedList<UserView> fetchUsers(UsersSelector selector) {
        TransactionTemplate tx = buildReadOnlyTransactionTemplate("fetch users");
        UserPageData data = tx.execute(new UserPageReader(this, selector));
        ListPaginator<UserView> paginator = new ListPaginator<UserView>(data.getUsers());
        return selector.isSelectAll() ?
            paginator.paginateAll() :
            paginator.paginate(data.getCount(), selector.getOffset(), selector.getLimit());
    }

    public UUID fetchUserId(String username) {
        return jooq().
            select(USERS.USER_ID).
            from(USERS).
            where(USERS.USERNAME.eq(username)).
            fetchOne(USERS.USER_ID);
    }

}
