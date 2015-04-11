package model.taskManager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import model.platform.DBQuery;

public class AddTaskBean {
	public HashMap<String,String> getParameter(int userID,int algorithmID){
		HashMap<String,String> hashmap = new HashMap<String,String>();
		return hashmap;
	}
	
	public int addTask(int userID, Task task , HashMap<String,String> hashmap) throws NumberFormatException, SQLException, IOException{
		/*
		 * renturn 0 is sucess
		 * return 1 is 缺少TaskName
		 * return 2 is 缺少AlgorithmID
		 * return 3 is write parameters of algorithm  false
		 * return 4 写任务参数文件出错
		 * return -1 is 未知错误
		*/

		
		System.out.println("AddTaskBean.addTask() Start !");
		
		String basePath = "C:/";
		//define basePath
		
		String TaskName = task.getTaskName();
		//任务名
		String UserID  = Integer.toString(userID);
		//用户id
		
		
		String TaskDSID = task.getTaskDSID();
		//任务所用数据集id
		
		
		String TaskDescription = task.getTaskDescription();
		//任务描述
		String TaskPriority = task.getTaskPriority();
		if(TaskPriority == "" ){
			TaskPriority = "5";
		}
		//任务优先级
		String AlgorithmName = task.getAlgorithmName();
		String AlgorithmID = null;
		String sql_tmp = "select AlgorithmID from algorithm where AlgorithmName = '" + AlgorithmName + "'";
		ResultSet rsr = DBQuery.query(sql_tmp);
		 while(rsr.next()){
			 AlgorithmID = rsr.getString("AlgorithmID");
		 }
		 DBQuery.closeDB();
		
		//任务所用算法id
		
		
		String TaskRunNumber = Integer.toString(0);
		//任务正在运行数量,初始設這為0
		
		
		
//		String UserName = task.getUserName();
//		//用户名
//		String TaskDSName = task.getTaskDSName();
//		//任务所用数据集名称
//		String AlgorithmName = task.getAlgorithmName();
//		//任务所用算法名
		
		/*
		 * make TaskCreateTime  and TaskChangeTime
		 */
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String TaskCreateTime = sdf.format(now);
		//任务创建时间
		String TaskChangeTime = TaskCreateTime;
		//任务修改时间
		
		// 缂佸嫬鎮庨弬鏉款杻SQL
		
		String TaskResultPath = null;
		String TaskConfiguration = null;
		
		if(TaskName.isEmpty()){
			return 1;
		}else if(AlgorithmID.isEmpty()){
			return 2;
			
		}else {
				String sql = "select MAX(TaskID) as max_id FROM task";
				
				try {
					sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
				} catch (Exception e) {
					
				}
				
				System.out.println("sql = " + sql);
				
				ResultSet rs = DBQuery.query(sql);
				int taskid = 1;
				if(rs.next()){
					taskid = Integer.valueOf(rs.getString("max_id")) + 1;
					 
					//任务结果目录，根据basepath、projectname、userid、module
				}else{
					taskid = 1;
				}
				DBQuery.closeDB();
				/*
				 * windows下配置路径
				 */
				TaskResultPath = basePath  + UserID + "/" + "Task" + "/" + taskid;
				//配置结果路径
				TaskConfiguration = TaskResultPath + "/" + "paraments.xml";
				//任务配置任务所有算法的参数文件路径
				System.out.println(TaskResultPath+"####$$$$$$");
				/*
				 * 写入任务所用算法的配置文件,如果写入失败则返回4
				 */
				int iscreateXML = XMLAcessBean.createXMLFile(TaskConfiguration, hashmap);
				if(iscreateXML != 0){
					System.out.println(" XMLAcessBean.createXMLFile() fail !");
					return 4;
				}
		
				String sql_insert = "insert into task (TaskName, UserID,TaskConfiguration,TaskDSID,TaskCreateTime,"+
						"TaskChangeTime,TaskDescription,TaskPriority,AlgorithmID,TaskRunNumber, TaskResultPath) ";
				sql_insert	+= " values('" 
				+ TaskName + "','" 
				+ UserID + "','" 
				+ TaskConfiguration+ "','"
				+ TaskDSID+ "','" 
				+ TaskCreateTime+ "','" 
				+ TaskChangeTime+ "','" 
				+ TaskDescription + "','" 
				+ TaskPriority + "','"
				+ AlgorithmID+ "','" 
				+ TaskRunNumber + "','"
				+ TaskResultPath + "')";
				
				System.out.println("sql_insert:" + sql_insert);

				// 鏉烆剚宕查崣鍌涙殶缂傛牜锟�
				try {
					sql_insert = new String(sql_insert.getBytes("ISO8859-1"), "UTF-8");
				} catch (Exception e) {
//					return -1;
				}

				// 閹笛嗩攽閹绘帒锟�
				DBQuery.Update(sql_insert);
				
				DBQuery.closeDB();
				System.out.println(" AddTaskBean.addTask() sucess !" );
				
				return 0;
			}
		
			
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
