/**
 * This class is generated by jOOQ
 */
package us.fok.lenzenslijper.models.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProjectUserGrants extends org.jooq.impl.TableImpl<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord> {

	private static final long serialVersionUID = 844089138;

	/**
	 * The singleton instance of <code>public.project_user_grants</code>
	 */
	public static final us.fok.lenzenslijper.models.jooq.tables.ProjectUserGrants PROJECT_USER_GRANTS = new us.fok.lenzenslijper.models.jooq.tables.ProjectUserGrants();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord> getRecordType() {
		return us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord.class;
	}

	/**
	 * The column <code>public.project_user_grants.project_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord, java.util.UUID> PROJECT_ID = createField("project_id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.project_user_grants.user_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord, java.util.UUID> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.project_user_grants.project_role_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord, java.lang.Integer> PROJECT_ROLE_ID = createField("project_role_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.project_user_grants.grantor_user_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord, java.util.UUID> GRANTOR_USER_ID = createField("grantor_user_id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.project_user_grants.created</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord, java.sql.Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.project_user_grants.row_created</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord, java.sql.Timestamp> ROW_CREATED = createField("row_created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.project_user_grants.row_updated</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord, java.sql.Timestamp> ROW_UPDATED = createField("row_updated", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * Create a <code>public.project_user_grants</code> table reference
	 */
	public ProjectUserGrants() {
		this("project_user_grants", null);
	}

	/**
	 * Create an aliased <code>public.project_user_grants</code> table reference
	 */
	public ProjectUserGrants(java.lang.String alias) {
		this(alias, us.fok.lenzenslijper.models.jooq.tables.ProjectUserGrants.PROJECT_USER_GRANTS);
	}

	private ProjectUserGrants(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord> aliased) {
		this(alias, aliased, null);
	}

	private ProjectUserGrants(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, us.fok.lenzenslijper.models.jooq.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord> getPrimaryKey() {
		return us.fok.lenzenslijper.models.jooq.Keys.UNIQ_GRANTS_PROJECT_USER_ROLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord>>asList(us.fok.lenzenslijper.models.jooq.Keys.UNIQ_GRANTS_PROJECT_USER_ROLE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<us.fok.lenzenslijper.models.jooq.tables.records.ProjectUserGrantsRecord, ?>>asList(us.fok.lenzenslijper.models.jooq.Keys.PROJECT_USER_GRANTS__FOR_GRANTS_PROJECT, us.fok.lenzenslijper.models.jooq.Keys.PROJECT_USER_GRANTS__FOR_GRANTS_USER, us.fok.lenzenslijper.models.jooq.Keys.PROJECT_USER_GRANTS__FOR_GRANTS_ROLE, us.fok.lenzenslijper.models.jooq.Keys.PROJECT_USER_GRANTS__FOR_GRANTS_GRANTOR);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public us.fok.lenzenslijper.models.jooq.tables.ProjectUserGrants as(java.lang.String alias) {
		return new us.fok.lenzenslijper.models.jooq.tables.ProjectUserGrants(alias, this);
	}

	/**
	 * Rename this table
	 */
	public us.fok.lenzenslijper.models.jooq.tables.ProjectUserGrants rename(java.lang.String name) {
		return new us.fok.lenzenslijper.models.jooq.tables.ProjectUserGrants(name, null);
	}
}
