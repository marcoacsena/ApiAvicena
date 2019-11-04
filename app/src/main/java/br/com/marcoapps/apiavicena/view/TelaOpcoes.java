package br.com.marcoapps.apiavicena.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import br.com.marcoapps.apiavicena.R;
import br.com.marcoapps.apiavicena.controller.TelaOpcoesController;

public class TelaOpcoes extends AppCompatActivity {
    private TelaOpcoesController control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_opcoes);
        control = new TelaOpcoesController(this);
    }

    public void acessarAgenda(View view) {
        control.acessarAgendaAction();
    }

    public void atualizarDados(View view) {
        control.atualizarDadosAction();
    }

    public void sair(View view) {
        control.sairAction();
    }
}
