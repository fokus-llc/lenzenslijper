package us.fok.lenzenslijper.persistence.repositories.impl;

import org.springframework.transaction.support.TransactionTemplate;
import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.models.dto.RevisionReceipt;
import us.fok.lenzenslijper.models.dto.TransferAssessment;
import us.fok.lenzenslijper.models.dto.TransferDocumentRevision;
import us.fok.lenzenslijper.persistence.transactions.content.*;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.UUID;

public class JooqContentRepository extends AbstractJooqRepository {

    public JooqContentRepository(DataSource dataSource, SchemaDictionary dictionary) {
        super(dataSource, dictionary);
    }

    public RevisionReceipt insertDocument(TransferDocumentRevision revision) {
        String txDesc = "insert document:" + revision.getDocumentType();
        TransactionTemplate tx = buildTransactionTemplate(txDesc);
        return tx.execute(new DocumentWriter(this, revision));
    }

    public RevisionReceipt insertAssessedDocument(TransferDocumentRevision revision) {
        String txDesc = "insert assessed document:" + revision.getDocumentType();
        TransactionTemplate tx = buildTransactionTemplate(txDesc);
        return tx.execute(new AutomaticallyAssessedDocumentWriter(this, revision));
    }

    public RevisionReceipt insertRevision(TransferDocumentRevision revision) {
        String txDesc = "insert child revision: " + revision.getParentRevisionId();
        TransactionTemplate tx = buildTransactionTemplate(txDesc);
        return tx.execute(new RevisionWriter(this, revision));
    }

    public RevisionReceipt insertAssessedRevision(TransferDocumentRevision revision) {
        String txDesc = "insert assessed child revision: " + revision.getParentRevisionId();
        TransactionTemplate tx = buildTransactionTemplate(txDesc);
        return tx.execute(new AutomaticallyAssessedRevisionWriter(this, revision));
    }

    public Timestamp insertAsssessment(UUID revisionId, TransferAssessment assessment) {
        String txDesc = "insert assessment: " + revisionId;
        TransactionTemplate tx = buildTransactionTemplate(txDesc);
        return tx.execute(new AssessmentWriter(this, revisionId, assessment));
    }
}
