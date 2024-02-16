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
        lblSaida = new javax.swing.JLabel();
        lblEntrada = new javax.swing.JLabel();
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

        lblSaida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSaida.setText("0.00");

        lblEntrada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEntrada.setText("0.00");

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
                .addGap(119, 119, 119)
                .addComponent(lblEntrada)
                .addGap(125, 125, 125)
                .addComponent(lblSaida)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaida)
                    .addComponent(lblEntrada)
                    .addComponent(btImprimir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
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
            String arq = "C:\\ADComercio\\Financeiro\\src\\Relatorios\\Fluxo\\RelatorioCaixa.jasper";
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
        // Configurar a tabela como não editável
        tbFluxoC.setDefaultEditor(Object.class, null);

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            //  Calendar cal = Calendar.getInstance();
            //  int mesAtual = cal.get(Calendar.MONTH) + 1;
            double somaEntrada = 0;
            double somaSaida = 0;
            double liquido = 0;

            pstm = con.prepareStatement("SELECT datahora, descricao, entrada,saida FROM caixa ORDER BY id DESC;");
            rs = pstm.executeQuery();

            NumberFormat currencyEntrada = NumberFormat.getCurrencyInstance();
            NumberFormat currencySaida = NumberFormat.getCurrencyInstance();
            modelo.setNumRows(0);

            while (rs.next()) {

                // Dentro do seu loop while
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dataHoraFormatada = dateFormat.format(rs.getTimestamp("datahora"));

                //   Timestamp dataHora = rs.getTimestamp("datahora");
                //   int mesDataHora = dataHora.toLocalDateTime().getMonthValue();
                double entrada = rs.getDouble("entrada");
                double saida = rs.getDouble("saida");

                // Adiciona a linha à tabela
                modelo.addRow(new Object[]{
                    dataHoraFormatada,
                    rs.getString("descricao"),
                    currencyEntrada.format(entrada),
                    currencySaida.format(saida),});

                somaEntrada += entrada;
                somaSaida += saida;

                liquido = somaEntrada - somaSaida;
            }
            // Atualiza os rótulos dentro do loop
            //   lblEntrada.setText(currencySaida.format(somaEntrada));
            lblEntrada.setText("Total de entradas no ano " + NumberFormat.getCurrencyInstance().format(somaEntrada));
            // lblSaida.setText(currencyEntrada.format(somaSaida));
            lblSaida.setText("Total de saidas no ano " + NumberFormat.getCurrencyInstance().format(somaSaida));

            Conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImprimir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JLabel lblSaida;
    private javax.swing.JTable tbFluxoC;
    // End of variables declaration//GEN-END:variables
}
