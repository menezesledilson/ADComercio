package financeiro.DAO;

import financeiro.conexao.Conexao;
import financeiro.model.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpresaDao {

    public void adicionar(Empresa empresa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("INSERT INTO empresa(nome, cidade, uf, cnpj, celular,observacao) VALUES (?,?,?, ?, ?, ?);");
            pstm.setString(1, empresa.getNome());
            pstm.setString(2, empresa.getCidade());
            pstm.setString(3, empresa.getUF());
            pstm.setString(4, empresa.getCNPJ());
            pstm.setString(5, empresa.getCelular());
            pstm.setString(6, empresa.getObservacao());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException) {
            // Logar a exceção
            sqlException.printStackTrace();
            // Mostrar uma mensagem mais específica para o usuário
            JOptionPane.showMessageDialog(null, "Erro SQL ao adicionar no banco: " + sqlException.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void alterar(Empresa empresa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("update empresa set nome = ?, cnpj=?, cidade = ?, uf = ?, celular = ?, observacao = ?  where id =?;");
            pstm.setString(1, empresa.getNome());
            pstm.setString(2, empresa.getCNPJ());
            pstm.setString(3, empresa.getCidade());
            pstm.setString(4, empresa.getUF());
            pstm.setString(5, empresa.getCelular());
            pstm.setString(6, empresa.getObservacao());
            pstm.setLong(7, empresa.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public void remover(Empresa empresa) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareCall("delete from empresa where id = ? ; ");
            pstm.setLong(1, empresa.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm);
        }
    }

    public List<Empresa> listarEmpresa() {
        List<Empresa> empresas = new ArrayList<>();
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement("SELECT * FROM empresa ORDER BY nome ASC;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(rs.getLong("id"));
                empresa.setNome(rs.getString("nome"));
                empresa.setCidade(rs.getString("cidade"));
                empresa.setCNPJ(rs.getString("uf"));
                empresa.setCNPJ(rs.getString("cnpj"));
                empresa.setCelular(rs.getString("celular"));
                empresa.setObservacao(rs.getString("observacao"));
                empresas.add(empresa);
            }
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return empresas;
    }

    public boolean clienteExistePorCNPJ(String cnpj) {
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        boolean existe = false;
        try {
            pstm = con.prepareStatement("select id from empresa where cnpj=? ");
            pstm.setString(1, cnpj);
            rs = pstm.executeQuery();

            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro SQL ao verificar se o cliente existe: " + sqlException.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return existe;
    }
}
