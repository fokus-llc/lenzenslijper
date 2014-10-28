package us.fok.lenzenslijper.models.dto;

import javax.xml.bind.annotation.XmlElement;
import java.util.UUID;

public class TransferLink {

    private String type;
    private String title;
    private UUID targetLinkableId;
    private String value;
    private Integer rank;
    private String timeRange;
    private Long beginning; // verify postgresql v. java range
    private Long ending;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "target_linkable_id")
    public UUID getTargetLinkableId() {
        return targetLinkableId;
    }

    public void setTargetLinkableId(UUID targetLinkableId) {
        this.targetLinkableId = targetLinkableId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @XmlElement(name = "time_range")
    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public Long getBeginning() {
        return beginning;
    }

    public void setBeginning(Long beginning) {
        this.beginning = beginning;
    }

    public Long getEnding() {
        return ending;
    }

    public void setEnding(Long ending) {
        this.ending = ending;
    }
}
