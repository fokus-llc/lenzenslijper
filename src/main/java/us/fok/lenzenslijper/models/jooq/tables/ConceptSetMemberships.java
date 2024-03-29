/**
 * This class is generated by jOOQ
 */
package us.fok.lenzenslijper.models.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ConceptSetMemberships extends org.jooq.impl.TableImpl<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord> {

	private static final long serialVersionUID = -2035947899;

	/**
	 * The singleton instance of <code>public.concept_set_memberships</code>
	 */
	public static final us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships CONCEPT_SET_MEMBERSHIPS = new us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord> getRecordType() {
		return us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord.class;
	}

	/**
	 * The column <code>public.concept_set_memberships.concept_set_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord, java.util.UUID> CONCEPT_SET_ID = createField("concept_set_id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.concept_set_memberships.rank</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord, java.lang.Integer> RANK = createField("rank", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.concept_set_memberships.member_concept_set_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord, java.util.UUID> MEMBER_CONCEPT_SET_ID = createField("member_concept_set_id", org.jooq.impl.SQLDataType.UUID.defaulted(true), this, "");

	/**
	 * The column <code>public.concept_set_memberships.member_concept_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord, java.util.UUID> MEMBER_CONCEPT_ID = createField("member_concept_id", org.jooq.impl.SQLDataType.UUID.defaulted(true), this, "");

	/**
	 * The column <code>public.concept_set_memberships.creator_user_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord, java.util.UUID> CREATOR_USER_ID = createField("creator_user_id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.concept_set_memberships.created</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord, java.sql.Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.concept_set_memberships.updater_user_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord, java.util.UUID> UPDATER_USER_ID = createField("updater_user_id", org.jooq.impl.SQLDataType.UUID.defaulted(true), this, "");

	/**
	 * The column <code>public.concept_set_memberships.updated</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord, java.sql.Timestamp> UPDATED = createField("updated", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * The column <code>public.concept_set_memberships.row_created</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord, java.sql.Timestamp> ROW_CREATED = createField("row_created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.concept_set_memberships.row_updated</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord, java.sql.Timestamp> ROW_UPDATED = createField("row_updated", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * Create a <code>public.concept_set_memberships</code> table reference
	 */
	public ConceptSetMemberships() {
		this("concept_set_memberships", null);
	}

	/**
	 * Create an aliased <code>public.concept_set_memberships</code> table reference
	 */
	public ConceptSetMemberships(java.lang.String alias) {
		this(alias, us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships.CONCEPT_SET_MEMBERSHIPS);
	}

	private ConceptSetMemberships(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord> aliased) {
		this(alias, aliased, null);
	}

	private ConceptSetMemberships(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, us.fok.lenzenslijper.models.jooq.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord> getPrimaryKey() {
		return us.fok.lenzenslijper.models.jooq.Keys.UNIQ_CON_SET_MEMS_SET_RANK;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord>>asList(us.fok.lenzenslijper.models.jooq.Keys.UNIQ_CON_SET_MEMS_SET_RANK);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<us.fok.lenzenslijper.models.jooq.tables.records.ConceptSetMembershipsRecord, ?>>asList(us.fok.lenzenslijper.models.jooq.Keys.CONCEPT_SET_MEMBERSHIPS__FOR_CON_SET_MEMS_SET, us.fok.lenzenslijper.models.jooq.Keys.CONCEPT_SET_MEMBERSHIPS__FOR_CON_SET_MEMS_MEM_SET, us.fok.lenzenslijper.models.jooq.Keys.CONCEPT_SET_MEMBERSHIPS__FOR_CON_SET_MEMS_MCONCEPT, us.fok.lenzenslijper.models.jooq.Keys.CONCEPT_SET_MEMBERSHIPS__FOR_CON_SET_MEMS_CREATOR, us.fok.lenzenslijper.models.jooq.Keys.CONCEPT_SET_MEMBERSHIPS__FOR_CON_SET_MEMS_UPDATER);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships as(java.lang.String alias) {
		return new us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships(alias, this);
	}

	/**
	 * Rename this table
	 */
	public us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships rename(java.lang.String name) {
		return new us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships(name, null);
	}
}
