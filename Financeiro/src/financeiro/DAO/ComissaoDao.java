package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.ComissaoPagamento;
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
public class ComissaoDao {

    public void adicionar(ComissaoPagamento comissaoPagamento) {

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("INSERT INTO comissao(nome,empresa,datapedido,dataentrega,precocheia,precofabrica,valorcomissao) values (?,?,?,?,?,?,?);");

            pstm.setString(1, comissaoPagamento.getNome());
            pstm.setString(2, comissaoPagamento.getEmpresa());

            pstm.setDate(3, comissaoPagamento.getDataPedido());
            pstm.setDate(4, comissaoPagamento.getDataEntrega());

            pstm.setDouble(5, comissaoPagamento.getPrecoCheia());
            pstm.setDouble(6, comissaoPagamento.getPrecoFabrica());

            pstm.setDouble(7, comissaoPagamento.getValorComissao());

            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void alterar(ComissaoPagamento comissaoPagamento) {
        /*  Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("update comissao set nome = ?, empresa = ?, datapedido = ?, dataentrega = ?, precocheia = ?, precofabrica = ?, valorcomissao = ?  WHERE id = ?");

            pstm.setString(1, comissao.getNome());
            pstm.setString(2, comissao.getEmpresa());

            pstm.setDate(3, comissao.getDataPedido());
            pstm.setDate(4, comissao.getDataEntrega());

            pstm.setDouble(5, comissao.getPrecoCheia());
            pstm.setDouble(6, comissao.getPrecoFabrica());

            pstm.setDouble(7, comissao.getValorComissao());

            pstm.setLong(8, comissao.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }*/
    }

    public void remover(ComissaoPagamento comissaoPagamento) {
        if (comissaoPagamento == null) {
            JOptionPane.showMessageDialog(null, "Objeto ComissaoPagamento é nulo.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareCall("delete from comissao where id = ? ; ");

           pstm.setLong(1, comissaoPagamento.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public List<ComissaoPagamento> listaComissao() {

        List<ComissaoPagamento> comissaos = new ArrayList<>();

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT id,nome, empresa, datapedido, dataentrega, precocheia,precofabrica,valorcomissao FROM comissao;");
            rs = pstm.executeQuery();

            while (rs.next()) {

                ComissaoPagamento comissaoPagamento = new ComissaoPagamento();

                comissaoPagamento.setId(rs.getLong("id"));
                comissaoPagamento.setNome(rs.getString("nome"));
                comissaoPagamento.setEmpresa(rs.getString("empresa"));

                comissaoPagamento.setDataPedido(rs.getDate("datapedido"));
                comissaoPagamento.setDataEntrega(rs.getDate("dataentrega"));
                comissaoPagamento.setPrecoCheia(rs.getDouble("precocheia"));
                comissaoPagamento.setPrecoFabrica(rs.getDouble("precofabrica"));
                comissaoPagamento.setValorComissao(rs.getDouble("valorcomissao"));

                comissaos.add(comissaoPagamento);
            }

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return comissaos;
    }

}
