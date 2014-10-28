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
public class Dropgeometrytable2 extends org.jooq.impl.AbstractRoutine<java.lang.String> {

	private static final long serialVersionUID = -636378414;

	/**
	 * The parameter <code>public.dropgeometrytable.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.CLOB);

	/**
	 * The parameter <code>public.dropgeometrytable.schema_name</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> SCHEMA_NAME = createParameter("schema_name", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public.dropgeometrytable.table_name</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> TABLE_NAME = createParameter("table_name", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * Create a new routine call instance
	 */
	public Dropgeometrytable2() {
		super("dropgeometrytable", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.CLOB);

		setReturnParameter(RETURN_VALUE);
		addInParameter(SCHEMA_NAME);
		addInParameter(TABLE_NAME);
		setOverloaded(true);
	}

	/**
	 * Set the <code>schema_name</code> parameter IN value to the routine
	 */
	public void setSchemaName(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Dropgeometrytable2.SCHEMA_NAME, value);
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
		setValue(us.fok.lenzenslijper.models.jooq.routines.Dropgeometrytable2.TABLE_NAME, value);
	}

	/**
	 * Set the <code>table_name</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setTableName(org.jooq.Field<java.lang.String> field) {
		setField(TABLE_NAME, field);
	}
}
