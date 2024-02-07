package financeiroPrincipal;

import financeiro.View.Menus.MenuPrincipal;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;

public class FinanceiroPrincipal {
//Windows

    public static void main(String[] args) {

        MenuPrincipal mm = new MenuPrincipal();
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (Exception e) {

        }
        mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mm.setVisible(true);
    }

}
