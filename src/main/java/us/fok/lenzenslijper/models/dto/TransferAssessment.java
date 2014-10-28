package us.fok.lenzenslijper.models.dto;

import javax.xml.bind.annotation.XmlElement;

public class TransferAssessment {

    private String user;
    private String assessmentType;
    private String comments;

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    @XmlElement(name = "assessment_type")
    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
