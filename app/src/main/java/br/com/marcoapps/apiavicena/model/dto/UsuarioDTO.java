package br.com.marcoapps.apiavicena.model.dto;

import br.com.marcoapps.apiavicena.model.vo.Usuario;

public class UsuarioDTO {

    private Integer codigoUsuario;
    private String login;
    private String senha;
    private String perfil;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer codigoUsuario, String login, String senha, String perfil) {
        this.codigoUsuario = codigoUsuario;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }



    public Usuario getUsurio() {

        Usuario usuario = new Usuario();

        usuario.setId(codigoUsuario);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setPerfil(perfil);
        return usuario;
        }
}
