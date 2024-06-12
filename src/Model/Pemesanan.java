package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pemesanan {
    private  int id_pesanan;
    private int id_pengguna;
    private String tanggal_pemesanan;


    // TAMBAH PESANAN
    
    public void set_data_pesanan(int give_id_pengguna, String give_tanggal_pemesanan){
        this.id_pengguna = give_id_pengguna;
        this.tanggal_pemesanan = give_tanggal_pemesanan;
    }
    
    public void insert_pesanan(){
        String cmd = "INSERT INTO `pesanan`(`id_pengguna`, `tanggal_pemesanan`) VALUES (?, ?)";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setInt(1, this.id_pengguna);
            stmt.setString(2, this.tanggal_pemesanan);
            stmt.execute();

            update_total_harga(id_pesanan);

            System.out.println("[ PESANAN DITAMBAHKAN ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    // UPDATE 

    public void update_total_harga(int give_id_layanan){
        String cmd = "UPDATE `pesanan` SET `total_harga` = ? WHERE id_pesanan = ?)";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setDouble(1, hitung_total_harga(give_id_layanan));
            stmt.setInt(2, give_id_layanan);
            stmt.execute();

            System.out.println("[ TOTAL HARGA DIPERBARUI ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // CEK PESANAN

    public static double hitung_total_harga(int give_id_pesanan){ //selalu hitung setelah insert pesanan
        String cmd = "SELECT `id_pesanan`, `subtotal` FROM `detail_pesanan` WHERE id_pesanan = ?";

        double total = 0;

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){

            stmt.setInt(1, give_id_pesanan);

            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                total += rs.getDouble("subtotal");
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        }

        return total;
    }
}