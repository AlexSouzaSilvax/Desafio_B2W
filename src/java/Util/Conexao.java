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
import Planeta.PlanetaBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;
//import org.bson.types.ObjectId;

public class Conexao {

    DB BaseDados;
    DBCollection colecao;
    BasicDBObject Document = new BasicDBObject();
    MongoDatabase database;

    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            PlanetaBean p = new PlanetaBean();
            p.setId((ObjectId) document.get("_id"));
            System.out.println("--------------------------> AID: " + p.getId());
            System.out.println("_ID: " + document.get("_id") + " | NOME: " + document.get("nome") + " | CLIMA: " + document.get("clima") + " | TERRENO: " + document.get("terreno"));

            //Gson gson = new Gson();
            //PlanetaBean p = gson.fromJson(document.toJson(), PlanetaBean.class);            
            //System.out.println("_ID: " + p.getId() + " NOME: " + p.getNome() + " CLIMA: " + p.getClima() + " TERRENO: " + p.getTerreno());
        }
    };

    public Conexao() {
        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            database = mongoClient.getDatabase("Estudo");
            System.out.println("Conexão efetuada com sucesso!");
        } catch (Exception e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void teste() {
        MongoCollection<Document> planeta = database.getCollection("Planeta");
        //System.out.println("--------------------------------------------> QTD DOCUMENTOS: " + planeta.countDocuments());
        System.out.println("--------------------------------------------> QTD DOCUMENTOS: " + planeta.countDocuments());

        /* lista as colecoes (tabelas)
        for (String name : database.listCollectionNames()) {
            System.out.println(name);
        }*/
    }

    public void inserir(String nome, String clima, String terreno) {
        MongoCollection<Document> planeta = database.getCollection("Planeta");
        try {
            Document document = new Document("nome", nome)
                    .append("clima", clima)
                    .append("terreno", terreno);

            planeta.insertOne(document);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void listar() {
        try {
            MongoCollection<Document> planeta = database.getCollection("Planeta");
            planeta.find().forEach(printBlock);
        } catch (Exception e) {
            System.out.println("----------------------------> " + e);
        }
    }

    public void buscaPorNome(String nome) {
        try {
            MongoCollection<Document> planeta = database.getCollection("Planeta");
            planeta.find(eq("nome", nome))
                    .forEach(printBlock);
        } catch (Exception e) {
            System.out.println("----------------------------> " + e);
        }
    }

    public void buscaPorId(String id) {
        try {
            MongoCollection<Document> planeta = database.getCollection("Planeta");
            planeta.find(eq("_id", id))
                    .forEach(printBlock);
        } catch (Exception e) {
            System.out.println("----------------------------> " + e);
        }
    }

    public void remover(ObjectId _id) {
        try {
            MongoCollection<Document> planeta = database.getCollection("Planeta");
            planeta.deleteOne(eq("_id", _id));
            System.out.println("Removeu com sucesso!");
        } catch (Exception e) {
            System.out.println("------------------------------------------------------> " + e);
        }
    }

}
