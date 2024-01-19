 
package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.NotaServico;
import financeiro.model.NotaServicoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
 
public class EmissorNotaServicoClienteDao {
    public void adicionar(NotaServicoCliente notaServicoCliente) {
        //Criar a conexao com banco
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
              pstm = con.prepareStatement("INSERT into emissornotacliente ( clienteempresa, nomeproduto, quantproduto, valorunitario, valorpeso, cargainicial) VALUES(?,?,?,?,?,?);");
            pstm.setString(1, notaServicoCliente.getClienteEmpresa());
            pstm.setString(2, notaServicoCliente.getNomeProduto());
            pstm.setInt(3, notaServicoCliente.getQuantProduto());
            pstm.setDouble(4, notaServicoCliente.getValorUnitario());
            pstm.setDouble(5, notaServicoCliente.getPesoUnitario());
            pstm.setDouble(6, notaServicoCliente.getCargaInicial());
            pstm.execute();
        } catch (SQLException ErroSql) {
             JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }
    public void removerCliente(NotaServicoCliente notaServicoCliente) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareCall("delete from emissornotacliente where id = ? ; ");
            pstm.setLong(1, notaServicoCliente.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }
    public List<NotaServicoCliente> listarNotaServicoCliente() {
        List<NotaServicoCliente> notaServicoClientes = new ArrayList<>();
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement("SELECT * FROM emissornotacliente ORDER BY datanotaservico ASC;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                NotaServicoCliente notaServicoCliente = new NotaServicoCliente();
                notaServicoCliente.setId(rs.getLong("id"));
                notaServicoCliente.setDataEmissaoNota(rs.getTimestamp("datanotaservico"));
                notaServicoCliente.setClienteEmpresa(rs.getString("clienteempresa"));
                notaServicoCliente.setQuantProduto(rs.getInt("quantproduto"));
                notaServicoCliente.setNomeProduto(rs.getString("nomeproduto"));
                notaServicoCliente.setValorUnitario(rs.getDouble("valorunitario"));
                notaServicoCliente.setPesoUnitario(rs.getDouble("valorpeso"));
                notaServicoCliente.setCargaInicial(rs.getDouble("cargainicial"));
                notaServicoClientes.add(notaServicoCliente);
            }
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return notaServicoClientes;
    }
}
