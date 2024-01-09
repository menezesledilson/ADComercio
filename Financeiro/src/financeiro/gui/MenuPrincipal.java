/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.gui;

import Fluxos.FluxoBoleto;
import Fluxos.FluxoCaixa;
import Fluxos.FluxoCliente;
import Fluxos.FluxoPagamento;
import Fluxos.FluxoPedidoBobina;
import Fluxos.FluxoVenda;
import financeiro.gui.Buscar.BuscarPedidoBobina;
import financeiro.gui.Buscar.BuscarBoleto;
import financeiro.gui.Buscar.BuscarNotaServico;
import financeiro.gui.Buscar.BuscaLivroCaixa;

import financeiro.conexao.Conexao;
import financeiro.gui.Buscar.BuscarControleVenda;
import financeiro.gui.Buscar.BuscarEmissorCalculoNF;
import financeiro.gui.Buscar.BuscarNotaId;
import financeiro.gui.Buscar.BuscarNotaServicoFinal;
import financeiro.gui.Buscar.BuscarPagamentoF;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import util.PosicaoFormulario;

/**
 *
 * @author Ledilson
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    PosicaoFormulario form = new PosicaoFormulario();
    
    public MenuPrincipal(String user) {
        
        initComponents();
        setIcon();
        
        jLabel1.setText(user);

        /*
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //setSize(800, 600);
        setSize(1366, 768);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null); // Centraliza o JFrame na tela principal
        // Outras configurações e adições podem ser feitas conforme necessário
        setVisible(true);
        jLabel3.setSize(1366, 768);

        // Configurar um Timer para verificar o horário a cada minuto
        Timer timer = new Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarHoraAviso();
            }
        });
        timer.start();
    }

    /*
     if (horaAtual.equals("14:05")) {
            SwingUtilities.invokeLater(() -> {
                exibirAviso("Aviso", "Hora de fazer backup 21:00!");
            });
        }
    
    
     */
    // private static int exibirAviso(String titulo, String mensagem) {
    //     return JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
    // }
    //  private static void exibirAviso(String titulo, String mensagem) {
    //   JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    //}
    private void verificarHoraAviso() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String horaAtual = sdf.format(new Date());
        
        if (horaAtual.equals("16:00")) {
            SwingUtilities.invokeLater(() -> {
                int escolha = exibirAviso(this, "Aviso", "Hora de fazer backup!");
                
                if (escolha == JOptionPane.YES_OPTION) {
                    // Código a ser executado se o usuário escolher "Sim"
                    // PostgresBackupRestore formMensagem = new PostgresBackupRestore();
                    // formMensagem.setVisible(true);

                    abrirFormMensagem();
                } else {
                    // Código a ser executado se o usuário escolher "Não" ou fechar a caixa de diálogo
                    JOptionPane.showMessageDialog(this, "Não se esqueça de fazer o backup após concluir a tarefa. ");
                }
                
            });
        }
    }
    
    private void abrirFormMensagem() {
        /*  PostgresBackupRestore formMensagem = new PostgresBackupRestore();
        jDesktop.add(formMensagem);
        formMensagem.setSize(400, 300);
        formMensagem.setLocation(50, 50);
        formMensagem.setVisible(true);*/
        
        PostgresBackupRestore formMensagem = new PostgresBackupRestore();

        // Obtém o tamanho da tela principal
        int telaPrincipalWidth = getWidth();
        int telaPrincipalHeight = getHeight();

        // Obtém o tamanho do JInternalFrame
        int formWidth = formMensagem.getWidth();
        int formHeight = formMensagem.getHeight();

        // Calcula a posição central em relação à tela principal
        int x = (telaPrincipalWidth - formWidth) / 2;
        int y = (telaPrincipalHeight - formHeight) / 2;
        
        jDesktop.add(formMensagem);
        formMensagem.setLocation(x, y);
        formMensagem.setVisible(true);
        
    }
    
    private static int exibirAviso(JFrame frame, String titulo, String mensagem) {
        return JOptionPane.showConfirmDialog(frame, mensagem, titulo, JOptionPane.YES_NO_OPTION);
        
    }
    
    private MenuPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/banco.png")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JSeparator();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jSeparator29 = new javax.swing.JSeparator();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem32 = new javax.swing.JMenuItem();
        jBarra = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblhora = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jDesktop = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        MenuBobina = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu6 = new javax.swing.JMenu();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem27 = new javax.swing.JMenuItem();
        jSeparator25 = new javax.swing.JPopupMenu.Separator();
        jMenuItem26 = new javax.swing.JMenuItem();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenu10 = new javax.swing.JMenu();
        jSeparator30 = new javax.swing.JPopupMenu.Separator();
        jMenuItem31 = new javax.swing.JMenuItem();
        jSeparator32 = new javax.swing.JPopupMenu.Separator();
        jMenuItem33 = new javax.swing.JMenuItem();
        jSeparator31 = new javax.swing.JPopupMenu.Separator();
        jMenuItem30 = new javax.swing.JMenuItem();
        jSeparator27 = new javax.swing.JPopupMenu.Separator();
        jMenuItem34 = new javax.swing.JMenuItem();
        jSeparator28 = new javax.swing.JPopupMenu.Separator();
        jMenuItem35 = new javax.swing.JMenuItem();
        jSeparator33 = new javax.swing.JPopupMenu.Separator();
        jMenu8 = new javax.swing.JMenu();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        jMenuItem21 = new javax.swing.JMenuItem();
        jSeparator22 = new javax.swing.JPopupMenu.Separator();
        jMenu12 = new javax.swing.JMenu();
        jSeparator34 = new javax.swing.JPopupMenu.Separator();
        jMenuItem36 = new javax.swing.JMenuItem();
        jSeparator36 = new javax.swing.JPopupMenu.Separator();
        jMenuItem25 = new javax.swing.JMenuItem();
        jSeparator35 = new javax.swing.JPopupMenu.Separator();
        jMenu7 = new javax.swing.JMenu();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem29 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem28 = new javax.swing.JMenuItem();
        jSeparator24 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator26 = new javax.swing.JPopupMenu.Separator();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        jMenuItem20 = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jMenuItem24 = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jMenu9 = new javax.swing.JMenu();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        jMenuCredencial = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem10.setText("jMenuItem10");

        jMenuItem12.setText("jMenuItem12");

        jMenuItem13.setText("jMenuItem13");

        jMenuItem17.setText("jMenuItem17");

        jMenuItem19.setText("jMenuItem19");

        jMenuItem22.setText("jMenuItem22");

        jMenuItem23.setText("jMenuItem23");

        jMenu11.setText("jMenu11");

        jMenuItem32.setText("jMenuItem32");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AD Comércio Papéis LTDA");
        setExtendedState(6);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jBarra.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setText("Usuário:");

        jLabel1.setText("0");

        lblhora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblhora.setText("Hora");

        lblData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblData.setText("Data");

        javax.swing.GroupLayout jBarraLayout = new javax.swing.GroupLayout(jBarra);
        jBarra.setLayout(jBarraLayout);
        jBarraLayout.setHorizontalGroup(
            jBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jBarraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 699, Short.MAX_VALUE)
                .addComponent(lblData)
                .addGap(43, 43, 43)
                .addComponent(lblhora)
                .addGap(45, 45, 45))
        );
        jBarraLayout.setVerticalGroup(
            jBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBarraLayout.createSequentialGroup()
                .addGroup(jBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(lblhora)
                    .addComponent(lblData))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 670));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(51, 204, 255));
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Fundo Tela.jpg"))); // NOI18N
        jLabel3.setText(" ");
        jLabel3.setMaximumSize(new java.awt.Dimension(1366, 768));
        jLabel3.setMinimumSize(new java.awt.Dimension(800, 600));
        jLabel3.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 750));

        jDesktop.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopLayout = new javax.swing.GroupLayout(jDesktop);
        jDesktop.setLayout(jDesktopLayout);
        jDesktopLayout.setHorizontalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jDesktopLayout.setVerticalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        jMenu1.setText("Cadastro ");
        jMenu1.add(jSeparator6);

        MenuBobina.setText("Bobina");
        MenuBobina.setName(""); // NOI18N
        MenuBobina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBobinaActionPerformed(evt);
            }
        });
        jMenu1.add(MenuBobina);
        jMenu1.add(jSeparator1);

        jMenuBar1.add(jMenu1);

        jMenu6.setText("Empresarial");
        jMenu6.add(jSeparator5);

        jMenuItem7.setText("Pedido de Bobinas");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);
        jMenu6.add(jSeparator2);

        jMenuItem8.setText("Operação de Pag. e Receb.");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);
        jMenu6.add(jSeparator10);

        jMenuBar1.add(jMenu6);

        jMenu5.setText("Op. Financeira");

        jMenuItem27.setText("Controle de  Vendas");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem27);
        jMenu5.add(jSeparator25);

        jMenuItem26.setText("Controle de  Pagamentos");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem26);
        jMenu5.add(jSeparator23);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Fiscal");
        jMenu2.add(jSeparator3);

        jMenuItem6.setText("Livro Caixa");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);
        jMenu2.add(jSeparator4);

        jMenuBar1.add(jMenu2);

        jMenu10.setText("Livros");
        jMenu10.add(jSeparator30);

        jMenuItem31.setText("Livro de Pedido de Bobinas");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem31);
        jMenu10.add(jSeparator32);

        jMenuItem33.setText("Livro de Boleto");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem33);
        jMenu10.add(jSeparator31);

        jMenuItem30.setText("Livro  Caixa");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem30);
        jMenu10.add(jSeparator27);

        jMenuItem34.setText("Livro de Vendas");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem34);
        jMenu10.add(jSeparator28);

        jMenuItem35.setText("Livro de Pagamentos");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem35);
        jMenu10.add(jSeparator33);

        jMenuBar1.add(jMenu10);

        jMenu8.setText("Emissão Nota Serviço");
        jMenu8.add(jSeparator13);

        jMenuItem15.setText("Emissão NS Produto");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem15);
        jMenu8.add(jSeparator15);

        jMenuItem4.setText("Emissão NS Calculo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem4);
        jMenu8.add(jSeparator20);

        jMenuItem21.setText("Emitir Nota Serviço");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem21);
        jMenu8.add(jSeparator22);

        jMenuBar1.add(jMenu8);

        jMenu12.setText("Nota Serviço ID");
        jMenu12.add(jSeparator34);

        jMenuItem36.setText("Lista de Clientes");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem36);
        jMenu12.add(jSeparator36);

        jMenuItem25.setText("Localizar NS ID");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem25);
        jMenu12.add(jSeparator35);

        jMenuBar1.add(jMenu12);

        jMenu7.setText("Localizar Registro");
        jMenu7.add(jSeparator8);

        jMenuItem14.setText("Localizar Pedidos de Bobinas");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem14);

        jMenuItem11.setText("Localizar Op. Pag. e Receb.");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem11);
        jMenu7.add(jSeparator9);

        jMenuItem29.setText("Localizar Controle de venda");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem29);
        jMenu7.add(jSeparator7);

        jMenuItem28.setText("Localizar Controle de Pagamento");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem28);
        jMenu7.add(jSeparator24);

        jMenuItem9.setText("Localizar Caixa");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem9);
        jMenu7.add(jSeparator26);

        jMenuItem18.setText("Localizar Nota Serviço Produto");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem18);
        jMenu7.add(jSeparator19);

        jMenuItem20.setText("Localizar Nota Servicço Calculo");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem20);
        jMenu7.add(jSeparator17);

        jMenuItem24.setText("Localizar Nota Serviço Empresa");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem24);
        jMenu7.add(jSeparator21);

        jMenuBar1.add(jMenu7);

        jMenu3.setText("Backup");

        jMenuItem5.setText("Realizar Backup");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);
        jMenu3.add(jSeparator12);

        jMenuBar1.add(jMenu3);

        jMenu9.setText("Acessos");
        jMenu9.add(jSeparator16);

        jMenuCredencial.setText("Cadastros de credencias");
        jMenuCredencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCredencialActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuCredencial);
        jMenu9.add(jSeparator18);

        jMenuBar1.add(jMenu9);

        jMenu4.setText("Sobre");

        jMenuItem16.setText("jMenuItem16");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem16);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(919, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuBobinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBobinaActionPerformed
        // TODO add your handling code here:
        CadastroBobina tela;
        form.abrirFormulario(tela = new CadastroBobina(), jDesktop);
    }//GEN-LAST:event_MenuBobinaActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        
        CadastroCaixa tela;
        form.abrirFormulario(tela = new CadastroCaixa(), jDesktop);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        
        CadastroPedidoBobina tela;
        form.abrirFormulario(tela = new CadastroPedidoBobina(), jDesktop);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        
        CadastroBoleto tela;
        form.abrirFormulario(tela = new CadastroBoleto(), jDesktop);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        
        PostgresBackupRestore tela;
        form.abrirFormulario(tela = new PostgresBackupRestore(), jDesktop);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        
        BuscaLivroCaixa tela;
        form.abrirFormulario(tela = new BuscaLivroCaixa(), jDesktop);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        /* /   BuscarBoleto1 mc = new BuscarBoleto1();
         mc.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         mc.setVisible(true);*/
        
        BuscarBoleto tela;
        form.abrirFormulario(tela = new BuscarBoleto(), jDesktop);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        BuscarPedidoBobina tela;
        form.abrirFormulario(tela = new BuscarPedidoBobina(), jDesktop);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        
        EmissorCalculoNF tela;
        form.abrirFormulario(tela = new EmissorCalculoNF(), jDesktop);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        
        EmissaoNotaServico tela;
        form.abrirFormulario(tela = new EmissaoNotaServico(), jDesktop);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        
        BuscarNotaServico tela;
        form.abrirFormulario(tela = new BuscarNotaServico(), jDesktop);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuCredencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCredencialActionPerformed
        
        Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm = con.prepareStatement("SELECT permissao FROM acesso WHERE login = ?");
            pstm.setString(1, jLabel1.getText());
            
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                String permissao = rs.getString("permissao");
                
                if ("Administrador".equals(permissao)) {
                    // CadastroCredencial mm = new CadastroCredencial();
                    //mm.setVisible(true);
                    CadastroCredencial tela;
                    form.abrirFormulario(tela = new CadastroCredencial(), jDesktop);
                    
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Você não possui permissão para o acesso.");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Usuário não encontrado");
            }
        } catch (SQLException ErroSql) {
            ErroSql.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Erro ao acessar o banco de dados");
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        

    }//GEN-LAST:event_jMenuCredencialActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Configura o fuso horário para Brasília
        TimeZone timeZone = TimeZone.getTimeZone("America/Sao_Paulo");
        
        TimeZone.setDefault(timeZone);
        
        Timer timer = new Timer(1000, new hora());
        timer.start();

        //Editando a Data
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        lblData.setText(formato.format(dataSistema));
        

    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed

        /* GuiTeste tela = new GuiTeste();
         jDesktop.add(tela);
         tela.setVisible(true);*/
        //  GuiTeste tela;
        //form.abrirFormulario(tela = new GuiTeste(), jDesktop);

    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        BuscarEmissorCalculoNF tela;
        form.abrirFormulario(tela = new BuscarEmissorCalculoNF(), jDesktop);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        FrmNotaServico tela;
        form.abrirFormulario(tela = new FrmNotaServico(), jDesktop);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        BuscarNotaServicoFinal tela;
        form.abrirFormulario(tela = new BuscarNotaServicoFinal(), jDesktop);
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        BuscarNotaId tela;
        form.abrirFormulario(tela = new BuscarNotaId(), jDesktop);
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        CadastroPagamentoFabrica tela;
        form.abrirFormulario(tela = new CadastroPagamentoFabrica(), jDesktop);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        CadastroControleVenda tela;
        form.abrirFormulario(tela = new CadastroControleVenda(), jDesktop);
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        BuscarPagamentoF tela;
        form.abrirFormulario(tela = new BuscarPagamentoF(), jDesktop);
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        BuscarControleVenda tela;
        form.abrirFormulario(tela = new BuscarControleVenda(), jDesktop);
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        FluxoCaixa tela;
        form.abrirFormulario(tela = new FluxoCaixa(), jDesktop);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        FluxoPedidoBobina tela;
        form.abrirFormulario(tela = new FluxoPedidoBobina(), jDesktop);
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        FluxoBoleto tela;
        form.abrirFormulario(tela = new FluxoBoleto(), jDesktop);
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        FluxoVenda tela;
        form.abrirFormulario(tela = new FluxoVenda(), jDesktop);
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        FluxoPagamento tela;
        form.abrirFormulario(tela = new FluxoPagamento(), jDesktop);
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        FluxoCliente tela;
        form.abrirFormulario(tela = new FluxoCliente(), jDesktop);
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //    SwingUtilities.invokeLater(() -> new MenuPrincipal());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuBobina;
    private javax.swing.JPanel jBarra;
    private javax.swing.JDesktopPane jDesktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCredencial;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator20;
    private javax.swing.JPopupMenu.Separator jSeparator21;
    private javax.swing.JPopupMenu.Separator jSeparator22;
    private javax.swing.JPopupMenu.Separator jSeparator23;
    private javax.swing.JPopupMenu.Separator jSeparator24;
    private javax.swing.JPopupMenu.Separator jSeparator25;
    private javax.swing.JPopupMenu.Separator jSeparator26;
    private javax.swing.JPopupMenu.Separator jSeparator27;
    private javax.swing.JPopupMenu.Separator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator30;
    private javax.swing.JPopupMenu.Separator jSeparator31;
    private javax.swing.JPopupMenu.Separator jSeparator32;
    private javax.swing.JPopupMenu.Separator jSeparator33;
    private javax.swing.JPopupMenu.Separator jSeparator34;
    private javax.swing.JPopupMenu.Separator jSeparator35;
    private javax.swing.JPopupMenu.Separator jSeparator36;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblhora;
    // End of variables declaration//GEN-END:variables

    class hora implements ActionListener {
        
        @Override
        
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            lblhora.setText(String.format("%1$tH:%1$tM:%1$tS", now)); //O Horário vai ter horas, minutos e segundos
        }
    }
    
}
