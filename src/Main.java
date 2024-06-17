
import View.All_Panel.nPanel_Layanan;
import javax.swing.SwingUtilities;

public class Main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // nLogin_User runApp = new nLogin_User();
            // runApp.initialize();
            test();
        });
    }

    public static void test(){
        nPanel_Layanan pl = new nPanel_Layanan();
        pl.initialize();
    }
}