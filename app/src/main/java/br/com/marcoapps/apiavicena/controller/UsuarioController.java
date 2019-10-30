package br.com.marcoapps.apiavicena.controller;

import android.app.Activity;
import android.content.Intent;
import android.print.PrinterId;
import android.widget.EditText;

import br.com.marcoapps.apiavicena.R;
import br.com.marcoapps.apiavicena.model.Usuario;
import br.com.marcoapps.apiavicena.model.UsuarioBO;
import br.com.marcoapps.apiavicena.view.OpcoesActivity;

public class UsuarioController {
    
    private Activity activity;
    private EditText editLogin;
    private EditText editSenha;

    public UsuarioController(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        editLogin = activity.findViewById(R.id.editLogin);
        editSenha = activity.findViewById(R.id.editSenha);
    }

    public void validarAction() {

        Usuario usuario = pegarDadosDoForm();

        UsuarioBO usuarioBO = new UsuarioBO(usuario);

        if(validar(usuarioBO)){
                validarLoginESenha();
        }
    }

    private Usuario pegarDadosDoForm() {
        Usuario usuario = new Usuario();
        usuario.setLogin(editLogin.getText().toString());
        usuario.setSenha(editSenha.getText().toString());
        return usuario;
    }

    private boolean validar(UsuarioBO usuarioBO) {

        if(!usuarioBO.validarLogin()){
            editLogin.setError("Preencha corretamente o email");
            return false;
        }

        if(!usuarioBO.validarSenha()){
            editSenha.setError("Preencha corretamente a senha");
            return false;
        }

        return true;
    }

    private void validarLoginESenha() {



    }

    private void chamarTelaOpcoes(Usuario usuario){


        Intent it = new Intent(activity, OpcoesActivity.class);
        it.putExtra("usuario", usuario);
        activity.startActivity(it);
    }


}
