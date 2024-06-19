
import View.All_Panel.nPanel_Kategori;
import View.Login.nLogin_User;
import javax.swing.SwingUtilities;

public class Main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            nLogin_User runApp = new nLogin_User();
            runApp.initialize();
            // test();
        });
    }

    public static void test(){
        nPanel_Kategori pl = new nPanel_Kategori();
        pl.initialize();
    }
}