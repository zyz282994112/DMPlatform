package model.platform;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.lang.System;


public class UserBean{
	/**
	 * @param args
	 * @throws SQLException 
	 * @throws NumberFormatException 
	 */
	
    public static void main(String[] args) throws NumberFormatException, SQLException {  
//        User user = new User();
        select(1);

    }

    public static User select(Integer id){
		User user = new User();
		try{
			 String sql ="SELECT `UserID`, `UserName`, `Profession`, `Company`, `CAddress`, `CPhone`, " +
			 		"`CEmail`, `UserEmail`, `UserMSN`, `UserQQ`, `UserMobile`, `UserPhone`," +
			 		"AES_DECRYPT(Password,\'abcdefg\') AS PASSWORD," +
			 		" `status`, `image`, `LoginTag`, `LastLoginTime` FROM `user` WHERE UserID = \'"+id + "\'";  
	         ResultSet rs = DBQuery.query(sql);
	         while(rs.next()){
	        	 user.setUserID(Integer.parseInt(rs.getString("UserID"))); 
	        	 user.setUserName(rs.getString("UserName"));
	        	 user.setProfession(rs.getString("Profession"));
	        	 user.setCompany(rs.getString("Company"));
	        	 user.setCAddress(rs.getString("CAddress"));
	        	 user.setCPhone(rs.getString("CPhone"));
	        	 user.setCEmail(rs.getString("CEmail"));
	        	 user.setUserEmail(rs.getString("UserEmail"));
	        	 user.setUserMSN(rs.getString("UserMSN"));
	        	 user.setUserQQ(rs.getString("UserQQ"));
	        	 user.setUserMobile(rs.getString("UserMobile"));
	        	 user.setUserPhone(rs.getString("UserPhone"));
	        	 user.setPassword((rs.getString("PASSWORD")));
	        	 user.setStatus(Integer.parseInt(rs.getString("status")));
	        	 user.setImagePath(rs.getString("image"));
	        	 user.setLogintag(Integer.parseInt(rs.getString("LoginTag")));
	        	 user.setLastLoginTime(Timestamp.valueOf(rs.getString("LastLoginTime")));
	         }
	         DBQuery.closeDB();   
	              
	        } catch (SQLException e) {  
	         System.out.println("query failed:" + e.getMessage());  
	        }	
    	
    	return user;
    }
    
	public static List<User> selectlist(String sql){
    	List<User> alluser = new ArrayList<User>();
		try{
			 User user;
		//	 String sql ="SELECT * FROM `user`";
			 ResultSet rs = DBQuery.query(sql);
	         while(rs.next()){
				 user = new User();
				 user.setUserID(Integer.parseInt(rs.getString("UserID"))); 
	        	 user.setUserName(rs.getString("UserName"));
	        	 user.setProfession(rs.getString("Profession"));
	        	 user.setCompany(rs.getString("Company"));
	        	 user.setCAddress(rs.getString("CAddress"));
	        	 user.setCPhone(rs.getString("CPhone"));
	        	 user.setCEmail(rs.getString("CEmail"));
	        	 user.setUserEmail(rs.getString("UserEmail"));
	        	 user.setUserMSN(rs.getString("UserMSN"));
	        	 user.setUserQQ(rs.getString("UserQQ"));
	        	 user.setUserMobile(rs.getString("UserMobile"));
	        	 user.setUserPhone(rs.getString("UserPhone"));
	        	 user.setPassword((rs.getString("Password")));
	        	 user.setStatus(Integer.parseInt(rs.getString("status")));
	        	 user.setImagePath(rs.getString("image"));
	        	 user.setLogintag(Integer.parseInt(rs.getString("LoginTag")));
	        	 user.setLastLoginTime(Timestamp.valueOf(rs.getString("LastLoginTime")));
	        	 alluser.add(user); 
	         }
	         DBQuery.closeDB();  
	              
	        } catch (SQLException e) {  
	         System.out.println("query failed:" + e.getMessage());  
	        }	
    	
    	return alluser;
    }
       
	public static User insert(User user) {
        try {  
            String sql = "INSERT INTO `user`(`UserName`, `Profession`, " +
            		"`Company`, `CAddress`, `CPhone`, `CEmail`, `UserEmail`, " +
            		"`UserMSN`, `UserQQ`, `UserMobile`, `UserPhone`, `Password`," +
            		"`status`,`image`) VALUES (" +
            		"\'" +user.getUserName()+"\'"+","+
            		"\'" +user.getProfession()+"\'"+","+
            		"\'" +user.getCompany()+"\'"+","+
            		"\'" +user.getCAddress()+"\'"+","+
            		"\'" +user.getCPhone()+"\'"+","+
            		"\'" +user.getCEmail()+"\'"+","+
            		"\'" +user.getUserEmail()+"\'"+","+
            		"\'" +user.getUserMSN()+"\'"+","+
            		"\'" +user.getUserQQ()+"\'"+","+
            		"\'" +user.getUserMobile()+"\'"+","+
            		"\'" +user.getUserPhone()+"\'"+","+
            		"AES_ENCRYPT(\'" +user.getPassword()+"\',\'abcdefg\')"+","+
            		"\'" +0+"\'"+","+
            		"\'" +user.getImagePath()+"\'"+
            		")"; 
            ResultSet rs = DBQuery.Update(sql);
            while(rs.next()){
                user.setUserID(Integer.parseInt(rs.getString(1)));
            }
            System.out.println("insert:"+user.getUserID()); 
            DBQuery.closeDB();
              
        } catch (SQLException e) {  
        	System.out.println("insert failed" + e.getMessage());
        }
        return user;
	}

	public static User update(User user) {
		
        try {  
            String sql = "UPDATE `user` SET " +
            		"UserName =\'" +user.getUserName()+"\'"+","+
            		"Profession=\'" +user.getProfession()+"\'"+","+
            		"Company=\'" +user.getCompany()+"\'"+","+
            		"CAddress=\'" +user.getCAddress()+"\'"+","+
            		"CPhone=\'" +user.getCPhone()+"\'"+","+
            		"CEmail=\'" +user.getCEmail()+"\'"+","+
            		"UserEmail=\'" +user.getUserEmail()+"\'"+","+
            		"UserMSN=\'" +user.getUserMSN()+"\'"+","+
            		"UserQQ=\'" +user.getUserQQ()+"\'"+","+
            		"UserMobile=\'" +user.getUserMobile()+"\'"+","+
            		"UserPhone=\'" +user.getUserPhone()+"\'"+","+
            		"LoginTag=" +user.getLogintag()+","+
            		"image=\'" +user.getImagePath()+"\'"+","+
            		"status=\'" +user.getStatus()+"\'"+","+
            		"LastLoginTime=\'" +user.getLastLoginTime()+"\'"+","+
            		"Password=AES_ENCRYPT(\'" +user.getPassword()+"\',\'abcdefg\')"+
            		" WHERE UserID = \'" + user.getUserID() + "\'"
            		;  
            
            DBQuery.Update(sql);
            DBQuery.closeDB();
            System.out.println("update success!"); 
            user = select(user.getUserID());
           return user; 
              
        } catch (SQLException e) {  
            System.out.println("update failed" + e.getMessage());  
        }
        
        return null;
	}

	public static Boolean delete(Integer id){
		
		try{
			 String sql ="DELETE FROM `user` WHERE UserID = \'"+id + "\'";
			 DBQuery.Update(sql);
	         DBQuery.closeDB();
	         System.out.println("delete success"); 
	         return true; 
	              
	        } catch (SQLException e) {  
	        	System.out.println("delete failed"+ e.getMessage());  
	            return false;
	        }	
		}
	
	public static Integer login(String username,String password){
		Integer id = -1;
		try{
			 String sql ="SELECT `UserID` FROM `user` WHERE UserName = \'"+username + "\' AND Password = AES_ENCRYPT( \'" + password + "\',\'abcdefg\')";
			 ResultSet rs = DBQuery.query(sql);
			 while(rs.next()){
	        	 id = Integer.parseInt(rs.getString("UserID")); 
	         }
	         DBQuery.closeDB();  
	        } catch (SQLException e) {  
	         System.out.println("query failed:" + e.getMessage());  
	        }	
    	
    	return id;	
	}
	
}
