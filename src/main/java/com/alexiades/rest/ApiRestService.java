package com.alexiades.rest;

import com.alexiades.model.Account;
import com.alexiades.utiles.FileJson;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.Scanner;

@Path("/")
public class ApiRestService {

    //http://localhost:9090/rest/account/?queryParameter=account
    @GET
    @Path("/getaccounts/{pathParameter}")
    @Produces("application/json")
    public String getAccounts(@PathParam("pathParameter") long account) throws IOException {

        //Pull the file
        File sampleFile = new File(getClass().getResource("/json_accounts.json").getFile());
        String sampleFileContent = new Scanner(sampleFile).useDelimiter("\\Z").next();

        //Create the node of the file
        ObjectMapper mapper = new ObjectMapper();
        JsonNode data = mapper.readTree(sampleFileContent);

        //Pull the information from the node through the key
        JsonNode accountNode = data.path(String.valueOf(account));

        if (!accountNode.isMissingNode()) {        // if "name" node is exist
            Account ac = new Account( account,accountNode.path("userName").asText(),accountNode.path("balance").asDouble(), accountNode.path("currencyCode").asText());
            return ac.toString();
        }else
            return "fail";
    }


    //http://localhost:9090/rest/account/?queryParameter=account
    @GET
    @Path("/getransfers/{pathParameter}")
    @Produces("application/json")
    public String getTransfers(@PathParam("pathParameter") long transfer) throws IOException {

        //Pull the file
        File sampleFile = new File(getClass().getResource("/json_transfers.json").getFile());
        String sampleFileContent = new Scanner(sampleFile).useDelimiter("\\Z").next();

        //Create the node of the file
        ObjectMapper mapper = new ObjectMapper();
        JsonNode data = mapper.readTree(sampleFileContent);

        //Pull the information from the node through the key
        JsonNode accountNode = data.path(String.valueOf(transfer));

        if (!accountNode.isMissingNode()) {        // if "name" node is exist
            Account ac = new Account( transfer,accountNode.path("userName").asText(),accountNode.path("balance").asDouble(), accountNode.path("currencyCode").asText());
            return ac.toString();
        }else
            return "fail";
    }


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
                FileJson.insertIntoFile(build.toString(),"json_accounts.json");

            }
        } catch (Exception e) {
            System.out.println("Error Parsing: - ");
        }
        System.out.println("Data Received:" + build.toString());

        // return HTTP response 200 in case of success
        return Response.status(200).entity(build.toString()).build();
    }


    @POST
    @Path("/postransfers")
    @Consumes("application/json")
    public Response createTransferInJSON(InputStream transfer) {
        StringBuilder build = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(transfer));
        String line = null;
        try {
            while ((line = in.readLine()) != null) {
                build.append(transfer);
                FileJson.insertIntoFile(build.toString(),"json_transfers.json");

            }
        } catch (Exception e) {
            System.out.println("Error Parsing: - ");
        }
        System.out.println("Data Received:" + build.toString());

        // return HTTP response 200 in case of success
        return Response.status(200).entity(build.toString()).build();
    }
}



