package us.fok.lenzenslijper.views;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import java.util.UUID;

public interface LinkView {

    @XmlElement(name = "link_type")
    String getLinkType();

    // origin title (incoming link) or target title
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    String getTitle();

    @XmlElement(name = "target_link")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    UUID getLinkableId();

    @XmlElement(name = "document_id")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    UUID getDocumentId();

    @XmlElement(name = "document_type")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    String getDocumentType();

    @XmlElement(name = "entity_id")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    UUID getEntityId();

    @XmlElement(name = "entity_type")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    String getEntityType();

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    Integer getRank();

    @XmlElement(name = "value")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    String getTargetValue();

    @XmlElement(name = "time_range")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    String getTimeRange();

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    Integer getBeginning();

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    Integer getEnding();

}
