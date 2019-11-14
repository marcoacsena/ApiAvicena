package br.com.marcoapps.apiavicena.model.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "medico")
public class Medico implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer codigoMedico;
    private String nomeMedico;
    private String crm;
    private String cpfMedico;
    private String emailMedico;
    private String celMensagemMedico;
    private String celularMedico;

    public Medico() {
    }

    public Medico(Integer codigoMedico, String nomeMedico, String crm, String cpfMedico, String emailMedico, String celMensagemMedico, String celularMedico) {
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

    @Override
    public String toString() {
        return "Medico{" +
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
