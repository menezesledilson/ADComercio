/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro;

import financeiro.gui.BuscarLivroCaixa;
import financeiro.gui.CadastroCaixa;
import financeiro.gui.CadastroCompraB;
import financeiro.gui.EmissorCalculoNF;
import financeiro.gui.NFTeste;
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
        
        /* CadastroCaixa mm = new CadastroCaixa();

        mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mm.setVisible(true); */

        
     CadastroCompraB mm = new CadastroCompraB();

        mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mm.setVisible(true);  
         
        /*EmissorCalculoNF mm = new EmissorCalculoNF();

         mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

         mm.setVisible(true);*/
    }

   

}
