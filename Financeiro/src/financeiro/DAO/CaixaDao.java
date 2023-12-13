/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.Caixa;
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
public class CaixaDao {

    public void adicionar(Caixa fluxoCaixa) {
        /*  Connection con = Conexao.getConnection();
         PreparedStatement pstm = null;

         try {
         pstm = con.prepareStatement("INSERT INTO caixa(datahora,descricao,entrada,saida,saldoAnterior,saldoAtual) values (?,?,?,?,?,?);");

         pstm.setTimestamp(1, fluxoCaixa.getDataHora());

         pstm.setString(2, fluxoCaixa.getDescricao());

         pstm.setDouble(3, fluxoCaixa.getEntrada());
         pstm.setDouble(4, fluxoCaixa.getSaida());
         pstm.setDouble(5, fluxoCaixa.getSaldoAnterior());
         pstm.setDouble(6, fluxoCaixa.getSaldoAtual());

         pstm.execute();

         JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

         } catch (SQLException ErroSql) {
         JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
         } finally {
         Conexao.closeConnection(con, pstm);
         }*/
    }

    public void entrada(Caixa fluxoCaixa) {

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {

            pstm = con.prepareStatement("INSERT INTO caixa(descricao,entrada,saida) values (?,?,?);");

            pstm.setString(1, fluxoCaixa.getDescricao());
            pstm.setDouble(2, fluxoCaixa.getEntrada());
            pstm.setDouble(3, fluxoCaixa.getSaida());

            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);

        }
    }

    public void saida(Caixa fluxoCaixa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("INSERT INTO caixa(descricao,saida,entrada) values (?,?,?);");

            pstm.setString(1, fluxoCaixa.getDescricao());
            pstm.setDouble(2, fluxoCaixa.getSaida());
            pstm.setDouble(3, fluxoCaixa.getEntrada());
            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void alterar(Caixa fluxoCaixa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("UPDATE caixa set datahora = ? , descricao = ?, entrada = ?, saida = ?, saldoAnterior = ?, saldoAtual = ? where id = ?;");

            pstm.setTimestamp(1, fluxoCaixa.getDataHora());
            pstm.setString(2, fluxoCaixa.getDescricao());
            pstm.setDouble(3, fluxoCaixa.getEntrada());
            pstm.setDouble(4, fluxoCaixa.getSaida());
            pstm.setDouble(5, fluxoCaixa.getSaldoAnterior());
            pstm.setDouble(6, fluxoCaixa.getSaldoAtual());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void remover(Caixa fluxoCaixa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareCall("DELETE FROM caixa where id = ?;");

            pstm.setLong(1, fluxoCaixa.getId());

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {

            Conexao.closeConnection(con, pstm);
        }
    }

    public List<Caixa> listarFluxoCaixa() {
        List<Caixa> fluxoCaixas = new ArrayList<>();

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT * FROM caixa ORDER BY dataHora ASC;");
            rs = pstm.executeQuery();

            while (rs.next()) {
                Caixa fluxoCaixa = new Caixa();

                fluxoCaixa.setId(rs.getLong("id"));

                fluxoCaixa.setDataHora(rs.getTimestamp("dataHora"));
                fluxoCaixa.setDescricao(rs.getString("descricao"));

                fluxoCaixa.setEntrada(rs.getDouble("entrada"));
                fluxoCaixa.setSaida(rs.getDouble("Saida"));

                fluxoCaixa.setSaldoAtual(rs.getDouble("saldoAtual"));
                fluxoCaixa.setSaldoAnterior(rs.getDouble("saldoAnterior"));

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
