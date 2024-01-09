/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fluxos;

import financeiro.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ledilson
 */
public class FluxoPagamento extends javax.swing.JInternalFrame {

    /**
     * Creates new form FluxoPagamento
     */
    public FluxoPagamento() {
        initComponents();
        carregaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFluxoPagamento = new javax.swing.JTable();
        lblSoma = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Fluxo de Pagamentos");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tbFluxoPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Descrição", "Valor", "Obs."
            }
        ));
        jScrollPane1.setViewportView(tbFluxoPagamento);

        lblSoma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSoma.setText("0.00");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSoma)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoma)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
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
 private void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tbFluxoPagamento.getModel();
        modelo.setNumRows(0);

        //Defini o tamanho da tabela
        tbFluxoPagamento.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbFluxoPagamento.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbFluxoPagamento.getColumnModel().getColumn(2).setPreferredWidth(20);
        tbFluxoPagamento.getColumnModel().getColumn(3).setPreferredWidth(30);

        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tbFluxoPagamento.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbFluxoPagamento.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbFluxoPagamento.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            // Consulta para obter a soma total da coluna Valor Pedido até a data atual
            String sqlSomaTotalReal = "SELECT SUM(valorpagamento) AS totalValor FROM pagamentofabrica WHERE CAST(datahorapagamento AS DATE) <= CURRENT_DATE";

            try (PreparedStatement statementValor = con.prepareStatement(sqlSomaTotalReal)) {

                try (ResultSet resultadoValor = statementValor.executeQuery()) {
                    if (resultadoValor.next()) {
                        Double totalAcumulado = resultadoValor.getDouble("totalValor");
                        
                        // Formata o valor para duas casas decimais
                        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
                        String formattedTotal = decimalFormat.format(totalAcumulado);
                        
                        lblSoma.setText(String.valueOf(formattedTotal));
                    } else {
                        // Se não houver resultados, define o total como zero
                        lblSoma.setText("0.00");
                    }
                }
            } catch (SQLException e) {
                // Trate exceções SQL conforme necessário
                e.printStackTrace();
            }

            pstm = con.prepareStatement("SELECT * FROM pagamentofabrica ORDER BY datahorapagamento ASC;");
            rs = pstm.executeQuery();

            NumberFormat currencyValor = NumberFormat.getCurrencyInstance();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("datahorapagamento"),
                    rs.getString("nomepagamento"),
                    currencyValor.format(rs.getDouble("valorpagamento")),
                    rs.getString("observacao")
                });
            }
            Conexao.closeConnection(con, pstm, rs);

        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSoma;
    private javax.swing.JTable tbFluxoPagamento;
    // End of variables declaration//GEN-END:variables
}
