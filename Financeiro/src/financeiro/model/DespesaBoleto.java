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
public class DespesaBoleto {

    private Long id;
    private String boletoClienteReceber;
    private Date dataReceber;
    private double receberValor;

    private String boletoEmpresaPagar;
    private Date dataPagar;
    private double PagarValor;

}
