package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class Ulasan {
    private int id_pengguna;
    private int id_layanan;
    private int id_paket;
    private String tanggal_ulasan;
    private String komentar;

    // TAMBAH ULASAN
    
    public void set_data_ulasan(int give_id_pengguna, int give_id_layanan, int give_id_paket, String give_tanggal_ulasan, String give_komentar){
        this.id_pengguna = give_id_pengguna;
        this.id_layanan = give_id_paket;
        this.id_paket = give_id_paket;
        this.tanggal_ulasan = give_tanggal_ulasan;
        this.komentar = give_komentar;
    }
    
    public void insert_ulasan(){
        String cmd = "INSERT INTO `ulasan`(`tanggal_ulasan`, `komentar`) VALUES (?, ?) WHERE id_pengguna = ? AND (id_layanan = ? OR id_paket = ?)";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setString(1, this.tanggal_ulasan);
            stmt.setString(2, this.komentar);
            stmt.setInt(3, this.id_pengguna);
            stmt.setInt(4, this.id_layanan);
            stmt.setInt(5, this.id_paket);
            stmt.execute();

            System.out.println("[ ULASAN BERHASIL ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    // CEK ULASAN

    public static TableModel cek_ulasan_by_layanan(int give_id_ulasan){ //selalu hitung setelah insert pesanan
        String cmd = "SELECT `tanggal_ulasan`, `komentar` FROM `ulasan` WHERE id_layanan = ?";

        TableModel tm = null;

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){

            stmt.setInt(1, give_id_ulasan);

            ResultSet rs = stmt.executeQuery();
            tm = DbUtils.resultSetToTableModel(rs); // konversi rs ke TableModel
            
        } catch (SQLException e) {
            System.err.println(e);
        }

        return tm;
    }
    
    public static TableModel cek_ulasan_by_paket(int give_id_paket){ //selalu hitung setelah insert pesanan
        String cmd = "SELECT `tanggal_ulasan`, `komentar` FROM `ulasan` WHERE id_paket = ?";

        TableModel tm = null;

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){

            stmt.setInt(1, give_id_paket);

            ResultSet rs = stmt.executeQuery();
            tm = DbUtils.resultSetToTableModel(rs); // konversi rs ke TableModel
            
        } catch (SQLException e) {
            System.err.println(e);
        }

        return tm;
    }
}