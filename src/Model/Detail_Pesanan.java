package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class Detail_Pesanan {
    private int id_pesanan;
    private int id_layanan;
    private int id_paket;
    private int kuantitas;
    private double harga_satuan;
    private double subtotal;


    // TAMBAH PESANAN
    
    public void set_data_pesanan(int give_id_pesanan, int give_id_layanan, int give_id_paket, int give_kuantitas, double give_harga_satuan, double give_subtotal){
        this.id_pesanan = give_id_pesanan;
        this.id_layanan = give_id_layanan;
        this.id_paket = give_id_paket;
        this.kuantitas = give_kuantitas;
        this.harga_satuan = give_harga_satuan;
        this.subtotal = give_subtotal;
    }
    
    public void insert_pesanan(){
        String cmd = "INSERT INTO `pesanan`(`id_pengguna`, `tanggal_pemesanan`, `total_harga`) VALUES (?, ?, ?)";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setInt(1, this.id_pengguna);
            stmt.setString(2, this.tanggal_pemesanan);
            stmt.setDouble(3, this.total_harga);
            stmt.execute();

            System.out.println("[ PESANAN DITAMBAHKAN ]");    

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