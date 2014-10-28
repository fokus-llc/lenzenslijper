/**
 * This class is generated by jOOQ
 */
package us.fok.lenzenslijper.models.jooq.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RevisionAssessmentsRecord extends org.jooq.impl.TableRecordImpl<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssessmentsRecord> implements org.jooq.Record7<java.util.UUID, java.lang.Integer, java.util.UUID, java.sql.Timestamp, java.lang.String, java.sql.Timestamp, java.sql.Timestamp> {

	private static final long serialVersionUID = -1647583249;

	/**
	 * Setter for <code>public.revision_assessments.revision_id</code>.
	 */
	public void setRevisionId(java.util.UUID value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.revision_assessments.revision_id</code>.
	 */
	public java.util.UUID getRevisionId() {
		return (java.util.UUID) getValue(0);
	}

	/**
	 * Setter for <code>public.revision_assessments.assessment_type_id</code>.
	 */
	public void setAssessmentTypeId(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.revision_assessments.assessment_type_id</code>.
	 */
	public java.lang.Integer getAssessmentTypeId() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>public.revision_assessments.user_id</code>.
	 */
	public void setUserId(java.util.UUID value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.revision_assessments.user_id</code>.
	 */
	public java.util.UUID getUserId() {
		return (java.util.UUID) getValue(2);
	}

	/**
	 * Setter for <code>public.revision_assessments.created</code>.
	 */
	public void setCreated(java.sql.Timestamp value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.revision_assessments.created</code>.
	 */
	public java.sql.Timestamp getCreated() {
		return (java.sql.Timestamp) getValue(3);
	}

	/**
	 * Setter for <code>public.revision_assessments.comments</code>.
	 */
	public void setComments(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.revision_assessments.comments</code>.
	 */
	public java.lang.String getComments() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>public.revision_assessments.row_created</code>.
	 */
	public void setRowCreated(java.sql.Timestamp value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.revision_assessments.row_created</code>.
	 */
	public java.sql.Timestamp getRowCreated() {
		return (java.sql.Timestamp) getValue(5);
	}

	/**
	 * Setter for <code>public.revision_assessments.row_updated</code>.
	 */
	public void setRowUpdated(java.sql.Timestamp value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.revision_assessments.row_updated</code>.
	 */
	public java.sql.Timestamp getRowUpdated() {
		return (java.sql.Timestamp) getValue(6);
	}

	// -------------------------------------------------------------------------
	// Record7 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.util.UUID, java.lang.Integer, java.util.UUID, java.sql.Timestamp, java.lang.String, java.sql.Timestamp, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.util.UUID, java.lang.Integer, java.util.UUID, java.sql.Timestamp, java.lang.String, java.sql.Timestamp, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row7) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field1() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionAssessments.REVISION_ASSESSMENTS.REVISION_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionAssessments.REVISION_ASSESSMENTS.ASSESSMENT_TYPE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field3() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionAssessments.REVISION_ASSESSMENTS.USER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field4() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionAssessments.REVISION_ASSESSMENTS.CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionAssessments.REVISION_ASSESSMENTS.COMMENTS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field6() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionAssessments.REVISION_ASSESSMENTS.ROW_CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field7() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionAssessments.REVISION_ASSESSMENTS.ROW_UPDATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value1() {
		return getRevisionId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value2() {
		return getAssessmentTypeId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value3() {
		return getUserId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value4() {
		return getCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getComments();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value6() {
		return getRowCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value7() {
		return getRowUpdated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionAssessmentsRecord value1(java.util.UUID value) {
		setRevisionId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionAssessmentsRecord value2(java.lang.Integer value) {
		setAssessmentTypeId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionAssessmentsRecord value3(java.util.UUID value) {
		setUserId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionAssessmentsRecord value4(java.sql.Timestamp value) {
		setCreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionAssessmentsRecord value5(java.lang.String value) {
		setComments(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionAssessmentsRecord value6(java.sql.Timestamp value) {
		setRowCreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionAssessmentsRecord value7(java.sql.Timestamp value) {
		setRowUpdated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionAssessmentsRecord values(java.util.UUID value1, java.lang.Integer value2, java.util.UUID value3, java.sql.Timestamp value4, java.lang.String value5, java.sql.Timestamp value6, java.sql.Timestamp value7) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached RevisionAssessmentsRecord
	 */
	public RevisionAssessmentsRecord() {
		super(us.fok.lenzenslijper.models.jooq.tables.RevisionAssessments.REVISION_ASSESSMENTS);
	}

	/**
	 * Create a detached, initialised RevisionAssessmentsRecord
	 */
	public RevisionAssessmentsRecord(java.util.UUID revisionId, java.lang.Integer assessmentTypeId, java.util.UUID userId, java.sql.Timestamp created, java.lang.String comments, java.sql.Timestamp rowCreated, java.sql.Timestamp rowUpdated) {
		super(us.fok.lenzenslijper.models.jooq.tables.RevisionAssessments.REVISION_ASSESSMENTS);

		setValue(0, revisionId);
		setValue(1, assessmentTypeId);
		setValue(2, userId);
		setValue(3, created);
		setValue(4, comments);
		setValue(5, rowCreated);
		setValue(6, rowUpdated);
	}
}