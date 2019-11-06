package br.com.marcoapps.apiavicena.controller;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.lang.reflect.Type;

import br.com.marcoapps.apiavicena.R;
import br.com.marcoapps.apiavicena.model.bo.MedicoBO;
import br.com.marcoapps.apiavicena.model.dto.MedicoDTO;
import br.com.marcoapps.apiavicena.model.vo.Medico;
import cz.msebera.android.httpclient.Header;

public class AlterarDadosMedicoController {

    private Activity activity;
    private EditText editCelularMensagem;
    private EditText editCelularParticular;
    private Medico medico;

    public AlterarDadosMedicoController(Activity activity) {
        this.activity = activity;
        medico = new Medico();
        initComponents();

    }

    private void initComponents() {
        editCelularMensagem = activity.findViewById(R.id.editCelularMensagem);
        editCelularParticular = activity.findViewById(R.id.editCelularParticular);
    }

    public void alterarDadosAction() {
        medico = pegarDadosDoForm();

        MedicoBO medicoBO = new MedicoBO(medico);

        if(validar(medicoBO)){
            atualizarDadosMedico(medico);
        }
    }

      private Medico pegarDadosDoForm() {
        medico = new Medico();
        medico.setCelMensagemMedico(editCelularMensagem.getText().toString());
        medico.setCelularMedico(editCelularParticular.getText().toString());
        return medico;
    }

    private boolean validar(MedicoBO medicoBO) {

        if(!medicoBO.validarCelularMensagem()){
            editCelularMensagem.setError("Preencha corretamente o número do celular");
            return false;
        }

        if(!medicoBO.validarCelularParticular()){
            editCelularParticular.setError("Preencha corretamente o número do celular");
            return false;
        }

        return true;
    }

    private void atualizarDadosMedico(Medico medico) {

        String email = activity.getIntent().getStringExtra("email");
        RequestParams parametros = new RequestParams();
        Gson gson = new Gson();
        parametros.put("dado", gson.toJson(medico));
        AsyncHttpClient client = new AsyncHttpClient();
        client.put("http://10.10.101.186:8080/ApiAvicena/api/medico/" + email, parametros, new AsyncHttpResponseHandler() {

            @Override
            public void onStart(){

                super.onStart();
                Toast.makeText(activity, "Atualização do médico foi iniciada...", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(activity, "Dados atualizados com sucesso!", Toast.LENGTH_SHORT).show();
                    limparDados();

                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Não foi possível atualizar os dados", Toast.LENGTH_SHORT).show();
                limparDados();
            }

        });

    }

    private void limparDados() {
        editCelularParticular.setText("");
        editCelularMensagem.setText("");

    }


    public void voltarAction() {
    }
}
