package financeiro.View.NotaServico;

import financeiro.DAO.NotaServicoDao;
import financeiro.conexao.Conexao;
import financeiro.model.NotaServicoFinal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class FrmNotaServico extends javax.swing.JInternalFrame {

    public FrmNotaServico() {
        initComponents();
        CarregarId();
        CentralizarJTextFields();
        dasabilitarCampos();
        DesativarBotao();
        bgNovo.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bgHabilitar = new javax.swing.JButton();
        bgGravar = new javax.swing.JButton();
        bgEmitir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPrestador = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTomador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtQuant = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMontante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFrete = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtImposto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtComissao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMontanteDevido = new javax.swing.JTextField();
        bgNovo = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Emissão Nota de Serviço");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        bgHabilitar.setText("Habilitar");
        bgHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgHabilitarActionPerformed(evt);
            }
        });

        bgGravar.setText("Gravar");
        bgGravar.setNextFocusableComponent(bgEmitir);
        bgGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgGravarActionPerformed(evt);
            }
        });

        bgEmitir.setText("Emitir");
        bgEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgEmitirActionPerformed(evt);
            }
        });

        jLabel1.setText("Empresa.:");

        txtPrestador.setNextFocusableComponent(txtTomador);

        jLabel2.setText("Cliente.:");

        txtTomador.setNextFocusableComponent(txtDescricao);

        jLabel3.setText("Quant.:");

        jLabel4.setText("Preço.:");

        txtPreco.setNextFocusableComponent(txtPeso);

        jLabel5.setText("Peso.:");

        txtPeso.setNextFocusableComponent(txtMontante);

        jLabel6.setText("Descrição.:");

        txtDescricao.setNextFocusableComponent(txtQuant);

        jLabel7.setText("T.Carga.:");

        txtMontante.setNextFocusableComponent(txtFrete);

        jLabel8.setText("Frete.:");

        txtFrete.setText(" ");
        txtFrete.setNextFocusableComponent(txtImposto);

        jLabel9.setText("Imposto.:");

        txtImposto.setNextFocusableComponent(txtComissao);

        jLabel10.setText("Comissão.:");

        txtComissao.setText(" ");
        txtComissao.setNextFocusableComponent(txtMontanteDevido);

        jLabel11.setText("A pagar.:");

        txtMontanteDevido.setText(" ");
        txtMontanteDevido.setNextFocusableComponent(bgGravar);

        bgNovo.setText("Novo");
        bgNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgNovoActionPerformed(evt);
            }
        });

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTomador))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
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
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(bgHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(bgNovo)
                            .addGap(31, 31, 31)
                            .addComponent(bgGravar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bgEmitir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMontante, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bgHabilitar)
                    .addComponent(bgGravar)
                    .addComponent(bgEmitir)
                    .addComponent(bgNovo)
                    .addComponent(lblId))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTomador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtMontante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtImposto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtMontanteDevido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bgHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgHabilitarActionPerformed
        bgNovo.setEnabled(true);
    }//GEN-LAST:event_bgHabilitarActionPerformed
    private void bgGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgGravarActionPerformed
        //Verificar se os campos estão vazios
        if (txtPrestador.getText().isEmpty()
                || txtTomador.getText().isEmpty()
                || txtDescricao.getText().isEmpty()
                || txtQuant.getText().isEmpty()
                || txtPreco.getText().isEmpty()
                || txtPeso.getText().isEmpty()
                || txtMontante.getText().isEmpty()
                || txtFrete.getText().isEmpty()
                || txtImposto.getText().isEmpty()
                || txtComissao.getText().isEmpty()
                || txtMontanteDevido.getText().isEmpty()) {
            //exibir aviso para inserir todos os dados
            JOptionPane.showMessageDialog(null, "Por favor, insira todos os dados antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            NotaServicoFinal h = new NotaServicoFinal();
            NotaServicoDao dao = new NotaServicoDao();
            h.setPrestador(txtPrestador.getText());
            h.setTomador(txtTomador.getText());
            h.setDescricao(txtDescricao.getText());
            h.setQuantidade(Integer.parseInt(txtQuant.getText()));
            h.setPrecoProduto(Double.parseDouble(txtPreco.getText()));
            h.setPesoproduto(Double.parseDouble(txtPeso.getText()));
            h.setTotalProduto(Double.parseDouble(txtMontante.getText()));
            h.setFreteProduto(Double.parseDouble(txtFrete.getText()));
            h.setImpostoProduto(Double.parseDouble(txtImposto.getText()));
            h.setComissaoProduto(Double.parseDouble(txtComissao.getText()));
            h.setApagarProduto(Double.parseDouble(txtMontanteDevido.getText()));
            dao.adicionar(h);
            CarregarId();
            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Nota de serviço adicionado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            bgNovo.setEnabled(false);
            bgEmitir.setEnabled(true);
            dasabilitarCampos();
        }
    }//GEN-LAST:event_bgGravarActionPerformed
    private void bgEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgEmitirActionPerformed
        Connection con = Conexao.getConnection();
        try {
            String caminhoRelatorio = "C:\\ADComercio\\Financeiro\\src\\Relatorios\\NotaServico\\RelatorioNotaServico.jasper";
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("nomePrestador", txtPrestador.getText());
            parametros.put("nomeTomador", txtTomador.getText());
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, parametros, con);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
        dasabilitarCampos();
        bgGravar.setEnabled(false);
        bgHabilitar.setEnabled(true);
    }//GEN-LAST:event_bgEmitirActionPerformed
    private void bgNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgNovoActionPerformed
        bgGravar.setEnabled(true);
        bgHabilitar.setEnabled(false);
        habilitarCampos();
        LimparCampos();
    }//GEN-LAST:event_bgNovoActionPerformed

    public void CarregarId() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.getConnection();
            // Execute a consulta SQL para obter o ID mais recente
            pstm = con.prepareStatement("SELECT MAX(id) AS max_id FROM notaservico;");
            rs = pstm.executeQuery();
            if (rs.next()) {
                // Obtenha o ID mais recente da consulta
                int id = rs.getInt("max_id");
                // Exiba o ID no seu Label (substitua "seuLabel" pelo nome real do seu Label)
                lblId.setText("ID: " + id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmNotaServico.class.getName()).log(Level.SEVERE, null, ex);
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
    }

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
    }

    private void CentralizarJTextFields() {
        txtPrestador.setHorizontalAlignment(SwingConstants.CENTER);
        txtComissao.setHorizontalAlignment(SwingConstants.CENTER);
        txtDescricao.setHorizontalAlignment(SwingConstants.CENTER);
        txtTomador.setHorizontalAlignment(SwingConstants.CENTER);
        txtFrete.setHorizontalAlignment(SwingConstants.CENTER);
        txtImposto.setHorizontalAlignment(SwingConstants.CENTER);
        txtMontante.setHorizontalAlignment(SwingConstants.CENTER);
        txtMontanteDevido.setHorizontalAlignment(SwingConstants.CENTER);
        txtPeso.setHorizontalAlignment(SwingConstants.CENTER);
        txtPreco.setHorizontalAlignment(SwingConstants.CENTER);
        txtQuant.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void HabilitarBotao() {
        bgEmitir.setEnabled(true);
        bgGravar.setEnabled(true);
    }

    public void DesativarBotao() {
        bgEmitir.setEnabled(false);
        bgGravar.setEnabled(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bgEmitir;
    private javax.swing.JButton bgGravar;
    private javax.swing.JButton bgHabilitar;
    private javax.swing.JButton bgNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtComissao;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtFrete;
    private javax.swing.JTextField txtImposto;
    private javax.swing.JTextField txtMontante;
    private javax.swing.JTextField txtMontanteDevido;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtPrestador;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JTextField txtTomador;
    // End of variables declaration//GEN-END:variables
}
