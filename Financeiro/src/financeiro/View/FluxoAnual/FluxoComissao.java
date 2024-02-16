package financeiro.View.FluxoAnual;

import financeiro.conexao.Conexao;
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

public class FluxoComissao extends javax.swing.JInternalFrame {

    public FluxoComissao() {
        initComponents();
        carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbComissao = new javax.swing.JTable();
        lbTotalComiss = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Fluxo Comissão");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btImprimir.setText("Imprimir");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        tbComissao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Hora", "Cliente", "Empresa", "Data Pedido", "Data Entrega", "Preço Nota", "Preço Pag", "Comissão"
            }
        ));
        tbComissao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbComissaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbComissao);

        lbTotalComiss.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTotalComiss.setText("0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btImprimir)
                        .addGap(68, 68, 68)
                        .addComponent(lbTotalComiss)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btImprimir)
                    .addComponent(lbTotalComiss))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        Connection con = Conexao.getConnection();
        try {
            String arq = "C:\\ADComercio\\Financeiro\\src\\Relatorios\\Fluxo\\RelatorioComissao.jasper";
            Map<String, Object> parametros = new HashMap<>();
            JasperPrint jaspertPrint = JasperFillManager.fillReport(arq, parametros, con);
            JasperViewer view = new JasperViewer(jaspertPrint, false);
            view.setVisible(true);
        } catch (JRException ex) {
            System.out.println("Erro:" + ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btImprimirActionPerformed

    private void tbComissaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbComissaoMouseClicked

    }//GEN-LAST:event_tbComissaoMouseClicked

    private void tamanhoTabela() {
        tbComissao.getColumnModel().getColumn(0).setPreferredWidth(130);
        tbComissao.getColumnModel().getColumn(1).setPreferredWidth(250);
        tbComissao.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbComissao.getColumnModel().getColumn(3).setPreferredWidth(90);
        tbComissao.getColumnModel().getColumn(4).setPreferredWidth(90);
        tbComissao.getColumnModel().getColumn(5).setPreferredWidth(90);
        tbComissao.getColumnModel().getColumn(6).setPreferredWidth(90);
    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbComissao.getModel();
        modelo.setNumRows(0);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tbComissao.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbComissao.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbComissao.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbComissao.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tbComissao.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbComissao.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        // Configurar a tabela como não editável
        tbComissao.setDefaultEditor(Object.class, null);

        tamanhoTabela();
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            String sqlSomaTotalComissao = "SELECT SUM(valorcomissao) AS totalComissao FROM comissao";
            pstm = con.prepareStatement(sqlSomaTotalComissao);
            rs = pstm.executeQuery();

            double totalComissao = 0.0;
            if (rs.next()) {
                totalComissao = rs.getDouble("totalComissao");
            }
            lbTotalComiss.setText("Soma Total de Comissão R$:   " + NumberFormat.getCurrencyInstance().format(totalComissao));
            pstm = con.prepareStatement("SELECT * from comissao ORDER BY  nome ASC;");
            rs = pstm.executeQuery();

            NumberFormat currencyPrecoCheia = NumberFormat.getCurrencyInstance();
            NumberFormat currencyPrecoFabrica = NumberFormat.getCurrencyInstance();
            NumberFormat currencyValorComissao = NumberFormat.getCurrencyInstance();

            while (rs.next()) {

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dataPedidoFormatada = dateFormat.format(rs.getTimestamp("datapedido"));
                String dataEntregaFormatada = dateFormat.format(rs.getTimestamp("dataentrega"));

                modelo.addRow(new Object[]{
                    rs.getString("datahora"),
                    rs.getString("nome"),
                    rs.getString("empresa"),
                    dataPedidoFormatada,
                    dataEntregaFormatada,
                    //rs.getDate("datapedido"),
                    //rs.getDate("dataentrega"),
                    currencyPrecoCheia.format(rs.getDouble("precocheia")),
                    currencyPrecoFabrica.format(rs.getDouble("precofabrica")),
                    currencyValorComissao.format(rs.getDouble("valorcomissao")),});
            }
            Conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImprimir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTotalComiss;
    private javax.swing.JTable tbComissao;
    // End of variables declaration//GEN-END:variables
}
