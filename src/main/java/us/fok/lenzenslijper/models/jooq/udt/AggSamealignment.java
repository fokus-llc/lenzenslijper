/**
 * This class is generated by jOOQ
 */
package us.fok.lenzenslijper.models.jooq.udt;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AggSamealignment extends org.jooq.impl.UDTImpl<us.fok.lenzenslijper.models.jooq.udt.records.AggSamealignmentRecord> {

	private static final long serialVersionUID = 1807572495;

	/**
	 * The singleton instance of <code>public.agg_samealignment</code>
	 */
	public static final us.fok.lenzenslijper.models.jooq.udt.AggSamealignment AGG_SAMEALIGNMENT = new us.fok.lenzenslijper.models.jooq.udt.AggSamealignment();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<us.fok.lenzenslijper.models.jooq.udt.records.AggSamealignmentRecord> getRecordType() {
		return us.fok.lenzenslijper.models.jooq.udt.records.AggSamealignmentRecord.class;
	}

	/**
	 * The attribute <code>public.agg_samealignment.refraster</code>.
	 */
	public static final org.jooq.UDTField<us.fok.lenzenslijper.models.jooq.udt.records.AggSamealignmentRecord, java.lang.Object> REFRASTER = createField("refraster", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"), AGG_SAMEALIGNMENT);

	/**
	 * The attribute <code>public.agg_samealignment.aligned</code>.
	 */
	public static final org.jooq.UDTField<us.fok.lenzenslijper.models.jooq.udt.records.AggSamealignmentRecord, java.lang.Boolean> ALIGNED = createField("aligned", org.jooq.impl.SQLDataType.BOOLEAN, AGG_SAMEALIGNMENT);

	/**
	 * No further instances allowed
	 */
	private AggSamealignment() {
		super("agg_samealignment", us.fok.lenzenslijper.models.jooq.Public.PUBLIC);

		// Initialise data type
		getDataType();
	}
}