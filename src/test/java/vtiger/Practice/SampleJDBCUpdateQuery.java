package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCUpdateQuery {

	public static void main(String[] args) throws SQLException {
		Driver driverRef = new Driver();
		Connection con = null;
		
		try 
		{
			
		
			//Step 1 : Register the driver/Database
			DriverManager.registerDriver(driverRef);
			
			//Step 2 : get the connection with database - use database name
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
			
			//Step 3 : issue create statement
			Statement state = con.createStatement();
			
			//Step 4 : execute the query -use table name
			 int result = state.executeUpdate("UPDATE customerinfo SET name='Chaitra' WHERE id=12;");
			
			//Step 5 : close the database
			
			System.out.println(result);
			
			if (result == 1) {
				System.out.println("Data is Updated");
			} else {
				System.out.println("Someting went Wrong;");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.close();
			System.out.println("Connection Closed;");
		}
		
	}

}
