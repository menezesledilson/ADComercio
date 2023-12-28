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
public class PedidoBobina {
    private Long id;
    private String nomeClientePedido;
    private double valorPedido;
    private int quantidadeBobina;
    private Date dataPedido;
    private Date dataEntrega;
    private int numeroChequeA;
    private int numeroChequeB;
    private int numeroChequeC;

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

    public int getNumeroChequeA() {
        return numeroChequeA;
    }

    public void setNumeroChequeA(int numeroChequeA) {
        this.numeroChequeA = numeroChequeA;
    }

    public int getNumeroChequeB() {
        return numeroChequeB;
    }

    public void setNumeroChequeB(int numeroChequeB) {
        this.numeroChequeB = numeroChequeB;
    }

    public int getNumeroChequeC() {
        return numeroChequeC;
    }

    public void setNumeroChequeC(int numeroChequeC) {
        this.numeroChequeC = numeroChequeC;
    }
    
}
