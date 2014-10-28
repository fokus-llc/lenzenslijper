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
public class GeometryDump extends org.jooq.impl.UDTImpl<us.fok.lenzenslijper.models.jooq.udt.records.GeometryDumpRecord> {

	private static final long serialVersionUID = 1975063724;

	/**
	 * The singleton instance of <code>public.geometry_dump</code>
	 */
	public static final us.fok.lenzenslijper.models.jooq.udt.GeometryDump GEOMETRY_DUMP = new us.fok.lenzenslijper.models.jooq.udt.GeometryDump();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<us.fok.lenzenslijper.models.jooq.udt.records.GeometryDumpRecord> getRecordType() {
		return us.fok.lenzenslijper.models.jooq.udt.records.GeometryDumpRecord.class;
	}

	/**
	 * The attribute <code>public.geometry_dump.path</code>.
	 */
	public static final org.jooq.UDTField<us.fok.lenzenslijper.models.jooq.udt.records.GeometryDumpRecord, java.lang.Integer[]> PATH = createField("path", org.jooq.impl.SQLDataType.INTEGER.getArrayDataType(), GEOMETRY_DUMP);

	/**
	 * The attribute <code>public.geometry_dump.geom</code>.
	 */
	public static final org.jooq.UDTField<us.fok.lenzenslijper.models.jooq.udt.records.GeometryDumpRecord, java.lang.Object> GEOM = createField("geom", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"), GEOMETRY_DUMP);

	/**
	 * No further instances allowed
	 */
	private GeometryDump() {
		super("geometry_dump", us.fok.lenzenslijper.models.jooq.Public.PUBLIC);

		// Initialise data type
		getDataType();
	}
}
