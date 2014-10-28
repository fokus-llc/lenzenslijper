package us.fok.lenzenslijper.domain;

public final class SystemSchemaConstants {

    private SystemSchemaConstants() {} // module only

    static final String ONTOLOGY_PROJECT_SLUG = "global";

    public static final int DOCUMENT_TYPE_ID_COLLECTION    = 41;

    public static final int LINK_TYPE_ID_HAS_PROTOTYPE = 1;
    public static final String LINK_TYPE_HAS_PROTOTYPE = "has-prototype";

    public static final int LINK_TYPE_ID_DEFINES      = 11;
    public static final String LINK_TYPE_DEFINES      = "defines";

    public static final int LINK_TYPE_ID_CONCEPT      = 31;
    public static final int LINK_TYPE_ID_COMPRISES    = 41;
    public static final int LINK_TYPE_ID_LOCUS        = 51;

    public static final int ASSESSMENT_TYPE_ID_SUBMIT  = 11;
    public static final int ASSESSMENT_TYPE_ID_PUBLISH = 21;

    public static final String RELEASE_TAG_SUBMITTED = "submitted";
    public static final int RELEASE_TAG_ID_PUBLISHED = 21;
    public static final String RELEASE_TAG_PUBLISHED = "published";

}
