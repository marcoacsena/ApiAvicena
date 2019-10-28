package br.com.marcoapps.apiavicena.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "usuario")
public class Usuario implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;

    @DatabaseField(canBeNull = false)
    private String login;

    @DatabaseField (canBeNull = false)
    private String senha;

    @DatabaseField (canBeNull = false)
    private String perfil;

    public Usuario() {
    }

    public Usuario(Integer id, String login, String senha, String perfil) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", login: '" + login + '\'' +
                ", senha: '" + senha + '\'' +
                ", perfil:'" + perfil + '\'' +
                '}';
    }
}


