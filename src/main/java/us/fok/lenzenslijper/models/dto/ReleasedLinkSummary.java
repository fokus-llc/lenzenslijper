package us.fok.lenzenslijper.models.dto;

import java.util.UUID;

public class ReleasedLinkSummary {

    int linkTypeId;

    String title;       // title of origin document: incoming link
    UUID originLinkableId;

    String targetTitle; // title of outgoing link
    UUID targetLinkableId;

    String targetValue;

    Integer rank;

    String timeRange;
    Integer beginning;
    Integer ending;

    UUID documentId; // targeted or origin document
    int documentTypeId;
    UUID prototypeConceptId;
    UUID entityId;

    public int getLinkTypeId() {
        return linkTypeId;
    }

    public void setLinkTypeId(int linkTypeId) {
        this.linkTypeId = linkTypeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getOriginLinkableId() {
        return originLinkableId;
    }

    public void setOriginLinkableId(UUID originLinkableId) {
        this.originLinkableId = originLinkableId;
    }

    public String getTargetTitle() {
        return targetTitle;
    }

    public void setTargetTitle(String targetTitle) {
        this.targetTitle = targetTitle;
    }

    public UUID getTargetLinkableId() {
        return targetLinkableId;
    }

    public void setTargetLinkableId(UUID targetLinkableId) {
        this.targetLinkableId = targetLinkableId;
    }

    public String getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public Integer getBeginning() {
        return beginning;
    }

    public void setBeginning(Integer beginning) {
        this.beginning = beginning;
    }

    public Integer getEnding() {
        return ending;
    }

    public void setEnding(Integer ending) {
        this.ending = ending;
    }

    public UUID getDocumentId() {
        return documentId;
    }

    public void setDocumentId(UUID documentId) {
        this.documentId = documentId;
    }

    public int getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(int documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public UUID getPrototypeConceptId() {
        return prototypeConceptId;
    }

    public void setPrototypeConceptId(UUID prototypeConceptId) {
        this.prototypeConceptId = prototypeConceptId;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public void setEntityId(UUID entityId) {
        this.entityId = entityId;
    }

}
