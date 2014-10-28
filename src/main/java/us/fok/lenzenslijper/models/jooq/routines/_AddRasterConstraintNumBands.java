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
public class _AddRasterConstraintNumBands extends org.jooq.impl.AbstractRoutine<java.lang.Boolean> {

	private static final long serialVersionUID = -1288131543;

	/**
	 * The parameter <code>public._add_raster_constraint_num_bands.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Boolean> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.BOOLEAN);

	/**
	 * The parameter <code>public._add_raster_constraint_num_bands.rastschema</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RASTSCHEMA = createParameter("rastschema", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public._add_raster_constraint_num_bands.rasttable</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RASTTABLE = createParameter("rasttable", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public._add_raster_constraint_num_bands.rastcolumn</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RASTCOLUMN = createParameter("rastcolumn", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * Create a new routine call instance
	 */
	public _AddRasterConstraintNumBands() {
		super("_add_raster_constraint_num_bands", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BOOLEAN);

		setReturnParameter(RETURN_VALUE);
		addInParameter(RASTSCHEMA);
		addInParameter(RASTTABLE);
		addInParameter(RASTCOLUMN);
	}

	/**
	 * Set the <code>rastschema</code> parameter IN value to the routine
	 */
	public void setRastschema(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines._AddRasterConstraintNumBands.RASTSCHEMA, value);
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
		setValue(us.fok.lenzenslijper.models.jooq.routines._AddRasterConstraintNumBands.RASTTABLE, value);
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
		setValue(us.fok.lenzenslijper.models.jooq.routines._AddRasterConstraintNumBands.RASTCOLUMN, value);
	}

	/**
	 * Set the <code>rastcolumn</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setRastcolumn(org.jooq.Field<java.lang.String> field) {
		setField(RASTCOLUMN, field);
	}
}
