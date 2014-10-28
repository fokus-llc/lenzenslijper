package us.fok.lenzenslijper.persistence.transactions.data;

import us.fok.lenzenslijper.models.immutable.ProjectWithMode;

import java.util.List;

public class ProjectPageData {

    private final List<ProjectWithMode> projects;
    private final Integer count;

    public ProjectPageData(List<ProjectWithMode> projects, Integer count) {
        this.projects = projects;
        this.count = count;
    }

    public List<ProjectWithMode> getProjects() {
        return projects;
    }

    public Integer getCount() {
        return count;
    }

}
