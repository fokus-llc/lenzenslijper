package us.fok.lenzenslijper.persistence.repositories.impl;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.models.immutable.ProjectWithMode;
import us.fok.lenzenslijper.models.pagination.PaginatedList;
import us.fok.lenzenslijper.selectors.ProjectsSelector;

import javax.sql.DataSource;

public class JooqProjectsRepositoryTest {

    private static DataSource source;
    private static SchemaDictionary schema;
    private static JooqProjectsRepository repo;

    @BeforeClass
    public static void setupClass() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/test-beans.xml");
        source = (DataSource) context.getBean("dataSource");
        schema = new SchemaDictionary(DSL.using(source, SQLDialect.POSTGRES));
        repo = new JooqProjectsRepository(source, schema);
    }

    @Test
    public void fetchVisibleProjectsPaginateTest() {
        /*
        ProjectsSelector selector = new ProjectsSelector(10, 0);
        PaginatedList<ProjectWithMode> projects = repo.fetchVisibleProjectsPaginated(selector);
        for(ProjectWithMode project : projects.getItems()) {
            System.out.println(project.getSlug());
        }
        */
    }

    @Test
    public void fetchVisibleProjectWithModeTest() {
        String projectSlug = "hc";
        ProjectWithMode project = repo.fetchVisibleProjectWithMode(projectSlug);
        System.out.println(project.getId());
    }

}
