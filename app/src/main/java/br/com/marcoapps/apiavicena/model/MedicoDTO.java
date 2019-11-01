package br.com.marcoapps.apiavicena.model;

public class MedicoDTO {

    private Integer codigoMedico;
    private String nomeMedico;
    private String crm;
    private String cpfMedico;
    private String emailMedico;
    private String celMensagemMedico;
    private String celularMedico;

    public MedicoDTO() {
    }

    public MedicoDTO(Integer codigoMedico, String nomeMedico, String crm, String cpfMedico, String emailMedico, String celMensagemMedico, String celularMedico) {
        this.codigoMedico = codigoMedico;
        this.nomeMedico = nomeMedico;
        this.crm = crm;
        this.cpfMedico = cpfMedico;
        this.emailMedico = emailMedico;
        this.celMensagemMedico = celMensagemMedico;
        this.celularMedico = celularMedico;
    }

    public Integer getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(Integer codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getCpfMedico() {
        return cpfMedico;
    }

    public void setCpfMedico(String cpfMedico) {
        this.cpfMedico = cpfMedico;
    }

    public String getEmailMedico() {
        return emailMedico;
    }

    public void setEmailMedico(String emailMedico) {
        this.emailMedico = emailMedico;
    }

    public String getCelMensagemMedico() {
        return celMensagemMedico;
    }

    public void setCelMensagemMedico(String celMensagemMedico) {
        this.celMensagemMedico = celMensagemMedico;
    }

    public String getCelularMedico() {
        return celularMedico;
    }

    public void setCelularMedico(String celularMedico) {
        this.celularMedico = celularMedico;
    }

    public Medico getMedico(){

        Medico m = new Medico();
        m.setCodigoMedico(codigoMedico);
        m.setNomeMedico(nomeMedico);
        m.setCrm(crm);
        m.setCelMensagemMedico(celMensagemMedico);
        m.setCelularMedico(celularMedico);
        m.setEmailMedico(emailMedico);
        m.setCpfMedico(cpfMedico);

        return m;
    }

    @Override
    public String toString() {
        return "MedicoDTO{" +
                "codigoMedico=" + codigoMedico +
                ", nomeMedico='" + nomeMedico + '\'' +
                ", crm='" + crm + '\'' +
                ", cpfMedico='" + cpfMedico + '\'' +
                ", emailMedico='" + emailMedico + '\'' +
                ", celMensagemMedico='" + celMensagemMedico + '\'' +
                ", celularMedico='" + celularMedico + '\'' +
                '}';
    }
}
