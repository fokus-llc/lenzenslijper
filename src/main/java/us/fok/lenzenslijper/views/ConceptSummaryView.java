package us.fok.lenzenslijper.views;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import java.util.UUID;

public class ConceptSummaryView {

    private UUID conceptId;
    private UUID linkableId;
    private UUID parentConceptId;
    private String projectSlug;
    private String slug;
    private String name;
    private String shortName;

    @XmlElement(name = "concept_id")
    public UUID getConceptId() {
        return conceptId;
    }

    public void setConceptId(UUID conceptId) {
        this.conceptId = conceptId;
    }

    @XmlElement(name = "link")
    public UUID getLinkableId() {
        return linkableId;
    }

    public void setLinkableId(UUID linkableId) {
        this.linkableId = linkableId;
    }

    @XmlElement(name = "parent_concept_id")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public UUID getParentConceptId() {
        return parentConceptId;
    }

    public void setParentConceptId(UUID parentConceptId) {
        this.parentConceptId = parentConceptId;
    }

    @XmlElement(name = "project")
    public String getProjectSlug() {
        return projectSlug;
    }

    public void setProjectSlug(String projectSlug) {
        this.projectSlug = projectSlug;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "short_name")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

}
