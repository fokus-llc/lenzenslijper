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
public class PgisGeometryMakelineFinalfn extends org.jooq.impl.AbstractRoutine<java.lang.Object> {

	private static final long serialVersionUID = 481365719;

	/**
	 * The parameter <code>public.pgis_geometry_makeline_finalfn.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Object> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"));

	/**
	 * The parameter <code>public.pgis_geometry_makeline_finalfn._1</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Object> _1 = createParameter("_1", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"));

	/**
	 * Create a new routine call instance
	 */
	public PgisGeometryMakelineFinalfn() {
		super("pgis_geometry_makeline_finalfn", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"));

		setReturnParameter(RETURN_VALUE);
		addInParameter(_1);
	}

	/**
	 * Set the <code>_1</code> parameter IN value to the routine
	 */
	public void set__1(java.lang.Object value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.PgisGeometryMakelineFinalfn._1, value);
	}

	/**
	 * Set the <code>_1</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void set__1(org.jooq.Field<java.lang.Object> field) {
		setField(_1, field);
	}
}
