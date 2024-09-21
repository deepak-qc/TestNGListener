package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class prac1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url= "://localhost:3306/";
		String dbName= "qafox";
		String dbURL= url + dbName;
		String userName= "root";
		String password= "root";
		
		Connection connection= null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql"+url+dbName , userName , password);
			if(!connection.isClosed()) {
				System.out.println("Successfully connected to qafox database");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("Select * from Employee");
				while(resultSet.next()) {
					System.out.println(resultSet.getString("Name")+" "+
				resultSet.getString("Location")+" "+resultSet.getInt("Experience"));
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				if(connection.isClosed()) {
					System.out.println("Connection of qafox database closed successfully!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
