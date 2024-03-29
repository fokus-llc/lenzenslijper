/**
 * This class is generated by jOOQ
 */
package us.fok.lenzenslijper.models.jooq.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LocationsRecord extends org.jooq.impl.UpdatableRecordImpl<us.fok.lenzenslijper.models.jooq.tables.records.LocationsRecord> implements org.jooq.Record3<java.util.UUID, java.lang.Object, java.sql.Timestamp> {

	private static final long serialVersionUID = 2060459220;

	/**
	 * Setter for <code>public.locations.location_id</code>.
	 */
	public void setLocationId(java.util.UUID value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.locations.location_id</code>.
	 */
	public java.util.UUID getLocationId() {
		return (java.util.UUID) getValue(0);
	}

	/**
	 * Setter for <code>public.locations.value</code>.
	 */
	public void setValue(java.lang.Object value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.locations.value</code>.
	 */
	public java.lang.Object getValue() {
		return (java.lang.Object) getValue(1);
	}

	/**
	 * Setter for <code>public.locations.row_created</code>.
	 */
	public void setRowCreated(java.sql.Timestamp value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.locations.row_created</code>.
	 */
	public java.sql.Timestamp getRowCreated() {
		return (java.sql.Timestamp) getValue(2);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.util.UUID> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.util.UUID, java.lang.Object, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.util.UUID, java.lang.Object, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field1() {
		return us.fok.lenzenslijper.models.jooq.tables.Locations.LOCATIONS.LOCATION_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Object> field2() {
		return us.fok.lenzenslijper.models.jooq.tables.Locations.LOCATIONS.VALUE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field3() {
		return us.fok.lenzenslijper.models.jooq.tables.Locations.LOCATIONS.ROW_CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value1() {
		return getLocationId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Object value2() {
		return getValue();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value3() {
		return getRowCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationsRecord value1(java.util.UUID value) {
		setLocationId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationsRecord value2(java.lang.Object value) {
		setValue(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationsRecord value3(java.sql.Timestamp value) {
		setRowCreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationsRecord values(java.util.UUID value1, java.lang.Object value2, java.sql.Timestamp value3) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached LocationsRecord
	 */
	public LocationsRecord() {
		super(us.fok.lenzenslijper.models.jooq.tables.Locations.LOCATIONS);
	}

	/**
	 * Create a detached, initialised LocationsRecord
	 */
	public LocationsRecord(java.util.UUID locationId, java.lang.Object value, java.sql.Timestamp rowCreated) {
		super(us.fok.lenzenslijper.models.jooq.tables.Locations.LOCATIONS);

		setValue(0, locationId);
		setValue(1, value);
		setValue(2, rowCreated);
	}
}
