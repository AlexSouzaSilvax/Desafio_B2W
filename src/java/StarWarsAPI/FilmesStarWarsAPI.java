package StarWarsAPI;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.HttpClient;

public class FilmesStarWarsAPI {

    public String buscaQtdAparicoesFilmes(String nome) {
        try {
            String _nome = nome;
            int n = nome.lastIndexOf(" ");
            if (n > 0) {
                _nome = nome.substring(0, n);
            }
            HttpGet getRequest = new HttpGet("https://swapi.dev/api/planets/?search=" + _nome);
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

            Gson gson = new Gson();
            FilmesStarWars filmesStarWars = gson.fromJson(stringBuilder.toString(), FilmesStarWars.class);
            String qtdAparicoesFilmes = String.valueOf(filmesStarWars.results.get(0).films.size());

            bufferedReader.close();

            return qtdAparicoesFilmes;

        } catch (IOException ex) {
            Logger.getLogger(FilmesStarWarsAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
