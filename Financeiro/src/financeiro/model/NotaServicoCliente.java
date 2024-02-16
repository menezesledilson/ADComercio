package financeiro.model;

import java.sql.Timestamp;

public class NotaServicoCliente {

    private Long id;
    private Timestamp dataEmissaoNota;
    private String clienteEmpresa;

    private String nomeProduto;

    private int quantProduto;

    private Double valorUnitario;
    private Double pesoUnitario;

    private Double cargaInicial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDataEmissaoNota() {
        return dataEmissaoNota;
    }

    public void setDataEmissaoNota(Timestamp dataEmissaoNota) {
        this.dataEmissaoNota = dataEmissaoNota;
    }

    public String getClienteEmpresa() {
        return clienteEmpresa;
    }

    public void setClienteEmpresa(String clienteEmpresa) {
        this.clienteEmpresa = clienteEmpresa;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantProduto() {
        return quantProduto;
    }

    public void setQuantProduto(int quantProduto) {
        this.quantProduto = quantProduto;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getPesoUnitario() {
        return pesoUnitario;
    }

    public void setPesoUnitario(Double pesoUnitario) {
        this.pesoUnitario = pesoUnitario;
    }

    public Double getCargaInicial() {
        return cargaInicial;
    }

    public void setCargaInicial(Double cargaInicial) {
        this.cargaInicial = cargaInicial;
    }

}
