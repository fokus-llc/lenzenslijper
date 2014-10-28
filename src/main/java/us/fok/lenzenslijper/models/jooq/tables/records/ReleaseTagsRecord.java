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
public class ReleaseTagsRecord extends org.jooq.impl.UpdatableRecordImpl<us.fok.lenzenslijper.models.jooq.tables.records.ReleaseTagsRecord> implements org.jooq.Record4<java.lang.Integer, java.lang.String, java.sql.Timestamp, java.sql.Timestamp> {

	private static final long serialVersionUID = -593519563;

	/**
	 * Setter for <code>public.release_tags.release_tag_id</code>.
	 */
	public void setReleaseTagId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.release_tags.release_tag_id</code>.
	 */
	public java.lang.Integer getReleaseTagId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.release_tags.slug</code>.
	 */
	public void setSlug(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.release_tags.slug</code>.
	 */
	public java.lang.String getSlug() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>public.release_tags.row_created</code>.
	 */
	public void setRowCreated(java.sql.Timestamp value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.release_tags.row_created</code>.
	 */
	public java.sql.Timestamp getRowCreated() {
		return (java.sql.Timestamp) getValue(2);
	}

	/**
	 * Setter for <code>public.release_tags.row_updated</code>.
	 */
	public void setRowUpdated(java.sql.Timestamp value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.release_tags.row_updated</code>.
	 */
	public java.sql.Timestamp getRowUpdated() {
		return (java.sql.Timestamp) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Integer> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.Integer, java.lang.String, java.sql.Timestamp, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.Integer, java.lang.String, java.sql.Timestamp, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return us.fok.lenzenslijper.models.jooq.tables.ReleaseTags.RELEASE_TAGS.RELEASE_TAG_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return us.fok.lenzenslijper.models.jooq.tables.ReleaseTags.RELEASE_TAGS.SLUG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field3() {
		return us.fok.lenzenslijper.models.jooq.tables.ReleaseTags.RELEASE_TAGS.ROW_CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field4() {
		return us.fok.lenzenslijper.models.jooq.tables.ReleaseTags.RELEASE_TAGS.ROW_UPDATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getReleaseTagId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getSlug();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value3() {
		return getRowCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value4() {
		return getRowUpdated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ReleaseTagsRecord value1(java.lang.Integer value) {
		setReleaseTagId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ReleaseTagsRecord value2(java.lang.String value) {
		setSlug(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ReleaseTagsRecord value3(java.sql.Timestamp value) {
		setRowCreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ReleaseTagsRecord value4(java.sql.Timestamp value) {
		setRowUpdated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ReleaseTagsRecord values(java.lang.Integer value1, java.lang.String value2, java.sql.Timestamp value3, java.sql.Timestamp value4) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ReleaseTagsRecord
	 */
	public ReleaseTagsRecord() {
		super(us.fok.lenzenslijper.models.jooq.tables.ReleaseTags.RELEASE_TAGS);
	}

	/**
	 * Create a detached, initialised ReleaseTagsRecord
	 */
	public ReleaseTagsRecord(java.lang.Integer releaseTagId, java.lang.String slug, java.sql.Timestamp rowCreated, java.sql.Timestamp rowUpdated) {
		super(us.fok.lenzenslijper.models.jooq.tables.ReleaseTags.RELEASE_TAGS);

		setValue(0, releaseTagId);
		setValue(1, slug);
		setValue(2, rowCreated);
		setValue(3, rowUpdated);
	}
}
