package us.fok.lenzenslijper.views;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;
import java.util.UUID;

/*
 * May represent a concept set or a concept
 */
public class ConceptNestableView implements Comparable<ConceptNestableView> {

    private UUID conceptSetId;
    private UUID conceptId;
    private int rank;
    private UUID projectId;
    private String name;
    private String shortName;
    private String slug;

    private List<ConceptNestableView> children;

    @XmlElement(name = "concept_set_id")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public UUID getConceptSetId() {
        return conceptSetId;
    }

    public void setConceptSetId(UUID conceptSetId) {
        this.conceptSetId = conceptSetId;
    }

    @XmlElement(name = "concept_id")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public UUID getConceptId() {
        return conceptId;
    }

    public void setConceptId(UUID conceptId) {
        this.conceptId = conceptId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @XmlTransient
    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public List<ConceptNestableView> getChildren() {
        return children;
    }

    public void setChildren(List<ConceptNestableView> children) {
        this.children = children;
    }

    @Override
    public int compareTo(ConceptNestableView other) {
        return Integer.compare(this.rank, other.rank);
    }

}
