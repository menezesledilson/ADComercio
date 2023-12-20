/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro;

import financeiro.gui.PostgresBackupRestore;
import financeiro.gui.BuscarLivroCaixa;
import financeiro.gui.CadastroCaixa;
import financeiro.gui.BuscarNotaServico;
import financeiro.gui.EmissaoNotaServico;
import financeiro.gui.EmissorCalculoNF;
import financeiro.gui.MenuPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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

        MenuPrincipal mm = new MenuPrincipal();

        mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mm.setVisible(true);

    }

}
