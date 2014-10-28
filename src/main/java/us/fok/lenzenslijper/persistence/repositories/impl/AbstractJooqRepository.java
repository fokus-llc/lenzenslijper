package us.fok.lenzenslijper.persistence.repositories.impl;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;
import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.persistence.engines.JooqContext;

import javax.sql.DataSource;

public class AbstractJooqRepository extends JdbcDaoSupport implements JooqContext {

    private final SchemaDictionary dictionary;

    public AbstractJooqRepository(DataSource dataSource, SchemaDictionary dictionary) {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(dataSource);
        setDataSource(proxy);
        this.dictionary = dictionary;
    }

    public DSLContext jooq() {
        return DSL.using(getDataSource(), SQLDialect.POSTGRES);
    }

    public SchemaDictionary getSchemaDictionary() {
        return dictionary;
    }

    public TransactionTemplate buildTransactionTemplate() {
        return new TransactionTemplate(new DataSourceTransactionManager(getDataSource()));
    }

    public TransactionTemplate buildTransactionTemplate(String name) {
        TransactionDefinition definition = buildTransactionDefinition(name);
        return new TransactionTemplate(new DataSourceTransactionManager(getDataSource()), definition);
    }

    private DefaultTransactionDefinition buildTransactionDefinition(String name) {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setName(name);
        return definition;
    }

    public TransactionTemplate buildTransactionTemplate(TransactionDefinition definition) {
        return new TransactionTemplate(new DataSourceTransactionManager(getDataSource()), definition);
    }

    public TransactionTemplate buildReadOnlyTransactionTemplate(String name) {
        return buildTransactionTemplate(buildReadOnlyTransactionDefinition(name));
    }

    protected TransactionDefinition buildReadOnlyTransactionDefinition(String name) {
        DefaultTransactionDefinition definition = buildTransactionDefinition(name);
        definition.setReadOnly(true);
        return definition;
    }

}
