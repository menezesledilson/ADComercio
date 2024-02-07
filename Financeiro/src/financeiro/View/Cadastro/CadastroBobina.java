package financeiro.View.Cadastro;

import financeiro.DAO.BobinaDao;
import financeiro.conexao.Conexao;
import financeiro.model.BobinaC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class CadastroBobina extends javax.swing.JInternalFrame {

    public CadastroBobina() {
        initComponents();

        CentralizarCampos();
        carregaTabela();
        //desativaBotoes();
        desativaCampos();
        CentralizarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCadBobinas = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Bobinas");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setText("Descrição.:");

        jLabel2.setText("Preço KG.:");

        tbCadBobinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Preço"
            }
        ));
        tbCadBobinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCadBobinasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCadBobinas);

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

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAlterar)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btNovo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btGravar)
                            .addComponent(jButton1))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btExcluir)
                            .addComponent(btAlterar))))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void CentralizarTabela() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        // Aplicar o renderizador às colunas de valorpedido (índice 1) e quantidadebobina (índice 2)
        tbCadBobinas.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

    }

    ;

    private void limparTexto() {
        txtDescricao.setText("");
        txtValor.setText("");
    }

    private void desativaBotoes() {
        btGravar.setEnabled(false);
        //  btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);

    }

    private void desativaCampos() {
        txtDescricao.setEnabled(false);
        txtValor.setEnabled(false);
    }

    private void ativaBotoes() {
        btGravar.setEnabled(true);
        //btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }

    private void ativaCampos() {
        txtDescricao.setEnabled(true);
        txtValor.setEnabled(true);
    }

    private void CentralizarCampos() {
        txtDescricao.setHorizontalAlignment(SwingConstants.CENTER);
        txtValor.setHorizontalAlignment(SwingConstants.CENTER);
    }
    private void tbCadBobinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCadBobinasMouseClicked

        //Setando campos de texto com registros
        BobinaC b = new BobinaC();
        BobinaDao dao = new BobinaDao();

        int index = tbCadBobinas.getSelectedRow();
        b = dao.listarBobinaC().get(index);

        txtDescricao.setText(b.getNomeBobina());
        txtValor.setText(Double.toString(b.getValorBobina()));

        btGravar.setEnabled(false);
        // btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
        ativaCampos();

    }//GEN-LAST:event_tbCadBobinasMouseClicked

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        ativaBotoes();

        //  ativaCampos();
        // btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);

        txtDescricao.setEnabled(true);
        txtValor.setEnabled(true);
        limparTexto();
    }//GEN-LAST:event_btNovoActionPerformed

    private void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tbCadBobinas.getModel();
        modelo.setNumRows(0);

        //Defini o tamanho da tabela
        tbCadBobinas.getColumnModel().getColumn(0).setPreferredWidth(350);
        tbCadBobinas.getColumnModel().getColumn(1).setPreferredWidth(20);

        try (Connection con = Conexao.getConnection();
                PreparedStatement pstm = con.prepareStatement("SELECT nomebobina, valorbobina FROM bobina ORDER BY nomebobina ASC;");
                ResultSet rs = pstm.executeQuery()) {

            NumberFormat currencyPreco = NumberFormat.getCurrencyInstance();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("nomebobina"),
                    //rs.getString(3),
                    currencyPreco.format(rs.getDouble("valorbobina"))
                });
            }
            Conexao.closeConnection(con, pstm, rs);

        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR);
        }
    }

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed

        // Verificar se os campos estão vazios
        if (txtDescricao.getText().isEmpty() || txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos antes de gravar.", "Campos Vazios", JOptionPane.WARNING_MESSAGE);
            return; // Abortar a operação se houver campos vazios
        }

        // Criar uma nova instância de BobinaC
        BobinaC b = new BobinaC();
        BobinaDao dao = new BobinaDao();

        // Atualizar os dados da nova bobina
        b.setNomeBobina(txtDescricao.getText());

        // Obter o valor como uma String do campo de texto
        String valorBobinaText = txtValor.getText();

        // Verificar se a conversão para double é válida
        try {
            // Convertendo a String para double
            double valorBobina = Double.parseDouble(valorBobinaText);

            // Definindo o valor convertido na propriedade
            b.setValorBobina(valorBobina);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido. Por favor, insira um valor numérico válido.", "Valor Inválido", JOptionPane.WARNING_MESSAGE);
            return; // Abortar a operação se o valor não for válido
        }

        // Adicionar a nova bobina no banco de dados
        dao.adicionar(b);

        // Atualizar a tabela
        carregaTabela();

        // Limpar os campos de texto
        limparTexto();
    }//GEN-LAST:event_btGravarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        //Objetos
        BobinaC b = new BobinaC();
        BobinaDao dao = new BobinaDao();

        int index = tbCadBobinas.getSelectedRow(); // retorna o numero da linha selecionada
        b = dao.listarBobinaC().get(index);

        b.setNomeBobina(txtDescricao.getText());
        b.setValorBobina(Double.parseDouble(txtValor.getText()));

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir o Produto ? \n "
                + "\n Produto:  " + b.getNomeBobina()
                + "\n R$: " + b.getValorBobina(), "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {

            case 0:
                dao.remover(b);
                carregaTabela();
                limparTexto();
                desativaBotoes();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;

        }

    }//GEN-LAST:event_btExcluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection con = Conexao.getConnection();
        //PreparedStatement pstm = null;
        try {
            String arq = "C:\\ADComercio\\Financeiro\\src\\Relatorios\\Mensal\\RelatorioBobina.jasper";
            Map<String, Object> parametros = new HashMap<>();

            JasperPrint jaspertPrint = JasperFillManager.fillReport(arq, parametros, con);
            JasperViewer view = new JasperViewer(jaspertPrint, false);
            view.setVisible(true);

        } catch (JRException ex) {
            System.out.println("Erro:" + ex);
        } finally {
            // Certifique-se de fechar a conexão
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        BobinaC b = new BobinaC();
        BobinaDao dao = new BobinaDao();

        int index = tbCadBobinas.getSelectedRow(); // retorna o numero da linha selecionada
        b = dao.listarBobinaC().get(index);

        switch (JOptionPane.showConfirmDialog(null,
                " [--ALTERAÇÃO DE DADOS--] \n Dado Atual"
                + "\n Produto:  " + b.getNomeBobina()
                + "\n R$: " + b.getValorBobina()
                + "\n Será alterado \n Produto: "
                + txtDescricao.getText()
                + "\n R$: "
                + txtValor.getText()
                + "\n Deseja realmente fazer alteração?",
                "Alteração de dados.  ", JOptionPane.YES_NO_OPTION)) {

            case 0:

                b.setNomeBobina(txtDescricao.getText());
                b.setValorBobina(Double.parseDouble(txtValor.getText()));

                dao.alterar(b);// faz alteração no banco de dados
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCadBobinas;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
