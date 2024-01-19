package financeiro.gui;

import financeiro.DAO.AcessoDao;
import financeiro.conexao.Conexao;
import financeiro.model.Credencial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CadastroCredencial extends javax.swing.JInternalFrame {

    public CadastroCredencial() {
        initComponents();
        carregaTabela();
        CentralizarJTextFields();
        Desativar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        txtsenha = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSenhas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtlogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbPermissao = new javax.swing.JComboBox();
        btExcluir = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Acesso");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Usuário.:");

        jLabel2.setText("Senha.:");

        tbSenhas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuários", "Login", "Senha", "nivel Acesso"
            }
        ));
        tbSenhas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSenhasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSenhas);

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Login.:");

        cbPermissao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Comum" }));

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 432, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtlogin)
                            .addComponent(txtnome, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbPermissao, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btGravar)
                                .addGap(18, 18, 18)
                                .addComponent(btExcluir)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(btExcluir)
                        .addComponent(btGravar)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbPermissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
 public void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tbSenhas.getModel();
        modelo.setNumRows(0);

        //Defini o tamanho da tabela
        tbSenhas.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbSenhas.getColumnModel().getColumn(1).setPreferredWidth(5);
        tbSenhas.getColumnModel().getColumn(2).setPreferredWidth(5);
        tbSenhas.getColumnModel().getColumn(3).setPreferredWidth(5);

        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar o renderizador às colunas de valorpedido (índice 1) e quantidadebobina (índice 2)
        tbSenhas.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbSenhas.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbSenhas.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbSenhas.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("SELECT * FROM acesso ORDER BY  nome ASC;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("nome"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("permissao")
                });
            }
            Conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limparTexto() {
        txtnome.setText("");
        txtlogin.setText("");
        txtsenha.setText("");
    }

    private void CentralizarJTextFields() {
        txtnome.setHorizontalAlignment(SwingConstants.CENTER);
        txtlogin.setHorizontalAlignment(SwingConstants.CENTER);
        txtsenha.setHorizontalAlignment(SwingConstants.CENTER);
    }
    private void tbSenhasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSenhasMouseClicked

    }//GEN-LAST:event_tbSenhasMouseClicked
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limparTexto();
        habilitar();
    }//GEN-LAST:event_jButton1ActionPerformed
    public void Desativar() {
        txtnome.setEnabled(false);
        txtlogin.setEnabled(false);
        txtsenha.setEnabled(false);
        cbPermissao.setEnabled(false);
    }

    public void habilitar() {
        txtnome.setEnabled(true);
        txtlogin.setEnabled(true);
        txtsenha.setEnabled(true);
        cbPermissao.setEnabled(true);
    }
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        Credencial s = new Credencial();
        AcessoDao dao = new AcessoDao();

        int index = tbSenhas.getSelectedRow();
        if (index != -1) {
            s = dao.ListaCrendecial().get(index);
            // Atualiza os campos com os valores da credencial
            txtnome.setText(s.getNome());
            txtlogin.setText(s.getLogin());
            txtsenha.setText(s.getSenha());
            cbPermissao.setSelectedItem(s.getPermissao());
            switch (JOptionPane.showConfirmDialog(null, "Deseja excluir o Credencial ? \n "
                    + "\n Usuario: " + s.getNome()
                    + "\n Login:  " + s.getLogin()
                    + "\n Senha: " + s.getSenha()
                    + "\n Permissão: " + s.getPermissao(), "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                case 0:
                    dao.remover(s);
                    carregaTabela();
                    limparTexto();
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        Credencial s = new Credencial();
        AcessoDao dao = new AcessoDao();
        s.setNome(txtnome.getText());
        s.setLogin(txtlogin.getText());
        s.setSenha(txtsenha.getText());
        s.setPermissao((String) cbPermissao.getSelectedItem());
        dao.adicionar(s);
        carregaTabela();
        Desativar();
        limparTexto();
    }//GEN-LAST:event_btGravarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JComboBox cbPermissao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbSenhas;
    private javax.swing.JTextField txtlogin;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtsenha;
    // End of variables declaration//GEN-END:variables
}
