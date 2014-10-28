package us.fok.lenzenslijper.persistence.transactions.content;

import org.jooq.DSLContext;
import us.fok.lenzenslijper.domain.SystemSchemaConstants;

import java.util.UUID;

public class AutomaticAssessmentWriter {

    public static void insertAutomaticAssessments(DSLContext jooq, UUID revisionId, UUID userId) {
        insertAutomaticSubmissionAssessment(jooq, revisionId, userId);
        insertAutomaticPublicationAssessment(jooq, revisionId, userId);
    }

    private static void insertAutomaticSubmissionAssessment(DSLContext jooq, UUID revisionId, UUID userId) {
        AssessmentWriter.insertAssessment(jooq,
            revisionId,
            SystemSchemaConstants.ASSESSMENT_TYPE_ID_SUBMIT,
            userId,
            "Automatically submitted");
    }

    private static void insertAutomaticPublicationAssessment(DSLContext jooq, UUID revisionId, UUID userId) {
        AssessmentWriter.insertAssessment(jooq,
            revisionId,
            SystemSchemaConstants.ASSESSMENT_TYPE_ID_PUBLISH,
            userId,
            "Automatically published");
    }

}
