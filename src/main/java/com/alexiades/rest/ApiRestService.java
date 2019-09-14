package com.alexiades.rest; // Note your package will be {{ groupId }}.rest

import com.alexiades.model.Transaction;
import com.alexiades.model.Account;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.alexiades.exception.CustomException;
import com.alexiades.model.CurrencyValidator;
import com.alexiades.model.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

//Sets the path to base URL + /
//example http://localhost:9090/rest/hello/JavaCodeGeeks?queryParameter=Enjoy%20RESTEasy

@Path("/")
public class ApiRestService {

    //http://localhost:9090/rest/account/?queryParameter=account
    @GET
    @Path("/getaccounts/{pathParameter}")
    @Produces("application/json")
    public String getAccount(@PathParam("pathParameter") long account) throws IOException {

        File sampleFile = new File(getClass().getResource("/json_account.json").getFile());
        String sampleFileContent = new Scanner(sampleFile).useDelimiter("\\Z").next();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode data = mapper.readTree(sampleFileContent);
        JsonNode accountNode = data.path(String.valueOf(account));

        if (!accountNode.isMissingNode()) {        // if "name" node is exist
            Account ac = new Account( account,accountNode.path("userName").asText(),accountNode.path("balance").asDouble(), accountNode.path("currencyCode").asText());
           return ac.toString();
        }else
            return "fail";
    }


    @POST
    @Path("/addaccounts")
    @Consumes("application/json")
    public Response createProductInJSON(Account acc) {

        String result = "Account created : " + acc.getAccountId();
        return Response.status(201).entity(result).build();

    }


/*
    //http://localhost:9090/rest/transfer/123
    @POST
    @Path("/transfer/{pathParameter}")
    @Produces("application/json")
    public String postTransfer() {

        ObjectMapper objectMapper = new ObjectMapper();
        Transaction transaction = new Transaction();
        String account = "";

        {
            try {
                JsonNode data = objectMapper.readTree("target/json_account.json");
                if (accoutExist(data, account) == true) {

                    return transaction.toString();

                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return transaction.toString();

    }

    public boolean accoutExist(JsonNode d, String acc) {


        // Get id
        long id = d.path("id").asLong();
        System.out.println("id : " + id);

        if (id != null) {

            return true;
        } else
            return false;
    }
*/

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





