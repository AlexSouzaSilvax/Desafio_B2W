/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planeta;

import Util.Conexao;    
import org.bson.types.ObjectId;

/**
 *
 * @author homer
 */
public class Teste {

    public static void main(String[] args) {        
        PlanetaDAO planetaDAO = new PlanetaDAO();
        planetaDAO.listar(); //ok
        //conexao.inserir("B2W", "EU SOU", "FODA"); //OK
        //conexao.buscaPorNome("AGORA FOI"); //OK
        //conexao.buscaPorId(new ObjectId("5f32ae1886bdd014711a0463")); //OK
        //conexao.remover(new ObjectId("5f329f13f8edfc3150f0a48a"));//ok        
    }
}
