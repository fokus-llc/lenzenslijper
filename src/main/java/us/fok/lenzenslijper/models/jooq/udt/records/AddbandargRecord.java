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
public class AddbandargRecord extends org.jooq.impl.UDTRecordImpl<us.fok.lenzenslijper.models.jooq.udt.records.AddbandargRecord> {

	private static final long serialVersionUID = -1807377580;


	/**
	 * Setter for <code>public.addbandarg.index</code>.
	 */
	public void setIndex(java.lang.Integer value) {
		setValue(us.fok.lenzenslijper.models.jooq.udt.Addbandarg.INDEX, value);
	}

	/**
	 * Getter for <code>public.addbandarg.index</code>.
	 */
	public java.lang.Integer getIndex() {
		return getValue(us.fok.lenzenslijper.models.jooq.udt.Addbandarg.INDEX);
	}

	/**
	 * Setter for <code>public.addbandarg.pixeltype</code>.
	 */
	public void setPixeltype(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.udt.Addbandarg.PIXELTYPE, value);
	}

	/**
	 * Getter for <code>public.addbandarg.pixeltype</code>.
	 */
	public java.lang.String getPixeltype() {
		return getValue(us.fok.lenzenslijper.models.jooq.udt.Addbandarg.PIXELTYPE);
	}

	/**
	 * Setter for <code>public.addbandarg.initialvalue</code>.
	 */
	public void setInitialvalue(java.lang.Double value) {
		setValue(us.fok.lenzenslijper.models.jooq.udt.Addbandarg.INITIALVALUE, value);
	}

	/**
	 * Getter for <code>public.addbandarg.initialvalue</code>.
	 */
	public java.lang.Double getInitialvalue() {
		return getValue(us.fok.lenzenslijper.models.jooq.udt.Addbandarg.INITIALVALUE);
	}

	/**
	 * Setter for <code>public.addbandarg.nodataval</code>.
	 */
	public void setNodataval(java.lang.Double value) {
		setValue(us.fok.lenzenslijper.models.jooq.udt.Addbandarg.NODATAVAL, value);
	}

	/**
	 * Getter for <code>public.addbandarg.nodataval</code>.
	 */
	public java.lang.Double getNodataval() {
		return getValue(us.fok.lenzenslijper.models.jooq.udt.Addbandarg.NODATAVAL);
	}

	/**
	 * Create a new <code>public.addbandarg</code> record
	 */
	public AddbandargRecord() {
		super(us.fok.lenzenslijper.models.jooq.udt.Addbandarg.ADDBANDARG);
	}
}
