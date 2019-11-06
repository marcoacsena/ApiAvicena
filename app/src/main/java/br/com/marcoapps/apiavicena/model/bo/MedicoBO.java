package br.com.marcoapps.apiavicena.model.bo;

import br.com.marcoapps.apiavicena.model.vo.Medico;

public class MedicoBO {

    private Medico medico;

    public MedicoBO(Medico medico) {
        this.medico = medico;
    }

    public boolean validarCelularMensagem() {
        return this.medico.getCelMensagemMedico() != null
                && !this.medico.getCelMensagemMedico().isEmpty();
    }

    public boolean validarCelularParticular() {

        return this.medico.getCelularMedico()!= null
                && !this.medico.getCelularMedico().isEmpty();
    }
}
