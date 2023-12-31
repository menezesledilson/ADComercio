/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.NotaServico;
import financeiro.model.PedidoBobina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ledilson
 */
public class EmissorNotaServicoDao {

    public void adicionarnf(NotaServico notaServico) {

        //Criar a conexao com banco
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {

            pstm = con.prepareStatement("INSERT into emissornotaservico (clientefornecedor, totalfinalcarga, frete, imposto, comissao, totalfretecarga, totalimpostocarga, totalcomissao)values (?,?,?,?,?,?,?,?);");

            pstm.setString(1, notaServico.getClienteFornecedor());

            pstm.setDouble(2, notaServico.getTotalCargaFinal());

            pstm.setDouble(3, notaServico.getFrete());
            pstm.setDouble(4, notaServico.getImposto());
            pstm.setDouble(5, notaServico.getComissao());
            pstm.setDouble(6, notaServico.getTotalFrete());
            pstm.setDouble(7, notaServico.getTotalImposto());
            pstm.setDouble(8, notaServico.getTotalComissao());
            //  pstm.setDouble(8, notaServico.getTotalCargaFinal());
//           pstm.setDouble(9, notaServico.getCargaGeralNs());
            pstm.execute();

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);

        }

    }

    public void remover(NotaServico notaServico) {

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareCall("delete from emissornotaservico where id = ? ; ");

            pstm.setLong(1, notaServico.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }

    }

    public List<NotaServico> listarNotaServico() {
        List<NotaServico> notaServicos = new ArrayList<>();

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT * FROM emissornotaservico ORDER BY clientefornecedor ASC;");
            rs = pstm.executeQuery();

            while (rs.next()) {

                NotaServico notaServico = new NotaServico();

                notaServico.setId(rs.getLong("id"));

                notaServico.setDataEmissaoNota(rs.getTimestamp("datanotaservico"));

                //    notaServico.setClienteEmpresa(rs.getString("clienteempresa"));
                notaServico.setClienteFornecedor(rs.getString("clientefornecedor"));

             //   notaServico.setQuantProduto(rs.getInt("quantproduto"));
                //   notaServico.setNomeProduto(rs.getString("nomeproduto"));
                //notaServico.setValorUnitario(rs.getDouble("valorunitario"));
                // notaServico.setPesoUnitario(rs.getDouble("valorpeso"));
                notaServico.setFrete(rs.getDouble("frete"));
                notaServico.setImposto(rs.getDouble("imposto"));
                notaServico.setComissao(rs.getDouble("comissao"));

                notaServico.setTotalCargaFinal(rs.getDouble("totalfinalcarga"));

              //  notaServico.setCargaGeralNs(rs.getDouble("cargageral"));
                notaServico.setTotalComissao(rs.getDouble("totalcomissao"));
                notaServico.setTotalImposto(rs.getDouble("totalimpostocarga"));
                notaServico.setTotalFrete(rs.getDouble("totalfretecarga"));

                notaServicos.add(notaServico);
            }
        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return notaServicos;
    }

    public void alterar(NotaServico notaServico) {
        /*
         Connection con = Conexao.getConnection();
         PreparedStatement pstm = null;

         try {
         pstm = con.prepareStatement("update emissornotaservico set clienteempresa = ?, quantproduto=?, nomeproduto=?, valorunitario = ?,valorpeso=? where id =?;");

         pstm.setString(1, notaServico.getClienteEmpresa());
         pstm.setDouble(2, notaServico.getQuantProduto());
         pstm.setString(3, notaServico.getNomeProduto());
         pstm.setDouble(4, notaServico.getValorUnitario());
         pstm.setDouble(5, notaServico.getPesoUnitario());

         pstm.setLong(6, notaServico.getId());

         pstm.executeUpdate();

         JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

         } catch (SQLException ErroSql) {
         JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
         } finally {
         Conexao.closeConnection(con, pstm);
         }
         */
    }
}
