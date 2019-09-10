
package com.alexiades.client;

import com.alexiades.model.Transfer;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/transfers")
public interface ServicesInterface {

    @GET
    @Path("/getinfo")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Transfer movieByImdbId(@QueryParam("imdbId") String imdbId);

    @GET
    @Path("/listmovies")
    @Produces({ "application/json" })
    List<Transfer> listMovies();

    @POST
    @Path("/addmovie")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Response addMovie(Transfer movie);

    @PUT
    @Path("/updatemovie")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Response updateMovie(Transfer movie);

    @DELETE
    @Path("/deletemovie")
    Response deleteMovie(@QueryParam("imdbId") String imdbId);

}