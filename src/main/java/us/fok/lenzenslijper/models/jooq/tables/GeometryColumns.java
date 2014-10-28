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
public class GeometryColumns extends org.jooq.impl.TableImpl<us.fok.lenzenslijper.models.jooq.tables.records.GeometryColumnsRecord> {

	private static final long serialVersionUID = -938285900;

	/**
	 * The singleton instance of <code>public.geometry_columns</code>
	 */
	public static final us.fok.lenzenslijper.models.jooq.tables.GeometryColumns GEOMETRY_COLUMNS = new us.fok.lenzenslijper.models.jooq.tables.GeometryColumns();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<us.fok.lenzenslijper.models.jooq.tables.records.GeometryColumnsRecord> getRecordType() {
		return us.fok.lenzenslijper.models.jooq.tables.records.GeometryColumnsRecord.class;
	}

	/**
	 * The column <code>public.geometry_columns.f_table_catalog</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.GeometryColumnsRecord, java.lang.String> F_TABLE_CATALOG = createField("f_table_catalog", org.jooq.impl.SQLDataType.VARCHAR.length(256).defaulted(true), this, "");

	/**
	 * The column <code>public.geometry_columns.f_table_schema</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.GeometryColumnsRecord, java.lang.String> F_TABLE_SCHEMA = createField("f_table_schema", org.jooq.impl.SQLDataType.VARCHAR.length(256).defaulted(true), this, "");

	/**
	 * The column <code>public.geometry_columns.f_table_name</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.GeometryColumnsRecord, java.lang.String> F_TABLE_NAME = createField("f_table_name", org.jooq.impl.SQLDataType.VARCHAR.length(256).defaulted(true), this, "");

	/**
	 * The column <code>public.geometry_columns.f_geometry_column</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.GeometryColumnsRecord, java.lang.String> F_GEOMETRY_COLUMN = createField("f_geometry_column", org.jooq.impl.SQLDataType.VARCHAR.length(256).defaulted(true), this, "");

	/**
	 * The column <code>public.geometry_columns.coord_dimension</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.GeometryColumnsRecord, java.lang.Integer> COORD_DIMENSION = createField("coord_dimension", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this, "");

	/**
	 * The column <code>public.geometry_columns.srid</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.GeometryColumnsRecord, java.lang.Integer> SRID = createField("srid", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this, "");

	/**
	 * The column <code>public.geometry_columns.type</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.GeometryColumnsRecord, java.lang.String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR.length(30).defaulted(true), this, "");

	/**
	 * Create a <code>public.geometry_columns</code> table reference
	 */
	public GeometryColumns() {
		this("geometry_columns", null);
	}

	/**
	 * Create an aliased <code>public.geometry_columns</code> table reference
	 */
	public GeometryColumns(java.lang.String alias) {
		this(alias, us.fok.lenzenslijper.models.jooq.tables.GeometryColumns.GEOMETRY_COLUMNS);
	}

	private GeometryColumns(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.GeometryColumnsRecord> aliased) {
		this(alias, aliased, null);
	}

	private GeometryColumns(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.GeometryColumnsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, us.fok.lenzenslijper.models.jooq.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public us.fok.lenzenslijper.models.jooq.tables.GeometryColumns as(java.lang.String alias) {
		return new us.fok.lenzenslijper.models.jooq.tables.GeometryColumns(alias, this);
	}

	/**
	 * Rename this table
	 */
	public us.fok.lenzenslijper.models.jooq.tables.GeometryColumns rename(java.lang.String name) {
		return new us.fok.lenzenslijper.models.jooq.tables.GeometryColumns(name, null);
	}
}