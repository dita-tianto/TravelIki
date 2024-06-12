package Controller;

import Model.Detail_Paket;

public class Insert_Kategori {
    public Insert_Kategori(String give_kategori){
        Detail_Paket ins_kategori = new Detail_Paket();
        ins_kategori.set_data_kategori(give_kategori);
        ins_kategori.insert_kategori();
    }
    
}