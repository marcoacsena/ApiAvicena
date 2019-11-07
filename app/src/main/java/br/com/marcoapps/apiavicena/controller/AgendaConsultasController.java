package br.com.marcoapps.apiavicena.controller;

import android.app.Activity;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.marcoapps.apiavicena.R;
import br.com.marcoapps.apiavicena.model.dto.ConsultaDTO;
import br.com.marcoapps.apiavicena.model.dto.ListaConsultasDTO;
import br.com.marcoapps.apiavicena.model.vo.AdapterConsulta;
import br.com.marcoapps.apiavicena.model.vo.Consulta;
import cz.msebera.android.httpclient.Header;

public class AgendaConsultasController {

    private Activity activity;
    private ListView lvConsultas;
    private List<Consulta> listConsultas;
    private AdapterConsulta adapterConsulta;

    public AgendaConsultasController(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        lvConsultas = activity.findViewById(R.id.lvConsultas);
        configListView();
    }

    private void configListView() {
        String email = activity.getIntent().getStringExtra("email");

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://10.10.100.193:8080/ApiAvicena/api/consulta/" + email , new AsyncHttpResponseHandler() {

            @Override
            public void onStart(){

                super.onStart();
                Toast.makeText(activity, "Agenda do médico foi iniciada...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {

                //  retorno em string da apiavicena em Json
                String agendaEmJson = new String(bytes);
                //conversao da string json para objeto
                Gson gson = new Gson();

                Type consultasListType = new TypeToken<ArrayList<ConsultaDTO>>(){}.getType();
                List<ConsultaDTO> listConsultas = gson.fromJson(agendaEmJson, consultasListType);
                ListaConsultasDTO listaConsultasDTO = new ListaConsultasDTO();
                listaConsultasDTO.setListaConsultasDTO(listConsultas);
                if(listaConsultasDTO != null) {

                    adapterConsulta = new AdapterConsulta(listaConsultasDTO.getConsultas(), activity);
                    lvConsultas.setAdapter(adapterConsulta);

                }else{
                    Toast.makeText(activity, "Não foi possível carregar a agenda.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Não foi possível carregar a agenda.", Toast.LENGTH_SHORT).show();

            }

        });

    }
    public void voltarAction(){
        activity.finish();
    }
}
