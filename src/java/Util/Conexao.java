/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author homer
 */
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    MongoDatabase database;

    public Conexao() {
        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            database = mongoClient.getDatabase("Estudo");
            System.out.println("Conexão efetuada com sucesso!");
        } catch (Exception e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String sendGet(String url, Map<String, String> parametro, Map<String, String> cabecalho) throws IOException {
        if (parametro != null) {
            int i = 0;
            for (Map.Entry<String, String> m : parametro.entrySet()) {
                if (i == 0) {
                    url += "?" + m.getKey() + "=" + URLEncoder.encode(m.getValue(), "UTF-8");
                } else {
                    url += "&" + m.getKey() + "=" + URLEncoder.encode(m.getValue(), "UTF-8");
                }
                i++;
            }
        }

        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        StringBuffer response = new StringBuffer();

        if (cabecalho != null) {
            for (Map.Entry<String, String> m : cabecalho.entrySet()) {
                con.addRequestProperty(m.getKey(), m.getValue());
            }
        }

        con.disconnect();

        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        con.disconnect();

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        return response.toString();
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void setDatabase(MongoDatabase database) {
        this.database = database;
    }
}
