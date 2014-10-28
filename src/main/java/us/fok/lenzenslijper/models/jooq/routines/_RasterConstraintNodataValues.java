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
public class _RasterConstraintNodataValues extends org.jooq.impl.AbstractRoutine<java.lang.Double[]> {

	private static final long serialVersionUID = 26567725;

	/**
	 * The parameter <code>public._raster_constraint_nodata_values.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Double[]> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.FLOAT.getArrayDataType());

	/**
	 * The parameter <code>public._raster_constraint_nodata_values.rast</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Object> RAST = createParameter("rast", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"));

	/**
	 * Create a new routine call instance
	 */
	public _RasterConstraintNodataValues() {
		super("_raster_constraint_nodata_values", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.FLOAT.getArrayDataType());

		setReturnParameter(RETURN_VALUE);
		addInParameter(RAST);
	}

	/**
	 * Set the <code>rast</code> parameter IN value to the routine
	 */
	public void setRast(java.lang.Object value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines._RasterConstraintNodataValues.RAST, value);
	}

	/**
	 * Set the <code>rast</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setRast(org.jooq.Field<java.lang.Object> field) {
		setField(RAST, field);
	}
}
