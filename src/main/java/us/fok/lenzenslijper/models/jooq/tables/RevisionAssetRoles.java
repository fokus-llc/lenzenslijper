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
public class RevisionAssetRoles extends org.jooq.impl.TableImpl<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord> {

	private static final long serialVersionUID = -1985841053;

	/**
	 * The singleton instance of <code>public.revision_asset_roles</code>
	 */
	public static final us.fok.lenzenslijper.models.jooq.tables.RevisionAssetRoles REVISION_ASSET_ROLES = new us.fok.lenzenslijper.models.jooq.tables.RevisionAssetRoles();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord> getRecordType() {
		return us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord.class;
	}

	/**
	 * The column <code>public.revision_asset_roles.revision_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord, java.util.UUID> REVISION_ID = createField("revision_id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.revision_asset_roles.asset_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord, java.util.UUID> ASSET_ID = createField("asset_id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.revision_asset_roles.asset_role_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord, java.lang.Integer> ASSET_ROLE_ID = createField("asset_role_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.revision_asset_roles.title</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord, java.lang.String> TITLE = createField("title", org.jooq.impl.SQLDataType.CLOB.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.revision_asset_roles.row_created</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord, java.sql.Timestamp> ROW_CREATED = createField("row_created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.revision_asset_roles.row_updated</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord, java.sql.Timestamp> ROW_UPDATED = createField("row_updated", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * Create a <code>public.revision_asset_roles</code> table reference
	 */
	public RevisionAssetRoles() {
		this("revision_asset_roles", null);
	}

	/**
	 * Create an aliased <code>public.revision_asset_roles</code> table reference
	 */
	public RevisionAssetRoles(java.lang.String alias) {
		this(alias, us.fok.lenzenslijper.models.jooq.tables.RevisionAssetRoles.REVISION_ASSET_ROLES);
	}

	private RevisionAssetRoles(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord> aliased) {
		this(alias, aliased, null);
	}

	private RevisionAssetRoles(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, us.fok.lenzenslijper.models.jooq.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord> getPrimaryKey() {
		return us.fok.lenzenslijper.models.jooq.Keys.UNIQ_REV_ASSET_ROLES_REV_ROLE_TITLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord>>asList(us.fok.lenzenslijper.models.jooq.Keys.UNIQ_REV_ASSET_ROLES_REV_ROLE_TITLE, us.fok.lenzenslijper.models.jooq.Keys.UNIQ_REV_ASSET_ROLES_REV_ASSET);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<us.fok.lenzenslijper.models.jooq.tables.records.RevisionAssetRolesRecord, ?>>asList(us.fok.lenzenslijper.models.jooq.Keys.REVISION_ASSET_ROLES__FOR_REV_ASSET_ROLES_REV, us.fok.lenzenslijper.models.jooq.Keys.REVISION_ASSET_ROLES__FOR_REV_ASSET_ROLES_ASSET, us.fok.lenzenslijper.models.jooq.Keys.REVISION_ASSET_ROLES__FOR_REV_ASSET_ROLES_ROLE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public us.fok.lenzenslijper.models.jooq.tables.RevisionAssetRoles as(java.lang.String alias) {
		return new us.fok.lenzenslijper.models.jooq.tables.RevisionAssetRoles(alias, this);
	}

	/**
	 * Rename this table
	 */
	public us.fok.lenzenslijper.models.jooq.tables.RevisionAssetRoles rename(java.lang.String name) {
		return new us.fok.lenzenslijper.models.jooq.tables.RevisionAssetRoles(name, null);
	}
}
