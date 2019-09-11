
package com.alexiades.client;

import com.alexiades.model.Product;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/transfers")
public interface ServicesInterface {

    @GET
    @Path("/getinfo")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Product getinfo(@QueryParam("trans") String trans);

    @GET
    @Path("/listransfers")
    @Produces({ "application/json" })
    List<Product> listransfers();

    @POST
    @Path("/addtransfer")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Response addtransfer(Product movie);

    @PUT
    @Path("/updatetransfer")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Response updatetransfer(Product movie);

    @DELETE
    @Path("/deletetransfer")
    Response deleteMovie(@QueryParam("trans") String trans);

}