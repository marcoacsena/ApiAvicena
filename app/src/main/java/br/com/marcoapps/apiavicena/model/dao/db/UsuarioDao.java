package br.com.marcoapps.apiavicena.model.dao.db;

import android.content.Context;

import br.com.marcoapps.apiavicena.model.dao.helpers.DaoHelper;
import br.com.marcoapps.apiavicena.model.vo.Usuario;

public class UsuarioDao extends DaoHelper<Usuario> {

    public UsuarioDao(Context c) {
        super(c, Usuario.class);
    }

}
