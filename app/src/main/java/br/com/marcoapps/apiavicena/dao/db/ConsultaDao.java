package br.com.marcoapps.apiavicena.dao.db;

import android.content.Context;

import br.com.marcoapps.apiavicena.dao.helpers.DaoHelper;
import br.com.marcoapps.apiavicena.model.Consulta;

public class ConsultaDao extends DaoHelper<Consulta> {

    public ConsultaDao(Context c) {
        super(c, Consulta.class);
    } {
    }
}
