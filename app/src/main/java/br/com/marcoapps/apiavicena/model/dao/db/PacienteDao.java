package br.com.marcoapps.apiavicena.model.dao.db;

import android.content.Context;

import br.com.marcoapps.apiavicena.model.dao.helpers.DaoHelper;
import br.com.marcoapps.apiavicena.model.vo.Paciente;

public class PacienteDao extends DaoHelper<Paciente> {

    public PacienteDao(Context c) {
        super(c, Paciente.class);

    }

}
