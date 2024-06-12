package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class Layanan {
    private String layanan;
    private String deskripsi;
    private double harga;
    private int id_kategori;

    // TAMBAH LAYANAN
    
    public void set_data_layanan(String give_layanan, String give_deskripsi, double give_harga, int give_id_kategori){
        this.layanan = give_layanan;
        this.deskripsi = give_deskripsi;
        this.harga = give_harga;
        this.id_kategori = give_id_kategori;
    }
    
    public void insert_layanan(){
        String cmd = "INSERT INTO `layanan`(`nama_layanan`, `deskripsi`, `harga`, `id_kategori`) VALUES (?, ?, ?, ?)";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setString(1, this.layanan);
            stmt.setString(2, this.deskripsi);
            stmt.setDouble(3, this.harga);
            stmt.setInt(4, this.id_kategori);
            stmt.execute();

            System.out.println("[ LAYANAN DITAMBAHKAN ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    // UPDATE LAYANAN

    public void update_layanan(int give_id_layanan){
        String cmd = "UPDATE `layanan` SET `nama_layanan` = ?, `deskripsi` = ?, `harga` = ?, id_kategori = ? WHERE id = ?)";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setString(1, this.layanan);
            stmt.setString(2, this.deskripsi);
            stmt.setDouble(3, this.harga);
            stmt.setInt(4, this.id_kategori);
            stmt.setInt(5, give_id_layanan);
            stmt.execute();

            System.out.println("[ LAYANAN DIPERBARUI ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // CEK LAYANAN

    public static TableModel load_data_layanan(){
        String cmd = "SELECT a.nama_layanan as Nama, b.nama_kategori as Kategori, a.harga as Harga, a.status_layanan FROM layanan a, kategori_layanan b WHERE a.id_kategori=b.id_kategori;";

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