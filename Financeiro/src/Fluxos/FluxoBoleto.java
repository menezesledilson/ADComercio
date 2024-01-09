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
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ledilson
 */
public class FluxoBoleto extends javax.swing.JInternalFrame {

    /**
     * Creates new form FluxoBoleto
     */
    public FluxoBoleto() {
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
        tbFluxoBoleto = new javax.swing.JTable();

        setClosable(true);
        setTitle("Fluxo Livro Boletos");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tbFluxoBoleto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Data Receber", "Valor Receber", "Empresa", "Data a Pagar", "Valor a Pagar"
            }
        ));
        jScrollPane1.setViewportView(tbFluxoBoleto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
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

        DefaultTableModel modelo = (DefaultTableModel) tbFluxoBoleto.getModel();
        modelo.setNumRows(0);

        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar o renderizador às colunas de valorpedido (índice 1) e quantidadebobina (índice 2)
        tbFluxoBoleto.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbFluxoBoleto.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        // tbBoletoClienteEmpresa.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbFluxoBoleto.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
       

        //Defini o tamanho da tabela
        tbFluxoBoleto.getColumnModel().getColumn(0).setPreferredWidth(170);
        tbFluxoBoleto.getColumnModel().getColumn(1).setPreferredWidth(60);
        tbFluxoBoleto.getColumnModel().getColumn(2).setPreferredWidth(60);
        tbFluxoBoleto.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbFluxoBoleto.getColumnModel().getColumn(4).setPreferredWidth(60);
        tbFluxoBoleto.getColumnModel().getColumn(5).setPreferredWidth(60);
        


        /*Outra forma de usar  
         BobinaDao dao = new BobinaDao();

         try {
         dao.listar().stream().forEach((p) -> {
         modelo.addRow(new Object[]{
         p.getNomeBobina(),
         p.getValorBobina()
         });
         });
         } catch (Exception Erro) 
         {
         JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados " + Erro, "ERRO", JOptionPane.ERROR);
         }*/
        try {

            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT * FROM boletoEmpresa ORDER BY databoletoreceber ASC;");
            rs = pstm.executeQuery();

            //Formatar o valor no campo jtable
            NumberFormat currencyReceber = NumberFormat.getCurrencyInstance();
            NumberFormat currencyApagar = NumberFormat.getCurrencyInstance();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    //rs.getString(1),
                    rs.getString("nomeboletoreceber"),
                    rs.getString("databoletoreceber"),
                    currencyReceber.format(rs.getDouble("valorboletoreceber")),
                    //rs.getString(4),
                    rs.getString("nomeboletoapagar"),
                    rs.getString("databoletoapagar"),
                    // currencyApagar.format(rs.getDouble("valorboletoApgar")),

                    currencyApagar.format(rs.getDouble("valorboletoapagar")),});
            }
            Conexao.closeConnection(con, pstm, rs);

        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFluxoBoleto;
    // End of variables declaration//GEN-END:variables
}
