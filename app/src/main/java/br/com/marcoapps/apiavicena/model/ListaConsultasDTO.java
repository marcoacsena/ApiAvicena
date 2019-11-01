package br.com.marcoapps.apiavicena.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaConsultasDTO {

    private List<ConsultaDTO> listaConsultasDTO;

    public ListaConsultasDTO(List<ConsultaDTO> listaConsultasDTO) {
        this.listaConsultasDTO = listaConsultasDTO;
    }

    public ListaConsultasDTO() {
    }

    public List<ConsultaDTO> getListaConsultasDTO() {
        return listaConsultasDTO;
    }

    public void setListaConsultasDTO(List<ConsultaDTO> listaConsultasDTO) {
        this.listaConsultasDTO = listaConsultasDTO;
    }

    public List<Consulta> getConsultas(){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        Date data = null;
        List<Consulta> consultas = new ArrayList<>();
        Consulta c = new Consulta();
        for(int i = 0; i<listaConsultasDTO.size(); i++) {
            try {
                data = formatador.parse(listaConsultasDTO.get(i).getDataConsulta());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            c.setPaciente(listaConsultasDTO.get(i).getPaciente());
            c.setHorarioConsulta(listaConsultasDTO.get(i).getHorarioConsulta());
            c.setEspecializacao(listaConsultasDTO.get(i).getEspecializacao());
            c.setDataConsulta(data);
            c.setConvenio(listaConsultasDTO.get(i).getConvenio());
            c.setCodigoConsulta(listaConsultasDTO.get(i).getCodigoConsulta());
            consultas.add(c);
        }
        return consultas;
    }

}
