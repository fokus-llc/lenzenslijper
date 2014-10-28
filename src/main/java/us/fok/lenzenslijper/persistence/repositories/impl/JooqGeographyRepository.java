package us.fok.lenzenslijper.persistence.repositories.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.impl.DSL;
import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.domain.SystemSchemaConstants;
import us.fok.lenzenslijper.views.geojson.Feature;
import us.fok.lenzenslijper.views.geojson.FeatureCollection;
import us.fok.lenzenslijper.views.geojson.GeometryLiteral;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static us.fok.lenzenslijper.models.jooq.Tables.*;

public class JooqGeographyRepository extends AbstractJooqRepository {

    public JooqGeographyRepository(DataSource dataSource, SchemaDictionary dictionary) {
        super(dataSource, dictionary);
    }

    public FeatureCollection fetchGeographicalFeaturesContext(UUID linkableId, UUID revisionId) {
        FeatureCollection collection = new FeatureCollection();

        DSLContext jooq = jooq();

        Field<String> geojsonValue = DSL.field("ST_AsGeoJSON(locations.value)", String.class);

        Record geoRecord = jooq.
            select(PUBLISHED_LINK_SUMMARIES.TARGET_TITLE, geojsonValue).
            from(LINKABLES).
            join(PUBLISHED_LINK_SUMMARIES).
                on(PUBLISHED_LINK_SUMMARIES.DOCUMENT_ID.eq(LINKABLES.DOCUMENT_ID)).
            join(LINKABLES.as("target_linkables")).
                on(DSL.fieldByName(UUID.class, "target_linkables", "linkable_id").eq(PUBLISHED_LINK_SUMMARIES.TARGET_LINKABLE_ID)).
            join(LOCATIONS).
                on(LOCATIONS.LOCATION_ID.eq(DSL.fieldByName(UUID.class, "target_linkables", "location_id"))).
            where(LINKABLES.LINKABLE_ID.eq(linkableId)).
                and(PUBLISHED_LINK_SUMMARIES.LINK_TYPE_ID.equal(SystemSchemaConstants.LINK_TYPE_ID_LOCUS)).
            limit(1).
            fetchOne();

        String title = geoRecord.getValue(PUBLISHED_LINK_SUMMARIES.TARGET_TITLE);
        String geoJson = geoRecord.getValue(geojsonValue);

        Feature feature = new Feature();
        feature.setId(title);
        ObjectNode properties = new ObjectMapper().createObjectNode();
        properties.put("name", title);
        feature.setProperties(properties);
        GeometryLiteral geoLiteral = new GeometryLiteral(geoJson);
        feature.setGeometry(geoLiteral);

        List<Feature> features = new ArrayList<Feature>();
        features.add(feature);
        collection.setFeatures(features);

        return collection;
    }

}
