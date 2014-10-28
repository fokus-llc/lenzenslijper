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
public class Documents extends org.jooq.impl.TableImpl<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord> {

	private static final long serialVersionUID = 1814808822;

	/**
	 * The singleton instance of <code>public.documents</code>
	 */
	public static final us.fok.lenzenslijper.models.jooq.tables.Documents DOCUMENTS = new us.fok.lenzenslijper.models.jooq.tables.Documents();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord> getRecordType() {
		return us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord.class;
	}

	/**
	 * The column <code>public.documents.document_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord, java.util.UUID> DOCUMENT_ID = createField("document_id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.documents.document_type_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord, java.lang.Integer> DOCUMENT_TYPE_ID = createField("document_type_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.documents.concept_set_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord, java.util.UUID> CONCEPT_SET_ID = createField("concept_set_id", org.jooq.impl.SQLDataType.UUID.defaulted(true), this, "");

	/**
	 * The column <code>public.documents.project_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord, java.util.UUID> PROJECT_ID = createField("project_id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.documents.slug</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord, java.lang.String> SLUG = createField("slug", org.jooq.impl.SQLDataType.CLOB.defaulted(true), this, "");

	/**
	 * The column <code>public.documents.row_created</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord, java.sql.Timestamp> ROW_CREATED = createField("row_created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.documents.row_updated</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord, java.sql.Timestamp> ROW_UPDATED = createField("row_updated", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * Create a <code>public.documents</code> table reference
	 */
	public Documents() {
		this("documents", null);
	}

	/**
	 * Create an aliased <code>public.documents</code> table reference
	 */
	public Documents(java.lang.String alias) {
		this(alias, us.fok.lenzenslijper.models.jooq.tables.Documents.DOCUMENTS);
	}

	private Documents(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord> aliased) {
		this(alias, aliased, null);
	}

	private Documents(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, us.fok.lenzenslijper.models.jooq.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord> getPrimaryKey() {
		return us.fok.lenzenslijper.models.jooq.Keys.UNIQ_DOCUMENTS_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord>>asList(us.fok.lenzenslijper.models.jooq.Keys.UNIQ_DOCUMENTS_ID, us.fok.lenzenslijper.models.jooq.Keys.UNIQ_DOCUMENTS_SLUG);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<us.fok.lenzenslijper.models.jooq.tables.records.DocumentsRecord, ?>>asList(us.fok.lenzenslijper.models.jooq.Keys.DOCUMENTS__FOR_DOCUMENTS_TYPE, us.fok.lenzenslijper.models.jooq.Keys.DOCUMENTS__FOR_DOCUMENTS_CSET, us.fok.lenzenslijper.models.jooq.Keys.DOCUMENTS__FOR_DOCUMENTS_PROJECT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public us.fok.lenzenslijper.models.jooq.tables.Documents as(java.lang.String alias) {
		return new us.fok.lenzenslijper.models.jooq.tables.Documents(alias, this);
	}

	/**
	 * Rename this table
	 */
	public us.fok.lenzenslijper.models.jooq.tables.Documents rename(java.lang.String name) {
		return new us.fok.lenzenslijper.models.jooq.tables.Documents(name, null);
	}
}