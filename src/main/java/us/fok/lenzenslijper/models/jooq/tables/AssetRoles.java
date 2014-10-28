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
public class AssetRoles extends org.jooq.impl.TableImpl<us.fok.lenzenslijper.models.jooq.tables.records.AssetRolesRecord> {

	private static final long serialVersionUID = -68776258;

	/**
	 * The singleton instance of <code>public.asset_roles</code>
	 */
	public static final us.fok.lenzenslijper.models.jooq.tables.AssetRoles ASSET_ROLES = new us.fok.lenzenslijper.models.jooq.tables.AssetRoles();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<us.fok.lenzenslijper.models.jooq.tables.records.AssetRolesRecord> getRecordType() {
		return us.fok.lenzenslijper.models.jooq.tables.records.AssetRolesRecord.class;
	}

	/**
	 * The column <code>public.asset_roles.asset_role_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.AssetRolesRecord, java.lang.Integer> ASSET_ROLE_ID = createField("asset_role_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.asset_roles.slug</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.AssetRolesRecord, java.lang.String> SLUG = createField("slug", org.jooq.impl.SQLDataType.CLOB.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.asset_roles.row_created</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.AssetRolesRecord, java.sql.Timestamp> ROW_CREATED = createField("row_created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.asset_roles.row_updated</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.AssetRolesRecord, java.sql.Timestamp> ROW_UPDATED = createField("row_updated", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * Create a <code>public.asset_roles</code> table reference
	 */
	public AssetRoles() {
		this("asset_roles", null);
	}

	/**
	 * Create an aliased <code>public.asset_roles</code> table reference
	 */
	public AssetRoles(java.lang.String alias) {
		this(alias, us.fok.lenzenslijper.models.jooq.tables.AssetRoles.ASSET_ROLES);
	}

	private AssetRoles(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.AssetRolesRecord> aliased) {
		this(alias, aliased, null);
	}

	private AssetRoles(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.AssetRolesRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, us.fok.lenzenslijper.models.jooq.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<us.fok.lenzenslijper.models.jooq.tables.records.AssetRolesRecord, java.lang.Integer> getIdentity() {
		return us.fok.lenzenslijper.models.jooq.Keys.IDENTITY_ASSET_ROLES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.AssetRolesRecord> getPrimaryKey() {
		return us.fok.lenzenslijper.models.jooq.Keys.UNIQ_ASSET_ROLES_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.AssetRolesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.AssetRolesRecord>>asList(us.fok.lenzenslijper.models.jooq.Keys.UNIQ_ASSET_ROLES_ID, us.fok.lenzenslijper.models.jooq.Keys.UNIQ_ASSET_ROLES_SLUG);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public us.fok.lenzenslijper.models.jooq.tables.AssetRoles as(java.lang.String alias) {
		return new us.fok.lenzenslijper.models.jooq.tables.AssetRoles(alias, this);
	}

	/**
	 * Rename this table
	 */
	public us.fok.lenzenslijper.models.jooq.tables.AssetRoles rename(java.lang.String name) {
		return new us.fok.lenzenslijper.models.jooq.tables.AssetRoles(name, null);
	}
}
