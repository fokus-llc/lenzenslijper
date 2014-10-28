package us.fok.lenzenslijper.selectors;

import java.util.UUID;

public class ConceptsSelector extends PaginatedSelector {

    private UUID projectId;
    private UUID parentConceptId;
    private String prefix;

    public ConceptsSelector(Integer limit, Integer offset) {
        this.setLimit(limit);
        this.setOffset(offset);
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public void setParentConceptId(UUID parentConceptId) {
        this.parentConceptId = parentConceptId;
    }

    public UUID getParentConceptId() {
        return parentConceptId;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

}
