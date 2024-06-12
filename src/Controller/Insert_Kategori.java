package Controller;

import Model.Kategori;

public class Insert_Kategori {
    public Insert_Kategori(String give_kategori){
        Kategori ins_kategori = new Kategori();
        ins_kategori.set_data_kategori(give_kategori);
        ins_kategori.insert_kategori();
    }
    
}