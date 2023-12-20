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

    public void adicionar(NotaServico notaServico) {

        //Criar a conexao com banco
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            //  pstm = con.prepareStatement("INSERT into emissornotadervico (dataNotaServico, clienteEmpresa, clienteFornecedor, nomeProduto, quantProduto, valorUnitario, valorPeso, cargaInicial, frete, totalFreteCarga, imposto, totalImpostoCarga, totalComissao, comissao, totalFinalCarga )values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            pstm = con.prepareStatement("INSERT into emissornotaservico ( clienteempresa, nomeproduto, quantproduto, valorunitario, valorpeso, cargainicial) VALUES(?,?,?,?,?,?);");

            pstm.setString(1, notaServico.getClienteEmpresa());
            //pstm.setString(2, notaServico.getClienteFornecedor());

            pstm.setString(2, notaServico.getNomeProduto());
            pstm.setInt(3, notaServico.getQuantProduto());

            pstm.setDouble(4, notaServico.getValorUnitario());
            pstm.setDouble(5, notaServico.getPesoUnitario());

            pstm.setDouble(6, notaServico.getCargaInicial());

            /*pstm.setDouble(9, notaServico.getFrete());
             pstm.setDouble(10, notaServico.getTotalFrete());

             pstm.setDouble(11, notaServico.getImposto());
             pstm.setDouble(12, notaServico.getTotalImposto());

             pstm.setDouble(13, notaServico.getComissao());
             pstm.setDouble(14, notaServico.getTotalComissao());

             pstm.setDouble(15, notaServico.getTotalCargaFinal());*/
            pstm.execute();

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);

        }
    }

    public void adicionarnf(NotaServico notaServico) {
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
            pstm = con.prepareStatement("SELECT * FROM emissornotaservico ORDER BY datanotaservico ASC;");
            rs = pstm.executeQuery();

            while (rs.next()) {

                NotaServico notaServico = new NotaServico();

                notaServico.setId(rs.getLong("id"));

                notaServico.setDataEmissaoNota(rs.getTimestamp("datanotaservico"));
                notaServico.setClienteEmpresa(rs.getString("clienteempresa"));
                notaServico.setQuantProduto(rs.getInt("quantproduto"));
                notaServico.setNomeProduto(rs.getString("nomeproduto"));

                notaServico.setValorUnitario(rs.getDouble("valorunitario"));
                notaServico.setPesoUnitario(rs.getDouble("valorpeso"));

                notaServicos.add(notaServico);
            }
        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return notaServicos;
    }
}
