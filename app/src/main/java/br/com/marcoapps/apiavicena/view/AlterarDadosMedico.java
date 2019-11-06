package br.com.marcoapps.apiavicena.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import br.com.marcoapps.apiavicena.R;
import br.com.marcoapps.apiavicena.controller.AlterarDadosMedicoController;

public class AlterarDadosMedico extends AppCompatActivity {

    private AlterarDadosMedicoController control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_dados_medico);
        control = new AlterarDadosMedicoController(this);
    }


    public void alterarDados(View view) {
        control.alterarDadosAction();
    }

    public void voltar(View view) {
        control.voltarAction();
    }
}
