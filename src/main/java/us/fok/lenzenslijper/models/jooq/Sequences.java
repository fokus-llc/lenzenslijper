/**
 * This class is generated by jOOQ
 */
package us.fok.lenzenslijper.models.jooq;

/**
 * This class is generated by jOOQ.
 *
 * Convenience access to all sequences in public
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

	/**
	 * The sequence <code>public.seq_assessment_type_id</code>
	 */
	public static final org.jooq.Sequence<java.lang.Long> SEQ_ASSESSMENT_TYPE_ID = new org.jooq.impl.SequenceImpl<java.lang.Long>("seq_assessment_type_id", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.seq_asset_role_id</code>
	 */
	public static final org.jooq.Sequence<java.lang.Long> SEQ_ASSET_ROLE_ID = new org.jooq.impl.SequenceImpl<java.lang.Long>("seq_asset_role_id", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.seq_asset_type_id</code>
	 */
	public static final org.jooq.Sequence<java.lang.Long> SEQ_ASSET_TYPE_ID = new org.jooq.impl.SequenceImpl<java.lang.Long>("seq_asset_type_id", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.seq_concept_relation_type_id</code>
	 */
	public static final org.jooq.Sequence<java.lang.Long> SEQ_CONCEPT_RELATION_TYPE_ID = new org.jooq.impl.SequenceImpl<java.lang.Long>("seq_concept_relation_type_id", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.seq_document_type_id</code>
	 */
	public static final org.jooq.Sequence<java.lang.Long> SEQ_DOCUMENT_TYPE_ID = new org.jooq.impl.SequenceImpl<java.lang.Long>("seq_document_type_id", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.seq_link_target_type_id</code>
	 */
	public static final org.jooq.Sequence<java.lang.Long> SEQ_LINK_TARGET_TYPE_ID = new org.jooq.impl.SequenceImpl<java.lang.Long>("seq_link_target_type_id", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.seq_link_type_id</code>
	 */
	public static final org.jooq.Sequence<java.lang.Long> SEQ_LINK_TYPE_ID = new org.jooq.impl.SequenceImpl<java.lang.Long>("seq_link_type_id", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.seq_project_role_id</code>
	 */
	public static final org.jooq.Sequence<java.lang.Long> SEQ_PROJECT_ROLE_ID = new org.jooq.impl.SequenceImpl<java.lang.Long>("seq_project_role_id", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.seq_release_tag_id</code>
	 */
	public static final org.jooq.Sequence<java.lang.Long> SEQ_RELEASE_TAG_ID = new org.jooq.impl.SequenceImpl<java.lang.Long>("seq_release_tag_id", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}
