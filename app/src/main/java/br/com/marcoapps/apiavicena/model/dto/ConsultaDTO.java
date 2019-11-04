package br.com.marcoapps.apiavicena.model.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.marcoapps.apiavicena.model.vo.Consulta;
import br.com.marcoapps.apiavicena.model.vo.Convenio;
import br.com.marcoapps.apiavicena.model.vo.Especializacao;
import br.com.marcoapps.apiavicena.model.vo.Paciente;

public class ConsultaDTO {

    private Integer codigoConsulta;
    private Paciente paciente;
    private Especializacao especializacao;
    private Convenio convenio;
    private String dataConsulta;
    private String horarioConsulta;

    public ConsultaDTO() {
    }

    public ConsultaDTO(Integer codigoConsulta, Paciente paciente, Especializacao especializacao, Convenio convenio, String dataConsulta, String horarioConsulta) {
        this.codigoConsulta = codigoConsulta;
        this.paciente = paciente;
        this.especializacao = especializacao;
        this.convenio = convenio;
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
    }

    public Integer getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(Integer codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Especializacao getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(Especializacao especializacao) {
        this.especializacao = especializacao;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public Consulta getConsulta(){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        Date data = null;
        try {
            data = formatador.parse(dataConsulta);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Consulta c = new Consulta();
         c.setCodigoConsulta(codigoConsulta);
         c.setConvenio(convenio);
         c.setDataConsulta(data);
         c.setEspecializacao(especializacao);
         c.setHorarioConsulta(horarioConsulta);
         c.setPaciente(paciente);
         return c;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "ConsultaDTO{" +
                "codigoConsulta=" + codigoConsulta +
                ", paciente=" + paciente +
                ", especializacao=" + especializacao +
                ", convenio=" + convenio +
                ", dataConsulta='" + sdf.format(dataConsulta) + '\'' +
                ", horarioConsulta='" + horarioConsulta + '\'' +
                '}';
    }

}
