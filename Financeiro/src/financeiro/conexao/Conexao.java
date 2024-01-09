/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.conexao;

/**
 *
 * @author Ledilson
 */
//importa as classes necessárias para o funcionamento da classe
import java.sql.Connection; // conexão SQL para Java
import java.sql.DriverManager; // driver de conexão SQL para Java
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; // classe para tratamento de exceções
import java.util.TimeZone;
 
 

 public class Conexao {

    private static final String Drive = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/financeiro";
    private static final String USUARIO_POSTGRES = "postgres";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() {
        try {
            Class.forName(Drive);
           
            
            return DriverManager.getConnection(URL, USUARIO_POSTGRES, PASSWORD); 
            
        } catch (ClassNotFoundException | SQLException ErroSql) {
            throw new RuntimeException("ERRO! Não foi possivel conectar. " + ErroSql);
        }

    } 
 

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception ErroSql) {
            throw new RuntimeException("ERRO! Não foi possivel fecha a conexão" + ErroSql);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pstm) {
        closeConnection(con);
        try {
            if (pstm != null) {
                pstm.close();
            }
        } catch (Exception ErroSql) {
            throw new RuntimeException("ERRO! Não foi possivel fecha o PreparedStatment" + ErroSql);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pstm, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception ErroSql) {
            throw new RuntimeException("ERRO! Não foi possivel fecha o ResultSet" + ErroSql);
        }
    }

}
