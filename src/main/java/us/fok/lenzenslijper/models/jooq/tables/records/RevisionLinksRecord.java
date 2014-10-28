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
public class RevisionLinksRecord extends org.jooq.impl.UpdatableRecordImpl<us.fok.lenzenslijper.models.jooq.tables.records.RevisionLinksRecord> implements org.jooq.Record11<java.util.UUID, java.lang.Integer, java.lang.String, java.util.UUID, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp> {

	private static final long serialVersionUID = -1204021908;

	/**
	 * Setter for <code>public.revision_links.revision_id</code>.
	 */
	public void setRevisionId(java.util.UUID value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.revision_links.revision_id</code>.
	 */
	public java.util.UUID getRevisionId() {
		return (java.util.UUID) getValue(0);
	}

	/**
	 * Setter for <code>public.revision_links.link_type_id</code>.
	 */
	public void setLinkTypeId(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.revision_links.link_type_id</code>.
	 */
	public java.lang.Integer getLinkTypeId() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>public.revision_links.target_title</code>.
	 */
	public void setTargetTitle(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.revision_links.target_title</code>.
	 */
	public java.lang.String getTargetTitle() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>public.revision_links.target_linkable_id</code>.
	 */
	public void setTargetLinkableId(java.util.UUID value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.revision_links.target_linkable_id</code>.
	 */
	public java.util.UUID getTargetLinkableId() {
		return (java.util.UUID) getValue(3);
	}

	/**
	 * Setter for <code>public.revision_links.target_value</code>.
	 */
	public void setTargetValue(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.revision_links.target_value</code>.
	 */
	public java.lang.String getTargetValue() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>public.revision_links.rank</code>.
	 */
	public void setRank(java.lang.Integer value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.revision_links.rank</code>.
	 */
	public java.lang.Integer getRank() {
		return (java.lang.Integer) getValue(5);
	}

	/**
	 * Setter for <code>public.revision_links.time_range</code>.
	 */
	public void setTimeRange(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.revision_links.time_range</code>.
	 */
	public java.lang.String getTimeRange() {
		return (java.lang.String) getValue(6);
	}

	/**
	 * Setter for <code>public.revision_links.beginning</code>.
	 */
	public void setBeginning(java.lang.Long value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>public.revision_links.beginning</code>.
	 */
	public java.lang.Long getBeginning() {
		return (java.lang.Long) getValue(7);
	}

	/**
	 * Setter for <code>public.revision_links.ending</code>.
	 */
	public void setEnding(java.lang.Long value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>public.revision_links.ending</code>.
	 */
	public java.lang.Long getEnding() {
		return (java.lang.Long) getValue(8);
	}

	/**
	 * Setter for <code>public.revision_links.row_created</code>.
	 */
	public void setRowCreated(java.sql.Timestamp value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>public.revision_links.row_created</code>.
	 */
	public java.sql.Timestamp getRowCreated() {
		return (java.sql.Timestamp) getValue(9);
	}

	/**
	 * Setter for <code>public.revision_links.row_updated</code>.
	 */
	public void setRowUpdated(java.sql.Timestamp value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>public.revision_links.row_updated</code>.
	 */
	public java.sql.Timestamp getRowUpdated() {
		return (java.sql.Timestamp) getValue(10);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record3<java.util.UUID, java.lang.Integer, java.lang.String> key() {
		return (org.jooq.Record3) super.key();
	}

	// -------------------------------------------------------------------------
	// Record11 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row11<java.util.UUID, java.lang.Integer, java.lang.String, java.util.UUID, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row11) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row11<java.util.UUID, java.lang.Integer, java.lang.String, java.util.UUID, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row11) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field1() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionLinks.REVISION_LINKS.REVISION_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionLinks.REVISION_LINKS.LINK_TYPE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionLinks.REVISION_LINKS.TARGET_TITLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field4() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionLinks.REVISION_LINKS.TARGET_LINKABLE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionLinks.REVISION_LINKS.TARGET_VALUE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field6() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionLinks.REVISION_LINKS.RANK;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field7() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionLinks.REVISION_LINKS.TIME_RANGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field8() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionLinks.REVISION_LINKS.BEGINNING;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field9() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionLinks.REVISION_LINKS.ENDING;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field10() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionLinks.REVISION_LINKS.ROW_CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field11() {
		return us.fok.lenzenslijper.models.jooq.tables.RevisionLinks.REVISION_LINKS.ROW_UPDATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value1() {
		return getRevisionId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value2() {
		return getLinkTypeId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getTargetTitle();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value4() {
		return getTargetLinkableId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getTargetValue();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value6() {
		return getRank();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value7() {
		return getTimeRange();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value8() {
		return getBeginning();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value9() {
		return getEnding();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value10() {
		return getRowCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value11() {
		return getRowUpdated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionLinksRecord value1(java.util.UUID value) {
		setRevisionId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionLinksRecord value2(java.lang.Integer value) {
		setLinkTypeId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionLinksRecord value3(java.lang.String value) {
		setTargetTitle(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionLinksRecord value4(java.util.UUID value) {
		setTargetLinkableId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionLinksRecord value5(java.lang.String value) {
		setTargetValue(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionLinksRecord value6(java.lang.Integer value) {
		setRank(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionLinksRecord value7(java.lang.String value) {
		setTimeRange(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionLinksRecord value8(java.lang.Long value) {
		setBeginning(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionLinksRecord value9(java.lang.Long value) {
		setEnding(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionLinksRecord value10(java.sql.Timestamp value) {
		setRowCreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionLinksRecord value11(java.sql.Timestamp value) {
		setRowUpdated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RevisionLinksRecord values(java.util.UUID value1, java.lang.Integer value2, java.lang.String value3, java.util.UUID value4, java.lang.String value5, java.lang.Integer value6, java.lang.String value7, java.lang.Long value8, java.lang.Long value9, java.sql.Timestamp value10, java.sql.Timestamp value11) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached RevisionLinksRecord
	 */
	public RevisionLinksRecord() {
		super(us.fok.lenzenslijper.models.jooq.tables.RevisionLinks.REVISION_LINKS);
	}

	/**
	 * Create a detached, initialised RevisionLinksRecord
	 */
	public RevisionLinksRecord(java.util.UUID revisionId, java.lang.Integer linkTypeId, java.lang.String targetTitle, java.util.UUID targetLinkableId, java.lang.String targetValue, java.lang.Integer rank, java.lang.String timeRange, java.lang.Long beginning, java.lang.Long ending, java.sql.Timestamp rowCreated, java.sql.Timestamp rowUpdated) {
		super(us.fok.lenzenslijper.models.jooq.tables.RevisionLinks.REVISION_LINKS);

		setValue(0, revisionId);
		setValue(1, linkTypeId);
		setValue(2, targetTitle);
		setValue(3, targetLinkableId);
		setValue(4, targetValue);
		setValue(5, rank);
		setValue(6, timeRange);
		setValue(7, beginning);
		setValue(8, ending);
		setValue(9, rowCreated);
		setValue(10, rowUpdated);
	}
}
