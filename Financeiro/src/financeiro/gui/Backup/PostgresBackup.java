/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.gui.Backup;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ledilson
 */
public class PostgresBackup {

    public static void realizaBackup() throws IOException, InterruptedException {
        final List<String> comandos = new ArrayList<String>();
      
        String dir = "C:/BkpADComercio";
                
        comandos.add("C:\\Program Files\\PostgreSQL\\13\\bin\\pg_dump.exe");
       
        comandos.add("-h");
        comandos.add("localhost");
        
        comandos.add("-p");
        comandos.add("5432");
        comandos.add("-U");
        comandos.add("postgres");
        comandos.add("-F");
        comandos.add("c");
        comandos.add("-b");
        comandos.add("-v");
        
        File directory = new File ("C:\\BkpADComercio");
        if(!directory.exists()){
            directory.mkdirs(); //Cria o diretório se não exisitir
        }
              
        comandos.add("-f");
        comandos.add("C:\\BkpADComercio\\backup_" + getDateTime() + ".adcomercio");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
        comandos.add("financeiro");
        
        ProcessBuilder pb = new ProcessBuilder(comandos);

        pb.environment().put("PGPASSWORD", "admin");

        try {
            final Process process = pb.start();

            final BufferedReader r = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            String line = r.readLine();
            while (line != null) {
                System.err.println(line);
                line = r.readLine();
            }
            r.close();

            process.waitFor();
            process.destroy();
            JOptionPane.showMessageDialog(null, "Backup realizado com sucesso.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        PostgresBackup b = new PostgresBackup();
        b.realizaBackup();
    }

    private static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
