package br.com.marcoapps.apiavicena.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.dao.Dao;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.marcoapps.apiavicena.R;
import br.com.marcoapps.apiavicena.model.dao.db.ConsultaDao;
import br.com.marcoapps.apiavicena.model.dao.db.PacienteDao;
import br.com.marcoapps.apiavicena.model.dto.ConsultaDTO;
import br.com.marcoapps.apiavicena.model.dto.ListaConsultasDTO;
import br.com.marcoapps.apiavicena.model.vo.AdapterConsulta;
import br.com.marcoapps.apiavicena.model.vo.Consulta;
import br.com.marcoapps.apiavicena.model.vo.Paciente;
import cz.msebera.android.httpclient.Header;

public class AgendaConsultasController {

    private Activity activity;
    private ListView lvConsultas;
    private List<Consulta> listaConsultas;
    private AdapterConsulta adapterConsulta;
    private ConsultaDao consultaDao;
    private Consulta consulta;
    private PacienteDao pacienteDao;
    private Paciente paciente;

    public AgendaConsultasController(Activity activity) {
        this.activity = activity;
        consultaDao = new ConsultaDao(activity);
        consulta = new Consulta();
        paciente = new Paciente();
        pacienteDao = new PacienteDao(activity);
        initComponents();
    }

    private void initComponents() {
        lvConsultas = activity.findViewById(R.id.lvConsultas);
        configListView();
    }

    private void configListView() {
        String email = activity.getIntent().getStringExtra("email");

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.43.108:8080/ApiAvicena/api/consulta/" + email, new AsyncHttpResponseHandler() {
//192.168.43.108
            //192.168.0.105
            @Override
            public void onStart() {

                super.onStart();
                Toast.makeText(activity, "Agenda do médico foi iniciada...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {

                //  retorno em string da apiavicena em Json
                String agendaEmJson = new String(bytes);
                //conversao da string json para objeto
                Gson gson = new Gson();

                Type consultasListType = new TypeToken<ArrayList<ConsultaDTO>>() {
                }.getType();
                List<ConsultaDTO> listConsultas = gson.fromJson(agendaEmJson, consultasListType);
                ListaConsultasDTO listaConsultasDTO = new ListaConsultasDTO();
                listaConsultasDTO.setListaConsultasDTO(listConsultas);
                if (listaConsultasDTO != null) {
                    for (Consulta c:listaConsultasDTO.getConsultas()) {
                        try {
                            paciente = c.getPaciente();
                            pacienteDao.getDao().createIfNotExists(paciente);
                            consultaDao.getDao().createIfNotExists(c);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                    try {
                        adapterConsulta = new AdapterConsulta(consultaDao.getDao().queryForAll(), activity);
                        lvConsultas.setAdapter(adapterConsulta);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

//                    adapterConsulta = new AdapterConsulta(listaConsultasDTO.getConsultas(), activity);
//                    lvConsultas.setAdapter(adapterConsulta);

                    cliqueLongo();

                } else {
                    Toast.makeText(activity, "Não foi possível carregar a agenda.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Não foi possível carregar a agenda.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void voltarAction() {
        activity.finish();
    }


    private void cliqueLongo() {
        lvConsultas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                consulta = (Consulta) adapterConsulta.getItem(i);
                dialogExcluirConsulta(consulta);
                return true; //executa somente clique longo
            }
        });

    }

    private void dialogExcluirConsulta(final Consulta c) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setTitle("Excluir Item");
        alerta.setIcon(android.R.drawable.ic_menu_delete);
        alerta.setMessage(c.toString());
        alerta.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                consulta = null;
            }
        });
        alerta.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                try {
                    if (consultaDao.getDao().delete(c) > 0) {
                        excluirConsultaLv(c);

                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                consulta = null;
            }
        });
        alerta.show();
    }

    private void excluirConsultaLv(Consulta c) {
        adapterConsulta.remove(c);
    }


}
