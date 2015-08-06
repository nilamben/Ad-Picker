import java.sql.*;

public class DbConnect {

	public static void main(String[] args) {
		// Create a variable for connection string.
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
				+ "databaseName=AdPicker_db;user=sa;password=power";

		// Declare the jdbc objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute some sql statement that returns some data.
			String query = "SELECT * FROM Ads";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			// Iterate through data in resultset to display data
			while (rs.next()) {
				System.out.println(rs.getString("Keyword") + " "
						+ rs.getInt("Category_Id"));
				// System.out.println(rs);
			}
		}
		// Handle any errors that may have occurred
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

	}

}
