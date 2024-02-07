package financeiro.model;

import java.sql.Timestamp;

/**
 *
 * @author Ledilson
 */
public class PagamentoFabrica {

    private Long id;
    private Timestamp datahora;
    private String NomePagamento;
    private Double ValorPagamento;
    private String ObservacaoVenda;

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

    public String getNomePagamento() {
        return NomePagamento;
    }

    public void setNomePagamento(String NomePagamento) {
        this.NomePagamento = NomePagamento;
    }

    public Double getValorPagamento() {
        return ValorPagamento;
    }

    public void setValorPagamento(Double ValorPagamento) {
        this.ValorPagamento = ValorPagamento;
    }

    public String getObservacaoVenda() {
        return ObservacaoVenda;
    }

    public void setObservacaoVenda(String ObservacaoVenda) {
        this.ObservacaoVenda = ObservacaoVenda;
    }

}
