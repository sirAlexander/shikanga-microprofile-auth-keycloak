package uk.co.shikanga.microprofile;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/resources")
@ApplicationScoped

@LoginConfig(authMethod = "MP-JWT")
@DeclareRoles({"yes man", "USER", "ADMIN"})
public class JwtKeycloakRestApplication extends Application {
}
