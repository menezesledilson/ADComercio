 
package financeiro.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Ledilson
 */
public class NotaCheia {

    private Long id;
    private String nomeEmpresa;
    private String nomeProduto;
    private int quantidade;

    private Double pesoPapel;
    private Double valorUnitario;
    private Double totalSipi;
    private Double totalCipi;
    private Double ValorIpi;
    private Double diferencialIpi;
    
    private Date DataPedido;
    private Date DataEntrega;
    private Double Ipi;
   
    private Timestamp dataHora;

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

    public Date getDataPedido() {
        return DataPedido;
    }

    public void setDataPedido(Date DataPedido) {
        this.DataPedido = DataPedido;
    }

    public Date getDataEntrega() {
        return DataEntrega;
    }

    public void setDataEntrega(Date DataEntrega) {
        this.DataEntrega = DataEntrega;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    
   
}
