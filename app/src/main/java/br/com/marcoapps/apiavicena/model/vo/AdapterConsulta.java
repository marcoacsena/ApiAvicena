package br.com.marcoapps.apiavicena.model.vo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.marcoapps.apiavicena.R;

public class AdapterConsulta extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Consulta> listConsultas;
    private Context context;

    public AdapterConsulta(List<Consulta> listConsultas, Context context) {
        this.listConsultas = listConsultas;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return listConsultas.size();
    }

    @Override
    public Object getItem(int position) {
        return listConsultas.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void add (Consulta c){
        listConsultas.add(c);
        this.notifyDataSetChanged();
    }

    public void remove (Consulta c){
        listConsultas.remove(c);
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //resgatar a pessoa da lista
        final Consulta consulta = listConsultas.get(position);
        //resgatar o layout do item
        convertView = inflater.inflate(R.layout.item_lv_agenda_consulta, null);
        //resgatar os elementos para saida dos dados
        TextView tvNome = convertView.findViewById(R.id.tvNome);
        TextView tvData = convertView.findViewById(R.id.tvData);
        TextView tvHorario = convertView.findViewById(R.id.tvHorario);
        TextView tvAtencaoEspecial = convertView.findViewById(R.id.tvAtencaoEspecial);
        //mandar dados para o layout
        tvNome.setText(consulta.getPaciente().getNomePaciente());
        tvData.setText(consulta.getDataConsulta());
        tvHorario.setText(consulta.getHorarioConsulta());
        tvAtencaoEspecial.setText(consulta.getAtencaoEspecial());

        return convertView;
    }
}

