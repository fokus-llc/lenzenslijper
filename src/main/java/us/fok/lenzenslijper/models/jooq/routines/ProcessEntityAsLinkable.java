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
public class ProcessEntityAsLinkable extends org.jooq.impl.AbstractRoutine<java.lang.Object> {

	private static final long serialVersionUID = 1345693485;

	/**
	 * The parameter <code>public.process_entity_as_linkable.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Object> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.DefaultDataType.getDefaultDataType("trigger"));

	/**
	 * Create a new routine call instance
	 */
	public ProcessEntityAsLinkable() {
		super("process_entity_as_linkable", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.DefaultDataType.getDefaultDataType("trigger"));

		setReturnParameter(RETURN_VALUE);
	}
}
