/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.BobinaC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ledilson
 */
public class BobinaDao {

    public void adicionar(BobinaC bobinaC) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("insert into bobina(nomeBobina,valorBobina) values (?, ?);");

            pstm.setString(1, bobinaC.getNomeBobina());
            pstm.setDouble(2, bobinaC.getValorBobina());

            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void alterar(BobinaC bobinaC) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("update bobina set nomeBobina = ?, valorBobina=? where id =?;");

            pstm.setString(1, bobinaC.getNomeBobina());
            pstm.setDouble(2, bobinaC.getValorBobina());
            pstm.setLong(3, bobinaC.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void remover(BobinaC bobinaC) {

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareCall("delete from bobina where id =? ; ");

            pstm.setLong(1, bobinaC.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public List<BobinaC> listar() {
        return listar(null); // Chama o método com termoBusca nulo para listar todas as bobinas
    }
    

    public List<BobinaC> listar(String termoBusca) {

        List<BobinaC> bobinaCs = new ArrayList<>();

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM bobina WHERE nomeBobina LIKE ? OR valorBobina LIKE ? ORDER BY nomeBobina ASC;";
            pstm = con.prepareStatement(sql);

            // Adicione o caractere '%' antes e depois do termo de busca para correspondência parcial
            termoBusca = "%" + termoBusca + "%";

            pstm.setString(1, termoBusca);
            pstm.setString(2, termoBusca);

            rs = pstm.executeQuery();

            while (rs.next()) {
                BobinaC bobinaC = new BobinaC();

                bobinaC.setId(rs.getLong("id"));
                bobinaC.setNomeBobina(rs.getString("nomeBobina"));
                bobinaC.setValorBobina(rs.getDouble("valorBobina"));

                bobinaCs.add(bobinaC);
            }

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }

        return bobinaCs;
    }

}
