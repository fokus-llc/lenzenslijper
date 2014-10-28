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
public class ConceptSetMembershipsRecord extends org.jooq.impl.UpdatableRecordImpl<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord> implements org.jooq.Record10<java.util.UUID, java.lang.Integer, java.util.UUID, java.util.UUID, java.util.UUID, java.sql.Timestamp, java.util.UUID, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp> {

	private static final long serialVersionUID = 704541699;

	/**
	 * Setter for <code>public.concept_set_memberships.concept_set_id</code>.
	 */
	public void setConceptSetId(java.util.UUID value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.concept_set_memberships.concept_set_id</code>.
	 */
	public java.util.UUID getConceptSetId() {
		return (java.util.UUID) getValue(0);
	}

	/**
	 * Setter for <code>public.concept_set_memberships.rank</code>.
	 */
	public void setRank(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.concept_set_memberships.rank</code>.
	 */
	public java.lang.Integer getRank() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>public.concept_set_memberships.member_concept_set_id</code>.
	 */
	public void setMemberConceptSetId(java.util.UUID value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.concept_set_memberships.member_concept_set_id</code>.
	 */
	public java.util.UUID getMemberConceptSetId() {
		return (java.util.UUID) getValue(2);
	}

	/**
	 * Setter for <code>public.concept_set_memberships.member_concept_id</code>.
	 */
	public void setMemberConceptId(java.util.UUID value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.concept_set_memberships.member_concept_id</code>.
	 */
	public java.util.UUID getMemberConceptId() {
		return (java.util.UUID) getValue(3);
	}

	/**
	 * Setter for <code>public.concept_set_memberships.creator_user_id</code>.
	 */
	public void setCreatorUserId(java.util.UUID value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.concept_set_memberships.creator_user_id</code>.
	 */
	public java.util.UUID getCreatorUserId() {
		return (java.util.UUID) getValue(4);
	}

	/**
	 * Setter for <code>public.concept_set_memberships.created</code>.
	 */
	public void setCreated(java.sql.Timestamp value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.concept_set_memberships.created</code>.
	 */
	public java.sql.Timestamp getCreated() {
		return (java.sql.Timestamp) getValue(5);
	}

	/**
	 * Setter for <code>public.concept_set_memberships.updater_user_id</code>.
	 */
	public void setUpdaterUserId(java.util.UUID value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.concept_set_memberships.updater_user_id</code>.
	 */
	public java.util.UUID getUpdaterUserId() {
		return (java.util.UUID) getValue(6);
	}

	/**
	 * Setter for <code>public.concept_set_memberships.updated</code>.
	 */
	public void setUpdated(java.sql.Timestamp value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>public.concept_set_memberships.updated</code>.
	 */
	public java.sql.Timestamp getUpdated() {
		return (java.sql.Timestamp) getValue(7);
	}

	/**
	 * Setter for <code>public.concept_set_memberships.row_created</code>.
	 */
	public void setRowCreated(java.sql.Timestamp value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>public.concept_set_memberships.row_created</code>.
	 */
	public java.sql.Timestamp getRowCreated() {
		return (java.sql.Timestamp) getValue(8);
	}

	/**
	 * Setter for <code>public.concept_set_memberships.row_updated</code>.
	 */
	public void setRowUpdated(java.sql.Timestamp value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>public.concept_set_memberships.row_updated</code>.
	 */
	public java.sql.Timestamp getRowUpdated() {
		return (java.sql.Timestamp) getValue(9);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record2<java.util.UUID, java.lang.Integer> key() {
		return (org.jooq.Record2) super.key();
	}

	// -------------------------------------------------------------------------
	// Record10 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row10<java.util.UUID, java.lang.Integer, java.util.UUID, java.util.UUID, java.util.UUID, java.sql.Timestamp, java.util.UUID, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row10) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row10<java.util.UUID, java.lang.Integer, java.util.UUID, java.util.UUID, java.util.UUID, java.sql.Timestamp, java.util.UUID, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row10) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field1() {
		return us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships.CONCEPT_SET_MEMBERSHIPS.CONCEPT_SET_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships.CONCEPT_SET_MEMBERSHIPS.RANK;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field3() {
		return us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships.CONCEPT_SET_MEMBERSHIPS.MEMBER_CONCEPT_SET_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field4() {
		return us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships.CONCEPT_SET_MEMBERSHIPS.MEMBER_CONCEPT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field5() {
		return us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships.CONCEPT_SET_MEMBERSHIPS.CREATOR_USER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field6() {
		return us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships.CONCEPT_SET_MEMBERSHIPS.CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field7() {
		return us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships.CONCEPT_SET_MEMBERSHIPS.UPDATER_USER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field8() {
		return us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships.CONCEPT_SET_MEMBERSHIPS.UPDATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field9() {
		return us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships.CONCEPT_SET_MEMBERSHIPS.ROW_CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field10() {
		return us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships.CONCEPT_SET_MEMBERSHIPS.ROW_UPDATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value1() {
		return getConceptSetId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value2() {
		return getRank();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value3() {
		return getMemberConceptSetId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value4() {
		return getMemberConceptId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value5() {
		return getCreatorUserId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value6() {
		return getCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value7() {
		return getUpdaterUserId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value8() {
		return getUpdated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value9() {
		return getRowCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value10() {
		return getRowUpdated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConceptSetMembershipsRecord value1(java.util.UUID value) {
		setConceptSetId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConceptSetMembershipsRecord value2(java.lang.Integer value) {
		setRank(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConceptSetMembershipsRecord value3(java.util.UUID value) {
		setMemberConceptSetId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConceptSetMembershipsRecord value4(java.util.UUID value) {
		setMemberConceptId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConceptSetMembershipsRecord value5(java.util.UUID value) {
		setCreatorUserId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConceptSetMembershipsRecord value6(java.sql.Timestamp value) {
		setCreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConceptSetMembershipsRecord value7(java.util.UUID value) {
		setUpdaterUserId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConceptSetMembershipsRecord value8(java.sql.Timestamp value) {
		setUpdated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConceptSetMembershipsRecord value9(java.sql.Timestamp value) {
		setRowCreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConceptSetMembershipsRecord value10(java.sql.Timestamp value) {
		setRowUpdated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConceptSetMembershipsRecord values(java.util.UUID value1, java.lang.Integer value2, java.util.UUID value3, java.util.UUID value4, java.util.UUID value5, java.sql.Timestamp value6, java.util.UUID value7, java.sql.Timestamp value8, java.sql.Timestamp value9, java.sql.Timestamp value10) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ConceptSetMembershipsRecord
	 */
	public ConceptSetMembershipsRecord() {
		super(us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships.CONCEPT_SET_MEMBERSHIPS);
	}

	/**
	 * Create a detached, initialised ConceptSetMembershipsRecord
	 */
	public ConceptSetMembershipsRecord(java.util.UUID conceptSetId, java.lang.Integer rank, java.util.UUID memberConceptSetId, java.util.UUID memberConceptId, java.util.UUID creatorUserId, java.sql.Timestamp created, java.util.UUID updaterUserId, java.sql.Timestamp updated, java.sql.Timestamp rowCreated, java.sql.Timestamp rowUpdated) {
		super(us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships.CONCEPT_SET_MEMBERSHIPS);

		setValue(0, conceptSetId);
		setValue(1, rank);
		setValue(2, memberConceptSetId);
		setValue(3, memberConceptId);
		setValue(4, creatorUserId);
		setValue(5, created);
		setValue(6, updaterUserId);
		setValue(7, updated);
		setValue(8, rowCreated);
		setValue(9, rowUpdated);
	}
}