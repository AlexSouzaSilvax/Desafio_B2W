/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planeta;

import org.bson.types.ObjectId;

/**
 *
 * @author homer
 */
public class PlanetaBean {

    private String _id;
    private String nome;
    private String clima;
    private String terreno;
    private String qtdAparicoesFilmes;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public String getQtdAparicoesFilmes() {
        return qtdAparicoesFilmes;
    }

    public void setQtdAparicoesFilmes(String qtdAparicoesFilmes) {
        this.qtdAparicoesFilmes = qtdAparicoesFilmes;
    }

}
