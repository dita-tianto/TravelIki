package Controller;

import Model.Ulasan;

public class Insert_Ulasan {
    public Insert_Ulasan(int give_id_pengguna, int give_id_layanan, int give_id_paket, String give_tanggal_ulasan, String give_komentar){
        Ulasan ins_ulasan = new Ulasan();
        ins_ulasan.set_data_ulasan(give_id_pengguna, give_id_layanan, give_id_paket, give_tanggal_ulasan, give_komentar);
        ins_ulasan.insert_ulasan();
    }
    
}