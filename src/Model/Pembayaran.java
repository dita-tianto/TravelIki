package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class Pembayaran {
    private int id_pesanan;
    private String tanggal_pembayaran;
    private double bayar;


    // TAMBAH PEMBAYARAN
    
    public void set_data_pesanan(int give_id_pesanan, String give_tanggal_pembayaran, double give_bayar){
        this.id_pesanan = give_id_pesanan;
        this.tanggal_pembayaran = give_tanggal_pembayaran;
        this.bayar = give_bayar;
    }
    
    public void insert_pesanan(){
        String cmd = "INSERT INTO `pembayaran`(`tanggal_pembayaran`, `bayar`) VALUES (?, ?) WHERE id_pesanan = ?";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setString(1, this.tanggal_pembayaran);
            stmt.setDouble(2, this.bayar);
            stmt.setInt(3, this.id_pesanan);
            stmt.execute();

            System.out.println("[ PEMBAYARAN BERHASIL ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    // CEK PEMBAYARAN 

    public static TableModel cek_pembayaran(int give_id_pembayaran){ //selalu hitung setelah insert pesanan
        String cmd = "SELECT * FROM `pembayaran` WHERE id_pembayaran = ?";

        TableModel tm = null;

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){

            stmt.setInt(1, give_id_pembayaran);

            ResultSet rs = stmt.executeQuery();
            tm = DbUtils.resultSetToTableModel(rs); // konversi rs ke TableModel
            
        } catch (SQLException e) {
            System.err.println(e);
        }

        return tm;
    }
}