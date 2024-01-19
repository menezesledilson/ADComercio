package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.NotaServicoFinal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class NotaServicoDao {
    public void adicionar(NotaServicoFinal notaServicoFinal) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("INSERT  INTO notaservico (prestador,tomador,descricao,quantidade,precoproduto,pesoproduto,totalproduto,freteproduto,impostoproduto,comissaoproduto,apagarproduto) VALUES (?,?,?,?,?,?,?,?,?,?,?);");
            pstm.setString(1, notaServicoFinal.getPrestador());
            pstm.setString(2, notaServicoFinal.getTomador());
            pstm.setString(3, notaServicoFinal.getDescricao());
            pstm.setInt(4, notaServicoFinal.getQuantidade());
            pstm.setDouble(5, notaServicoFinal.getPrecoProduto());
            pstm.setDouble(6, notaServicoFinal.getPesoproduto());
            pstm.setDouble(7, notaServicoFinal.getTotalProduto());
            pstm.setDouble(8, notaServicoFinal.getFreteProduto());
            pstm.setDouble(9, notaServicoFinal.getImpostoProduto());
            pstm.setDouble(10, notaServicoFinal.getComissaoProduto());
            pstm.setDouble(11, notaServicoFinal.getApagarProduto());
            pstm.execute();
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }
        public List<NotaServicoFinal> listarnotaServicoFinal() {
        List<NotaServicoFinal> notaSfinals = new ArrayList<>();
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement("SELECT * FROM notaservico ORDER BY datahora ASC;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                NotaServicoFinal notaFinal = new NotaServicoFinal();
                notaFinal.setId(rs.getLong("id"));
                notaFinal.setDatahora(rs.getTimestamp("datahora"));
                notaFinal.setPrestador(rs.getString("prestador"));
                notaFinal.setTomador(rs.getString("tomador"));
                notaFinal.setDescricao(rs.getString("descricao"));
                notaFinal.setQuantidade(rs.getInt("quantidade"));
                notaFinal.setPrecoProduto(rs.getDouble("precoproduto"));
                notaFinal.setPesoproduto(rs.getDouble("pesoproduto"));
                notaFinal.setTotalProduto(rs.getDouble("totalproduto"));
                notaFinal.setFreteProduto(rs.getDouble("freteproduto"));
                notaFinal.setImpostoProduto(rs.getDouble("impotoproduto"));
                notaFinal.setComissaoProduto(rs.getDouble("comissaoproduto"));
                notaFinal.setApagarProduto(rs.getDouble("apagarproduto"));
                notaSfinals.add(notaFinal);
            }
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return notaSfinals;
    }
}
