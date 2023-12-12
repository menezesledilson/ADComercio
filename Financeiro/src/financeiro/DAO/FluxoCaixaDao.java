/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.FluxoCaixa;
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
public class FluxoCaixaDao {

    public void adicionar(FluxoCaixa fluxoCaixa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("INSERT INTO fluxocaixa(dataHoraCadastro,descricao,valorEntrada,valorSaida) values (?,?,?,?);");

            pstm.setTimestamp(1, fluxoCaixa.getDataHora());
            pstm.setString(2, fluxoCaixa.getDescricaoFluxo());

            pstm.setDouble(3, fluxoCaixa.getValorEntrada());
            pstm.setDouble(4, fluxoCaixa.getValorSaida());

            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void alterar(FluxoCaixa fluxoCaixa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("UPDATE fluxocaixa set dataHoraCadastro = ?, descricao = ?, valorEntrada = ?,valorSaida = ? where id = ?;");

            pstm.setTimestamp(1, fluxoCaixa.getDataHora());
            pstm.setString(2, fluxoCaixa.getDescricaoFluxo());

            pstm.setDouble(3, fluxoCaixa.getValorEntrada());
            pstm.setDouble(4, fluxoCaixa.getValorSaida());
            pstm.setLong(5, fluxoCaixa.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void remover(FluxoCaixa fluxoCaixa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareCall("DELETE FROM fluxocaixa where id = ?;");

            pstm.setLong(1, fluxoCaixa.getId());

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {

            Conexao.closeConnection(con, pstm);
        }
    }

    public List<FluxoCaixa> listarFluxoCaixa() {

        List<FluxoCaixa> fluxoCaixas = new ArrayList<>();

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT * FROM fluxocaixa ORDER BY descricao ASC;");
            rs = pstm.executeQuery();

            while (rs.next()) {

                FluxoCaixa fluxoCaixa = new FluxoCaixa();
 
                fluxoCaixa.setDataHora(rs.getTimestamp("dataHoraCadastro"));
                fluxoCaixa.setDescricaoFluxo(rs.getString("descricao"));

                fluxoCaixa.setValorEntrada(rs.getDouble("valorEntrada"));
                fluxoCaixa.setValorSaida(rs.getDouble("valorSaida"));

                fluxoCaixas.add(fluxoCaixa);
            }
        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }

        return fluxoCaixas;

    }
}
