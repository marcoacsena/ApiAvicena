package br.com.marcoapps.apiavicena.controller;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import br.com.marcoapps.apiavicena.model.vo.Usuario;
import br.com.marcoapps.apiavicena.view.AgendaConsultas;

public class TelaOpcoesController {

    private Activity activity;

    public TelaOpcoesController(Activity activity) {
        this.activity = activity;
    }

    public void acessarAgendaAction() {
        Usuario usuario = (Usuario) activity.getIntent().getSerializableExtra("usuario");
        String perfil = usuario.getPerfil();
        if(perfil.equals("medico")) {
            String email = usuario.getLogin();
            Intent it = new Intent(activity, AgendaConsultas.class);
            it.putExtra("email", email);
            activity.startActivity(it);
        }else{
            Toast.makeText(activity, "Acesso negado! Não tem perfil de médico.", Toast.LENGTH_LONG).show();
        }
    }

    public void atualizarDadosAction() {

    }

    public void sairAction() {
        activity.finish();
    }
}
