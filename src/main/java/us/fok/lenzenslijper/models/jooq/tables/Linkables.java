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
public class Linkables extends org.jooq.impl.TableImpl<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord> {

	private static final long serialVersionUID = -1632753667;

	/**
	 * The singleton instance of <code>public.linkables</code>
	 */
	public static final us.fok.lenzenslijper.models.jooq.tables.Linkables LINKABLES = new us.fok.lenzenslijper.models.jooq.tables.Linkables();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord> getRecordType() {
		return us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord.class;
	}

	/**
	 * The column <code>public.linkables.linkable_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord, java.util.UUID> LINKABLE_ID = createField("linkable_id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.linkables.entity_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord, java.util.UUID> ENTITY_ID = createField("entity_id", org.jooq.impl.SQLDataType.UUID.defaulted(true), this, "");

	/**
	 * The column <code>public.linkables.concept_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord, java.util.UUID> CONCEPT_ID = createField("concept_id", org.jooq.impl.SQLDataType.UUID.defaulted(true), this, "");

	/**
	 * The column <code>public.linkables.document_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord, java.util.UUID> DOCUMENT_ID = createField("document_id", org.jooq.impl.SQLDataType.UUID.defaulted(true), this, "");

	/**
	 * The column <code>public.linkables.location_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord, java.util.UUID> LOCATION_ID = createField("location_id", org.jooq.impl.SQLDataType.UUID.defaulted(true), this, "");

	/**
	 * The column <code>public.linkables.row_created</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord, java.sql.Timestamp> ROW_CREATED = createField("row_created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.linkables.row_updated</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord, java.sql.Timestamp> ROW_UPDATED = createField("row_updated", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * Create a <code>public.linkables</code> table reference
	 */
	public Linkables() {
		this("linkables", null);
	}

	/**
	 * Create an aliased <code>public.linkables</code> table reference
	 */
	public Linkables(java.lang.String alias) {
		this(alias, us.fok.lenzenslijper.models.jooq.tables.Linkables.LINKABLES);
	}

	private Linkables(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord> aliased) {
		this(alias, aliased, null);
	}

	private Linkables(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, us.fok.lenzenslijper.models.jooq.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord> getPrimaryKey() {
		return us.fok.lenzenslijper.models.jooq.Keys.UNIQ_LINKABLES_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord>>asList(us.fok.lenzenslijper.models.jooq.Keys.UNIQ_LINKABLES_ID, us.fok.lenzenslijper.models.jooq.Keys.UNIQ_LINKABLES_ENTITY, us.fok.lenzenslijper.models.jooq.Keys.UNIQ_LINKABLES_CONCEPT, us.fok.lenzenslijper.models.jooq.Keys.UNIQ_LINKABLES_DOCUMENT, us.fok.lenzenslijper.models.jooq.Keys.UNIQ_LINKABLES_LOCATION);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<us.fok.lenzenslijper.models.jooq.tables.records.LinkablesRecord, ?>>asList(us.fok.lenzenslijper.models.jooq.Keys.LINKABLES__FOR_LINKABLES_ENTITY, us.fok.lenzenslijper.models.jooq.Keys.LINKABLES__FOR_LINKABLES_CONCEPT, us.fok.lenzenslijper.models.jooq.Keys.LINKABLES__FOR_LINKABLES_DOCUMENT, us.fok.lenzenslijper.models.jooq.Keys.LINKABLES__FOR_LINKABLES_LOCATION);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public us.fok.lenzenslijper.models.jooq.tables.Linkables as(java.lang.String alias) {
		return new us.fok.lenzenslijper.models.jooq.tables.Linkables(alias, this);
	}

	/**
	 * Rename this table
	 */
	public us.fok.lenzenslijper.models.jooq.tables.Linkables rename(java.lang.String name) {
		return new us.fok.lenzenslijper.models.jooq.tables.Linkables(name, null);
	}
}
