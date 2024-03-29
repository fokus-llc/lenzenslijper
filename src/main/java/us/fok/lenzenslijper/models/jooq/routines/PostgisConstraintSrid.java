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
public class PostgisConstraintSrid extends org.jooq.impl.AbstractRoutine<java.lang.Integer> {

	private static final long serialVersionUID = 1588468606;

	/**
	 * The parameter <code>public.postgis_constraint_srid.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Integer> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.INTEGER);

	/**
	 * The parameter <code>public.postgis_constraint_srid.geomschema</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> GEOMSCHEMA = createParameter("geomschema", org.jooq.impl.SQLDataType.CLOB);

	/**
	 * The parameter <code>public.postgis_constraint_srid.geomtable</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> GEOMTABLE = createParameter("geomtable", org.jooq.impl.SQLDataType.CLOB);

	/**
	 * The parameter <code>public.postgis_constraint_srid.geomcolumn</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> GEOMCOLUMN = createParameter("geomcolumn", org.jooq.impl.SQLDataType.CLOB);

	/**
	 * Create a new routine call instance
	 */
	public PostgisConstraintSrid() {
		super("postgis_constraint_srid", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER);

		setReturnParameter(RETURN_VALUE);
		addInParameter(GEOMSCHEMA);
		addInParameter(GEOMTABLE);
		addInParameter(GEOMCOLUMN);
	}

	/**
	 * Set the <code>geomschema</code> parameter IN value to the routine
	 */
	public void setGeomschema(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.PostgisConstraintSrid.GEOMSCHEMA, value);
	}

	/**
	 * Set the <code>geomschema</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setGeomschema(org.jooq.Field<java.lang.String> field) {
		setField(GEOMSCHEMA, field);
	}

	/**
	 * Set the <code>geomtable</code> parameter IN value to the routine
	 */
	public void setGeomtable(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.PostgisConstraintSrid.GEOMTABLE, value);
	}

	/**
	 * Set the <code>geomtable</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setGeomtable(org.jooq.Field<java.lang.String> field) {
		setField(GEOMTABLE, field);
	}

	/**
	 * Set the <code>geomcolumn</code> parameter IN value to the routine
	 */
	public void setGeomcolumn(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.PostgisConstraintSrid.GEOMCOLUMN, value);
	}

	/**
	 * Set the <code>geomcolumn</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setGeomcolumn(org.jooq.Field<java.lang.String> field) {
		setField(GEOMCOLUMN, field);
	}
}
