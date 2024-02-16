package financeiro.View.Cadastro;

import financeiro.DAO.ControleVendedorDao;
import financeiro.conexao.Conexao;
import financeiro.model.ControleVendedor;
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

public class CadastroControleVenda extends javax.swing.JInternalFrame {

    public CadastroControleVenda() {
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
        jLabel1 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lblSoma = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbControleVendedor = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        bgGravar = new javax.swing.JButton();
        bgExcluir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Controle de vendas");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Cliente.:");

        txtCliente.setText(" ");

        jLabel3.setText("Valor.:");

        txtValor.setText(" ");

        lblSoma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSoma.setText("0.00");

        tbControleVendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Nome", "Valor", "Obs."
            }
        ));
        tbControleVendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbControleVendedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbControleVendedor);

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

        bgExcluir.setText("Excluir");
        bgExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgExcluirActionPerformed(evt);
            }
        });

        jLabel4.setText("Total.:");

        jLabel2.setText("Obs.:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addGap(18, 18, 18)
                        .addComponent(bgGravar)
                        .addGap(18, 18, 18)
                        .addComponent(bgExcluir)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSoma)))
                .addGap(0, 243, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(bgGravar)
                    .addComponent(bgExcluir)
                    .addComponent(jLabel2)
                    .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSoma)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
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

    public void habilitarBotao() {
        // bgGravar.setEnabled(true);
        bgExcluir.setEnabled(true);
    }

    public void desativarBotao() {
        bgGravar.setEnabled(false);
        bgExcluir.setEnabled(false);
    }

    public void desativarCampos() {
        txtCliente.setEnabled(false);
        txtValor.setEnabled(false);
        txtObs.setEnabled(false);
    }

    public void ativaCampos() {
        txtCliente.setEnabled(true);
        txtValor.setEnabled(true);
        txtObs.setEnabled(true);
    }

    public void limparCampo() {
        txtCliente.setText("");
        txtValor.setText("");
        txtObs.setText("");
    }

    private void CentralizarCampos() {
        txtCliente.setHorizontalAlignment(SwingConstants.CENTER);
        txtValor.setHorizontalAlignment(SwingConstants.CENTER);
        txtObs.setHorizontalAlignment(SwingConstants.CENTER);
    }
    private void bgGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgGravarActionPerformed
        // Verificar se os campos estão vazios
        if (txtCliente.getText().isEmpty() || txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos antes de gravar.", "Campos Vazios", JOptionPane.WARNING_MESSAGE);
            return; // Abortar a operação se houver campos vazios
        }

        // Criar uma nova instância
        ControleVendedor b = new ControleVendedor();
        ControleVendedorDao dao = new ControleVendedorDao();

        // Atualizar os dados da nova bobina
        b.setNomeVenda(txtCliente.getText());
        b.setObservacaoVenda(txtObs.getText());

        String entradaValor = txtValor.getText().trim().replace(",", ".");
        b.setValorVenda(Double.parseDouble(entradaValor));

        // Adicionar a nova bobina no banco de dados
        dao.adicionar(b);

        // Atualizar a tabela
        carregaTabela();
        desativarCampos();

    }//GEN-LAST:event_bgGravarActionPerformed

    private void tbControleVendedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbControleVendedorMouseClicked
        //Setando campos de texto com registros
        ControleVendedor b = new ControleVendedor();
        ControleVendedorDao dao = new ControleVendedorDao();

        int index = tbControleVendedor.getSelectedRow();
        b = dao.listarControleVendedor().get(index);

        txtCliente.setText(b.getNomeVenda());
        txtValor.setText(Double.toString(b.getValorVenda()));
        txtObs.setText(b.getObservacaoVenda());
        ativaCampos();
        bgExcluir.setEnabled(true);
        bgGravar.setEnabled(false);
    }//GEN-LAST:event_tbControleVendedorMouseClicked

    private void bgExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgExcluirActionPerformed
        //Objetos
        ControleVendedor b = new ControleVendedor();
        ControleVendedorDao dao = new ControleVendedorDao();

        int index = tbControleVendedor.getSelectedRow(); // retorna o numero da linha selecionada
        b = dao.listarControleVendedor().get(index);

        b.setNomeVenda(txtCliente.getText());
        b.setValorVenda(Double.parseDouble(txtValor.getText()));

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir o Pagamento ? \n "
                + "\n Nome:  " + b.getNomeVenda()
                + "\n R$: " + b.getValorVenda(), "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {

            case 0:
                dao.remover(b);
                carregaTabela();
                //   limparCampo();
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

    private int mesAnterior = -1;
    private int anoAnterior = -1;

    private void carregaTabela() {

        // Verifica se o mês atual é diferente do mês anteriormente carregado na tabela
        DefaultTableModel modelo = (DefaultTableModel) tbControleVendedor.getModel();
        modelo.setNumRows(0);

        //Defini o tamanho da tabela
        tbControleVendedor.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbControleVendedor.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbControleVendedor.getColumnModel().getColumn(2).setPreferredWidth(20);
        tbControleVendedor.getColumnModel().getColumn(3).setPreferredWidth(50);

        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbControleVendedor.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        tbControleVendedor.revalidate();
        tbControleVendedor.repaint();
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            // Consulta para obter a soma total da coluna Valor Pedido para o mês atual
            String sqlSomaTotalReal = "SELECT SUM(valorvenda) AS totalValor FROM controlevendedor WHERE EXTRACT(MONTH FROM CAST(datahoravenda AS DATE)) = ? AND EXTRACT(YEAR FROM CAST(datahoravenda AS DATE)) = ?";

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
                        // Formatar o número para exibir duas casas decimais e arredondar
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
                // Trate exceções SQL conforme necessário
                e.printStackTrace();
            }

            pstm = con.prepareStatement("SELECT id, datahoravenda, nomevenda, valorvenda, observacao FROM controlevendedor WHERE EXTRACT(MONTH FROM CAST(datahoravenda AS DATE)) = ? AND EXTRACT(YEAR FROM CAST(datahoravenda AS DATE)) = ? ORDER BY id DESC");
            pstm.setInt(1, mesAtual);
            pstm.setInt(2, anoAtual);
            rs = pstm.executeQuery();

            NumberFormat currencyValor = NumberFormat.getCurrencyInstance();

            while (rs.next()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dataHoraFormatada = dateFormat.format(rs.getTimestamp("datahoravenda"));

                modelo.addRow(new Object[]{
                    dataHoraFormatada,
                    // rs.getString("datahoravenda"),
                    rs.getString("nomevenda"),
                    currencyValor.format(rs.getDouble("valorvenda")),
                    rs.getString("observacao")
                });
            }
            Conexao.closeConnection(con, pstm, rs);

        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    /* private void carregaTabela() {


        DefaultTableModel modelo = (DefaultTableModel) tbControleVendedor.getModel();
        modelo.setNumRows(0);

        //Defini o tamanho da tabela
        tbControleVendedor.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbControleVendedor.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbControleVendedor.getColumnModel().getColumn(2).setPreferredWidth(20);
        tbControleVendedor.getColumnModel().getColumn(3).setPreferredWidth(50);

        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tbControleVendedor.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbControleVendedor.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbControleVendedor.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        tbControleVendedor.revalidate();
        tbControleVendedor.repaint();
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;




            // Consulta para obter a soma total da coluna Valor Pedido para o mês atual
            String sqlSomaTotalReal = "SELECT SUM(valorvenda) AS totalValor FROM controlevendedor WHERE EXTRACT(MONTH FROM CAST(datahoravenda AS DATE)) = ? AND EXTRACT(YEAR FROM CAST(datahoravenda AS DATE)) = ?";

            // Obtém o mês e o ano atuais
            Calendar cal = Calendar.getInstance();
            int mesAtual = cal.get(Calendar.MONTH) + 1; // Note que os meses em Java começam do zero
            int anoAtual = cal.get(Calendar.YEAR);

            try (PreparedStatement statementValor = con.prepareStatement(sqlSomaTotalReal)) {
                statementValor.setInt(1, mesAtual);
                statementValor.setInt(2, anoAtual);

                try (ResultSet resultadoValor = statementValor.executeQuery()) {
                    if (resultadoValor.next()) {
                        Double totalValor = resultadoValor.getDouble("totalValor");
                        // Formatar o número para exibir duas casas decimais e arredondar
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
                // Trate exceções SQL conforme necessário
                e.printStackTrace();
            }

            pstm = con.prepareStatement("SELECT * FROM controlevendedor;");
            rs = pstm.executeQuery();

            NumberFormat currencyValor = NumberFormat.getCurrencyInstance();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("datahoravenda"),
                    rs.getString("nomevenda"),
                    currencyValor.format(rs.getDouble("valorvenda")),
                    rs.getString("observacao")
                });
            }
            Conexao.closeConnection(con, pstm, rs);

        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bgExcluir;
    private javax.swing.JButton bgGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSoma;
    private javax.swing.JTable tbControleVendedor;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtObs;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
