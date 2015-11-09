import java.sql.*;

public class HotelDB {
	
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost/testdb";

		static final String USER = "root";
		static final String PASS = "ilya";

		public static void main(String[] args) {

			String pathToCSV = "C:\\Users\\Ilya\\Downloads\\Reservation\\Reservation\\CustomerData.csv";
			ReservationData entry = Csv2Reservation.convert2csv(pathToCSV);
			updateTable(entry);
			queryTable();

		} // end main

		private static void queryTable() {

			Connection conn = null;
			Statement stmt = null;
			try {
				// STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				stmt = conn.createStatement();
				String sql;
				sql = "SELECT * FROM HOTELDB";
				ResultSet rs = stmt.executeQuery(sql);

				// STEP 5: Extract data from result set
				while (rs.next()) {
					// Retrieve by column name
					int id = rs.getInt("ID");
					String checkIn = rs.getString("CHECKIN");
					String checkOut = rs.getString("CHECKOUT");
					int guestNum = rs.getInt("GUESTNUM");

					// Display values
					System.out.print("ID: " + id);
					System.out.print(", CHECKIN: " + checkIn);
					System.out.print(", CHECKOUT: " + checkOut);
					System.out.print(", GUESTNUM: " + guestNum + "\n");
				}

				// STEP 6: Clean-up environment
				rs.close();

				stmt.close();
				conn.close();
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally try
			} // end try
			System.out.println("End Query Data");
		}

		private static void updateTable(ReservationData data) {

			Connection conn = null;
			Statement stmt = null;
			try {
				// STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				System.out.println("Adding row in given database...");
				


				String sql = "INSERT INTO HOTELDB (CHECKIN, CHECKOUT, GUESTNUM, ROOMNUM, "
						+ "LNAME, FNAME, STREET, CITY, PROVINCE, COUNTRY, "
						+ "POSTALCODE, PHONENUMBER, EMAIL, CCTYPE, CCNAME, "
						+ "CCNUMBER, CCEXPIRY) VALUES ('" +
						data.checkIn + "', '" + 
						data.checkOut + "', '" + 
						data.guestNum + "', '" + 
						data.roomNum + "', '" + 
						data.lName + "', '" + 
						data.fName + "', '" + 
						data.street + "', '" + 
						data.city + "', '" + 
						data.province + "', '" + 
						data.country + "', '" + 
						data.postalCode + "', '" + 
						data.phoneNumber + "', '" + 
						data.email + "', '" + 
						data.ccType + "', '" + 
						data.ccName + "', '" + 
						data.ccNumber + "', '" + 
						data.ccExpiry + "');";
				System.out.println(sql);
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);




				stmt.close();
				conn.close();
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally try
			} // end try
			System.out.println("End Insert Table!");

		}


}
