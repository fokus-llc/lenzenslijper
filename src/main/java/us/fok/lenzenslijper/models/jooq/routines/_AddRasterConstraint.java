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
public class _AddRasterConstraint extends org.jooq.impl.AbstractRoutine<java.lang.Boolean> {

	private static final long serialVersionUID = 365738212;

	/**
	 * The parameter <code>public._add_raster_constraint.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Boolean> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.BOOLEAN);

	/**
	 * The parameter <code>public._add_raster_constraint.cn</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> CN = createParameter("cn", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public._add_raster_constraint.sql</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> SQL = createParameter("sql", org.jooq.impl.SQLDataType.CLOB);

	/**
	 * Create a new routine call instance
	 */
	public _AddRasterConstraint() {
		super("_add_raster_constraint", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BOOLEAN);

		setReturnParameter(RETURN_VALUE);
		addInParameter(CN);
		addInParameter(SQL);
	}

	/**
	 * Set the <code>cn</code> parameter IN value to the routine
	 */
	public void setCn(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines._AddRasterConstraint.CN, value);
	}

	/**
	 * Set the <code>cn</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setCn(org.jooq.Field<java.lang.String> field) {
		setField(CN, field);
	}

	/**
	 * Set the <code>sql</code> parameter IN value to the routine
	 */
	public void setSql(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines._AddRasterConstraint.SQL, value);
	}

	/**
	 * Set the <code>sql</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setSql(org.jooq.Field<java.lang.String> field) {
		setField(SQL, field);
	}
}
