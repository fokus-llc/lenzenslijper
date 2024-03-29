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
public class _DropRasterConstraint extends org.jooq.impl.AbstractRoutine<java.lang.Boolean> {

	private static final long serialVersionUID = -1416118165;

	/**
	 * The parameter <code>public._drop_raster_constraint.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Boolean> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.BOOLEAN);

	/**
	 * The parameter <code>public._drop_raster_constraint.rastschema</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RASTSCHEMA = createParameter("rastschema", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public._drop_raster_constraint.rasttable</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RASTTABLE = createParameter("rasttable", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public._drop_raster_constraint.cn</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> CN = createParameter("cn", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * Create a new routine call instance
	 */
	public _DropRasterConstraint() {
		super("_drop_raster_constraint", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BOOLEAN);

		setReturnParameter(RETURN_VALUE);
		addInParameter(RASTSCHEMA);
		addInParameter(RASTTABLE);
		addInParameter(CN);
	}

	/**
	 * Set the <code>rastschema</code> parameter IN value to the routine
	 */
	public void setRastschema(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines._DropRasterConstraint.RASTSCHEMA, value);
	}

	/**
	 * Set the <code>rastschema</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setRastschema(org.jooq.Field<java.lang.String> field) {
		setField(RASTSCHEMA, field);
	}

	/**
	 * Set the <code>rasttable</code> parameter IN value to the routine
	 */
	public void setRasttable(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines._DropRasterConstraint.RASTTABLE, value);
	}

	/**
	 * Set the <code>rasttable</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setRasttable(org.jooq.Field<java.lang.String> field) {
		setField(RASTTABLE, field);
	}

	/**
	 * Set the <code>cn</code> parameter IN value to the routine
	 */
	public void setCn(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines._DropRasterConstraint.CN, value);
	}

	/**
	 * Set the <code>cn</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setCn(org.jooq.Field<java.lang.String> field) {
		setField(CN, field);
	}
}
