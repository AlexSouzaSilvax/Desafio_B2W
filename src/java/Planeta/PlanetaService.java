/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planeta;

import StarWarsAPI.PlanetasStarWarsBean;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author homer
 */
public class PlanetaService {

    PlanetaDAO planetaDAO = new PlanetaDAO();
    PlanetasStarWarsBean planetasStarWarsBean = new PlanetasStarWarsBean();

    public List<PlanetaBean> buscarQtdAparicoesFilmes(List<PlanetaBean> planetas) {
        planetas.forEach((p) -> {
            p.setQtdAparicoesFilmes(planetasStarWarsBean.buscarQtdAparicoesFilmes(p.getNome()));
        });
        return planetas;
    }

    public List<PlanetaBean> listar() {
        return buscarQtdAparicoesFilmes(planetaDAO.listar());
    }

    public List<PlanetaBean> buscarPorNome(String nome) {
        return buscarQtdAparicoesFilmes(planetaDAO.buscaPorNome(nome));
    }

    public List<PlanetaBean> buscarPorId(String id) {
        return buscarQtdAparicoesFilmes(planetaDAO.buscaPorId(new ObjectId(id)));
    }

    public void inserir(PlanetaBean p) {
        planetaDAO.inserir(p);
    }

    public void remover(String id) {
        planetaDAO.remover(new ObjectId(id));
    }

}
