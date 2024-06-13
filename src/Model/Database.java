package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://Localhost:3306/traveliki";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection(){
        Connection con = null;

		try {
			Class.forName(JDBC_DRIVER);

			con = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("[ KONEKSI BERHASIL ]");
		} catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }

		return con;
    }

    public static Connection getconnection(){
        Connection con = null;

		try {
			Class.forName(JDBC_DRIVER);

			con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/shop_management", USER, PASS);

            System.out.println("[ KONEKSI BERHASIL ]");
		} catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }

		return con;
    }
}
