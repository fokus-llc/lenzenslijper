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
public class _DropRasterConstraintScale extends org.jooq.impl.AbstractRoutine<java.lang.Boolean> {

	private static final long serialVersionUID = 2026314094;

	/**
	 * The parameter <code>public._drop_raster_constraint_scale.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Boolean> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.BOOLEAN);

	/**
	 * The parameter <code>public._drop_raster_constraint_scale.rastschema</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RASTSCHEMA = createParameter("rastschema", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public._drop_raster_constraint_scale.rasttable</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RASTTABLE = createParameter("rasttable", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public._drop_raster_constraint_scale.rastcolumn</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RASTCOLUMN = createParameter("rastcolumn", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public._drop_raster_constraint_scale.axis</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> AXIS = createParameter("axis", org.jooq.impl.SQLDataType.CHAR);

	/**
	 * Create a new routine call instance
	 */
	public _DropRasterConstraintScale() {
		super("_drop_raster_constraint_scale", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BOOLEAN);

		setReturnParameter(RETURN_VALUE);
		addInParameter(RASTSCHEMA);
		addInParameter(RASTTABLE);
		addInParameter(RASTCOLUMN);
		addInParameter(AXIS);
	}

	/**
	 * Set the <code>rastschema</code> parameter IN value to the routine
	 */
	public void setRastschema(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines._DropRasterConstraintScale.RASTSCHEMA, value);
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
		setValue(us.fok.lenzenslijper.models.jooq.routines._DropRasterConstraintScale.RASTTABLE, value);
	}

	/**
	 * Set the <code>rasttable</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setRasttable(org.jooq.Field<java.lang.String> field) {
		setField(RASTTABLE, field);
	}

	/**
	 * Set the <code>rastcolumn</code> parameter IN value to the routine
	 */
	public void setRastcolumn(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines._DropRasterConstraintScale.RASTCOLUMN, value);
	}

	/**
	 * Set the <code>rastcolumn</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setRastcolumn(org.jooq.Field<java.lang.String> field) {
		setField(RASTCOLUMN, field);
	}

	/**
	 * Set the <code>axis</code> parameter IN value to the routine
	 */
	public void setAxis(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines._DropRasterConstraintScale.AXIS, value);
	}

	/**
	 * Set the <code>axis</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setAxis(org.jooq.Field<java.lang.String> field) {
		setField(AXIS, field);
	}
}
