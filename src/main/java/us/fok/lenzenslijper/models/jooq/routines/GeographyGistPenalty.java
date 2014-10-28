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
public class GeographyGistPenalty extends org.jooq.impl.AbstractRoutine<java.lang.Object> {

	private static final long serialVersionUID = -222153548;

	/**
	 * The parameter <code>public.geography_gist_penalty.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Object> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.DefaultDataType.getDefaultDataType("internal"));

	/**
	 * The parameter <code>public.geography_gist_penalty._1</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Object> _1 = createParameter("_1", org.jooq.impl.DefaultDataType.getDefaultDataType("internal"));

	/**
	 * The parameter <code>public.geography_gist_penalty._2</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Object> _2 = createParameter("_2", org.jooq.impl.DefaultDataType.getDefaultDataType("internal"));

	/**
	 * The parameter <code>public.geography_gist_penalty._3</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Object> _3 = createParameter("_3", org.jooq.impl.DefaultDataType.getDefaultDataType("internal"));

	/**
	 * Create a new routine call instance
	 */
	public GeographyGistPenalty() {
		super("geography_gist_penalty", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.DefaultDataType.getDefaultDataType("internal"));

		setReturnParameter(RETURN_VALUE);
		addInParameter(_1);
		addInParameter(_2);
		addInParameter(_3);
	}

	/**
	 * Set the <code>_1</code> parameter IN value to the routine
	 */
	public void set__1(java.lang.Object value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.GeographyGistPenalty._1, value);
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
	public void set__2(java.lang.Object value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.GeographyGistPenalty._2, value);
	}

	/**
	 * Set the <code>_2</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void set__2(org.jooq.Field<java.lang.Object> field) {
		setField(_2, field);
	}

	/**
	 * Set the <code>_3</code> parameter IN value to the routine
	 */
	public void set__3(java.lang.Object value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.GeographyGistPenalty._3, value);
	}

	/**
	 * Set the <code>_3</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void set__3(org.jooq.Field<java.lang.Object> field) {
		setField(_3, field);
	}
}
