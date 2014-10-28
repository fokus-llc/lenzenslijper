package us.fok.lenzenslijper.selectors;

import java.util.UUID;

public class ProjectsSelector extends PaginatedSelector {

    public static enum Sort { NAME, RECENT_ACTIVITY }

    private Sort sortOrder = Sort.NAME;
    private final UUID permissionsUserId;

    public ProjectsSelector(Integer limit, Integer offset) {
        this.setLimit(limit);
        this.setOffset(offset);
        this.permissionsUserId = null;
    }

    public ProjectsSelector(Integer limit, Integer offset, UUID permissionsUserId) {
        this.setLimit(limit);
        this.setOffset(offset);
        this.permissionsUserId = permissionsUserId;
    }

    public UUID getPermissionsUserId() {
        return permissionsUserId;
    }

    public boolean isUserPermissioned() {
        return this.permissionsUserId != null;
    }

    public Sort getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Sort sortOrder) {
        this.sortOrder = sortOrder;
    }

}
