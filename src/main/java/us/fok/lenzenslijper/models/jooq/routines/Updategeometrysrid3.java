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
public class Updategeometrysrid3 extends org.jooq.impl.AbstractRoutine<java.lang.String> {

	private static final long serialVersionUID = 1900277727;

	/**
	 * The parameter <code>public.updategeometrysrid.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.CLOB);

	/**
	 * The parameter <code>public.updategeometrysrid._1</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> _1 = createParameter("_1", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public.updategeometrysrid._2</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> _2 = createParameter("_2", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public.updategeometrysrid._3</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Integer> _3 = createParameter("_3", org.jooq.impl.SQLDataType.INTEGER);

	/**
	 * Create a new routine call instance
	 */
	public Updategeometrysrid3() {
		super("updategeometrysrid", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.CLOB);

		setReturnParameter(RETURN_VALUE);
		addInParameter(_1);
		addInParameter(_2);
		addInParameter(_3);
		setOverloaded(true);
	}

	/**
	 * Set the <code>_1</code> parameter IN value to the routine
	 */
	public void set__1(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Updategeometrysrid3._1, value);
	}

	/**
	 * Set the <code>_1</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void set__1(org.jooq.Field<java.lang.String> field) {
		setField(_1, field);
	}

	/**
	 * Set the <code>_2</code> parameter IN value to the routine
	 */
	public void set__2(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Updategeometrysrid3._2, value);
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
	public void set__3(java.lang.Integer value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Updategeometrysrid3._3, value);
	}

	/**
	 * Set the <code>_3</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void set__3(org.jooq.Field<java.lang.Integer> field) {
		setField(_3, field);
	}
}
