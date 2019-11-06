package br.com.marcoapps.apiavicena.controller;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import br.com.marcoapps.apiavicena.model.vo.Usuario;
import br.com.marcoapps.apiavicena.view.AgendaConsultas;
import br.com.marcoapps.apiavicena.view.AlterarDadosMedico;

public class TelaOpcoesController {

    private Activity activity;
    private Usuario usuario;

    public TelaOpcoesController(Activity activity) {
        this.activity = activity;
        usuario = new Usuario();
    }

    public void acessarAgendaAction() {
        usuario = (Usuario) activity.getIntent().getSerializableExtra("usuario");
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
        usuario = (Usuario) activity.getIntent().getSerializableExtra("usuario");
        String email = usuario.getLogin();
        Intent it = new Intent(activity, AlterarDadosMedico.class);
        it.putExtra("email", email);
        activity.startActivity(it);

        Toast.makeText(activity, usuario.getLogin(), Toast.LENGTH_SHORT).show();

    }

    public void sairAction() {
        activity.finish();
    }
}
