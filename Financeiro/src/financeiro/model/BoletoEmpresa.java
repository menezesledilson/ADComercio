/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.model;

import java.math.BigDecimal;
import java.sql.Date;
import static org.postgresql.util.ByteConverter.numeric;
import static org.postgresql.util.ByteConverter.numeric;

/**
 *
 * @author Ledilson
 */
public class BoletoEmpresa {

    private Long id;
    private String boletoClienteReceber;
    private Date dataClienteReceber;
    private Double receberClienteValor;
    private String boletoEmpresaPagar;
    private Date dataEmpresaPagar;
    private Double PagarEmpresaValor;
    private String Observacao;
    private String Status;
    private String numeroNota;

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }
    
    

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoletoClienteReceber() {
        return boletoClienteReceber;
    }

    public void setBoletoClienteReceber(String boletoClienteReceber) {
        this.boletoClienteReceber = boletoClienteReceber;
    }

    public Date getDataClienteReceber() {
        return dataClienteReceber;
    }

    public void setDataClienteReceber(Date dataClienteReceber) {
        this.dataClienteReceber = dataClienteReceber;
    }

    public Double getReceberClienteValor() {
        return receberClienteValor;
    }

    public void setReceberClienteValor(Double receberClienteValor) {
        this.receberClienteValor = receberClienteValor;
    }

    public String getBoletoEmpresaPagar() {
        return boletoEmpresaPagar;
    }

    public void setBoletoEmpresaPagar(String boletoEmpresaPagar) {
        this.boletoEmpresaPagar = boletoEmpresaPagar;
    }

    public Date getDataEmpresaPagar() {
        return dataEmpresaPagar;
    }

    public void setDataEmpresaPagar(Date dataEmpresaPagar) {
        this.dataEmpresaPagar = dataEmpresaPagar;
    }

    public Double getPagarEmpresaValor() {
        return PagarEmpresaValor;
    }

    public void setPagarEmpresaValor(Double PagarEmpresaValor) {
        this.PagarEmpresaValor = PagarEmpresaValor;
    }

}
