package Controller;

import Model.Pembayaran;

public class Insert_Pembayaran {
    public Insert_Pembayaran(int give_id_pesanan, String give_tanggal_pembayaran, double give_bayar){
        Pembayaran ins_pembayaran = new Pembayaran();
        ins_pembayaran.set_data_pesanan(give_id_pesanan, give_tanggal_pembayaran, give_bayar);
        ins_pembayaran.insert_pesanan();
    }
}