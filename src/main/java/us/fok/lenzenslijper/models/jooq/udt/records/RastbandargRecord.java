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
public class RastbandargRecord extends org.jooq.impl.UDTRecordImpl<us.fok.lenzenslijper.models.jooq.udt.records.RastbandargRecord> {

	private static final long serialVersionUID = -1218364342;


	/**
	 * Setter for <code>public.rastbandarg.rast</code>.
	 */
	public void setRast(java.lang.Object value) {
		setValue(us.fok.lenzenslijper.models.jooq.udt.Rastbandarg.RAST, value);
	}

	/**
	 * Getter for <code>public.rastbandarg.rast</code>.
	 */
	public java.lang.Object getRast() {
		return getValue(us.fok.lenzenslijper.models.jooq.udt.Rastbandarg.RAST);
	}

	/**
	 * Setter for <code>public.rastbandarg.nband</code>.
	 */
	public void setNband(java.lang.Integer value) {
		setValue(us.fok.lenzenslijper.models.jooq.udt.Rastbandarg.NBAND, value);
	}

	/**
	 * Getter for <code>public.rastbandarg.nband</code>.
	 */
	public java.lang.Integer getNband() {
		return getValue(us.fok.lenzenslijper.models.jooq.udt.Rastbandarg.NBAND);
	}

	/**
	 * Create a new <code>public.rastbandarg</code> record
	 */
	public RastbandargRecord() {
		super(us.fok.lenzenslijper.models.jooq.udt.Rastbandarg.RASTBANDARG);
	}
}