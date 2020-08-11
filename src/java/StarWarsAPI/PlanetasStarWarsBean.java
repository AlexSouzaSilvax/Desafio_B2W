/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StarWarsAPI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author homer
 */
public class PlanetasStarWarsBean {

    private String qtdAparicoes;

    FilmesStarWarsAPI filmesStarWarsAPI = new FilmesStarWarsAPI();

    public String buscarQtdAparicoesFilmes(String nome) {
        return filmesStarWarsAPI.buscaQtdAparicoesFilmes(nome);
    }

    public String getQtdAparicoes() {
        return qtdAparicoes;
    }

    public void setQtdAparicoes(String qtdAparicoes) {
        this.qtdAparicoes = qtdAparicoes;
    }

}
