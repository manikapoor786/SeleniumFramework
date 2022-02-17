package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public void dbconnection() throws SQLException
	{
		Connection con= DriverManager.getConnection("jdbc:mysql://" +"localhost" + ":"+3306+ "/Selenium", "INFOCORP\\manish.kapoor", "Sheena@786");
	}
	
}
