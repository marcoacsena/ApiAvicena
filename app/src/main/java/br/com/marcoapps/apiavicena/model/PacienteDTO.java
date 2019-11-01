package br.com.marcoapps.apiavicena.model;

public class PacienteDTO {
    private Integer codigoPaciente;
    private String nomePaciente;
    private String cpfPaciente;

    public PacienteDTO() {
    }

    public PacienteDTO(Integer codigoPaciente, String nomePaciente, String cpfPaciente) {
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

    public Paciente getPaciente(){

        Paciente p = new Paciente();
        p.setCodigoPaciente(codigoPaciente);
        p.setNomePaciente(nomePaciente);
        p.setCpfPaciente(cpfPaciente);

        return p;
    }

    @Override
    public String toString() {
        return "PacienteDTO{" +
                "codigoPaciente=" + codigoPaciente +
                ", nomePaciente='" + nomePaciente + '\'' +
                ", cpfPaciente='" + cpfPaciente + '\'' +
                '}';
    }
}
