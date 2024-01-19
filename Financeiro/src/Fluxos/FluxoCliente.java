package Fluxos;

import financeiro.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ledilson
 */
public class FluxoCliente extends javax.swing.JInternalFrame {

    public FluxoCliente() {
        initComponents();
        carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFluxoCliente = new javax.swing.JTable();

        setClosable(true);
        setTitle("Cadastro de Clientes com ID");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void tamanhoTabela() {
        //Defini o tamanho da tabela
        tbFluxoCliente.getColumnModel().getColumn(0).setPreferredWidth(130);
        tbFluxoCliente.getColumnModel().getColumn(1).setPreferredWidth(20);
        tbFluxoCliente.getColumnModel().getColumn(2).setPreferredWidth(70);
        tbFluxoCliente.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbFluxoCliente.getColumnModel().getColumn(4).setPreferredWidth(150);

        tbFluxoCliente.getColumnModel().getColumn(5).setPreferredWidth(50);
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
        tbFluxoCliente.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbFluxoCliente.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFluxoCliente;
    // End of variables declaration//GEN-END:variables
}
