package br.com.marcoapps.apiavicena.model.bo;

import br.com.marcoapps.apiavicena.model.vo.Usuario;

public class UsuarioBO {

    private Usuario usuario;

    public UsuarioBO(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean validarLogin() {
        return this.usuario.getLogin() != null && !this.usuario.getLogin().isEmpty();
    }

    public boolean validarSenha() {

        return this.usuario.getSenha() != null && !this.usuario.getSenha().isEmpty();
    }
}
