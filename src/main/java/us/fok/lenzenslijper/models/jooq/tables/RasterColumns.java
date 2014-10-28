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
public class RasterColumns extends org.jooq.impl.TableImpl<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord> {

	private static final long serialVersionUID = 1673673886;

	/**
	 * The singleton instance of <code>public.raster_columns</code>
	 */
	public static final us.fok.lenzenslijper.models.jooq.tables.RasterColumns RASTER_COLUMNS = new us.fok.lenzenslijper.models.jooq.tables.RasterColumns();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord> getRecordType() {
		return us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord.class;
	}

	/**
	 * The column <code>public.raster_columns.r_table_catalog</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.String> R_TABLE_CATALOG = createField("r_table_catalog", org.jooq.impl.SQLDataType.VARCHAR.defaulted(true), this, "");

	/**
	 * The column <code>public.raster_columns.r_table_schema</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.String> R_TABLE_SCHEMA = createField("r_table_schema", org.jooq.impl.SQLDataType.VARCHAR.defaulted(true), this, "");

	/**
	 * The column <code>public.raster_columns.r_table_name</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.String> R_TABLE_NAME = createField("r_table_name", org.jooq.impl.SQLDataType.VARCHAR.defaulted(true), this, "");

	/**
	 * The column <code>public.raster_columns.r_raster_column</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.String> R_RASTER_COLUMN = createField("r_raster_column", org.jooq.impl.SQLDataType.VARCHAR.defaulted(true), this, "");

	/**
	 * The column <code>public.raster_columns.srid</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.Integer> SRID = createField("srid", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this, "");

	/**
	 * The column <code>public.raster_columns.scale_x</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.Double> SCALE_X = createField("scale_x", org.jooq.impl.SQLDataType.DOUBLE.defaulted(true), this, "");

	/**
	 * The column <code>public.raster_columns.scale_y</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.Double> SCALE_Y = createField("scale_y", org.jooq.impl.SQLDataType.DOUBLE.defaulted(true), this, "");

	/**
	 * The column <code>public.raster_columns.blocksize_x</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.Integer> BLOCKSIZE_X = createField("blocksize_x", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this, "");

	/**
	 * The column <code>public.raster_columns.blocksize_y</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.Integer> BLOCKSIZE_Y = createField("blocksize_y", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this, "");

	/**
	 * The column <code>public.raster_columns.same_alignment</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.Boolean> SAME_ALIGNMENT = createField("same_alignment", org.jooq.impl.SQLDataType.BOOLEAN.defaulted(true), this, "");

	/**
	 * The column <code>public.raster_columns.regular_blocking</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.Boolean> REGULAR_BLOCKING = createField("regular_blocking", org.jooq.impl.SQLDataType.BOOLEAN.defaulted(true), this, "");

	/**
	 * The column <code>public.raster_columns.num_bands</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.Integer> NUM_BANDS = createField("num_bands", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this, "");

	/**
	 * The column <code>public.raster_columns.pixel_types</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.String[]> PIXEL_TYPES = createField("pixel_types", org.jooq.impl.SQLDataType.CLOB.getArrayDataType(), this, "");

	/**
	 * The column <code>public.raster_columns.nodata_values</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.Double[]> NODATA_VALUES = createField("nodata_values", org.jooq.impl.SQLDataType.FLOAT.getArrayDataType(), this, "");

	/**
	 * The column <code>public.raster_columns.out_db</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.Boolean[]> OUT_DB = createField("out_db", org.jooq.impl.SQLDataType.BOOLEAN.getArrayDataType(), this, "");

	/**
	 * The column <code>public.raster_columns.extent</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord, java.lang.Object> EXTENT = createField("extent", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"), this, "");

	/**
	 * Create a <code>public.raster_columns</code> table reference
	 */
	public RasterColumns() {
		this("raster_columns", null);
	}

	/**
	 * Create an aliased <code>public.raster_columns</code> table reference
	 */
	public RasterColumns(java.lang.String alias) {
		this(alias, us.fok.lenzenslijper.models.jooq.tables.RasterColumns.RASTER_COLUMNS);
	}

	private RasterColumns(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord> aliased) {
		this(alias, aliased, null);
	}

	private RasterColumns(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.RasterColumnsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, us.fok.lenzenslijper.models.jooq.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public us.fok.lenzenslijper.models.jooq.tables.RasterColumns as(java.lang.String alias) {
		return new us.fok.lenzenslijper.models.jooq.tables.RasterColumns(alias, this);
	}

	/**
	 * Rename this table
	 */
	public us.fok.lenzenslijper.models.jooq.tables.RasterColumns rename(java.lang.String name) {
		return new us.fok.lenzenslijper.models.jooq.tables.RasterColumns(name, null);
	}
}
