/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.model;

import static java.sql.JDBCType.TIMESTAMP;
import java.sql.Timestamp;
import net.sf.jasperreports.repo.DefaultRepositoryPersistenceServiceFactory;

/**
 *
 * @author Ledilson
 */
public class HistoricoCaixa {

    private Long id;
    private Timestamp datahora;
    private String descricao;
    private double entrada;
    private double saida;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public double getSaida() {
        return saida;
    }

    public void setSaida(double saida) {
        this.saida = saida;
    }

}
