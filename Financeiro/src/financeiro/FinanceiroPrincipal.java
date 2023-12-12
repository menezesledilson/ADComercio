/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro;

import financeiro.gui.BuscarBoleto;
import financeiro.gui.CadastroBobina;
import financeiro.gui.CadastroBoleto;
import financeiro.gui.CadastroPedidoBobina;
import financeiro.gui.MenuPrincipal;
import javax.swing.WindowConstants;

/**
 *
 * @author Ledilson
 */
public class FinanceiroPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      /* CadastroBoleto mm = new CadastroBoleto();

        mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mm.setVisible(true);*/

        
         CadastroPedidoBobina mm = new CadastroPedidoBobina();

         mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

         mm.setVisible(true);  
         
        /* CadastroBobina mm = new CadastroBobina();

         mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

         mm.setVisible(true);*/
    }

}
