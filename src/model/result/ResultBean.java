package model.result;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.System;

import model.platform.DBQuery;

public class ResultBean {
	public static void main(String[] args) throws NumberFormatException, SQLException {  
        
        RESULT result1 = select(1);
        System.out.println(result1.getResultName());
        
        List<RESULT> result2 = selectAll();
        System.out.println(result2.get(0).getResultName());
        
        RESULT result3 = new RESULT();
        result3.setResultID(2);
        result3.setResultName("light");
        result3 = update(result3);
        System.out.println(result3.getResultName());
        
    }
	
	public static RESULT select(int id) {
		RESULT result = new RESULT();
		String sql = "SELECT * FROM `result` WHERE ResultID = " + id;
		try {
			ResultSet rs = DBQuery.query(sql);
	         while(rs.next()){
	        	 result.setResultID(rs.getInt("ResultID"));
	        	 result.setResultName(rs.getString("ResultName"));
	        	 result.setResultPath(rs.getString("ResultPath"));
	        	 result.setTaskID(rs.getInt("TaskID"));
	        	 result.setTaskName(rs.getString("TaskName"));
	        	 result.setTIID(rs.getInt("TIID"));
	        	 result.setTIName(rs.getString("TIName"));
	        	 result.setResultType(rs.getString("ResultType"));
	        	 result.setResultTime(rs.getString("ResultTime"));
	        	 result.setResultDescription(rs.getString("ResultDescription"));
	         }
	         DBQuery.closeDB();   
		} catch (SQLException e) {  
	         System.out.println("query failed:" + e.getMessage());  
	    }	
   	
		return result;
	}
	
	public static List<RESULT> selectAll() {
		List<RESULT> allResult = new ArrayList<RESULT>();
		String sql = "SELECT * FROM `result`";
		try {
			ResultSet rs = DBQuery.query(sql);
	         while(rs.next()){
	        	 RESULT result = new RESULT();
	        	 result.setResultID(rs.getInt("ResultID"));
	        	 result.setResultName(rs.getString("ResultName"));
	        	 result.setResultPath(rs.getString("ResultPath"));
	        	 result.setTaskID(rs.getInt("TaskID"));
	        	 result.setTaskName(rs.getString("TaskName"));
	        	 result.setTIID(rs.getInt("TIID"));
	        	 result.setTIName(rs.getString("TIName"));
	        	 result.setResultType(rs.getString("ResultType"));
	        	 result.setResultTime(rs.getString("ResultTime"));
	        	 result.setResultDescription(rs.getString("ResultDescription"));
	        	 allResult.add(result);
	         }
	         DBQuery.closeDB();   
		} catch (SQLException e) {  
	         System.out.println("query failed:" + e.getMessage());  
	    }
		return allResult;
	}
	
	public static RESULT insert(RESULT result) {
		String sql = "INSERT INTO `result` "
				+ "(ResultName, ResultPath, TaskID, TaskName, " 
				+ "TIID, TIName, ResultType, ResultTime, " 
				+ "ResultDescription) VALUE ('"
				+ result.getResultName() + "', '"
				+ result.getResultPath() + "', "
				+ result.getTaskID() + ", '"
				+ result.getTaskName() + "', "
				+ result.getTIID() + ", '"
				+ result.getTIName() + "', '"
				+ result.getResultType() + "', "
				+ result.getResultTime() + ", '"
				+ result.getResultDescription() + "')";
		System.out.println(sql);
		try {
			ResultSet rs = DBQuery.Update(sql);
			if(rs!=null)
            while(rs.next()){
                result.setResultID(rs.getInt("ResultID"));
            }
            System.out.println("insert:" + result.getResultID()); 
            DBQuery.closeDB();
		} catch (SQLException e) {
			System.out.println("query failed:" + e.getMessage());  
		}
		return result;
	}
	
	public static RESULT update(RESULT result) {
		String sql = "UPDATE `result` SET "
				+ "ResultName = '" + result.getResultName() + "', "
				+ "ResultPath = '" + result.getResultPath() + "', "
				+ "TaskID = " + result.getTaskID() + ", "
				+ "TaskName = '" + result.getTaskName() + "', "
				+ "TIID = " + result.getTIID() + ", "
				+ "TIName = '" + result.getTIName() + "', "
				+ "ResultType = '" + result.getResultType() + "', "
				+ "ResultTime = " + result.getResultTime() + ", "
				+ "ResultDescription = '" + result.getResultDescription() + "' "
				+ "WHERE ResultID = " + result.getResultID();
		try {
			DBQuery.Update(sql);
            DBQuery.closeDB();
            System.out.println("update success"); 
            result = select(result.getResultID());
            return result; 
		} catch (SQLException e) {
			System.out.println("query failed:" + e.getMessage());
		}
		
		return null;
	}
	
	public static String delete(int id) {
		String sql ="DELETE FROM `result` WHERE ResultID = "+id;
		try {
			DBQuery.Update(sql);
	        DBQuery.closeDB();
	        System.out.println("delete success"); 
	        return "successfully"; 
		} catch (SQLException e) {  
            return "delete failed"+ e.getMessage();  
        }
	}
}