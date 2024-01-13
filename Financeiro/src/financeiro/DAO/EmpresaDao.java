/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ledilson
 */
public class EmpresaDao {

   public void adicionar(Empresa empresa) {
    Connection con = Conexao.getConnection();
    PreparedStatement pstm = null;

    try {
        pstm = con.prepareStatement("INSERT INTO empresa(nome, uf, cnpj, celular) VALUES (?, ?, ?, ?);");

        pstm.setString(1, empresa.getNome());
        pstm.setString(2, empresa.getUF());
        pstm.setString(3, empresa.getCNPJ());
        pstm.setString(4, empresa.getCelular());

        pstm.execute();

        JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    } catch (SQLException sqlException) {
        // Logar a exceção
        sqlException.printStackTrace();
        // Mostrar uma mensagem mais específica para o usuário
        JOptionPane.showMessageDialog(null, "Erro SQL ao adicionar no banco: " + sqlException.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    } finally {
        Conexao.closeConnection(con, pstm);
    }
}


    public void alterar(Empresa empresa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("update empresa set nome = ?, cnpj=?, uf = ?, celular = ? where id =?;");

            pstm.setString(1, empresa.getNome());
            pstm.setString(2, empresa.getCNPJ());
            pstm.setString(3, empresa.getUF());
            pstm.setString(4, empresa.getCelular());

            pstm.setLong(5, empresa.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public List<Empresa> listarEmpresa() {
        List<Empresa> empresas = new ArrayList<>();

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT * FROM bobina ORDER BY nomebobina ASC;");
            rs = pstm.executeQuery();

            while (rs.next()) {

                Empresa empresa = new Empresa();

                empresa.setId(rs.getLong("id"));
                empresa.setNome(rs.getString("nome"));
                empresa.setCNPJ(rs.getString("uf"));
                empresa.setCNPJ(rs.getString("cnpj"));
                empresa.setCelular(rs.getString("celular"));

                empresas.add(empresa);
            }

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }

        return empresas;
    }

}
