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
public class PostgisLibxmlVersion extends org.jooq.impl.AbstractRoutine<java.lang.String> {

	private static final long serialVersionUID = 1539642063;

	/**
	 * The parameter <code>public.postgis_libxml_version.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.CLOB);

	/**
	 * Create a new routine call instance
	 */
	public PostgisLibxmlVersion() {
		super("postgis_libxml_version", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.CLOB);

		setReturnParameter(RETURN_VALUE);
	}
}
