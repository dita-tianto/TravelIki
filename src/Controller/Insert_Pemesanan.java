package Controller;

import Model.Detail_Pesanan;
import Model.Pemesanan;

public class Insert_Pemesanan {
    public Insert_Pemesanan(int give_id_pengguna, String give_tanggal_pemesanan,int give_id_layanan, int give_id_paket, int give_kuantitas, double give_harga_satuan){
        Pemesanan ins_pemesanan = new Pemesanan();
        Detail_Pesanan ins_detail_pesanan = new Detail_Pesanan();

        // MENAMBAHKAN PESANAN
        ins_pemesanan.set_data_pesanan(give_id_pengguna, give_tanggal_pemesanan);
        ins_pemesanan.insert_pesanan();

        int id_pesanan = ins_pemesanan.get_id_pesanan(give_id_pengguna, give_tanggal_pemesanan);
        double subtotal = ins_detail_pesanan.hitung_subtotal(give_kuantitas, give_harga_satuan);

        // MENAMBAHKAN DETAIL PESANAN
        ins_detail_pesanan.set_detail_pesanan(id_pesanan, give_id_layanan, give_id_paket, give_kuantitas, give_harga_satuan, subtotal);
        ins_detail_pesanan.insert_detail_pesanan();
    }
    
}