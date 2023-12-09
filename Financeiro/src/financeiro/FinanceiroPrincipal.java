/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro;

import financeiro.gui.CadastroBobina;
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
        MenuPrincipal mm = new MenuPrincipal();

        mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mm.setVisible(true);

    }

}
