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
public class LinkTargetTypesRecord extends org.jooq.impl.UpdatableRecordImpl<us.fok.lenzenslijper.models.jooq.tables.records.LinkTargetTypesRecord> implements org.jooq.Record4<java.lang.Integer, java.lang.String, java.sql.Timestamp, java.sql.Timestamp> {

	private static final long serialVersionUID = 69408688;

	/**
	 * Setter for <code>public.link_target_types.link_target_type_id</code>.
	 */
	public void setLinkTargetTypeId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.link_target_types.link_target_type_id</code>.
	 */
	public java.lang.Integer getLinkTargetTypeId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.link_target_types.slug</code>.
	 */
	public void setSlug(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.link_target_types.slug</code>.
	 */
	public java.lang.String getSlug() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>public.link_target_types.row_created</code>.
	 */
	public void setRowCreated(java.sql.Timestamp value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.link_target_types.row_created</code>.
	 */
	public java.sql.Timestamp getRowCreated() {
		return (java.sql.Timestamp) getValue(2);
	}

	/**
	 * Setter for <code>public.link_target_types.row_updated</code>.
	 */
	public void setRowUpdated(java.sql.Timestamp value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.link_target_types.row_updated</code>.
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
		return us.fok.lenzenslijper.models.jooq.tables.LinkTargetTypes.LINK_TARGET_TYPES.LINK_TARGET_TYPE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return us.fok.lenzenslijper.models.jooq.tables.LinkTargetTypes.LINK_TARGET_TYPES.SLUG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field3() {
		return us.fok.lenzenslijper.models.jooq.tables.LinkTargetTypes.LINK_TARGET_TYPES.ROW_CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field4() {
		return us.fok.lenzenslijper.models.jooq.tables.LinkTargetTypes.LINK_TARGET_TYPES.ROW_UPDATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getLinkTargetTypeId();
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
	public LinkTargetTypesRecord value1(java.lang.Integer value) {
		setLinkTargetTypeId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LinkTargetTypesRecord value2(java.lang.String value) {
		setSlug(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LinkTargetTypesRecord value3(java.sql.Timestamp value) {
		setRowCreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LinkTargetTypesRecord value4(java.sql.Timestamp value) {
		setRowUpdated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LinkTargetTypesRecord values(java.lang.Integer value1, java.lang.String value2, java.sql.Timestamp value3, java.sql.Timestamp value4) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached LinkTargetTypesRecord
	 */
	public LinkTargetTypesRecord() {
		super(us.fok.lenzenslijper.models.jooq.tables.LinkTargetTypes.LINK_TARGET_TYPES);
	}

	/**
	 * Create a detached, initialised LinkTargetTypesRecord
	 */
	public LinkTargetTypesRecord(java.lang.Integer linkTargetTypeId, java.lang.String slug, java.sql.Timestamp rowCreated, java.sql.Timestamp rowUpdated) {
		super(us.fok.lenzenslijper.models.jooq.tables.LinkTargetTypes.LINK_TARGET_TYPES);

		setValue(0, linkTargetTypeId);
		setValue(1, slug);
		setValue(2, rowCreated);
		setValue(3, rowUpdated);
	}
}
