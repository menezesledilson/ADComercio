/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.CompraBobina;
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
public class CompraBDao {

    public void adcionar(CompraBobina compraBobina) {
        //Criar a conexao com banco
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("INSERT INTO pedidocomprabobina (quantidade,descricao,valorunitario,pesopapel,totalpedido) VALUES (?,?,?,?,?);");
            pstm.setInt(1, compraBobina.getQuantPedido()); // Substitua 'getQuantidade()' pelo método correto que retorna a quantidade desejada.
            pstm.setString(2, compraBobina.getDescricaoPedido());
            pstm.setDouble(3, compraBobina.getValorUnitarioPedido());
            pstm.setDouble(4, compraBobina.getPesoPapelPedido());
              pstm.setDouble(5, compraBobina.getTotalGeralPedido());
            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }

    }

    public void alterar(CompraBobina compraBobina) {
        //Criar a conexao com banco
       /* Connection con = Conexao.getConnection();
         PreparedStatement pstm = null;
         try {

         pstm = con.prepareStatement("UPDATE pedidocomprabobina SET datapedido = ?, quantidade = ?, descricao = ?, nomeempresa = ?, pesopapel = ?, valorunitario = ?, totalpedido = ? WHERE id = ?;");

         pstm.setDate(1, pedidoCompraBobina.getDataPedido());
         pstm.setString(2, pedidoCompraBobina.getDescricaoPedido());
         pstm.setString(3, pedidoCompraBobina.getNomeEmpresa());
         pstm.setInt(4, pedidoCompraBobina.getQuantidadePedido());
         pstm.setDouble(5, pedidoCompraBobina.getPesoPapelPedido());
         pstm.setDouble(6, pedidoCompraBobina.getValorUnitarioPedido());
         pstm.setDouble(7, pedidoCompraBobina.getTotalGeralPedido());

         pstm.setLong(8, pedidoCompraBobina.getId());

         pstm.executeUpdate();

         JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
         } catch (SQLException ErroSql) {

         JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);

         } finally {
         Conexao.closeConnection(con, pstm);
         }*/
    }

    public void remover(CompraBobina compraBobina) {
        //Criar a conexao com banco
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        /*   try {
         pstm = con.prepareStatement("DELETE FROM pedidocomprabobina WHERE id = ?;");


         pstm.setLong(1, pedidoCompraBobina.getId());

         pstm.executeUpdate();

         JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

         } catch (SQLException ErroSql) {

         JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
         } finally {

         Conexao.closeConnection(con, pstm);
         }*/
    }

    public List<CompraBobina> listarcompraBobina() {

        List<CompraBobina> compraBobinas = new ArrayList<>();

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT * FROM pedidocomprabobina;");
            rs = pstm.executeQuery();

            while (rs.next()) {
                CompraBobina compraBobina = new CompraBobina();

                compraBobina.setId(rs.getLong("id"));
                compraBobina.setDataPedido(rs.getDate("datapedido"));
                compraBobina.setDescricaoPedido(rs.getString("descricao"));
                compraBobina.setQuantPedido(rs.getInt("quantidade"));
                compraBobina.setPesoPapelPedido(rs.getDouble("pesopapel"));
                compraBobina.setValorUnitarioPedido(rs.getDouble("valorunitario"));
                compraBobina.setNomeEmpresa(rs.getString("nomeempresa"));

                compraBobinas.add(compraBobina);
            }
        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }

        return compraBobinas;
    }
}
