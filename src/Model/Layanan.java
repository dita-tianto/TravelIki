package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Layanan {
    private String layanan;
    private String deskripsi;
    private double harga;

    // TAMBAH LAYANAN
    
    public void set_data_layanan(String give_layanan, String give_deskripsi, double give_harga){
        this.layanan = give_layanan;
        this.deskripsi = give_deskripsi;
        this.harga = give_harga;
    }
    
    public void insert_layanan(){
        String cmd = "INSERT INTO `layanan`(`nama_layanan`, `deskripsi`, `harga`) VALUES (?, ?, ?)";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setString(1, this.layanan);
            stmt.setString(2, this.deskripsi);
            stmt.setDouble(3, this.harga);
            stmt.execute();

            System.out.println("[ LAYANAN DITAMBAHKAN ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // CEK LAYANAN

    public static void load_data_layanan(int id_layanan){
        String cmd = "SELECT a.nama_layanan as Nama, b.nama_kategori as Kategori, a.harga as Harga, a.status_layanan FROM layanan a, kategori_layanan b WHERE a.id_kategori=b.id_kategori;";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){

            ResultSet rs = stmt.executeQuery();
            
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}