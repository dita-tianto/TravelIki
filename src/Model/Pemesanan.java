package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import View.All_panel.nPanel_Pemesanan;
import net.proteanit.sql.DbUtils;

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

            update_total_harga(get_id_pesanan(id_pengguna, tanggal_pemesanan));

            System.out.println("[ PESANAN DITAMBAHKAN ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    // UPDATE PESANAN

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

    public void update_status_pemesanan(int give_id_layanan, Enums.pemesanan give_status){
        String cmd = "UPDATE `pesanan` SET `status_pesanan` = ? WHERE id_pesanan = ?";
        
        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setString(1, give_status.name());
            stmt.setInt(2, give_id_layanan);
            stmt.execute();

            System.out.println("[ TOTAL HARGA DIPERBARUI ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // CEK PESANAN

    public double hitung_total_harga(int give_id_pesanan){ //selalu hitung setelah insert pesanan
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

    public static int get_id_by_name(String give_id_pengguna){
        return 0;
    }

    public int get_id_pesanan(int give_id_pengguna, String give_tanggal_pemesanan){
        String cmd = "SELECT `id_pesanan` FROM `pesanan` WHERE `id_pengguna` = ? AND `tanggal_pemesanan` = ?";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){

            stmt.setInt(1, give_id_pengguna);
            stmt.setString(1, give_tanggal_pemesanan);

            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                id_pesanan = rs.getInt("id_pesanan");
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        }
        return id_pesanan;
    }

    public static void load_data_pesanan(){
        String cmd = "SELECT p.id_pesanan AS 'ID Pesanan', u.username AS 'Nama Pemesan', p.tanggal_pemesanan AS 'Tanggal Pemesanan', p.status_pemesanan AS 'Status Pesanan' FROM pemesanan p JOIN pengguna u ON p.id_pengguna = u.id_pengguna;";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            ResultSet rs = stmt.executeQuery();// konversi rs ke TableModel
            nPanel_Pemesanan.table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}