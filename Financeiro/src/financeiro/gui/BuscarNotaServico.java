/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.gui;

import financeiro.DAO.BobinaDao;
import financeiro.DAO.CompraBDao;
import financeiro.conexao.Conexao;
import financeiro.model.CompraBobina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Ledilson
 */
public class BuscarNotaServico extends javax.swing.JFrame {

    /**
     * Creates new form Pedido
     */
    public BuscarNotaServico() {
        initComponents();
       desabilitarBotoes();
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
        tbBuscaClientes = new javax.swing.JTable();
        dateChooserInicio = new com.toedter.calendar.JDateChooser();
        dateChooserFim = new com.toedter.calendar.JDateChooser();
        btBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btPesquisa = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Localizar NS Clientes");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbBuscaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Cliente", "Quantidade", "Produto", "Preço Unitário", "Peso", "Carga Total"
            }
        ));
        tbBuscaClientes.setEnabled(false);
        jScrollPane1.setViewportView(tbBuscaClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 710, 300));
        jPanel1.add(dateChooserInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 129, -1));
        jPanel1.add(dateChooserFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 129, -1));

        btBuscar.setText("Procurar Registro");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 53, 150, 30));

        jLabel1.setText("Data Inicial");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 87, -1));

        jLabel2.setText("Data Final");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 56, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, 730, 10));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 14, 95));

        btPesquisa.setText("Nova Pesquisa");
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 13, 150, 30));

        jButton2.setText("Imprimir");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 53, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // Verificar se as datas inicial e final estão selecionadas
        if (dateChooserInicio.getDate() == null || dateChooserFim.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione as datas inicial e final antes de realizar a pesquisa.", "Datas não Selecionadas", JOptionPane.WARNING_MESSAGE);
            return; // Abortar a operação se as datas não estiverem selecionadas
        }

        // dateChooserInicio.setEnabled(false);
        //dateChooserFim.setEnabled(false);
        DefaultTableModel model = (DefaultTableModel) tbBuscaClientes.getModel();

        TableColumnModel columnModel = tbBuscaClientes.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(100);  // Largura em pixels
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(20);
        columnModel.getColumn(3).setPreferredWidth(40);
        columnModel.getColumn(4).setPreferredWidth(40);
        columnModel.getColumn(5).setPreferredWidth(40);
        columnModel.getColumn(6).setPreferredWidth(40);
       

        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar o renderizador às colunas de valorpedido (índice 1) e quantidadebobina (índice 2)
        tbBuscaClientes.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbBuscaClientes.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbBuscaClientes.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbBuscaClientes.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tbBuscaClientes.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbBuscaClientes.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
      

        try (Connection con = Conexao.getConnection()) {
            String sql = "SELECT * FROM emissornotaservico WHERE (datanotaservico BETWEEN ? AND ?) OR (datanotaservico BETWEEN ? AND ?)";

            //Formatar o valor no campo jtable
            NumberFormat currencyValorUnitario = NumberFormat.getCurrencyInstance();
            NumberFormat currencyValorPeso = NumberFormat.getCurrencyInstance();
            NumberFormat currencyValorCargaInicial = NumberFormat.getCurrencyInstance();

            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setObject(1, new java.sql.Timestamp(dateChooserInicio.getDate().getTime()));
                pst.setObject(2, new java.sql.Timestamp(dateChooserFim.getDate().getTime()));
                pst.setObject(3, new java.sql.Timestamp(dateChooserInicio.getDate().getTime()));
                pst.setObject(4, new java.sql.Timestamp(dateChooserFim.getDate().getTime()));

                //linha para testar a consultar
                //  System.out.println("SQL: " + pst.toString());
                try (ResultSet rs = pst.executeQuery()) {
                    if (!rs.next()) {
                        //ResultSet está vazio, exibir mensagem
                        JOptionPane.showMessageDialog(this, "Consulta não encontrou dados com a data inicial e final fornecida.", "Sem Resultados", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Limpar todas as linhas existentes na tabela
                        model.setRowCount(0);
                        do {

                            model.addRow(new Object[]{
                                rs.getObject("datanotaservico"),
                                rs.getObject("clienteempresa"),
                                rs.getObject("quantproduto"),
                                rs.getObject("nomeproduto"),
                                currencyValorUnitario.format(rs.getDouble("valorunitario")),
                                currencyValorPeso.format(rs.getDouble("valorpeso")),
                                currencyValorCargaInicial.format(rs.getDouble("cargainicial")),});
                        } while (rs.next());
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        // TODO add your handling code here:
        habilitarBotoes();
    }//GEN-LAST:event_btPesquisaActionPerformed
    private double totalAcumulado = 0.0;
    private void habilitarBotoes() {

        dateChooserInicio.setEnabled(true);
        dateChooserFim.setEnabled(true);
        btBuscar.setEnabled(true);

    }

    private void desabilitarBotoes() {

        dateChooserInicio.setEnabled(false);
        dateChooserFim.setEnabled(false);
        btBuscar.setEnabled(false);
        // btPesquisa.setEnabled(false);

    }

   
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
            java.util.logging.Logger.getLogger(BuscarNotaServico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarNotaServico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarNotaServico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarNotaServico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarNotaServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btPesquisa;
    private com.toedter.calendar.JDateChooser dateChooserFim;
    private com.toedter.calendar.JDateChooser dateChooserInicio;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbBuscaClientes;
    // End of variables declaration//GEN-END:variables
}