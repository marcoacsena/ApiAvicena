package br.com.marcoapps.apiavicena.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import br.com.marcoapps.apiavicena.R;
import br.com.marcoapps.apiavicena.controller.AgendaConsultasController;

public class AgendaConsultas extends AppCompatActivity {

    private AgendaConsultasController control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_consultas);
        control = new AgendaConsultasController (this);
    }

    public void voltar(View view) {
        control.voltarAction();
    }

    public void atualizar(View view) {
        control.atualizarAction();
    }
}
