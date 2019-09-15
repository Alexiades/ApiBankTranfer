package com.alexiades.utiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileJson {

    // boolean en el futuro
    public static void insertIntoFile(String stringpost) throws FileNotFoundException, JsonProcessingException {
        //extraigo el fichero
        File jsonFile=new File(FileJson.class.getResource("/json_account.json").getFile());
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
        }


}