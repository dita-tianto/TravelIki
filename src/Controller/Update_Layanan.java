package Controller;

import Model.Layanan;

public class Update_Layanan {
    public Update_Layanan(int give_id_layanan, String give_layanan, String give_deskripsi, double give_harga, int give_id_kategori, String give_status, String give_jenis){
        Layanan up_layanan = new Layanan();
        up_layanan.set_data_layanan(give_layanan, give_deskripsi, give_harga, give_id_kategori, give_status, give_jenis);
        up_layanan.update_layanan(give_id_layanan);
    }
    
}