/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.DAO;

import financeiro.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import financeiro.model.PedidoBobina;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ledilson
 */
public class PedidoBobinaDao {

    public void adicionar(PedidoBobina pedidobobina) {

        //Criar a conexao com banco
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {

           
            pstm = con.prepareStatement("INSERT into pedidobobina (nomecliente,valorpedido,quantidadebobina,datapedido,dataentrega,numerochequea,numerochequeb,numerochequec,pagpedido,observacao)values (?,?,?,?,?,?,?,?,?,? );");
            pstm.setString(1, pedidobobina.getNomeClientePedido());
            pstm.setDouble(2, pedidobobina.getValorPedido());
            pstm.setInt(3, pedidobobina.getQuantidadeBobina());
            pstm.setDate(4, pedidobobina.getDataPedido());
            pstm.setDate(5, pedidobobina.getDataEntrega());
            pstm.setString(6, pedidobobina.getNumeroChequeA());
            pstm.setString(7, pedidobobina.getNumeroChequeB());
            pstm.setString(8, pedidobobina.getNumeroChequeC());

            pstm.setString(9, pedidobobina.getPagPedido());
            pstm.setString(10, pedidobobina.getObservacaoPagamento());;

            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            ErroSql.printStackTrace(); // Isso imprimirá detalhes da exceção no console
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco: " + ErroSql.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void alterar(PedidoBobina pedidobobina) {
        //Criar a conexao com banco
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {

            pstm = con.prepareStatement("UPDATE pedidobobina SET nomecliente = ?, valorpedido = ?, quantidadebobina = ?, datapedido = ?, dataentrega = ?, numerochequea = ?, numerochequeb = ?, numerochequec = ?, pagpedido = ?, observacao = ? WHERE id = ?");

            pstm.setString(1, pedidobobina.getNomeClientePedido());
            pstm.setDouble(2, pedidobobina.getValorPedido());
            pstm.setInt(3, pedidobobina.getQuantidadeBobina());

            pstm.setDate(4, pedidobobina.getDataPedido());
            pstm.setDate(5, pedidobobina.getDataEntrega());

            pstm.setString(6, pedidobobina.getNumeroChequeA());
            pstm.setString(7, pedidobobina.getNumeroChequeB());
            pstm.setString(8, pedidobobina.getNumeroChequeC());

            pstm.setString(9, pedidobobina.getPagPedido());
            pstm.setString(10, pedidobobina.getObservacaoPagamento());

            pstm.setLong(11, pedidobobina.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);

        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void remover(PedidoBobina pedidobobina) {

        //Criar a conexao com banco
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareCall("DELETE FROM pedidobobina where id = ?;");

            pstm.setLong(1, pedidobobina.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {

            Conexao.closeConnection(con, pstm);
        }
    }

    public List<PedidoBobina> listarPedidoBobina() {

        List<PedidoBobina> pedidoBobinas = new ArrayList<>();

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT id,nomecliente,valorpedido,quantidadebobina,datapedido,dataentrega,numerochequea,numerochequeb,numerochequec,pagpedido,observacao FROM pedidobobina ORDER BY  id DESC;");

            rs = pstm.executeQuery();

            while (rs.next()) {

                PedidoBobina pedidoBobina = new PedidoBobina();

                pedidoBobina.setId(rs.getLong("id"));

                pedidoBobina.setNomeClientePedido(rs.getString("nomecliente"));
                pedidoBobina.setValorPedido(rs.getDouble("valorpedido"));

                pedidoBobina.setQuantidadeBobina(rs.getInt("quantidadebobina"));
                pedidoBobina.setDataPedido(rs.getDate("datapedido"));
                pedidoBobina.setDataEntrega(rs.getDate("dataentrega"));

                pedidoBobina.setNumeroChequeA(rs.getString("numerochequeA"));
                pedidoBobina.setNumeroChequeB(rs.getString("numerochequeB"));
                pedidoBobina.setNumeroChequeC(rs.getString("numerochequeC"));

                pedidoBobina.setPagPedido(rs.getString("pagpedido"));

                pedidoBobina.setObservacaoPagamento(rs.getString("observacao"));

                pedidoBobinas.add(pedidoBobina);
            }
        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return pedidoBobinas;
    }
}
