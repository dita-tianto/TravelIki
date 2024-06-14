package Model;

import View.All_Panel.Panel_Insert_Kategori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.TableModel;

// import net.proteanit.sql.DbUtils;
import net.proteanit.sql.DbUtils;

public class Kategori {
    private String kategori;

    // TAMBAH KATEGORI

    public void set_data_kategori(String give_kategori) {
        this.kategori = give_kategori;
    }

    public void insert_kategori() {
        String cmd = "INSERT INTO `kategori_layanan`(`nama_kategori`) VALUE (?)";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            stmt.setString(1, this.kategori);
            stmt.execute();

            System.out.println("[ KATEGORI DITAMBAHKAN ]");

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // UPDATE KATEGORI

    public void update_kategori(int give_id_kategori) {
        String cmd = "UPDATE `kategori_layanan` SET `nama_kategori` = ? WHERE `id_kategori` = ?";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            stmt.setString(1, this.kategori);
            stmt.setInt(2, give_id_kategori);
            stmt.execute();

            System.out.println("[ KATEGORI DIPERBARUI ]");

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // CEK KATEGORI

    public static void load_data_kategori() {
        String cmd = "SELECT * FROM `kategori_layanan`;";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            ResultSet rs = stmt.executeQuery();// konversi rs ke TableModel
            Panel_Insert_Kategori.table.setModel(DbUtils.resultSetToTableModel(rs));
 
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static int get_id_kategori(String give_kategori) {
        String cmd = "SELECT id_kategori FROM kategori_layanan WHERE nama_kategori = ?";

        int id = 0;

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            stmt.setString(1, give_kategori);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
            }

        } catch (Exception e) {

        }

        return id;
    }
}