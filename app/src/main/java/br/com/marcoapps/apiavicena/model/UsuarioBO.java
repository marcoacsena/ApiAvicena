package br.com.marcoapps.apiavicena.model;

public class UsuarioBO {


    private Usuario usuario;

    public UsuarioBO(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean validaLogin() {

        return this.usuario.getLogin() != null && !this.usuario.getLogin().isEmpty();
    }

    public boolean validaSenha() {

        return this.usuario.getSenha() != null && !this.usuario.getSenha().isEmpty();
    }
}
