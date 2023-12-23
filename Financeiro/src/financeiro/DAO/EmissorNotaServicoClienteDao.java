/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Ledilson
 */
public class EmissorNotaServicoClienteDao {

    public void adicionar(NotaServicoCliente notaServicoCliente) {

        //Criar a conexao com banco
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            //  pstm = con.prepareStatement("INSERT into emissornotadervico (dataNotaServico, clienteEmpresa, clienteFornecedor, nomeProduto, quantProduto, valorUnitario, valorPeso, cargaInicial, frete, totalFreteCarga, imposto, totalImpostoCarga, totalComissao, comissao, totalFinalCarga )values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            pstm = con.prepareStatement("INSERT into emissornotacliente ( clienteempresa, nomeproduto, quantproduto, valorunitario, valorpeso, cargainicial) VALUES(?,?,?,?,?,?);");

            pstm.setString(1, notaServicoCliente.getClienteEmpresa());

            pstm.setString(2, notaServicoCliente.getNomeProduto());
            pstm.setInt(3, notaServicoCliente.getQuantProduto());

            pstm.setDouble(4, notaServicoCliente.getValorUnitario());
            pstm.setDouble(5, notaServicoCliente.getPesoUnitario());

            pstm.setDouble(6, notaServicoCliente.getCargaInicial());

            /*
             //pstm.setString(2, notaServico.getClienteFornecedor());
             pstm.setDouble(9, notaServico.getFrete());
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

                //notaServico.setClienteFornecedor(rs.getString("clientefornecedor"));
                //  notaServicoCliente.setFrete(rs.getDouble("frete"));
                //notaServico.setImposto(rs.getDouble("imposto"));
                //notaServico.setComissao(rs.getDouble("comissao"));
                //  notaServicoCliente.setTotalCargaFinal(rs.getDouble("totalfinalcarga"));
                // notaServicoCliente.setCargaGeralNs(rs.getDouble("cargageral"));
                //notaServicoCliente.setTotalComissao(rs.getDouble("totalcomissao"));
                //notaServicoCliente.setTotalImposto(rs.getDouble("totalimpostocarga"));
                //notaServicoCliente.setTotalFrete(rs.getDouble("totalfretecarga"));
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
