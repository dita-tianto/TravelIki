package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login_Employee {

	public static String emp_data_chek(String give_username, String give_password, String give_rol) {
		Connection obj = Database.getConnection();

		String comnd = "SELECT `username`, `password` FROM `login_employee` WHERE username=? AND password=? AND role=?";

		String user = null;
		String pass;

		try {
			PreparedStatement ps = obj.prepareStatement(comnd);
			ps.setString(1, give_username);
			ps.setString(2, give_password);
			ps.setString(3, give_rol);
			ps.execute();
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = rs.getString("username");
				pass = rs.getString("password");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	private static Connection getconnection() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getconnection'");
	}

	public static String username_exist_emp(String give_username) {
		Connection obj = Database.getConnection();

		String comnd = "SELECT username FROM login_employee WHERE username=?";

		String user = null;

		try {
			PreparedStatement ps = obj.prepareStatement(comnd);
			ps.setString(1, give_username);

			ps.execute();
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = rs.getString("username");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
