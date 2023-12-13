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
public class CalculoNF {

    private Long id;
    private Long idbobina;
    
    private String descricao;
    private Date dataEmissao;
    private int quantidade;

    private double pesoPapel;
    private double valorUnitario;

    private double frete;
    private double impostoIpi;
    private double comissao;
    private double valorApagar;
    private double totalCarga;

    public Long getIdbobina() {
        return idbobina;
    }

    public void setIdbobina(Long idbobina) {
        this.idbobina = idbobina;
    }
    
                           

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPesoPapel() {
        return pesoPapel;
    }

    public void setPesoPapel(double pesoPapel) {
        this.pesoPapel = pesoPapel;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public double getImpostoIpi() {
        return impostoIpi;
    }

    public void setImpostoIpi(double impostoIpi) {
        this.impostoIpi = impostoIpi;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getValorApagar() {
        return valorApagar;
    }

    public void setValorApagar(double valorApagar) {
        this.valorApagar = valorApagar;
    }

    public double getTotalCarga() {
        return totalCarga;
    }

    public void setTotalCarga(double totalCarga) {
        this.totalCarga = totalCarga;
    }
    
    

}
