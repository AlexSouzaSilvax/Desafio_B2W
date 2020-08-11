/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planeta;

import com.google.gson.Gson;
import com.mongodb.Block;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author homer
 */
public class PlanetaService {

    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            PlanetaBean p = new PlanetaBean();
            ObjectId nome = new ObjectId(document.get("_id").toString());
            p.setId(nome.toString());
            p.setNome((String) document.get("nome"));
            p.setClima((String) document.get("clima"));
            p.setTerreno((String) document.get("terreno"));
            p.setQtdAparicoesFilmes(buscarQtdAparicoesFilmes(p.getNome()));
            planetaJson(p);
        }
    };

    public String planetaJson(PlanetaBean p) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(p));
        return gson.toJson(p);
    }

    public String buscarQtdAparicoesFilmes(String nome) {
        String qtd = "0";
        return qtd;
    }

}
