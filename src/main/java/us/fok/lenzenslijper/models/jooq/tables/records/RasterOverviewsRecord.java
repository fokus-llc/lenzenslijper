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
public class RasterOverviewsRecord extends org.jooq.impl.TableRecordImpl<us.fok.lenzenslijper.models.jooq.tables.records.RasterOverviewsRecord> implements org.jooq.Record9<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer> {

	private static final long serialVersionUID = 1535534738;

	/**
	 * Setter for <code>public.raster_overviews.o_table_catalog</code>.
	 */
	public void setOTableCatalog(java.lang.String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.raster_overviews.o_table_catalog</code>.
	 */
	public java.lang.String getOTableCatalog() {
		return (java.lang.String) getValue(0);
	}

	/**
	 * Setter for <code>public.raster_overviews.o_table_schema</code>.
	 */
	public void setOTableSchema(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.raster_overviews.o_table_schema</code>.
	 */
	public java.lang.String getOTableSchema() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>public.raster_overviews.o_table_name</code>.
	 */
	public void setOTableName(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.raster_overviews.o_table_name</code>.
	 */
	public java.lang.String getOTableName() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>public.raster_overviews.o_raster_column</code>.
	 */
	public void setORasterColumn(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.raster_overviews.o_raster_column</code>.
	 */
	public java.lang.String getORasterColumn() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>public.raster_overviews.r_table_catalog</code>.
	 */
	public void setRTableCatalog(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.raster_overviews.r_table_catalog</code>.
	 */
	public java.lang.String getRTableCatalog() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>public.raster_overviews.r_table_schema</code>.
	 */
	public void setRTableSchema(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.raster_overviews.r_table_schema</code>.
	 */
	public java.lang.String getRTableSchema() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>public.raster_overviews.r_table_name</code>.
	 */
	public void setRTableName(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.raster_overviews.r_table_name</code>.
	 */
	public java.lang.String getRTableName() {
		return (java.lang.String) getValue(6);
	}

	/**
	 * Setter for <code>public.raster_overviews.r_raster_column</code>.
	 */
	public void setRRasterColumn(java.lang.String value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>public.raster_overviews.r_raster_column</code>.
	 */
	public java.lang.String getRRasterColumn() {
		return (java.lang.String) getValue(7);
	}

	/**
	 * Setter for <code>public.raster_overviews.overview_factor</code>.
	 */
	public void setOverviewFactor(java.lang.Integer value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>public.raster_overviews.overview_factor</code>.
	 */
	public java.lang.Integer getOverviewFactor() {
		return (java.lang.Integer) getValue(8);
	}

	// -------------------------------------------------------------------------
	// Record9 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row9<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer> fieldsRow() {
		return (org.jooq.Row9) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row9<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer> valuesRow() {
		return (org.jooq.Row9) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field1() {
		return us.fok.lenzenslijper.models.jooq.tables.RasterOverviews.RASTER_OVERVIEWS.O_TABLE_CATALOG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return us.fok.lenzenslijper.models.jooq.tables.RasterOverviews.RASTER_OVERVIEWS.O_TABLE_SCHEMA;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return us.fok.lenzenslijper.models.jooq.tables.RasterOverviews.RASTER_OVERVIEWS.O_TABLE_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return us.fok.lenzenslijper.models.jooq.tables.RasterOverviews.RASTER_OVERVIEWS.O_RASTER_COLUMN;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return us.fok.lenzenslijper.models.jooq.tables.RasterOverviews.RASTER_OVERVIEWS.R_TABLE_CATALOG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return us.fok.lenzenslijper.models.jooq.tables.RasterOverviews.RASTER_OVERVIEWS.R_TABLE_SCHEMA;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field7() {
		return us.fok.lenzenslijper.models.jooq.tables.RasterOverviews.RASTER_OVERVIEWS.R_TABLE_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field8() {
		return us.fok.lenzenslijper.models.jooq.tables.RasterOverviews.RASTER_OVERVIEWS.R_RASTER_COLUMN;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field9() {
		return us.fok.lenzenslijper.models.jooq.tables.RasterOverviews.RASTER_OVERVIEWS.OVERVIEW_FACTOR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value1() {
		return getOTableCatalog();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getOTableSchema();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getOTableName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getORasterColumn();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getRTableCatalog();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value6() {
		return getRTableSchema();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value7() {
		return getRTableName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value8() {
		return getRRasterColumn();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value9() {
		return getOverviewFactor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RasterOverviewsRecord value1(java.lang.String value) {
		setOTableCatalog(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RasterOverviewsRecord value2(java.lang.String value) {
		setOTableSchema(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RasterOverviewsRecord value3(java.lang.String value) {
		setOTableName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RasterOverviewsRecord value4(java.lang.String value) {
		setORasterColumn(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RasterOverviewsRecord value5(java.lang.String value) {
		setRTableCatalog(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RasterOverviewsRecord value6(java.lang.String value) {
		setRTableSchema(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RasterOverviewsRecord value7(java.lang.String value) {
		setRTableName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RasterOverviewsRecord value8(java.lang.String value) {
		setRRasterColumn(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RasterOverviewsRecord value9(java.lang.Integer value) {
		setOverviewFactor(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RasterOverviewsRecord values(java.lang.String value1, java.lang.String value2, java.lang.String value3, java.lang.String value4, java.lang.String value5, java.lang.String value6, java.lang.String value7, java.lang.String value8, java.lang.Integer value9) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached RasterOverviewsRecord
	 */
	public RasterOverviewsRecord() {
		super(us.fok.lenzenslijper.models.jooq.tables.RasterOverviews.RASTER_OVERVIEWS);
	}

	/**
	 * Create a detached, initialised RasterOverviewsRecord
	 */
	public RasterOverviewsRecord(java.lang.String oTableCatalog, java.lang.String oTableSchema, java.lang.String oTableName, java.lang.String oRasterColumn, java.lang.String rTableCatalog, java.lang.String rTableSchema, java.lang.String rTableName, java.lang.String rRasterColumn, java.lang.Integer overviewFactor) {
		super(us.fok.lenzenslijper.models.jooq.tables.RasterOverviews.RASTER_OVERVIEWS);

		setValue(0, oTableCatalog);
		setValue(1, oTableSchema);
		setValue(2, oTableName);
		setValue(3, oRasterColumn);
		setValue(4, rTableCatalog);
		setValue(5, rTableSchema);
		setValue(6, rTableName);
		setValue(7, rRasterColumn);
		setValue(8, overviewFactor);
	}
}