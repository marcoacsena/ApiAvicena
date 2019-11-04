package br.com.marcoapps.apiavicena.model.vo;

import java.io.Serializable;
import java.util.List;

public class ListaConsultas implements Serializable {

    private List<Consulta> listaDeConsultas;

    public ListaConsultas() {
    }

    public ListaConsultas(List<Consulta> listaDeConsultas) {
        this.listaDeConsultas = listaDeConsultas;
    }

    public List<Consulta> getListaDeConsultas() {
        return listaDeConsultas;
    }

     public void setListaDeConsultas(List<Consulta> listaDeConsultas) {
        this.listaDeConsultas = listaDeConsultas;
    }
    @Override
    public String toString() {
        return "ListaConsultas{" +
                "listaDeConsultas=" + listaDeConsultas +
                '}';
    }

}
