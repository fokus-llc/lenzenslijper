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
public class ReleaseTags extends org.jooq.impl.TableImpl<us.fok.lenzenslijper.models.jooq.tables.records.ReleaseTagsRecord> {

	private static final long serialVersionUID = -468142766;

	/**
	 * The singleton instance of <code>public.release_tags</code>
	 */
	public static final us.fok.lenzenslijper.models.jooq.tables.ReleaseTags RELEASE_TAGS = new us.fok.lenzenslijper.models.jooq.tables.ReleaseTags();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<us.fok.lenzenslijper.models.jooq.tables.records.ReleaseTagsRecord> getRecordType() {
		return us.fok.lenzenslijper.models.jooq.tables.records.ReleaseTagsRecord.class;
	}

	/**
	 * The column <code>public.release_tags.release_tag_id</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ReleaseTagsRecord, java.lang.Integer> RELEASE_TAG_ID = createField("release_tag_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.release_tags.slug</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ReleaseTagsRecord, java.lang.String> SLUG = createField("slug", org.jooq.impl.SQLDataType.CLOB.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.release_tags.row_created</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ReleaseTagsRecord, java.sql.Timestamp> ROW_CREATED = createField("row_created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.release_tags.row_updated</code>.
	 */
	public final org.jooq.TableField<us.fok.lenzenslijper.models.jooq.tables.records.ReleaseTagsRecord, java.sql.Timestamp> ROW_UPDATED = createField("row_updated", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * Create a <code>public.release_tags</code> table reference
	 */
	public ReleaseTags() {
		this("release_tags", null);
	}

	/**
	 * Create an aliased <code>public.release_tags</code> table reference
	 */
	public ReleaseTags(java.lang.String alias) {
		this(alias, us.fok.lenzenslijper.models.jooq.tables.ReleaseTags.RELEASE_TAGS);
	}

	private ReleaseTags(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.ReleaseTagsRecord> aliased) {
		this(alias, aliased, null);
	}

	private ReleaseTags(java.lang.String alias, org.jooq.Table<us.fok.lenzenslijper.models.jooq.tables.records.ReleaseTagsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, us.fok.lenzenslijper.models.jooq.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<us.fok.lenzenslijper.models.jooq.tables.records.ReleaseTagsRecord, java.lang.Integer> getIdentity() {
		return us.fok.lenzenslijper.models.jooq.Keys.IDENTITY_RELEASE_TAGS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.ReleaseTagsRecord> getPrimaryKey() {
		return us.fok.lenzenslijper.models.jooq.Keys.UNIQ_RELEASE_TAGS_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.ReleaseTagsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<us.fok.lenzenslijper.models.jooq.tables.records.ReleaseTagsRecord>>asList(us.fok.lenzenslijper.models.jooq.Keys.UNIQ_RELEASE_TAGS_ID, us.fok.lenzenslijper.models.jooq.Keys.UNIQ_RELEASE_TAGS_SLUG);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public us.fok.lenzenslijper.models.jooq.tables.ReleaseTags as(java.lang.String alias) {
		return new us.fok.lenzenslijper.models.jooq.tables.ReleaseTags(alias, this);
	}

	/**
	 * Rename this table
	 */
	public us.fok.lenzenslijper.models.jooq.tables.ReleaseTags rename(java.lang.String name) {
		return new us.fok.lenzenslijper.models.jooq.tables.ReleaseTags(name, null);
	}
}
