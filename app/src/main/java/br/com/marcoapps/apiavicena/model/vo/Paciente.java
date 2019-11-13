package br.com.marcoapps.apiavicena.model.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "paciente")
public class Paciente implements Serializable {
    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer pacienteVO_id;
    @DatabaseField (canBeNull = false)
    private String nomePaciente;

    private String cpfPaciente;

    public Paciente() {
    }

    public Paciente(Integer pacienteVO_id, String nomePaciente, String cpfPaciente) {
        this.pacienteVO_id = pacienteVO_id;
        this.nomePaciente = nomePaciente;
        this.cpfPaciente = cpfPaciente;
    }

    public Integer getPacienteVO_id() {
        return pacienteVO_id;
    }

    public void setPacienteVO_id(Integer pacienteVO_id) {
        this.pacienteVO_id = pacienteVO_id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "codigoPaciente=" + pacienteVO_id +
                ", nomePaciente='" + nomePaciente + '\'' +
                ", cpfPaciente='" + cpfPaciente + '\'' +
                '}';
    }
}
