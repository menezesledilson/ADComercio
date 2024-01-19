
package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.NotaBaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class NotaBaixaDao {
    public void adicionar(NotaBaixa notaBaixa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("insert into notabaixa(nomeempresa,nomeproduto,quantidade,valorunitario,pesopapel,ipi,totalsipi,valoripi,totalcipi,diferencial,datapedido,dataentrega) values (?,?,?,?,?,?,?,?,?,?,?,?);");
            pstm.setString(1, notaBaixa.getNomeEmpresa());
            pstm.setString(2, notaBaixa.getNomeProduto());
            pstm.setInt(3, notaBaixa.getQuantidade());
            pstm.setDouble(4, notaBaixa.getValorUnitario());
            pstm.setDouble(5, notaBaixa.getPesoPapel());
            pstm.setDouble(6, notaBaixa.getIpi());
            pstm.setDouble(7, notaBaixa.getTotalSipi());
            pstm.setDouble(8, notaBaixa.getValorIpi());
            pstm.setDouble(9, notaBaixa.getTotalCipi());
            pstm.setDouble(10, notaBaixa.getDiferencialIpi());
            pstm.setDate(11, notaBaixa.getDataPedido());
            pstm.setDate(12, notaBaixa.getDataEntrega());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }
    public void alterar(NotaBaixa notaBaixa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("update notabaixa set  nomeempresa = ?,nomeproduto = ?,quantidade = ?,valorunitario = ?,pesopapel = ?,ipi = ?,totalsipi = ?,valoripi = ?,totalcipi = ?,diferencial = ?,datapedido = ?, dataentrega = ? where id =?;");
            pstm.setString(1, notaBaixa.getNomeEmpresa());
            pstm.setString(2, notaBaixa.getNomeProduto());
            pstm.setInt(3, notaBaixa.getQuantidade());
            pstm.setDouble(4, notaBaixa.getValorUnitario());
            pstm.setDouble(5, notaBaixa.getPesoPapel());
            pstm.setDouble(6, notaBaixa.getIpi());
            pstm.setDouble(7, notaBaixa.getTotalSipi());
            pstm.setDouble(8, notaBaixa.getValorIpi());
            pstm.setDouble(9, notaBaixa.getTotalCipi());
            pstm.setDouble(10, notaBaixa.getDiferencialIpi());
            pstm.setDate(11, notaBaixa.getDataPedido());
            pstm.setDate(12, notaBaixa.getDataEntrega());
            pstm.setLong(13, notaBaixa.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }
    public void remover(NotaBaixa notaBaixa) {

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareCall("delete from notabaixa where id = ? ; ");
            pstm.setLong(1, notaBaixa.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }
    public List<NotaBaixa> listarBaixa() {
        List<NotaBaixa> notaBaixas = new ArrayList<>();
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement("SELECT * FROM notabaixa ORDER BY nomeempresa ASC;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                NotaBaixa notaBaixa = new NotaBaixa();
                notaBaixa.setId(rs.getLong("id"));
                notaBaixa.setNomeEmpresa(rs.getString("nomeempresa"));
                notaBaixa.setNomeProduto(rs.getString("nomeproduto"));
                notaBaixa.setQuantidade(rs.getInt("quantidade"));
                notaBaixa.setIpi(rs.getDouble("ipi"));
                notaBaixa.setValorIpi(rs.getDouble("valoripi"));
                notaBaixa.setTotalCipi(rs.getDouble("totalcipi"));
                notaBaixa.setTotalSipi(rs.getDouble("totalsipi"));
                notaBaixa.setPesoPapel(rs.getDouble("pesopapel"));
                notaBaixa.setValorUnitario(rs.getDouble("valorunitario"));
                notaBaixa.setDiferencialIpi(rs.getDouble("diferencial"));
                notaBaixa.setDataPedido(rs.getDate("datapedido"));
                notaBaixa.setDataEntrega(rs.getDate("dataentrega"));
                notaBaixas.add(notaBaixa);
            }

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return notaBaixas;
    }
}
