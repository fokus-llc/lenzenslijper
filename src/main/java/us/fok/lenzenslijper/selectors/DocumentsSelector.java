package us.fok.lenzenslijper.selectors;

import java.util.UUID;

public class DocumentsSelector extends ContentSelector {

    private String prefix;
    private Integer documentTypeId;
    private UUID relatedConceptLinkableId;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public UUID getRelatedConceptLinkableId() {
        return relatedConceptLinkableId;
    }

    public void setRelatedConceptLinkableId(UUID conceptLinkableId) {
        this.relatedConceptLinkableId = conceptLinkableId;
    }


}
