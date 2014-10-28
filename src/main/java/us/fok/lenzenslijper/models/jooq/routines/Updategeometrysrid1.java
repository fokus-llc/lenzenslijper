/**
 * This class is generated by jOOQ
 */
package us.fok.lenzenslijper.models.jooq.routines;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Updategeometrysrid1 extends org.jooq.impl.AbstractRoutine<java.lang.String> {

	private static final long serialVersionUID = 372750655;

	/**
	 * The parameter <code>public.updategeometrysrid.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.CLOB);

	/**
	 * The parameter <code>public.updategeometrysrid.catalogn_name</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> CATALOGN_NAME = createParameter("catalogn_name", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public.updategeometrysrid.schema_name</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> SCHEMA_NAME = createParameter("schema_name", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public.updategeometrysrid.table_name</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> TABLE_NAME = createParameter("table_name", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public.updategeometrysrid.column_name</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> COLUMN_NAME = createParameter("column_name", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public.updategeometrysrid.new_srid_in</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Integer> NEW_SRID_IN = createParameter("new_srid_in", org.jooq.impl.SQLDataType.INTEGER);

	/**
	 * Create a new routine call instance
	 */
	public Updategeometrysrid1() {
		super("updategeometrysrid", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.CLOB);

		setReturnParameter(RETURN_VALUE);
		addInParameter(CATALOGN_NAME);
		addInParameter(SCHEMA_NAME);
		addInParameter(TABLE_NAME);
		addInParameter(COLUMN_NAME);
		addInParameter(NEW_SRID_IN);
		setOverloaded(true);
	}

	/**
	 * Set the <code>catalogn_name</code> parameter IN value to the routine
	 */
	public void setCatalognName(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Updategeometrysrid1.CATALOGN_NAME, value);
	}

	/**
	 * Set the <code>catalogn_name</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setCatalognName(org.jooq.Field<java.lang.String> field) {
		setField(CATALOGN_NAME, field);
	}

	/**
	 * Set the <code>schema_name</code> parameter IN value to the routine
	 */
	public void setSchemaName(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Updategeometrysrid1.SCHEMA_NAME, value);
	}

	/**
	 * Set the <code>schema_name</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setSchemaName(org.jooq.Field<java.lang.String> field) {
		setField(SCHEMA_NAME, field);
	}

	/**
	 * Set the <code>table_name</code> parameter IN value to the routine
	 */
	public void setTableName(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Updategeometrysrid1.TABLE_NAME, value);
	}

	/**
	 * Set the <code>table_name</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setTableName(org.jooq.Field<java.lang.String> field) {
		setField(TABLE_NAME, field);
	}

	/**
	 * Set the <code>column_name</code> parameter IN value to the routine
	 */
	public void setColumnName(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Updategeometrysrid1.COLUMN_NAME, value);
	}

	/**
	 * Set the <code>column_name</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setColumnName(org.jooq.Field<java.lang.String> field) {
		setField(COLUMN_NAME, field);
	}

	/**
	 * Set the <code>new_srid_in</code> parameter IN value to the routine
	 */
	public void setNewSridIn(java.lang.Integer value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Updategeometrysrid1.NEW_SRID_IN, value);
	}

	/**
	 * Set the <code>new_srid_in</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setNewSridIn(org.jooq.Field<java.lang.Integer> field) {
		setField(NEW_SRID_IN, field);
	}
}