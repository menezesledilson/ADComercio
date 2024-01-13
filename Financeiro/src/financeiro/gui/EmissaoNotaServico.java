/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.gui;

import financeiro.model.NotaServicoCliente;
import financeiro.DAO.BobinaDao;
import financeiro.DAO.EmissorNotaServicoClienteDao;
import financeiro.DAO.EmpresaDao;
import financeiro.conexao.Conexao;
import financeiro.model.NotaServico;
import financeiro.model.NotaServicoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ledilson
 */
public class EmissaoNotaServico extends javax.swing.JInternalFrame {

    /**
     * Creates new form EmissaoNotaServico
     */
    public EmissaoNotaServico() {
        initComponents();
        carregaTabela();
        desativarBotao();
        desativarCampo();
        btGravaCliente.setEnabled(false);
        cbListProduto();
        cbListCliente();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btGravaCliente = new javax.swing.JButton();
        btAtivarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtQuant = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPesoUnitario = new javax.swing.JTextField();
        txtValorUnitario1 = new javax.swing.JLabel();
        cbxProduto = new javax.swing.JComboBox();
        lbCargaInicial = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        cbxCliente = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Pagamento Harolpel");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btGravaCliente.setText("Gravar Cliente");
        btGravaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravaClienteActionPerformed(evt);
            }
        });

        btAtivarCliente.setText("Novo");
        btAtivarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtivarClienteActionPerformed(evt);
            }
        });

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Empresa", "Quant.", "Produto", "Preço Unitário", "Peso", "Preço Carga "
            }
        ));
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbClientes);

        jLabel4.setText("Quant.:");

        jLabel1.setText("Cliente.:");

        jLabel3.setText("Produto.:");

        jLabel6.setText("Preço.:");

        jLabel5.setText("Peso.:");

        txtValorUnitario1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtValorUnitario1.setText("0.00");

        cbxProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        cbxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProdutoActionPerformed(evt);
            }
        });

        lbCargaInicial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCargaInicial.setText("0.00");

        jLabel2.setText("Total.:");

        btDelete.setText("Excluir");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(5, 5, 5)
                                                .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(btAtivarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(btGravaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(73, 73, 73)
                                                .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel3)
                                        .addGap(4, 4, 4)
                                        .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtValorUnitario1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPesoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbCargaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 166, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGravaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAtivarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtValorUnitario1)
                    .addComponent(jLabel5)
                    .addComponent(txtPesoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lbCargaInicial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private double AcumuloPesoPdido = 0.0;    //Comunicação com cbxBobina Adcionar

    ArrayList<Integer> idCadastroBobina = new ArrayList<Integer>();
    ArrayList<Double> valorUnitarioBobina1 = new ArrayList<Double>();

    public void cbListProduto() {

        // Limpar os dados antigos
        idCadastroBobina.clear();
        valorUnitarioBobina1.clear();

        cbxProduto.removeAllItems();
        try {

            BobinaDao dao = new BobinaDao();
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT * FROM bobina ORDER BY nomeBobina ASC;");
            rs = pstm.executeQuery();

            while (rs.next()) {
                idCadastroBobina.add(rs.getInt(1));
                cbxProduto.addItem(rs.getString(2));
                valorUnitarioBobina1.add(rs.getDouble(3));
            }

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbClientes.getModel();
        modelo.setNumRows(0);

        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar o renderizador às colunas de valorpedido (índice 1) e quantidadebobina (índice 2)
        tbClientes.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        // tbClientes.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbClientes.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbClientes.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbClientes.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tbClientes.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbClientes.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

        //Defini o tamanho da tabela
        tbClientes.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbClientes.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbClientes.getColumnModel().getColumn(2).setPreferredWidth(25);
        tbClientes.getColumnModel().getColumn(3).setPreferredWidth(150);
        tbClientes.getColumnModel().getColumn(4).setPreferredWidth(80);
        tbClientes.getColumnModel().getColumn(5).setPreferredWidth(60);

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT datanotaservico, clienteempresa, quantproduto,nomeproduto,valorunitario, valorpeso, cargainicial FROM emissornotacliente;");
            rs = pstm.executeQuery();

            //Formatar o valor no campo jtable
            NumberFormat currencyValorPeso = NumberFormat.getCurrencyInstance();
            NumberFormat currencyValorUnitario = NumberFormat.getCurrencyInstance();
            NumberFormat currencyValorCargaInicial = NumberFormat.getCurrencyInstance();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("datanotaservico"),
                    rs.getString("clienteempresa"),
                    rs.getString("quantproduto"),
                    rs.getString("nomeproduto"),
                    //rs.getString("valorunitario"),
                    currencyValorUnitario.format(rs.getDouble("valorunitario")),
                    // rs.getString("valorpeso")

                    currencyValorPeso.format(rs.getDouble("valorpeso")),
                    currencyValorCargaInicial.format(rs.getDouble("cargainicial")),});
            }
            Conexao.closeConnection(con, pstm, rs);

        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void limparCampos() {
        txtQuant.setText("");
        
        txtPesoUnitario.setText("");
        txtValorUnitario1.setText("");
    }

    public void desativarBotao() {
        //  btAlterar.setEnabled(false);
        btDelete.setEnabled(false);
    }

    public void ativarBotao() {
        //  btAlterar.setEnabled(true);
        btDelete.setEnabled(true);
    }

    public void ativarCampo() {

        txtQuant.setEnabled(true);
        cbxProduto.setEnabled(true);
        cbxCliente.setEnabled(true);
        txtPesoUnitario.setEnabled(true);
    }

    public void desativarCampo() {

        txtQuant.setEnabled(false);
        cbxProduto.setEnabled(false);
        cbxCliente.setEnabled(false);
        txtPesoUnitario.setEnabled(false);
    }

    private void btGravaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravaClienteActionPerformed
       if (txtQuant.getText().isEmpty() || txtPesoUnitario.getText().isEmpty() || 
               cbxCliente.getSelectedItem() == null || cbxProduto.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        NotaServicoCliente a = new NotaServicoCliente();
        EmissorNotaServicoClienteDao dao = new EmissorNotaServicoClienteDao();

        ativarBotao();

        try {
            String descricacaoCliente = cbxCliente.getSelectedItem().toString();

            a.setClienteEmpresa(descricacaoCliente);

            a.setQuantProduto(Integer.parseInt(txtQuant.getText()));

            //adição do produto
            //a.setNomeProduto(txtNomeProduto.getText());
            if (cbxProduto.getItemCount() > 0) {
                String descricaoSelecionada = cbxProduto.getSelectedItem().toString();
                a.setNomeProduto(descricaoSelecionada);
                a.setPesoUnitario(Double.parseDouble(txtPesoUnitario.getText()));
                a.setValorUnitario(Double.parseDouble(txtValorUnitario1.getText()));
                //  a.setValorUnitario(Double.parseDouble(txtValorUnitario.getText()));

                //Calculo do valor total
                double valorPedidoPeso = a.getValorUnitario() * a.getPesoUnitario();
                a.setCargaInicial(valorPedidoPeso);

                // Acumula o valor total
                AcumuloPesoPdido += valorPedidoPeso;

                // Formata o valor para exibir apenas duas casas decimais
                DecimalFormat df = new DecimalFormat("#.##");
                String valorFormatado = df.format(AcumuloPesoPdido);

                // Atualiza a soma
                lbCargaInicial.setText(String.valueOf(valorFormatado));

                a.setCargaInicial(valorPedidoPeso);

                dao.adicionar(a);
                carregaTabela();

                limparCampos();

                // Pergunta ao usuário se deseja adicionar mais um pedido
                int opcao = JOptionPane.showConfirmDialog(this, "Pedido adicionado com sucesso. Deseja adicionar mais um pedido?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    // O usuário escolheu adicionar mais um pedido, limpe os campos ou faça outras ações necessárias

                    //   limparCampos();
                } else {
                    // O usuário escolheu não adicionar mais um pedido, mantenha os campos preenchidos
                    // ou faça outras ações necessárias
                }
            } else {
                //JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
                JOptionPane.showMessageDialog(this, "Nenhum item disponível na lista de produtos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para quantidade, valor e peso.", "Erro", JOptionPane.ERROR_MESSAGE);
            // Ou logue a exceção para análise posterior
            e.printStackTrace();
        }   //JOptionPane.showMessageDialog(null, "Campos sem  informações: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btGravaClienteActionPerformed

    private void btAtivarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtivarClienteActionPerformed
        ativarCampo();
        btGravaCliente.setEnabled(true);
        //btAlterar.setEnabled(false);
        btDelete.setEnabled(false);
        carregaTabela();
    }//GEN-LAST:event_btAtivarClienteActionPerformed

    private void tbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientesMouseClicked

        //Setando campos de texto com registros
        NotaServicoCliente a = new NotaServicoCliente();
        EmissorNotaServicoClienteDao dao = new EmissorNotaServicoClienteDao();

        int index = tbClientes.getSelectedRow();
        a = dao.listarNotaServicoCliente().get(index);

        cbxCliente.setSelectedItem(a.getClienteEmpresa());
        cbxCliente.addItem(a.getClienteEmpresa());

        txtQuant.setText(String.valueOf(a.getQuantProduto()));
        txtPesoUnitario.setText(Double.toString(a.getPesoUnitario()));

        cbxCliente.setEnabled(true);
        txtQuant.setEnabled(true);
        cbxProduto.setEnabled(true);

        txtPesoUnitario.setEnabled(true);

        //  btAlterar.setEnabled(true);
        btDelete.setEnabled(true);
        btGravaCliente.setEnabled(false);
    }//GEN-LAST:event_tbClientesMouseClicked

    private void cbxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProdutoActionPerformed
        // Não use getStateChange() para eventos de ação, pois é específico de eventos de item
        int selectedIndex = cbxProduto.getSelectedIndex();

        if (selectedIndex >= 0 && selectedIndex < valorUnitarioBobina1.size()) {
            double valorSelecionado = valorUnitarioBobina1.get(selectedIndex);
            txtValorUnitario1.setText(String.valueOf(valorSelecionado));
        }
    }//GEN-LAST:event_cbxProdutoActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed

        //Objetos
        NotaServicoCliente a = new NotaServicoCliente();
        EmissorNotaServicoClienteDao dao = new EmissorNotaServicoClienteDao();

        int index = tbClientes.getSelectedRow(); // retorna o numero da linha selecionada

        a = dao.listarNotaServicoCliente().get(index);

        String descricaoCliente = cbxCliente.getSelectedItem().toString();
        a.setNomeProduto(descricaoCliente);

        a.setQuantProduto(Integer.parseInt(txtQuant.getText()));
        //  a.setPesoUnitario(Double.parseDouble(txtPesoUnitario.getText()));

        //seleção Produto
        String descricaoSelecionada = cbxProduto.getSelectedItem().toString();
        a.setNomeProduto(descricaoSelecionada);

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir o Produto ? \n "
                + "\n Produto:  " + a.getClienteEmpresa()
                + "\n Quantidadte: " + a.getQuantProduto()
                + "\n R$: " + a.getPesoUnitario(), "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {

            case 0:
                dao.removerCliente(a);
                carregaTabela();
                limparCampos();
                desativarBotao();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void cbxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClienteActionPerformed

    }//GEN-LAST:event_cbxClienteActionPerformed

    ArrayList<Integer> idCadastroEmpresa = new ArrayList<Integer>();
    ArrayList<String> nomeClienteEmpresa = new ArrayList<String>();

    public void cbListCliente() {
        // Limpar os dados antigos
        nomeClienteEmpresa.clear();
        cbxCliente.removeAllItems();

        try {

            EmpresaDao dao = new EmpresaDao();
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT * FROM empresa ORDER BY nome ASC;");
            rs = pstm.executeQuery();

            while (rs.next()) {
                idCadastroBobina.add(rs.getInt(1));
                cbxCliente.addItem(rs.getString(2));
            }

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtivarCliente;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btGravaCliente;
    private javax.swing.JComboBox<String> cbxCliente;
    private javax.swing.JComboBox cbxProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCargaInicial;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTextField txtPesoUnitario;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JLabel txtValorUnitario1;
    // End of variables declaration//GEN-END:variables
}
