package Fluxos;

import financeiro.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.Calendar;
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
public class FluxoCaixa extends javax.swing.JInternalFrame {

    public FluxoCaixa() {
        initComponents();
        carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFluxoC = new javax.swing.JTable();
        lblSaldoAtual = new javax.swing.JLabel();
        lblsaldoAnterior = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btImprimir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Fluxo Livro Caixa");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tbFluxoC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data hora", "Descrição", "Entrada", "Saída"
            }
        ));
        jScrollPane1.setViewportView(tbFluxoC);

        lblSaldoAtual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSaldoAtual.setText("0.00");

        lblsaldoAnterior.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblsaldoAnterior.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Saldo Atual");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText(" Saldo Anterior");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btImprimir)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(lblsaldoAnterior)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblSaldoAtual)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldoAtual)
                    .addComponent(lblsaldoAnterior)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(btImprimir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
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

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        Connection con = Conexao.getConnection();
        //PreparedStatement pstm = null;
        try {
            String arq = "C:\\ADComercio\\Financeiro\\src\\RelatorioFluxo\\RelatorioCaixa.jasper";
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
    public void tamanhoTabela() {
        // Defini o tamanho da tabela
        tbFluxoC.getColumnModel().getColumn(0).setPreferredWidth(1);
        tbFluxoC.getColumnModel().getColumn(1).setPreferredWidth(10);
        tbFluxoC.getColumnModel().getColumn(2).setPreferredWidth(1);
        tbFluxoC.getColumnModel().getColumn(3).setPreferredWidth(1);
    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbFluxoC.getModel();
        modelo.setNumRows(0);
        tamanhoTabela();
        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        // Aplicar o renderizador às colunas de valorpedido (índice 1) e quantidadebobina (índice 2)
        tbFluxoC.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbFluxoC.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbFluxoC.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;
            // Obtém o mês atual
            Calendar cal = Calendar.getInstance();
            int mesAtual = cal.get(Calendar.MONTH) + 1; // Note que os meses em Java começam do zero
            // Inicializa os saldos
            double saldoAtual = 0;
            double saldoAnterior = 0;
            pstm = con.prepareStatement("SELECT datahora, descricao, entrada, saida, LAG(SUM(entrada - COALESCE(saida, 0))) OVER (ORDER BY datahora) AS saldoAnterior, SUM(entrada - COALESCE(saida, 0)) OVER (ORDER BY datahora) AS saldoAtual FROM caixa GROUP BY datahora, descricao, entrada, saida ORDER BY datahora ASC;");
            rs = pstm.executeQuery();
            NumberFormat currencyEntrada = NumberFormat.getCurrencyInstance();
            NumberFormat currencySaida = NumberFormat.getCurrencyInstance();
            while (rs.next()) {
                Timestamp dataHora = rs.getTimestamp("datahora");
                int mesDataHora = dataHora.toLocalDateTime().getMonthValue();
                // Verifica se há uma mudança de mês
                if (mesDataHora != mesAtual) {
                    // Zera os rótulos quando há uma mudança de mês
                    lblSaldoAtual.setText("0");
                    lblsaldoAnterior.setText("0");
                    // Zera os saldos quando há uma mudança de mês
                    saldoAtual = 0;
                    saldoAnterior = 0;
                    mesAtual = mesDataHora; // Atualiza o mês atual
                }
                modelo.addRow(new Object[]{
                    dataHora,
                    rs.getString("descricao"),
                    currencyEntrada.format(rs.getDouble("entrada")),
                    currencySaida.format(rs.getDouble("saida"))
                });
                // Atualiza os saldos dentro do loop
                saldoAtual = rs.getDouble("saldoAtual");
                saldoAnterior = rs.getDouble("saldoAnterior");
            }
            // Atualize os rótulos fora do loop, após o processamento de todas as linhas do mês
            lblSaldoAtual.setText(String.valueOf(saldoAtual));
            lblsaldoAnterior.setText(String.valueOf(saldoAnterior));
            Conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImprimir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSaldoAtual;
    private javax.swing.JLabel lblsaldoAnterior;
    private javax.swing.JTable tbFluxoC;
    // End of variables declaration//GEN-END:variables
}
