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
public class ValidDetailRecord extends org.jooq.impl.UDTRecordImpl<us.fok.lenzenslijper.models.jooq.udt.records.ValidDetailRecord> {

	private static final long serialVersionUID = -380288790;


	/**
	 * Setter for <code>public.valid_detail.valid</code>.
	 */
	public void setValid(java.lang.Boolean value) {
		setValue(us.fok.lenzenslijper.models.jooq.udt.ValidDetail.VALID, value);
	}

	/**
	 * Getter for <code>public.valid_detail.valid</code>.
	 */
	public java.lang.Boolean getValid() {
		return getValue(us.fok.lenzenslijper.models.jooq.udt.ValidDetail.VALID);
	}

	/**
	 * Setter for <code>public.valid_detail.reason</code>.
	 */
	public void setReason(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.udt.ValidDetail.REASON, value);
	}

	/**
	 * Getter for <code>public.valid_detail.reason</code>.
	 */
	public java.lang.String getReason() {
		return getValue(us.fok.lenzenslijper.models.jooq.udt.ValidDetail.REASON);
	}

	/**
	 * Setter for <code>public.valid_detail.location</code>.
	 */
	public void setLocation(java.lang.Object value) {
		setValue(us.fok.lenzenslijper.models.jooq.udt.ValidDetail.LOCATION, value);
	}

	/**
	 * Getter for <code>public.valid_detail.location</code>.
	 */
	public java.lang.Object getLocation() {
		return getValue(us.fok.lenzenslijper.models.jooq.udt.ValidDetail.LOCATION);
	}

	/**
	 * Create a new <code>public.valid_detail</code> record
	 */
	public ValidDetailRecord() {
		super(us.fok.lenzenslijper.models.jooq.udt.ValidDetail.VALID_DETAIL);
	}
}
