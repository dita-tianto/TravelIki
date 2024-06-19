package Controller;

import Model.Enums;
import Model.Pengguna;

public class Update_Pengguna {
    public Update_Pengguna(int give_id_pengguna, String give_username, String give_email, String give_no_telepon, String give_password, String give_role){
        Pengguna reg_user = new Pengguna();
        reg_user.set_user_data(give_username, give_email, give_no_telepon, give_password, give_role);
        reg_user.update_user(give_id_pengguna);
    }
}