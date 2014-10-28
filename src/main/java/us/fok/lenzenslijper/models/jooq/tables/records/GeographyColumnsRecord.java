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
public class GeographyColumnsRecord extends org.jooq.impl.TableRecordImpl<us.fok.lenzenslijper.models.jooq.tables.records.GeographyColumnsRecord> implements org.jooq.Record7<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String> {

	private static final long serialVersionUID = 366813770;

	/**
	 * Setter for <code>public.geography_columns.f_table_catalog</code>.
	 */
	public void setFTableCatalog(java.lang.String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.geography_columns.f_table_catalog</code>.
	 */
	public java.lang.String getFTableCatalog() {
		return (java.lang.String) getValue(0);
	}

	/**
	 * Setter for <code>public.geography_columns.f_table_schema</code>.
	 */
	public void setFTableSchema(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.geography_columns.f_table_schema</code>.
	 */
	public java.lang.String getFTableSchema() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>public.geography_columns.f_table_name</code>.
	 */
	public void setFTableName(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.geography_columns.f_table_name</code>.
	 */
	public java.lang.String getFTableName() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>public.geography_columns.f_geography_column</code>.
	 */
	public void setFGeographyColumn(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.geography_columns.f_geography_column</code>.
	 */
	public java.lang.String getFGeographyColumn() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>public.geography_columns.coord_dimension</code>.
	 */
	public void setCoordDimension(java.lang.Integer value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.geography_columns.coord_dimension</code>.
	 */
	public java.lang.Integer getCoordDimension() {
		return (java.lang.Integer) getValue(4);
	}

	/**
	 * Setter for <code>public.geography_columns.srid</code>.
	 */
	public void setSrid(java.lang.Integer value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.geography_columns.srid</code>.
	 */
	public java.lang.Integer getSrid() {
		return (java.lang.Integer) getValue(5);
	}

	/**
	 * Setter for <code>public.geography_columns.type</code>.
	 */
	public void setType(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.geography_columns.type</code>.
	 */
	public java.lang.String getType() {
		return (java.lang.String) getValue(6);
	}

	// -------------------------------------------------------------------------
	// Record7 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String> fieldsRow() {
		return (org.jooq.Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String> valuesRow() {
		return (org.jooq.Row7) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field1() {
		return us.fok.lenzenslijper.models.jooq.tables.GeographyColumns.GEOGRAPHY_COLUMNS.F_TABLE_CATALOG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return us.fok.lenzenslijper.models.jooq.tables.GeographyColumns.GEOGRAPHY_COLUMNS.F_TABLE_SCHEMA;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return us.fok.lenzenslijper.models.jooq.tables.GeographyColumns.GEOGRAPHY_COLUMNS.F_TABLE_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return us.fok.lenzenslijper.models.jooq.tables.GeographyColumns.GEOGRAPHY_COLUMNS.F_GEOGRAPHY_COLUMN;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field5() {
		return us.fok.lenzenslijper.models.jooq.tables.GeographyColumns.GEOGRAPHY_COLUMNS.COORD_DIMENSION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field6() {
		return us.fok.lenzenslijper.models.jooq.tables.GeographyColumns.GEOGRAPHY_COLUMNS.SRID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field7() {
		return us.fok.lenzenslijper.models.jooq.tables.GeographyColumns.GEOGRAPHY_COLUMNS.TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value1() {
		return getFTableCatalog();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getFTableSchema();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getFTableName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getFGeographyColumn();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value5() {
		return getCoordDimension();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value6() {
		return getSrid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value7() {
		return getType();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GeographyColumnsRecord value1(java.lang.String value) {
		setFTableCatalog(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GeographyColumnsRecord value2(java.lang.String value) {
		setFTableSchema(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GeographyColumnsRecord value3(java.lang.String value) {
		setFTableName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GeographyColumnsRecord value4(java.lang.String value) {
		setFGeographyColumn(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GeographyColumnsRecord value5(java.lang.Integer value) {
		setCoordDimension(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GeographyColumnsRecord value6(java.lang.Integer value) {
		setSrid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GeographyColumnsRecord value7(java.lang.String value) {
		setType(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GeographyColumnsRecord values(java.lang.String value1, java.lang.String value2, java.lang.String value3, java.lang.String value4, java.lang.Integer value5, java.lang.Integer value6, java.lang.String value7) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached GeographyColumnsRecord
	 */
	public GeographyColumnsRecord() {
		super(us.fok.lenzenslijper.models.jooq.tables.GeographyColumns.GEOGRAPHY_COLUMNS);
	}

	/**
	 * Create a detached, initialised GeographyColumnsRecord
	 */
	public GeographyColumnsRecord(java.lang.String fTableCatalog, java.lang.String fTableSchema, java.lang.String fTableName, java.lang.String fGeographyColumn, java.lang.Integer coordDimension, java.lang.Integer srid, java.lang.String type) {
		super(us.fok.lenzenslijper.models.jooq.tables.GeographyColumns.GEOGRAPHY_COLUMNS);

		setValue(0, fTableCatalog);
		setValue(1, fTableSchema);
		setValue(2, fTableName);
		setValue(3, fGeographyColumn);
		setValue(4, coordDimension);
		setValue(5, srid);
		setValue(6, type);
	}
}