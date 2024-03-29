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
public class PostgisTransformGeometry extends org.jooq.impl.AbstractRoutine<java.lang.Object> {

	private static final long serialVersionUID = 199180622;

	/**
	 * The parameter <code>public.postgis_transform_geometry.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Object> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"));

	/**
	 * The parameter <code>public.postgis_transform_geometry._1</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Object> _1 = createParameter("_1", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"));

	/**
	 * The parameter <code>public.postgis_transform_geometry._2</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> _2 = createParameter("_2", org.jooq.impl.SQLDataType.CLOB);

	/**
	 * The parameter <code>public.postgis_transform_geometry._3</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> _3 = createParameter("_3", org.jooq.impl.SQLDataType.CLOB);

	/**
	 * The parameter <code>public.postgis_transform_geometry._4</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Integer> _4 = createParameter("_4", org.jooq.impl.SQLDataType.INTEGER);

	/**
	 * Create a new routine call instance
	 */
	public PostgisTransformGeometry() {
		super("postgis_transform_geometry", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"));

		setReturnParameter(RETURN_VALUE);
		addInParameter(_1);
		addInParameter(_2);
		addInParameter(_3);
		addInParameter(_4);
	}

	/**
	 * Set the <code>_1</code> parameter IN value to the routine
	 */
	public void set__1(java.lang.Object value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.PostgisTransformGeometry._1, value);
	}

	/**
	 * Set the <code>_1</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void set__1(org.jooq.Field<java.lang.Object> field) {
		setField(_1, field);
	}

	/**
	 * Set the <code>_2</code> parameter IN value to the routine
	 */
	public void set__2(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.PostgisTransformGeometry._2, value);
	}

	/**
	 * Set the <code>_2</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void set__2(org.jooq.Field<java.lang.String> field) {
		setField(_2, field);
	}

	/**
	 * Set the <code>_3</code> parameter IN value to the routine
	 */
	public void set__3(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.PostgisTransformGeometry._3, value);
	}

	/**
	 * Set the <code>_3</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void set__3(org.jooq.Field<java.lang.String> field) {
		setField(_3, field);
	}

	/**
	 * Set the <code>_4</code> parameter IN value to the routine
	 */
	public void set__4(java.lang.Integer value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.PostgisTransformGeometry._4, value);
	}

	/**
	 * Set the <code>_4</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void set__4(org.jooq.Field<java.lang.Integer> field) {
		setField(_4, field);
	}
}
