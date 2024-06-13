import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Database;

public class Main {
    public static void main(String[] args) throws Exception {
        String cmd = "SELECT username FROM pengguna WHERE username LIKE ?";

        String user = null;

        try (Connection con = Database.getConnection();
                PreparedStatement stmt = con.prepareStatement(cmd)) {

            stmt.setString(1, "a");

            ResultSet rs = stmt.executeQuery();

            if(rs.next())
            user = rs.getString("username");

        } catch (SQLException e) {
            System.err.println(e);
        }

        System.out.println(user);
    }
}
