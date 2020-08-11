/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planeta;

import Util.Conexao;
import com.mongodb.BasicDBObject;
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

    public void inserir(PlanetaBean p) {
        try {
            MongoCollection<Document> planeta = conexao.getDatabase().getCollection("Planeta");
            Document document = new Document("nome", p.getNome())
                    .append("clima", p.getClima())
                    .append("terreno", p.getTerreno());
            planeta.insertOne(document);
        } catch (Exception e) {
            System.out.println("----------------------------> PlanetaDAO - inserir(String nome, String clima, String terreno) " + e);
        }
    }

    public List<PlanetaBean> listar() {
        try {
            MongoCollection<Document> planeta = conexao.getDatabase().getCollection("Planeta");
            List<PlanetaBean> planetas = new ArrayList<>();
            for (Document doc : planeta.find()) {
                PlanetaBean p = new PlanetaBean();
                ObjectId id = new ObjectId(doc.get("_id").toString());
                p.setId(id.toString());
                p.setNome((String) doc.get("nome"));
                p.setClima((String) doc.get("clima"));
                p.setTerreno((String) doc.get("terreno"));
                planetas.add(p);
            }
            return planetas;
        } catch (Exception e) {
            System.out.println("----------------------------> PlanetaDAO - listar() " + e);
        }
        return null;
    }

    public List<PlanetaBean> buscaPorNome(String nome) {
        try {
            MongoCollection<Document> planeta = conexao.getDatabase().getCollection("Planeta");
            List<PlanetaBean> planetas = new ArrayList<>();
            for (Document doc : planeta.find(eq("nome", nome))) {
                PlanetaBean p = new PlanetaBean();
                ObjectId id = new ObjectId(doc.get("_id").toString());
                p.setId(id.toString());
                p.setNome((String) doc.get("nome"));
                p.setClima((String) doc.get("clima"));
                p.setTerreno((String) doc.get("terreno"));
                planetas.add(p);
            }
            return planetas;
        } catch (Exception e) {
            System.out.println("----------------------------> PlanetaDAO - buscaPorNome(String nome) " + e);
        }
        return null;
    }

    public List<PlanetaBean> buscaPorId(ObjectId id) {
        try {
            MongoCollection<Document> planeta = conexao.getDatabase().getCollection("Planeta");
            List<PlanetaBean> planetas = new ArrayList<>();
            for (Document doc : planeta.find(eq("_id", id))) {
                PlanetaBean p = new PlanetaBean();
                ObjectId _id = new ObjectId(doc.get("_id").toString());
                p.setId(_id.toString());
                p.setNome((String) doc.get("nome"));
                p.setClima((String) doc.get("clima"));
                p.setTerreno((String) doc.get("terreno"));
                planetas.add(p);
            }
            return planetas;
        } catch (Exception e) {
            System.out.println("----------------------------> PlanetaDAO - buscaPorId(ObjectId id) " + e);

        }
        return null;
    }

    public void remover(ObjectId _id) {
        try {
            MongoCollection<Document> planeta = conexao.getDatabase().getCollection("Planeta");
            planeta.deleteOne(eq("_id", _id));            
        } catch (Exception e) {
            System.out.println("----------------------------> PlanetaDAO - remover(ObjectId _id) " + e);
        }
    }
}
