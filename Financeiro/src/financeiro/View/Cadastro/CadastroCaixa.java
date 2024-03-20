package financeiro.View.Cadastro;

import financeiro.DAO.CaixaDao;
import financeiro.conexao.Conexao;
import financeiro.model.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CadastroCaixa extends javax.swing.JInternalFrame {

    public CadastroCaixa() {
        initComponents();
        carregaTabela();
        CentralizarCampos();
        limparTexto();
        DesativaCampos();
        DesativarBotao();
        CentralizarTabela();
    }

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
        jSeparator2 = new javax.swing.JSeparator();
        btNovo = new javax.swing.JButton();
        lblSaldoAtual = new javax.swing.JLabel();
        lblSaldoAnterior = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Livro Caixa");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbFluxoCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Descrição", "Entrada", "Saída"
            }
        ));
        tbFluxoCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFluxoCaixaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFluxoCaixa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 700, 330));

        txtDescricao.setNextFocusableComponent(txtEntrada);
        jPanel1.add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 20, 130, -1));

        txtEntrada.setNextFocusableComponent(txtSaida);
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
        jPanel1.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 80, -1));

        jLabel4.setText("Saída.:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 104, -1, 20));

        btSaida.setText("Saída");
        btSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaidaActionPerformed(evt);
            }
        });
        jPanel1.add(btSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 80, -1));

        btEntrada.setText("Entrada");
        btEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntradaActionPerformed(evt);
            }
        });
        jPanel1.add(btEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 80, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 20, 140));

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 70, -1));

        lblSaldoAtual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSaldoAtual.setForeground(new java.awt.Color(0, 0, 204));
        lblSaldoAtual.setText("0.00");
        jPanel1.add(lblSaldoAtual, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 190, 20));

        lblSaldoAnterior.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSaldoAnterior.setText("0.00");
        jPanel1.add(lblSaldoAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 190, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  private int mesAnterior = -1; // Inicializa com um valor que não representa um mês válido

    private void carregaTabela() {
        tamanhoTabela();
        DefaultTableModel modelo = (DefaultTableModel) tbFluxoCaixa.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            double saldoAtual = 0;
            double saldoAnterior = 0;

            Calendar cal = Calendar.getInstance();
            int mesAtual = cal.get(Calendar.MONTH) + 1; //mês

            if (mesAtual != mesAnterior) {
                modelo.setNumRows(0); // Limpa a tabela se o mês mudou
                mesAnterior = mesAtual; // Atualiza o mês anterior
            }
            pstm = con.prepareStatement("SELECT id, datahora, descricao, entrada, saida FROM caixa WHERE EXTRACT(MONTH FROM datahora) = ? order by id DESC;");
            pstm.setInt(1, mesAtual);
            rs = pstm.executeQuery();

            NumberFormat currencyEntrada = NumberFormat.getCurrencyInstance();
            NumberFormat currencySaida = NumberFormat.getCurrencyInstance();
            modelo.setNumRows(0);

            while (rs.next()) {
                // Dentro do seu loop while
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dataHoraFormatada = dateFormat.format(rs.getTimestamp("datahora"));

                double entrada = rs.getDouble("entrada");
                double saida = rs.getDouble("saida");

                modelo.addRow(new Object[]{
                    dataHoraFormatada,
                    //rs.getString("dataHora"),
                    rs.getString("descricao"),
                    currencyEntrada.format(entrada),
                    currencySaida.format(saida),});

                // Atualiza os saldos dentro do loop
                saldoAnterior = saldoAtual;
                saldoAtual += (entrada - saida);
            }

            lblSaldoAtual.setText("Saldo atual " + NumberFormat.getCurrencyInstance().format(saldoAtual));
            lblSaldoAnterior.setText("Saldo anterior " + NumberFormat.getCurrencyInstance().format(saldoAnterior));

            Conexao.closeConnection(con, pstm, rs);

        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tamanhoTabela() {

        tbFluxoCaixa.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbFluxoCaixa.getColumnModel().getColumn(1).setPreferredWidth(150);
    }

    private void CentralizarCampos() {
        txtEntrada.setHorizontalAlignment(SwingConstants.CENTER);
        txtSaida.setHorizontalAlignment(SwingConstants.CENTER);
        txtDescricao.setHorizontalAlignment(SwingConstants.CENTER);
        lblSaldoAtual.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void CentralizarTabela() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        // Aplicar o renderizador às colunas de valorpedido (índice 1) e quantidadebobina (índice 2)
        tbFluxoCaixa.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

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
        btNovo.setEnabled(true);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
        txtDescricao.setEnabled(true);
        txtEntrada.setEnabled(true);
        txtSaida.setEnabled(true);
    }//GEN-LAST:event_tbFluxoCaixaMouseClicked

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

                double novaEntrada = Double.parseDouble(txtEntrada.getText().trim().replace(",", "."));
                double novaSaida = Double.parseDouble(txtSaida.getText().trim().replace(",", "."));

                // Define os novos valores
                l.setDescricao(txtDescricao.getText());
                l.setEntrada(novaEntrada);
                l.setSaida(novaSaida);
                dao.alterar(l);
                carregaTabela();
                DesativaCampos();
                btAlterar.setEnabled(false);
                btExcluir.setEnabled(false);
                //limpaCampo();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nenhuma alteração foi feita.",
                        "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
        btNovo.setEnabled(true);
        DesativaCampos();
    }//GEN-LAST:event_btAlterarActionPerformed
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
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
        btNovo.setEnabled(true);
        DesativaCampos();
    }//GEN-LAST:event_btExcluirActionPerformed
    private void btSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaidaActionPerformed
        Caixa l = new Caixa();
        CaixaDao dao = new CaixaDao();
        /*String saidaText = txtSaida.getText().trim().replace(",", ".");

        if (saidaText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um valor para saída.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;  // Encerra o método se o campo de entrada estiver vazio
        }*/
        l.setDescricao(txtDescricao.getText());
        l.setSaida(Double.parseDouble(txtSaida.getText().trim().replace(",", ".")));
        l.setEntrada(0.0); // Definindo a entrada como zero para saída
        dao.saida(l);
        carregaTabela();
        txtEntrada.setEnabled(false);
        btEntrada.setEnabled(false);
        txtDescricao.setEnabled(false);
        txtSaida.setEnabled(false);
        limparTexto();
    }//GEN-LAST:event_btSaidaActionPerformed
    private void btEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntradaActionPerformed
        Caixa l = new Caixa();
        CaixaDao dao = new CaixaDao();
        //String entradaText = txtEntrada.getText().trim().replace(",", ".");

        /*if (entradaText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, insira os dados de saída.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;  // Encerra o método se o campo de entrada estiver vazio
        }*/
        l.setDescricao(txtDescricao.getText());
        l.setEntrada(Double.parseDouble(txtEntrada.getText().trim().replace(",", ".")));
        l.setSaida(0.0); // Definindo a saída como zero para entrada
        txtSaida.setEnabled(false);
        txtEntrada.setEnabled(false);
        txtDescricao.setEnabled(false);
        btSaida.setEnabled(false);
        dao.entrada(l);
        limparTexto();
        carregaTabela();
    }//GEN-LAST:event_btEntradaActionPerformed
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        AtivarCampos();
        btEntrada.setEnabled(true);
        btSaida.setEnabled(true);
    }//GEN-LAST:event_btNovoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btEntrada;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSaida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblSaldoAnterior;
    private javax.swing.JLabel lblSaldoAtual;
    private javax.swing.JTable tbFluxoCaixa;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtSaida;
    // End of variables declaration//GEN-END:variables
}
