package financeiro.View.FluxoAnual;

import financeiro.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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

public class FluxoPedidoBobina extends javax.swing.JInternalFrame {

    public FluxoPedidoBobina() {
        initComponents();
        carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFluxoPedidoBobina = new javax.swing.JTable();
        lblTotalValor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbTotalBobina = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btImprimir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Fluxo Pedido Bobinas");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tbFluxoPedidoBobina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empresa", "Valor", "Qtd", "Data Pedido", "Data Entrega", "Cheque 1", "Cheque 2", "Cheque 3", "Forma Pag.", "Obs.", "Obs.2"
            }
        ));
        jScrollPane1.setViewportView(tbFluxoPedidoBobina);

        lblTotalValor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotalValor.setText("0.00");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Total Valor");

        lbTotalBobina.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTotalBobina.setText("0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText(" Total Bobina");

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
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTotalBobina)
                .addContainerGap(657, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalValor)
                    .addComponent(jLabel1)
                    .addComponent(lbTotalBobina)
                    .addComponent(jLabel2)
                    .addComponent(btImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            String arq = "C:\\ADComercio\\Financeiro\\src\\Relatorios\\Fluxo\\RelatorioPedidoBobina.jasper";
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
        tbFluxoPedidoBobina.getColumnModel().getColumn(0).setPreferredWidth(200);
        tbFluxoPedidoBobina.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbFluxoPedidoBobina.getColumnModel().getColumn(2).setPreferredWidth(50);

        tbFluxoPedidoBobina.getColumnModel().getColumn(3).setPreferredWidth(90);
        tbFluxoPedidoBobina.getColumnModel().getColumn(4).setPreferredWidth(90);

        tbFluxoPedidoBobina.getColumnModel().getColumn(5).setPreferredWidth(90);
        tbFluxoPedidoBobina.getColumnModel().getColumn(6).setPreferredWidth(90);
        tbFluxoPedidoBobina.getColumnModel().getColumn(7).setPreferredWidth(90);

        tbFluxoPedidoBobina.getColumnModel().getColumn(8).setPreferredWidth(90);
        tbFluxoPedidoBobina.getColumnModel().getColumn(9).setPreferredWidth(130);
        tbFluxoPedidoBobina.getColumnModel().getColumn(10).setPreferredWidth(130);
    }

    private void carregaTabela() {
        tamanhoTabela();
        DefaultTableModel modelo = (DefaultTableModel) tbFluxoPedidoBobina.getModel();
        // Limpa a tabela antes de preencher os novos dados
        modelo.setNumRows(0);
        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar o renderizador às colunas de valorpedido (índice 1) e quantidadebobina (índice 2)
        tbFluxoPedidoBobina.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbFluxoPedidoBobina.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbFluxoPedidoBobina.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tbFluxoPedidoBobina.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbFluxoPedidoBobina.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tbFluxoPedidoBobina.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        // Configurar a tabela como não editável
        tbFluxoPedidoBobina.setDefaultEditor(Object.class, null);
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            // Consulta para obter a soma total da coluna quantidadeBobina
            String sqlSomaTotal = "SELECT SUM (quantidadeBobina) AS totalBobinas FROM pedidobobina";
            try (PreparedStatement statement = con.prepareStatement(sqlSomaTotal);
                    ResultSet resultado = statement.executeQuery()) {

                if (resultado.next()) {
                    int totalBobinas = resultado.getInt("totalBobinas");
                    lbTotalBobina.setText(String.valueOf(totalBobinas));
                }
            }
            String sqlSomaTotalReal = "SELECT SUM(valorpedido) AS totalValor FROM pedidobobina";
            NumberFormat currencyValor = NumberFormat.getCurrencyInstance();

            try (PreparedStatement statement = con.prepareCall(sqlSomaTotalReal);
                    ResultSet resultadoValor = statement.executeQuery()) {

                if (resultadoValor.next()) {
                    Double totalValor = resultadoValor.getDouble("totalValor");
                    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
                    String formattedTotal = decimalFormat.format(totalValor);
                    lblTotalValor.setText(formattedTotal);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Tratar a exceção conforme necessário, por exemplo, exibindo uma mensagem de erro.
            }
            pstm = con.prepareStatement("SELECT * FROM pedidobobina ORDER BY datahora DESC;");
            rs = pstm.executeQuery();
            while (rs.next()) {

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                // String dataFormatadaPedido = dateFormat.format(rs.getDate("datapedido"));

                String dataFormatadaPedido = "";
                Date dataPedido = rs.getDate("datapedido");
                if (dataPedido != null) {
                    dataFormatadaPedido = dateFormat.format(dataPedido);
                }

                String dataFormatadaEntrega = "";
                Date dataEntrega = rs.getDate("dataentrega");
                if (dataEntrega != null) {
                    dataFormatadaEntrega = dateFormat.format(dataEntrega);
                }

                modelo.addRow(new Object[]{
                    //rs.getString(1), id da tabela do banco de dados
                    rs.getString("nomecliente"),
                    currencyValor.format(rs.getDouble("valorpedido")),
                    rs.getString("quantidadebobina"),
                    // rs.getString("datapedido"),
                    // rs.getString("dataentrega"),
                    dataFormatadaPedido,
                    dataFormatadaEntrega,
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTotalBobina;
    private javax.swing.JLabel lblTotalValor;
    private javax.swing.JTable tbFluxoPedidoBobina;
    // End of variables declaration//GEN-END:variables
}
