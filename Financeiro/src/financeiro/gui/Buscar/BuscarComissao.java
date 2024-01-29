package financeiro.gui.Buscar;

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

public class BuscarComissao extends javax.swing.JInternalFrame {

    public BuscarComissao() {
        initComponents();
        desabilitarBotoes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPagamentoF = new javax.swing.JTable();
        dateChooserInicioP = new com.toedter.calendar.JDateChooser();
        dateChooserFimP = new com.toedter.calendar.JDateChooser();
        btPagamentoF = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btgGerarRelatorio = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Localizar Comissão\n");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbPagamentoF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Hora", "Cliente", "Empresa", "Data Pedido", "Data Entrega", "Preço Nota", "Preço Pag", "Comissão"
            }
        ));
        tbPagamentoF.setEnabled(false);
        jScrollPane2.setViewportView(tbPagamentoF);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, 1020, 330));
        jPanel2.add(dateChooserInicioP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 129, -1));
        jPanel2.add(dateChooserFimP, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 129, -1));

        btPagamentoF.setText("Procurar Registro");
        btPagamentoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPagamentoFActionPerformed(evt);
            }
        });
        jPanel2.add(btPagamentoF, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 150, 30));

        jLabel1.setText("Data Inicial");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 80, -1));

        jLabel2.setText("Data Final");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 56, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, 1020, 10));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 14, 95));

        btgGerarRelatorio.setText("Imprimir");
        btgGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btgGerarRelatorioActionPerformed(evt);
            }
        });
        jPanel2.add(btgGerarRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 110, 30));

        jButton1.setText("Nova Pesquisa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private Timestamp dataInicio;
    private Timestamp dataFim;
    private void btPagamentoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPagamentoFActionPerformed
        if (dateChooserInicioP.getDate() == null || dateChooserFimP.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione as datas inicial e final antes de realizar a pesquisa.", "Datas não Selecionadas", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tbPagamentoF.getModel();
        model.setRowCount(0);

        TableColumnModel columnModel = tbPagamentoF.getColumnModel();
        /* columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(50);
         */

        columnModel.getColumn(0).setPreferredWidth(130);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(90);
        columnModel.getColumn(4).setPreferredWidth(90);
        columnModel.getColumn(5).setPreferredWidth(90);
        columnModel.getColumn(6).setPreferredWidth(90);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tbPagamentoF.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        // tbComissao.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbPagamentoF.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbPagamentoF.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbPagamentoF.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tbPagamentoF.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbPagamentoF.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

        try (Connection con = Conexao.getConnection()) {
            String sql = "SELECT * FROM comissao WHERE (datahora BETWEEN ? AND ?) OR (datahora BETWEEN ? AND ?)ORDER BY datahora ASC";

            // Formatando o valor no campo da jTable
            NumberFormat currencyValorCheio = NumberFormat.getCurrencyInstance();
            NumberFormat currencyValorFabrica = NumberFormat.getCurrencyInstance();
            NumberFormat currencyValorComiss = NumberFormat.getCurrencyInstance();

            // Armazene as datas de início e fim para uso posterior
            dataInicio = new java.sql.Timestamp(dateChooserInicioP.getDate().getTime());
            dataFim = new java.sql.Timestamp(dateChooserFimP.getDate().getTime());

            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setObject(1, new java.sql.Timestamp(dateChooserInicioP.getDate().getTime()));
                pst.setObject(2, new java.sql.Timestamp(dateChooserFimP.getDate().getTime()));
                pst.setObject(3, new java.sql.Timestamp(dateChooserInicioP.getDate().getTime()));
                pst.setObject(4, new java.sql.Timestamp(dateChooserFimP.getDate().getTime()));

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
                                rs.getObject("nome"),
                                rs.getObject("empresa"),
                                rs.getObject("datapedido"),
                                rs.getObject("dataentrega"),
                                currencyValorCheio.format(rs.getDouble("precocheia")),
                                currencyValorFabrica.format(rs.getDouble("precofabrica")),
                                currencyValorComiss.format(rs.getDouble("valorcomissao"))
                            });
                        } while (rs.next());
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btPagamentoFActionPerformed

    private void btgGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btgGerarRelatorioActionPerformed
        Connection con = Conexao.getConnection();

        try {
            String arq = "C:\\ADComercio\\Financeiro\\src\\Relatorio\\RelatorioComissao.jasper";
            Map<String, Object> parametros = new HashMap<>();

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
    }//GEN-LAST:event_btgGerarRelatorioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        habilitarBotoes();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void habilitarBotoes() {

        dateChooserInicioP.setEnabled(true);
        dateChooserFimP.setEnabled(true);
        btPagamentoF.setEnabled(true);
        btgGerarRelatorio.setEnabled(true);
    }

    private void desabilitarBotoes() {

        dateChooserInicioP.setEnabled(false);
        dateChooserFimP.setEnabled(false);
        btPagamentoF.setEnabled(false);
        btgGerarRelatorio.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPagamentoF;
    private javax.swing.JButton btgGerarRelatorio;
    private com.toedter.calendar.JDateChooser dateChooserFimP;
    private com.toedter.calendar.JDateChooser dateChooserInicioP;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbPagamentoF;
    // End of variables declaration//GEN-END:variables
}
