/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.gui;

import financeiro.DAO.BobinaDao;
import financeiro.conexao.Conexao;
import financeiro.model.BobinaC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.security.x509.X500Name;

/**
 *
 * @author Ledilson
 */
public class CadastroBobina extends javax.swing.JFrame {

    /**
     * Creates new form CadastroBobina
     */
    public CadastroBobina() {
        initComponents();
        carregaTabela();
        desativaBotoes();
        desativaCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBobina = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Produtos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Descrição.:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        jLabel2.setText("Preço KG.:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        txtDescricao.setNextFocusableComponent(txtValor);
        jPanel1.add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 190, 20));

        txtValor.setNextFocusableComponent(txtValor);
        jPanel1.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 50, 70, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 101, 450, 30));

        tbBobina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome.", "Valor."
            }
        ));
        tbBobina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBobinaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBobina);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 330));

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 80, -1));

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 80, -1));

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });
        jPanel1.add(btGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 80, -1));

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 80, -1));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 10, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed

        BobinaC b = new BobinaC();
        BobinaDao dao = new BobinaDao();

        b.setNomeBobina(txtDescricao.getText());

        // Obtendo o valor como uma String do campo de texto
        String valorBobinaText = txtValor.getText();

        // Convertendo a String para double
        double valorBobina = Double.parseDouble(valorBobinaText);

        // Definindo o valor convertido na propriedade
        b.setValorBobina(valorBobina);

        dao.adicionar(b);
        carregaTabela();

        limparTexto();

        // Agora, adicione a nova linha diretamente ao modelo da tabela
        // DefaultTableModel modelo = (DefaultTableModel) tbBobina.getModel();
        //modelo.addRow(new Object[]{b.getNomeBobina(), String.valueOf(b.getValorBobina())});

    }//GEN-LAST:event_btGravarActionPerformed

    private void tbBobinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBobinaMouseClicked
        // TODO add your handling code here:

        //Setando campos de texto com registros
        BobinaC p = new BobinaC();
        BobinaDao dao = new BobinaDao();

        int index = tbBobina.getSelectedRow();

        p = dao.listar().get(index);

        txtDescricao.setText(p.getNomeBobina());
        txtValor.setText(Double.toString(p.getValorBobina()));

        txtDescricao.setEnabled(true);
        txtValor.setEnabled(true);
        btGravar.setEnabled(false);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);


    }//GEN-LAST:event_tbBobinaMouseClicked

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed

        //Objetos 
        BobinaC p = new BobinaC();
        BobinaDao dao = new BobinaDao();

        int index = tbBobina.getSelectedRow(); // retorna o numero da linha selecionada

        p = dao.listar().get(index);//retorna o objeto do arraylist de acordo com a posição

        switch (JOptionPane.showConfirmDialog(null, " [--ALTERAÇÃO DE PRODUTO--] \n Produto Atual: " + p.getNomeBobina() + "\n R$: "
                + p.getValorBobina() + "0 " 
                + "\n Será alterado para \n Novo Produto: " + txtDescricao.getText()
                + "\n R$: " + txtValor.getText()+ "0 " 
                + "\n Deseja realmente fazer alteração? ",
                " Alteração de dados. ", JOptionPane.YES_NO_OPTION)) {

            case 0:

                p.setNomeBobina(txtDescricao.getText()); // seta as novas informações para objeto selecionado
                p.setValorBobina(Double.parseDouble(txtValor.getText()));

                dao.alterar(p);// faz alteração no banco de dados
                carregaTabela();
                limparTexto();
                desativaBotoes();
                desativaCampos();
                break;

            case 1:
                JOptionPane.showMessageDialog(null, "Nenhuma alteração foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        BobinaC p = new BobinaC();

        BobinaDao dao = new BobinaDao();

        int index = tbBobina.getSelectedRow();

        p = dao.listar().get(index);

        p.setNomeBobina(txtDescricao.getText());

        p.setValorBobina(Double.parseDouble(txtValor.getText()));

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir o Produto ? \n "
                + "Produto:  " + p.getNomeBobina()
                + "\n R$: " + p.getValorBobina() + "0 ", "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {

            case 0:
                dao.remover(p);
                carregaTabela();
                limparTexto();
                desativaBotoes();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }


    }//GEN-LAST:event_btExcluirActionPerformed

    private void limparTexto() {
        txtDescricao.setText("");
        txtValor.setText("");

    }

    private void desativaBotoes() {
        btGravar.setEnabled(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);

    }

    private void desativaCampos() {
        txtDescricao.setEnabled(false);
        txtValor.setEnabled(false);

    }

    private void ativaBotoes() {
        btGravar.setEnabled(true);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);

    }

    private void ativaCampos() {
        txtDescricao.setEnabled(true);
        txtValor.setEnabled(true);

    }

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed

        limparTexto();
        ativaBotoes();
        ativaCampos();
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);

    }//GEN-LAST:event_btNovoActionPerformed

    private void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tbBobina.getModel();
        modelo.setNumRows(0);

        //Defini o tamanho da tabela
        tbBobina.getColumnModel().getColumn(0).setPreferredWidth(350);
        tbBobina.getColumnModel().getColumn(1).setPreferredWidth(20);

        /* BobinaDao dao = new BobinaDao();

         try {
         dao.listar().stream().forEach((p) -> {
         modelo.addRow(new Object[]{
         p.getNomeBobina(),
         p.getValorBobina()
         });
         });
         } catch (Exception Erro) 
         {
         JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados " + Erro, "ERRO", JOptionPane.ERROR);
         }*/
        try {

            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT * FROM bobina ORDER BY nomeBobina ASC;");
            rs = pstm.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString(2),
                    rs.getString(3)
                });
            }
            Conexao.closeConnection(con, pstm, rs);

        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR);
        }
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
            java.util.logging.Logger.getLogger(CadastroBobina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroBobina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroBobina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroBobina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroBobina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tbBobina;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
