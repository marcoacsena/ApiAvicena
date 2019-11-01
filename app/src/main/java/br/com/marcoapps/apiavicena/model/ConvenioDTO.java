package br.com.marcoapps.apiavicena.model;

public class ConvenioDTO {

    private Integer codigoConvenio;
    private String nomeConvenio;
    private String valorConvenio;

    public ConvenioDTO() {
    }

    public ConvenioDTO(Integer codigoConvenio, String nomeConvenio, String valorConvenio) {
        this.codigoConvenio = codigoConvenio;
        this.nomeConvenio = nomeConvenio;
        this.valorConvenio = valorConvenio;
    }

    public Integer getCodigoConvenio() {
        return codigoConvenio;
    }

    public void setCodigoConvenio(Integer codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public String getValorConvenio() {
        return valorConvenio;
    }

    public void setValorConvenio(String valorConvenio) {
        this.valorConvenio = valorConvenio;
    }


    public Convenio getConvenio(){

      Convenio c = new Convenio();
      c.setCodigoConvenio(codigoConvenio);
      c.setValorConvenio(valorConvenio);
      c.setNomeConvenio(nomeConvenio);

        return c;
    }

    @Override
    public String toString() {
        return "ConvenioDTO{" +
                "codigoConvenio=" + codigoConvenio +
                ", nomeConvenio='" + nomeConvenio + '\'' +
                ", valorConvenio='" + valorConvenio + '\'' +
                '}';
    }
}
