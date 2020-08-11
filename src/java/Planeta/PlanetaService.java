/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planeta;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author homer
 */
public class PlanetaService {

    PlanetaDAO planetaDAO = new PlanetaDAO();

    public List<PlanetaBean> listar() {
        return planetaDAO.listar();
    }

    public void buscarPorNome(String nome) {
        planetaDAO.buscaPorNome(nome);
    }

    public void buscarPorId(String id) {
        planetaDAO.buscaPorId(new ObjectId(id));
    }

    public void inserir(String nome, String clima, String terreno) {
        planetaDAO.inserir(nome, clima, terreno);
    }

    public void remover(String id) {
        planetaDAO.remover(new ObjectId(id));
    }

}
