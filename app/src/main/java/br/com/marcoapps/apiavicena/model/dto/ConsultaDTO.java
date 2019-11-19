package br.com.marcoapps.apiavicena.model.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.marcoapps.apiavicena.model.vo.Consulta;
import br.com.marcoapps.apiavicena.model.vo.Convenio;
import br.com.marcoapps.apiavicena.model.vo.Especializacao;
import br.com.marcoapps.apiavicena.model.vo.Paciente;

public class ConsultaDTO {

    private Integer codigoConsulta;
    private PacienteDTO pacienteVO;
    private String dataConsulta;
    private String horarioConsulta;
    private String atencaoEspecial;

    public ConsultaDTO() {
    }

    public ConsultaDTO(Integer codigoConsulta, PacienteDTO pacienteVO, String dataConsulta, String horarioConsulta, String atencaoEspecial) {
        this.codigoConsulta = codigoConsulta;
        this.pacienteVO = pacienteVO;
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
        this.atencaoEspecial = atencaoEspecial;
    }

    public Integer getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(Integer codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public PacienteDTO getPacienteVO() {
        return pacienteVO;
    }

    public void setPacienteVO(PacienteDTO pacienteVO) {
        this.pacienteVO = pacienteVO;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public String getAtencaoEspecial() {
        return atencaoEspecial;
    }

    public void setAtencaoEspecial(String atencaoEspecial) {
        this.atencaoEspecial = atencaoEspecial;
    }

    public List<Consulta> getConsulta(){
        Consulta c = new Consulta();
        List<Consulta> consultas = new ArrayList<>();
         c.setCodigoConsulta(codigoConsulta);
         c.setDataConsulta(dataConsulta);
         c.setAtencaoEspecial(atencaoEspecial);
         c.setHorarioConsulta(horarioConsulta);
         c.setPaciente(pacienteVO.getPaciente());
         consultas.add(c);
         return consultas;
    }

    @Override
    public String toString() {

     //   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return "ConsultaDTO{" +
                "codigoConsulta=" + codigoConsulta +
                ", pacienteVO=" + pacienteVO +
                ", dataConsulta='" +  (dataConsulta) + '\'' +
                ", horarioConsulta='" + horarioConsulta + '\'' +
                ", atencaoEspecial='" + atencaoEspecial + '\'' +
                '}';
    }
}
