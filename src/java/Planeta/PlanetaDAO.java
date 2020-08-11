/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planeta;

import Util.Conexao;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author homer
 */
public class PlanetaDAO {

    Conexao conexao = new Conexao();
    BasicDBObject Document = new BasicDBObject();
    //MongoDatabase database;

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

    public void inserir(String nome, String clima, String terreno) {
        MongoCollection<Document> planeta = conexao.getDatabase().getCollection("Planeta");
        try {
            Document document = new Document("nome", nome)
                    .append("clima", clima)
                    .append("terreno", terreno);

            planeta.insertOne(document);
        } catch (Exception e) {
            System.out.println("----------------------------> PlanetaDAO - inserir(String nome, String clima, String terreno) " + e);
        }
    }

    /*public void listar() {
        MongoCollection<Document> planeta = conexao.getDatabase().getCollection("Planeta");
        try {
            planeta.find().forEach(printBlock);
        } catch (Exception e) {
            System.out.println("----------------------------> " + e);
        }
    }
     */
    public List<PlanetaBean> listar() {
        try {
            MongoCollection<Document> planeta = conexao.getDatabase().getCollection("Planeta");
            List<PlanetaBean> planetas = new ArrayList<>();
            PlanetaBean p = new PlanetaBean();
            for (Document doc : planeta.find()) {
                ObjectId nome = new ObjectId(doc.get("_id").toString());
                p.setId(nome.toString());
                p.setNome((String) doc.get("nome"));
                p.setClima((String) doc.get("clima"));
                p.setTerreno((String) doc.get("terreno"));
                p.setQtdAparicoesFilmes(buscarQtdAparicoesFilmes(p.getNome()));
                planetas.add(p);
            }
            return planetas;
        } catch (Exception e) {
            System.out.println("----------------------------> PlanetaDAO - listar() " + e);
        }
        return null;
    }

    public void buscaPorNome(String nome) {
        MongoCollection<Document> planeta = conexao.getDatabase().getCollection("Planeta");
        try {
            planeta.find(eq("nome", nome))
                    .forEach(printBlock);
        } catch (Exception e) {
            System.out.println("----------------------------> PlanetaDAO - buscaPorNome(String nome) " + e);
        }
    }

    public void buscaPorId(ObjectId id) {
        MongoCollection<Document> planeta = conexao.getDatabase().getCollection("Planeta");
        try {
            planeta.find(eq("_id", id))
                    .forEach(printBlock);
        } catch (Exception e) {
            System.out.println("----------------------------> PlanetaDAO - buscaPorId(ObjectId id) " + e);

        }
    }

    public void remover(ObjectId _id) {
        MongoCollection<Document> planeta = conexao.getDatabase().getCollection("Planeta");
        try {

            planeta.deleteOne(eq("_id", _id));
            System.out.println("Removeu com sucesso!");
        } catch (Exception e) {
            System.out.println("----------------------------> PlanetaDAO - remover(ObjectId _id) " + e);
        }
    }

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
