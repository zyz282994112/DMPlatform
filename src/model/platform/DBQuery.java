package model.platform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.System;

public class DBQuery {
	
	private static Connection conn;  
	 
	private static Statement st;  
	
	private static ResultSet rs;
	
	private static String url;
	
	private static String useUnicode;
	
	private static String characterEncoding;
	
	private static String username;
	
	private static String password;
	
	private static String className;
	
	public static void
    init(String className,String url,String characterEncoding,String useUnicode,String username,String password){
		DBQuery.className = className;
		DBQuery.username = username;
		DBQuery.url = url;
		DBQuery.password = password;
		DBQuery.useUnicode = useUnicode;
		DBQuery.characterEncoding = characterEncoding;
		
	}
	
	public synchronized static Connection getConnection() {
		// TODO Auto-generated method stub
		Connection con = null;  
        try {  
        	
            Class.forName(className);// 
            con = DriverManager.getConnection(url+"?useUnicode="+useUnicode+"&characterEncoding="+characterEncoding, username, password);//  
    		System.out.println("connect success"); 
              
        } catch (Exception e) {  
            System.out.println("connect failed:" + e.getMessage()); 
        }  
        return con; 
    }  
	
	public static ResultSet query(String sql) {  
        System.out.println("start query");  
        conn = getConnection();
        try {  
            st = conn.createStatement();   
            rs = st.executeQuery(sql);  
            System.out.println("query success!"); 
            return rs;  
        } catch (SQLException e) {  
            System.out.println("query failed:"+e.getMessage());  
            return null;  
        }    
    }  

	public static ResultSet Update(String sql) {  
        System.out.println("start update");  
        conn = getConnection();
        try {   
            st = conn.createStatement();    
            st.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);  
            rs = st.getGeneratedKeys();    
            System.out.println("update success");
            return rs;  
        } catch (SQLException e) {  
            System.out.println("update failed:"+e.getMessage()+sql);  
            return null;  
        }    
    }  
	
	public static int Update(String sql, boolean returnRowCountAffected) {  
        System.out.println("start update");  
        conn = getConnection();
        try {   
            st = conn.createStatement();    
            int rowCount = st.executeUpdate(sql);  
            System.out.println("update success");
            return rowCount;
        } catch (SQLException e) {  
            System.out.println("update failed:"+e.getMessage()+sql);  
            return 0;  
        }    
    } 
	
	public static void closeDB() throws SQLException{  
		try{
			rs.close(); 
	        System.out.println("rs close");  
			st.close(); 
			System.out.println("st close");
			conn.close();
			System.out.println("conn close");
		}catch (SQLException e) {  
            System.out.println("close failed:"+e.getMessage());  
        }
	}

}
