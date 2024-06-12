package Controller;

import Model.Layanan;

public class Update_Kategori {
    public Update_Kategori(int give_id_layanan, String give_layanan, String give_deskripsi, double give_harga, int give_id_kategori){
        Layanan up_layanan = new Layanan();
        up_layanan.set_data_layanan(give_layanan, give_deskripsi, give_harga, give_id_kategori);
        up_layanan.update_layanan(give_id_layanan);
    }
    
}