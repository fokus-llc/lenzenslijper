package us.fok.lenzenslijper.selectors;

import java.util.UUID;

public class ContentSelector extends PaginatedSelector {

    public static enum Sort {
        NAME, RECENT;
    }

    private UUID projectId;
    private UUID prototypeConceptId;
    private Sort sort;

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public UUID getPrototypeConceptId() {
        return prototypeConceptId;
    }

    public void setPrototypeConceptId(UUID conceptId) {
        this.prototypeConceptId = conceptId;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

}
