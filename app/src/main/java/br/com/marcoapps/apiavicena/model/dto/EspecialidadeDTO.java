package br.com.marcoapps.apiavicena.model.dto;

import br.com.marcoapps.apiavicena.model.vo.Especialidade;

public class EspecialidadeDTO {

    private Integer codigoEspecialidade;
    private String nomeEspecialidade;
    private String instituicao;

    public EspecialidadeDTO() {
    }

    public EspecialidadeDTO(Integer codigoEspecialidade, String nomeEspecialidade, String instituicao) {
        this.codigoEspecialidade = codigoEspecialidade;
        this.nomeEspecialidade = nomeEspecialidade;
        instituicao = instituicao;
    }

    public Integer getCodigoEspecialidade() {
        return codigoEspecialidade;
    }

    public void setCodigoEspecialidade(Integer codigoEspecialidade) {
        this.codigoEspecialidade = codigoEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public Especialidade getEspecialidde(){

        Especialidade e = new Especialidade();
        e.setCodigoEspecialidade(codigoEspecialidade);
        e.setNomeEspecialidade(nomeEspecialidade);
        e.setInstituicao(instituicao);

        return e;
    }

    @Override
    public String toString() {
        return "EspecialidadeDTO{" +
                "codigoEspecialidade=" + codigoEspecialidade +
                ", nomeEspecialidade='" + nomeEspecialidade + '\'' +
                ", Instituicao='" + instituicao + '\'' +
                '}';
    }
}
