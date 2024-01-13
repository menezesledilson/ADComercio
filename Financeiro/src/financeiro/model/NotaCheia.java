/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.model;

/**
 *
 * @author Ledilson
 */
public class NotaCheia {

    public Long id;
    public String nomeEmpresa;
    public String nomeProduto;
    public int quantidade;

    public Double pesoPapel;
    public Double valorUnitario;
    public Double totalSipi;
    public Double totalCipi;
    public Double ValorIpi;
    public Double diferencialIpi;

    public Double Ipi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPesoPapel() {
        return pesoPapel;
    }

    public void setPesoPapel(Double pesoPapel) {
        this.pesoPapel = pesoPapel;
    }

    public Double getTotalSipi() {
        return totalSipi;
    }

    public void setTotalSipi(Double totalSipi) {
        this.totalSipi = totalSipi;
    }

    public Double getTotalCipi() {
        return totalCipi;
    }

    public void setTotalCipi(Double totalCipi) {
        this.totalCipi = totalCipi;
    }

    public Double getValorIpi() {
        return ValorIpi;
    }

    public void setValorIpi(Double ValorIpi) {
        this.ValorIpi = ValorIpi;
    }

    public Double getIpi() {
        return Ipi;
    }

    public void setIpi(Double Ipi) {
        this.Ipi = Ipi;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getDiferencialIpi() {
        return diferencialIpi;
    }

    public void setDiferencialIpi(Double diferencialIpi) {
        this.diferencialIpi = diferencialIpi;
    }

}
