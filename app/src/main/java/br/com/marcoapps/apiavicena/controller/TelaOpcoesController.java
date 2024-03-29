package br.com.marcoapps.apiavicena.controller;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.sql.SQLException;

import br.com.marcoapps.apiavicena.model.dao.db.MedicoDao;
import br.com.marcoapps.apiavicena.model.dto.MedicoDTO;
import br.com.marcoapps.apiavicena.model.vo.Medico;
import br.com.marcoapps.apiavicena.model.vo.Usuario;
import br.com.marcoapps.apiavicena.view.AgendaConsultas;
import br.com.marcoapps.apiavicena.view.AlterarDadosMedico;
import cz.msebera.android.httpclient.Header;

public class TelaOpcoesController {

    private Activity activity;
    private Usuario usuario;
    private Medico medico;
    private MedicoDao medicoDao;

    public TelaOpcoesController(Activity activity) {
        this.activity = activity;
        usuario = new Usuario();
        medico = new Medico();
        medicoDao = new MedicoDao(activity);
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

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.43.108:8080/ApiAvicena/api/medico/" + email , new AsyncHttpResponseHandler() {
//192.168.43.108
// 192.168.0.105
            @Override
            public void onStart(){

                super.onStart();
                Toast.makeText(activity, "Busca do médico foi iniciada...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {

                //  retorno em string da apiavicena em Json
                String medicoEmJson = new String(bytes);
                //conversao da string json para objeto
                Gson gson = new Gson();
                MedicoDTO medicoDTO = gson.fromJson(medicoEmJson, MedicoDTO.class);
                Medico medico = medicoDTO.getMedico();
                if(medico != null) {
                    try {
                        medicoDao.getDao().createOrUpdate(medico);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    Intent it = new Intent(activity, AlterarDadosMedico.class);
                    it.putExtra("medico", medico);
                    activity.startActivity(it);
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Não foi possível encontrar o médico", Toast.LENGTH_SHORT).show();
            }

        });

    }
    public void sairAction() {
        activity.finish();
    }
}
