/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.NotaCheia;
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
public class NotaCheiaDao {

    public void adicionar(NotaCheia notaCheia) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("insert into notacheia(nomeempresa,nomeproduto,quantidade,valorunitario,pesopapel,ipi,totalsipi,valoripi,totalcipi,diferencial,datapedido,dataentrega) values (?,?,?,?,?,?,?,?,?,?,?,?);");

            pstm.setString(1, notaCheia.getNomeEmpresa());
            pstm.setString(2, notaCheia.getNomeProduto());
            pstm.setInt(3, notaCheia.getQuantidade());
            pstm.setDouble(4, notaCheia.getValorUnitario());
            pstm.setDouble(5, notaCheia.getPesoPapel());
            pstm.setDouble(6, notaCheia.getIpi());
            pstm.setDouble(7, notaCheia.getTotalSipi());
            pstm.setDouble(8, notaCheia.getValorIpi());
            pstm.setDouble(9, notaCheia.getTotalCipi());
            pstm.setDouble(10, notaCheia.getDiferencialIpi());
            pstm.setDate(11, notaCheia.getDataPedido());
            pstm.setDate(12, notaCheia.getDataEntrega());

            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            ErroSql.printStackTrace(); // Isso imprimirá a stack trace no console
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco: " + ErroSql.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void alterar(NotaCheia notaCheia) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("update notacheia set  nomeempresa = ?,nomeproduto = ?,quantidade = ?,valorunitario = ?,pesopapel = ?,ipi = ?,totalsipi = ?,valoripi = ?,totalcipi = ?,diferencial = ?, datapedido = ?, dataentrega = ? where id =?;");

            pstm.setString(1, notaCheia.getNomeEmpresa());
            pstm.setString(2, notaCheia.getNomeProduto());
            pstm.setInt(3, notaCheia.getQuantidade());
            pstm.setDouble(4, notaCheia.getValorUnitario());
            pstm.setDouble(5, notaCheia.getPesoPapel());
            pstm.setDouble(6, notaCheia.getIpi());
            pstm.setDouble(7, notaCheia.getTotalSipi());
            pstm.setDouble(8, notaCheia.getValorIpi());
            pstm.setDouble(9, notaCheia.getTotalCipi());
            pstm.setDouble(10, notaCheia.getDiferencialIpi());
            pstm.setDate(11, notaCheia.getDataPedido());
            pstm.setDate(12, notaCheia.getDataEntrega());

            pstm.setLong(13, notaCheia.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void remover(NotaCheia notaCheia) {

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareCall("delete from notacheia where id = ? ; ");

            pstm.setLong(1, notaCheia.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public List<NotaCheia> listarNotaCheia() {

        List<NotaCheia> notaCheias = new ArrayList<>();

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT * FROM notacheia ORDER BY nomeempresa ASC;");
            rs = pstm.executeQuery();

            while (rs.next()) {

                NotaCheia notaCheia = new NotaCheia();

                notaCheia.setId(rs.getLong("id"));

                notaCheia.setNomeEmpresa(rs.getString("nomeempresa"));
                notaCheia.setNomeProduto(rs.getString("nomeproduto"));
                notaCheia.setQuantidade(rs.getInt("quantidade"));

                notaCheia.setIpi(rs.getDouble("ipi"));
                notaCheia.setValorIpi(rs.getDouble("valoripi"));

                notaCheia.setTotalCipi(rs.getDouble("totalcipi"));
                notaCheia.setTotalSipi(rs.getDouble("totalsipi"));

                notaCheia.setPesoPapel(rs.getDouble("pesopapel"));
                notaCheia.setValorUnitario(rs.getDouble("valorunitario"));

                notaCheia.setDiferencialIpi(rs.getDouble("diferencial"));

                notaCheia.setDataPedido(rs.getDate("datapedido"));
                notaCheia.setDataEntrega(rs.getDate("dataentrega"));

                notaCheias.add(notaCheia);
            }

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }

        return notaCheias;

    }

}
