package br.com.marcoapps.apiavicena.model.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "consulta")
public class Consulta implements Serializable {
    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;
    @DatabaseField(unique = true)
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

    public Consulta(Integer id, Integer codigoConsulta, String dataConsulta, String horarioConsulta, String atencaoEspecial, Paciente pacienteVO) {
        this.id = id;
        this.codigoConsulta = codigoConsulta;
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
        this.atencaoEspecial = atencaoEspecial;
        this.pacienteVO = pacienteVO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPacienteVO() {
        return pacienteVO;
    }

    public void setPacienteVO(Paciente pacienteVO) {
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
        String data = (this.getDataConsulta().replaceAll("-","/"));
        String[] s = data.split("/");
        String novaData = s[2] + "/" + s[1] + "/" + s[0];

        return
                "Nome do paciente=" + pacienteVO.getNomePaciente() + "\n"+
                "Data da Consulta='" + novaData + "\n" +
                "Horario da Consulta='" + horarioConsulta + "\n" +
                "Atenção Especial='" + atencaoEspecial;

    }
}
