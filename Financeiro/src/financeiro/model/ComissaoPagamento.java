/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Ledilson
 */
public class ComissaoPagamento {

    private Long id;
    private String nome;
    private String empresa;

    private Date dataPedido;
    private Date dataEntrega;
    
    
    private Double precoCheia;
    private Double precoFabrica;
    
    private Double valorComissao;
    
    private Timestamp datahora;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Double getPrecoCheia() {
        return precoCheia;
    }

    public void setPrecoCheia(Double precoCheia) {
        this.precoCheia = precoCheia;
    }

    public Double getPrecoFabrica() {
        return precoFabrica;
    }

    public void setPrecoFabrica(Double precoFabrica) {
        this.precoFabrica = precoFabrica;
    }

    public Double getValorComissao() {
        return valorComissao;
    }

    public void setValorComissao(Double valorComissao) {
        this.valorComissao = valorComissao;
    }

    
}
