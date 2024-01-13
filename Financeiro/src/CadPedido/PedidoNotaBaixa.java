/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CadPedido;

import financeiro.DAO.BobinaDao;
import financeiro.DAO.EmpresaDao;
import financeiro.DAO.NotaBaixaDao;
import financeiro.conexao.Conexao;
import financeiro.model.NotaBaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ledilson
 */
public class PedidoNotaBaixa extends javax.swing.JInternalFrame {

    /**
     * Creates new form PedidoNotaBaixa
     */
    public PedidoNotaBaixa() {
        initComponents();
        cbListProduto();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNotaBaixa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox<>();
        cbxProduto = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtQuant = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIpi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblValorUnitarioIpi = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        lbPesoTotal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbDiferencaIpi = new javax.swing.JLabel();
        btGravar = new javax.swing.JButton();
        lbPesoTotalIpi = new javax.swing.JLabel();
        btExcluir = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDataPedido = new javax.swing.JFormattedTextField();
        txtDataEntrega = new javax.swing.JFormattedTextField();

        setClosable(true);
        setTitle("Pedido Nota Baixa");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tbNotaBaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Produto", "Qtd", "Peso", "Preço S/ IPI", "Preço C/ IPI", "Total S/ IPI", "Total C/ IPI", "IPI", "Valor de IPI"
            }
        ));
        tbNotaBaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNotaBaixaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbNotaBaixa);

        jLabel1.setText("Cliente.:");

        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClienteActionPerformed(evt);
            }
        });

        cbxProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProdutoActionPerformed(evt);
            }
        });

        jLabel2.setText("Produto.:");

        txtQuant.setText(" ");

        jLabel3.setText("Quantidade.:");

        jLabel4.setText("Imposto R$.:");

        jLabel5.setText("Preço Unitário.:");

        txtValorUnitario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtValorUnitario.setText("0.00");

        jLabel6.setText("Preço Unitário IPI.:");

        lblValorUnitarioIpi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblValorUnitarioIpi.setText("0.00");

        jLabel7.setText("Total.:");

        jLabel8.setText("Peso.:");

        txtPeso.setText(" ");

        lbPesoTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbPesoTotal.setText("0.00");

        jLabel9.setText("Total IPI.: ");

        jLabel11.setText("Valor de IPI.:");

        lbDiferencaIpi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDiferencaIpi.setText("0.00");

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        lbPesoTotalIpi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbPesoTotalIpi.setText("0.00");

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        jLabel10.setText("Data Pedido");

        jLabel12.setText("Data Entrega");

        try {
            txtDataPedido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
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
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btNovo)
                                .addGap(18, 18, 18)
                                .addComponent(btGravar)
                                .addGap(18, 18, 18)
                                .addComponent(btAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(btExcluir)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxCliente, 0, 201, Short.MAX_VALUE)
                                    .addComponent(cbxProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtValorUnitario)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblValorUnitarioIpi)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbPesoTotal)
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbPesoTotalIpi))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4)
                                                .addGap(12, 12, 12)
                                                .addComponent(txtIpi, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)))))
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDiferencaIpi)
                        .addGap(164, 164, 164))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGravar)
                    .addComponent(btExcluir)
                    .addComponent(btNovo)
                    .addComponent(btAlterar)
                    .addComponent(jLabel11)
                    .addComponent(lbDiferencaIpi)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(txtDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel8)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtIpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtValorUnitario)
                    .addComponent(jLabel6)
                    .addComponent(lblValorUnitarioIpi)
                    .addComponent(jLabel7)
                    .addComponent(lbPesoTotal)
                    .addComponent(lbPesoTotalIpi)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void cbxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClienteActionPerformed

    }//GEN-LAST:event_cbxClienteActionPerformed

    private void cbxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProdutoActionPerformed
        // Não use getStateChange() para eventos de ação, pois é específico de eventos de item
        int selectedIndex = cbxProduto.getSelectedIndex();

        if (selectedIndex >= 0 && selectedIndex < valorUnitarioBobina1.size()) {
            double valorSelecionado = valorUnitarioBobina1.get(selectedIndex);
            txtValorUnitario.setText(String.valueOf(valorSelecionado));
        }
    }//GEN-LAST:event_cbxProdutoActionPerformed
    private double AcumuloPesoPdido = 0.0;    //Comunicação com cbxBobina Adcionar
    private double AcumuloPesoImposto = 0.0;

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
    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        if (txtValorUnitario.getText().isEmpty() || txtPeso.getText().isEmpty() || cbxCliente.getSelectedItem() == null || cbxProduto.getSelectedItem() == null
                || txtIpi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        NotaBaixa a = new NotaBaixa();
        NotaBaixaDao dao = new NotaBaixaDao();

        try {

            String descricacaoCliente = cbxCliente.getSelectedItem().toString();
          
            a.setNomeEmpresa(descricacaoCliente);

            String quantidadeTexto = txtQuant.getText().trim(); // Remova espaços em branco
            if (!quantidadeTexto.isEmpty()) {
                int quantidade = Integer.parseInt(quantidadeTexto);
                a.setQuantidade(quantidade);

                //adição do produto
                //a.setNomeProduto(txtNomeProduto.getText());
                if (cbxProduto.getItemCount() > 0) {

                    String descricaoSelecionada = cbxProduto.getSelectedItem().toString();
                    a.setNomeProduto(descricaoSelecionada);

                    a.setValorUnitario(Double.parseDouble(txtValorUnitario.getText()));

                    a.setPesoPapel(Double.parseDouble(txtPeso.getText()));

                    //Calculo do valor total
                    double valorPedidoPeso = a.getValorUnitario() * a.getPesoPapel();
                    a.setTotalSipi(valorPedidoPeso);

                    // Acumula o valor total
                    AcumuloPesoPdido += valorPedidoPeso;

                    // Formata o valor para exibir apenas duas casas decimais
                    DecimalFormat df = new DecimalFormat("#.##");
                    String valorFormatado = df.format(AcumuloPesoPdido);

                    // Atualiza a soma
                    lbPesoTotal.setText(String.valueOf(valorFormatado));

                    //Usuario já inserir o valor
                    a.setIpi(Double.parseDouble(txtIpi.getText()));

                    //Calcula o imposto Ipi  resultado valorUnitarioIpi
                    double valorUnitarioIpi = ((a.getIpi() / 100) + 1) * a.getValorUnitario();

                    // Formata o valor para exibir apenas duas casas decimais
                    DecimalFormat dg = new DecimalFormat("#.##");
                    String valorFormatadoImposto = dg.format(valorUnitarioIpi);

                    // Substitui vírgula por ponto
                    valorFormatadoImposto = valorFormatadoImposto.replace(",", ".");

                    //Exibi o valor de 4.13 imposto
                    lblValorUnitarioIpi.setText(valorFormatadoImposto);

                    // Salva no banco de dados
                    a.setValorIpi(Double.parseDouble(valorFormatadoImposto));

                    double valorPesoCIpi = a.getValorIpi() * a.getPesoPapel();

                    a.setTotalCipi(valorPesoCIpi);

                    AcumuloPesoImposto += valorPesoCIpi;

                    //Formata o valor para exibir apenas duas casas decimais
                    DecimalFormat dh = new DecimalFormat("#.##");
                    String valorFormatadoIpi = dh.format(AcumuloPesoImposto);

                    // Atualiza a soma
                    lbPesoTotalIpi.setText(String.valueOf(valorFormatadoIpi));

                    //Diferença
                    //  double ipiDiferenca = a.getTotalCipi() - a.getTotalSipi();
                    double ipiDiferenca = AcumuloPesoImposto - AcumuloPesoPdido;

                    a.setDiferencialIpi(ipiDiferenca);

                    //Formata o valor para exibir apenas duas casas decimais
                    DecimalFormat dj = new DecimalFormat("#.##");
                    String valorDiferenca = dj.format(ipiDiferenca);
                    // Atualiza a soma
                    lbDiferencaIpi.setText(String.valueOf(valorDiferenca));

                    dao.adicionar(a);
                    carregaTabela();

                    limparCampos();
                    // Atualiza a soma
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
            }
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para quantidade, valor e peso.", "Erro", JOptionPane.ERROR_MESSAGE);
            // Ou logue a exceção para análise posterior
            e.printStackTrace();
        }

    }//GEN-LAST:event_btGravarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        ativaBotoes();
        ativaCampos();
        // btAlterar.setEnabled(false);
        limparCampos();
        btExcluir.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed

    private void tbNotaBaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNotaBaixaMouseClicked
        //Setando campos de texto com registros
        NotaBaixa a = new NotaBaixa();
        NotaBaixaDao dao = new NotaBaixaDao();

        int index = tbNotaBaixa.getSelectedRow();
        a = dao.listarBaixa().get(index);

        txtQuant.setText(Integer.toString(a.getQuantidade()));
        txtPeso.setText(Double.toString(a.getPesoPapel()));
        txtIpi.setText(Double.toString(a.getIpi()));
        txtValorUnitario.setText(Double.toString(a.getValorUnitario()));

        cbxCliente.setSelectedItem(a.getNomeEmpresa());
        cbxCliente.addItem(a.getNomeEmpresa());

        cbxProduto.setSelectedItem(a.getNomeProduto());
        cbxProduto.addItem(a.getNomeProduto());

        btGravar.setEnabled(false);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
        ativaCampos();
    }//GEN-LAST:event_tbNotaBaixaMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        NotaBaixa a = new NotaBaixa();
        NotaBaixaDao dao = new NotaBaixaDao();

        int index = tbNotaBaixa.getSelectedRow();
        a = dao.listarBaixa().get(index);

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir o Produto ? \n "
                + "\n Empresa:  " + a.getNomeEmpresa()
                + "\n Produto: " + a.getNomeProduto()
                + "\n Qtd: " + a.getQuantidade()
                + "\n Peso: " + a.getPesoPapel()
                + "\n Preço s/Ipi: " + a.getValorUnitario()
                + "\n Preço c/Ipi: " + a.getValorIpi()
                + "\n Total s/Ipi: " + a.getTotalSipi()
                + "\n  Total c/Ipi: " + a.getTotalCipi()
                + "\n Ipi: " + a.getIpi(),
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

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        NotaBaixa a = new NotaBaixa();
        NotaBaixaDao dao = new NotaBaixaDao();

        int index = tbNotaBaixa.getSelectedRow();
        a = dao.listarBaixa().get(index);

        switch (JOptionPane.showConfirmDialog(null,
                " [--ALTERAÇÃO DE DADOS--] \n Dado Atual"
                + "\n Empresa:  " + a.getNomeEmpresa()
                + "\n Produto: " + a.getNomeProduto()
                + "\n Qtd: " + a.getQuantidade()
                + "\n Peso: " + a.getPesoPapel()
                + "\n Preço s/Ipi: " + a.getValorUnitario()
                + "\n Preço c/Ipi: " + a.getValorIpi()
                + "\n Total s/Ipi: " + a.getTotalSipi()
                + "\n  Total c/Ipi: " + a.getTotalCipi()
                + "\n Ipi: " + a.getIpi()
                + "\n Será alterado "
                + "\n Empresa:  " + cbxCliente.getSelectedItem()
                + "\n Produto: " + cbxProduto.getSelectedItem()
                + "\n Qtd: " + txtQuant.getText()
                + "\n Peso: " + txtPeso.getText()
                + "\n Preço s/Ipi: " + txtValorUnitario.getText()
                + "\n Preço c/Ipi: " + lblValorUnitarioIpi.getText()
                + "\n Total s/Ipi: " + lbPesoTotal.getText()
                + "\n  Total c/Ipi: " + lbPesoTotalIpi.getText()
                + "\n Ipi: " + txtIpi.getText()
                + "\n Deseja realmente fazer alteração?",
                "Alteração de dados.  ", JOptionPane.YES_NO_OPTION)) {

            case 0:
                String descricacaoCliente = cbxCliente.getSelectedItem().toString();
                a.setNomeEmpresa(descricacaoCliente);

                String descricaoSelecionada = cbxProduto.getSelectedItem().toString();
                a.setNomeProduto(descricaoSelecionada);

                a.setQuantidade(Integer.parseInt(txtQuant.getText()));
                a.setPesoPapel(Double.parseDouble(txtPeso.getText()));

                a.setValorUnitario(Double.parseDouble(txtValorUnitario.getText()));
                //  a.setValorIpi(Double.parseDouble(lblValorUnitarioIpi.getText()));

                //  a.setTotalSipi(Double.parseDouble(lbPesoTotal.getText()));
                //    a.setTotalCipi(Double.parseDouble(lbPesoTotalIpi.getText()));
                a.setPesoPapel(Double.parseDouble(txtPeso.getText()));
                a.setIpi(Double.parseDouble(txtIpi.getText()));

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
    public void limparCampos() {
        cbxCliente.removeAllItems();
        cbxProduto.removeAllItems();
        txtQuant.setText("");
        txtPeso.setText("");
        txtIpi.setText("");
        txtValorUnitario.setText("");
        lblValorUnitarioIpi.setText("");
        lbPesoTotal.setText("");
        lbPesoTotalIpi.setText("");
    }

    private void desativaBotoes() {
        btGravar.setEnabled(false);
        //  btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);

    }

    private void desativaCampos() {
        cbxCliente.setEnabled(false);
        cbxProduto.setEnabled(false);
        txtQuant.setEnabled(false);
        txtPeso.setEnabled(false);
        txtIpi.setEnabled(false);
        txtValorUnitario.setEnabled(false);
        lblValorUnitarioIpi.setEnabled(false);
        lbPesoTotal.setEnabled(false);
        lbPesoTotalIpi.setEnabled(false);
    }

    private void ativaCampos() {
        cbxCliente.setEnabled(true);
        cbxProduto.setEnabled(true);
        txtQuant.setEnabled(true);
        txtPeso.setEnabled(true);
        txtIpi.setEnabled(true);
        txtValorUnitario.setEnabled(true);
        lblValorUnitarioIpi.setEnabled(true);
        lbPesoTotal.setEnabled(true);
        lbPesoTotalIpi.setEnabled(true);
    }

    private void ativaBotoes() {
        btGravar.setEnabled(true);
        //btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }

    private void CentralizarCampos() {
        txtQuant.setHorizontalAlignment(SwingConstants.CENTER);
        txtPeso.setHorizontalAlignment(SwingConstants.CENTER);
        txtIpi.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbNotaBaixa.getModel();
        modelo.setNumRows(0);

        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar o renderizador às colunas de valorpedido (índice 1) e quantidadebobina (índice 2)
        tbNotaBaixa.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        tbNotaBaixa.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbNotaBaixa.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        //tbNotaBaixa.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tbNotaBaixa.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        // tbNotaBaixa.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

        tbNotaBaixa.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        tbNotaBaixa.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);

        //Defini o tamanho da tabela
        tbNotaBaixa.getColumnModel().getColumn(0).setPreferredWidth(130);
        tbNotaBaixa.getColumnModel().getColumn(1).setPreferredWidth(150);
        /* tbNotaBaixa.getColumnModel().getColumn(2).setPreferredWidth(70);
        tbNotaBaixa.getColumnModel().getColumn(3).setPreferredWidth(70);
        
        tbNotaBaixa.getColumnModel().getColumn(4).setPreferredWidth(80);
        tbNotaBaixa.getColumnModel().getColumn(5).setPreferredWidth(60);
        tbNotaBaixa.getColumnModel().getColumn(6).setPreferredWidth(25);
        tbNotaBaixa.getColumnModel().getColumn(7).setPreferredWidth(150);
        tbNotaBaixa.getColumnModel().getColumn(8).setPreferredWidth(80);
        tbNotaBaixa.getColumnModel().getColumn(9).setPreferredWidth(60);**/

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT * from notabaixa order by nomeempresa ASC ;");

            rs = pstm.executeQuery();

            //Formatar o valor no campo jtable
            NumberFormat currencyPesoPapel = NumberFormat.getCurrencyInstance();
            NumberFormat currencyValorUnitario = NumberFormat.getCurrencyInstance();

            NumberFormat currencyTotalSIpi = NumberFormat.getCurrencyInstance();
            NumberFormat currencyTotalCIpi = NumberFormat.getCurrencyInstance();

            NumberFormat currencyValorIpi = NumberFormat.getCurrencyInstance();
            NumberFormat currencyIpi = NumberFormat.getCurrencyInstance();
            NumberFormat currencyDiferencial = NumberFormat.getCurrencyInstance();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("nomeempresa"),
                    rs.getString("nomeproduto"),
                    rs.getString("quantidade"),
                    currencyPesoPapel.format(rs.getDouble("pesopapel")),
                    currencyValorUnitario.format(rs.getDouble("valorunitario")),
                    currencyValorIpi.format(rs.getDouble("valoripi")),
                    currencyTotalSIpi.format(rs.getDouble("totalsipi")),
                    currencyTotalCIpi.format(rs.getDouble("totalCipi")),
                    currencyIpi.format(rs.getDouble("ipi")),
                    currencyDiferencial.format(rs.getDouble("diferencial"))});
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
    private javax.swing.JComboBox<String> cbxProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbDiferencaIpi;
    private javax.swing.JLabel lbPesoTotal;
    private javax.swing.JLabel lbPesoTotalIpi;
    private javax.swing.JLabel lblValorUnitarioIpi;
    private javax.swing.JTable tbNotaBaixa;
    private javax.swing.JFormattedTextField txtDataEntrega;
    private javax.swing.JFormattedTextField txtDataPedido;
    private javax.swing.JTextField txtIpi;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JLabel txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
