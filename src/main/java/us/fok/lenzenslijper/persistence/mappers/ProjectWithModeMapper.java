package us.fok.lenzenslijper.persistence.mappers;

import org.jooq.Record;
import org.jooq.RecordMapper;
import us.fok.lenzenslijper.models.dto.MutableProjectWithMode;
import us.fok.lenzenslijper.models.immutable.ProjectWithMode;

import static us.fok.lenzenslijper.models.jooq.Tables.PROJECTS;

public class ProjectWithModeMapper implements RecordMapper<Record, ProjectWithMode> {

    @Override
    public ProjectWithMode map(Record rec) {
        MutableProjectWithMode project = new MutableProjectWithMode();

        project.setId(rec.getValue(PROJECTS.PROJECT_ID));
        project.setName(rec.getValue(PROJECTS.NAME));
        project.setSlug(rec.getValue(PROJECTS.SLUG));

        project.setMode((Integer) rec.getValue("mode"));
        project.setCreator((String) rec.getValue("creator"));

        return project;
    }

}