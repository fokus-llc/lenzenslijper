/**
 * This class is generated by jOOQ
 */
package us.fok.lenzenslijper.models.jooq.udt.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GeometryDumpRecord extends org.jooq.impl.UDTRecordImpl<us.fok.lenzenslijper.models.jooq.udt.records.GeometryDumpRecord> {

	private static final long serialVersionUID = -907438092;


	/**
	 * Setter for <code>public.geometry_dump.path</code>.
	 */
	public void setPath(java.lang.Integer[] value) {
		setValue(us.fok.lenzenslijper.models.jooq.udt.GeometryDump.PATH, value);
	}

	/**
	 * Getter for <code>public.geometry_dump.path</code>.
	 */
	public java.lang.Integer[] getPath() {
		return getValue(us.fok.lenzenslijper.models.jooq.udt.GeometryDump.PATH);
	}

	/**
	 * Setter for <code>public.geometry_dump.geom</code>.
	 */
	public void setGeom(java.lang.Object value) {
		setValue(us.fok.lenzenslijper.models.jooq.udt.GeometryDump.GEOM, value);
	}

	/**
	 * Getter for <code>public.geometry_dump.geom</code>.
	 */
	public java.lang.Object getGeom() {
		return getValue(us.fok.lenzenslijper.models.jooq.udt.GeometryDump.GEOM);
	}

	/**
	 * Create a new <code>public.geometry_dump</code> record
	 */
	public GeometryDumpRecord() {
		super(us.fok.lenzenslijper.models.jooq.udt.GeometryDump.GEOMETRY_DUMP);
	}
}
