/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.PagamentoFabrica;
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
public class PagamentoFabricaDao {

    public void adicionar(PagamentoFabrica pagamentoFabrica) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("insert into pagamentofabrica (nomepagamento,valorpagamento, observacao) values (?, ?, ?);");

            pstm.setString(1, pagamentoFabrica.getNomePagamento());
            pstm.setDouble(2, pagamentoFabrica.getValorPagamento());
            pstm.setString(3, pagamentoFabrica.getObservacaoPagamento());

            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);

        }

    }

    public void remover(PagamentoFabrica pagamentoFabrica) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareCall("delete from pagamentofabrica where id = ? ; ");

            pstm.setLong(1, pagamentoFabrica.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public List<PagamentoFabrica> listarPagFabrica() {
        List<PagamentoFabrica> PagamentoFabricas = new ArrayList<>();

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT * FROM  pagamentofabrica ORDER BY datahorapagamento ASC;");
            rs = pstm.executeQuery();

            while (rs.next()) {

                PagamentoFabrica pagamentoFabrica = new PagamentoFabrica();

                pagamentoFabrica.setId(rs.getLong("id"));
                pagamentoFabrica.setDatahora(rs.getTimestamp("datahorapagamento"));
                pagamentoFabrica.setNomePagamento(rs.getString("nomepagamento"));
                pagamentoFabrica.setValorPagamento(rs.getDouble("valorpagamento"));
                pagamentoFabrica.setNomePagamento(rs.getString("observacao"));

                PagamentoFabricas.add(pagamentoFabrica);
            }

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }

        return PagamentoFabricas;
    }
}
