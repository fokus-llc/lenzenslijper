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
public class Droprasterconstraints2 extends org.jooq.impl.AbstractRoutine<java.lang.Boolean> {

	private static final long serialVersionUID = -1102703141;

	/**
	 * The parameter <code>public.droprasterconstraints.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Boolean> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.BOOLEAN);

	/**
	 * The parameter <code>public.droprasterconstraints.rasttable</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RASTTABLE = createParameter("rasttable", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public.droprasterconstraints.rastcolumn</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RASTCOLUMN = createParameter("rastcolumn", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public.droprasterconstraints.constraints</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String[]> CONSTRAINTS = createParameter("constraints", org.jooq.impl.SQLDataType.CLOB.getArrayDataType());

	/**
	 * Create a new routine call instance
	 */
	public Droprasterconstraints2() {
		super("droprasterconstraints", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BOOLEAN);

		setReturnParameter(RETURN_VALUE);
		addInParameter(RASTTABLE);
		addInParameter(RASTCOLUMN);
		addInParameter(CONSTRAINTS);
		setOverloaded(true);
	}

	/**
	 * Set the <code>rasttable</code> parameter IN value to the routine
	 */
	public void setRasttable(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Droprasterconstraints2.RASTTABLE, value);
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
		setValue(us.fok.lenzenslijper.models.jooq.routines.Droprasterconstraints2.RASTCOLUMN, value);
	}

	/**
	 * Set the <code>rastcolumn</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setRastcolumn(org.jooq.Field<java.lang.String> field) {
		setField(RASTCOLUMN, field);
	}

	/**
	 * Set the <code>constraints</code> parameter IN value to the routine
	 */
	public void setConstraints(java.lang.String[] value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Droprasterconstraints2.CONSTRAINTS, value);
	}

	/**
	 * Set the <code>constraints</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setConstraints(org.jooq.Field<java.lang.String[]> field) {
		setField(CONSTRAINTS, field);
	}
}
