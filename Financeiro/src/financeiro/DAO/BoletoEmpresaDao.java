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

public class BoletoEmpresaDao {

    public void adicionar(BoletoEmpresa boletoEmpresa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("insert into boletoEmpresa(nomeboletoreceber,databoletoreceber,valorboletoreceber,nomeboletoapagar,databoletoapagar,valorboletoapagar,statuspago,observacao,numeronota) values (?,?,?,?,?,?,?,?,?);");
            pstm.setString(1, boletoEmpresa.getBoletoClienteReceber());
            pstm.setDate(2, boletoEmpresa.getDataClienteReceber());
            pstm.setDouble(3, boletoEmpresa.getReceberClienteValor());
            pstm.setString(4, boletoEmpresa.getBoletoEmpresaPagar());
            pstm.setDate(5, boletoEmpresa.getDataEmpresaPagar());
            pstm.setDouble(6, boletoEmpresa.getPagarEmpresaValor());
            pstm.setString(7, boletoEmpresa.getStatus());
            pstm.setString(8, boletoEmpresa.getObservacao());
            pstm.setString(9, boletoEmpresa.getNumeroNota());
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
            pstm = con.prepareStatement("update boletoempresa set nomeboletoreceber = ?, databoletoreceber = ?, valorboletoreceber = ?, nomeboletoapagar = ?, databoletoapagar = ?, valorboletoapagar = ?, statuspago = ?, observacao = ?,numeronota = ? where id = ?;");

            pstm.setString(1, boletoEmpresa.getBoletoClienteReceber());
            pstm.setDate(2, boletoEmpresa.getDataClienteReceber());
            pstm.setDouble(3, boletoEmpresa.getReceberClienteValor());
            pstm.setString(4, boletoEmpresa.getBoletoEmpresaPagar());
            pstm.setDate(5, boletoEmpresa.getDataEmpresaPagar());
            pstm.setDouble(6, boletoEmpresa.getPagarEmpresaValor());
            pstm.setString(7, boletoEmpresa.getStatus());
            pstm.setString(8, boletoEmpresa.getObservacao());
            pstm.setString(9, boletoEmpresa.getNumeroNota());

            pstm.setLong(10, boletoEmpresa.getId());

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
            pstm = con.prepareCall("DELETE FROM boletoempresa where id = ?;");
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
            pstm = con.prepareStatement("SELECT * FROM boletoempresa ORDER BY databoletoreceber ASC;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                BoletoEmpresa boletoEmpresa = new BoletoEmpresa();

                boletoEmpresa.setId(rs.getLong("id"));
                boletoEmpresa.setBoletoClienteReceber(rs.getString("nomeboletoreceber"));
                boletoEmpresa.setBoletoEmpresaPagar(rs.getString("nomeboletoapagar"));
                boletoEmpresa.setReceberClienteValor(rs.getDouble("valorboletoreceber"));
                boletoEmpresa.setPagarEmpresaValor(rs.getDouble("valorboletoapagar"));
                boletoEmpresa.setDataClienteReceber(rs.getDate("databoletoreceber"));
                boletoEmpresa.setDataEmpresaPagar(rs.getDate("databoletoapagar"));
                boletoEmpresa.setStatus(rs.getString("statuspago"));
                boletoEmpresa.setNumeroNota(rs.getString("numeronota"));
                boletoEmpresa.setObservacao(rs.getString("observacao"));

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
