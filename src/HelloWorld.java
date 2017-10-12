import models.userFunctions.Impl.UsersImpl;
import models.userFunctions.Users;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"

    public String getClichedMessage() {
        return "<p><a href=\"http://localhost:8080/FileSystem_war_exploded/Users\">USERS</a></p>";
    }
}