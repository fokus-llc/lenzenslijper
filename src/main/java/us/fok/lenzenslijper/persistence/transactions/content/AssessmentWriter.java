package us.fok.lenzenslijper.persistence.transactions.content;

import org.jooq.DSLContext;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import us.fok.lenzenslijper.domain.Privilege;
import us.fok.lenzenslijper.errors.ServiceInputError;
import us.fok.lenzenslijper.models.dto.TransferAssessment;
import us.fok.lenzenslijper.persistence.engines.JooqContext;
import us.fok.lenzenslijper.persistence.repositories.impl.JooqContentRepository;

import java.sql.Timestamp;
import java.util.UUID;

import static us.fok.lenzenslijper.models.jooq.Tables.*;
import static us.fok.lenzenslijper.util.StringUtilities.stringIsPresent;

public class AssessmentWriter implements TransactionCallback<Timestamp> {

    private final JooqContext context;
    private final UUID revisionId;
    private final TransferAssessment spec;

    public AssessmentWriter(JooqContentRepository context, UUID revisionId, TransferAssessment assessment) {
        this.context = context;
        this.revisionId = revisionId;
        this.spec = assessment;
    }

    @Override
    public Timestamp doInTransaction(TransactionStatus transactionStatus) {
        return insertAssessment(context.jooq(), revisionId, spec);
    }

    private Timestamp insertAssessment(DSLContext jooq, UUID revisionId, TransferAssessment spec) {
        UUID projectId = fetchProjectForRevision(jooq, revisionId);
        UUID userId = fetchUserWithProjectWritePermissionsGuaranteed(jooq, spec.getUser(), projectId);
        int assessmentTypeId = lookupAssessmentTypeGuaranteed(spec.getAssessmentType());
        return insertAssessment(jooq, revisionId, assessmentTypeId, userId, spec.getComments());
    }

    private UUID fetchProjectForRevision(DSLContext jooq, UUID revisionId) {
        return jooq.
            select(DOCUMENTS.PROJECT_ID).
            from(DOCUMENTS).
            join(REVISIONS).
                on(REVISIONS.DOCUMENT_ID.eq(DOCUMENTS.DOCUMENT_ID)).
            where(REVISIONS.REVISION_ID.eq(revisionId)).
            fetchOne(DOCUMENTS.PROJECT_ID);
    }

    protected UUID fetchUserWithProjectWritePermissionsGuaranteed(DSLContext jooq, String user, UUID projectId) {
        if (! stringIsPresent(user)) {
            throw new ServiceInputError("No user specified");
        }
        UUID userId = jooq.
            selectDistinct(USERS.USER_ID).
            from(USERS).
            join(VIRTUAL_AGGREGATE_GRANTS).
            on(VIRTUAL_AGGREGATE_GRANTS.USER_ID.eq(USERS.USER_ID)).
            where(VIRTUAL_AGGREGATE_GRANTS.PROJECT_ID.eq(projectId)).
            and(VIRTUAL_AGGREGATE_GRANTS.MODE.bitAnd(Privilege.SUBMIT.getValue()).ne(0)).
            and(USERS.USERNAME.eq(user)).
            fetchOne(USERS.USER_ID);
        if (userId == null) {
            throw new ServiceInputError("User '" + user + "' may not write to the project");
        }
        return userId;
    }

    private int lookupAssessmentTypeGuaranteed(String assessmentType) {
        Integer assetTypeId = context.getSchemaDictionary().getAssessmentTypeId(assessmentType);
        if (assetTypeId == null) {
            throw new ServiceInputError("Assessment type unknown: '" + assessmentType + "'");
        }
        return assetTypeId;
    }

    public static Timestamp insertAssessment(DSLContext jooq, UUID revisionId, int assessmentTypeId, UUID userId, String comments) {
        return jooq.
            insertInto(REVISION_ASSESSMENTS,
                       REVISION_ASSESSMENTS.REVISION_ID,
                       REVISION_ASSESSMENTS.ASSESSMENT_TYPE_ID,
                       REVISION_ASSESSMENTS.USER_ID,
                       REVISION_ASSESSMENTS.COMMENTS).
            values(revisionId,
                   assessmentTypeId,
                   userId,
                   comments).
            returning(REVISION_ASSESSMENTS.CREATED).
            fetchOne().
            getValue(REVISION_ASSESSMENTS.CREATED);
    }

}
