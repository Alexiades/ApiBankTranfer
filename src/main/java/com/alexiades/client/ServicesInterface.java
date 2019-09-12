
package com.alexiades.client;

import com.alexiades.model.Transaction;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/transfers")
public interface ServicesInterface {

    @GET
    @Path("/getinfo")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Transaction getinfo(@QueryParam("trans") String trans);

    @GET
    @Path("/listransfers")
    @Produces({ "application/json" })
    List<Transaction> listransfers();

    @POST
    @Path("/addtransfer")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Response addtransfer(Transaction movie);

    @PUT
    @Path("/updatetransfer")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Response updatetransfer(Transaction movie);

    @DELETE
    @Path("/deletetransfer")
    Response deleteMovie(@QueryParam("trans") String trans);

}