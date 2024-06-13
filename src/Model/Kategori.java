package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class Kategori {
    private String kategori;

    // TAMBAH KATEGORI
    
    public void set_data_kategori(String give_kategori){
        this.kategori = give_kategori;
    }
    
    public void insert_kategori(){
        String cmd = "INSERT INTO `kategori`(`nama_kategori`) VALUE (?)";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setString(1, this.kategori);
            stmt.execute();

            System.out.println("[ KATEGORI DITAMBAHKAN ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // UPDATE KATEGORI

    public void update_kategori(int give_id_kategori){
        String cmd = "UPDATE `kategori` SET `kategori` = ? WHERE `id_kategori` = ?";

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setString(1, this.kategori);
            stmt.setInt(1, give_id_kategori);
            stmt.execute();

            System.out.println("[ KATEGORI DIPERBARUI ]");    

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // CEK KATEGORI

    public static void load_data_kategori(){
        String cmd = "SELECT * FROM `kategori_layanan` WHERE 1;";

        TableModel tm = null;

        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(cmd)){

            ResultSet rs = stmt.executeQuery();
            tm = DbUtils.resultSetToTableModel(rs); // konversi rs ke TableModel
            
        } catch (SQLException e) {
            System.err.println(e);
        }

    }
}