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
public class SpatialRefSys extends org.jooq.impl.TableImpl<us.fok.lenzenslijper.models.jooq.tables.records.SpatialRefSysRecord> {

	private static final long serialVersionUID = 414662666;

	/**
	 * The singleton instance of <code>public.spatial_ref_sys</code>
	 */
	public static final us.fok.lenzenslijper.models.jooq.tables.SpatialRefSys SPATIAL_REF_SYS = new us.fok.lenzenslijper.models.jooq.tables.SpatialRefSys();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<us.fok.lenzenslijper.models.jooq.tables.records.SpatialRefSysRecord> getRecordType() {
		return us.fok.lenzenslijper.models.jooq.tables.records.SpatialRefSysRecord.class;
	}

	/**
	 * The column <code>public.spatial_ref_sys.srid</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.SpatialRefSysRecord, java.lang.Integer> SRID = createField("srid", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.spatial_ref_sys.auth_name</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.SpatialRefSysRecord, java.lang.String> AUTH_NAME = createField("auth_name", org.jooq.impl.SQLDataType.VARCHAR.length(256).defaulted(true), this, "");

	/**
	 * The column <code>public.spatial_ref_sys.auth_srid</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.SpatialRefSysRecord, java.lang.Integer> AUTH_SRID = createField("auth_srid", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this, "");

	/**
	 * The column <code>public.spatial_ref_sys.srtext</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.SpatialRefSysRecord, java.lang.String> SRTEXT = createField("srtext", org.jooq.impl.SQLDataType.VARCHAR.length(2048).defaulted(true), this, "");

	/**
	 * The column <code>public.spatial_ref_sys.proj4text</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.SpatialRefSysRecord, java.lang.String> PROJ4TEXT = createField("proj4text", org.jooq.impl.SQLDataType.VARCHAR.length(2048).defaulted(true), this, "");

	/**
	 * Create a <code>public.spatial_ref_sys</code> table reference
	 */
	public SpatialRefSys() {
		this("spatial_ref_sys", null);
	}

	/**
	 * Create an aliased <code>public.spatial_ref_sys</code> table reference
	 */
	public SpatialRefSys(java.lang.String alias) {
		this(alias, us.fok.lenzenslijper.models.jooq.tables.SpatialRefSys.SPATIAL_REF_SYS);
	}

	private SpatialRefSys(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.SpatialRefSysRecord> aliased) {
		this(alias, aliased, null);
	}

	private SpatialRefSys(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.SpatialRefSysRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, us.fok.lenzenslijper.models.jooq.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.SpatialRefSysRecord> getPrimaryKey() {
		return us.fok.lenzenslijper.models.jooq.Keys.SPATIAL_REF_SYS_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.SpatialRefSysRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.SpatialRefSysRecord>>asList(us.fok.lenzenslijper.models.jooq.Keys.SPATIAL_REF_SYS_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public us.fok.lenzenslijper.models.jooq.tables.SpatialRefSys as(java.lang.String alias) {
		return new us.fok.lenzenslijper.models.jooq.tables.SpatialRefSys(alias, this);
	}

	/**
	 * Rename this table
	 */
	public us.fok.lenzenslijper.models.jooq.tables.SpatialRefSys rename(java.lang.String name) {
		return new us.fok.lenzenslijper.models.jooq.tables.SpatialRefSys(name, null);
	}
}