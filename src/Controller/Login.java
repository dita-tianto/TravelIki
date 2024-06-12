package Controller;

import Model.Enums;
import Model.User;
import View.Menu_Dashboard;
import View.Login.Login_Pengguna;
import javax.swing.JOptionPane;

public class Login {
    public static void run_login(String give_username, String give_password){
        // User log_user = new User();
        Enums.role user_role = User.check_user_data(give_username, give_password);

        if (user_role == null) {
            JOptionPane.showMessageDialog(null, "[ Login Failed ]");

        } else {
            System.out.println("[LOGIN AS " + user_role + " ]");
            Menu_Dashboard Dashboard_JFrm = new Menu_Dashboard(user_role); // ini langsung masuk ke dashboard sesuai role
            Dashboard_JFrm.setVisible(true);
            Login_Pengguna.frmLoginPanel.dispose();
		}
    }
}