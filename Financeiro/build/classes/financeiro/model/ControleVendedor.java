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
public class ControleVendedor {

    private Long id;
    private String nomeVenda;
    private Double valorVenda;
    private Timestamp datahoraVenda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeVenda() {
        return nomeVenda;
    }

    public void setNomeVenda(String nomeVenda) {
        this.nomeVenda = nomeVenda;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Timestamp getDatahoraVenda() {
        return datahoraVenda;
    }

    public void setDatahoraVenda(Timestamp datahoraVenda) {
        this.datahoraVenda = datahoraVenda;
    }
    
    

}