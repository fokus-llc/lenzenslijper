package us.fok.lenzenslijper.models.dto;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;

public class LinkTypeRecord {

    private String slug;
    private String targetTypeSlug;
    private String converseSlug;
    private String domainPrototypeSlug;
    private String rangePrototypeSlug;

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @XmlElement(name = "target-type")
    public String getTargetTypeSlug() {
        return targetTypeSlug;
    }

    public void setTargetTypeSlug(String targetTypeSlug) {
        this.targetTypeSlug = targetTypeSlug;
    }

    @XmlElement(name = "converse")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getConverseSlug() {
        return converseSlug;
    }

    public void setConverseSlug(String converseSlug) {
        this.converseSlug = converseSlug;
    }

    @XmlElement(name = "domain")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getDomainPrototypeSlug() {
        return domainPrototypeSlug;
    }

    public void setDomainPrototypeSlug(String domainPrototypeSlug) {
        this.domainPrototypeSlug = domainPrototypeSlug;
    }

    @XmlElement(name = "range")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getRangePrototypeSlug() {
        return rangePrototypeSlug;
    }

    public void setRangePrototypeSlug(String rangePrototypeSlug) {
        this.rangePrototypeSlug = rangePrototypeSlug;
    }

}
