package Controller;

import Model.Pengguna;

public class Insert_Pengguna {
    public Insert_Pengguna(String give_username, String give_email, String give_no_telepon, String give_password, String give_role){
        Pengguna reg_user = new Pengguna();
        reg_user.set_user_data(give_username, give_email, give_no_telepon, give_password, give_role);
        reg_user.insert_user();
    }
}