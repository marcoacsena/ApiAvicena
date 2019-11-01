package br.com.marcoapps.apiavicena.dao.db;

import android.content.Context;

import br.com.marcoapps.apiavicena.dao.helpers.DaoHelper;
import br.com.marcoapps.apiavicena.model.Medico;

public class MedicoDao extends DaoHelper<Medico> {

    public MedicoDao(Context c) {
        super(c, Medico.class);
    }

}
