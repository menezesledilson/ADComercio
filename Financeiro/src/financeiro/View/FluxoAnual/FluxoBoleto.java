package financeiro.View.FluxoAnual;

import financeiro.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class FluxoBoleto extends javax.swing.JInternalFrame {

    public FluxoBoleto() {
        initComponents();
        carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFluxoBoleto = new javax.swing.JTable();
        btImprimir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Fluxo Livro Boletos");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tbFluxoBoleto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Data Receber", "Valor Receber", "Empresa", "Data a Pagar", "Valor a Pagar", "Status", "NF.", "Obs."
            }
        ));
        jScrollPane1.setViewportView(tbFluxoBoleto);

        btImprimir.setText("Imprimir");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btImprimir)
                .addContainerGap(899, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        //PreparedStatement pstm = null;
        try {
            String arq = "C:\\ADComercio\\Financeiro\\src\\Relatorios\\Fluxo\\RelatorioBoleto.jasper";
            Map<String, Object> parametros = new HashMap<>();

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
    }//GEN-LAST:event_btImprimirActionPerformed

    private void tamanhoTabela() {
        //Defini o tamanho da tabela
        tbFluxoBoleto.getColumnModel().getColumn(0).setPreferredWidth(170);
        tbFluxoBoleto.getColumnModel().getColumn(1).setPreferredWidth(60);
        tbFluxoBoleto.getColumnModel().getColumn(2).setPreferredWidth(60);
        tbFluxoBoleto.getColumnModel().getColumn(3).setPreferredWidth(80);
        tbFluxoBoleto.getColumnModel().getColumn(4).setPreferredWidth(60);
        tbFluxoBoleto.getColumnModel().getColumn(5).setPreferredWidth(60);
        tbFluxoBoleto.getColumnModel().getColumn(6).setPreferredWidth(50);
        tbFluxoBoleto.getColumnModel().getColumn(7).setPreferredWidth(50);
        tbFluxoBoleto.getColumnModel().getColumn(8).setPreferredWidth(50);
    }

    private void carregaTabela() {

        tamanhoTabela();
        DefaultTableModel modelo = (DefaultTableModel) tbFluxoBoleto.getModel();
        modelo.setNumRows(0);

        // Configurar a tabela como não editável
        tbFluxoBoleto.setDefaultEditor(Object.class, null);

        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar o renderizador às colunas de valorpedido (índice 1) e quantidadebobina (índice 2)
        tbFluxoBoleto.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbFluxoBoleto.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbFluxoBoleto.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbFluxoBoleto.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tbFluxoBoleto.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbFluxoBoleto.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tbFluxoBoleto.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        tbFluxoBoleto.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        try {

            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT * FROM boletoEmpresa ORDER BY id DESC;");
            rs = pstm.executeQuery();

            //Formatar o valor no campo jtable
            NumberFormat currencyReceber = NumberFormat.getCurrencyInstance();
            NumberFormat currencyApagar = NumberFormat.getCurrencyInstance();

            while (rs.next()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                String dataFormatadaReceber = "";
                Date dataReceber = rs.getDate("databoletoreceber");
                if (dataReceber != null) {
                    dataFormatadaReceber = dateFormat.format(dataReceber);
                }

                String dataFormatadaPagar = "";
                Date dataPagar = rs.getDate("databoletoapagar");
                if (dataPagar != null) {
                    dataFormatadaPagar = dateFormat.format(dataPagar);
                }
                modelo.addRow(new Object[]{
                    rs.getString("nomeboletoreceber"),
                    dataFormatadaReceber,
                    currencyReceber.format(rs.getDouble("valorboletoreceber")),
                    rs.getString("nomeboletoapagar"),
                    dataFormatadaPagar,
                    currencyApagar.format(rs.getDouble("valorboletoapagar")),
                    rs.getString("statuspago"),
                    rs.getString("numeronota"),
                    rs.getString("observacao")});
            }
            Conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImprimir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFluxoBoleto;
    // End of variables declaration//GEN-END:variables
}
