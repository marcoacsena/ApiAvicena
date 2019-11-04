package br.com.marcoapps.apiavicena.model.vo;

import java.io.Serializable;

public class Especialidade implements Serializable {

    private Integer codigoEspecialidade;
    private String nomeEspecialidade;
    private String instituicao;

    public Especialidade() {
    }

    public Especialidade(Integer codigoEspecialidade, String nomeEspecialidade, String instituicao) {
        this.codigoEspecialidade = codigoEspecialidade;
        this.nomeEspecialidade = nomeEspecialidade;
        instituicao = instituicao;
    }

    public Integer getCodigoEspecialidade() {
        return codigoEspecialidade;
    }

    public void setCodigoEspecialidade(Integer codigoEspecialidade) {
        this.codigoEspecialidade = codigoEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    @Override
    public String toString() {
        return "Especialidade{" +
                "codigoEspecialidade=" + codigoEspecialidade +
                ", nomeEspecialidade='" + nomeEspecialidade + '\'' +
                ", Instituicao='" + instituicao + '\'' +
                '}';
    }
}
