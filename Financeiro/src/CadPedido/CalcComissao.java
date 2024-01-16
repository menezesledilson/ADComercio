/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CadPedido;

import financeiro.DAO.ComissaoDao;
import financeiro.DAO.EmpresaDao;
import financeiro.conexao.Conexao;
import financeiro.model.ComissaoPagamento;
import financeiro.model.NotaBaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
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
public class CalcComissao extends javax.swing.JInternalFrame {

    //Conversão de data
    private final SimpleDateFormat sdfPedido = new SimpleDateFormat("dd-MM-yyyy");
    private final SimpleDateFormat sdfEntrega = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Creates new form CalcComissao
     */
    public CalcComissao() {
        initComponents();

        cbListCliente();
        carregaTabela();
        desativaCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtCheia = new javax.swing.JTextField();
        txtFabrica = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbComissao = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPedido = new javax.swing.JFormattedTextField();
        txtEntrega = new javax.swing.JFormattedTextField();
        txtEmpresa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lbTotalComissao = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Comissão");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Pedido nota cheia.:");

        jLabel2.setText("Pedido nota Fabrica.:");

        cbxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente.:");

        tbComissao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Empresa", "Data Pedido", "Data Entrega", "Preço Nota Cheia", "Preço Pag", "Comissão"
            }
        ));
        tbComissao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbComissaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbComissao);

        jLabel4.setText("Data Pedido.:");

        jLabel5.setText("Data Entrega.:");

        try {
            txtPedido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Empresa.:");

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

        jLabel7.setText("Comissão.:");

        lbTotalComissao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTotalComissao.setText("0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPedido))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCheia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEntrega))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtFabrica, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbTotalComissao))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btNovo)
                                .addGap(18, 18, 18)
                                .addComponent(btGravar)
                                .addGap(18, 18, 18)
                                .addComponent(btAlterar)))
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGravar)
                    .addComponent(btExcluir)
                    .addComponent(btNovo)
                    .addComponent(btAlterar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCheia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtFabrica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(lbTotalComissao))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                // idCadastroBobina.add(rs.getInt(1));
                cbxCliente.addItem(rs.getString(2));
            }

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        ativaBotoes();
        ativaCampos();
        // btAlterar.setEnabled(false);
        limparCampos();
        btExcluir.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        if (txtEmpresa.getText().isEmpty() || cbxCliente.getSelectedItem() == null
                || txtPedido.getText().isEmpty() || txtEntrega.getText().isEmpty()
                || txtCheia.getText().isEmpty() || txtFabrica.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ComissaoPagamento a = new ComissaoPagamento();
        ComissaoDao dao = new ComissaoDao();

        String descricacaoCliente = cbxCliente.getSelectedItem().toString();
        a.setNome(descricacaoCliente);

        a.setEmpresa(txtEmpresa.getText());

        // Entrada da Data cliente
        try {
            java.util.Date dataFormatada = sdfPedido.parse(txtPedido.getText());
            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
            a.setDataPedido(dataSQL);
        } catch (ParseException ex) {
            // Logger.getLogger(CadastroBoleto.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Impede a continuação do método se a data estiver incorreta
        }
        // Entrada da Data Empresa
        try {
            java.util.Date dataFormatada = sdfEntrega.parse(txtEntrega.getText());

            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());

            a.setDataEntrega(dataSQL);

        } catch (ParseException ex) {

            // Logger.getLogger(CadastroBoleto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Impede a continuação do método se a data estiver incorreta
        }
        a.setPrecoCheia(Double.parseDouble(txtCheia.getText()));
        a.setPrecoFabrica(Double.parseDouble(txtFabrica.getText()));

        double totalComissao = a.getPrecoCheia() - a.getPrecoFabrica();

        a.setValorComissao(totalComissao);

        // Formata o valor para exibir apenas duas casas decimais
        DecimalFormat df = new DecimalFormat("#.##");
        String valorFormatado = df.format(totalComissao);

        // Atualiza a soma
        lbTotalComissao.setText(String.valueOf(valorFormatado));

        dao.adicionar(a);
        carregaTabela();

    }//GEN-LAST:event_btGravarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        ComissaoPagamento a = new ComissaoPagamento();
        ComissaoDao dao = new ComissaoDao();

        int index = tbComissao.getSelectedRow();
        a = dao.listaComissao().get(index);

        switch (JOptionPane.showConfirmDialog(null,
                " [--ALTERAÇÃO DE DADOS--] \n Dado Atual"
                + "\n Cliente:  " + a.getNome()
                + "\n Empresa:  " + a.getEmpresa()
                + "\n Data Pedido: " + a.getDataPedido()
                + "\n Data Entrega: " + a.getDataEntrega()
                + "\n Preço Cheia: " + a.getPrecoCheia()
                + "\n Preço Fabrica : " + a.getPrecoFabrica()
                + "\n Comissão: " + a.getValorComissao()
                + "\n Será alterado "
                + "\n Cliente:  " + cbxCliente.getSelectedItem()
                + "\n Empresa:  " + txtEmpresa.getText()
                + "\n Data Pedido: " + txtPedido.getText()
                + "\n Data Entrega: " + txtEntrega.getText()
                + "\n Preço Cheia: " + txtCheia.getText()
                + "\n Preço Fabrica: " + txtFabrica.getText()
                + "\n Deseja realmente fazer alteração?",
                "Alteração de dados.  ", JOptionPane.YES_NO_OPTION)) {

            case 0:
                String descricacaoCliente = cbxCliente.getSelectedItem().toString();
                a.setNome(descricacaoCliente);

                a.setEmpresa(txtEmpresa.getText());

                // Entrada da Data cliente
                try {
                    java.util.Date dataFormatada = sdfPedido.parse(txtPedido.getText());
                    java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
                    a.setDataPedido(dataSQL);
                } catch (ParseException ex) {
                    // Logger.getLogger(CadastroBoleto.class.getName()).log(Level.SEVERE, null, ex);

                    JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                // Entrada da Data Empresa
                try {
                    java.util.Date dataFormatada = sdfEntrega.parse(txtEntrega.getText());

                    java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());

                    a.setDataEntrega(dataSQL);

                } catch (ParseException ex) {

                    // Logger.getLogger(CadastroBoleto.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
                }
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

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        ComissaoPagamento a = new ComissaoPagamento();
        ComissaoDao dao = new ComissaoDao();

        int index = tbComissao.getSelectedRow();
        a = dao.listaComissao().get(index);

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir o Produto ? \n "
                + "\n Cliente:  " + a.getNome()
                + "\n Empresa: " + a.getEmpresa()
                + "\n Data Pedido: " + a.getDataPedido()
                + "\n Data Entrega: " + a.getDataEntrega()
                + "\n Preço: " + a.getPrecoCheia()
                + "\n Preço: " + a.getPrecoFabrica()
                + "\n  Comissão: " + a.getValorComissao(),
                "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {

            case 0:
                dao.remover(a);
                carregaTabela();
                limparCampos();
                desativaBotoes();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;

        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void cbxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClienteActionPerformed

    }//GEN-LAST:event_cbxClienteActionPerformed

    private void tbComissaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbComissaoMouseClicked
        //Setando campos de texto com registros
        ComissaoPagamento a = new ComissaoPagamento();
        ComissaoDao dao = new ComissaoDao();

        int index = tbComissao.getSelectedRow();
        a = dao.listaComissao().get(index);

        txtEmpresa.setText(a.getEmpresa());

        txtCheia.setText(Double.toString(a.getPrecoCheia()));
        txtFabrica.setText(Double.toString(a.getPrecoFabrica()));

        cbxCliente.setSelectedItem(a.getNome());
        cbxCliente.addItem(a.getNome());

        /*  FORMATANDO A DATA */
        SimpleDateFormat sdfC = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfE = new SimpleDateFormat("dd-MM-yyyy");

        if (a.getDataEntrega() != null) {
            txtEntrega.setText(sdfC.format(a.getDataEntrega()));
        }

        if (a.getDataPedido() != null) {
            txtPedido.setText(sdfE.format(a.getDataPedido()));
        }

        cbxCliente.setEnabled(true);

        txtEmpresa.setEnabled(true);
        txtCheia.setEnabled(true);

        txtFabrica.setEnabled(true);
        txtPedido.setEnabled(true);

        txtEntrega.setEnabled(true);
        txtPedido.setEnabled(true);

        btGravar.setEnabled(false);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
        ativaCampos();
    }//GEN-LAST:event_tbComissaoMouseClicked
    public void limparCampos() {
        txtEmpresa.setText("");
        txtPedido.setText("");
        txtEntrega.setText("");
        txtCheia.setText("");
        txtFabrica.setText("");
    }

    private void desativaBotoes() {
        btGravar.setEnabled(false);
        //  btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }

    private void desativaCampos() {
        cbxCliente.setEnabled(false);
        txtEmpresa.setEnabled(false);

        txtPedido.setEnabled(false);
        txtEntrega.setEnabled(false);

        txtCheia.setEnabled(false);
        txtFabrica.setEnabled(false);
    }

    private void ativaCampos() {
        cbxCliente.setEnabled(true);
        txtEmpresa.setEnabled(true);

        txtPedido.setEnabled(true);
        txtCheia.setEnabled(true);

        txtEntrega.setEnabled(true);
        txtFabrica.setEnabled(true);

    }

    private void ativaBotoes() {
        btGravar.setEnabled(true);
        //btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }

    private void CentralizarCampos() {
        txtEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
        txtPedido.setHorizontalAlignment(SwingConstants.CENTER);
        txtCheia.setHorizontalAlignment(SwingConstants.CENTER);
        txtEntrega.setHorizontalAlignment(SwingConstants.CENTER);
        txtFabrica.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void tamanhoTabela() {
        //Defini o tamanho da tabela
        tbComissao.getColumnModel().getColumn(0).setPreferredWidth(150);
        tbComissao.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbComissao.getColumnModel().getColumn(2).setPreferredWidth(90);
        tbComissao.getColumnModel().getColumn(3).setPreferredWidth(90);
        tbComissao.getColumnModel().getColumn(4).setPreferredWidth(90);
        tbComissao.getColumnModel().getColumn(5).setPreferredWidth(90);

    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbComissao.getModel();
        modelo.setNumRows(0);

        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar o renderizador às colunas de valorpedido (índice 1) e quantidadebobina (índice 2)
        tbComissao.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbComissao.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbComissao.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbComissao.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbComissao.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tbComissao.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        
        tamanhoTabela();
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT * from comissao order by nome ASC ;");

            rs = pstm.executeQuery();

            //Formatar o valor no campo jtable
            NumberFormat currencyPrecoCheia = NumberFormat.getCurrencyInstance();
            NumberFormat currencyPrecoFabrica = NumberFormat.getCurrencyInstance();
            NumberFormat currencyValorComissao = NumberFormat.getCurrencyInstance();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("nome"),
                    rs.getString("empresa"),
                    rs.getDate("datapedido"),
                    rs.getDate("dataentrega"),
                    currencyPrecoCheia.format(rs.getDouble("precocheia")),
                    currencyPrecoFabrica.format(rs.getDouble("precofabrica")),
                    currencyValorComissao.format(rs.getDouble("valorcomissao")),});
            }
            Conexao.closeConnection(con, pstm, rs);

        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JComboBox<String> cbxCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTotalComissao;
    private javax.swing.JTable tbComissao;
    private javax.swing.JTextField txtCheia;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JFormattedTextField txtEntrega;
    private javax.swing.JTextField txtFabrica;
    private javax.swing.JFormattedTextField txtPedido;
    // End of variables declaration//GEN-END:variables
}
