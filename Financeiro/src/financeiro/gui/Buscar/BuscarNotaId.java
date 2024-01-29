package financeiro.gui.Buscar;

import financeiro.conexao.Conexao;
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

public class BuscarNotaId extends javax.swing.JInternalFrame {

    public BuscarNotaId() {
        initComponents();
        carregaTabela();
         CentralizarCampos();
        desativarBotao();
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
        lblTomador = new javax.swing.JLabel();
        bgLocalizar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFluxoCliente = new javax.swing.JTable();

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

        lblTomador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTomador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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
                "Data", "ID", "Prestador", "Tomador", "Descrição", "Qtd", "Preço", "Peso", "Apagar", "Frete", "Imposto", "Comissão", "Total NS"
            }
        ));
        jScrollPane1.setViewportView(tbFluxoCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(bgLocalizar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bgHabilitar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTomador, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir)
                        .addGap(56, 56, 56)
                        .addComponent(bgReimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 556, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bgHabilitar)
                        .addComponent(bgReimprimir)
                        .addComponent(bgLocalizar)
                        .addComponent(btExcluir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTomador, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
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
 private void CentralizarCampos() {
        txtId.setHorizontalAlignment(SwingConstants.CENTER);
    }
    private void tamanhoTabela() {
        //Defini o tamanho da tabela
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
    }

    private void carregaTabela() {

        tamanhoTabela();
        DefaultTableModel modelo = (DefaultTableModel) tbFluxoCliente.getModel();
        modelo.setNumRows(0);
        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tbFluxoCliente.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(11).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(12).setCellRenderer(centerRenderer);

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
                modelo.addRow(new Object[]{
                    rs.getString("datahora"),
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
                    currencyApgar.format(rs.getDouble("apagarproduto")),});
            }
            Conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void bgHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgHabilitarActionPerformed
        bgLocalizar.setEnabled(true);
        txtId.setEnabled(true);
        bgReimprimir.setEnabled(false);
        txtId.setText("");
    }//GEN-LAST:event_bgHabilitarActionPerformed
    public void Limpar() {
        txtId.setText("");
    }
    private void bgLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgLocalizarActionPerformed
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            // Obter o ID digitado no campo de texto e remover espaços em branco
            String idText = txtId.getText().trim();
            // Verificar se o campo não está vazio
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um ID válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Obter o ID digitado no campo de texto
            int idDigitado = Integer.parseInt(idText);

            // Estabelecer a conexão com o banco de dados
            con = Conexao.getConnection();

            // Execute a consulta SQL para obter o ID mais recente
            pstm = con.prepareStatement("SELECT * FROM notaservico where id = ? ");
            pstm.setInt(1, idDigitado);

            // Executar a consulta
            rs = pstm.executeQuery();
            // Verificar se há resultados
            if (rs.next()) {
                // Exibir o nome da empresa no lbTomador
                lblTomador.setText(rs.getString("tomador"));
            } else {
                // Se não houver resultados, exibir uma mensagem informando que o ID não foi encontrado
                JOptionPane.showMessageDialog(null, "ID não encontrado", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Remova ou ajuste conforme necessário
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um ID válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Remova ou ajuste conforme necessário
        } finally {
            // Fechar os recursos (ResultSet, PreparedStatement e Connection) no bloco finally para garantir a liberação adequada

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
                // Lidar com erros de fechamento, se necessário
                e.printStackTrace();
            }
        }
        bgHabilitar.setEnabled(true);
        bgReimprimir.setEnabled(true);
        txtId.setEnabled(false);
    }//GEN-LAST:event_bgLocalizarActionPerformed

    private void bgReimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgReimprimirActionPerformed
        Connection con = Conexao.getConnection();
        try {
            String caminhoRelatorio = "C:\\ADComercio\\Financeiro\\src\\RelatorioNotaServico\\RelatorioNotaServicoId.jasper";

            // Adicione o ID da nota como um parâmetro
            Map<String, Object> parametros = new HashMap<>();

            // Utilize trim() para remover espaços em branco antes e depois do valor
            String notaIdStr = txtId.getText().trim();

            parametros.put("notaId", Integer.valueOf(notaIdStr));

            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, parametros, con);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);

        } catch (JRException ex) {
            // Exiba a mensagem de erro usando JOptionPane
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
                // Usuário escolheu "Sim", então proceda com a exclusão
                con = Conexao.getConnection();

                String sql = "DELETE FROM notaservico WHERE id = ?";

                pstm = con.prepareStatement(sql);
                pstm.setInt(1, idDigitado);

                int rowsAffected = pstm.executeUpdate();

                // Verificar se algum registro foi excluído
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    // Limpar campos ou realizar outras ações necessárias após a exclusão
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para excluir com o ID fornecido.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                // Usuário escolheu "Não" ou fechou a caixa de diálogo, então não faça nada
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Remova ou ajuste conforme necessário
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um ID válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Remova ou ajuste conforme necessário
        } finally {
            // Fechar os recursos (PreparedStatement e Connection) no bloco finally para garantir a liberação adequada
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // Lidar com erros de fechamento, se necessário
                e.printStackTrace();
            }
        }
        carregaTabela();
    }//GEN-LAST:event_btExcluirActionPerformed
    public void HabilitarBotao() {
        bgLocalizar.setEnabled(true);
    }

    public void desativarBotao() {
        bgLocalizar.setEnabled(false);
        bgReimprimir.setEnabled(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bgHabilitar;
    private javax.swing.JButton bgLocalizar;
    private javax.swing.JButton bgReimprimir;
    private javax.swing.JButton btExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTomador;
    private javax.swing.JTable tbFluxoCliente;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
