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
public class RevisionSummary extends org.jooq.impl.UDTImpl<us.fok.lenzenslijper.models.jooq.udt.records.RevisionSummaryRecord> {

	private static final long serialVersionUID = 40649016;

	/**
	 * The singleton instance of <code>public.revision_summary</code>
	 */
	public static final us.fok.lenzenslijper.models.jooq.udt.RevisionSummary REVISION_SUMMARY = new us.fok.lenzenslijper.models.jooq.udt.RevisionSummary();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<us.fok.lenzenslijper.models.jooq.udt.records.RevisionSummaryRecord> getRecordType() {
		return us.fok.lenzenslijper.models.jooq.udt.records.RevisionSummaryRecord.class;
	}

	/**
	 * The attribute <code>public.revision_summary.revision_id</code>.
	 */
	public static final org.jooq.UDTField<us.fok.lenzenslijper.models.jooq.udt.records.RevisionSummaryRecord, java.util.UUID> REVISION_ID = createField("revision_id", org.jooq.impl.SQLDataType.UUID, REVISION_SUMMARY);

	/**
	 * The attribute <code>public.revision_summary.document_id</code>.
	 */
	public static final org.jooq.UDTField<us.fok.lenzenslijper.models.jooq.udt.records.RevisionSummaryRecord, java.util.UUID> DOCUMENT_ID = createField("document_id", org.jooq.impl.SQLDataType.UUID, REVISION_SUMMARY);

	/**
	 * The attribute <code>public.revision_summary.created</code>.
	 */
	public static final org.jooq.UDTField<us.fok.lenzenslijper.models.jooq.udt.records.RevisionSummaryRecord, java.lang.Object> CREATED = createField("created", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"), REVISION_SUMMARY);

	/**
	 * The attribute <code>public.revision_summary.user_id</code>.
	 */
	public static final org.jooq.UDTField<us.fok.lenzenslijper.models.jooq.udt.records.RevisionSummaryRecord, java.util.UUID> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.UUID, REVISION_SUMMARY);

	/**
	 * The attribute <code>public.revision_summary.document_type_id</code>.
	 */
	public static final org.jooq.UDTField<us.fok.lenzenslijper.models.jooq.udt.records.RevisionSummaryRecord, java.lang.Object> DOCUMENT_TYPE_ID = createField("document_type_id", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"), REVISION_SUMMARY);

	/**
	 * The attribute <code>public.revision_summary.project_id</code>.
	 */
	public static final org.jooq.UDTField<us.fok.lenzenslijper.models.jooq.udt.records.RevisionSummaryRecord, java.util.UUID> PROJECT_ID = createField("project_id", org.jooq.impl.SQLDataType.UUID, REVISION_SUMMARY);

	/**
	 * No further instances allowed
	 */
	private RevisionSummary() {
		super("revision_summary", us.fok.lenzenslijper.models.jooq.Public.PUBLIC);

		// Initialise data type
		getDataType();
	}
}