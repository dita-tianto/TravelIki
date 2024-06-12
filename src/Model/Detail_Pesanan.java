package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public void set_detail_pesanan(int give_id_pesanan, int give_id_layanan, int give_id_paket, int give_kuantitas, double give_harga_satuan, double give_subtotal){
        this.id_pesanan = give_id_pesanan;
        this.id_layanan = give_id_layanan;
        this.id_paket = give_id_paket;
        this.kuantitas = give_kuantitas;
        this.harga_satuan = give_harga_satuan;
        this.subtotal = give_subtotal;
    }
    
    public void insert_detail_pesanan(){
        String cmd = "INSERT INTO `detail_pesanan`(`id_layanan`, `id_paket`, `kuantitas`, `harga_satuan`, `subtotal`) VALUES (?, ?, ?, ?, ?)";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setInt(1, this.id_layanan);
            stmt.setInt(2, this.id_paket);
            stmt.setInt(3, this.kuantitas);
            stmt.setDouble(4, this.harga_satuan);
            stmt.setDouble(5, this.subtotal);
            stmt.execute();

            System.out.println("[ DETAIL PESANAN DITAMBAHKAN ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    // UPDATE LAYANAN

    public void update_detail_pesanan(int give_id_detail_pesanan){
        String cmd = "UPDATE `detail_pesanan` SET `id_layanan` = ?, `id_paket` = ?, `kuantitas` = ?, harga_satuan = ?, subtotal = ? WHERE id_detail_pesanan = ?)";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
                stmt.setInt(1, this.id_layanan);
                stmt.setInt(2, this.id_paket);
                stmt.setInt(3, this.kuantitas);
                stmt.setDouble(4, this.harga_satuan);
                stmt.setDouble(5, this.subtotal);
                stmt.setInt(5, give_id_detail_pesanan);
                stmt.execute();

            System.out.println("[ DETAIL PESANAN DIPERBARUI ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // CEK LAYANAN

    public static TableModel load_data_detail_pesanan(){
        String cmd = "SELECT a.id_detail_pesanan, a.id_pesanan, a.id_layanan, a.id_paket, a.kuantitas, a.harga_satuan, a.subtotal FROM detail_pesanan a JOIN pemesanan b ON a.id_pesanan = b.id_pesanan JOIN layanan c ON a.id_layanan = c.id_layanan JOIN paket_layanan d ON a.id_paket = d.id_paket;";

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