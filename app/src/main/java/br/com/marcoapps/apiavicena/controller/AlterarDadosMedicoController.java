package br.com.marcoapps.apiavicena.controller;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.sql.SQLException;

import br.com.marcoapps.apiavicena.R;
import br.com.marcoapps.apiavicena.model.bo.MedicoBO;
import br.com.marcoapps.apiavicena.model.dao.db.MedicoDao;
import br.com.marcoapps.apiavicena.model.vo.Medico;
import br.com.marcoapps.apiavicena.uitl.Mascaras;
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
        editCelularMensagem.addTextChangedListener(Mascaras.mask(editCelularMensagem, Mascaras.FORMAT_FONE));
        editCelularParticular.addTextChangedListener(Mascaras.mask(editCelularParticular, Mascaras.FORMAT_FONE));
        preencherCamposTelefone();


    }

    private void preencherCamposTelefone() {
        Medico medicoValidado = (Medico) activity.getIntent().getSerializableExtra("medico");

        editCelularMensagem.setText(medicoValidado.getCelMensagemMedico());
        editCelularParticular.setText(medicoValidado.getCelularMedico());
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

        Medico medicoValidado = (Medico) activity.getIntent().getSerializableExtra("medico");
        RequestParams parametros = new RequestParams();
        Gson gson = new Gson();
        parametros.put("dado", gson.toJson(medico));
        AsyncHttpClient client = new AsyncHttpClient();
        int codigoMedico = medicoValidado.getCodigoMedico();
        client.put("http://192.168.43.108:8080/ApiAvicena/api/medico/" + codigoMedico , parametros, new AsyncHttpResponseHandler() {
//192.168.43.108
//10.10.100.193
//192.168.0.105
            @Override
            public void onStart(){

                super.onStart();
                Toast.makeText(activity, "Atualização do médico foi iniciada...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {

                String medicoEmJson = new String(bytes);
                if(medicoEmJson.equals("true")) {
                    Toast.makeText(activity, "Dados atualizados com sucesso!", Toast.LENGTH_LONG).show();
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
        activity.finish();
    }
}
