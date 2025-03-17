package Controller;

import Model.Detail_Paket;

public class Update_Detail_Paket {
    public Update_Detail_Paket(int give_id_paket, int give_id_layanan){
        Detail_Paket up_Detail_Paket = new Detail_Paket();
        up_Detail_Paket.set_data_paket(give_id_paket, give_id_layanan);
        
        int id_detail_paket = up_Detail_Paket.get_id_detail_paket();

        up_Detail_Paket.update_detail_paket(id_detail_paket);
    }
    
}