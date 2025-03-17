package Controller;

import Model.Detail_Pesanan;

public class Update_Detail_Pemesanan {
    public Update_Detail_Pemesanan(int give_id_pesanan, int give_id_layanan, int give_id_paket, int give_kuantitas, double give_harga_satuan){
        Detail_Pesanan ins_detail_pesanan = new Detail_Pesanan();
        ins_detail_pesanan.set_detail_pesanan(give_id_pesanan, give_id_layanan, give_id_paket, give_kuantitas, give_harga_satuan);
        ins_detail_pesanan.update_detail_pesanan(give_id_pesanan);
    }
    
}