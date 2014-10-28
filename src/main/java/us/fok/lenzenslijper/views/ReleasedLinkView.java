package us.fok.lenzenslijper.views;

import us.fok.lenzenslijper.models.dto.ReleasedLinkSummary;

import java.util.UUID;

public class ReleasedLinkView implements LinkView {

    private final ReleasedLinkSummary record;

    private String linkType;
    private String documentType;
    private String entityType;

    public ReleasedLinkView(ReleasedLinkSummary record) {
        this.record = record;
    }

    @Override
    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    @Override
    public String getTitle() {
        String originTitle = record.getTitle();
        return originTitle == null ? record.getTargetTitle() : originTitle;
    }

    public UUID getLinkableId() {
        UUID originLink = record.getOriginLinkableId();
        return originLink == null ? record.getTargetLinkableId() : originLink;
    }

    @Override
    public UUID getDocumentId() {
        return record.getDocumentId();
    }

    @Override
    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Override
    public UUID getEntityId() {
        return record.getEntityId();
    }

    @Override
    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    @Override
    public String getTargetValue() {
        return record.getTargetValue();
    }

    @Override
    public Integer getRank() {
        return record.getRank();
    }

    @Override
    public String getTimeRange() {
        return record.getTimeRange();
    }

    @Override
    public Integer getBeginning() {
        return record.getBeginning();
    }

    @Override
    public Integer getEnding() {
        return record.getEnding();
    }

}
