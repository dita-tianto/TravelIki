package Controller;

import Model.Kategori;

public class Update_Kategori {
    public Update_Kategori(int give_id_kategori, String give_kategori){
        Kategori ins_kategori = new Kategori();
        ins_kategori.set_data_kategori(give_kategori);
        ins_kategori.update_kategori(give_id_kategori);
    }
    
}