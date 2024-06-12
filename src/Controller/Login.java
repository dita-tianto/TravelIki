package Controller;

import java.awt.Window;

import javax.swing.JOptionPane;

import Model.Enums;
import Model.User;
import Model.Enums.role;
import View.Dashboard_JFrm;
import View.Login.LOG_Splash;

public class Login {
    public Login(String give_username, String give_password){
        User log_user = new User();
        Enums.role user_role = User.check_user_data(give_username, give_password);

        if (user_role == null) {
            JOptionPane.showMessageDialog(null, "[ Login Failed ]");

        } else {
            System.out.println("[LOGIN AS " + user_role + " ]");
            Dashboard_JFrm Dashboard_JFrm = new Dashboard_JFrm(user_role); // ini langsung masuk ke dashboard sesuai role
            Dashboard_JFrm.setVisible(true);
            ((Window) LOG_Splash.frmLoginPanel).dispose();
		}
    }
    
}