package financeiro.gui;

import financeiro.DAO.BoletoEmpresaDao;
import financeiro.conexao.Conexao;
import javax.swing.JOptionPane;
import financeiro.model.BoletoEmpresa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ledilson
 */
public class CadastroBoleto extends javax.swing.JInternalFrame {

    //Conversão de data
    private final SimpleDateFormat sdfC = new SimpleDateFormat("dd-MM-yyyy");
    private final SimpleDateFormat sdfE = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Creates new form CadastroBoleto
     */
    public CadastroBoleto() {
        initComponents();
        carregaTabela();
        desativaBotoes();
        desativaCampos();
        CentralizarJTextFields();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtClienteReceber = new javax.swing.JTextField();
        btNovo = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBoletoClienteEmpresa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtEmpresaPagar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtValorEmpresaPagar = new javax.swing.JTextField();
        txtValorClienteReceber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtDataClienteReceber = new javax.swing.JFormattedTextField();
        txtDataEmpresaPagar = new javax.swing.JFormattedTextField();

        setClosable(true);
        setTitle("Cadastro de Pagamentos e Recebimentos");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Data.: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 44, 40, 20));

        jLabel4.setText("Cliente.:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, -1, 20));
        jPanel1.add(txtClienteReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 190, -1));

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 80, -1));

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });
        jPanel1.add(btGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 80, -1));

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 80, -1));

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 80, -1));

        tbBoletoClienteEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente a Receber", "Data a Receber", "Valor a Receber", "Empresa a Pagar", "Data a Pagar", "Valor a Pagar"
            }
        ));
        tbBoletoClienteEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBoletoClienteEmpresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBoletoClienteEmpresa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 154, 750, 330));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("## Pagamento a Receber ##");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));
        jPanel1.add(txtEmpresaPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 110, 170, -1));

        jLabel5.setText("Data.: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 114, 40, 20));

        jLabel6.setText("R$.:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 30, 30));
        jPanel1.add(txtValorEmpresaPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 60, -1));

        txtValorClienteReceber.setText(" ");
        txtValorClienteReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorClienteReceberActionPerformed(evt);
            }
        });
        jPanel1.add(txtValorClienteReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 60, -1));

        jLabel7.setText("Empresa .:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 114, 70, 20));

        jLabel8.setText("R$.:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 114, 30, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("## Pagamento a Pagar ##");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 750, 10));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 10, 140));

        try {
            txtDataClienteReceber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtDataClienteReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 80, -1));

        try {
            txtDataEmpresaPagar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtDataEmpresaPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void CentralizarJTextFields() {
        txtEmpresaPagar.setHorizontalAlignment(SwingConstants.CENTER);
        txtClienteReceber.setHorizontalAlignment(SwingConstants.CENTER);
        txtValorEmpresaPagar.setHorizontalAlignment(SwingConstants.CENTER);
        txtValorClienteReceber.setHorizontalAlignment(SwingConstants.CENTER);
        txtDataClienteReceber.setHorizontalAlignment(SwingConstants.CENTER);
        txtDataEmpresaPagar.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void tamanhoTabela() {
        //Defini o tamanho da tabela
        tbBoletoClienteEmpresa.getColumnModel().getColumn(0).setPreferredWidth(170);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(3).setPreferredWidth(90);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(4).setPreferredWidth(50);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    private void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tbBoletoClienteEmpresa.getModel();
        modelo.setNumRows(0);
        tamanhoTabela();
        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        // Aplicar o renderizador às colunas de valorpedido (índice 1) e quantidadebobina (índice 2)
        tbBoletoClienteEmpresa.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        try {

            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("SELECT * FROM boletoEmpresa ORDER BY databoletoreceber ASC;");
            rs = pstm.executeQuery();
            //Formatar o valor no campo jtable
            NumberFormat currencyReceber = NumberFormat.getCurrencyInstance();
            NumberFormat currencyApagar = NumberFormat.getCurrencyInstance();
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("nomeboletoreceber"),
                    rs.getString("databoletoreceber"),
                    currencyReceber.format(rs.getDouble("valorboletoreceber")),
                    rs.getString("nomeboletoapagar"),
                    rs.getString("databoletoapagar"),
                    currencyApagar.format(rs.getDouble("valorboletoapagar")),});
            }
            Conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR);
        }
    }

    private void limparTexto() {
        txtClienteReceber.setText("");
        txtEmpresaPagar.setText("");
        txtDataClienteReceber.setText("");
        txtDataEmpresaPagar.setText("");
        txtValorClienteReceber.setText("");
        txtValorEmpresaPagar.setText("");
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
        txtClienteReceber.setEnabled(false);
        txtEmpresaPagar.setEnabled(false);
        txtDataClienteReceber.setEnabled(false);
        txtDataEmpresaPagar.setEnabled(false);
        txtValorClienteReceber.setEnabled(false);
        txtValorEmpresaPagar.setEnabled(false);
    }

    private void ativaBotoes() {
        btGravar.setEnabled(true);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }

    private void ativaCampos() {
        txtClienteReceber.setEnabled(true);
        txtEmpresaPagar.setEnabled(true);
        txtDataClienteReceber.setEnabled(true);
        txtDataEmpresaPagar.setEnabled(true);
        txtValorClienteReceber.setEnabled(true);
        txtValorEmpresaPagar.setEnabled(true);
    }
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limparTexto();
        ativaBotoes();
        ativaCampos();
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        if (txtClienteReceber.getText().isEmpty() || txtEmpresaPagar.getText().isEmpty()
                || txtDataClienteReceber.getText().isEmpty() || txtDataEmpresaPagar.getText().isEmpty()
                || txtValorClienteReceber.getText().isEmpty() || txtValorEmpresaPagar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        BoletoEmpresa e = new BoletoEmpresa();
        BoletoEmpresaDao dao = new BoletoEmpresaDao();
        // Parte do pagamento do cliente
        e.setBoletoClienteReceber(txtClienteReceber.getText());
        e.setBoletoEmpresaPagar(txtEmpresaPagar.getText());
        // Entrada da Data cliente
        try {
            java.util.Date dataFormatada = sdfC.parse(txtDataClienteReceber.getText());
            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
            e.setDataClienteReceber(dataSQL);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Entrada da Data Empresa
        try {
            java.util.Date dataFormatada = sdfE.parse(txtDataEmpresaPagar.getText());
            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
            e.setDataEmpresaPagar(dataSQL);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /*OBTENDO O VALOR DE CLIENTE */
        String valorReceberClienteText = txtValorClienteReceber.getText();
        // Convertendo a String para double
        double valorReceberCliente = Double.parseDouble(valorReceberClienteText);
        // Definindo o valor convertido na propriedade
        e.setReceberClienteValor(valorReceberCliente);
        /*OBTENDO O VALOR DE EMPRESA */
        String valorPagarEmpresaText = txtValorEmpresaPagar.getText();
        // Convertendo a String para double
        double valorPagarEmpresa = Double.parseDouble(valorPagarEmpresaText);
        // Definindo o valor convertido na propriedade
        e.setPagarEmpresaValor(valorPagarEmpresa);
        // Adicionando o objeto ao banco de dados
        dao.adicionar(e);
        carregaTabela();
        desativaCampos();
        limparTexto();
    }//GEN-LAST:event_btGravarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed

        BoletoEmpresa e = new BoletoEmpresa();
        BoletoEmpresaDao dao = new BoletoEmpresaDao();

        int index = tbBoletoClienteEmpresa.getSelectedRow();
        e = dao.listarBoletoEmpresa().get(index);

        switch (JOptionPane.showConfirmDialog(null,
                " [--ALTERAÇÃO DE DADOS--] \n Dado Atual"
                + "\n Cliente:  " + e.getBoletoClienteReceber()
                + "\n Data à Receber: " + e.getDataClienteReceber()
                + "\n Valor à Receber R$: " + e.getReceberClienteValor()
                + "\n Empresa: " + e.getBoletoEmpresaPagar()
                + "\n Data à Pagar: " + e.getDataEmpresaPagar()
                + "\n Valor à Pagar R$: " + e.getPagarEmpresaValor()
                + "\n Será alterado"
                + "\n Cliente: " + txtClienteReceber.getText()
                + "\n Data à Receber: " + txtDataEmpresaPagar.getText()
                + "\n Valor à Pagar R$: " + txtValorClienteReceber.getText()
                + "\n Empresa: " + txtEmpresaPagar.getText()
                + "\n Data à Receber " + txtDataEmpresaPagar.getText()
                + "\n Valor à Pagar R$: " + txtValorEmpresaPagar.getText()
                + "\n Deseja realmente fazer alteração?",
                "Alteração de dados.  ", JOptionPane.YES_NO_OPTION)) {
            case 0:
                e.setBoletoClienteReceber(txtClienteReceber.getText());
                e.setBoletoEmpresaPagar(txtEmpresaPagar.getText());
                e.setReceberClienteValor(Double.parseDouble(txtValorEmpresaPagar.getText()));
                e.setPagarEmpresaValor(Double.parseDouble(txtValorEmpresaPagar.getText()));
                // Entrada da Data cliente
                try {
                    java.util.Date dataFormatada = sdfC.parse(txtDataClienteReceber.getText());
                    java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
                    e.setDataClienteReceber(dataSQL);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                // Entrada da Data Empresa
                try {
                    java.util.Date dataFormatada = sdfE.parse(txtDataEmpresaPagar.getText());
                    java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
                    e.setDataEmpresaPagar(dataSQL);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                dao.alterar(e);// faz alteração no banco de dados
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
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        BoletoEmpresa e = new BoletoEmpresa();
        BoletoEmpresaDao dao = new BoletoEmpresaDao();
        int index = tbBoletoClienteEmpresa.getSelectedRow();
        e = dao.listarBoletoEmpresa().get(index);
        e.setBoletoClienteReceber(txtClienteReceber.getText());
        e.setBoletoEmpresaPagar(txtEmpresaPagar.getText());
        // Entrada da Data cliente
        try {
            java.util.Date dataFormatada = sdfC.parse(txtDataClienteReceber.getText());
            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
            e.setDataClienteReceber(dataSQL);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        // Entrada da Data Empresa
        try {
            java.util.Date dataFormatada = sdfE.parse(txtDataEmpresaPagar.getText());
            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
            e.setDataEmpresaPagar(dataSQL);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        //OBTENDO O VALOR DE CLIENTE
        String valorReceberClienteText = txtValorClienteReceber.getText();
        // Convertendo a String para double
        double valorReceberCliente = Double.parseDouble(valorReceberClienteText);
        // Definindo o valor convertido na propriedade
        e.setReceberClienteValor(valorReceberCliente);
        //OBTENDO O VALOR DE EMPRESA
        String valorPagarEmpresaText = txtValorEmpresaPagar.getText();
        // Convertendo a String para double
        double valorPagarEmpresa = Double.parseDouble(valorPagarEmpresaText);
        // Definindo o valor convertido na propriedade
        e.setPagarEmpresaValor(valorPagarEmpresa);
        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir ? \n "
                + "Cliente:  " + e.getBoletoClienteReceber()
                + "\n Data: " + e.getDataClienteReceber()
                + "\n R$: " + e.getReceberClienteValor()
                + "\n Empresa: " + e.getBoletoEmpresaPagar()
                + "\n Data: " + e.getDataEmpresaPagar()
                + "\n R$: " + e.getPagarEmpresaValor()
                + " ", "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            case 0:
                dao.remover(e);
                carregaTabela();
                limparTexto();
                desativaBotoes();
                desativaCampos();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btExcluirActionPerformed
    private void tbBoletoClienteEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBoletoClienteEmpresaMouseClicked
        //Setando campos de texto com registros
        BoletoEmpresa e = new BoletoEmpresa();
        BoletoEmpresaDao dao = new BoletoEmpresaDao();
        int index = tbBoletoClienteEmpresa.getSelectedRow();
        e = dao.listarBoletoEmpresa().get(index);
        // Setando valores nos campos de texto
        txtValorClienteReceber.setText(Double.toString(e.getReceberClienteValor()));
        txtValorEmpresaPagar.setText(Double.toString(e.getPagarEmpresaValor()));
        txtClienteReceber.setText(e.getBoletoClienteReceber());
        txtEmpresaPagar.setText(e.getBoletoEmpresaPagar());
        /*  FORMATANDO A DATA */
        SimpleDateFormat sdfC = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfE = new SimpleDateFormat("dd-MM-yyyy");
        txtDataClienteReceber.setText(sdfC.format(e.getDataClienteReceber()));
        txtDataEmpresaPagar.setText(sdfE.format(e.getDataEmpresaPagar()));
        txtClienteReceber.setEnabled(true);
        txtEmpresaPagar.setEnabled(true);
        txtDataClienteReceber.setEnabled(true);
        txtDataEmpresaPagar.setEnabled(true);
        txtValorClienteReceber.setEnabled(true);
        txtValorEmpresaPagar.setEnabled(true);
        btGravar.setEnabled(false);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }//GEN-LAST:event_tbBoletoClienteEmpresaMouseClicked

    private void txtValorClienteReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorClienteReceberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorClienteReceberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbBoletoClienteEmpresa;
    private javax.swing.JTextField txtClienteReceber;
    private javax.swing.JFormattedTextField txtDataClienteReceber;
    private javax.swing.JFormattedTextField txtDataEmpresaPagar;
    private javax.swing.JTextField txtEmpresaPagar;
    private javax.swing.JTextField txtValorClienteReceber;
    private javax.swing.JTextField txtValorEmpresaPagar;
    // End of variables declaration//GEN-END:variables
}
