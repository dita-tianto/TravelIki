package Controller;

import Model.Paket;

public class Update_Layanan {
    public Update_Layanan(int give_id_layanan, String give_layanan, String give_deskripsi, double give_harga, int give_id_kategori){
        Paket up_layanan = new Paket();
        up_layanan.set_data_layanan(give_layanan, give_deskripsi, give_harga, give_id_kategori);
        up_layanan.update_layanan(give_id_layanan);
    }
    
}