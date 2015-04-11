package model.dataset;

import java.sql.*;

public class ConnDB {
	
private Connection conn=null;

	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1:3306/dataminingplatform"
					+"?useUnicode=true&characterEncoding=UTF-8";
			String name="jssysyx";//username
			String password="jssysyx";//password
			conn=DriverManager.getConnection(url,name,password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return conn;
	}
}
