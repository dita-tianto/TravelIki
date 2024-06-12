package Controller;

import Model.Detail_Paket;
import Model.Paket;

public class Update_Detail_Paket {
    public Update_Detail_Paket(String give_paket, String give_deskripsi, double give_harga, int give_id_kategori, int give_id_layanan){
        Paket up_paket = new  Paket();
        Detail_Paket up_Detail_Paket = new Detail_Paket();

        // MENAMBAHKAN PAKET
        up_paket.set_data_paket(give_paket, give_deskripsi, give_harga, give_id_kategori); 
        up_paket.insert_paket();

        // buat paket dulu lalu tambahkan layanannya
        int id_paket = up_paket.get_id_paket(give_paket, give_id_kategori); 

        // MENAMBAHKAN DETAIL PAKET
        up_Detail_Paket.set_data_paket(id_paket, give_id_layanan);
        up_Detail_Paket.insert_layanan();
    }
    
}