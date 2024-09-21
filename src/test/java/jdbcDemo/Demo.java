package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "qafox";
		String dbURL = url + dbName;
		String username = "root";
		String password = "root";

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(dbURL, username, password);
			if (!connection.isClosed()) {
				System.out.println("Successfully connected to qafox database");
				// Executing the query
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from Employee");
				HashMap<String, String> hm = new HashMap<String, String>();
				List<String> columnNames = new ArrayList<String>();
				while (resultSet.next()) {
					ResultSetMetaData metaData = resultSet.getMetaData();
					int columnCount = metaData.getColumnCount();
					System.out.println("No of columns are: " + columnCount);
					for (int i = 1; i <= columnCount; i++) {
						String columnName = metaData.getColumnLabel(i);
						columnNames.add(columnName);
						hm.put(columnName, resultSet.getString(columnName));
					}
					System.out.println("============================================");
					System.out.println("hm value is: " + hm);
					System.out.println("List columnNames value is " + columnNames);
				}
			}
			// Close the database connection.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (connection.isClosed()) {
					System.out.println("Connection to qafox database successfully closed.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
