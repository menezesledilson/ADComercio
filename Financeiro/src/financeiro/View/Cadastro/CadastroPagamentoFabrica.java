package financeiro.View.Cadastro;

import financeiro.DAO.PagamentoFabricaDao;
import financeiro.conexao.Conexao;
import financeiro.model.PagamentoFabrica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CadastroPagamentoFabrica extends javax.swing.JInternalFrame {

    public CadastroPagamentoFabrica() {
        initComponents();
        carregaTabela();
        desativarCampos();
        CentralizarCampos();
        desativarBotao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        bgGravar = new javax.swing.JButton();
        bgExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lblSoma = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbAcertoFabrica = new javax.swing.JTable();
        txtObs = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Acerto a Fabrica");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        bgGravar.setText("Gravar");
        bgGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgGravarActionPerformed(evt);
            }
        });

        bgExcluir.setText(" Excluir");
        bgExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgExcluirActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome.:");

        jLabel2.setText("Valor.:");

        txtValor.setText(" ");

        lblSoma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSoma.setText("0.00");

        jLabel3.setText("Total.:");

        jLabel4.setText("Obs.:");

        TbAcertoFabrica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data hora", "Descrição", "Valor", "Obs."
            }
        ));
        TbAcertoFabrica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbAcertoFabricaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbAcertoFabrica);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSoma))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bgGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bgExcluir)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(bgGravar)
                    .addComponent(bgExcluir)
                    .addComponent(jLabel4)
                    .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSoma)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
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

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        bgGravar.setEnabled(true);
        ativaCampos();
        limparCampo();

    }//GEN-LAST:event_btNovoActionPerformed
    private void bgGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgGravarActionPerformed
        if (txtName.getText().isEmpty() || txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos antes de gravar.", "Campos Vazios", JOptionPane.WARNING_MESSAGE);
            return; // Abortar a operação se houver campos vazios
        }
        PagamentoFabrica b = new PagamentoFabrica();
        PagamentoFabricaDao dao = new PagamentoFabricaDao();
        b.setNomePagamento(txtName.getText());
        b.setObservacaoVenda(txtObs.getText());

        String entradaValor = txtValor.getText().trim().replace(",", ".");
        b.setValorPagamento(Double.parseDouble(entradaValor));

        dao.adicionar(b);
        carregaTabela();
        desativarCampos();

    }//GEN-LAST:event_bgGravarActionPerformed
    private void bgExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgExcluirActionPerformed
        PagamentoFabrica b = new PagamentoFabrica();
        PagamentoFabricaDao dao = new PagamentoFabricaDao();
        int index = TbAcertoFabrica.getSelectedRow();
        b = dao.listarPagFabrica().get(index);
        // b.setNomePagamento(txtNome.getText());
        b.setValorPagamento(Double.parseDouble(txtValor.getText()));
        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir o Pagamento ? \n "
                + "\n Nome:  " + b.getNomePagamento()
                + "\n R$: " + b.getValorPagamento(), "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            case 0:
                dao.remover(b);
                carregaTabela();
                bgGravar.setEnabled(false);
                btNovo.setEnabled(true);
                bgExcluir.setEnabled(true);
                desativarCampos();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_bgExcluirActionPerformed

    private void TbAcertoFabricaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAcertoFabricaMouseClicked

        PagamentoFabrica b = new PagamentoFabrica();
        PagamentoFabricaDao dao = new PagamentoFabricaDao();

        int index = TbAcertoFabrica.getSelectedRow();
        b = dao.listarPagFabrica().get(index);

        txtName.setText(b.getNomePagamento());
        txtValor.setText(Double.toString(b.getValorPagamento()));
        txtObs.setText(b.getObservacaoVenda());
        ativaCampos();
        bgExcluir.setEnabled(true);
        bgGravar.setEnabled(false);

    }//GEN-LAST:event_TbAcertoFabricaMouseClicked

    public void habilitarBotao() {
        bgGravar.setEnabled(true);
        bgExcluir.setEnabled(true);
    }

    public void desativarBotao() {
        bgGravar.setEnabled(false);
        bgExcluir.setEnabled(false);
    }

    public void desativarCampos() {
        txtObs.setEnabled(false);
        txtValor.setEnabled(false);
        txtName.setEnabled(false);
    }

    public void ativaCampos() {
        txtObs.setEnabled(true);
        txtValor.setEnabled(true);
        txtName.setEnabled(true);
    }

    public void limparCampo() {
        txtObs.setText("");
        txtValor.setText("");
        txtName.setText("");
    }

    private void CentralizarCampos() {
        //   txtNome.setHorizontalAlignment(SwingConstants.CENTER);
        txtValor.setHorizontalAlignment(SwingConstants.CENTER);
        txtName.setHorizontalAlignment(SwingConstants.CENTER);
    }
    private int mesAnterior = -1;
    private int anoAnterior = -1;

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) TbAcertoFabrica.getModel();
        modelo.setNumRows(0);
        //Defini o tamanho da tabela
        TbAcertoFabrica.getColumnModel().getColumn(0).setPreferredWidth(50);
        TbAcertoFabrica.getColumnModel().getColumn(1).setPreferredWidth(50);
        TbAcertoFabrica.getColumnModel().getColumn(2).setPreferredWidth(20);
        TbAcertoFabrica.getColumnModel().getColumn(3).setPreferredWidth(200);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TbAcertoFabrica.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        TbAcertoFabrica.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        TbAcertoFabrica.revalidate();
        TbAcertoFabrica.repaint();
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;
            // Consulta para obter a soma total da coluna Valor Pedido para o mês atual
            String sqlSomaTotalReal = "SELECT SUM(valorpagamento) AS totalValor FROM pagamentofabrica WHERE EXTRACT(MONTH FROM CAST(datahorapagamento AS DATE)) = ? AND EXTRACT(YEAR FROM CAST(datahorapagamento AS DATE)) = ?";
            // Obtém o mês e o ano atuais
            Calendar cal = Calendar.getInstance();
            int mesAtual = cal.get(Calendar.MONTH) + 1; // Note que os meses em Java começam do zero
            int anoAtual = cal.get(Calendar.YEAR);

            if (mesAtual != mesAnterior || anoAtual != anoAnterior) {
                modelo.setNumRows(0); // Limpa a tabela se o mês ou o ano mudaram
                mesAnterior = mesAtual; // Atualiza o mês anterior
                anoAnterior = anoAtual; // Atualiza o ano anterior
            }
            try (PreparedStatement statementValor = con.prepareStatement(sqlSomaTotalReal)) {
                statementValor.setInt(1, mesAtual);
                statementValor.setInt(2, anoAtual);

                try (ResultSet resultadoValor = statementValor.executeQuery()) {
                    if (resultadoValor.next()) {
                        Double totalValor = resultadoValor.getDouble("totalValor");
                        // Formata o valor para duas casas decimais
                        DecimalFormat df = new DecimalFormat("#,##0.00");
                        df.setMaximumFractionDigits(2);
                        df.setMinimumFractionDigits(2);
                        String formattedTotal = df.format(totalValor);
                        lblSoma.setText(String.valueOf(formattedTotal));
                    } else {
                        // Se não houver resultados, define o total como zero
                        lblSoma.setText("0.00");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            pstm = con.prepareStatement("SELECT id,datahorapagamento, nomepagamento,valorpagamento,observacao FROM  pagamentofabrica WHERE EXTRACT(MONTH FROM CAST(datahorapagamento AS DATE)) = ? AND EXTRACT(YEAR FROM CAST(datahorapagamento AS DATE)) = ? ORDER BY id DESC;");
            pstm.setInt(1, mesAtual);
            pstm.setInt(2, anoAtual);
            rs = pstm.executeQuery();

            NumberFormat currencyValor = NumberFormat.getCurrencyInstance();
            while (rs.next()) {
                // Dentro do seu loop while
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dataHoraFormatada = dateFormat.format(rs.getTimestamp("datahorapagamento"));
                modelo.addRow(new Object[]{
                    dataHoraFormatada,
                    rs.getString("nomepagamento"),
                    currencyValor.format(rs.getDouble("valorpagamento")),
                    rs.getString("observacao")
                });
            }
            Conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TbAcertoFabrica;
    private javax.swing.JButton bgExcluir;
    private javax.swing.JButton bgGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSoma;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtObs;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
