/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.ControleVendedor;
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
public class ControleVendedorDao {

    public void adicionar(ControleVendedor controleVendedor) {
        
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("insert into controlevendedor (nomevenda,valorvenda,observacao) values (?, ?, ?);");

            pstm.setString(1, controleVendedor.getNomeVenda());
            pstm.setDouble(2, controleVendedor.getValorVenda());
            pstm.setString(3, controleVendedor.getObservacaoVenda());

            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void remover(ControleVendedor controleVendedor) {

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareCall("delete from controlevendedor where id = ? ; ");

            pstm.setLong(1, controleVendedor.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public List<ControleVendedor> listarControleVendedor() {
        List<ControleVendedor> listarControleVendedors = new ArrayList<>();

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
          pstm = con.prepareStatement("SELECT id, datahoravenda,nomevenda, valorvenda, observacao FROM controlevendedor ORDER BY id DESC");


            rs = pstm.executeQuery();

            while (rs.next()) {

                ControleVendedor controleVendedor = new ControleVendedor();

                controleVendedor.setId(rs.getLong("id"));
                controleVendedor.setDatahoraVenda(rs.getTimestamp("datahoravenda"));
                controleVendedor.setNomeVenda(rs.getString("nomevenda"));
                controleVendedor.setValorVenda(rs.getDouble("valorvenda"));
                controleVendedor.setObservacaoVenda(rs.getString("observacao"));

                listarControleVendedors.add(controleVendedor);
            }

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }

        return listarControleVendedors;
    }

}
