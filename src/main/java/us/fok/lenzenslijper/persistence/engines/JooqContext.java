package us.fok.lenzenslijper.persistence.engines;

import org.jooq.DSLContext;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;
import us.fok.lenzenslijper.domain.SchemaDictionary;

public interface JooqContext {

    DSLContext jooq();
    TransactionTemplate buildTransactionTemplate();
    TransactionTemplate buildTransactionTemplate(TransactionDefinition definition);
    SchemaDictionary getSchemaDictionary();

}
