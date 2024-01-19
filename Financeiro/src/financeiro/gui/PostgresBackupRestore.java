
package financeiro.gui;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PostgresBackupRestore extends javax.swing.JInternalFrame {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    public PostgresBackupRestore() {
        initComponents();
   }
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBackup = new javax.swing.JButton();
        btRestore = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Backup de Segurança");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btnBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bkp.png"))); // NOI18N
        btnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupActionPerformed(evt);
            }
        });

        btRestore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restore.png"))); // NOI18N
        btRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRestoreActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Backup");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Restore");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRestoreActionPerformed
        String host = "localhost";
        String port = "5432";
        String database = "financeiro";
        String user = "postgres";
        String password = "admin";
        // Caminho do diretório de restauração
        String restoreDirectory = "C:\\ADComercio\\BkpAD";
        // Crie um diálogo de seleção de arquivo
        JFileChooser fileChooser = new JFileChooser(restoreDirectory);
        fileChooser.setDialogTitle("Selecione o arquivo de backup");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos de backup", "adcomercio"));
        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Se o usuário selecionou um arquivo
            File backupFile = fileChooser.getSelectedFile();
            try {
                String[] command = {
                    "C:\\Program Files\\PostgreSQL\\13\\bin\\pg_restore.exe",
                    "-h", host,
                    "-p", port,
                    "-U", user,
                    "-d", database,
                    "-c", // Limpa o banco de dados antes de restaurar
                    backupFile.getAbsolutePath()
                };
                ProcessBuilder processBuilder = new ProcessBuilder(command);
                processBuilder.environment().put("PGPASSWORD", password);
                processBuilder.redirectErrorStream(true); // Redireciona saída de erro para a saída de entrada
                Process process = processBuilder.start();
                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    JOptionPane.showMessageDialog(null, "Restauração realizada com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao restaurar o banco de dados.");
                }
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btRestoreActionPerformed

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed
        // Seu código de backup aqui, sem alterações
        String host = "localhost";
        String port = "5432";
        String database = "financeiro";
        String user = "postgres";
        String password = "admin";

        File directory = new File("C:\\ADComercio\\BkpAD");
        if (!directory.exists()) {
            directory.mkdirs(); // Cria o diretório se não existir
        }

        ZoneId brasiliaTimeZone = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime now = ZonedDateTime.now(brasiliaTimeZone);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HHmmss");
        String dateTimeString = now.format(formatter);

        String backupFileName = "bkp_" + database + "_" + dateTimeString + ".adcomercio";
        String backupPath = "C:\\ADComercio\\BkpAD\\" + backupFileName;

        try {
            String[] command = {
                "C:\\Program Files\\PostgreSQL\\13\\bin\\pg_dump.exe",
                "-h", host,
                "-p", port,
                "-U", user,
                "-F", "c",
                "-b",
                "-f", backupPath,
                database
            };

            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.environment().put("PGPASSWORD", password);

            processBuilder.redirectErrorStream(true); // Redireciona saída de erro para a saída de entrada

            Process process = processBuilder.start();

            process.waitFor(); // Aguarda a conclusão do processo

            // Verificar o código de retorno do processo para determinar se o backup foi bem-sucedido
            int exitCode = process.exitValue();
            if (exitCode == 0) {
                // Verificar se o arquivo de backup foi criado
                File backupFile = new File(backupPath);
                if (backupFile.exists()) {
                    JOptionPane.showMessageDialog(null, "Backup realizado com sucesso.");
                    System.out.println("Backup realizado com sucesso. Arquivo: " + backupFile.getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao fazer o backup. O arquivo de backup não foi encontrado.");
                    System.out.println("Erro ao fazer o backup. O arquivo de backup não foi encontrado.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao fazer o backup. Código de retorno: " + exitCode);
                System.out.println("Erro ao fazer o backup. Código de retorno: " + exitCode);
            }

        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao fazer o backup.");
        }


    }//GEN-LAST:event_btnBackupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRestore;
    private javax.swing.JButton btnBackup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
