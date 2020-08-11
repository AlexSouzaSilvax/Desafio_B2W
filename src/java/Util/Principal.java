/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import org.bson.types.ObjectId;

/**
 *
 * @author homer
 */
public class Principal {

    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        //conexao.teste();                
        //conexao.inserir("TESTE NOME", "TESTE CLIMA", "TESTE TERRENO");        
        //conexao.buscaPorNome("TESTE NOME");
        //conexao.remover(new ObjectId("5f329eac9ba94153a1a40a47"));
        conexao.listar();
    }
}
