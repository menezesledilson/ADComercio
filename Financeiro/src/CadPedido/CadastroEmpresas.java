/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CadPedido;

import financeiro.DAO.EmpresaDao;
import financeiro.conexao.Conexao;
import financeiro.model.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ledilson
 */
public class CadastroEmpresas extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastroEmpresas
     */
    public CadastroEmpresas() {
        initComponents();
        carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
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

        jButton4.setText("Excluir");

        jLabel1.setText("Nome.:");

        jLabel2.setText("CNPJ.:");

        jLabel3.setText("Cel.:");

        tbCadEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "UF", "CNPJ", "Celular"
            }
        ));
        jScrollPane1.setViewportView(tbCadEmpresa);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        cbxUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", " " }));

        jLabel4.setText("UF.:");

        try {
            txtCel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxUf, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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
                                .addComponent(jButton4)))
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
                            .addComponent(jButton4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
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
 if( txtCliente.getText().isEmpty() || txtCnpj.getText().isEmpty()|| cbxUf.getSelectedItem() == null ||
         txtCel.getText().isEmpty()){JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }
        // Criar uma nova instância de BobinaC
        Empresa e = new Empresa();
        EmpresaDao dao = new EmpresaDao();

        e.setNome(txtCliente.getText());
        e.setCNPJ(txtCnpj.getText());
        e.setCelular(txtCel.getText());

        String UFSelecionada = cbxUf.getSelectedItem().toString();
        e.setUF(UFSelecionada);

        // Adicionar a nova bobina no banco de dados
        dao.adicionar(e);

        // Atualizar a tabela
        carregaTabela();
        // Limpar os campos de texto
        // limparTexto();

    }//GEN-LAST:event_btGravarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btNovoActionPerformed

    public void maskCelular() {

    }

    public void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tbCadEmpresa.getModel();

        modelo.setNumRows(0);

        //Defini o tamanho da tabela
        tbCadEmpresa.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbCadEmpresa.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbCadEmpresa.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbCadEmpresa.getColumnModel().getColumn(3).setPreferredWidth(100);

        try (Connection con = Conexao.getConnection();
                PreparedStatement pstm = con.prepareStatement("SELECT nome,cnpj,uf,celular FROM empresa ORDER BY nome ASC;");
                ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("nome"),
                     rs.getString("uf"),
                    rs.getString("cnpj"),
                    rs.getString("Celular")

                });
            }
            Conexao.closeConnection(con, pstm, rs);

        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JComboBox<String> cbxUf;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbCadEmpresa;
    private javax.swing.JFormattedTextField txtCel;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtCnpj;
    // End of variables declaration//GEN-END:variables
}
