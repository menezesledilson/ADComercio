package financeiro.View.Cadastro;

import financeiro.DAO.BoletoEmpresaDao;
import financeiro.conexao.Conexao;
import financeiro.model.BoletoEmpresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CadastroBoleto extends javax.swing.JInternalFrame {

    //Conversão de data
    private final SimpleDateFormat sdfC = new SimpleDateFormat("dd-MM-yyyy");
    private final SimpleDateFormat sdfE = new SimpleDateFormat("dd-MM-yyyy");

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
        txtDataClienteReceber = new javax.swing.JFormattedTextField();
        txtDataEmpresaPagar = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNF = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Cadastro de Pagamentos e Recebimentos");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Data.: ");

        jLabel4.setText("Cliente.:");

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        tbBoletoClienteEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente a Receber", "Data a Receber", "Valor a Receber", "Empresa a Pagar", "Data a Pagar", "Valor a Pagar", "Status", "NF", "Obs."
            }
        ));
        tbBoletoClienteEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBoletoClienteEmpresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBoletoClienteEmpresa);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("## Pagamento a Receber ##");

        jLabel5.setText("Data.: ");

        jLabel6.setText("R$.:");

        txtValorClienteReceber.setText(" ");
        txtValorClienteReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorClienteReceberActionPerformed(evt);
            }
        });

        jLabel7.setText("Empresa .:");

        jLabel8.setText("R$.:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("## Pagamento a Pagar ##");

        try {
            txtDataClienteReceber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataEmpresaPagar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Status.:");

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Aguardando Pagamento", "Atrasado", "Cancelado", "Concluído", "Devolvido", "Em Andamento", "Em Análise", "Em Espera", "Em Processo", "Pendente", "Recusado" }));

        jLabel10.setText("Obs.:");

        jLabel11.setText("Nª NF");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmpresaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(2, 2, 2)
                        .addComponent(txtDataEmpresaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(9, 268, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDataClienteReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtClienteReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorClienteReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btGravar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorEmpresaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNF, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btNovo)
                            .addComponent(btGravar))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtClienteReceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDataClienteReceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorClienteReceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtEmpresaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDataEmpresaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btAlterar)
                                    .addComponent(btExcluir)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValorEmpresaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtValorClienteReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorClienteReceberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorClienteReceberActionPerformed

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
        String descricaoStatus = cbxStatus.getSelectedItem().toString();
        e.setStatus(descricaoStatus);
        txtNF.setText(e.getNumeroNota());
        txtObs.setText(e.getObservacao());

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
        txtNF.setEnabled(true);
        cbxStatus.setEnabled(true);
        txtObs.setEnabled(true);

        btGravar.setEnabled(false);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }//GEN-LAST:event_tbBoletoClienteEmpresaMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        BoletoEmpresa e = new BoletoEmpresa();
        BoletoEmpresaDao dao = new BoletoEmpresaDao();
        int index = tbBoletoClienteEmpresa.getSelectedRow();
        e = dao.listarBoletoEmpresa().get(index);
        e.setBoletoClienteReceber(txtClienteReceber.getText());
        e.setBoletoEmpresaPagar(txtEmpresaPagar.getText());
        String descricaoStatus = cbxStatus.getSelectedItem().toString();
        e.setStatus(descricaoStatus);
        e.setObservacao(txtObs.getText());
        e.setNumeroNota(txtNF.getText());
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
                + "\n Status: " + e.getStatus()
                + "\n Nª nota: " + e.getNumeroNota()
                + "\n Obs: " + e.getObservacao()
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
                + "\n Nª nota : " + e.getNumeroNota()
                + "\n Status: " + e.getStatus()
                + "\n Nª nota: " + e.getNumeroNota()
                + "\n Obs: " + e.getObservacao()
                + "\n Será alterado"
                + "\n Cliente: " + txtClienteReceber.getText()
                + "\n Data à Receber: " + txtDataEmpresaPagar.getText()
                + "\n Valor à Pagar R$: " + txtValorClienteReceber.getText()
                + "\n Empresa: " + txtEmpresaPagar.getText()
                + "\n Data à Receber " + txtDataEmpresaPagar.getText()
                + "\n Valor à Pagar R$: " + txtValorEmpresaPagar.getText()
                + "\n Status" + cbxStatus.getSelectedItem()
                + "\n Nª nota : " + txtNF.getText()
                + "\n Obs: " + txtObs.getText()
                + "\n Deseja realmente fazer alteração?",
                "Alteração de dados.  ", JOptionPane.YES_NO_OPTION)) {
            case 0:
                e.setBoletoClienteReceber(txtClienteReceber.getText());
                e.setBoletoEmpresaPagar(txtEmpresaPagar.getText());

                String valorReceberClienteText = txtValorClienteReceber.getText().trim().replace(",", ".");

                String valorEmpresaText = txtValorEmpresaPagar.getText().trim().replace(",", ".");

                e.setReceberClienteValor(Double.parseDouble(valorReceberClienteText));
                e.setPagarEmpresaValor(Double.parseDouble(valorEmpresaText));

                String descricacaoStatus = cbxStatus.getSelectedItem().toString();
                e.setStatus(descricacaoStatus);
                e.setNumeroNota(txtNF.getText());
                e.setObservacao(txtObs.getText());

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

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        if (txtClienteReceber.getText().isEmpty() || txtEmpresaPagar.getText().isEmpty()
                || txtDataClienteReceber.getText().isEmpty() || cbxStatus.getSelectedItem() == null || txtDataEmpresaPagar.getText().isEmpty()
                || txtValorClienteReceber.getText().isEmpty()||txtNF.getText().isEmpty() || txtValorEmpresaPagar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        BoletoEmpresa e = new BoletoEmpresa();
        BoletoEmpresaDao dao = new BoletoEmpresaDao();

        // Parte do pagamento do cliente
        e.setBoletoClienteReceber(txtClienteReceber.getText());
        e.setBoletoEmpresaPagar(txtEmpresaPagar.getText());
        e.setNumeroNota(txtNF.getText().trim());
        e.setObservacao(txtObs.getText());
        String statusSelecionada = cbxStatus.getSelectedItem().toString();
        e.setStatus(statusSelecionada);

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
        String valorReceberClienteText = txtValorClienteReceber.getText().trim().replace(",", ".");
        // Convertendo a String para double
        double valorReceberCliente = Double.parseDouble(valorReceberClienteText);
        // Definindo o valor convertido na propriedade
        e.setReceberClienteValor(valorReceberCliente);
        /*OBTENDO O VALOR DE EMPRESA */
        String valorPagarEmpresaText = txtValorEmpresaPagar.getText().trim().replace(",", ".");
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

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limparTexto();
        ativaBotoes();
        ativaCampos();
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed
    private void CentralizarJTextFields() {
        txtEmpresaPagar.setHorizontalAlignment(SwingConstants.CENTER);
        txtClienteReceber.setHorizontalAlignment(SwingConstants.CENTER);
        txtValorEmpresaPagar.setHorizontalAlignment(SwingConstants.CENTER);
        txtValorClienteReceber.setHorizontalAlignment(SwingConstants.CENTER);
        txtDataClienteReceber.setHorizontalAlignment(SwingConstants.CENTER);
        txtDataEmpresaPagar.setHorizontalAlignment(SwingConstants.CENTER);
        txtNF.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void tamanhoTabela() {
        //Defini o tamanho da tabela
        tbBoletoClienteEmpresa.getColumnModel().getColumn(0).setPreferredWidth(170);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(3).setPreferredWidth(90);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(4).setPreferredWidth(50);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(5).setPreferredWidth(50);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(6).setPreferredWidth(50);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(7).setPreferredWidth(50);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(8).setPreferredWidth(50);

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
        tbBoletoClienteEmpresa.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        tbBoletoClienteEmpresa.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);

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

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dataFormatadaReceber = dateFormat.format(rs.getDate("databoletoreceber"));
                String dataFormatadaPagar = dateFormat.format(rs.getDate("databoletoapagar"));

                modelo.addRow(new Object[]{
                    rs.getString("nomeboletoreceber"),
                    dataFormatadaReceber,
                    currencyReceber.format(rs.getDouble("valorboletoreceber")),
                    rs.getString("nomeboletoapagar"),
                    dataFormatadaPagar,
                    currencyApagar.format(rs.getDouble("valorboletoapagar")),
                    rs.getString("statuspago"),
                    rs.getString("numeronota"),
                    rs.getString("observacao"),});
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
        txtNF.setText("");
        txtObs.setText("");
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
        txtNF.setEnabled(false);
        txtObs.setEnabled(false);
        cbxStatus.setEnabled(false);
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
        txtObs.setEnabled(true);
        txtNF.setEnabled(true);
        cbxStatus.setEnabled(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable tbBoletoClienteEmpresa;
    private javax.swing.JTextField txtClienteReceber;
    private javax.swing.JFormattedTextField txtDataClienteReceber;
    private javax.swing.JFormattedTextField txtDataEmpresaPagar;
    private javax.swing.JTextField txtEmpresaPagar;
    private javax.swing.JTextField txtNF;
    private javax.swing.JTextField txtObs;
    private javax.swing.JTextField txtValorClienteReceber;
    private javax.swing.JTextField txtValorEmpresaPagar;
    // End of variables declaration//GEN-END:variables
}
