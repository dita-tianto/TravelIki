package Controller;

import Model.Kategori;
import Model.Ulasan;

public class Update_Ulasan {
    public Update_Ulasan(int give_id_ulasan, int give_id_pengguna, int give_id_layanan, String give_tanggal_ulasan, String give_komentar){
        Ulasan up_ulasan = new Ulasan();
        up_ulasan.set_data_ulasan(give_id_pengguna, give_id_layanan, give_tanggal_ulasan, give_komentar);
        up_ulasan.update_ulasan(give_id_ulasan);
    }
    
}