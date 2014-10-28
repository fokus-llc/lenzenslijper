package us.fok.lenzenslijper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import us.fok.lenzenslijper.errors.ServiceInputError;
import us.fok.lenzenslijper.models.dto.RevisionReceipt;
import us.fok.lenzenslijper.models.dto.TransferAssessment;
import us.fok.lenzenslijper.models.dto.TransferDocumentRevision;
import us.fok.lenzenslijper.models.immutable.ProjectWithMode;
import us.fok.lenzenslijper.models.pagination.PaginatedList;
import us.fok.lenzenslijper.persistence.repositories.ConsolidatedRepository;
import us.fok.lenzenslijper.selectors.ProjectsSelector;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.security.Principal;
import java.util.UUID;

import static us.fok.lenzenslijper.util.StringUtilities.stringIsPresent;
import static us.fok.lenzenslijper.util.NumericUtilities.constrainInteger;

@Controller
@Path("auth")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class AuthorizedContentController {

    private static final String URI_PUBLIC_LINKED_DOCUMENT_REVISION = "/public/linked/documents/{docLink}/revisions/{revId}";

    private final ConsolidatedRepository repo;

    @Autowired
    public AuthorizedContentController(ConsolidatedRepository repo) {
        this.repo = repo;
    }

    @POST
    @Path("revisions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postRevision(TransferDocumentRevision inputRevision, @Context SecurityContext security) {
        ensureRevisionUser(inputRevision, security);
        RevisionReceipt outputRevision = insertDocumentRevisionWithErrorHandling(inputRevision);
        return Response.
            created(buildRevisionUri(outputRevision)).
            entity(outputRevision).
            build();
    }

    private String ensureRevisionUser(TransferDocumentRevision revision, SecurityContext security) {
        String username = ensureContextUser(security);
        revision.setUser(username);
        return username;
    }

    private String ensureContextUser(SecurityContext security) {
        String username = getAuthorizedUserName(security);
        if (! stringIsPresent(username)) {
            throw new WebApplicationException("No authorized user", Response.Status.UNAUTHORIZED);
        }
        return username;
    }

    private String getAuthorizedUserName(SecurityContext security) {
        Principal principal = security.getUserPrincipal();
        return principal == null ? null : principal.getName();
    }

    private RevisionReceipt insertDocumentRevisionWithErrorHandling(TransferDocumentRevision revision) {
        RevisionReceipt result = null;
        try {
            result = repo.insertDocumentRevision(revision);
        }
        catch (Exception e) {
            handleServiceException(e, "Error processing new inputRevision.");
        }
        return result;
    }

    private void handleServiceException(Throwable e, String genericMessage) {
        if (e instanceof ServiceInputError) {
            throw new WebApplicationException(e.getMessage(),
                                              Response.Status.BAD_REQUEST);
        }
        else {
            throw new WebApplicationException(genericMessage,
                                              Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    private URI buildRevisionUri(RevisionReceipt documentRevision) {
        UriBuilder builder = UriBuilder.fromPath(URI_PUBLIC_LINKED_DOCUMENT_REVISION);
        return builder.build(documentRevision.getDocumentLink(), documentRevision.getRevisionId());
    }

    @POST
    @Path("revisions/{uuid: [a-f0-9-]*}/assessments")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postAssessment(@PathParam("uuid") UUID revisionId, TransferAssessment assessment, @Context SecurityContext security) {
        setAssessmentUserGuaranteed(assessment, security);
        insertAssessmentWithErrorHandling(revisionId, assessment);
        return Response.
            noContent().
            build();
    }

    private void setAssessmentUserGuaranteed(TransferAssessment assessment, SecurityContext security) {
        String username = ensureContextUser(security);
        assessment.setUser(username);
    }

    private void insertAssessmentWithErrorHandling(UUID revisionId, TransferAssessment assessment) {
        try {
            repo.insertRevisionAssessment(revisionId, assessment);
        }
        catch (Exception e) {
            handleServiceException(e, "Error processing new assessment.");
        }
    }

    @GET @Path("projects")
    public PaginatedList<ProjectWithMode> projects(@QueryParam("limit") Integer limit,
                                                   @QueryParam("offset") Integer offset,
                                                   @Context SecurityContext security) {
        ProjectsSelector selector =
            new ProjectsSelector(constrainInteger(limit, null, 1, 100),
                                 constrainInteger(offset, 0, 0, null),
                                 fetchContextUserId(security));
        return repo.fetchWritableProjectsWithMode(selector);
    }

    private UUID fetchContextUserId(SecurityContext security) {
        String username = ensureContextUser(security);
        return repo.fetchUserId(username);
    }

}
