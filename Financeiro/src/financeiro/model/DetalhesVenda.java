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
public class DetalhesVenda {
    
    private Long id;
    
    private int quantVenda;
    private Long idBobina;
    private Long idCompra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantVenda() {
        return quantVenda;
    }

    public void setQuantVenda(int quantVenda) {
        this.quantVenda = quantVenda;
    }

    public Long getIdBobina() {
        return idBobina;
    }

    public void setIdBobina(Long idBobina) {
        this.idBobina = idBobina;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }
    
    
    
}
