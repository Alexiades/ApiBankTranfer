package com.alexiades.rest; // Note your package will be {{ groupId }}.rest

import com.alexiades.model.Transaction;
import com.alexiades.model.Account;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.alexiades.exception.CustomException;
import com.alexiades.utiles.CurrencyValidator;
import com.alexiades.utiles.FileJson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.JSONArray;
import org.json.JSONObject;

import static org.junit.Assert.*;


import java.io.*;
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

        //extraigo el fichero
        File sampleFile = new File(getClass().getResource("/json_account.json").getFile());
        String sampleFileContent = new Scanner(sampleFile).useDelimiter("\\Z").next();

        //creo el nodo del fichero
        ObjectMapper mapper = new ObjectMapper();
        JsonNode data = mapper.readTree(sampleFileContent);

        //extraigo el nodo con el contenido
        JsonNode accountNode = data.path(String.valueOf(account));

        if (!accountNode.isMissingNode()) {        // if "name" node is exist
            Account ac = new Account( account,accountNode.path("userName").asText(),accountNode.path("balance").asDouble(), accountNode.path("currencyCode").asText());
            return ac.toString();
        }else
            return "fail";
    }

    //http://localhost:9090/rest/account/?queryParameter=account
    @GET
    @Path("/newgetaccounts")
    @Produces("application/json")
    public String getAccount(InputStream account) {
        StringBuilder build = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(account));
        String line = null;
        try {
            while ((line = in.readLine()) != null) {
                build.append(account);
                FileJson.insertIntoFile(build.toString());

            }
        } catch (Exception e) {
            System.out.println("Error Parsing: - ");
        }
        System.out.println("Data Received:" + build.toString());

        return build.toString();

    }



/*
    @POST
    @Path("/addaccounts")
    @Consumes("application/json")
        public Response createProductInJSON(InputStream account) {
                StringBuilder build = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader((account)));
        String line = null;
            String result = "Product created : " + account.toString();
        System.out.println("Data Received:" + account.toString());
           // return Response.status(201).entity(result).build();
        return Response.status(201).entity(result).build();
        }

*/

    @POST
    @Path("/postaccounts")
    @Consumes("application/json")
    public Response createAccountInJSON(InputStream account) {
        StringBuilder build = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(account));
        String line = null;
        try {
            while ((line = in.readLine()) != null) {
                build.append(account);
                FileJson.insertIntoFile(build.toString());

            }
        } catch (Exception e) {
            System.out.println("Error Parsing: - ");
        }
        System.out.println("Data Received:" + build.toString());

        // return HTTP response 200 in case of success
        return Response.status(200).entity(build.toString()).build();
    }



    //String result = "Account created : " + acc.getAccountId();
        //return Response.status(201).entity(result).build();

/*

    public boolean accoutExist(JsonNode d, String acc) {
        // Get id
        long id = d.path("id").asLong();
        System.out.println("id : " + id);
        if (id ) {
            return true;
        } else
            return false;
    }
*/

    //way 2
/*
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
        /*
        @POST
        public Response transferFund(Transaction transaction) throws CustomException {

            String currency = transaction.getCurrencyCode();
            if (CurrencyValidator.validateCcyCode(currency)) {
                int updateCount = daoFactory.getAccountDAO().transferAccountBalance(transaction);
                if (updateCount == 2) {
                    return Response.status(Response.Status.OK).build();
                } else {
                    // transaction failed
                    throw new WebApplicationException("Transaction failed", Response.Status.BAD_REQUEST);
                }

                return Response.status(Response.Status.OK).build();


            } else {
                throw new WebApplicationException("Currency Code Invalid ", Response.Status.BAD_REQUEST);
            }

        }

        */
    }



