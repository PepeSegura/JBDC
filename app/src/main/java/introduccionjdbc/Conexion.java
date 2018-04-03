package introduccionjdbc;

import java.sql.*;

public class Conexion {
	private static String JDBC_URL = "jdbc:mysql://localhost:3306/sga?useSSL=false";
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String JDBC_USER = "root";
	private static String JDBC_PASS = "#ff0016#";
	private static Driver driver = null;

	public static synchronized Connection getConnection() throws SQLException {
		if (driver == null) {
			try {
				Class<?> jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}

	public static void close(ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement stmt) {

		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void close(Connection con) {

		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
