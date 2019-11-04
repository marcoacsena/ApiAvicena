package br.com.marcoapps.apiavicena.model.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;

@DatabaseTable(tableName = "consulta")
public class Consulta implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer codigoConsulta;
    @DatabaseField (canBeNull = false)
    private String dataConsulta;
    @DatabaseField (canBeNull = false)
    private String horarioConsulta;
    @DatabaseField (canBeNull = false)
    private String atencaoEspecial;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Paciente paciente;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Especializacao especializacao;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Convenio convenio;

    public Consulta() {
    }

    public Consulta(Integer codigoConsulta, String dataConsulta, String horarioConsulta, String atencaoEspecial, Paciente paciente, Especializacao especializacao, Convenio convenio) {
        this.codigoConsulta = codigoConsulta;
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
        this.atencaoEspecial = atencaoEspecial;
        this.paciente = paciente;
        this.especializacao = especializacao;
        this.convenio = convenio;
    }

    public Integer getCodigoConsulta() {
        return codigoConsulta;
    }

    public String getAtencaoEspecial() {
        return atencaoEspecial;
    }

    public void setAtencaoEspecial(String atencaoEspecial) {
        this.atencaoEspecial = atencaoEspecial;
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

    @Override
    public String toString() {
        return "Consulta{" +
                "codigoConsulta=" + codigoConsulta +
                ", paciente=" + paciente +
                ", especializacao=" + especializacao +
                ", convenio=" + convenio +
                ", dataConsulta=" + dataConsulta +
                ", horarioConsulta='" + horarioConsulta + '\'' +
                '}';
    }
}
