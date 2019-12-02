package uk.co.shikanga.microprofile.secure;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/resources")
@RequestScoped
public class ProtectedResource {

    @Inject
    @ConfigProperty(name = "message")
    String message;

    @Inject
    JsonWebToken callerPrincipal;

    @GET
    @RolesAllowed("USER")
    @Path("/secure")
    public Response message() {

        System.out.println(callerPrincipal.getIssuer());
        System.out.println(callerPrincipal.getRawToken());
        System.out.println(callerPrincipal.getTokenID());

        return Response.ok(callerPrincipal.getName() + " is allowed to read message: " + message).build();
    }
}