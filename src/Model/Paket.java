package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class Paket {
    private int id_paket;
    private String paket;
    private String deskripsi;
    private double harga;
    private int id_kategori;

    // TAMBAH paket
    
    public void set_data_paket(String give_paket, String give_deskripsi, double give_harga, int give_id_kategori){
        this.paket = give_paket;
        this.deskripsi = give_deskripsi;
        this.harga = give_harga;
        this.id_kategori = give_id_kategori;
    }
    
    public void insert_paket(){
        String cmd = "INSERT INTO `paket_layanan`(`nama_paket`, `deskripsi`, `harga`, `id_kategori`) VALUES (?, ?, ?, ?)";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setString(1, this.paket);
            stmt.setString(2, this.deskripsi);
            stmt.setDouble(3, this.harga);
            stmt.setInt(4, this.id_kategori);
            stmt.execute();

            System.out.println("[ PAKET DITAMBAHKAN ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    // UPDATE paket

    public void update_paket(int give_id_paket){
        String cmd = "UPDATE `paket_layanan` SET `nama_paket` = ?, `deskripsi` = ?, `harga` = ?, id_kategori = ? WHERE id_paket = ?)";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setString(1, this.paket);
            stmt.setString(2, this.deskripsi);
            stmt.setDouble(3, this.harga);
            stmt.setInt(4, this.id_kategori);
            stmt.setInt(5, give_id_paket);
            stmt.execute();

            System.out.println("[ PAKET DIPERBARUI ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // CEK paket

    public int get_id_paket(String give_paket, int give_id_kategori){
        String cmd = "SELECT `id_pesanan` FROM `pesanan` WHERE `id_pengguna` = ? AND `tanggal_pemesanan` = ?";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){

            stmt.setString(1, give_paket);
            stmt.setInt(2, give_id_kategori);

            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                id_paket = rs.getInt("id_paket");
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        }
        return id_paket;
    }

    public static TableModel load_data_paket(){
        String cmd = "SELECT a.nama_paket as Nama, b.nama_kategori as Kategori, a.harga_paket as Harga, a.status_paket FROM paket_layanan a, kategori_layanan b WHERE a.id_kategori=b.id_kategori;";

        TableModel tm = null;

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){

            ResultSet rs = stmt.executeQuery();
            tm = DbUtils.resultSetToTableModel(rs); // konversi rs ke TableModel
            
        } catch (SQLException e) {
            System.err.println(e);
        }

        return tm;
    }
}