package API.GET;

import models.userFunctions.Impl.UsersImpl;
import models.userFunctions.Users;

import javax.ws.rs.*;

@Path("/Users")
public class UsersApi {
    @GET
    @Produces("text/plain")
    public String getAllUsera() {
        models.userFunctions.Users users = new UsersImpl();
        String result = "";
        String tmp[] = users.getUsers();
        for (int i = 0; i < users.getUsersCount(); i++) {
            result += tmp[i] + "\n";
        }
        return result;
    }

    @Path("{id}")
    @GET
    public String getOneUser(@PathParam("id") String name) {

        return name;
    }


}