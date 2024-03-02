/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Ledilson
 */
public class PedidoBobina {

    private Long id;
    private String nomeClientePedido;
    private double valorPedido;
    private int quantidadeBobina;
    private String observacaoPagamento;
    private String observacaoFrete;
    private String pagPedido;
    private Date dataPedido;
    private Date dataEntrega;
    private String numeroChequeA;
    private String numeroChequeB;
    private String numeroChequeC;
    
     private Timestamp dataHora;

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }
    

    public String getObservacaoPagamento() {
        return observacaoPagamento;
    }

    public void setObservacaoPagamento(String observacaoPagamento) {
        this.observacaoPagamento = observacaoPagamento;
    }

    public String getObservacaoFrete() {
        return observacaoFrete;
    }

    public void setObservacaoFrete(String observacaoFrete) {
        this.observacaoFrete = observacaoFrete;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeClientePedido() {
        return nomeClientePedido;
    }

    public void setNomeClientePedido(String nomeClientePedido) {
        this.nomeClientePedido = nomeClientePedido;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public int getQuantidadeBobina() {
        return quantidadeBobina;
    }

    public void setQuantidadeBobina(int quantidadeBobina) {
        this.quantidadeBobina = quantidadeBobina;
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

    public String getNumeroChequeA() {
        return numeroChequeA;
    }

    public void setNumeroChequeA(String numeroChequeA) {
        this.numeroChequeA = numeroChequeA;
    }

    public String getNumeroChequeB() {
        return numeroChequeB;
    }

    public void setNumeroChequeB(String numeroChequeB) {
        this.numeroChequeB = numeroChequeB;
    }

    public String getNumeroChequeC() {
        return numeroChequeC;
    }

    public void setNumeroChequeC(String numeroChequeC) {
        this.numeroChequeC = numeroChequeC;
    }

   

    public String getPagPedido() {
        return pagPedido;
    }

    public void setPagPedido(String pagPedido) {
        this.pagPedido = pagPedido;
    }

}
