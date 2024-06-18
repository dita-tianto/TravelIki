package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.TableModel;

import View.All_Panel.nPanel_Pembayaran;
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

    public static void load_data_pembayaran(){
        String cmd = "SELECT p.id_pesanan AS 'ID Pesanan', b.tanggal_pembayaran AS 'Tanggal Pembayaran', b.bayar AS 'Nominal Pembayaran' FROM pembayaran b JOIN pemesanan p ON b.id_pesanan = p.id_pesanan;";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            ResultSet rs = stmt.executeQuery();// konversi rs ke TableModel
            nPanel_Pembayaran.table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}