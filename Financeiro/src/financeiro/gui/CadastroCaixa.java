/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.gui;

import financeiro.DAO.CaixaDao;
import financeiro.conexao.Conexao;
import financeiro.model.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ledilson
 */
public class CadastroCaixa extends javax.swing.JFrame {

    //Data automatica
    private final SimpleDateFormat sdfDataAutomatica = new SimpleDateFormat("dd-MM-yyyy");
   
    

    /**
     * Creates new form CadastroFluxoCaixa
     */
    public CadastroCaixa() {
        initComponents();
        carregaTabela();
        CentralizarCampos();
        limparTexto();
        DesativaCampos();
        DesativarBotao();
        
       // setResizable(false);
        
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
        txtDescricao = new javax.swing.JTextField();
        txtEntrada = new javax.swing.JTextField();
        txtSaida = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btSaida = new javax.swing.JButton();
        btEntrada = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        saldoLabel = new javax.swing.JLabel();
        lblSaldoAtual = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblsaldoAnterior = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btNovo = new javax.swing.JButton();

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 680, 320));
        jPanel1.add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 20, 130, -1));
        jPanel1.add(txtEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 80, -1));
        jPanel1.add(txtSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 90, -1));

        jLabel1.setText("Descrição.:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 24, -1, 20));

        jLabel2.setText("Entrada.:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 64, 60, 20));

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 80, -1));

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 80, -1));

        jLabel4.setText("Saída.:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 104, -1, 20));

        btSaida.setText("Saida");
        btSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaidaActionPerformed(evt);
            }
        });
        jPanel1.add(btSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 80, -1));

        btEntrada.setText("Entrada");
        btEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntradaActionPerformed(evt);
            }
        });
        jPanel1.add(btEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 80, -1));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saldoLabel.setForeground(new java.awt.Color(255, 0, 153));
        jPanel2.add(saldoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 40, 20));

        lblSaldoAtual.setForeground(new java.awt.Color(0, 0, 204));
        lblSaldoAtual.setText("0.00");
        jPanel2.add(lblSaldoAtual, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 40, 20));

        jLabel3.setText("Saldo anterior R$:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        lblsaldoAnterior.setForeground(new java.awt.Color(255, 0, 0));
        lblsaldoAnterior.setText("0.00");
        jPanel2.add(lblsaldoAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 50, 20));

        jLabel5.setText("Saldo atual R$:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 170, 70));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 20, 140));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 20, 140));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 680, 10));

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        AtivarCampos();
        btEntrada.setEnabled(true);
        btSaida.setEnabled(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntradaActionPerformed
        Caixa l = new Caixa();
        CaixaDao dao = new CaixaDao();

        String entradaText = txtEntrada.getText().trim();

        if (entradaText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um valor para a entrada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;  // Encerra o método se o campo de entrada estiver vazio
        }

        l.setDescricao(txtDescricao.getText());
        l.setEntrada(Double.parseDouble(txtEntrada.getText()));
        l.setSaida(0.0); // Definindo a saída como zero para entrada

        dao.entrada(l);
        carregaTabela();
    }//GEN-LAST:event_btEntradaActionPerformed

    private void btSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaidaActionPerformed
        Caixa l = new Caixa();
        CaixaDao dao = new CaixaDao();

        String entradaText = txtSaida.getText().trim();

        if (entradaText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um valor para saída.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;  // Encerra o método se o campo de entrada estiver vazio
        }

        l.setDescricao(txtDescricao.getText());
        l.setSaida(Double.parseDouble(txtSaida.getText()));
        l.setEntrada(0.0); // Definindo a entrada como zero para saída

        dao.saida(l);
        carregaTabela();
        limparTexto();
    }//GEN-LAST:event_btSaidaActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        Caixa l = new Caixa();
        CaixaDao dao = new CaixaDao();

        int index = tbFluxoCaixa.getSelectedRow();
        l = dao.listarFluxoCaixa().get(index);

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir a Informção ? \n "
            + "\n Descrição:  " + l.getDescricao()
            + "\n Entrada R$: " + l.getEntrada()
            + "\n Saida R$: " + l.getSaida()
            + "\n Será alterado"
            + " \n Descrição: " + txtDescricao.getText()
            + "\n Entrada R$: " + txtEntrada.getText()
            + "\n Saida R$: " + txtSaida.getText(),
            "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {

        case 0:
        dao.remover(l);
        carregaTabela();
        limparTexto();
        // desativaBotoes();
        break;
        case 1:
        JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        break;
        }
        btNovo.setEnabled(true);
        DesativaCampos();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed

        Caixa l = new Caixa();
        CaixaDao dao = new CaixaDao();

        int index = tbFluxoCaixa.getSelectedRow();
        l = dao.listarFluxoCaixa().get(index);

        switch (JOptionPane.showConfirmDialog(null,
            "[--ALTERAÇÃO DE DADOS--] \n Dado Atual"
            + "\n Descrição:  " + l.getDescricao()
            + "\n Entrada R$: " + l.getEntrada()
            + "\n Saida R$: " + l.getSaida()
            + "\n Será alterado"
            + " \n Descrição: " + txtDescricao.getText()
            + "\n Entrada R$: " + txtEntrada.getText()
            + "\n Saida R$: " + txtSaida.getText()
            + "\n Deseja realmente fazer alteração?",
            "Alteração de dados.", JOptionPane.YES_NO_OPTION)) {

        case 0:

        double novaEntrada = Double.parseDouble(txtEntrada.getText());
        double novaSaida = Double.parseDouble(txtSaida.getText());

        // Verifica se houve alteração na entrada
        if (novaEntrada != l.getEntrada()) {
            l.setEntrada(novaEntrada);
            dao.entrada(l);
        }

        // Verifica se houve alteração na saída
        if (novaSaida != l.getSaida()) {
            l.setSaida(novaSaida);
            dao.saida(l);
        }

        carregaTabela();
        limparTexto();
        // desativaBotoes();
        //desativaCampos();
        break;
        case 1:
        JOptionPane.showMessageDialog(null, "Nenhuma alteração foi feita.",
            "AVISO", JOptionPane.INFORMATION_MESSAGE);
        break;
        }
        btNovo.setEnabled(true);
        DesativaCampos();
    }//GEN-LAST:event_btAlterarActionPerformed

    private void tbFluxoCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFluxoCaixaMouseClicked

        Caixa l = new Caixa();

        CaixaDao dao = new CaixaDao();

        int index = tbFluxoCaixa.getSelectedRow();

        l = dao.listarFluxoCaixa().get(index);

        txtDescricao.setText(l.getDescricao());

        txtEntrada.setText(Double.toString(l.getEntrada()));
        txtSaida.setText(Double.toString(l.getSaida()));

        //Configurar a data e hora automatica
        java.util.Date dataHoraAtual = new java.util.Date();
        java.sql.Timestamp dataSQL = new java.sql.Timestamp(dataHoraAtual.getTime());
        l.setDataHora(dataSQL);

        desativaBotoes();

        btNovo.setEnabled(false);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);

        txtDescricao.setEnabled(true);

        txtEntrada.setEnabled(true);

        txtSaida.setEnabled(true);
        /*
        btEntrada.setEnabled(false);
        btSaida.setEnabled(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        */
    }//GEN-LAST:event_tbFluxoCaixaMouseClicked
private void carregaTabela() {
    

        DefaultTableModel modelo = (DefaultTableModel) tbFluxoCaixa.getModel();
        modelo.setNumRows(0);

        //Defini o tamanho da tabela
        tbFluxoCaixa.getColumnModel().getColumn(0).setPreferredWidth(1);
        tbFluxoCaixa.getColumnModel().getColumn(1).setPreferredWidth(1);
        tbFluxoCaixa.getColumnModel().getColumn(2).setPreferredWidth(1);
        tbFluxoCaixa.getColumnModel().getColumn(3).setPreferredWidth(1);

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT datahora, descricao, entrada, saida,LAG(SUM(entrada - COALESCE(saida, 0))) OVER (ORDER BY datahora) AS saldoAnterior,SUM(entrada - COALESCE(saida, 0)) OVER (ORDER BY datahora) AS saldoAtual FROM caixa GROUP BY datahora, descricao, entrada, saida ORDER BY datahora ASC;");
            rs = pstm.executeQuery();

            NumberFormat currencyEntrada = NumberFormat.getCurrencyInstance();
            NumberFormat currencySaida = NumberFormat.getCurrencyInstance();
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("datahora"),
                    rs.getString("descricao"),
                    currencyEntrada.format(rs.getDouble("entrada")),
                    currencyEntrada.format(rs.getDouble("saida"))
                });

                // Extraindo o saldoAtual e atualizando o JLabel
                double saldoAtual = rs.getDouble("saldoAtual");
                lblSaldoAtual.setText("" + saldoAtual);

                double saldoAnterior = rs.getDouble("saldoAnterior");
                lblsaldoAnterior.setText("" + saldoAnterior);
            }

            Conexao.closeConnection(con, pstm, rs);

        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void CentralizarCampos() {
        txtEntrada.setHorizontalAlignment(SwingConstants.CENTER);
        txtSaida.setHorizontalAlignment(SwingConstants.CENTER);
        lblsaldoAnterior.setHorizontalAlignment(SwingConstants.CENTER);
        lblSaldoAtual.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void limparTexto() {
        txtDescricao.setText("");
        txtEntrada.setText("");
        txtSaida.setText("");

    }

    private void DesativarBotao() {

        btEntrada.setEnabled(false);
        btSaida.setEnabled(false);
        btExcluir.setEnabled(false);
        btAlterar.setEnabled(false);

    }

    private void AtivarCampos() {
        txtDescricao.setEnabled(true);
        txtEntrada.setEnabled(true);
        txtSaida.setEnabled(true);
    }

    private void DesativaCampos() {
        txtDescricao.setEnabled(false);
        txtEntrada.setEnabled(false);
        txtSaida.setEnabled(false);
    }

    private void desativaBotoes() {

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
            java.util.logging.Logger.getLogger(CadastroCaixa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCaixa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCaixa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCaixa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btEntrada;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSaida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblSaldoAtual;
    private javax.swing.JLabel lblsaldoAnterior;
    private javax.swing.JLabel saldoLabel;
    private javax.swing.JTable tbFluxoCaixa;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtSaida;
    // End of variables declaration//GEN-END:variables

}