package financeiro.View.NotaServico;

import financeiro.DAO.EmissorNotaServicoDao;
import financeiro.conexao.Conexao;
import financeiro.model.NotaServico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class EmissorCalculoNF extends javax.swing.JInternalFrame {

    public EmissorCalculoNF() {
        initComponents();
        carregaTabela();
        CentralizarJTextFields();
        desativaBotoes();
        btExcluir.setEnabled(false);
        desativaCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbCalculoNF = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNotaServico = new javax.swing.JTable();
        txtTotalCargaFinal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFrete = new javax.swing.JTextField();
        txtComissao = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtImposto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lblComissao = new javax.swing.JLabel();
        lblFrete = new javax.swing.JLabel();
        lblImposto = new javax.swing.JLabel();
        txtForncedor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btHabilitar = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Emissão Nota Serviço Calculo");

        jbCalculoNF.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Carga Comissão.:");

        tbNotaServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fornecedor", "Carga Geral", "Frete", "Imposto", "Comissão", "Carga Frete", "Carga Imposto", "Valor a pagar"
            }
        ));
        tbNotaServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNotaServicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNotaServico);

        jLabel6.setText("Comissão.:");

        jLabel10.setText("Frete.:");

        jLabel11.setText(" Carga Frete.:");

        jLabel12.setText("Carga Imposto.:");

        jLabel13.setText("Imposto.:");

        jLabel14.setText("T.Carga.:");

        lblComissao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblComissao.setText("0.00");

        lblFrete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFrete.setText("0.00");

        lblImposto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblImposto.setText("0.00");

        jLabel3.setText("Cliente.:");

        btHabilitar.setText("Habilitar");
        btHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHabilitarActionPerformed(evt);
            }
        });

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jbCalculoNFLayout = new javax.swing.GroupLayout(jbCalculoNF);
        jbCalculoNF.setLayout(jbCalculoNFLayout);
        jbCalculoNFLayout.setHorizontalGroup(
            jbCalculoNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jbCalculoNFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jbCalculoNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jbCalculoNFLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtForncedor, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalCargaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFrete)
                        .addContainerGap(274, Short.MAX_VALUE))
                    .addGroup(jbCalculoNFLayout.createSequentialGroup()
                        .addGroup(jbCalculoNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jbCalculoNFLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtImposto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblImposto)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtComissao, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblComissao))
                            .addGroup(jbCalculoNFLayout.createSequentialGroup()
                                .addComponent(btHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
        );
        jbCalculoNFLayout.setVerticalGroup(
            jbCalculoNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jbCalculoNFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jbCalculoNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btHabilitar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jbCalculoNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btExcluir)
                        .addComponent(btGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(23, 23, 23)
                .addGroup(jbCalculoNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtForncedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotalCargaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFrete))
                .addGap(18, 18, 18)
                .addGroup(jbCalculoNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtImposto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImposto)
                    .addComponent(jLabel6)
                    .addComponent(txtComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComissao))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbCalculoNF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbCalculoNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void tamanhoTabela() {
        //Defini o tamanho da tabela
        tbNotaServico.getColumnModel().getColumn(0).setPreferredWidth(300);
        tbNotaServico.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbNotaServico.getColumnModel().getColumn(2).setPreferredWidth(130);
        tbNotaServico.getColumnModel().getColumn(3).setPreferredWidth(150);
        tbNotaServico.getColumnModel().getColumn(4).setPreferredWidth(150);
        tbNotaServico.getColumnModel().getColumn(5).setPreferredWidth(150);
        tbNotaServico.getColumnModel().getColumn(6).setPreferredWidth(150);
        tbNotaServico.getColumnModel().getColumn(7).setPreferredWidth(150);
    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbNotaServico.getModel();
        modelo.setNumRows(0);
        tamanhoTabela();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        // Aplicar o renderizador às colunas de valorpedido(índice 1) e quantidadebobina (índice 2)
        tbNotaServico.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbNotaServico.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbNotaServico.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbNotaServico.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tbNotaServico.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbNotaServico.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tbNotaServico.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("SELECT * FROM emissornotaservico ORDER BY clientefornecedor ASC;");
            rs = pstm.executeQuery();

            NumberFormat currencyFinalCarga = NumberFormat.getCurrencyInstance();
            NumberFormat currencyFrete = NumberFormat.getCurrencyInstance();
            NumberFormat currencyImposto = NumberFormat.getCurrencyInstance();
            NumberFormat currencyTotalComissao = NumberFormat.getCurrencyInstance();
            NumberFormat currencyTotalImpostoCarga = NumberFormat.getCurrencyInstance();
            NumberFormat currencyTotalFreteCarga = NumberFormat.getCurrencyInstance();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("clientefornecedor"),
                    currencyFinalCarga.format(rs.getDouble("totalfinalcarga")),
                    currencyFrete.format(rs.getDouble("frete")),
                    currencyImposto.format(rs.getDouble("imposto")),
                    currencyTotalComissao.format(rs.getDouble("comissao")),
                    currencyTotalFreteCarga.format(rs.getDouble("totalfretecarga")),
                    currencyTotalImpostoCarga.format(rs.getDouble("totalimpostocarga")),
                    currencyTotalComissao.format(rs.getDouble("totalcomissao")),});
            }
            Conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void CentralizarJTextFields() {
        txtForncedor.setHorizontalAlignment(SwingConstants.CENTER);
        txtImposto.setHorizontalAlignment(SwingConstants.CENTER);
        txtFrete.setHorizontalAlignment(SwingConstants.CENTER);
        txtTotalCargaFinal.setHorizontalAlignment(SwingConstants.CENTER);
        txtComissao.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void limparCampos() {
        txtForncedor.setText("");
        txtImposto.setText("");
        txtFrete.setText("");
        txtTotalCargaFinal.setText("");
        txtComissao.setText("");
    }

    private void ativaBotoes() {
        btGravar.setEnabled(true);
    }

    private void desativaBotoes() {
        btGravar.setEnabled(false);
    }

    private void desativaCampos() {
        txtForncedor.setEnabled(false);
        txtImposto.setEnabled(false);
        txtFrete.setEnabled(false);
        txtTotalCargaFinal.setEnabled(false);
        txtComissao.setEnabled(false);
    }

    private void ativaCampos() {
        txtForncedor.setEnabled(true);
        txtImposto.setEnabled(true);
        txtFrete.setEnabled(true);
        txtTotalCargaFinal.setEnabled(true);
        txtComissao.setEnabled(true);
    }
    private void tbNotaServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNotaServicoMouseClicked
        //Setando campos de texto com registros
        NotaServico a = new NotaServico();
        EmissorNotaServicoDao dao = new EmissorNotaServicoDao();
        int index = tbNotaServico.getSelectedRow();
        a = dao.listarNotaServico().get(index);
        txtForncedor.setText(a.getClienteFornecedor());
        txtTotalCargaFinal.setText(Double.toString(a.getTotalCargaFinal()));
        txtFrete.setText(Double.toString(a.getFrete()));
        txtImposto.setText(Double.toString(a.getImposto()));
        txtComissao.setText(Double.toString(a.getComissao()));
        btExcluir.setEnabled(true);
        btGravar.setEnabled(false);
    }//GEN-LAST:event_tbNotaServicoMouseClicked
    private void btHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHabilitarActionPerformed
        ativaBotoes();
        btExcluir.setEnabled(false);
        ativaCampos();
        limparCampos();
    }//GEN-LAST:event_btHabilitarActionPerformed
    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        if (txtForncedor.getText().isEmpty() || txtTotalCargaFinal.getText().isEmpty()
                || txtFrete.getText().isEmpty() || txtImposto.getText().isEmpty()
                || txtComissao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        NotaServico a = new NotaServico();
        EmissorNotaServicoDao dao = new EmissorNotaServicoDao();

        String valorCargaFinal = txtTotalCargaFinal.getText().trim().replace(",", ".");
        String valorFrete = txtFrete.getText().trim().replace(",", ".");
        String valorImposto = txtImposto.getText().trim().replace(",", ".");
        String valorComissao = txtComissao.getText().trim().replace(",", ".");
        try {
            a.setClienteFornecedor(txtForncedor.getText());
            a.setTotalCargaFinal(Double.parseDouble(valorCargaFinal));
            a.setFrete(Double.parseDouble(valorFrete));
            double totalCargaFinal = a.getTotalCargaFinal();
            double frete = a.getFrete();
            double totalFreteCarga = totalCargaFinal - frete;
            a.setTotalFrete(totalFreteCarga);
            DecimalFormat decimalFormatFreteCarga = new DecimalFormat("#.##");
            String resultadoFormatadoFreteCarga = String.format("%.2f", totalFreteCarga);
            lblFrete.setText(String.valueOf(resultadoFormatadoFreteCarga));
            a.setImposto(Double.parseDouble(valorImposto));
            double Imposto = a.getImposto();
            double totalFreteImposto = totalFreteCarga + Imposto;
            a.setTotalImposto(totalFreteImposto);
            DecimalFormat decimalFormatImposto = new DecimalFormat("#.##");
            String resultadoFormatadoImposto = String.format("%.2f", totalFreteImposto);
            lblImposto.setText(String.valueOf(resultadoFormatadoImposto));
            a.setComissao(Double.parseDouble(valorComissao));
            double Comissao = a.getComissao();
            double totalFreteComissao = totalFreteImposto - Comissao;
            a.setTotalComissao(totalFreteComissao);
            DecimalFormat decimalFormatComissao = new DecimalFormat("#.##");
            String resultadoFormatadoComissao = String.format("%.2f", totalFreteComissao);
            lblComissao.setText(String.valueOf(resultadoFormatadoComissao));
            dao.adicionarnf(a);
            desativaCampos();
            carregaTabela();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite valores numéricos válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btGravarActionPerformed
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        NotaServico a = new NotaServico();
        EmissorNotaServicoDao dao = new EmissorNotaServicoDao();

        int index = tbNotaServico.getSelectedRow();
        a = dao.listarNotaServico().get(index);
        a.setClienteFornecedor(txtForncedor.getText());
        a.setTotalCargaFinal(Double.parseDouble(txtTotalCargaFinal.getText()));
        a.setFrete(Double.parseDouble(txtFrete.getText()));
        a.setImposto(Double.parseDouble(txtImposto.getText()));
        a.setComissao(Double.parseDouble(txtComissao.getText()));
        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir os Dados ?"
                + "\n Fornecedor:  " + a.getClienteFornecedor()
                + "\n Carga Total: " + a.getTotalCargaFinal()
                + "\n Frete: " + a.getFrete()
                + "\n Imposto:" + a.getImposto()
                + "\n Comissao:  " + a.getComissao()
                + "\n Frete total " + a.getTotalFrete()
                + "\n Imposto total " + a.getTotalImposto()
                + "\n Comissão" + a.getComissao()
                + "\n Comissão total" + a.getTotalComissao(), "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            case 0:
                dao.remover(a);
                carregaTabela();
                desativaCampos();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btExcluirActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btHabilitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jbCalculoNF;
    private javax.swing.JLabel lblComissao;
    private javax.swing.JLabel lblFrete;
    private javax.swing.JLabel lblImposto;
    private javax.swing.JTable tbNotaServico;
    private javax.swing.JTextField txtComissao;
    private javax.swing.JTextField txtForncedor;
    private javax.swing.JTextField txtFrete;
    private javax.swing.JTextField txtImposto;
    private javax.swing.JTextField txtTotalCargaFinal;
    // End of variables declaration//GEN-END:variables
}
