package us.fok.lenzenslijper.persistence.transactions.data;

import us.fok.lenzenslijper.views.UserView;

import java.util.List;

public class UserPageData {

    private final List<UserView> users;
    private final Integer count;

    public UserPageData(List<UserView> users, Integer count) {
        this.users = users;
        this.count = count;
    }

    public List<UserView> getUsers() {
        return users;
    }

    public Integer getCount() {
        return count;
    }

}
