package br.com.marcoapps.apiavicena.model.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;


@DatabaseTable(tableName = "consulta")
public class Consulta implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer codigoConsulta;
    @DatabaseField (canBeNull = false)
    private String dataConsulta;
    @DatabaseField (canBeNull = false)
    private String horarioConsulta;
    @DatabaseField
    private String atencaoEspecial;
   @DatabaseField(foreign = true, foreignAutoRefresh = true)

    private Paciente pacienteVO;

    public Consulta() {
    }

    public Consulta(Integer codigoConsulta, String dataConsulta, String horarioConsulta, String atencaoEspecial, Paciente pacienteVO) {
        this.codigoConsulta = codigoConsulta;
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
        this.atencaoEspecial = atencaoEspecial;
        this.pacienteVO = pacienteVO;
    }

    public Integer getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(Integer codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
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

    public String getAtencaoEspecial() {
        return atencaoEspecial;
    }

    public void setAtencaoEspecial(String atencaoEspecial) {
        this.atencaoEspecial = atencaoEspecial;
    }

    public Paciente getPaciente() {
        return pacienteVO;
    }

    public void setPaciente(Paciente pacienteVO) {
        this.pacienteVO = pacienteVO;
    }

    @Override
    public String toString() {



        return "Consulta{" +
                "codigoConsulta=" + codigoConsulta +
                ", dataConsulta='" + dataConsulta + '\'' +
                ", horarioConsulta='" + horarioConsulta + '\'' +
                ", atencaoEspecial='" + atencaoEspecial + '\'' +
                ", paciente=" + pacienteVO +
                '}';
    }
}
