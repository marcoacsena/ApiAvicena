package br.com.marcoapps.apiavicena.model.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.marcoapps.apiavicena.model.vo.Consulta;

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

        List<Consulta> consultas = new ArrayList<>();
        Consulta c = new Consulta();
        for(int i = 0; i<listaConsultasDTO.size(); i++) {

            c.setPaciente(listaConsultasDTO.get(i).getPacienteDTO().getPaciente());
            c.setHorarioConsulta(listaConsultasDTO.get(i).getHorarioConsulta());
            c.setDataConsulta(listaConsultasDTO.get(i).getDataConsulta());

            c.setCodigoConsulta(listaConsultasDTO.get(i).getCodigoConsulta());
            consultas.add(c);
        }
        return consultas;
    }

}
