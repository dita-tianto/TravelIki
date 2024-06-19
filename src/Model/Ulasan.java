package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.TableModel;

import View.All_Panel.nPanel_Ulasan;
import net.proteanit.sql.DbUtils;

public class Ulasan {
    private int id_pengguna;
    private int id_layanan;
    private String tanggal_ulasan;
    private String komentar;

    // TAMBAH ULASAN
    
    public void set_data_ulasan(int give_id_pengguna, int give_id_layanan, String give_tanggal_ulasan, String give_komentar){
        this.id_pengguna = give_id_pengguna;
        this.id_layanan = give_id_layanan;
        this.tanggal_ulasan = give_tanggal_ulasan;
        this.komentar = give_komentar;
    }
    
    public void insert_ulasan(){
        String cmd = "INSERT INTO `ulasan` (`tanggal_ulasan`, `komentar`, `id_pengguna`, `id_layanan`) VALUES (?, ?, ?, ?)";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setString(1, this.tanggal_ulasan);
            stmt.setString(2, this.komentar);
            stmt.setInt(3, this.id_pengguna);
            stmt.setInt(4, this.id_layanan);
            stmt.execute();

            System.out.println("[ ULASAN BERHASIL ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public void update_ulasan(int give_id_ulasan){
        String cmd = "UPDATE `ulasan` SET 'id_pengguna' = ?, 'id_layanan' = ?, 'tanggal_ulasan' = ?, 'komentar' = ? WHERE id_ulasan = ?";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setInt(1, this.id_pengguna);
            stmt.setInt(2, this.id_layanan);
            stmt.setString(3, this.tanggal_ulasan);
            stmt.setString(4, this.komentar);
            stmt.setInt(4, give_id_ulasan);
            stmt.execute();

            System.out.println("[ ULASAN BERHASIL ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    // delete ulasan
    public static void delete_ulasan(int give_id_ulasan) {
        String cmd = "DELETE FROM `ulasan` WHERE id_ulasan = ?";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {
            stmt.setInt(1, give_id_ulasan);
            stmt.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    // CEK ULASAN

    public static void load_data_ulasan(){ //selalu hitung setelah insert pesanan
        String cmd = "SELECT 'u.id_ulasan' AS ID, p.username AS 'Nama', l.nama_layanan AS 'Nama Layanan', u.tanggal_ulasan AS 'Tanggal Ulasan', u.komentar AS 'Komentar' FROM ulasan u JOIN pengguna p ON p.id_pengguna = u.id_pengguna JOIN layanan l ON l.id_layanan = u.id_layanan;";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            ResultSet rs = stmt.executeQuery();// konversi rs ke TableModel
            nPanel_Ulasan.table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
}