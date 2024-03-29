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
public class UuidGenerateV3 extends org.jooq.impl.AbstractRoutine<java.util.UUID> {

	private static final long serialVersionUID = 709759006;

	/**
	 * The parameter <code>public.uuid_generate_v3.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.util.UUID> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.UUID);

	/**
	 * The parameter <code>public.uuid_generate_v3.namespace</code>.
	 */
	public static final org.jooq.Parameter<java.util.UUID> NAMESPACE = createParameter("namespace", org.jooq.impl.SQLDataType.UUID);

	/**
	 * The parameter <code>public.uuid_generate_v3.name</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> NAME = createParameter("name", org.jooq.impl.SQLDataType.CLOB);

	/**
	 * Create a new routine call instance
	 */
	public UuidGenerateV3() {
		super("uuid_generate_v3", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.UUID);

		setReturnParameter(RETURN_VALUE);
		addInParameter(NAMESPACE);
		addInParameter(NAME);
	}

	/**
	 * Set the <code>namespace</code> parameter IN value to the routine
	 */
	public void setNamespace(java.util.UUID value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.UuidGenerateV3.NAMESPACE, value);
	}

	/**
	 * Set the <code>namespace</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setNamespace(org.jooq.Field<java.util.UUID> field) {
		setField(NAMESPACE, field);
	}

	/**
	 * Set the <code>name</code> parameter IN value to the routine
	 */
	public void setName_(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.UuidGenerateV3.NAME, value);
	}

	/**
	 * Set the <code>name</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setName_(org.jooq.Field<java.lang.String> field) {
		setField(NAME, field);
	}
}
