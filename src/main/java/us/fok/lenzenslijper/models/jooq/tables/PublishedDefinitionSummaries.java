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
public class PublishedDefinitionSummaries extends org.jooq.impl.TableImpl<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord> {

	private static final long serialVersionUID = -66265858;

	/**
	 * The singleton instance of <code>public.published_definition_summaries</code>
	 */
	public static final us.fok.lenzenslijper.models.jooq.tables.PublishedDefinitionSummaries PUBLISHED_DEFINITION_SUMMARIES = new us.fok.lenzenslijper.models.jooq.tables.PublishedDefinitionSummaries();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord> getRecordType() {
		return us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord.class;
	}

	/**
	 * The column <code>public.published_definition_summaries.revision_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord, java.util.UUID> REVISION_ID = createField("revision_id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.published_definition_summaries.user_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord, java.util.UUID> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.UUID.defaulted(true), this, "");

	/**
	 * The column <code>public.published_definition_summaries.document_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord, java.util.UUID> DOCUMENT_ID = createField("document_id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.published_definition_summaries.document_type_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord, java.lang.Integer> DOCUMENT_TYPE_ID = createField("document_type_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.published_definition_summaries.prototype_concept_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord, java.util.UUID> PROTOTYPE_CONCEPT_ID = createField("prototype_concept_id", org.jooq.impl.SQLDataType.UUID.defaulted(true), this, "");

	/**
	 * The column <code>public.published_definition_summaries.project_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord, java.util.UUID> PROJECT_ID = createField("project_id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.published_definition_summaries.title</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord, java.lang.String> TITLE = createField("title", org.jooq.impl.SQLDataType.CLOB.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.published_definition_summaries.entity_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord, java.util.UUID> ENTITY_ID = createField("entity_id", org.jooq.impl.SQLDataType.UUID.defaulted(true), this, "");

	/**
	 * The column <code>public.published_definition_summaries.assessed</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord, java.sql.Timestamp> ASSESSED = createField("assessed", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * Create a <code>public.published_definition_summaries</code> table reference
	 */
	public PublishedDefinitionSummaries() {
		this("published_definition_summaries", null);
	}

	/**
	 * Create an aliased <code>public.published_definition_summaries</code> table reference
	 */
	public PublishedDefinitionSummaries(java.lang.String alias) {
		this(alias, us.fok.lenzenslijper.models.jooq.tables.PublishedDefinitionSummaries.PUBLISHED_DEFINITION_SUMMARIES);
	}

	private PublishedDefinitionSummaries(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord> aliased) {
		this(alias, aliased, null);
	}

	private PublishedDefinitionSummaries(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, us.fok.lenzenslijper.models.jooq.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord> getPrimaryKey() {
		return us.fok.lenzenslijper.models.jooq.Keys.UNIQ_PUB_DOCUMENT_DOCUMENT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord>>asList(us.fok.lenzenslijper.models.jooq.Keys.UNIQ_PUB_DOCUMENT_REVISION, us.fok.lenzenslijper.models.jooq.Keys.UNIQ_PUB_DOCUMENT_DOCUMENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<us.fok.lenzenslijper.models.jooq.tables.records.PublishedDefinitionSummariesRecord, ?>>asList(us.fok.lenzenslijper.models.jooq.Keys.PUBLISHED_DEFINITION_SUMMARIES__FOR_PUB_DOCUMENT_REVISION, us.fok.lenzenslijper.models.jooq.Keys.PUBLISHED_DEFINITION_SUMMARIES__FOR_PUB_DOCUMENT_USER, us.fok.lenzenslijper.models.jooq.Keys.PUBLISHED_DEFINITION_SUMMARIES__FOR_PUB_DOCUMENT_DOCUMENT, us.fok.lenzenslijper.models.jooq.Keys.PUBLISHED_DEFINITION_SUMMARIES__FOR_PUB_DOCUMENT_DOCUMENT_TYPE, us.fok.lenzenslijper.models.jooq.Keys.PUBLISHED_DEFINITION_SUMMARIES__FOR_PUB_DOCUMENT_DOCUMENT_PROTOTYPE, us.fok.lenzenslijper.models.jooq.Keys.PUBLISHED_DEFINITION_SUMMARIES__FOR_PUB_DOCUMENT_PROJECT, us.fok.lenzenslijper.models.jooq.Keys.PUBLISHED_DEFINITION_SUMMARIES__FOR_PUB_DOCUMENT_ENTITY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public us.fok.lenzenslijper.models.jooq.tables.PublishedDefinitionSummaries as(java.lang.String alias) {
		return new us.fok.lenzenslijper.models.jooq.tables.PublishedDefinitionSummaries(alias, this);
	}

	/**
	 * Rename this table
	 */
	public us.fok.lenzenslijper.models.jooq.tables.PublishedDefinitionSummaries rename(java.lang.String name) {
		return new us.fok.lenzenslijper.models.jooq.tables.PublishedDefinitionSummaries(name, null);
	}
}