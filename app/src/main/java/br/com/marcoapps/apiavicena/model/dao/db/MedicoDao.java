package br.com.marcoapps.apiavicena.model.dao.db;

import android.content.Context;

import br.com.marcoapps.apiavicena.model.dao.helpers.DaoHelper;
import br.com.marcoapps.apiavicena.model.vo.Medico;

public class MedicoDao extends DaoHelper<Medico> {

    public MedicoDao(Context c) {
        super(c, Medico.class);
    }

}
