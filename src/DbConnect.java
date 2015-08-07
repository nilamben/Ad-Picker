import java.sql.*;

public class DbConnect {

	public static void main(String[] args) {

		/*
		 * MSSQL // Create a variable for connection string. String
		 * connectionUrl = "jdbc:sqlserver://localhost:1433;" +
		 * "databaseName=AdPicker_db;user=sa;password=power";
		 * 
		 * // Declare the jdbc objects. Connection con = null; Statement stmt =
		 * null; ResultSet rs = null;
		 * 
		 * try { // Establish the connection.
		 * Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =
		 * DriverManager.getConnection(connectionUrl);
		 * 
		 * // Create and execute some sql statement that returns some data.
		 * String query = "SELECT * FROM Ads"; stmt = con.createStatement(); rs
		 * = stmt.executeQuery(query);
		 * 
		 * // Iterate through data in resultset to display data while
		 * (rs.next()) { System.out.println(rs.getString("Keyword") + " " +
		 * rs.getInt("Category_Id")); // System.out.println(rs); } } // Handle
		 * any errors that may have occurred catch (Exception ex) {
		 * ex.printStackTrace(); } finally { if (rs != null) try { rs.close(); }
		 * catch (Exception e) { } if (stmt != null) try { stmt.close(); } catch
		 * (Exception e) { } if (con != null) try { con.close(); } catch
		 * (Exception e) { } }
		 */

		// Sqlite

		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:Ad_Picker_db.db");
			System.out.println("Opened DB successfully");

			stmt = con.createStatement();
			String query = "CREATE TABLE Category(Id INT PRIMARY KEY NOT NULL, Name VARCHAR(255))";
			stmt.executeUpdate(query);
			
			query = "INSERT INTO Category(Id, Name) VALUES (1, 'Film & Animation')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (2, 'Autos & Vehicles')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (10, 'Music')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (15, 'Pets & Animals')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (17, 'Sports')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (18, 'Short Movies')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (19, 'Travel & Events')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (20, 'Gaming')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (21, 'Videoblogging')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (22, 'People & Blogs')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (23, 'Comedy')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (24, 'Entertainment')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (25, 'News & Politics')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (26, 'Howto & Style')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (27, 'Education')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (28, 'Science & Technology')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (29, 'Nonprofits & Activism')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (30, 'Movies')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (31, 'Anime/Animation')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (32, 'Action/Adventure')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (33, 'Classics')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (34, 'Comedy')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (35, 'Documentary')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (36, 'Drama')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (37, 'Family')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (38, 'Foreign')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (39, 'Horror')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (40, 'Sci-Fi/Fantasy')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (41, 'Thriller')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (42, 'Shorts')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (43, 'Shows')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Category(Id, Name) VALUES (44, 'Trailers')";
			stmt.executeUpdate(query);
			
			
			
			query = "CREATE TABLE Ads(Keyword VARCHAR(255),"
					+ "Category_Id INT,"					
					+ "Image_path VARCHAR(255),"
					+ "FOREIGN KEY(Category_Id) REFERENCES Category(Id))";									
			stmt.executeUpdate(query);
			
			query = "INSERT INTO Ads(Keyword, Category_Id, Image_path) values ('Star, Tensports,F1, Race, Cricket, Tennis, Kabaddi, Sachin, Brett lee', 17, '')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Ads(Keyword, Category_Id, Image_path) values ('Java, Tutorial, Programming, Python, .Net, Excersizes, Sample, Javascript', 27, '')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Ads(Keyword, Category_Id, Image_path) values ('Comedy, Circus, Mahabali, laughter', 34, '')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Ads(Keyword, Category_Id, Image_path) values ('Movies, Animation, English, Hindi,cartoon', 1, '')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Ads(Keyword, Category_Id, Image_path) values ('Documentary, body of henry, Indian Army', 35, '')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Ads(Keyword, Category_Id, Image_path) values ('Songs, Video songs, Coming home, let it go, music', 10, '')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Ads(Keyword, Category_Id, Image_path) values ('Super mario, rubiks, board, games, video', 20, '')";
			stmt.executeUpdate(query);
			query = "INSERT INTO Ads(Keyword, Category_Id, Image_path) values ('Daddys, home, car, official, trailor, furniture, housing, movie ', 44, '')";
			stmt.executeUpdate(query);
			
			stmt.close();
			con.close();
			
		} catch (Exception ex) {
			System.err
					.println(ex.getClass().getName() + ": " + ex.getMessage());
			System.exit(0);
		}

		System.out.println("Tables created successfully");
	}
}
