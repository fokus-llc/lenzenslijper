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
public class UuidNil extends org.jooq.impl.AbstractRoutine<java.util.UUID> {

	private static final long serialVersionUID = 445980491;

	/**
	 * The parameter <code>public.uuid_nil.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.util.UUID> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.UUID);

	/**
	 * Create a new routine call instance
	 */
	public UuidNil() {
		super("uuid_nil", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.UUID);

		setReturnParameter(RETURN_VALUE);
	}
}
