package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.DetalhesVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalhesVendaDao {

    public void adicionar(DetalhesVenda detalhesVenda) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("insert into detalhesvenda(idevenda,quantidade,id_produto) values (?,?,?);");
            pstm.setInt(1, detalhesVenda.getQuantVenda());
            pstm.setDouble(2, detalhesVenda.getIdBobina());
            pstm.setDouble(3, detalhesVenda.getIdCompra());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void alterar(DetalhesVenda detalhesVenda) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("update detalhesvenda set quantidade = ?, idevenda=?, id_produto = ? where id =?;");
            pstm.setLong(1, detalhesVenda.getIdBobina());
            pstm.setInt(2, detalhesVenda.getQuantVenda());
            pstm.setLong(3, detalhesVenda.getIdCompra());
            pstm.setLong(4, detalhesVenda.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void remover(DetalhesVenda detalhesVenda) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareCall("delete from detalhesvenda where id =? ; ");
            pstm.setLong(1, detalhesVenda.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public List<DetalhesVenda> listarDetalhes() {
        return listarDetalhes(null); // Chama o método com termoBusca nulo para listar todas as bobinas
    }

    public List<DetalhesVenda> listarDetalhes(String termoBusca) {
        List<DetalhesVenda> DetalhesVendass = new ArrayList<>();
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM detalhesvenda ;";
            pstm = con.prepareStatement(sql);
            // Adicione o caractere '%' antes e depois do termo de busca para correspondência parcial
            termoBusca = "%" + termoBusca + "%";
            pstm.setString(1, termoBusca);
            pstm.setString(2, termoBusca);
            rs = pstm.executeQuery();
            while (rs.next()) {
                DetalhesVenda DetalhesVenda = new DetalhesVenda();
                DetalhesVenda.setId(rs.getLong("id"));
                DetalhesVenda.setIdBobina(rs.getLong("idBobina"));
                DetalhesVenda.setQuantVenda((int) rs.getLong("quantidade"));
                DetalhesVendass.add(DetalhesVenda);
            }
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return DetalhesVendass;
    }
}
