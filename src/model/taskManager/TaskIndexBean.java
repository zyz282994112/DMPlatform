package model.taskManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.platform.DBQuery;

public class TaskIndexBean {
	private int UserID;

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}
	
	public List<Task> getTask1(int UserID) throws SQLException{
		List<Task> list = new ArrayList<Task>();
		
		String sql = "select * from " +
				"task,user,algorithm,ds" +
				" where task.UserID =" + UserID +
				"and task.UserID = user.UserID" +
				"and task.AlgorithmID = algorithm.AlgorithmID" +
				"and task.TaskDSID = ds.DSID";
		ResultSet rs = DBQuery.query(sql);
		while (rs.next()) {
			
			Task task = new Task();
			if(rs.getString("TaskID") != null){
				task.setTaskID(rs.getString("TaskID").toString());
			}
			if(rs.getString("TaskName") != null){
				task.setTaskName(rs.getString("TaskName").toString());
			}			
			if(rs.getString("UserID") != null){
				task.setUserID(rs.getString("UserID").toString());
			}
			if(rs.getString("TaskConfiguration") != null){
				task.setTaskConfiguration(rs.getString("TaskConfiguration").toString());
			}
			if(rs.getString("TaskDSID") != null){
				task.setTaskDSID(rs.getString("TaskDSID").toString());
			}
			if(rs.getString("TaskCreateTime") != null){
				task.setTaskCreateTime(rs.getString("TaskCreateTime").toString());
			}
			if(rs.getString("TaskChangeTime") != null){
				task.setTaskChangeTime(rs.getString("TaskChangeTime").toString());
			}
			if(rs.getString("TaskDescription") != null){
				task.setTaskDescription(rs.getString("TaskDescription").toString());
			}
			if(rs.getString("TaskPriority") != null){
				task.setTaskPriority(rs.getString("TaskPriority").toString());
			}
			if(rs.getString("AlgorithmID") != null){
				task.setAlgorithmID(rs.getString("AlgorithmID").toString());
			}
			if(rs.getString("TaskLatestRunTime") != null){
				task.setTaskLatestRunTime(rs.getString("TaskLatestRunTime").toString());
			}				
			if(rs.getString("TaskRunNumber") != null){
				task.setTaskRunNumber(rs.getString("TaskRunNumber").toString());
			}
			if(rs.getString("TaskResultPath") != null){
				task.setTaskResultPath(rs.getString("TaskResultPath").toString());
			}
			
			if(rs.getString("AlgorithmName") != null){
				task.setAlgorithmName(rs.getString("AlgorithmName").toString());
			}
			if(rs.getString("TaskDSName") != null){
				task.setTaskDSName(rs.getString("TaskDSName").toString());
			}
			list.add(task);
		}
		return list;
		
	}
	
	public List<Task> getTask(int UserID) throws SQLException{
		List<Task> list = new ArrayList<Task>();
					
			String sql = "select * from task where UserID =" + UserID ;
						
			
//			System.out.println("sql = " + sql);
			
			try {
				sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
			} catch (Exception e) {
				
			}
			
			ResultSet rs = DBQuery.query(sql);
			
//			System.out.println("db.query(sql); " );
			
//			System.out.println(db.next());
			
			
			while (rs.next()) {
					
				Task task = new Task();
				
				if(rs.getString("TaskID") != null){
					task.setTaskID(rs.getString("TaskID").toString());
				}
				if(rs.getString("TaskName") != null){
					task.setTaskName(rs.getString("TaskName").toString());
				}			
				if(rs.getString("UserID") != null){
					task.setUserID(rs.getString("UserID").toString());
				}
				if(rs.getString("TaskConfiguration") != null){
					task.setTaskConfiguration(rs.getString("TaskConfiguration").toString());
				}
				if(rs.getString("TaskDSID") != null){
					task.setTaskDSID(rs.getString("TaskDSID").toString());
				}
				if(rs.getString("TaskCreateTime") != null){
					task.setTaskCreateTime(rs.getString("TaskCreateTime").toString());
				}
				if(rs.getString("TaskChangeTime") != null){
					task.setTaskChangeTime(rs.getString("TaskChangeTime").toString());
				}
				if(rs.getString("TaskDescription") != null){
					task.setTaskDescription(rs.getString("TaskDescription").toString());
				}
				if(rs.getString("TaskPriority") != null){
					task.setTaskPriority(rs.getString("TaskPriority").toString());
				}
				if(rs.getString("AlgorithmID") != null){
					task.setAlgorithmID(rs.getString("AlgorithmID").toString());
				}
				if(rs.getString("TaskLatestRunTime") != null){
					task.setTaskLatestRunTime(rs.getString("TaskLatestRunTime").toString());
				}				
				if(rs.getString("TaskRunNumber") != null){
					task.setTaskRunNumber(rs.getString("TaskRunNumber").toString());
				}
				if(rs.getString("TaskResultPath") != null){
					task.setTaskResultPath(rs.getString("TaskResultPath").toString());
				}
				
				
				/*
				 * �õ�AlgorithmName
				 */
				if(rs.getString("AlgorithmID") != null){
					int AlgorithmID = Integer.parseInt(rs.getString("AlgorithmID"));
					String sql_AlgorithmName = "select * from algorithm where  AlgorithmID =  " + AlgorithmID ;
					
					System.out.println("sql_AlgorithmName = " + sql_AlgorithmName);
					
					try {
						sql_AlgorithmName = new String(sql_AlgorithmName.getBytes("ISO8859-1"), "UTF-8");
					} catch (Exception e) {
						
					}
					
					ResultSet rs_AlgorithmName = DBQuery.query(sql_AlgorithmName);
					
					
					while (rs_AlgorithmName.next()) {
						String  AlgorithmName = rs_AlgorithmName.getString("AlgorithmName");
						if(AlgorithmName != null){
							task.setAlgorithmName(AlgorithmName);
						}
						
					}
					System.out.println("AlgorithmID" + AlgorithmID);
				}
				
				/*
				 * �õ�TaskDSNames
				 */			
				if(rs.getString("TaskDSID") != null){
					int TaskDSID = Integer.parseInt(rs.getString("TaskDSID"));
					String sql_TaskDSName = "select * from ds where   DSID = " + TaskDSID ;
					
//					System.out.println("sql_TaskDSName = " + sql_TaskDSName);
					
					try {
						sql_TaskDSName = new String(sql_TaskDSName.getBytes("ISO8859-1"), "UTF-8");
					} catch (Exception e) {
						
					}
					
					ResultSet rs_TaskDSName = DBQuery.query(sql_TaskDSName);
					
					while (rs_TaskDSName.next()) {
						String  TaskDSName = rs_TaskDSName.getString("DSName");
						if(TaskDSName != null){
							task.setTaskDSName(TaskDSName);
						}
					}
					System.out.println("TaskDSID" + TaskDSID);
				}
				
				
				/*
				 * �õ�UserName
				 */
				if(UserID >= 0){
					
					String sql_UserName = "select * from user where  UserID =  " + UserID ;
					
					System.out.println("sql_UserName = " + sql_UserName);
					
					try {
						sql_UserName = new String(sql_UserName.getBytes("ISO8859-1"), "UTF-8");
					} catch (Exception e) {
						
					}
					
					ResultSet rs_UserName = DBQuery.query(sql_UserName);
					
					while (rs_UserName.next()) {
						String  UserName = rs_UserName.getString("UserName");
						if(UserName != null){
							task.setTaskDSName(UserName);
						}
					}
//					System.out.println("UserID" + UserID);
				}
				
				
				System.out.println("before list.add(task)" );
				
				// 淇濆瓨褰撳墠琛�
				list.add(task);
				
				System.out.println("list.add(task)" +list.size());
			}
			// 淇濆瓨鎵�湁琛屾暟鎹垪琛ㄤ紶閫掔粰涓嬩竴涓�?闈�
//			request.setAttribute("list", list);
			 DBQuery.closeDB(); 
//			 System.out.println(" return TaskIndexBean sucess!");
			 System.out.println("list.add(task)" +list.size());
				return list;
		}
		
	
}
