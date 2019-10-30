package br.com.marcoapps.apiavicena.controller;

import android.app.Activity;
import android.content.Intent;
import android.print.PrinterId;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.Arrays;

import br.com.marcoapps.apiavicena.R;
import br.com.marcoapps.apiavicena.model.Usuario;
import br.com.marcoapps.apiavicena.model.UsuarioBO;
import br.com.marcoapps.apiavicena.model.UsuarioDTO;
import br.com.marcoapps.apiavicena.view.OpcoesActivity;
import cz.msebera.android.httpclient.Header;

public class UsuarioController {
    
    private Activity activity;
    private EditText editLogin;
    private EditText editSenha;

    private Usuario usuario;

    public UsuarioController(Activity activity) {
        this.activity = activity;
        initComponents();
        usuario = new Usuario();
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

        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://localhost",
                new AsyncHttpResponseHandler() {

                    @Override
                    public void onStart(){

                        super.onStart();
                        Toast.makeText(activity, "A validação do Usuario foi iniciada...", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(int i, Header[] headers, byte[] bytes) {

                        //retorno em string da apiavicena em Json

                        String usuarioEmJson = new String(bytes);

                        //conversao da string json para objeto
                        Gson gson = new Gson();

                        UsuarioDTO usuarioDTO = gson.fromJson(usuarioEmJson, UsuarioDTO.class);
                        usuario = usuarioDTO.getUsurio();
                        chamarTelaOpcoes(usuario);

                    }

                    @Override
                    public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

                        limparDados();
                    }
                });

    }

    private void chamarTelaOpcoes(Usuario usuario){


        Intent it = new Intent(activity, OpcoesActivity.class);
        it.putExtra("usuario", usuario);
        activity.startActivity(it);
    }

    private void limparDados() {

        editLogin.setText("");
        editSenha.setText("");
    }


}
