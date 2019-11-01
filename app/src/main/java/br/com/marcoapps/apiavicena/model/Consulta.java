package br.com.marcoapps.apiavicena.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;

@DatabaseTable(tableName = "consulta")
public class Consulta implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer codigoConsulta;
    @DatabaseField (canBeNull = false)
    private Date dataConsulta;
    @DatabaseField (canBeNull = false)
    private String horarioConsulta;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Paciente paciente;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Especializacao especializacao;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Convenio convenio;

    public Consulta() {
    }

    public Consulta(Integer codigoConsulta, Paciente paciente, Especializacao especializacao, Convenio convenio, Date dataConsulta, String horarioConsulta) {
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

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
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
