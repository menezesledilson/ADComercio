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

public class CaixaDao {

    public void entrada(Caixa fluxoCaixa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("INSERT INTO caixa(descricao,entrada) values (?,?);");
            pstm.setString(1, fluxoCaixa.getDescricao());
            pstm.setDouble(2, fluxoCaixa.getEntrada());
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
            pstm = con.prepareStatement("INSERT INTO caixa(descricao,saida) values (?,?);");
            pstm.setString(1, fluxoCaixa.getDescricao());
            pstm.setDouble(2, fluxoCaixa.getSaida());
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
            pstm = con.prepareStatement("UPDATE caixa set  descricao = ?, entrada = ?, saida = ? where id = ?;");

            pstm.setString(1, fluxoCaixa.getDescricao());
            pstm.setDouble(2, fluxoCaixa.getEntrada());
            pstm.setDouble(3, fluxoCaixa.getSaida());
            pstm.setLong(4, fluxoCaixa.getId());

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
            pstm = con.prepareStatement("SELECT id, datahora, descricao, entrada, saida FROM caixa order by id DESC ");//order by id DESC

            rs = pstm.executeQuery();
            while (rs.next()) {

                Caixa fluxoCaixa = new Caixa();
                fluxoCaixa.setId(rs.getLong("id"));
                fluxoCaixa.setDataHora(rs.getTimestamp("dataHora"));
                fluxoCaixa.setDescricao(rs.getString("descricao"));
                fluxoCaixa.setEntrada(rs.getDouble("entrada"));
                fluxoCaixa.setSaida(rs.getDouble("Saida"));

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
