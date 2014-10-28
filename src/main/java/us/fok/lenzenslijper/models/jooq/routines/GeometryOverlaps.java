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
public class GeometryOverlaps extends org.jooq.impl.AbstractRoutine<java.lang.Boolean> {

	private static final long serialVersionUID = -1487095921;

	/**
	 * The parameter <code>public.geometry_overlaps.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Boolean> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.BOOLEAN);

	/**
	 * The parameter <code>public.geometry_overlaps.geom1</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Object> GEOM1 = createParameter("geom1", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"));

	/**
	 * The parameter <code>public.geometry_overlaps.geom2</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Object> GEOM2 = createParameter("geom2", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"));

	/**
	 * Create a new routine call instance
	 */
	public GeometryOverlaps() {
		super("geometry_overlaps", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BOOLEAN);

		setReturnParameter(RETURN_VALUE);
		addInParameter(GEOM1);
		addInParameter(GEOM2);
	}

	/**
	 * Set the <code>geom1</code> parameter IN value to the routine
	 */
	public void setGeom1(java.lang.Object value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.GeometryOverlaps.GEOM1, value);
	}

	/**
	 * Set the <code>geom1</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setGeom1(org.jooq.Field<java.lang.Object> field) {
		setField(GEOM1, field);
	}

	/**
	 * Set the <code>geom2</code> parameter IN value to the routine
	 */
	public void setGeom2(java.lang.Object value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.GeometryOverlaps.GEOM2, value);
	}

	/**
	 * Set the <code>geom2</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setGeom2(org.jooq.Field<java.lang.Object> field) {
		setField(GEOM2, field);
	}
}
