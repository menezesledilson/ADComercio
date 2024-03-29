
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

public class BobinaDao {
    public void adicionar(BobinaC bobinaC) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("insert into bobina(nomebobina,valorbobina) values (?, ?);");
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
            pstm = con.prepareStatement("update bobina set nomebobina = ?, valorbobina=? where id =?;");
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
            pstm = con.prepareCall("delete from bobina where id = ? ; ");
            pstm.setLong(1, bobinaC.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }
    public List<BobinaC> listarBobinaC() {
        List<BobinaC> bobinaCs = new ArrayList<>();
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement("SELECT * FROM bobina ORDER BY nomebobina ASC;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                BobinaC bobinaC = new BobinaC();
                bobinaC.setId(rs.getLong("id"));
                bobinaC.setNomeBobina(rs.getString("nomebobina"));
                bobinaC.setValorBobina(rs.getDouble("valorbobina"));
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
