package Controller;

import Model.Detail_Paket;
import Model.Paket;

public class Insert_Paket {
    public Insert_Paket(String give_paket, String give_deskripsi, double give_harga, int give_id_kategori, int give_id_layanan){
        Paket ins_paket = new  Paket();
        Detail_Paket ins_Detail_Paket = new Detail_Paket();

        // MENAMBAHKAN PAKET
        ins_paket.set_data_paket(give_paket, give_deskripsi, give_harga, give_id_kategori); 
        ins_paket.insert_paket();

        // buat paket dulu lalu tambahkan layanannya
        int id_paket = ins_paket.get_id_paket(give_paket, give_id_kategori); 

        // MENAMBAHKAN DETAIL PAKET
        ins_Detail_Paket.set_data_paket(id_paket, give_id_layanan);
        ins_Detail_Paket.insert_layanan();
    }
    
}