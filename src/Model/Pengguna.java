package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import View.All_Panel.nPanel_Account;
import net.proteanit.sql.DbUtils;

public class Pengguna {
    // private int id_pengguna;
    private String username;
    private String email;
    private String no_telepon;
    private String password;
    private String role;

    // REGISTER
    public void set_user_data(String give_username, String give_email, String give_no_telepon, String give_password,
            String give_role) {
        this.username = give_username;
        this.email = give_email;
        this.no_telepon = give_no_telepon;
        this.password = give_password;
        this.role = give_role;
    }

    public void insert_user() {
        String cmd = "INSERT INTO `pengguna`(`username`, `email`, `no_telepon`, `password`, `role`) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            stmt.setString(1, this.username);
            stmt.setString(2, this.email);
            stmt.setString(3, this.no_telepon);
            stmt.setString(4, this.password);
            stmt.setString(5, this.role);
            stmt.execute();

            System.out.println("[ USER DITAMBAHKAN ]");

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public void update_user(int give_id_pengguna) {
        String cmd = "UPDATE `pengguna` SET `username` = ?, `email` = ?, `no_telepon` = ?, `password` = ?, `role` = ? WHERE id_pengguna = ?";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            stmt.setString(1, this.username);
            stmt.setString(2, this.email);
            stmt.setString(3, this.no_telepon);
            stmt.setString(4, this.password);
            stmt.setString(5, this.role);
            stmt.setInt(6, give_id_pengguna);
            stmt.execute();

            System.out.println("[ USER DITAMBAHKAN ]");

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // LOGIN

    public static Enums.role get_user_role(String give_username, String give_password) {
        String cmd = "SELECT `username`, `password`, `role` FROM `pengguna` WHERE username = ? AND password = ?";

        Enums.role role = null;

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            stmt.setString(1, give_username);
            stmt.setString(2, give_password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String role_Str = rs.getString("role");
                role = Model.Enums.role.valueOf(role_Str.toUpperCase());

                System.out.println("[ AKSES LOGIN DITERIMA ]");
            } else {
                System.out.println("[ AKSES LOGIN DITOLAK ]");
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        return role;
    }

    public static String cek_user_data(String give_username) {
        String cmd = "SELECT username FROM pengguna WHERE username LIKE ?";

        String user = null;

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            stmt.setString(1, give_username);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                user = rs.getString("username");
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        return user;
    }

    public static void load_data_pengguna() {
        String cmd = "SELECT id_pengguna AS 'ID', username AS 'Username', email AS 'Email', no_telepon AS 'No Telepon', password AS 'Password', role AS 'Role' FROM pengguna;";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            ResultSet rs = stmt.executeQuery();// konversi rs ke TableModel
            nPanel_Account.table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // delete pengguna
    public static void delete_pengguna(int give_id_pengguna) {
        String cmd = "DELETE FROM `pengguna` WHERE id_pengguna = ?";

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {
            stmt.setInt(1, give_id_pengguna);
            stmt.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }

    }
}
