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
            pstm = con.prepareStatement("INSERT into emissornotaservico ( clienteempresa, nomeproduto, quantproduto, valorunitario, valorpeso) VALUES(?,?,?,?,?);");

            pstm.setString(1, notaServico.getClienteEmpresa());
            //pstm.setString(2, notaServico.getClienteFornecedor());

            pstm.setString(2, notaServico.getNomeProduto());
            pstm.setInt(3, notaServico.getQuantProduto());

            pstm.setDouble(4, notaServico.getValorUnitario());
            pstm.setDouble(5, notaServico.getPesoUnitario());

            /* pstm.setDouble(8, notaServico.getCargaInicial());

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

    public void alterar(NotaServico notaServico) {
    }

    public void remover(NotaServico notaServico) {
    }

    public List<NotaServico> listarNotaServic() {
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
//  fluxoCaixa.setDataHora(rs.getTimestamp("dataHora"));
                notaServico.setClienteEmpresa(rs.getString("clienteempresa"));
                notaServico.setClienteFornecedor(rs.getString("clientefornecedor"));

                notaServico.setNomeProduto(rs.getString("nomeproduto"));
                notaServico.setQuantProduto(rs.getInt("quantproduto"));

                notaServico.setValorUnitario(rs.getDouble("valorunitario"));
                notaServico.setPesoUnitario(rs.getDouble("pesounitario"));

                notaServico.setCargaInicial(rs.getDouble("cargainicial"));

                notaServico.setFrete(rs.getDouble("frete"));
                notaServico.setTotalFrete(rs.getDouble("totalfrete"));

                notaServico.setImposto(rs.getDouble("imposto"));
                notaServico.setTotalImposto(rs.getDouble("totalimposto"));

                notaServico.setComissao(rs.getDouble("comissao"));
                notaServico.setTotalComissao(rs.getDouble("totalcomissao"));

                notaServico.setTotalCargaFinal(rs.getDouble("totalcargafinal"));

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
