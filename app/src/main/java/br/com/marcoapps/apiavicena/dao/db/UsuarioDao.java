package br.com.marcoapps.apiavicena.dao.db;

import android.content.Context;

import br.com.marcoapps.apiavicena.dao.helpers.DaoHelper;
import br.com.marcoapps.apiavicena.model.Usuario;

public class UsuarioDao extends DaoHelper<Usuario> {

    public UsuarioDao(Context c) {
        super(c, Usuario.class);
    }

}
