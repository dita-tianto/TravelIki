package Controller;

import Model.Detail_Paket;
import Model.Paket;

public class Insert_Detail_Paket {
    public Insert_Detail_Paket(String give_paket, int give_id_kategori, int give_id_layanan) {
        Paket ins_paket = new Paket();
        Detail_Paket ins_Detail_Paket = new Detail_Paket();

        // buat paket dulu lalu tambahkan layanannya
        int id_paket = ins_paket.get_id_paket(give_paket, give_id_kategori);

        // MENAMBAHKAN DETAIL PAKET
        ins_Detail_Paket.set_data_paket(id_paket, give_id_layanan);
        ins_Detail_Paket.insert_layanan();
    }

}