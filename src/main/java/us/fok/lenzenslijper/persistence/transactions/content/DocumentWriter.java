package us.fok.lenzenslijper.persistence.transactions.content;

import org.jooq.DSLContext;
import org.springframework.transaction.TransactionStatus;
import us.fok.lenzenslijper.errors.ServiceInputError;
import us.fok.lenzenslijper.models.dto.RevisionReceipt;
import us.fok.lenzenslijper.models.dto.TransferDocumentRevision;
import us.fok.lenzenslijper.persistence.repositories.impl.JooqContentRepository;

import java.util.UUID;

import static us.fok.lenzenslijper.models.jooq.Tables.*;
import static us.fok.lenzenslijper.util.StringUtilities.stringIsPresent;

public class DocumentWriter extends RevisionWriter {

    public DocumentWriter(JooqContentRepository jooqContentRepository, TransferDocumentRevision revision) {
        super(jooqContentRepository, revision);
    }

    @Override
    public RevisionReceipt doInTransaction(TransactionStatus transactionStatus) {
        return insertDocument(context.jooq(), spec);
    }

    protected RevisionReceipt insertDocument(DSLContext jooq, TransferDocumentRevision spec) {
        UUID projectId = fetchProjectGuaranteed(jooq, spec);
        UUID userId = fetchUserWithProjectWritePermissionsGuaranteed(jooq, spec.getUser(), projectId);

        int documentTypeId = lookupDocumentTypeGuaranteed(spec.getDocumentType());
        UUID documentId = insertDocumentRow(jooq, documentTypeId, projectId);

        return createLinkedDocumentRevision(jooq, spec, null, documentId, projectId, userId);
    }

    private UUID fetchProjectGuaranteed(DSLContext jooq, TransferDocumentRevision spec) {
        String projectName = spec.getProject();
        if (! stringIsPresent(projectName)) {
            throw new ServiceInputError("No project specified");
        }
        UUID projectId = jooq.
            select(PROJECTS.PROJECT_ID).
            from(PROJECTS).
            where(PROJECTS.SLUG.eq(projectName)).
            fetchOne(PROJECTS.PROJECT_ID);
        if (projectId == null) {
            throw new ServiceInputError("Invalid project specified: '" + projectName + "'");
        }
        return projectId;
    }

    private int lookupDocumentTypeGuaranteed(String documentType) {
        if (! stringIsPresent(documentType)) {
            throw new ServiceInputError("No document type specified");
        }
        Integer documentTypeId = context.getSchemaDictionary().getDocumentTypeId(documentType);
        if (documentTypeId == null) {
            throw new ServiceInputError("Invalid document type specified: '" + documentType + "'");
        }
        return documentTypeId;
    }

    private UUID insertDocumentRow(DSLContext jooq, int documentTypeId, UUID projectId) {
        return jooq.
            insertInto(DOCUMENTS,
                DOCUMENTS.DOCUMENT_TYPE_ID,
                DOCUMENTS.PROJECT_ID).
            values(documentTypeId, projectId).
            returning(DOCUMENTS.DOCUMENT_ID).
            fetchOne().
            getValue(DOCUMENTS.DOCUMENT_ID);
    }

}
