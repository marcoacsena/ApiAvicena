package br.com.marcoapps.apiavicena.model;

import java.io.Serializable;

public class Paciente implements Serializable {

    private Integer codigoPaciente;
    private String nomePaciente;
    private String cpfPaciente;

    public Paciente() {
    }

    public Paciente(Integer codigoPaciente, String nomePaciente, String cpfPaciente) {
        this.codigoPaciente = codigoPaciente;
        this.nomePaciente = nomePaciente;
        this.cpfPaciente = cpfPaciente;
    }

    public Integer getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Integer codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
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
                "codigoPaciente=" + codigoPaciente +
                ", nomePaciente='" + nomePaciente + '\'' +
                ", cpfPaciente='" + cpfPaciente + '\'' +
                '}';
    }
}
