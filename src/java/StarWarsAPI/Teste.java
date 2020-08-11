package StarWarsAPI;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.client.HttpClient;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Teste {

    public static int main(String[] args) throws IOException {
        String nome = "Tatooine";
        HttpGet getRequest = new HttpGet("https://swapi.dev/api/planets/?search=" + nome);

        HttpClient httpClient = HttpClientBuilder.create().build();
        getRequest.addHeader("accept", "application/json");
        HttpResponse response = httpClient.execute(getRequest);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
        }

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader((response.getEntity().getContent())));

        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        //System.out.println(stringBuilder.toString());
        JsonParser parser = new JsonParser();
        JsonObject json = (JsonObject) parser.parse(stringBuilder.toString());

        Gson gson = new Gson();
        FilmesStarWars filmesStarWars = gson.fromJson(stringBuilder.toString(), FilmesStarWars.class);
        int qtdAparicoesFilmes = filmesStarWars.results.get(0).films.size();
        bufferedReader.close();
        return qtdAparicoesFilmes;
    }
}
