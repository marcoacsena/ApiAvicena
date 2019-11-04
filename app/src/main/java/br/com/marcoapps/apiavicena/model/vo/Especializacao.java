package br.com.marcoapps.apiavicena.model.vo;

import java.io.Serializable;

public class Especializacao implements Serializable {

    private Integer codigoEspecializacao;
    private Medico medico;
    private Especialidade especialidade;
    private Integer ano;

    public Especializacao() {
    }

    public Especializacao(Integer codigoEspecializacao, Medico medico, Especialidade especialidade, Integer ano) {
        this.codigoEspecializacao = codigoEspecializacao;
        this.medico = medico;
        this.especialidade = especialidade;
        this.ano = ano;
    }

    public Integer getCodigoEspecializacao() {
        return codigoEspecializacao;
    }

    public void setCodigoEspecializacao(Integer codigoEspecializacao) {
        this.codigoEspecializacao = codigoEspecializacao;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Especializacao{" +
                "codigoEspecializacao=" + codigoEspecializacao +
                ", medico=" + medico +
                ", especialidade=" + especialidade +
                ", ano=" + ano +
                '}';
    }
}
