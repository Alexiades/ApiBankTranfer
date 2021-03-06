package com.alexiades.utiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class FileJson {

    /**
     *
     * Insert a NodeJSON from a string that have been pull in the API.
     *
     * @param stringpost Insert a JSON sting to be parse
     * @param file get the name of the file where we are going to insert the NodeJSON
     *
     * @return The method return a true if the file is updated, other case it will return a false
     */


    public static boolean insertIntoFile(String stringpost,String file) throws FileNotFoundException, JsonProcessingException {
        //extraigo el fichero
        File jsonFile=new File(FileJson.class.getResource(file).getFile());
        String jsonFileContent=new Scanner(jsonFile).useDelimiter("\\Z").next();

        //creo el nodo del fichero
        ObjectMapper mapper=new ObjectMapper();
        JsonNode data=mapper.readTree(jsonFileContent);

        //inserto el nodo en el arbol
        JSONObject jsonObjectAcc=new JSONObject(stringpost);

        String accountid=jsonObjectAcc.keys().toString();


        ObjectNode addedNode=((ObjectNode)data).putObject(accountid);
        addedNode
        .put("userName",jsonObjectAcc.getString("userName"))
        .put("balance",jsonObjectAcc.getString("balance"))
        .put("currencyCode",jsonObjectAcc.getString("currencyCode"));

        return true;

        }


}