 
package CadPedido;

import financeiro.DAO.EmpresaDao;
import financeiro.DAO.NotaCheiaDao;
import financeiro.conexao.Conexao;
import financeiro.model.Empresa;
import financeiro.model.NotaCheia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ledilson
 */
public class CadastroEmpresas extends javax.swing.JInternalFrame {
  
    public CadastroEmpresas() {
        initComponents();
        carregaTabela();
        desativaCampos();
        CentralizarCampos();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCadEmpresa = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        cbxUf = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtCel = new javax.swing.JFormattedTextField();
        txtCnpj = new javax.swing.JFormattedTextField();
        txtObs = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Cadastro Empresa");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

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

        txtCliente.setNextFocusableComponent(cbxUf);

        jLabel1.setText("Nome.:");

        jLabel2.setText("CNPJ.:");

        jLabel3.setText("Cel.:");

        tbCadEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cidade", "UF", "CNPJ", "Celular", "Obs"
            }
        ));
        tbCadEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCadEmpresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCadEmpresa);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        cbxUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UF", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", " " }));
        cbxUf.setNextFocusableComponent(txtCnpj);

        jLabel4.setText("UF.:");

        try {
            txtCel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCel.setNextFocusableComponent(txtObs);

        try {
            txtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCnpj.setNextFocusableComponent(txtCel);

        txtObs.setText(" ");
        txtObs.setNextFocusableComponent(btGravar);

        jLabel5.setText("Obs.:");

        jLabel6.setText("Cidade.:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCnpj))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxUf, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCidade)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btGravar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(btExcluir)))
                        .addGap(73, 73, 73))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btNovo)
                            .addComponent(btGravar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAlterar)
                            .addComponent(btExcluir)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jSeparator2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        // Verificar se os campos estão vazios
        if (txtCliente.getText().isEmpty() || txtCidade.getText().isEmpty() || txtCnpj.getText().isEmpty() || cbxUf.getSelectedItem() == null
                || txtCel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Criar uma nova instância de BobinaC
        Empresa e = new Empresa();
        EmpresaDao dao = new EmpresaDao();

        e.setNome(txtCliente.getText());
        e.setCidade(txtCidade.getText());
        e.setCNPJ(txtCnpj.getText());
        e.setCelular(txtCel.getText());
        e.setObservacao(txtObs.getText());
        String UFSelecionada = cbxUf.getSelectedItem().toString();
        e.setUF(UFSelecionada);

        // Adicionar a nova bobina no banco de dados
        dao.adicionar(e);
        // Atualizar a tabela
        carregaTabela();
        // Limpar os campos de texto
        limparCampos();

    }//GEN-LAST:event_btGravarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        ativaBotoes();
        ativaCampos();
        // btAlterar.setEnabled(false);
        limparCampos();
        btExcluir.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        Empresa a = new Empresa();
        EmpresaDao dao = new EmpresaDao();

        int index = tbCadEmpresa.getSelectedRow();
        a = dao.listarEmpresa().get(index);

        switch (JOptionPane.showConfirmDialog(null,
                " [--ALTERAÇÃO DE DADOS--] \n Dado Atual"
                + "\n Empresa:  " + a.getNome()
                + "\n Cidade: " + a.getCidade()
                + "\n UF: " + a.getUF()
                + "\n CNPJ: " + a.getCNPJ()
                + "\n Cel: " + a.getCelular()
                + "\n Obs: " + a.getObservacao()
                + "\n Será alterado "
                + "\n Empresa:  " + txtCliente.getText()
                + "\n Cidade:  " + txtCidade.getText()
                + "\n UF" + cbxUf.getSelectedItem()
                + "\n CNPJ: " + txtCnpj.getText()
                + "\n Cel: " + txtCel.getText()
                + "\n Obs: " + txtObs.getText()
                + "\n Deseja realmente fazer alteração?",
                "Alteração de dados.  ", JOptionPane.YES_NO_OPTION)) {

            case 0:
                String descricacaoUf = cbxUf.getSelectedItem().toString();
                a.setUF(descricacaoUf);
                a.setNome(txtCliente.getText());
                a.setCidade(txtCidade.getText());
                a.setCNPJ(txtCnpj.getText());
                a.setCelular(txtCel.getText());
                a.setObservacao(txtObs.getText());

                dao.alterar(a);// faz alteração no banco de dados
                carregaTabela();
                limparCampos();
                desativaBotoes();
                desativaCampos();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nenhuma alteração foi feita.",
                        "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void tbCadEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCadEmpresaMouseClicked
        Empresa a = new Empresa();
        EmpresaDao dao = new EmpresaDao();

        int index = tbCadEmpresa.getSelectedRow();
        a = dao.listarEmpresa().get(index);

        txtCliente.setText(a.getNome());
        String descricaoUf = cbxUf.getSelectedItem().toString();
        a.setUF(descricaoUf);
        txtCidade.setText(a.getCidade());
        txtCnpj.setText(a.getCNPJ());
        txtCel.setText(a.getCelular());
        txtObs.setText(a.getObservacao());
        btGravar.setEnabled(false);
        // btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
        ativaCampos();
    }//GEN-LAST:event_tbCadEmpresaMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // Criar uma nova instância de BobinaC
        Empresa a = new Empresa();
        EmpresaDao dao = new EmpresaDao();

        int index = tbCadEmpresa.getSelectedRow();
        a = dao.listarEmpresa().get(index);
        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir o Produto ? \n "
                + "\n Empresa:  " + a.getNome()
                + "\n Cidade: " + a.getCidade()
                + "\n UF: " + a.getUF()
                + "\n CNPJ: " + a.getCNPJ()
                + "\n Cel: " + a.getCelular()
                + "\n Obs: " + a.getObservacao(),
                "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            case 0:
                dao.remover(a);
                carregaTabela();
                limparCampos();
                desativaBotoes();
                desativaCampos();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbCadEmpresa.getModel();
        modelo.setNumRows(0);
        //Defini o tamanho da tabela
        tbCadEmpresa.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbCadEmpresa.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbCadEmpresa.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbCadEmpresa.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbCadEmpresa.getColumnModel().getColumn(4).setPreferredWidth(100);

        try (Connection con = Conexao.getConnection();
                PreparedStatement pstm = con.prepareStatement("SELECT nome,cnpj,cidade,uf,celular FROM empresa ORDER BY nome ASC;");
                ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("nome"),
                    rs.getString("cidade"),
                    rs.getString("uf"),
                    rs.getString("cnpj"),
                    rs.getString("Celular")
                });
            }
            Conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limparCampos() {
        txtCliente.setText("");
        txtCnpj.setText("");
        txtCel.setText("");
        txtObs.setText("");
        txtCidade.setText("");
    }
    private void ativaBotoes() {
        btGravar.setEnabled(true);
        //btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }
    private void desativaBotoes() {
        btGravar.setEnabled(false);
        //  btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }
    private void desativaCampos() {
        txtCliente.setEnabled(false);
        txtCnpj.setEnabled(false);
        txtCel.setEnabled(false);
        txtObs.setEnabled(false);
        cbxUf.setEnabled(false);
        txtCidade.setEnabled(false);
    }
    private void ativaCampos() {
        txtCliente.setEnabled(true);
        txtCnpj.setEnabled(true);
        txtCel.setEnabled(true);
        txtObs.setEnabled(true);
        cbxUf.setEnabled(true);
        txtCidade.setEnabled(true);
    }
    private void CentralizarCampos() {
        txtCliente.setHorizontalAlignment(SwingConstants.CENTER);
        txtCnpj.setHorizontalAlignment(SwingConstants.CENTER);
        txtCidade.setHorizontalAlignment(SwingConstants.CENTER);
        txtCel.setHorizontalAlignment(SwingConstants.CENTER);
        txtObs.setHorizontalAlignment(SwingConstants.CENTER);
        txtCidade.setHorizontalAlignment(SwingConstants.CENTER);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JComboBox<String> cbxUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbCadEmpresa;
    private javax.swing.JFormattedTextField txtCel;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtCnpj;
    private javax.swing.JTextField txtObs;
    // End of variables declaration//GEN-END:variables
}
