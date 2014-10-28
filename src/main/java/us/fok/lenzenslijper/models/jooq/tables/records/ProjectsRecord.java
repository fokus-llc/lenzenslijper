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
public class ProjectsRecord extends org.jooq.impl.UpdatableRecordImpl<us.fok.lenzenslijper.models.jooq.tables.records.ProjectsRecord> implements org.jooq.Record11<java.util.UUID, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.util.UUID, java.sql.Timestamp, java.util.UUID, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp> {

	private static final long serialVersionUID = 396846265;

	/**
	 * Setter for <code>public.projects.project_id</code>.
	 */
	public void setProjectId(java.util.UUID value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.projects.project_id</code>.
	 */
	public java.util.UUID getProjectId() {
		return (java.util.UUID) getValue(0);
	}

	/**
	 * Setter for <code>public.projects.slug</code>.
	 */
	public void setSlug(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.projects.slug</code>.
	 */
	public java.lang.String getSlug() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>public.projects.name</code>.
	 */
	public void setName(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.projects.name</code>.
	 */
	public java.lang.String getName() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>public.projects.short_name</code>.
	 */
	public void setShortName(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.projects.short_name</code>.
	 */
	public java.lang.String getShortName() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>public.projects.default_mode</code>.
	 */
	public void setDefaultMode(java.lang.Integer value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.projects.default_mode</code>.
	 */
	public java.lang.Integer getDefaultMode() {
		return (java.lang.Integer) getValue(4);
	}

	/**
	 * Setter for <code>public.projects.creator_user_id</code>.
	 */
	public void setCreatorUserId(java.util.UUID value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.projects.creator_user_id</code>.
	 */
	public java.util.UUID getCreatorUserId() {
		return (java.util.UUID) getValue(5);
	}

	/**
	 * Setter for <code>public.projects.created</code>.
	 */
	public void setCreated(java.sql.Timestamp value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.projects.created</code>.
	 */
	public java.sql.Timestamp getCreated() {
		return (java.sql.Timestamp) getValue(6);
	}

	/**
	 * Setter for <code>public.projects.updater_user_id</code>.
	 */
	public void setUpdaterUserId(java.util.UUID value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>public.projects.updater_user_id</code>.
	 */
	public java.util.UUID getUpdaterUserId() {
		return (java.util.UUID) getValue(7);
	}

	/**
	 * Setter for <code>public.projects.updated</code>.
	 */
	public void setUpdated(java.sql.Timestamp value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>public.projects.updated</code>.
	 */
	public java.sql.Timestamp getUpdated() {
		return (java.sql.Timestamp) getValue(8);
	}

	/**
	 * Setter for <code>public.projects.row_created</code>.
	 */
	public void setRowCreated(java.sql.Timestamp value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>public.projects.row_created</code>.
	 */
	public java.sql.Timestamp getRowCreated() {
		return (java.sql.Timestamp) getValue(9);
	}

	/**
	 * Setter for <code>public.projects.row_updated</code>.
	 */
	public void setRowUpdated(java.sql.Timestamp value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>public.projects.row_updated</code>.
	 */
	public java.sql.Timestamp getRowUpdated() {
		return (java.sql.Timestamp) getValue(10);
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
	// Record11 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row11<java.util.UUID, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.util.UUID, java.sql.Timestamp, java.util.UUID, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row11) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row11<java.util.UUID, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.util.UUID, java.sql.Timestamp, java.util.UUID, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row11) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field1() {
		return us.fok.lenzenslijper.models.jooq.tables.Projects.PROJECTS.PROJECT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return us.fok.lenzenslijper.models.jooq.tables.Projects.PROJECTS.SLUG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return us.fok.lenzenslijper.models.jooq.tables.Projects.PROJECTS.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return us.fok.lenzenslijper.models.jooq.tables.Projects.PROJECTS.SHORT_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field5() {
		return us.fok.lenzenslijper.models.jooq.tables.Projects.PROJECTS.DEFAULT_MODE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field6() {
		return us.fok.lenzenslijper.models.jooq.tables.Projects.PROJECTS.CREATOR_USER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field7() {
		return us.fok.lenzenslijper.models.jooq.tables.Projects.PROJECTS.CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field8() {
		return us.fok.lenzenslijper.models.jooq.tables.Projects.PROJECTS.UPDATER_USER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field9() {
		return us.fok.lenzenslijper.models.jooq.tables.Projects.PROJECTS.UPDATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field10() {
		return us.fok.lenzenslijper.models.jooq.tables.Projects.PROJECTS.ROW_CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field11() {
		return us.fok.lenzenslijper.models.jooq.tables.Projects.PROJECTS.ROW_UPDATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value1() {
		return getProjectId();
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
	public java.lang.String value3() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getShortName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value5() {
		return getDefaultMode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value6() {
		return getCreatorUserId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value7() {
		return getCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value8() {
		return getUpdaterUserId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value9() {
		return getUpdated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value10() {
		return getRowCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value11() {
		return getRowUpdated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProjectsRecord value1(java.util.UUID value) {
		setProjectId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProjectsRecord value2(java.lang.String value) {
		setSlug(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProjectsRecord value3(java.lang.String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProjectsRecord value4(java.lang.String value) {
		setShortName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProjectsRecord value5(java.lang.Integer value) {
		setDefaultMode(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProjectsRecord value6(java.util.UUID value) {
		setCreatorUserId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProjectsRecord value7(java.sql.Timestamp value) {
		setCreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProjectsRecord value8(java.util.UUID value) {
		setUpdaterUserId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProjectsRecord value9(java.sql.Timestamp value) {
		setUpdated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProjectsRecord value10(java.sql.Timestamp value) {
		setRowCreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProjectsRecord value11(java.sql.Timestamp value) {
		setRowUpdated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProjectsRecord values(java.util.UUID value1, java.lang.String value2, java.lang.String value3, java.lang.String value4, java.lang.Integer value5, java.util.UUID value6, java.sql.Timestamp value7, java.util.UUID value8, java.sql.Timestamp value9, java.sql.Timestamp value10, java.sql.Timestamp value11) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ProjectsRecord
	 */
	public ProjectsRecord() {
		super(us.fok.lenzenslijper.models.jooq.tables.Projects.PROJECTS);
	}

	/**
	 * Create a detached, initialised ProjectsRecord
	 */
	public ProjectsRecord(java.util.UUID projectId, java.lang.String slug, java.lang.String name, java.lang.String shortName, java.lang.Integer defaultMode, java.util.UUID creatorUserId, java.sql.Timestamp created, java.util.UUID updaterUserId, java.sql.Timestamp updated, java.sql.Timestamp rowCreated, java.sql.Timestamp rowUpdated) {
		super(us.fok.lenzenslijper.models.jooq.tables.Projects.PROJECTS);

		setValue(0, projectId);
		setValue(1, slug);
		setValue(2, name);
		setValue(3, shortName);
		setValue(4, defaultMode);
		setValue(5, creatorUserId);
		setValue(6, created);
		setValue(7, updaterUserId);
		setValue(8, updated);
		setValue(9, rowCreated);
		setValue(10, rowUpdated);
	}
}