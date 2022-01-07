package com.example.demo.api;

import com.example.demo.service.XMLparser;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPhandler {

    //Get a product by searching the database for it's barcode-number
    public String GetProductByBarCode(String barcode) throws IOException, SAXException {
        StringBuilder result = new StringBuilder();
        XMLparser parser = new XMLparser();
        URL url = new URL("http://localhost:9003/rest/findByBarCode/"+barcode);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        System.out.println(conn.getResponseCode());
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        String ret = parser.parseString(result.toString());
        return ret;
    }

    //Opens the cashregister JAR, not woring atm
    public void openCashRegister() throws IOException {

        //WIP, send help or a shotgun/axe
        URL url = new URL("http://localhost:9001/cashbox/open");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/xml");
        conn.setRequestProperty("Accept", "application/xml");


    }

}
