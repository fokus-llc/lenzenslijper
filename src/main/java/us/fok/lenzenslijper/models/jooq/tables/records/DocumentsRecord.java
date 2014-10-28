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
public class DocumentsRecord extends org.jooq.impl.UpdatableRecordImpl<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord> implements org.jooq.Record7<java.util.UUID, java.lang.Integer, java.util.UUID, java.util.UUID, java.lang.String, java.sql.Timestamp, java.sql.Timestamp> {

	private static final long serialVersionUID = 514033998;

	/**
	 * Setter for <code>public.documents.document_id</code>.
	 */
	public void setDocumentId(java.util.UUID value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.documents.document_id</code>.
	 */
	public java.util.UUID getDocumentId() {
		return (java.util.UUID) getValue(0);
	}

	/**
	 * Setter for <code>public.documents.document_type_id</code>.
	 */
	public void setDocumentTypeId(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.documents.document_type_id</code>.
	 */
	public java.lang.Integer getDocumentTypeId() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>public.documents.concept_set_id</code>.
	 */
	public void setConceptSetId(java.util.UUID value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.documents.concept_set_id</code>.
	 */
	public java.util.UUID getConceptSetId() {
		return (java.util.UUID) getValue(2);
	}

	/**
	 * Setter for <code>public.documents.project_id</code>.
	 */
	public void setProjectId(java.util.UUID value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.documents.project_id</code>.
	 */
	public java.util.UUID getProjectId() {
		return (java.util.UUID) getValue(3);
	}

	/**
	 * Setter for <code>public.documents.slug</code>.
	 */
	public void setSlug(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.documents.slug</code>.
	 */
	public java.lang.String getSlug() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>public.documents.row_created</code>.
	 */
	public void setRowCreated(java.sql.Timestamp value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.documents.row_created</code>.
	 */
	public java.sql.Timestamp getRowCreated() {
		return (java.sql.Timestamp) getValue(5);
	}

	/**
	 * Setter for <code>public.documents.row_updated</code>.
	 */
	public void setRowUpdated(java.sql.Timestamp value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.documents.row_updated</code>.
	 */
	public java.sql.Timestamp getRowUpdated() {
		return (java.sql.Timestamp) getValue(6);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.util.UUID> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record7 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.util.UUID, java.lang.Integer, java.util.UUID, java.util.UUID, java.lang.String, java.sql.Timestamp, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.util.UUID, java.lang.Integer, java.util.UUID, java.util.UUID, java.lang.String, java.sql.Timestamp, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row7) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field1() {
		return us.fok.lenzenslijper.models.jooq.tables.Documents.DOCUMENTS.DOCUMENT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return us.fok.lenzenslijper.models.jooq.tables.Documents.DOCUMENTS.DOCUMENT_TYPE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field3() {
		return us.fok.lenzenslijper.models.jooq.tables.Documents.DOCUMENTS.CONCEPT_SET_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field4() {
		return us.fok.lenzenslijper.models.jooq.tables.Documents.DOCUMENTS.PROJECT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return us.fok.lenzenslijper.models.jooq.tables.Documents.DOCUMENTS.SLUG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field6() {
		return us.fok.lenzenslijper.models.jooq.tables.Documents.DOCUMENTS.ROW_CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field7() {
		return us.fok.lenzenslijper.models.jooq.tables.Documents.DOCUMENTS.ROW_UPDATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value1() {
		return getDocumentId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value2() {
		return getDocumentTypeId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value3() {
		return getConceptSetId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value4() {
		return getProjectId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getSlug();
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
	public DocumentsRecord value1(java.util.UUID value) {
		setDocumentId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DocumentsRecord value2(java.lang.Integer value) {
		setDocumentTypeId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DocumentsRecord value3(java.util.UUID value) {
		setConceptSetId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DocumentsRecord value4(java.util.UUID value) {
		setProjectId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DocumentsRecord value5(java.lang.String value) {
		setSlug(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DocumentsRecord value6(java.sql.Timestamp value) {
		setRowCreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DocumentsRecord value7(java.sql.Timestamp value) {
		setRowUpdated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DocumentsRecord values(java.util.UUID value1, java.lang.Integer value2, java.util.UUID value3, java.util.UUID value4, java.lang.String value5, java.sql.Timestamp value6, java.sql.Timestamp value7) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached DocumentsRecord
	 */
	public DocumentsRecord() {
		super(us.fok.lenzenslijper.models.jooq.tables.Documents.DOCUMENTS);
	}

	/**
	 * Create a detached, initialised DocumentsRecord
	 */
	public DocumentsRecord(java.util.UUID documentId, java.lang.Integer documentTypeId, java.util.UUID conceptSetId, java.util.UUID projectId, java.lang.String slug, java.sql.Timestamp rowCreated, java.sql.Timestamp rowUpdated) {
		super(us.fok.lenzenslijper.models.jooq.tables.Documents.DOCUMENTS);

		setValue(0, documentId);
		setValue(1, documentTypeId);
		setValue(2, conceptSetId);
		setValue(3, projectId);
		setValue(4, slug);
		setValue(5, rowCreated);
		setValue(6, rowUpdated);
	}
}
