package financeiro.View.Buscar;

import financeiro.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class BuscaLivroCaixa extends javax.swing.JInternalFrame {

    public BuscaLivroCaixa() {
        initComponents();
        desabilitarBotoes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBuscarLivroCaixa = new javax.swing.JTable();
        dateChooserFimCaixa = new com.toedter.calendar.JDateChooser();
        dateChooserInicioCaixa = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btPesquisa = new javax.swing.JButton();
        btBuscarLivroCaixa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Localizar Livro Caixa");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbBuscarLivroCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Descrição", "Entrada", "Saída"
            }
        ));
        jScrollPane1.setViewportView(tbBuscarLivroCaixa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 750, 400));
        jPanel1.add(dateChooserFimCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 130, -1));
        jPanel1.add(dateChooserInicioCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, -1));

        jLabel1.setText("Data Final");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jLabel2.setText("Data Inicial");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 10, 90));

        btPesquisa.setText("Nova Pesquisa");
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 140, 30));

        btBuscarLivroCaixa.setText("Procurar Registro");
        btBuscarLivroCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarLivroCaixaActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscarLivroCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 140, 30));

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        // TODO add your handling code here:
        habilitarBotoes();
    }//GEN-LAST:event_btPesquisaActionPerformed

    private void habilitarBotoes() {

        dateChooserInicioCaixa.setEnabled(true);
        dateChooserFimCaixa.setEnabled(true);
        btBuscarLivroCaixa.setEnabled(true);

    }

    private void desabilitarBotoes() {

        dateChooserInicioCaixa.setEnabled(false);
        dateChooserFimCaixa.setEnabled(false);
        btBuscarLivroCaixa.setEnabled(false);
        // btPesquisa.setEnabled(false);

    }
    private Timestamp dataInicio;
    private Timestamp dataFim;

    private void btBuscarLivroCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarLivroCaixaActionPerformed
        // Verificar se as datas inicial e final estão selecionadas
        if (dateChooserInicioCaixa.getDate() == null || dateChooserFimCaixa.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione as datas inicial e final antes de realizar a pesquisa.", "Datas não Selecionadas", JOptionPane.WARNING_MESSAGE);
            return; // Abortar a operação se as datas não estiverem selecionadas
        }

        DefaultTableModel model = (DefaultTableModel) tbBuscarLivroCaixa.getModel();

        TableColumnModel columnModel = tbBuscarLivroCaixa.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(10);  // Largura em pixels
        columnModel.getColumn(1).setPreferredWidth(20);
        columnModel.getColumn(2).setPreferredWidth(20);
        columnModel.getColumn(3).setPreferredWidth(10);

        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar o renderizador às colunas de valorpedido (índice 1) e quantidadebobina (índice 2)
        tbBuscarLivroCaixa.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbBuscarLivroCaixa.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbBuscarLivroCaixa.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        try (Connection con = Conexao.getConnection()) {
            String sql = "SELECT * FROM caixa WHERE (datahora BETWEEN ? AND ?) OR (datahora BETWEEN ? AND ?) ORDER BY datahora ASC";

            //Formatar o valor no campo jtable
            NumberFormat currencyValorEntrada = NumberFormat.getCurrencyInstance();
            NumberFormat currencyValorSaida = NumberFormat.getCurrencyInstance();

            // Armazene as datas de início e fim para uso posterior
            dataInicio = new java.sql.Timestamp(dateChooserInicioCaixa.getDate().getTime());
            dataFim = new java.sql.Timestamp(dateChooserFimCaixa.getDate().getTime());

            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setObject(1, new java.sql.Timestamp(dateChooserInicioCaixa.getDate().getTime()));
                pst.setObject(2, new java.sql.Timestamp(dateChooserFimCaixa.getDate().getTime()));
                pst.setObject(3, new java.sql.Timestamp(dateChooserInicioCaixa.getDate().getTime()));
                pst.setObject(4, new java.sql.Timestamp(dateChooserFimCaixa.getDate().getTime()));

                //linha para testar a consultar
                //  System.out.println("SQL: " + pst.toString());
                try (ResultSet rs = pst.executeQuery()) {
                    if (!rs.next()) {
                        //ResultSet está vazio, exibir mensagem
                        JOptionPane.showMessageDialog(this, "Consulta não encontrou dados com a data inicial e final fornecida.", "Sem Resultados", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Limpar todas as linhas existentes na tabela
                        model.setRowCount(0);
                        do {
                            model.addRow(new Object[]{
                                rs.getObject("datahora"),
                                rs.getObject("descricao"),
                                //  rs.getObject("entrada"),
                                currencyValorEntrada.format(rs.getDouble("entrada")),
                                //rs.getObject("saida"),
                                currencyValorSaida.format(rs.getDouble("saida")),});
                        } while (rs.next());

                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btBuscarLivroCaixaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection con = Conexao.getConnection();
        //PreparedStatement pstm = null;
        try {
            String arq = "C:\\ADComercio\\Financeiro\\src\\Relatorios\\Mensal\\RelatorioLivroCaixa.jasper";
            Map<String, Object> parametros = new HashMap<>();

            // Use as datas de início e fim armazenadas como parâmetros
            if (dataInicio != null) {
                parametros.put("DataIn", new java.sql.Timestamp(dataInicio.getTime()));
            }
            if (dataFim != null) {
                parametros.put("DataFin", new java.sql.Timestamp(dataFim.getTime()));
            }

            JasperPrint jaspertPrint = JasperFillManager.fillReport(arq, parametros, con);
            JasperViewer view = new JasperViewer(jaspertPrint, false);
            view.setVisible(true);

        } catch (JRException ex) {
            System.out.println("Erro:" + ex);
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
        desabilitarBotoes();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarLivroCaixa;
    private javax.swing.JButton btPesquisa;
    private com.toedter.calendar.JDateChooser dateChooserFimCaixa;
    private com.toedter.calendar.JDateChooser dateChooserInicioCaixa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbBuscarLivroCaixa;
    // End of variables declaration//GEN-END:variables
}
