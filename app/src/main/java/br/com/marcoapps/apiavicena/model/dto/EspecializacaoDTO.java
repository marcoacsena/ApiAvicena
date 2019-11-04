package br.com.marcoapps.apiavicena.model.dto;

import br.com.marcoapps.apiavicena.model.vo.Especialidade;
import br.com.marcoapps.apiavicena.model.vo.Especializacao;
import br.com.marcoapps.apiavicena.model.vo.Medico;

public class EspecializacaoDTO {

    private Integer codigoEspecializacao;
    private Medico medico;
    private Especialidade especialidade;
    private Integer ano;

    public EspecializacaoDTO() {
    }

    public EspecializacaoDTO(Integer codigoEspecializacao, Medico medico, Especialidade especialidade, Integer ano) {
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

    public Especializacao getEspecializacao(){

        Especializacao e = new Especializacao();
        e.setCodigoEspecializacao(codigoEspecializacao);
        e.setEspecialidade(especialidade);
        e.setMedico(medico);
        e.setAno(ano);


        return e;
    }

    @Override
    public String toString() {
        return "EspecializacaoDTO{" +
                "codigoEspecializacao=" + codigoEspecializacao +
                ", medico=" + medico +
                ", especialidade=" + especialidade +
                ", ano=" + ano +
                '}';
    }

}
