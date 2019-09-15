package com.alexiades.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import com.alexiades.model.Account;
import org.json.JSONObject;


public class NetClientPost {


        static class NodeAccount {
            public int accountid;
            public String userName;
            public double balance;
            public String currencyCode;

            public NodeAccount(int accountid, String userName, double balance, String currencyCode) {
                this.accountid = accountid;
                this.userName = userName;
                this.balance = balance;
                this.currencyCode = currencyCode;
            }
        }

        public static void main(String[] args) {
        String string = "";

        Account account = new Account(43524, "Hook", 10.2, "EUR");

        string = account.toString();


            JSONObject jsonObject = new JSONObject(string);
           // System.out.println(jsonObject);

/*
                String key = "test";
                NodeAccount node =

                //TEST
                // Create a HashMap object called accounts
                HashMap<String, NodeAccount> accounts = new HashMap<String, NodeAccount>();

                for (int i = 0; i == 5; i++) {
                    key = key + i;
                    accounts.put(key, );
                }
*/
        //  String input = "{\"4563\":{\"userName\":\"user5\",\"balance\":20,\"currencyCode\":\"EUR\"}}";




            // Step2: Now pass JSON File Data to REST Service
            try {
                URL url = new URL("http://localhost:9090/rest/postaccounts");
                URLConnection connection = url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(jsonObject.toString());
                out.close();

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while (in.readLine() != null) {
                }
                System.out.println("\nREST Service Invoked Successfully..");
                System.out.println(out.toString());
                in.close();
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }

    }
}