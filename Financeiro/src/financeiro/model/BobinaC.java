/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.model;

import java.io.Serializable;
import javax.swing.text.html.parser.Entity;

/**
 *
 * @author Ledilson
 */

public class BobinaC {

    private Long id;
    private String nomeBobina;
    private double valorBobina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeBobina() {
        return nomeBobina;
    }

    public void setNomeBobina(String nomeBobina) {
        this.nomeBobina = nomeBobina;
    }

    public double getValorBobina() {
        return valorBobina;
    }

    public void setValorBobina(double valorBobina) {
        this.valorBobina = valorBobina;
    }
 

}
