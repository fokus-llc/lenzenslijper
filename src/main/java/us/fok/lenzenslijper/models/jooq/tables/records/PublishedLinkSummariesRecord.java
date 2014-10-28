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
public class PublishedLinkSummariesRecord extends org.jooq.impl.UpdatableRecordImpl<us.fok.lenzenslijper.models.jooq.tables.records.PublishedLinkSummariesRecord> implements org.jooq.Record10<java.util.UUID, java.util.UUID, java.lang.Integer, java.lang.String, java.util.UUID, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Long, java.lang.Long> {

	private static final long serialVersionUID = -2047702560;

	/**
	 * Setter for <code>public.published_link_summaries.revision_id</code>.
	 */
	public void setRevisionId(java.util.UUID value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.published_link_summaries.revision_id</code>.
	 */
	public java.util.UUID getRevisionId() {
		return (java.util.UUID) getValue(0);
	}

	/**
	 * Setter for <code>public.published_link_summaries.document_id</code>.
	 */
	public void setDocumentId(java.util.UUID value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.published_link_summaries.document_id</code>.
	 */
	public java.util.UUID getDocumentId() {
		return (java.util.UUID) getValue(1);
	}

	/**
	 * Setter for <code>public.published_link_summaries.link_type_id</code>.
	 */
	public void setLinkTypeId(java.lang.Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.published_link_summaries.link_type_id</code>.
	 */
	public java.lang.Integer getLinkTypeId() {
		return (java.lang.Integer) getValue(2);
	}

	/**
	 * Setter for <code>public.published_link_summaries.target_title</code>.
	 */
	public void setTargetTitle(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.published_link_summaries.target_title</code>.
	 */
	public java.lang.String getTargetTitle() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>public.published_link_summaries.target_linkable_id</code>.
	 */
	public void setTargetLinkableId(java.util.UUID value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.published_link_summaries.target_linkable_id</code>.
	 */
	public java.util.UUID getTargetLinkableId() {
		return (java.util.UUID) getValue(4);
	}

	/**
	 * Setter for <code>public.published_link_summaries.time_range</code>.
	 */
	public void setTimeRange(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.published_link_summaries.time_range</code>.
	 */
	public java.lang.String getTimeRange() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>public.published_link_summaries.target_value</code>.
	 */
	public void setTargetValue(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.published_link_summaries.target_value</code>.
	 */
	public java.lang.String getTargetValue() {
		return (java.lang.String) getValue(6);
	}

	/**
	 * Setter for <code>public.published_link_summaries.rank</code>.
	 */
	public void setRank(java.lang.Integer value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>public.published_link_summaries.rank</code>.
	 */
	public java.lang.Integer getRank() {
		return (java.lang.Integer) getValue(7);
	}

	/**
	 * Setter for <code>public.published_link_summaries.beginning</code>.
	 */
	public void setBeginning(java.lang.Long value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>public.published_link_summaries.beginning</code>.
	 */
	public java.lang.Long getBeginning() {
		return (java.lang.Long) getValue(8);
	}

	/**
	 * Setter for <code>public.published_link_summaries.ending</code>.
	 */
	public void setEnding(java.lang.Long value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>public.published_link_summaries.ending</code>.
	 */
	public java.lang.Long getEnding() {
		return (java.lang.Long) getValue(9);
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
	// Record10 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row10<java.util.UUID, java.util.UUID, java.lang.Integer, java.lang.String, java.util.UUID, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Long, java.lang.Long> fieldsRow() {
		return (org.jooq.Row10) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row10<java.util.UUID, java.util.UUID, java.lang.Integer, java.lang.String, java.util.UUID, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Long, java.lang.Long> valuesRow() {
		return (org.jooq.Row10) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field1() {
		return us.fok.lenzenslijper.models.jooq.tables.PublishedLinkSummaries.PUBLISHED_LINK_SUMMARIES.REVISION_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field2() {
		return us.fok.lenzenslijper.models.jooq.tables.PublishedLinkSummaries.PUBLISHED_LINK_SUMMARIES.DOCUMENT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field3() {
		return us.fok.lenzenslijper.models.jooq.tables.PublishedLinkSummaries.PUBLISHED_LINK_SUMMARIES.LINK_TYPE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return us.fok.lenzenslijper.models.jooq.tables.PublishedLinkSummaries.PUBLISHED_LINK_SUMMARIES.TARGET_TITLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field5() {
		return us.fok.lenzenslijper.models.jooq.tables.PublishedLinkSummaries.PUBLISHED_LINK_SUMMARIES.TARGET_LINKABLE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return us.fok.lenzenslijper.models.jooq.tables.PublishedLinkSummaries.PUBLISHED_LINK_SUMMARIES.TIME_RANGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field7() {
		return us.fok.lenzenslijper.models.jooq.tables.PublishedLinkSummaries.PUBLISHED_LINK_SUMMARIES.TARGET_VALUE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field8() {
		return us.fok.lenzenslijper.models.jooq.tables.PublishedLinkSummaries.PUBLISHED_LINK_SUMMARIES.RANK;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field9() {
		return us.fok.lenzenslijper.models.jooq.tables.PublishedLinkSummaries.PUBLISHED_LINK_SUMMARIES.BEGINNING;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field10() {
		return us.fok.lenzenslijper.models.jooq.tables.PublishedLinkSummaries.PUBLISHED_LINK_SUMMARIES.ENDING;
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
	public java.util.UUID value2() {
		return getDocumentId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value3() {
		return getLinkTypeId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getTargetTitle();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value5() {
		return getTargetLinkableId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value6() {
		return getTimeRange();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value7() {
		return getTargetValue();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value8() {
		return getRank();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value9() {
		return getBeginning();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value10() {
		return getEnding();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PublishedLinkSummariesRecord value1(java.util.UUID value) {
		setRevisionId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PublishedLinkSummariesRecord value2(java.util.UUID value) {
		setDocumentId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PublishedLinkSummariesRecord value3(java.lang.Integer value) {
		setLinkTypeId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PublishedLinkSummariesRecord value4(java.lang.String value) {
		setTargetTitle(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PublishedLinkSummariesRecord value5(java.util.UUID value) {
		setTargetLinkableId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PublishedLinkSummariesRecord value6(java.lang.String value) {
		setTimeRange(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PublishedLinkSummariesRecord value7(java.lang.String value) {
		setTargetValue(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PublishedLinkSummariesRecord value8(java.lang.Integer value) {
		setRank(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PublishedLinkSummariesRecord value9(java.lang.Long value) {
		setBeginning(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PublishedLinkSummariesRecord value10(java.lang.Long value) {
		setEnding(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PublishedLinkSummariesRecord values(java.util.UUID value1, java.util.UUID value2, java.lang.Integer value3, java.lang.String value4, java.util.UUID value5, java.lang.String value6, java.lang.String value7, java.lang.Integer value8, java.lang.Long value9, java.lang.Long value10) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached PublishedLinkSummariesRecord
	 */
	public PublishedLinkSummariesRecord() {
		super(us.fok.lenzenslijper.models.jooq.tables.PublishedLinkSummaries.PUBLISHED_LINK_SUMMARIES);
	}

	/**
	 * Create a detached, initialised PublishedLinkSummariesRecord
	 */
	public PublishedLinkSummariesRecord(java.util.UUID revisionId, java.util.UUID documentId, java.lang.Integer linkTypeId, java.lang.String targetTitle, java.util.UUID targetLinkableId, java.lang.String timeRange, java.lang.String targetValue, java.lang.Integer rank, java.lang.Long beginning, java.lang.Long ending) {
		super(us.fok.lenzenslijper.models.jooq.tables.PublishedLinkSummaries.PUBLISHED_LINK_SUMMARIES);

		setValue(0, revisionId);
		setValue(1, documentId);
		setValue(2, linkTypeId);
		setValue(3, targetTitle);
		setValue(4, targetLinkableId);
		setValue(5, timeRange);
		setValue(6, targetValue);
		setValue(7, rank);
		setValue(8, beginning);
		setValue(9, ending);
	}
}