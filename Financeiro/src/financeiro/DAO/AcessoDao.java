/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.Credencial;
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
public class AcessoDao {

    public void adicionar(Credencial credencial) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("INSERT INTO acesso (nome, login,senha,permissao) VALUES (?,?,?,?); ");

            pstm.setString(1, credencial.getNome());
            pstm.setString(2, credencial.getLogin());
              pstm.setString(3, credencial.getSenha());
              pstm.setString(4, credencial.getPermissao());

            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void remover(Credencial credencial) {

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("DELETE FROM acesso WHERE id = ?");

            pstm.setLong(1, credencial.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public List<Credencial> ListaCrendecial() {
        List<Credencial> credencials = new ArrayList<>();

        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT * FROM acesso ORDER BY nome ASC;");
            rs = pstm.executeQuery();

            while (rs.next()) {

                Credencial credencial = new Credencial();

                credencial.setId(rs.getLong("id"));
                credencial.setNome(rs.getString("nome"));
                credencial.setLogin(rs.getString("login"));
                 credencial.setSenha(rs.getString("senha"));
                   credencial.setPermissao(rs.getString("permissao"));

                credencials.add(credencial);
            }
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return credencials;
    }
  
}

