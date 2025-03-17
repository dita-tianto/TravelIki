package Controller;

import Model.Layanan;

public class Insert_Layanan {
    public Insert_Layanan(String give_layanan, double give_harga, int give_id_kategori, String jenis){
        Layanan ins_layanan = new Layanan();
        ins_layanan.set_data_layanan(give_layanan, give_harga, give_id_kategori, jenis);
        ins_layanan.insert_layanan();
    }
    
}