package Model;

import View.Panel_Test;

import View.All_Panel.Panel_Insert_Layanan;
import View.All_Panel.nPanel_Layanan;
import java.lang.reflect.Array;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import net.proteanit.sql.DbUtils;

public class Layanan {
    private String layanan;
    private String deskripsi;
    private double harga;
    private int id_kategori;
    private String status;
    private String jenis;

    // TAMBAH LAYANAN

    public void set_data_layanan(String give_layanan, double give_harga, int give_id_kategori, String give_jenis) {
        this.layanan = give_layanan;
        this.harga = give_harga;
        this.id_kategori = give_id_kategori;
        this.jenis = give_jenis;
    }

    public void set_data_layanan(String give_layanan, String give_deskripsi, double give_harga, int give_id_kategori,
            String give_status, String give_jenis) {
        this.layanan = give_layanan;
        this.deskripsi = give_deskripsi;
        this.harga = give_harga;
        this.id_kategori = give_id_kategori;
        this.status = give_status;
        this.jenis = give_jenis;
    }

    public void insert_layanan() {
        String cmd = "INSERT INTO `layanan`(`nama_layanan`, `harga`, `id_kategori`, `jenis_layanan`) VALUES (?, ?, ?, ?)";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            stmt.setString(1, this.layanan);
            stmt.setDouble(2, this.harga);
            stmt.setInt(3, this.id_kategori);
            stmt.setString(4, this.jenis);
            stmt.execute();

            System.out.println("[ LAYANAN DITAMBAHKAN ]");

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // UPDATE LAYANAN

    public void update_layanan(int give_id_layanan) {
        String cmd = "UPDATE `layanan` SET `nama_layanan` = ?, `deskripsi` = ?, `harga` = ?, id_kategori = ?, status = ?, jenis_layanan = ? WHERE id_layanan = ?";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            stmt.setString(1, this.layanan);
            stmt.setString(2, this.deskripsi);
            stmt.setDouble(3, this.harga);
            stmt.setInt(4, this.id_kategori);
            stmt.setString(5, this.status);
            stmt.setString(6, this.jenis);
            stmt.setInt(7, give_id_layanan);
            stmt.execute();

            System.out.println("[ LAYANAN DIPERBARUI ]");

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // CEK LAYANAN

    public static void load_data_layanan() {
        String cmd = "SELECT l.id_layanan AS 'ID', l.nama_layanan AS 'Nama Layanan', k.nama_kategori AS 'Kategori', l.harga AS 'Harga', l.jenis_layanan AS 'Jenis', l.status AS 'Status' FROM layanan l JOIN kategori_layanan k ON l.id_kategori = k.id_kategori;";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            ResultSet rs = stmt.executeQuery();
            nPanel_Layanan.table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void load_layanan() {
        ArrayList<String> status = new ArrayList<>();

        String cmd = "SELECT nama_layanan AS 'Nama Layanan' FROM layanan";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            ResultSet rs = stmt.executeQuery();
            Panel_Test.table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    public static ArrayList<String> get_status_layanan() {
        ArrayList<String> status = new ArrayList<>();

        String cmd = "SELECT status_layanan FROM layanan";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                status.add(rs.getString("status_layanan"));
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        return status;
    }

    // delete layanan
    public static void delete_layanan(int give_id_kategori) {
        String cmd = "DELETE FROM `layanan` WHERE id_layanan = ?";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {
            stmt.setInt(1, give_id_kategori);
            stmt.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }

    }
}