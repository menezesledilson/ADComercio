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
public class Credencial {

    private Long id;
    private String usuarios;
    private String senhas;
    private String nivelAcesso;

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public String getSenhas() {
        return senhas;
    }

    public void setSenhas(String senhas) {
        this.senhas = senhas;
    }

}
