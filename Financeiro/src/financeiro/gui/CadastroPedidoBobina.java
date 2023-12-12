/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.gui;

import financeiro.DAO.PedidoBobinaDao;
import financeiro.conexao.Conexao;
import financeiro.model.PedidoBobina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ledilson
 */
public class CadastroPedidoBobina extends javax.swing.JFrame {

    //Conversão de data
    private final SimpleDateFormat sdfPedido = new SimpleDateFormat("dd-MM-yyyy");
    private final SimpleDateFormat sdfEntrega = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Creates new form PedidoBobina
     */
    public CadastroPedidoBobina() {
        initComponents();
        carregaTabela();
        desativaBotoes();
        desativaCampos();

        CentralizarJTextFields();
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
        btAlterar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPedido = new javax.swing.JTable();
        txtNomeEmpresa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        txtQuant = new javax.swing.JTextField();
        txtDataPedido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDataEntrega = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtChequeA = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtChequeB = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtChequeC = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtTotalBobina = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTotalValor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 80, -1));

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 80, -1));

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });
        jPanel1.add(btGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 80, -1));

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 80, -1));

        tbPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empresa", "Valor", "Quant", "Data Pedido", "Data Entrega", "N. Cheque 1", "N. Cheque 2", "N. Cheque 3"
            }
        ));
        tbPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPedido);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 790, 290));
        jPanel1.add(txtNomeEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 19, 280, -1));

        jLabel1.setText("Empresa.:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, -1, 30));

        jLabel2.setText("Quant.:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 20));

        jLabel3.setText("Valor.:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 30));
        jPanel1.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 70, -1));
        jPanel1.add(txtQuant, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 40, -1));
        jPanel1.add(txtDataPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 60, 100, -1));

        jLabel4.setText("Data Pedido.:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 63, -1, 20));

        jLabel5.setText("Data Entrega.:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 110, 80, 20));
        jPanel1.add(txtDataEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 107, -1));

        jLabel6.setText("N.Cheque 1.:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 64, -1, 20));
        jPanel1.add(txtChequeA, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 60, 50, -1));

        jLabel7.setText("N.Cheque 2.:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, 20));
        jPanel1.add(txtChequeB, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 50, -1));

        jLabel8.setText("N.Cheque 3.:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, 20));
        jPanel1.add(txtChequeC, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 50, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 172, 790, 10));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 10, 170));
        jPanel1.add(txtTotalBobina, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 60, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("<-Total Geral R$->");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("<-T Bobinas->");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));
        jPanel1.add(txtTotalValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 60, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed

        PedidoBobina l = new PedidoBobina();
        PedidoBobinaDao dao = new PedidoBobinaDao();

        int index = tbPedido.getSelectedRow();
        l = dao.listarPedidoBobina().get(index);
  
        switch (JOptionPane.showConfirmDialog(null,
                "[--ALTERAÇÃO DE DADOS--] \n Dado Atual"
                + "\n Empresa:  " + l.getNomeClientePedido()
                + "\n R$: " + l.getValorPedido()
                + "\n Quant : " + l.getQuantidadeBobina()
                + "\n Data Pedido: " + l.getDataPedido()
                + "\n Data Entrega: " + l.getDataEntrega()
                + "\n N. Cheque 1: " + l.getNumeroChequeA()
                + "\n N. Cheque 2: " + l.getNumeroChequeB()
                + "\n N. Cheque 3: " + l.getNumeroChequeC()
                + "\n Será alterado \n Empresa: "
                + txtNomeEmpresa.getText()
                + "\n R$: " + txtValor.getText()
                + "\n Quant : " + txtQuant.getText()
                + "\n Data Pedido: " + txtDataPedido.getText()
                + "\n Data Entrega: " + txtDataEntrega.getText()
                + "\n N. Cheque 1: " + txtChequeA.getText()
                + "\n  N. Cheque 2: " + txtChequeB.getText()
                + "\n  N. Cheque 3: " + txtChequeC.getText()
                + "\n Deseja realmente fazer alteração?",
                "Alteração de dados.", JOptionPane.YES_NO_OPTION)) {

            case 0:

                l.setNomeClientePedido(txtNomeEmpresa.getText());
                l.setValorPedido(Double.parseDouble(txtValor.getText()));
                l.setQuantidadeBobina(Integer.parseInt(txtQuant.getText()));

                l.setNumeroChequeA(Integer.parseInt(txtChequeA.getText()));
                l.setNumeroChequeB(Integer.parseInt(txtChequeB.getText()));
                l.setNumeroChequeC(Integer.parseInt(txtChequeC.getText()));

                // Entrada da Data cliente
                try {
                    java.util.Date dataFormatada = sdfPedido.parse(txtDataPedido.getText());
                    java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
                    l.setDataPedido(dataSQL);
                } catch (ParseException ex) {
                    // Logger.getLogger(CadastroBoleto.class.getName()).log(Level.SEVERE, null, ex);

                    JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                // Entrada da Data Empresa
                try {
                    java.util.Date dataFormatada = sdfEntrega.parse(txtDataEntrega.getText());

                    java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());

                    l.setDataEntrega(dataSQL);

                } catch (ParseException ex) {

                    // Logger.getLogger(CadastroBoleto.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
                }

                dao.alterar(l);// faz alteração no banco de dados

                carregaTabela();
                limparTexto();
                desativaBotoes();
                desativaCampos();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nenhuma alteração foi feita.",
                        "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }


    }//GEN-LAST:event_btAlterarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed

        limparTexto();
        ativaBotoes();
        ativaCampos();
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed

        PedidoBobina l = new PedidoBobina();
        PedidoBobinaDao dao = new PedidoBobinaDao();

        l.setNomeClientePedido(txtNomeEmpresa.getText());

        //Converter integer para int
        l.setQuantidadeBobina(Integer.parseInt(txtQuant.getText()));

        l.setNumeroChequeA(Integer.parseInt(txtChequeA.getText()));
        l.setNumeroChequeB(Integer.parseInt(txtChequeA.getText()));
        l.setNumeroChequeC(Integer.parseInt(txtChequeA.getText()));

        //Converte o valor 
        String txtValorPedido = txtValor.getText();
        // Convertendo a String para double
        double valorPedido = Double.parseDouble(txtValorPedido);
        // Definindo o valor convertido na propriedade
        l.setValorPedido(valorPedido);

        // Entrada da Data cliente
        try {
            java.util.Date dataFormatada = sdfPedido.parse(txtDataPedido.getText());
            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
            l.setDataPedido(dataSQL);
        } catch (ParseException ex) {
            // Logger.getLogger(CadastroBoleto.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        // Entrada da Data Empresa
        try {
            java.util.Date dataFormatada = sdfEntrega.parse(txtDataEntrega.getText());

            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());

            l.setDataEntrega(dataSQL);

        } catch (ParseException ex) {

            // Logger.getLogger(CadastroBoleto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // Adicionando o objeto ao banco de dados
        dao.adicionar(l);

        // Carregando a tabela
        carregaTabela();

        // Limpar os campos, se necessário
        limparTexto();


    }//GEN-LAST:event_btGravarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        PedidoBobina l = new PedidoBobina();
        PedidoBobinaDao dao = new PedidoBobinaDao();

        int index = tbPedido.getSelectedRow();

        l = dao.listarPedidoBobina().get(index);

        l.setNomeClientePedido(txtNomeEmpresa.getText());

        //Converter integer para int
        l.setQuantidadeBobina(Integer.parseInt(txtQuant.getText()));

        l.setNumeroChequeA(Integer.parseInt(txtChequeA.getText()));
        l.setNumeroChequeB(Integer.parseInt(txtChequeA.getText()));
        l.setNumeroChequeC(Integer.parseInt(txtChequeA.getText()));

        //Converte o valor 
        String txtValorPedido = txtValor.getText();
        // Convertendo a String para double
        double valorPedido = Double.parseDouble(txtValorPedido);
        // Definindo o valor convertido na propriedade
        l.setValorPedido(valorPedido);

        // Entrada da Data cliente
        try {
            java.util.Date dataFormatada = sdfPedido.parse(txtDataPedido.getText());
            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
            l.setDataPedido(dataSQL);
        } catch (ParseException ex) {
            // Logger.getLogger(CadastroBoleto.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        // Entrada da Data Empresa
        try {
            java.util.Date dataFormatada = sdfEntrega.parse(txtDataEntrega.getText());

            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());

            l.setDataEntrega(dataSQL);
        } catch (ParseException ex) {

            // Logger.getLogger(CadastroBoleto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir o Produto ? \n "
                + "\n Empresa:  " + l.getNomeClientePedido()
                + "\n R$: " + l.getValorPedido()
                + "\n Quant : " + l.getQuantidadeBobina()
                + "\n Data Pedido: " + l.getDataPedido()
                + "\n Data Entrega: " + l.getDataEntrega()
                + "\n N. Cheque 1: " + l.getNumeroChequeA()
                + "\n N. Cheque 2: " + l.getNumeroChequeB()
                + "\n N. Cheque 3: " + l.getNumeroChequeC(), "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {

            case 0:
                dao.remover(l);
                carregaTabela();
                limparTexto();
                desativaBotoes();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }

    }//GEN-LAST:event_btExcluirActionPerformed

    private void tbPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPedidoMouseClicked
        // TODO add your handling code here:

        //Setando campos de texto com registros
        PedidoBobina g = new PedidoBobina();
        PedidoBobinaDao dao = new PedidoBobinaDao();

        int index = tbPedido.getSelectedRow();
        g = dao.listarPedidoBobina().get(index);

        txtNomeEmpresa.setText(g.getNomeClientePedido());

        // Setando valores nos campos de texto
        txtValor.setText(Double.toString(g.getValorPedido()));

        txtQuant.setText(String.valueOf(g.getQuantidadeBobina()));

        txtChequeA.setText(String.valueOf(g.getNumeroChequeA()));
        txtChequeB.setText(String.valueOf(g.getNumeroChequeB()));
        txtChequeC.setText(String.valueOf(g.getNumeroChequeC()));

        //  FORMATANDO A DATA 
        SimpleDateFormat sdfPedido = new SimpleDateFormat("dd-MM-yyyy");

        SimpleDateFormat sdfEntrega = new SimpleDateFormat("dd-MM-yyyy");

        txtDataPedido.setText(sdfPedido.format(g.getDataPedido()));

        txtDataEntrega.setText(sdfEntrega.format(g.getDataEntrega()));

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

    }//GEN-LAST:event_tbPedidoMouseClicked
    private void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tbPedido.getModel();
        modelo.setNumRows(0);

        //Defini o tamanho da tabela
        tbPedido.getColumnModel().getColumn(0).setPreferredWidth(130);
        tbPedido.getColumnModel().getColumn(1).setPreferredWidth(10);
        tbPedido.getColumnModel().getColumn(2).setPreferredWidth(5);
        tbPedido.getColumnModel().getColumn(3).setPreferredWidth(15);
        tbPedido.getColumnModel().getColumn(4).setPreferredWidth(15);
        tbPedido.getColumnModel().getColumn(5).setPreferredWidth(15);
        tbPedido.getColumnModel().getColumn(6).setPreferredWidth(10);
        tbPedido.getColumnModel().getColumn(7).setPreferredWidth(10);

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            // Consulta para obter a soma total da coluna quantidadeBobina  
            String sqlSomaTotal = "SELECT SUM (quantidadeBobina) AS totalBobinas FROM pedidobobina";
            try (PreparedStatement statement = con.prepareStatement(sqlSomaTotal);
                    ResultSet resultado = statement.executeQuery()) {

                if (resultado.next()) {
                    int totalBobinas = resultado.getInt("totalBobinas");
                    txtTotalBobina.setText(String.valueOf(totalBobinas));
                }
            }

            // Consulta para obter a soma total da coluna Valor Pedido
            String sqlSomaTotalReal = "SELECT SUM (valorpedido) AS totalValor FROM pedidobobina";
            try (PreparedStatement statement = con.prepareCall(sqlSomaTotalReal);
                    ResultSet resultadoValor = statement.executeQuery()) {

                if (resultadoValor.next()) {
                    Double totalValor = resultadoValor.getDouble("totalValor");
                    txtTotalValor.setText(String.valueOf(totalValor));
                }
            }

            pstm = con.prepareStatement("SELECT * FROM pedidobobina ORDER BY nomeCliente ASC;");
            rs = pstm.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    //rs.getString(1), id da tabela do banco de dados
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9)
                });
            }
            Conexao.closeConnection(con, pstm, rs);

        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void CentralizarJTextFields() {

        txtTotalBobina.setHorizontalAlignment(SwingConstants.CENTER);
        txtTotalValor.setHorizontalAlignment(SwingConstants.CENTER);
        txtValor.setHorizontalAlignment(SwingConstants.CENTER);
        txtDataEntrega.setHorizontalAlignment(SwingConstants.CENTER);
        txtDataPedido.setHorizontalAlignment(SwingConstants.CENTER);
        txtQuant.setHorizontalAlignment(SwingConstants.CENTER);

        txtTotalBobina.setEnabled(false);
        txtTotalValor.setEnabled(false);
    }

    private void limparTexto() {

        txtNomeEmpresa.setText("");
        txtNomeEmpresa.setText("");

        txtQuant.setText("");

        txtDataEntrega.setText("");
        txtDataPedido.setText("");

        txtChequeA.setText("");
        txtChequeB.setText("");
        txtChequeC.setText("");

        btGravar.setEnabled(false);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }

    private void desativaBotoes() {
        btGravar.setEnabled(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);

    }

    private void desativaCampos() {

        txtNomeEmpresa.setEnabled(false);

        txtValor.setEnabled(false);

        txtQuant.setEnabled(false);

        txtDataEntrega.setEnabled(false);
        txtDataPedido.setEnabled(false);

        txtChequeA.setEnabled(false);
        txtChequeB.setEnabled(false);
        txtChequeC.setEnabled(false);
    }

    private void ativaBotoes() {
        btGravar.setEnabled(true);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);

    }

    private void ativaCampos() {
        txtNomeEmpresa.setEnabled(true);

        txtValor.setEnabled(true);

        txtQuant.setEnabled(true);

        txtDataEntrega.setEnabled(true);
        txtDataPedido.setEnabled(true);

        txtChequeA.setEnabled(true);
        txtChequeB.setEnabled(true);
        txtChequeC.setEnabled(true);

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
            java.util.logging.Logger.getLogger(CadastroPedidoBobina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPedidoBobina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPedidoBobina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPedidoBobina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPedidoBobina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbPedido;
    private javax.swing.JTextField txtChequeA;
    private javax.swing.JTextField txtChequeB;
    private javax.swing.JTextField txtChequeC;
    private javax.swing.JTextField txtDataEntrega;
    private javax.swing.JTextField txtDataPedido;
    private javax.swing.JTextField txtNomeEmpresa;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JTextField txtTotalBobina;
    private javax.swing.JTextField txtTotalValor;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
