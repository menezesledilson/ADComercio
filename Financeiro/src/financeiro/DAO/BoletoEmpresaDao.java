/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.DAO;

import financeiro.conexao.Conexao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import financeiro.model.BoletoEmpresa;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ledilson
 */
public class BoletoEmpresaDao {

    public void adicionar(BoletoEmpresa boletoEmpresa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("insert into boletoEmpresa(nomeBoletoReceber,dataBoletoReceber,valorBoletoReceber,nomeBoletoApagar,dataBoletoApagar,valorBoletoApagar) values (?,?,?,?,?,?);");

            pstm.setString(1, boletoEmpresa.getBoletoClienteReceber());
            pstm.setDate(2, boletoEmpresa.getDataClienteReceber());
            pstm.setDouble(3, boletoEmpresa.getReceberClienteValor());

            pstm.setString(4, boletoEmpresa.getBoletoEmpresaPagar());
            pstm.setDate(5, boletoEmpresa.getDataEmpresaPagar());
            pstm.setDouble(6, boletoEmpresa.getPagarEmpresaValor());

            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void alterar(BoletoEmpresa boletoEmpresa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("update boletoEmpresa set nomeBoletoReceber = ?, dataBoletoReceber = ?, valorBoletoReceber = ?, nomeBoletoApagar = ?, dataBoletoApagar = ?, valorBoletoApagar = ? where id = ?;");

            pstm.setString(1, boletoEmpresa.getBoletoClienteReceber());
            pstm.setDate(2, boletoEmpresa.getDataClienteReceber());
            pstm.setDouble(3, boletoEmpresa.getReceberClienteValor());

            pstm.setString(4, boletoEmpresa.getBoletoEmpresaPagar());
            pstm.setDate(5, boletoEmpresa.getDataEmpresaPagar());
            pstm.setDouble(6, boletoEmpresa.getPagarEmpresaValor());

            pstm.setLong(7, boletoEmpresa.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void remover(BoletoEmpresa boletoEmpresa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareCall("delete from boletoEmpresa where id = ?;");

            pstm.setLong(1, boletoEmpresa.getId());

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {

            Conexao.closeConnection(con, pstm);
        }
    }

    public List<BoletoEmpresa> listarBoletoEmpresa() {
        
        List<BoletoEmpresa> boletoEmpresas = new ArrayList<>();

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT * FROM boletoEmpresa ORDER BY nomeBoletoReceber ASC;");
            rs = pstm.executeQuery();

            while (rs.next()) {

                BoletoEmpresa boletoEmpresa = new BoletoEmpresa();

                boletoEmpresa.setId(rs.getLong("id"));

                boletoEmpresa.setBoletoClienteReceber(rs.getString("nomeBoletoReceber"));
                boletoEmpresa.setBoletoEmpresaPagar(rs.getString("nomeBoletoApagar"));

                boletoEmpresa.setReceberClienteValor(rs.getDouble("valorBoletoReceber"));
                boletoEmpresa.setPagarEmpresaValor(rs.getDouble("valorBoletoApagar"));

                boletoEmpresa.setDataClienteReceber(rs.getDate("dataBoletoReceber"));
                boletoEmpresa.setDataEmpresaPagar(rs.getDate("dataBoletoApagar"));
                
                boletoEmpresas.add(boletoEmpresa);
            }
        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }

        return boletoEmpresas;

    }
}
