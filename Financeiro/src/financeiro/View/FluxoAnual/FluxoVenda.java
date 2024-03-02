package financeiro.View.FluxoAnual;

import financeiro.conexao.Conexao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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

/**
 *
 * @author Ledilson
 */
public class FluxoVenda extends javax.swing.JInternalFrame {

    public FluxoVenda() {
        initComponents();
        carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblSoma = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFluxoVenda = new javax.swing.JTable();
        btImprimir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Fluxo de vendas");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblSoma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSoma.setText("0.00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Total:");

        tbFluxoVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Nome", "Valor", "Obs"
            }
        ));
        jScrollPane1.setViewportView(tbFluxoVenda);

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
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lblSoma)
                .addContainerGap(396, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btImprimir)
                    .addComponent(jLabel4)
                    .addComponent(lblSoma))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        Connection con = Conexao.getConnection();
        //PreparedStatement pstm = null;
        try {
            String arq = "C:\\ADComercio\\Financeiro\\src\\Relatorios\\Fluxo\\RelatorioVenda.jasper";
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
        tbFluxoVenda.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbFluxoVenda.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbFluxoVenda.getColumnModel().getColumn(2).setPreferredWidth(20);
        tbFluxoVenda.getColumnModel().getColumn(3).setPreferredWidth(50);

    }

    private void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tbFluxoVenda.getModel();
        modelo.setNumRows(0);
        tamanhoTabela();
        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbFluxoVenda.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbFluxoVenda.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbFluxoVenda.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        // Configurar a tabela como não editável
        tbFluxoVenda.setDefaultEditor(Object.class, null);
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            // Consulta para obter a soma total da coluna Valor Pedido até a data atual
            String sqlSomaTotalReal = "SELECT SUM(valorvenda) AS soma_valorvenda FROM controlevendedor;";
            try (PreparedStatement statementValor = con.prepareStatement(sqlSomaTotalReal)) {
                try (ResultSet resultadoValor = statementValor.executeQuery()) {
                    if (resultadoValor.next()) {
                        BigDecimal totalAcumulado = resultadoValor.getBigDecimal("soma_valorvenda");
                        // Formata o valor para duas casas decimais
                        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
                        String formattedTotal = decimalFormat.format(totalAcumulado);
                        lblSoma.setText(formattedTotal);
                    } else {
                        // Se não houver resultados, define o total como zero
                        lblSoma.setText("0.00");
                    }
                }
            } catch (SQLException e) {
                // Trate exceções SQL conforme necessário
                e.printStackTrace();
            }
            pstm = con.prepareStatement("SELECT * FROM controlevendedor ORDER BY datahoravenda DESC;");
            rs = pstm.executeQuery();
            NumberFormat currencyValor = NumberFormat.getCurrencyInstance();
            while (rs.next()) {
                // Dentro do seu loop while
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dataHoraFormatada = dateFormat.format(rs.getTimestamp("datahoravenda"));

                modelo.addRow(new Object[]{
                    dataHoraFormatada,
                    rs.getString("nomevenda"),
                    currencyValor.format(rs.getDouble("valorvenda")),
                    rs.getString("observacao")
                });
            }
            Conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImprimir;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSoma;
    private javax.swing.JTable tbFluxoVenda;
    // End of variables declaration//GEN-END:variables
}
