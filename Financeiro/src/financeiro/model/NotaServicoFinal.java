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
public class NotaServicoFinal {
    
private Long id;  
private Timestamp datahora ;
private String prestador; 
private String tomador;  
private String descricao;  
private int quantidade; 
private Double precoProduto;  
private Double Pesoproduto;  
private Double totalProduto;  
private Double freteProduto;  
private Double impostoProduto;  
private Double comissaoProduto;  
private Double apagarProduto;  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDatahora() {
        return datahora;
    }

    public void setDatahora(Timestamp datahora) {
        this.datahora = datahora;
    }

    public String getPrestador() {
        return prestador;
    }

    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }

    public String getTomador() {
        return tomador;
    }

    public void setTomador(String tomador) {
        this.tomador = tomador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Double getPesoproduto() {
        return Pesoproduto;
    }

    public void setPesoproduto(Double Pesoproduto) {
        this.Pesoproduto = Pesoproduto;
    }

    public Double getTotalProduto() {
        return totalProduto;
    }

    public void setTotalProduto(Double totalProduto) {
        this.totalProduto = totalProduto;
    }

    public Double getFreteProduto() {
        return freteProduto;
    }

    public void setFreteProduto(Double freteProduto) {
        this.freteProduto = freteProduto;
    }

    public Double getImpostoProduto() {
        return impostoProduto;
    }

    public void setImpostoProduto(Double impostoProduto) {
        this.impostoProduto = impostoProduto;
    }

    public Double getComissaoProduto() {
        return comissaoProduto;
    }

    public void setComissaoProduto(Double comissaoProduto) {
        this.comissaoProduto = comissaoProduto;
    }

    public Double getApagarProduto() {
        return apagarProduto;
    }

    public void setApagarProduto(Double apagarProduto) {
        this.apagarProduto = apagarProduto;
    }

}
