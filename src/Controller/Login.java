package Controller;

import Model.Enums;
import Model.Pengguna;
import View.Menu_Dashboard;
import javax.swing.JOptionPane;

public class Login {
    public static void run_login(String give_username, String give_password){
        // Pengguna log_user = new Pengguna();
        Enums.role user_role = Pengguna.get_user_role(give_username, give_password);

        if (user_role == null) {
            JOptionPane.showMessageDialog(null, "[ Login Failed ]");

        } else {
            System.out.println("[LOGIN AS " + user_role + " ]");
            Menu_Dashboard Dashboard_JFrm = new Menu_Dashboard(user_role); // ini langsung masuk ke dashboard sesuai role
            Dashboard_JFrm.setVisible(true);
            // Login_Pengguna.frmLoginPanel.dispose();
		}
    }
}