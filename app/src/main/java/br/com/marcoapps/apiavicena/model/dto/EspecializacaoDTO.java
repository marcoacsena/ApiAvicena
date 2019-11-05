package br.com.marcoapps.apiavicena.model.dto;

import br.com.marcoapps.apiavicena.model.vo.Especialidade;
import br.com.marcoapps.apiavicena.model.vo.Especializacao;
import br.com.marcoapps.apiavicena.model.vo.Medico;

public class EspecializacaoDTO {

    private Integer codigoEspecializacao;
    private Medico medicoVO;
    private Especialidade especialidadeVO;
    private Integer ano;

    public EspecializacaoDTO() {
    }

    public EspecializacaoDTO(Integer codigoEspecializacao, Medico medicoVO, Especialidade especialidadeVO, Integer ano) {
        this.codigoEspecializacao = codigoEspecializacao;
        this.medicoVO = medicoVO;
        this.especialidadeVO = especialidadeVO;
        this.ano = ano;
    }

    public Integer getCodigoEspecializacao() {
        return codigoEspecializacao;
    }

    public void setCodigoEspecializacao(Integer codigoEspecializacao) {
        this.codigoEspecializacao = codigoEspecializacao;
    }


    public Medico getMedicoVO() {
        return medicoVO;
    }

    public void setMedicoVO(Medico medicoVO) {
        this.medicoVO = medicoVO;
    }

    public Especialidade getEspecialidadeVO() {
        return especialidadeVO;
    }

    public void setEspecialidadeVO(Especialidade especialidadeVO) {
        this.especialidadeVO = especialidadeVO;
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
        e.setEspecialidade(especialidadeVO);
        e.setMedico(medicoVO);
        e.setAno(ano);


        return e;
    }

    @Override
    public String toString() {
        return "EspecializacaoDTO{" +
                "codigoEspecializacao=" + codigoEspecializacao +
                ", medico=" + medicoVO +
                ", especialidade=" + especialidadeVO +
                ", ano=" + ano +
                '}';
    }

}
