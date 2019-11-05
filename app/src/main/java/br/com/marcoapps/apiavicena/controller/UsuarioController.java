package br.com.marcoapps.apiavicena.controller;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import br.com.marcoapps.apiavicena.R;
import br.com.marcoapps.apiavicena.model.vo.Usuario;
import br.com.marcoapps.apiavicena.model.bo.UsuarioBO;
import br.com.marcoapps.apiavicena.model.dto.UsuarioDTO;
import br.com.marcoapps.apiavicena.view.TelaOpcoes;
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

        usuario = pegarDadosDoForm();

        UsuarioBO usuarioBO = new UsuarioBO(usuario);

        if(validar(usuarioBO)){
                validarLoginESenha(usuario);
        }
    }

    private Usuario pegarDadosDoForm() {
        usuario = new Usuario();
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

    private void validarLoginESenha(Usuario usuario) {

        Gson gson = new Gson();
        RequestParams parametros = new RequestParams();
        parametros.put("dado", gson.toJson(usuario));
        AsyncHttpClient client = new AsyncHttpClient();
        client.post("http://192.168.43.108:8080/ApiAvicena/api/usuario", parametros , new AsyncHttpResponseHandler() {

            @Override
            public void onStart(){

                 super.onStart();
                 Toast.makeText(activity, "A validação do Usuario foi iniciada...", Toast.LENGTH_SHORT).show();
                    }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {

              //  retorno em string da apiavicena em Json

                String usuarioEmJson = new String(bytes);
                //conversao da string json para objeto
                Gson gson = new Gson();

                UsuarioDTO usuarioDTO = gson.fromJson(usuarioEmJson, UsuarioDTO.class);
                Usuario usuario = usuarioDTO.getUsurio();
                if(usuario.getId()!=null) {
                    chamarTelaOpcoes(usuario);
                    Toast.makeText(activity, usuario.toString(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(activity, "Usuario invalido", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                limparDados();
            }

               });

    }

    private void chamarTelaOpcoes(Usuario usuario){
        Intent it = new Intent(activity, TelaOpcoes.class);
        it.putExtra("usuario", usuario);
        activity.startActivity(it);
    }

    private void limparDados() {

        editLogin.setText("");
        editSenha.setText("");
    }


}
