package com.alexiades.rest; // Note your package will be {{ groupId }}.rest

import com.alexiades.model.Transaction;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.alexiades.exception.CustomException;
import com.alexiades.model.CurrencyValidator;
import com.alexiades.model.Transaction;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

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

                    //Transaction transaction = new Transaction();
                    Transaction transaction = new Transaction();


                    return transaction.toString();


    }

    //way 1

        /*
Example

    var data = {
            "1": {
        "account": "11"
    },
            "2": {
        "account": "22"
    }
};
*/



    //http://localhost:9090/rest/hello/get
    @POST
    @Path("/transfer")
    @Produces("application/json")
    public String postTransfer() {

        ObjectMapper objectMapper = new ObjectMapper();
        Transaction transaction = new Transaction();
        String account = "";

        {
            try {
                JsonNode data = objectMapper.readTree("target/json_db.json");
                if (accoutExist(data,account) == true) {

                    return transaction.toString();

                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return transaction.toString();

    }

    public boolean accoutExist(JsonNode d,String acc) {

        d.get(acc);

        return true;

    }

     //way 2

    @Path("/transaction")
    @Produces(MediaType.APPLICATION_JSON)
    public class TransactionService {

        //private final DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.H2);

        /**
         * Transfer fund between two accounts.
         *
         * @param transaction
         * @return
         * @throws CustomException
         */
        @POST
        public Response transferFund(Transaction transaction) throws CustomException {

            String currency = transaction.getCurrencyCode();
            if (CurrencyValidator.validateCcyCode(currency)) {
/*                int updateCount = daoFactory.getAccountDAO().transferAccountBalance(transaction);
                if (updateCount == 2) {
                    return Response.status(Response.Status.OK).build();
                } else {
                    // transaction failed
                    throw new WebApplicationException("Transaction failed", Response.Status.BAD_REQUEST);
                }
*/
                return Response.status(Response.Status.OK).build();


            } else {
                throw new WebApplicationException("Currency Code Invalid ", Response.Status.BAD_REQUEST);
            }

        }
    }
}




