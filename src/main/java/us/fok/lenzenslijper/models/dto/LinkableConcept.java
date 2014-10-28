package us.fok.lenzenslijper.models.dto;

import java.util.UUID;

public class LinkableConcept {

    private UUID linkableId;
    private String name;

    public UUID getLinkableId() {
        return linkableId;
    }

    public void setLinkableId(UUID linkableId) {
        this.linkableId = linkableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
