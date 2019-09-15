package com.alexiades.client;

import com.alexiades.model.Account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

    public class NetClientPost
    {

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

        // http://localhost:8080/RESTfulExample/json/product/post
        public static void main(String[] args) {

            try {

                URL url = new URL("http://localhost:9090/rest/addaccounts");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
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

                Account account = new Account(43524, "Hook", 10.2, "EUR");

                /*
                 *  Alternatively you can use this simple String to send
                 *  instead of using a Student instance
                 *
                 *  String jsonString = "{\"id\":12,\"firstName\":\"Catain\",\"lastName\":\"Hook\",\"age\":10}";
                 */

                String input = account.toString();
                //Send request
                OutputStream os = conn.getOutputStream();
                os.write(input.getBytes());
                os.flush();
                //Get response
                if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

                String output;
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {

                    System.out.println(output);
                }

                conn.disconnect();

            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();

            }
        }

    }
