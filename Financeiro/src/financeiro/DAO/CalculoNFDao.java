/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.CalculoNF;
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
public class CalculoNFDao {

    public void adicionar(CalculoNF calculoNF) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("insert into calculonf(descricao,dataEmissao,quantidade,pesoPapel,valorUnitario,frete,impostoIpi,comissao,valorApagar,totalCarga,idbobina) values (?,?,?,?,?,?,?,?,?,?,?,);");

            pstm.setString(1, calculoNF.getDescricao());
            pstm.setDate(2, calculoNF.getDataEmissao());
            pstm.setDouble(3, calculoNF.getQuantidade());

            pstm.setDouble(4, calculoNF.getPesoPapel());
            pstm.setDouble(5, calculoNF.getValorUnitario());
            pstm.setDouble(6, calculoNF.getFrete());
            pstm.setDouble(7, calculoNF.getImpostoIpi());
            pstm.setDouble(8, calculoNF.getComissao());
            pstm.setDouble(9, calculoNF.getValorApagar());
            pstm.setDouble(10, calculoNF.getTotalCarga());
             pstm.setDouble(11, calculoNF.getIdbobina());

            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void alterar(CalculoNF calculoNF) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("UPDATE calculonf  set descricao = ?, dataEmissao =?, quantidade = ?, pesoPapel = ?, valorUnitario = ?,frete = ?, impostoIpi = ? ,comissao = ? ,valorApagar = ?,totalCarga = ?, idbobina = ? where id = ?;");

            pstm.setString(1, calculoNF.getDescricao());
            pstm.setDate(2, calculoNF.getDataEmissao());
            pstm.setDouble(3, calculoNF.getQuantidade());

            pstm.setDouble(4, calculoNF.getPesoPapel());
            pstm.setDouble(5, calculoNF.getValorUnitario());
            pstm.setDouble(6, calculoNF.getFrete());
            pstm.setDouble(7, calculoNF.getImpostoIpi());
            pstm.setDouble(8, calculoNF.getComissao());
            pstm.setDouble(9, calculoNF.getValorApagar());
            pstm.setDouble(10, calculoNF.getTotalCarga());
             pstm.setDouble(11, calculoNF.getIdbobina());

            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void remover(CalculoNF calculoNF) {

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareCall("DELETE from calculonf where id =? ; ");

            pstm.setLong(1, calculoNF.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public List<CalculoNF> listarCalculoNF() {
        List<CalculoNF> calculoNFs = new ArrayList<>();

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT * FROM calculo ORDER BY dataemissao ASC;");
            rs = pstm.executeQuery();

            while (rs.next()) {

                CalculoNF calculoNF = new CalculoNF();

                calculoNF.setId(rs.getLong("id"));
                calculoNF.setDescricao(rs.getString("descricao"));

                calculoNF.setQuantidade(rs.getInt("quantidade"));
                calculoNF.setPesoPapel(rs.getDouble("pesoPapel"));
                
                calculoNF.setValorUnitario(rs.getDouble("valorUnitario"));
                calculoNF.setFrete(rs.getDouble("frete"));

                calculoNF.setImpostoIpi(rs.getDouble("impostoIpi"));
                calculoNF.setComissao(rs.getDouble("comissao"));

                calculoNF.setValorApagar(rs.getDouble("valorApagar"));
                calculoNF.setTotalCarga(rs.getDouble("totalCarga"));
                calculoNF.setIdbobina(rs.getLong("idbobina"));

                calculoNFs.add(calculoNF);
            }

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }

        return calculoNFs;
    }
}
