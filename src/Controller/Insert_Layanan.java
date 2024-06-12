package Controller;

import Model.Layanan;

public class Insert_Layanan {
    public Insert_Layanan(String give_layanan, String give_deskripsi, double give_harga, int give_id_kategori){
        Layanan ins_layanan = new Layanan();
        ins_layanan.set_data_layanan(give_layanan, give_deskripsi, give_harga, give_id_kategori);
        ins_layanan.insert_layanan();
    }
    
}