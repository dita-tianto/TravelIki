package Controller;

import Model.Paket;

public class Update_Paket {
    public Update_Paket(String give_paket, String give_deskripsi, double give_harga, int give_id_kategori){
        Paket up_paket = new Paket();
        up_paket.set_data_paket(give_paket, give_deskripsi, give_harga, give_id_kategori);

        int id_paket = up_paket.get_id_paket(give_paket, give_id_kategori);

        up_paket.update_paket(id_paket);

    }
    
}