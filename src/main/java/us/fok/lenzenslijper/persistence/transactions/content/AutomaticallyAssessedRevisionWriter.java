package us.fok.lenzenslijper.persistence.transactions.content;

import org.jooq.DSLContext;
import org.springframework.transaction.TransactionStatus;
import us.fok.lenzenslijper.models.dto.RevisionReceipt;
import us.fok.lenzenslijper.models.dto.TransferDocumentRevision;
import us.fok.lenzenslijper.persistence.repositories.impl.JooqContentRepository;

public class AutomaticallyAssessedRevisionWriter extends RevisionWriter {

    public AutomaticallyAssessedRevisionWriter(JooqContentRepository jooqContentRepository, TransferDocumentRevision revision) {
        super(jooqContentRepository, revision);
    }

    @Override
    public RevisionReceipt doInTransaction(TransactionStatus transactionStatus) {
        DSLContext jooq = context.jooq();
        RevisionReceipt receipt = insertRevision(jooq, spec);
        AutomaticAssessmentWriter.insertAutomaticAssessments(jooq, receipt.getRevisionId(), receipt.getUserId());
        return receipt;
    }

}
