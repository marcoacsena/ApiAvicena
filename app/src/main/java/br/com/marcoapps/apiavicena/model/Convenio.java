package br.com.marcoapps.apiavicena.model;

import java.io.Serializable;

public class Convenio implements Serializable {

    private Integer codigoConvenio;
    private String nomeConvenio;
    private String valorConvenio;

    public Convenio() {
    }

    public Convenio(Integer codigoConvenio, String nomeConvenio, String valorConvenio) {
        this.codigoConvenio = codigoConvenio;
        this.nomeConvenio = nomeConvenio;
        this.valorConvenio = valorConvenio;
    }

    public Integer getCodigoConvenio() {
        return codigoConvenio;
    }

    public void setCodigoConvenio(Integer codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public String getValorConvenio() {
        return valorConvenio;
    }

    public void setValorConvenio(String valorConvenio) {
        this.valorConvenio = valorConvenio;
    }

    @Override
    public String toString() {
        return "Convenio{" +
                "codigoConvenio=" + codigoConvenio +
                ", nomeConvenio='" + nomeConvenio + '\'' +
                ", valorConvenio='" + valorConvenio + '\'' +
                '}';
    }
}
