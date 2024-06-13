package Controller;

import Model.Detail_Paket;
import Model.Paket;

public class Insert_Paket {
    public Insert_Paket(String give_paket, String give_deskripsi, double give_harga, int give_id_kategori) {
        Paket ins_paket = new Paket();

        // MENAMBAHKAN PAKET
        ins_paket.set_data_paket(give_paket, give_deskripsi, give_harga, give_id_kategori);
        ins_paket.insert_paket();
    }

}