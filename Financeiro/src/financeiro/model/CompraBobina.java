/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.model;

import java.sql.Date;

/**
 *
 * @author Ledilson
 */
public class CompraBobina {
    private Long id;
    private  String descricaoPedido ;
    private String nomeEmpresa;
    private Date dataPedido;
    private int quantPedido;
    private Double pesoPapelPedido;
    private Double valorUnitarioPedido;
    private Double totalGeralPedido;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public int getQuantPedido() {
        return quantPedido;
    }

    public void setQuantPedido(int quantPedido) {
        this.quantPedido = quantPedido;
    }

    public Double getPesoPapelPedido() {
        return pesoPapelPedido;
    }

    public void setPesoPapelPedido(Double pesoPapelPedido) {
        this.pesoPapelPedido = pesoPapelPedido;
    }

    public Double getValorUnitarioPedido() {
        return valorUnitarioPedido;
    }

    public void setValorUnitarioPedido(Double valorUnitarioPedido) {
        this.valorUnitarioPedido = valorUnitarioPedido;
    }

    public Double getTotalGeralPedido() {
        return totalGeralPedido;
    }

    public void setTotalGeralPedido(Double totalGeralPedido) {
        this.totalGeralPedido = totalGeralPedido;
    }

  
}
