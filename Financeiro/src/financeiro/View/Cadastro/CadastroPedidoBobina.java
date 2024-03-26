package financeiro.View.Cadastro;

import financeiro.DAO.PedidoBobinaDao;
import financeiro.conexao.Conexao;
import financeiro.model.PedidoBobina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CadastroPedidoBobina extends javax.swing.JInternalFrame {

    //Conversão de data
    private final SimpleDateFormat sdfPedido = new SimpleDateFormat("dd-MM-yyyy");
    private final SimpleDateFormat sdfEntrega = new SimpleDateFormat("dd-MM-yyyy");

    public CadastroPedidoBobina() {
        initComponents();
        carregaTabela();
        desativaBotoes();
        desativaCampos();
        CentralizarJTextFields();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btAlterar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPedido = new javax.swing.JTable();
        txtNomeEmpresa = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtQuant = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtChequeA = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtChequeB = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtChequeC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbTotalBobina = new javax.swing.JLabel();
        lblTotalValor = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxPag = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();
        txtDataPedido = new javax.swing.JFormattedTextField();
        txtDataEntrega = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        txtObsFrete = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Cadastro de Pedidos Entregues ");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

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

        tbPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data hora", "Empresa", "Valor", "Qtd", "Data Pedido", "Data Entrega", "N. Ch 1", "N. Ch 2", "N. Ch 3", "Forma Pag.", "Obs.", "Obs.2"
            }
        ));
        tbPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPedido);

        txtNomeEmpresa.setNextFocusableComponent(txtValor);

        txtValor.setNextFocusableComponent(txtDataPedido);

        jLabel1.setText("Empresa.:");

        jLabel2.setText("Quant.:");

        jLabel3.setText("Valor.:");

        txtQuant.setNextFocusableComponent(txtDataEntrega);

        jLabel4.setText("Data Pedido.:");

        jLabel5.setText("Data Entrega.:");

        jLabel6.setText("N.Cheque 1.:");

        txtChequeA.setNextFocusableComponent(txtChequeB);

        jLabel7.setText("N.Cheque 2.:");

        txtChequeB.setNextFocusableComponent(txtChequeC);

        jLabel8.setText("N.Cheque 3.:");

        txtChequeC.setNextFocusableComponent(txtQuant);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText(" T. Geral  ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText(" T. Bobinas ");

        lbTotalBobina.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTotalBobina.setText("0");

        lblTotalValor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTotalValor.setText("0.00");

        jLabel11.setText("Forma Pag.:");

        cbxPag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Boleto", "Cart.Débito", "Cart.Crédito", "Conta Salário", "Ch à vista", "Ch 30d", "Ch 60d", "Ch 90d", "Dinheiro", "Pag. Pendente", "PIX", "Transf. Bancária" }));

        jLabel12.setText("Obs.:");

        txtObs.setText(" ");
        txtObs.setNextFocusableComponent(btGravar);
        txtObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObsActionPerformed(evt);
            }
        });

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

        jLabel13.setText("Obs2.:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataEntrega))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(11, 11, 11)
                                .addComponent(txtNomeEmpresa)))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel11)
                                .addGap(3, 3, 3)
                                .addComponent(cbxPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtChequeB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtChequeC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtChequeA, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lbTotalBobina, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblTotalValor)
                                        .addGap(10, 10, 10)))
                                .addGap(56, 56, 56))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtObsFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btNovo)
                            .addComponent(btGravar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTotalValor))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbTotalBobina)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btAlterar)
                                    .addComponent(btExcluir)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtChequeA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtChequeB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtChequeC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtObsFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
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

    private void tamanhoTabela() {
        //Defini o tamanho da tabela
        tbPedido.getColumnModel().getColumn(0).setPreferredWidth(80);
        tbPedido.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbPedido.getColumnModel().getColumn(2).setPreferredWidth(40);
        tbPedido.getColumnModel().getColumn(3).setPreferredWidth(20);
        //sao as dadtas
        tbPedido.getColumnModel().getColumn(4).setPreferredWidth(50);
        tbPedido.getColumnModel().getColumn(5).setPreferredWidth(50);
        //numero de cheques
        tbPedido.getColumnModel().getColumn(6).setPreferredWidth(20);
        tbPedido.getColumnModel().getColumn(7).setPreferredWidth(20);
        tbPedido.getColumnModel().getColumn(8).setPreferredWidth(20);

        tbPedido.getColumnModel().getColumn(9).setPreferredWidth(50);
        tbPedido.getColumnModel().getColumn(10).setPreferredWidth(130);
        tbPedido.getColumnModel().getColumn(11).setPreferredWidth(130);
    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbPedido.getModel();
        tamanhoTabela();
        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tbPedido.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbPedido.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbPedido.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tbPedido.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbPedido.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tbPedido.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        tbPedido.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;
            String sqlSomaTotalBobinas = "SELECT SUM(quantidadeBobina) AS totalBobinas FROM pedidobobina WHERE EXTRACT(MONTH FROM CAST(dataPedido AS DATE)) = ? AND EXTRACT(YEAR FROM CAST(dataPedido AS DATE)) = ?";
            // Obtém o mês e o ano atuais
            Calendar cal = Calendar.getInstance();
            int mesAtual = -1;
            int mesAtualNovo = cal.get(Calendar.MONTH) + 1; // Note que os meses em Java começam do zero
            int anoAtual = cal.get(Calendar.YEAR);
            //verificar se o mês atual
            if (mesAtual != mesAtualNovo) {
                lbTotalBobina.setText("0");
                lblTotalValor.setText("0");
                modelo.setNumRows(0);
                //atualiza o mês atual
                mesAtual = mesAtualNovo;
            }
            try (PreparedStatement statementBobinas = con.prepareStatement(sqlSomaTotalBobinas)) {
                statementBobinas.setInt(1, mesAtual);
                statementBobinas.setInt(2, anoAtual);
                try (ResultSet resultadoBobinas = statementBobinas.executeQuery()) {
                    if (resultadoBobinas.next()) {
                        int totalBobinas = resultadoBobinas.getInt("totalBobinas");
                        lbTotalBobina.setText(String.valueOf(totalBobinas));
                    } else {
                        // Se não houver resultados, define o total como zero
                        lbTotalBobina.setText("0");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // Consulta para obter a soma total da coluna Valor Pedido para o mês atual
            String sqlSomaTotalReal = "SELECT SUM(valorpedido) AS totalValor FROM pedidobobina WHERE EXTRACT(MONTH FROM CAST(dataPedido AS DATE)) = ? AND EXTRACT(YEAR FROM CAST(dataPedido AS DATE)) = ?";
            try (PreparedStatement statementValor = con.prepareStatement(sqlSomaTotalReal)) {
                statementValor.setInt(1, mesAtual);
                statementValor.setInt(2, anoAtual);
                
                try (ResultSet resultadoValor = statementValor.executeQuery()) {
                    if (resultadoValor.next()) {
                        Double totalValor = resultadoValor.getDouble("totalValor");
                        //Formatar o valor
                        DecimalFormat decimalFormat = new DecimalFormat("#.##");
                        String valorFormatado = decimalFormat.format(totalValor);
                        lblTotalValor.setText(String.valueOf(valorFormatado));
                    } else {
                        // Se não houver resultados, define o total como zero
                        lblTotalValor.setText("0");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // Limpa a tabela antes de preencher os novos dados
            modelo.setNumRows(0);
            pstm = con.prepareStatement("SELECT id,datahora,nomecliente,valorpedido,quantidadebobina,datapedido,dataentrega,numerochequea,numerochequeb,numerochequec,pagpedido,observacao,obsfrete FROM pedidobobina WHERE EXTRACT(MONTH FROM CAST(datahora AS DATE)) = ? AND EXTRACT(YEAR FROM CAST(datahora AS DATE)) = ? ORDER BY id DESC");
            pstm.setInt(1, mesAtual);
            pstm.setInt(2, anoAtual);
            rs = pstm.executeQuery();
            //Formatar o valor no campo jtable
            NumberFormat currencyValor = NumberFormat.getCurrencyInstance();
            while (rs.next()) {

                // Dentro do seu loop while
                SimpleDateFormat dateFormatHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dataHoraFormatada = dateFormatHora.format(rs.getTimestamp("datahora"));

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dataFormatadaEntrega = dateFormat.format(rs.getDate("dataentrega"));
                String dataFormatadaPedido = dateFormat.format(rs.getDate("datapedido"));

                modelo.addRow(new Object[]{
                    dataHoraFormatada,
                    rs.getString("nomecliente"),
                    currencyValor.format(rs.getDouble("valorpedido")),
                    rs.getString("quantidadebobina"),
                    dataFormatadaPedido,
                    dataFormatadaEntrega,
                    // rs.getString("dataentrega"),
                    //rs.getString("datapedido"),
                    rs.getString("numerochequea"),
                    rs.getString("numerochequeb"),
                    rs.getString("numerochequec"),
                    rs.getString("pagpedido"),
                    rs.getString("observacao"),
                    rs.getString("obsfrete"),});
            }
            Conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void CentralizarJTextFields() {
        txtNomeEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
        lbTotalBobina.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotalValor.setHorizontalAlignment(SwingConstants.CENTER);
        txtValor.setHorizontalAlignment(SwingConstants.CENTER);
        txtDataEntrega.setHorizontalAlignment(SwingConstants.CENTER);
        txtDataPedido.setHorizontalAlignment(SwingConstants.CENTER);
        txtQuant.setHorizontalAlignment(SwingConstants.CENTER);
        txtChequeA.setHorizontalAlignment(SwingConstants.CENTER);
        txtChequeB.setHorizontalAlignment(SwingConstants.CENTER);
        txtChequeC.setHorizontalAlignment(SwingConstants.CENTER);
        //cbxPag.setHorizontalAlignment(SwingConstants.CENTER);
        txtObs.setHorizontalAlignment(SwingConstants.CENTER);
        txtObsFrete.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void limparTexto() {
        txtNomeEmpresa.setText("");
        txtQuant.setText("");
        txtValor.setText("");
        txtDataEntrega.setText("");
        txtDataPedido.setText("");
        txtChequeA.setText("");
        txtChequeB.setText("");
        txtChequeC.setText("");
        txtObs.setText("");
        txtObsFrete.setText("");
        // Limpar JComboBox (usando setSelectedItem(null))
        cbxPag.setSelectedItem(null);
        btGravar.setEnabled(false);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }

    private void desativaBotoes() {
        btGravar.setEnabled(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }

    private void desativaCampos() {
        txtNomeEmpresa.setEnabled(false);
        txtValor.setEnabled(false);
        txtQuant.setEnabled(false);
        txtDataEntrega.setEnabled(false);
        txtDataPedido.setEnabled(false);
        txtChequeA.setEnabled(false);
        txtChequeB.setEnabled(false);
        txtChequeC.setEnabled(false);
        txtObs.setEnabled(false);
        txtObsFrete.setEnabled(false);
        cbxPag.setEnabled(false);
    }

    private void ativaBotoes() {
        btGravar.setEnabled(true);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }

    private void ativaCampos() {
        txtNomeEmpresa.setEnabled(true);
        txtValor.setEnabled(true);
        txtQuant.setEnabled(true);
        txtDataEntrega.setEnabled(true);
        txtDataPedido.setEnabled(true);
        txtChequeA.setEnabled(true);
        txtChequeB.setEnabled(true);
        txtChequeC.setEnabled(true);
        txtObs.setEnabled(true);
        txtObsFrete.setEnabled(true);
        cbxPag.setEnabled(true);
    }
    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        PedidoBobina l = new PedidoBobina();
        PedidoBobinaDao dao = new PedidoBobinaDao();
        int index = tbPedido.getSelectedRow();
        l = dao.listarPedidoBobina().get(index);
        switch (JOptionPane.showConfirmDialog(null,
                "[--ALTERAÇÃO DE DADOS--] \n Dado Atual"
                + "\n Empresa:  " + l.getNomeClientePedido()
                + "\n R$: " + l.getValorPedido()
                + "\n Quant : " + l.getQuantidadeBobina()
                + "\n Data Pedido: " + l.getDataPedido()
                + "\n Data Entrega: " + l.getDataEntrega()
                + "\n N. Cheque 1: " + l.getNumeroChequeA()
                + "\n N. Cheque 2: " + l.getNumeroChequeB()
                + "\n N. Cheque 3: " + l.getNumeroChequeC()
                + "\n Forma Pag.: " + l.getPagPedido()
                + "\n Obs.: " + l.getObservacaoPagamento()
                + "\n ObsFrete.: " + l.getObservacaoFrete()
                + "\n Será alterado \n Empresa: "
                + txtNomeEmpresa.getText()
                + "\n R$: " + txtValor.getText()
                + "\n Quant : " + txtQuant.getText()
                + "\n Data Pedido: " + txtDataPedido.getText()
                + "\n Data Entrega: " + txtDataEntrega.getText()
                + "\n N. Cheque 1: " + txtChequeA.getText()
                + "\n  N. Cheque 2: " + txtChequeB.getText()
                + "\n  N. Cheque 3: " + txtChequeC.getText()
                + "\n Forma Pag.: " + cbxPag.getSelectedItem()
                + "\n Obs.: " + txtObs.getText()
                + "\n ObsFrete.: " + txtObsFrete.getText()
                + "\n Deseja realmente fazer alteração?",
                "Alteração de dados.", JOptionPane.YES_NO_OPTION)) {
            case 0:
                l.setNomeClientePedido(txtNomeEmpresa.getText());
                String valorPedido = txtValor.getText().trim().replace(",", ".");
                l.setValorPedido(Double.parseDouble(valorPedido));

                l.setQuantidadeBobina(Integer.parseInt(txtQuant.getText()));
                l.setNumeroChequeA(txtChequeA.getText());
                l.setNumeroChequeB(txtChequeB.getText());
                l.setNumeroChequeC(txtChequeC.getText());
                l.setPagPedido((String) cbxPag.getSelectedItem());
                l.setObservacaoPagamento(txtObs.getText());
                l.setObservacaoFrete(txtObsFrete.getText());
                // Entrada da Data cliente
                try {
                    java.util.Date dataFormatada = sdfPedido.parse(txtDataPedido.getText());
                    java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
                    l.setDataPedido(dataSQL);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                // Entrada da Data Empresa
                try {
                    java.util.Date dataFormatada = sdfEntrega.parse(txtDataEntrega.getText());
                    java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
                    l.setDataEntrega(dataSQL);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                dao.alterar(l);// faz alteração no banco de dados
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
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        txtNomeEmpresa.setText("");
        limparTexto();
        ativaBotoes();
        ativaCampos();
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed
    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        if (txtNomeEmpresa.getText().isEmpty() || txtQuant.getText().isEmpty()
                || txtChequeA.getText().isEmpty() || txtChequeB.getText().isEmpty()
                || txtChequeC.getText().isEmpty() || cbxPag.getSelectedItem() == null
                || txtValor.getText().isEmpty()
                || txtDataPedido.getText().isEmpty() || txtDataEntrega.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        PedidoBobina l = new PedidoBobina();
        PedidoBobinaDao dao = new PedidoBobinaDao();
        l.setNomeClientePedido(txtNomeEmpresa.getText());

        String valorPedido = txtValor.getText().trim().replace(",", ".");

        l.setValorPedido(Double.parseDouble(valorPedido));
        //Converter integer para int
        l.setQuantidadeBobina(Integer.parseInt(txtQuant.getText()));
        l.setNumeroChequeA(txtChequeA.getText());
        l.setNumeroChequeB(txtChequeB.getText());
        l.setNumeroChequeC(txtChequeC.getText());
        l.setPagPedido((String) cbxPag.getSelectedItem());
        l.setObservacaoPagamento(txtObs.getText());
        l.setObservacaoFrete(txtObsFrete.getText());
        // Entrada da Data cliente
        try {
            java.util.Date dataFormatada = sdfPedido.parse(txtDataPedido.getText());
            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
            l.setDataPedido(dataSQL);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Impede a continuação do método se a data estiver incorreta
        }
        // Entrada da Data Empresa
        try {
            java.util.Date dataFormatada = sdfEntrega.parse(txtDataEntrega.getText());
            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
            l.setDataEntrega(dataSQL);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Impede a continuação do método se a data estiver incorreta
        }
        dao.adicionar(l);
        carregaTabela();
        desativaCampos();
        limparTexto();
    }//GEN-LAST:event_btGravarActionPerformed
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        PedidoBobina l = new PedidoBobina();
        PedidoBobinaDao dao = new PedidoBobinaDao();
        int index = tbPedido.getSelectedRow();
        l = dao.listarPedidoBobina().get(index);
        l.setNomeClientePedido(txtNomeEmpresa.getText());
        //Converter integer para int
        l.setQuantidadeBobina(Integer.parseInt(txtQuant.getText()));
        l.setNumeroChequeA(txtChequeA.getText());
        l.setNumeroChequeB(txtChequeB.getText());
        l.setNumeroChequeC(txtChequeC.getText());
        l.setPagPedido((String) cbxPag.getSelectedItem());
        l.setObservacaoPagamento(txtObs.getText());
        l.setObservacaoFrete(txtObsFrete.getText());
        //Converte o valor
        String txtValorPedido = txtValor.getText();
        // Convertendo a String para double
        double valorPedido = Double.parseDouble(txtValorPedido);
        // Definindo o valor convertido na propriedade
        l.setValorPedido(valorPedido);
        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir o Produto ? \n "
                + "\n Empresa:  " + l.getNomeClientePedido()
                + "\n R$: " + l.getValorPedido()
                + "\n Quant : " + l.getQuantidadeBobina()
                + "\n Data Pedido: " + l.getDataPedido()
                + "\n Data Entrega: " + l.getDataEntrega()
                + "\n N. Cheque 1: " + l.getNumeroChequeA()
                + "\n N. Cheque 2: " + l.getNumeroChequeB()
                + "\n N. Cheque 3: " + l.getNumeroChequeC()
                + "\n Pag.: " + l.getPagPedido()
                + "\n Obs.:" + l.getObservacaoPagamento()
                + "\n ObsFrete.:" + l.getObservacaoFrete(), "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            case 0:
                dao.remover(l);
                carregaTabela();
                limparTexto();
                desativaBotoes();
                desativaCampos();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btExcluirActionPerformed
    private void tbPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPedidoMouseClicked
        //Setando campos de texto com registros
        PedidoBobina g = new PedidoBobina();
        PedidoBobinaDao dao = new PedidoBobinaDao();
        int index = tbPedido.getSelectedRow();
        g = dao.listarPedidoBobina().get(index);
        txtNomeEmpresa.setText(g.getNomeClientePedido());
        txtValor.setText(Double.toString(g.getValorPedido()));
        txtQuant.setText(String.valueOf(g.getQuantidadeBobina()));
        txtChequeA.setText(g.getNumeroChequeA());
        txtChequeB.setText(g.getNumeroChequeB());
        txtChequeC.setText(g.getNumeroChequeC());
        cbxPag.setSelectedItem(g.getPagPedido());
        txtObs.setText(g.getObservacaoPagamento());
        txtObsFrete.setText(g.getObservacaoFrete());
        // Definindo as datas formatadas nos JTextFields existentes
        SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
        txtDataPedido.setValue(formatoData.format(g.getDataPedido()));
        txtDataEntrega.setValue(formatoData.format(g.getDataEntrega()));

        ativaCampos();
        btGravar.setEnabled(false);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }//GEN-LAST:event_tbPedidoMouseClicked

    private void txtObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JComboBox cbxPag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTotalBobina;
    private javax.swing.JLabel lblTotalValor;
    private javax.swing.JTable tbPedido;
    private javax.swing.JTextField txtChequeA;
    private javax.swing.JTextField txtChequeB;
    private javax.swing.JTextField txtChequeC;
    private javax.swing.JFormattedTextField txtDataEntrega;
    private javax.swing.JFormattedTextField txtDataPedido;
    private javax.swing.JTextField txtNomeEmpresa;
    private javax.swing.JTextField txtObs;
    private javax.swing.JTextField txtObsFrete;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
