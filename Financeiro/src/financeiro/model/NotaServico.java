/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.model;

import java.sql.Timestamp;

/**
 *
 * @author Ledilson
 */
public class NotaServico {

    private Long id;
    private Timestamp dataEmissaoNota;
    private String clienteEmpresa;
    private String clienteFornecedor;
    private String nomeProduto;

    private int quantProduto;

    private Double valorUnitario;
    private Double pesoUnitario;

    private Double cargaInicial;

    private Double frete;
    private Double totalFrete;

    private Double imposto;
    private Double totalImposto;

    private Double Comissao;
    private Double totalComissao;

    private Double totalCargaFinal;
    
     private Double totalFinalCarga;
     

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

    public String getClienteFornecedor() {
        return clienteFornecedor;
    }

    public void setClienteFornecedor(String clienteFornecedor) {
        this.clienteFornecedor = clienteFornecedor;
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

    public Double getFrete() {
        return frete;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }

    public Double getTotalFrete() {
        return totalFrete;
    }

    public void setTotalFrete(Double totalFrete) {
        this.totalFrete = totalFrete;
    }

    public Double getImposto() {
        return imposto;
    }

    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }

    public Double getTotalImposto() {
        return totalImposto;
    }

    public void setTotalImposto(Double totalImposto) {
        this.totalImposto = totalImposto;
    }

    public Double getComissao() {
        return Comissao;
    }

    public void setComissao(Double Comissao) {
        this.Comissao = Comissao;
    }

    public Double getTotalComissao() {
        return totalComissao;
    }

    public void setTotalComissao(Double totalComissao) {
        this.totalComissao = totalComissao;
    }

    public Double getTotalCargaFinal() {
        return totalCargaFinal;
    }

    public void setTotalCargaFinal(Double totalCargaFinal) {
        this.totalCargaFinal = totalCargaFinal;
    }

    public Double getTotalFinalCarga() {
        return totalFinalCarga;
    }

    public void setTotalFinalCarga(Double totalFinalCarga) {
        this.totalFinalCarga = totalFinalCarga;
    }

}
