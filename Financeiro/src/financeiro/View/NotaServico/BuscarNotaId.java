package financeiro.View.NotaServico;

import financeiro.DAO.NotaServicoDao;
import financeiro.conexao.Conexao;
import financeiro.model.NotaServicoFinal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
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

public class BuscarNotaId extends javax.swing.JInternalFrame {

    public BuscarNotaId() {
        initComponents();
        carregaTabela();
        CentralizarCampos();
        desativarBotao();
        desativarBotoes();
        dasabilitarCampos();
        txtId.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bgHabilitar = new javax.swing.JButton();
        bgReimprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNomeTomador = new javax.swing.JLabel();
        bgLocalizar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFluxoCliente = new javax.swing.JTable();
        btAlterar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtTomador = new javax.swing.JTextField();
        txtPrestador = new javax.swing.JTextField();
        txtObs = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQuant = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMontante = new javax.swing.JTextField();
        txtMontanteDevido = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtComissao = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtImposto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFrete = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("Emitir  Nota Serviço Indentificador");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bgHabilitar.setText("Habilitar");
        bgHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgHabilitarActionPerformed(evt);
            }
        });

        bgReimprimir.setText("Reimprimir");
        bgReimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgReimprimirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Digite o ID");

        txtId.setText(" ");

        lblNomeTomador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNomeTomador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        bgLocalizar.setText("Localizar");
        bgLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgLocalizarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        tbFluxoCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "ID", "Prestador", "Tomador", "Descrição", "Qtd", "Preço", "Peso", "Apagar", "Frete", "Imposto", "Comissão", "Total NS", "Obs."
            }
        ));
        tbFluxoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFluxoClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFluxoCliente);

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        jLabel2.setText("Empresa.:");

        jLabel3.setText("Cliente.:");

        jLabel6.setText("Descrição.:");

        jLabel12.setText("Obs.:");

        jLabel4.setText("Quant.:");

        jLabel5.setText("Preço.:");

        jLabel7.setText("Peso.:");

        jLabel8.setText("T.Carga.:");

        txtMontanteDevido.setText(" ");

        jLabel11.setText("A pagar.:");

        txtComissao.setText(" ");

        jLabel10.setText("Comissão.:");

        jLabel9.setText("Imposto.:");

        txtFrete.setText(" ");

        jLabel13.setText("Frete.:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMontante, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtImposto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtComissao, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMontanteDevido, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bgHabilitar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bgLocalizar)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNomeTomador, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(btExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(bgReimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTomador, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bgHabilitar)
                            .addComponent(bgReimprimir)
                            .addComponent(bgLocalizar)
                            .addComponent(btExcluir)
                            .addComponent(btAlterar))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblNomeTomador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtTomador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtMontante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtImposto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtMontanteDevido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void CentralizarCampos() {
        txtId.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void carregaTabela() {

        tamanhoTabela();
        DefaultTableModel modelo = (DefaultTableModel) tbFluxoCliente.getModel();
        modelo.setNumRows(0);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbFluxoCliente.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(11).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(12).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(13).setCellRenderer(centerRenderer);
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT * FROM notaservico ORDER BY datahora ASC;");
            rs = pstm.executeQuery();

            NumberFormat currencyPreco = NumberFormat.getCurrencyInstance();
            NumberFormat currencyPeso = NumberFormat.getCurrencyInstance();
            NumberFormat currencyTotal = NumberFormat.getCurrencyInstance();
            NumberFormat currencyFrete = NumberFormat.getCurrencyInstance();
            NumberFormat currencyImposto = NumberFormat.getCurrencyInstance();
            NumberFormat currencyComissao = NumberFormat.getCurrencyInstance();
            NumberFormat currencyApgar = NumberFormat.getCurrencyInstance();

            while (rs.next()) {
                // Dentro do seu loop while
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dataHoraFormatada = dateFormat.format(rs.getTimestamp("datahora"));
                modelo.addRow(new Object[]{
                    dataHoraFormatada,
                    rs.getInt("id"),
                    rs.getString("prestador"),
                    rs.getString("tomador"),
                    rs.getString("descricao"),
                    rs.getString("quantidade"),
                    currencyPreco.format(rs.getDouble("precoproduto")),
                    currencyPeso.format(rs.getDouble("pesoproduto")),
                    currencyTotal.format(rs.getDouble("totalproduto")),
                    currencyFrete.format(rs.getDouble("freteproduto")),
                    currencyImposto.format(rs.getDouble("impostoproduto")),
                    currencyComissao.format(rs.getDouble("comissaoproduto")),
                    currencyApgar.format(rs.getDouble("apagarproduto")),
                    rs.getString("observacaonf"),});
            }
            Conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tamanhoTabela() {
        tbFluxoCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbFluxoCliente.getColumnModel().getColumn(1).setPreferredWidth(20);
        tbFluxoCliente.getColumnModel().getColumn(2).setPreferredWidth(70);
        tbFluxoCliente.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbFluxoCliente.getColumnModel().getColumn(4).setPreferredWidth(150);
        tbFluxoCliente.getColumnModel().getColumn(5).setPreferredWidth(40);
        tbFluxoCliente.getColumnModel().getColumn(6).setPreferredWidth(50);
        tbFluxoCliente.getColumnModel().getColumn(7).setPreferredWidth(50);
        tbFluxoCliente.getColumnModel().getColumn(8).setPreferredWidth(50);
        tbFluxoCliente.getColumnModel().getColumn(9).setPreferredWidth(50);
        tbFluxoCliente.getColumnModel().getColumn(10).setPreferredWidth(50);
        tbFluxoCliente.getColumnModel().getColumn(11).setPreferredWidth(50);
        tbFluxoCliente.getColumnModel().getColumn(12).setPreferredWidth(50);
        tbFluxoCliente.getColumnModel().getColumn(13).setPreferredWidth(50);
    }
    private void bgHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgHabilitarActionPerformed
        bgLocalizar.setEnabled(true);
        txtId.setEnabled(true);
        bgReimprimir.setEnabled(false);
        txtId.setText("");
        dasabilitarCampos();
        desativarBotoes();
        lblNomeTomador.setText("");
    }//GEN-LAST:event_bgHabilitarActionPerformed

    public void Limpar() {
        txtId.setText("");
    }
    private void bgLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgLocalizarActionPerformed
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String idText = txtId.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um ID válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int idDigitado = Integer.parseInt(idText);
            con = Conexao.getConnection();
            pstm = con.prepareStatement("SELECT * FROM notaservico where id = ? ");

            pstm.setInt(1, idDigitado);
            rs = pstm.executeQuery();

            if (rs.next()) {

                lblNomeTomador.setText(rs.getString("tomador"));
            } else {
                JOptionPane.showMessageDialog(null, "ID não encontrado", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um ID válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        bgHabilitar.setEnabled(true);
        bgReimprimir.setEnabled(true);
        btExcluir.setEnabled(true);
        txtId.setEnabled(false);
    }//GEN-LAST:event_bgLocalizarActionPerformed

    private void bgReimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgReimprimirActionPerformed
        Connection con = Conexao.getConnection();
        try {
            String caminhoRelatorio = "C:\\ADComercio\\Financeiro\\src\\Relatorios\\NotaServico\\RelatorioNotaServicoId.jasper";
            // Adicione o ID da nota como um parâmetro
            Map<String, Object> parametros = new HashMap<>();
            String notaIdStr = txtId.getText().trim();
            parametros.put("notaId", Integer.valueOf(notaIdStr));

            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, parametros, con);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        bgLocalizar.setEnabled(false);
        txtId.setEnabled(false);
        bgHabilitar.setEnabled(true);
    }//GEN-LAST:event_bgReimprimirActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            String idText = txtId.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um ID válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int idDigitado = Integer.parseInt(idText);
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                con = Conexao.getConnection();
                String sql = "DELETE FROM notaservico WHERE id = ?";
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, idDigitado);
                int rowsAffected = pstm.executeUpdate();
                // Verificar se algum registro foi excluído
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para excluir com o ID fornecido.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um ID válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        carregaTabela();
        lblNomeTomador.setText("");
        btExcluir.setEnabled(false);
        bgReimprimir.setEnabled(false);
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        String valor = txtPreco.getText().trim().replace(",", ".");
        String valorPeso = txtPeso.getText().trim().replace(",", ".");
        String valorCarga = txtMontante.getText().trim().replace(",", ".");
        String valorFrete = txtFrete.getText().trim().replace(",", ".");
        String valorImposto = txtImposto.getText().trim().replace(",", ".");
        String valorComissao = txtComissao.getText().trim().replace(",", ".");
        String valorApgar = txtMontanteDevido.getText().trim().replace(",", ".");

        NotaServicoFinal h = new NotaServicoFinal();
        NotaServicoDao dao = new NotaServicoDao();

        int index = tbFluxoCliente.getSelectedRow();

        h = dao.listarnotaServicoFinal().get(index);

        switch (JOptionPane.showConfirmDialog(null,
                " [--ALTERAÇÃO DE DADOS--] \n Dado Atual"
                + "\n Empresa:  " + h.getPrestador()
                + "\n Cliente:  " + h.getTomador()
                + "\n Descricação: " + h.getDescricao()
                + "\n Obs: " + h.getObservacaoNotaServicoFinal()
                + "\n Qtd: " + h.getQuantidade()
                + "\n Preço: " + h.getPrecoProduto()
                + "\n Peso R$: " + h.getPesoproduto()
                + "\n Total Carga : " + h.getTotalProduto()
                + "\n Frete: " + h.getFreteProduto()
                + "\n Imposto: " + h.getImpostoProduto()
                + "\n Comissão: " + h.getComissaoProduto()
                + "\n Apagar: " + h.getApagarProduto()
                + "\n Será alterado"
                + "\n Empresa:  " + txtPrestador.getText()
                + "\n Cliente:  " + txtTomador.getText()
                + "\n Descricação: " + txtDescricao.getText()
                + "\n Obs: " + txtObs.getText()
                + "\n Qtd: " + txtQuant.getText()
                + "\n Preço: " + txtPreco.getText()
                + "\n Peso R$: " + txtPeso.getText()
                + "\n Total Carga : " + txtMontante.getText()
                + "\n Frete: " + txtFrete.getText()
                + "\n Imposto: " + txtImposto.getText()
                + "\n Comissão: " + txtComissao.getText()
                + "\n Apagar: " + txtMontanteDevido.getText()
                + "\n Deseja realmente fazer alteração?",
                "Alteração de dados.  ", JOptionPane.YES_NO_OPTION)) {
            case 0:

                h.setPrestador(txtPrestador.getText());
                h.setTomador(txtTomador.getText());
                h.setDescricao(txtDescricao.getText());
                h.setQuantidade(Integer.parseInt(txtQuant.getText()));
                h.setPrecoProduto(Double.parseDouble(valor));
                h.setPesoproduto(Double.parseDouble(valorPeso));
                h.setTotalProduto(Double.parseDouble(valorCarga));
                h.setFreteProduto(Double.parseDouble(valorFrete));
                h.setImpostoProduto(Double.parseDouble(valorImposto));
                h.setComissaoProduto(Double.parseDouble(valorComissao));
                h.setApagarProduto(Double.parseDouble(valorApgar));
                h.setObservacaoNotaServicoFinal(txtObs.getText());

                dao.alterar(h);// faz alteração no banco de dados
                carregaTabela();
                LimparCampos();
                desativarBotao();
                desativarBotoes();
                dasabilitarCampos();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nenhuma alteração foi feita.",
                        "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void tbFluxoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFluxoClienteMouseClicked
        habilitarCampos();
        btExcluir.setEnabled(false);
        btAlterar.setEnabled(true);
        bgLocalizar.setEnabled(false);
        txtId.setEnabled(false);
        NotaServicoFinal h = new NotaServicoFinal();
        NotaServicoDao dao = new NotaServicoDao();

        int index = tbFluxoCliente.getSelectedRow();
        h = dao.listarnotaServicoFinal().get(index);

        txtPrestador.setText(h.getPrestador());
        txtTomador.setText(h.getTomador());
        txtDescricao.setText(h.getDescricao());
        txtComissao.setText(Double.toString(h.getComissaoProduto()));
        txtFrete.setText(Double.toString(h.getFreteProduto()));
        txtImposto.setText(Double.toString(h.getImpostoProduto()));
        txtMontante.setText(Double.toString(h.getTotalProduto()));
        txtMontanteDevido.setText(Double.toString(h.getApagarProduto()));
        txtPeso.setText(Double.toString(h.getPesoproduto()));
        txtPreco.setText(Double.toString(h.getPrecoProduto()));
        txtQuant.setText(Integer.toString(h.getQuantidade()));
        txtObs.setText(h.getObservacaoNotaServicoFinal());

    }//GEN-LAST:event_tbFluxoClienteMouseClicked
    public void LimparCampos() {
        txtPrestador.setText("");
        txtComissao.setText("");
        txtDescricao.setText("");
        txtTomador.setText("");
        txtFrete.setText("");
        txtImposto.setText("");
        txtMontante.setText("");
        txtMontanteDevido.setText("");
        txtPeso.setText("");
        txtPreco.setText("");
        txtQuant.setText("");
        txtObs.setText("");
    }

    public void habilitarCampos() {
        txtPrestador.setEnabled(true);
        txtComissao.setEnabled(true);
        txtDescricao.setEnabled(true);
        txtTomador.setEnabled(true);
        txtFrete.setEnabled(true);
        txtImposto.setEnabled(true);
        txtMontante.setEnabled(true);
        txtMontanteDevido.setEnabled(true);
        txtPeso.setEnabled(true);
        txtPreco.setEnabled(true);
        txtQuant.setEnabled(true);
        txtObs.setEnabled(true);
    }

    private void dasabilitarCampos() {
        txtPrestador.setEnabled(false);
        txtComissao.setEnabled(false);
        txtDescricao.setEnabled(false);
        txtTomador.setEnabled(false);
        txtFrete.setEnabled(false);
        txtImposto.setEnabled(false);
        txtMontante.setEnabled(false);
        txtMontanteDevido.setEnabled(false);
        txtPeso.setEnabled(false);
        txtPreco.setEnabled(false);
        txtQuant.setEnabled(false);
        txtObs.setEnabled(false);
    }

    public void HabilitarBotao() {
        bgLocalizar.setEnabled(true);
    }

    public void desativarBotao() {
        bgLocalizar.setEnabled(false);
        bgReimprimir.setEnabled(false);
    }

    public void desativarBotoes() {
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }

    public void ativarBotoes() {
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bgHabilitar;
    private javax.swing.JButton bgLocalizar;
    private javax.swing.JButton bgReimprimir;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
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
    private javax.swing.JLabel lblNomeTomador;
    private javax.swing.JTable tbFluxoCliente;
    private javax.swing.JTextField txtComissao;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtFrete;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtImposto;
    private javax.swing.JTextField txtMontante;
    private javax.swing.JTextField txtMontanteDevido;
    private javax.swing.JTextField txtObs;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtPrestador;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JTextField txtTomador;
    // End of variables declaration//GEN-END:variables
}
