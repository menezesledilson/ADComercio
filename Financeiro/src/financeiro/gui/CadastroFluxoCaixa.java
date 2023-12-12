/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.gui;

import financeiro.DAO.FluxoCaixaDao;
import financeiro.conexao.Conexao;
import financeiro.model.FluxoCaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ledilson
 */
public class CadastroFluxoCaixa extends javax.swing.JFrame {

    //Data automatica
    private final SimpleDateFormat sdfDataAutomatica = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Creates new form CadastroFluxoCaixa
     */
    public CadastroFluxoCaixa() {
        initComponents();
        carregaTela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFluxoCaixa = new javax.swing.JTable();
        txtDescricaoFluxo = new javax.swing.JTextField();
        txtEntrada = new javax.swing.JTextField();
        txtSaida = new javax.swing.JTextField();
        txtDataHora = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbFluxoCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Descrição", "Entrada", "Saida"
            }
        ));
        tbFluxoCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFluxoCaixaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFluxoCaixa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 185, 670, 214));
        jPanel1.add(txtDescricaoFluxo, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 47, 136, -1));
        jPanel1.add(txtEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 108, 136, -1));
        jPanel1.add(txtSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 155, 136, -1));
        jPanel1.add(txtDataHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 155, 230, -1));

        jLabel1.setText("Descricao");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 14, -1, -1));

        jLabel2.setText("Entrada");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 83, -1, -1));

        jLabel3.setText("Data e Hora automatico");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        btAlterar.setText("Alterar");
        jPanel1.add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

        btExcluir.setText("Excluir");
        jPanel1.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, -1));

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });
        jPanel1.add(btGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, -1));

        btNovo.setText("Novo");
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        jLabel4.setText("Saida");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 135, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed

        FluxoCaixa l = new FluxoCaixa();
        FluxoCaixaDao dao = new FluxoCaixaDao();

        int index = tbFluxoCaixa.getSelectedRow();

        // Configurar outras propriedades
        l = dao.listarFluxoCaixa().get(index);
        l.setValorEntrada(Double.parseDouble(txtEntrada.getText()));
        l.setValorSaida(Double.parseDouble(txtSaida.getText()));

        //Configurar a data e hora automatica 
        java.util.Date dataHoraAtual = new java.util.Date();
        java.sql.Timestamp dataSQL = new java.sql.Timestamp(dataHoraAtual.getTime());
        l.setDataHora(dataSQL);

        // Carregar a tabela
        //  carregaTabela();
        dao.adicionar(l);
    }//GEN-LAST:event_btGravarActionPerformed
    private void carregaTela() {

        DefaultTableModel modelo = (DefaultTableModel) tbFluxoCaixa.getModel();
        modelo.setNumRows(0);

        //Definir o tamanho da tabela
        // tbFluxoCaixa.getColumnModel().getColumn(0).setPreferredWidth(10);
        //tbFluxoCaixa.getColumnModel().getColumn(1).setPreferredWidth(10);
        // tbFluxoCaixa.getColumnModel().getColumn(2).setPreferredWidth(5);
        //tbFluxoCaixa.getColumnModel().getColumn(3).setPreferredWidth(15);
        // tbFluxoCaixa.getColumnModel().getColumn(4).setPreferredWidth(15);
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT * FROM fluxocaixa ORDER BY dataHoraCadastro ASC;");
            rs = pstm.executeQuery();
 
            while (rs.next()) {
            

                modelo.addRow(new Object[]{
                    //rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                });
            }
            Conexao.closeConnection(con, pstm, rs);

        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void tbFluxoCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFluxoCaixaMouseClicked

        FluxoCaixa l = new FluxoCaixa();

        FluxoCaixaDao dao = new FluxoCaixaDao();

        int index = tbFluxoCaixa.getSelectedRow();

        l = dao.listarFluxoCaixa().get(index);

        txtDescricaoFluxo.setText(l.getDescricaoFluxo());

        txtEntrada.setText(Double.toString(l.getValorEntrada()));
        txtSaida.setText(Double.toString(l.getValorSaida()));

        //Configurar a data e hora automatica 
        java.util.Date dataHoraAtual = new java.util.Date();
        java.sql.Timestamp dataSQL = new java.sql.Timestamp(dataHoraAtual.getTime());
        l.setDataHora(dataSQL);

        /* //Setando campos de texto com registros
        

         // Setando valores nos campos de texto
          
         
         //  FORMATANDO A DATA 
      

         txtNomeEmpresa.setEnabled(true);

         txtValor.setEnabled(true);

         txtQuant.setEnabled(true);

         txtDataEntrega.setEnabled(true);
         txtDataPedido.setEnabled(true);

         txtChequeA.setEnabled(true);
         txtChequeB.setEnabled(true);
         txtChequeC.setEnabled(true);

         btGravar.setEnabled(false);
         btAlterar.setEnabled(true);
         btExcluir.setEnabled(true);

         */
    }//GEN-LAST:event_tbFluxoCaixaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroFluxoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFluxoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFluxoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFluxoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFluxoCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFluxoCaixa;
    private javax.swing.JTextField txtDataHora;
    private javax.swing.JTextField txtDescricaoFluxo;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtSaida;
    // End of variables declaration//GEN-END:variables
}