package us.fok.lenzenslijper.models.dto;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.jooq.DSLContext;
import org.jooq.Record5;
import org.jooq.SelectSelectStep;
import us.fok.lenzenslijper.providers.ISO8601DateFormatSerializer;

import javax.xml.bind.annotation.XmlElement;
import java.sql.Timestamp;
import java.util.UUID;

import static us.fok.lenzenslijper.models.jooq.Tables.REVISIONS;
import static us.fok.lenzenslijper.models.jooq.Tables.RELEASED_REVISION_SUMMARIES;
import static us.fok.lenzenslijper.models.jooq.Tables.USERS;

public class ReleasedRevisionSummary {

    public static SelectSelectStep<Record5<UUID,String,Timestamp,String,Timestamp>> projection(DSLContext jooq) {
        return jooq.
            select(REVISIONS.REVISION_ID,
                REVISIONS.COMMENTS,
                REVISIONS.CREATED,
                USERS.USERNAME,
                RELEASED_REVISION_SUMMARIES.ASSESSED);
    }

    private UUID editionId;
    private String comments;
    private String username;
    private Timestamp created;
    private Timestamp assessed;

    @XmlElement(name = "edition_id")
    public UUID getEditionId() {
        return editionId;
    }

    public void setEditionId(UUID editionId) {
        this.editionId = editionId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @XmlElement(name = "user")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonSerialize(using = ISO8601DateFormatSerializer.class)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @JsonSerialize(using = ISO8601DateFormatSerializer.class)
    public Timestamp getAssessed() {
        return assessed;
    }

    public void setAssessed(Timestamp assessed) {
        this.assessed = assessed;
    }

}
