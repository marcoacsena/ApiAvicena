package br.com.marcoapps.apiavicena.model.dao.db;

import android.content.Context;

import br.com.marcoapps.apiavicena.model.dao.helpers.DaoHelper;
import br.com.marcoapps.apiavicena.model.vo.Consulta;

public class ConsultaDao extends DaoHelper<Consulta> {

    public ConsultaDao(Context c) {
        super(c, Consulta.class);
    } {
    }
}
