package com.alexiades.rest; // Note your package will be {{ groupId }}.rest

import com.alexiades.model.Product;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

//Sets the path to base URL + /hello
//example http://localhost:9090/rest/hello/JavaCodeGeeks?queryParameter=Enjoy%20RESTEasy

@Path("/hello")
public class ApiRestService {
/*
    private Map<String, Product> inventory = new HashMap<String, Product>();

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
/*
    @GET
    @Path("/{pathParameter}")
    public Response responseMsg( @PathParam("pathParameter") String pathParameter,
                                 @DefaultValue("Nothing to say") @QueryParam("queryParameter") String queryParameter) {

        String response = "Hello from: " + pathParameter + " : " + queryParameter;

        return Response.status(200).entity(response).build();
    }
*/

    //http://localhost:9090/rest/hello/get
        @GET
        @Path("/get")
        @Produces("application/json")
        public String getProductInJSON() {

            Product product = new Product();
            product.setName("iPad 3");
            product.setQty(999);

            return product.toString();

        }

//http://localhost:9090/rest/hello/post
    @POST
    @Path("/post")
    @Consumes("application/json")
    public Response createProductInJSON(Product product) {

        String result = "Product created : " + product;
        return Response.status(201).entity(result).build();

    }
}
