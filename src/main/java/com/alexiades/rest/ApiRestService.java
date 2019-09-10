package com.alexiades.rest; // Note your package will be {{ groupId }}.rest

import com.alexiades.model.Transfer;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

//Sets the path to base URL + /hello
//example http://localhost:9090/rest/hello/JavaCodeGeeks?queryParameter=Enjoy%20RESTEasy

@Path("/hello")
public class ApiRestService {

    private Map<String, Transfer> inventory = new HashMap<String, Transfer>();
/*
    @GET
    @Path("/getinfo")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Transfer movieByImdbId(@QueryParam("imdbId") String imdbId) {
        if (inventory.containsKey(imdbId)) {
            return inventory.get(imdbId);
        } else {
            return null;
        }
    }
*/
// It's works, I need now to think about the structure of the api
//example http://localhost:9090/rest/hello/JavaCodeGeeks?queryParameter=Enjoy%20RESTEasy
//response :

    @GET
    @Path("/{pathParameter}")
    public Response responseMsg( @PathParam("pathParameter") String pathParameter,
                                 @DefaultValue("Nothing to say") @QueryParam("queryParameter") String queryParameter) {

        String response = "Hello from: " + pathParameter + " : " + queryParameter;

        return Response.status(200).entity(response).build();
    }

    @POST
    @Path("/addmovie")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addMovie(Transfer movie) {
        if (null != inventory.get(movie.getImdbId())) {
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .entity("com.alexiades.model.Movie is Already in the database.").build();
        }

        inventory.put(movie.getImdbId(), movie);
        return Response.status(Response.Status.CREATED).build();
    }
}
