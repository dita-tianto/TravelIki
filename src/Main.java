
import View.Login.nLogin_User;
import javax.swing.SwingUtilities;

public class Main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            nLogin_User runApp = new nLogin_User();
            runApp.initialize();
            // nDashboard_Admin dash = new nDashboard_Admin();
        });
    }
}