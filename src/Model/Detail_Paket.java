package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class Detail_Paket {
    private int id_paket;
    private int id_layanan;

    // TAMBAH KATEGORI
    
    public void set_data_paket(int give_id_paket, int give_id_layanan){
        this.id_paket = give_id_paket;
        this.id_layanan = give_id_layanan;
    }
    
    public void insert_layanan(){
        String cmd = "INSERT INTO `detail_paket_layanan`(`id_paket`, `id_layanan`) VALUE (?, ?)";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setInt(1, this.id_paket);
            stmt.setInt(2, this.id_layanan);
            stmt.execute();

            System.out.println("[ DETAIL PAKET DITAMBAHKAN ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // CEK KATEGORI

    public static TableModel load_detail_paket(){
        String cmd = "SELECT * FROM `detail_paket_layanan` WHERE 1;";

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