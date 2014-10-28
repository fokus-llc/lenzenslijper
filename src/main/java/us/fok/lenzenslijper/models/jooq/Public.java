/**
 * This class is generated by jOOQ
 */
package us.fok.lenzenslijper.models.jooq;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = 328848405;

	/**
	 * The singleton instance of <code>public</code>
	 */
	public static final Public PUBLIC = new Public();

	/**
	 * No further instances allowed
	 */
	private Public() {
		super("public");
	}

	@Override
	public final java.util.List<org.jooq.Sequence<?>> getSequences() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getSequences0());
		return result;
	}

	private final java.util.List<org.jooq.Sequence<?>> getSequences0() {
		return java.util.Arrays.<org.jooq.Sequence<?>>asList(
			us.fok.lenzenslijper.models.jooq.Sequences.SEQ_ASSESSMENT_TYPE_ID,
			us.fok.lenzenslijper.models.jooq.Sequences.SEQ_ASSET_ROLE_ID,
			us.fok.lenzenslijper.models.jooq.Sequences.SEQ_ASSET_TYPE_ID,
			us.fok.lenzenslijper.models.jooq.Sequences.SEQ_CONCEPT_RELATION_TYPE_ID,
			us.fok.lenzenslijper.models.jooq.Sequences.SEQ_DOCUMENT_TYPE_ID,
			us.fok.lenzenslijper.models.jooq.Sequences.SEQ_LINK_TARGET_TYPE_ID,
			us.fok.lenzenslijper.models.jooq.Sequences.SEQ_LINK_TYPE_ID,
			us.fok.lenzenslijper.models.jooq.Sequences.SEQ_PROJECT_ROLE_ID,
			us.fok.lenzenslijper.models.jooq.Sequences.SEQ_RELEASE_TAG_ID);
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			us.fok.lenzenslijper.models.jooq.tables.AssessmentTypes.ASSESSMENT_TYPES,
			us.fok.lenzenslijper.models.jooq.tables.AssetRoles.ASSET_ROLES,
			us.fok.lenzenslijper.models.jooq.tables.AssetTypes.ASSET_TYPES,
			us.fok.lenzenslijper.models.jooq.tables.Assets.ASSETS,
			us.fok.lenzenslijper.models.jooq.tables.ConceptRelationTypes.CONCEPT_RELATION_TYPES,
			us.fok.lenzenslijper.models.jooq.tables.ConceptRelations.CONCEPT_RELATIONS,
			us.fok.lenzenslijper.models.jooq.tables.ConceptSetMemberships.CONCEPT_SET_MEMBERSHIPS,
			us.fok.lenzenslijper.models.jooq.tables.ConceptSets.CONCEPT_SETS,
			us.fok.lenzenslijper.models.jooq.tables.Concepts.CONCEPTS,
			us.fok.lenzenslijper.models.jooq.tables.DocumentTypes.DOCUMENT_TYPES,
			us.fok.lenzenslijper.models.jooq.tables.Documents.DOCUMENTS,
			us.fok.lenzenslijper.models.jooq.tables.Entities.ENTITIES,
			us.fok.lenzenslijper.models.jooq.tables.GeographyColumns.GEOGRAPHY_COLUMNS,
			us.fok.lenzenslijper.models.jooq.tables.GeometryColumns.GEOMETRY_COLUMNS,
			us.fok.lenzenslijper.models.jooq.tables.LinkTargetTypes.LINK_TARGET_TYPES,
			us.fok.lenzenslijper.models.jooq.tables.LinkTypes.LINK_TYPES,
			us.fok.lenzenslijper.models.jooq.tables.Linkables.LINKABLES,
			us.fok.lenzenslijper.models.jooq.tables.Locations.LOCATIONS,
			us.fok.lenzenslijper.models.jooq.tables.ProjectRoles.PROJECT_ROLES,
			us.fok.lenzenslijper.models.jooq.tables.ProjectUserGrants.PROJECT_USER_GRANTS,
			us.fok.lenzenslijper.models.jooq.tables.Projects.PROJECTS,
			us.fok.lenzenslijper.models.jooq.tables.PublishedDefinitionSummaries.PUBLISHED_DEFINITION_SUMMARIES,
			us.fok.lenzenslijper.models.jooq.tables.PublishedLinkSummaries.PUBLISHED_LINK_SUMMARIES,
			us.fok.lenzenslijper.models.jooq.tables.RasterColumns.RASTER_COLUMNS,
			us.fok.lenzenslijper.models.jooq.tables.RasterOverviews.RASTER_OVERVIEWS,
			us.fok.lenzenslijper.models.jooq.tables.ReleaseTags.RELEASE_TAGS,
			us.fok.lenzenslijper.models.jooq.tables.ReleasedRevisionSummaries.RELEASED_REVISION_SUMMARIES,
			us.fok.lenzenslijper.models.jooq.tables.ReleasedTitleSummaries.RELEASED_TITLE_SUMMARIES,
			us.fok.lenzenslijper.models.jooq.tables.RevisionAssessments.REVISION_ASSESSMENTS,
			us.fok.lenzenslijper.models.jooq.tables.RevisionAssetRoles.REVISION_ASSET_ROLES,
			us.fok.lenzenslijper.models.jooq.tables.RevisionLinks.REVISION_LINKS,
			us.fok.lenzenslijper.models.jooq.tables.Revisions.REVISIONS,
			us.fok.lenzenslijper.models.jooq.tables.SpatialRefSys.SPATIAL_REF_SYS,
			us.fok.lenzenslijper.models.jooq.tables.SubmittedDefinitionSummaries.SUBMITTED_DEFINITION_SUMMARIES,
			us.fok.lenzenslijper.models.jooq.tables.SubmittedLinkSummaries.SUBMITTED_LINK_SUMMARIES,
			us.fok.lenzenslijper.models.jooq.tables.UserPreferences.USER_PREFERENCES,
			us.fok.lenzenslijper.models.jooq.tables.Users.USERS,
			us.fok.lenzenslijper.models.jooq.tables.VirtualAggregateGrants.VIRTUAL_AGGREGATE_GRANTS);
	}

	@Override
	public final java.util.List<org.jooq.UDT<?>> getUDTs() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getUDTs0());
		return result;
	}

	private final java.util.List<org.jooq.UDT<?>> getUDTs0() {
		return java.util.Arrays.<org.jooq.UDT<?>>asList(
			us.fok.lenzenslijper.models.jooq.udt.Addbandarg.ADDBANDARG,
			us.fok.lenzenslijper.models.jooq.udt.AggSamealignment.AGG_SAMEALIGNMENT,
			us.fok.lenzenslijper.models.jooq.udt.GeometryDump.GEOMETRY_DUMP,
			us.fok.lenzenslijper.models.jooq.udt.Geomval.GEOMVAL,
			us.fok.lenzenslijper.models.jooq.udt.Rastbandarg.RASTBANDARG,
			us.fok.lenzenslijper.models.jooq.udt.Reclassarg.RECLASSARG,
			us.fok.lenzenslijper.models.jooq.udt.RevisionSummary.REVISION_SUMMARY,
			us.fok.lenzenslijper.models.jooq.udt.Unionarg.UNIONARG,
			us.fok.lenzenslijper.models.jooq.udt.ValidDetail.VALID_DETAIL);
	}
}