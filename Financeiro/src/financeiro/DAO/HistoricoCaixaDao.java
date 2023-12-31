/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.HistoricoCaixa;
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
public class HistoricoCaixaDao {

    public void adiciona(HistoricoCaixa historicoCaixa) {
        //Criar a conexao com banco
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("INSERT into historicocaixa (descricao,entrada,saida) VALUES (?, ?, ?);");
            // pstm.setTimestamp(1, historicoCaixa.getDatahora());
            pstm.setString(1, historicoCaixa.getDescricao());
            pstm.setDouble(2, historicoCaixa.getEntrada());
            pstm.setDouble(3, historicoCaixa.getSaida());

            pstm.execute();

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public List<HistoricoCaixa> listaHistoricoCaixa() {
        List<HistoricoCaixa> historicoCaixas = new ArrayList<>();

        try (Connection con = Conexao.getConnection();
                PreparedStatement pstm = con.prepareStatement("SELECT * FROM historicocaixa");
                ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                HistoricoCaixa historicoCaixa = new HistoricoCaixa();

                historicoCaixa.setId(rs.getLong("id"));
                historicoCaixa.setDescricao(rs.getString("descricao"));
                historicoCaixa.setEntrada(rs.getDouble("entrada"));
                historicoCaixa.setSaida(rs.getDouble("saida"));

                historicoCaixas.add(historicoCaixa);
            }
        } catch (SQLException ErroSql) {
            ErroSql.printStackTrace(); // Melhor prática para logar o erro
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }

        return historicoCaixas;
    }
}
