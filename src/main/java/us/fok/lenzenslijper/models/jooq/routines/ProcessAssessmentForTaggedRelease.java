/**
 * This class is generated by jOOQ
 */
package us.fok.lenzenslijper.models.jooq.routines;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProcessAssessmentForTaggedRelease extends org.jooq.impl.AbstractRoutine<java.lang.Void> {

	private static final long serialVersionUID = 648980381;

	/**
	 * The parameter <code>public.process_assessment_for_tagged_release._release_tag_id</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Object> _RELEASE_TAG_ID = createParameter("_release_tag_id", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"));

	/**
	 * The parameter <code>public.process_assessment_for_tagged_release._revision_assessment</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Object> _REVISION_ASSESSMENT = createParameter("_revision_assessment", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"));

	/**
	 * Create a new routine call instance
	 */
	public ProcessAssessmentForTaggedRelease() {
		super("process_assessment_for_tagged_release", us.fok.lenzenslijper.models.jooq.Public.PUBLIC);

		addInParameter(_RELEASE_TAG_ID);
		addInParameter(_REVISION_ASSESSMENT);
	}

	/**
	 * Set the <code>_release_tag_id</code> parameter IN value to the routine
	 */
	public void set_ReleaseTagId(java.lang.Object value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.ProcessAssessmentForTaggedRelease._RELEASE_TAG_ID, value);
	}

	/**
	 * Set the <code>_revision_assessment</code> parameter IN value to the routine
	 */
	public void set_RevisionAssessment(java.lang.Object value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.ProcessAssessmentForTaggedRelease._REVISION_ASSESSMENT, value);
	}
}
