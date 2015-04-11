package model.taskManager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import model.platform.DBQuery;

public class TaskBean {
	public List<Task> getAllTask() throws SQLException{

		List<Task> list = new ArrayList<Task>();
					
			String sql = "select * from task,algorithm,dataset,user  where task.algorithmID = algorithm.AlgorithmID" 
			     + " and task.taskdsid = dataset.DSID and task.userID = user.userID  "  ;
			
			System.out.println("sql = " + sql);
			
			try {
				sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
			} catch (Exception e) {
				
			}
			
			ResultSet rs = DBQuery.query(sql);
			
			while (rs.next()) {
												
				// 闁哄被鍎撮妤�掕箛姘兼斀闁轰胶澧楀畵渚�儍閸曨偅鍊楀☉鎿冧簻閻⊙冣枔閸偅娈堕柟鐧告嫹
				Task task = new Task();
				
				if(rs.getString("TaskID") != null){
					task.setTaskID(rs.getString("TaskID"));
				}
				if(rs.getString("TaskName") != null){
					task.setTaskName(rs.getString("TaskName"));
				}			
				if(rs.getString("UserID") != null){
					task.setUserID(rs.getString("UserID"));
				}
				if(rs.getString("TaskConfiguration") != null){
					task.setTaskConfiguration(rs.getString("TaskConfiguration"));
				}
				if(rs.getString("TaskDSID") != null){
					task.setTaskDSID(rs.getString("TaskDSID"));
				}
				if(rs.getString("TaskCreateTime") != null){
					task.setTaskCreateTime(rs.getString("TaskCreateTime"));
				}
				if(rs.getString("TaskChangeTime") != null){
					task.setTaskChangeTime(rs.getString("TaskChangeTime"));
				}
				if(rs.getString("TaskDescription") != null){
					task.setTaskDescription(rs.getString("TaskDescription"));
				}
				if(rs.getString("TaskPriority") != null){
					task.setTaskPriority(rs.getString("TaskPriority"));
				}
				if(rs.getString("AlgorithmID") != null){
					task.setAlgorithmID(rs.getString("AlgorithmID"));
				}
				if(rs.getString("TaskLatestRunTime") != null){
					task.setTaskLatestRunTime(rs.getString("TaskLatestRunTime"));
				}				
				if(rs.getString("TaskRunNumber") != null){
					task.setTaskRunNumber(rs.getString("TaskRunNumber"));
				}
				if(rs.getString("TaskResultPath") != null){
					task.setTaskResultPath(rs.getString("TaskResultPath"));
				}
				
				if(rs.getString("algorithm.AlgorithmName") != null){
					task.setAlgorithmName(rs.getString("algorithm.AlgorithmName"));
				}
				if(rs.getString("dataset.DSName") != null){
					task.setTaskDSName(rs.getString("dataset.DSName"));
				}
				if(rs.getString("user.UserName") != null){
					task.setUserName(rs.getString("user.UserName"));
				}
			
				// 濞ｅ洦绻傞悺銊ㄣ亹閹惧啿顤呴悶娑虫嫹
				list.add(task);
				
//				System.out.println("list.add(task)" );
			}
			// 濞ｅ洦绻傞悺銊╁箥閿熻姤绠掗悶娑樻湰閺嗙喖骞戦鐓庣仚閻炴稏鍔嬬槐鍫曟焻閹烘梻鑸跺☉鎾愁儎缁斿瓨绋夐鍫嫹?闂傚牞鎷�
//			request.setAttribute("list", list);
			 DBQuery.closeDB(); 
//			 System.out.println(" return TaskIndexBean sucess!");
				
				return list;
		
		
	}
	
	
	public List<Task> getAllTask(int UserID) throws SQLException{
		List<Task> list = new ArrayList<Task>();
					
			String sql = "select * from task,algorithm,dataset,user  where task.algorithmID = algorithm.AlgorithmID" 
			     + " and task.taskdsid = dataset.DSID and task.userID = user.userID  and   task.UserID =" + UserID ;
			
			System.out.println("sql = " + sql);
			
			try {
				sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
			} catch (Exception e) {
				
			}
			
			ResultSet rs = DBQuery.query(sql);
			
			while (rs.next()) {
												
				// 闁哄被鍎撮妤�掕箛姘兼斀闁轰胶澧楀畵渚�儍閸曨偅鍊楀☉鎿冧簻閻⊙冣枔閸偅娈堕柟鐧告嫹
				Task task = new Task();
				
				if(rs.getString("TaskID") != null){
					task.setTaskID(rs.getString("TaskID"));
				}
				if(rs.getString("TaskName") != null){
					task.setTaskName(rs.getString("TaskName"));
				}			
				if(rs.getString("UserID") != null){
					task.setUserID(rs.getString("UserID"));
				}
				if(rs.getString("TaskConfiguration") != null){
					task.setTaskConfiguration(rs.getString("TaskConfiguration"));
				}
				if(rs.getString("TaskDSID") != null){
					task.setTaskDSID(rs.getString("TaskDSID"));
				}
				if(rs.getString("TaskCreateTime") != null){
					task.setTaskCreateTime(rs.getString("TaskCreateTime"));
				}
				if(rs.getString("TaskChangeTime") != null){
					task.setTaskChangeTime(rs.getString("TaskChangeTime"));
				}
				if(rs.getString("TaskDescription") != null){
					task.setTaskDescription(rs.getString("TaskDescription"));
				}
				if(rs.getString("TaskPriority") != null){
					task.setTaskPriority(rs.getString("TaskPriority"));
				}
				if(rs.getString("AlgorithmID") != null){
					task.setAlgorithmID(rs.getString("AlgorithmID"));
				}
				if(rs.getString("TaskLatestRunTime") != null){
					task.setTaskLatestRunTime(rs.getString("TaskLatestRunTime"));
				}				
				if(rs.getString("TaskRunNumber") != null){
					task.setTaskRunNumber(rs.getString("TaskRunNumber"));
				}
				if(rs.getString("TaskResultPath") != null){
					task.setTaskResultPath(rs.getString("TaskResultPath"));
				}
				
				if(rs.getString("algorithm.AlgorithmName") != null){
					task.setAlgorithmName(rs.getString("algorithm.AlgorithmName"));
				}
				if(rs.getString("dataset.DSName") != null){
					task.setTaskDSName(rs.getString("dataset.DSName"));
				}
				if(rs.getString("user.UserName") != null){
					task.setUserName(rs.getString("user.UserName"));
				}
			
				// 濞ｅ洦绻傞悺銊ㄣ亹閹惧啿顤呴悶娑虫嫹
				list.add(task);
				
//				System.out.println("list.add(task)" );
			}
			// 濞ｅ洦绻傞悺銊╁箥閿熻姤绠掗悶娑樻湰閺嗙喖骞戦鐓庣仚閻炴稏鍔嬬槐鍫曟焻閹烘梻鑸跺☉鎾愁儎缁斿瓨绋夐鍫嫹?闂傚牞鎷�
//			request.setAttribute("list", list);
			 DBQuery.closeDB(); 
//			 System.out.println(" return TaskIndexBean sucess!");
				
				return list;
		}
	public Task addTask(int userID, Task task , HashMap<String,String> hashmap) throws NumberFormatException, SQLException, IOException{
		/*
		 * renturn 0 is sucess
		 * return 1 鍐欎换鍔″弬鏁版枃浠跺嚭閿�
		 * return -1 is 鏈煡閿欒
		*/

		
		System.out.println("AddTaskBean.addTask() Start !!!!!!!!!!"+task.getTaskPriority()+"AAAAAAA");
		String basePath = "/usr/local/tomcat7/webapps/platform/TaskM";
		//define basePath
		
		
		String TaskName = task.getTaskName();
		//浠诲姟鍚�
		int UserID  = userID;
		
		//鐢ㄦ埛id
		
		System.out.println("task.getTaskDSID() = " + task.getTaskDSID());
		
		int TaskDSID = Integer.parseInt(task.getTaskDSID());
		//浠诲姟鎵�敤鏁版嵁闆唅d
		
		System.out.println("TaskDSID = " + TaskDSID);
		
	//	int AlgorithmID = Integer.parseInt(task.getAlgorithmID());
		String AlgorithmName = task.getAlgorithmName();
		String AlgorithmID = null;
		String sql_tmp = "select AlgorithmID from algorithm where AlgorithmName = '" + AlgorithmName + "'";
		ResultSet rsr = DBQuery.query(sql_tmp);
		 while(rsr.next()){
			 AlgorithmID = rsr.getString("AlgorithmID");
		 }
		 DBQuery.closeDB();
		//任务所用算法id
		System.out.println("AlgorithmID:!!!!"+AlgorithmID);
		
		//浠诲姟鎵�敤绠楁硶id
		
		String TaskDescription = task.getTaskDescription();
		if(TaskDescription == null ){
			TaskDescription = " ";
		}
		//浠诲姟鎻忚堪
		int TaskPriority = 5;
		if(task.getTaskPriority() != "" ){
			
			TaskPriority = Integer.parseInt(task.getTaskPriority());;
		}
		//浠诲姟浼樺厛绾�
		
		int TaskRunNumber = 0;
		//浠诲姟姝ｅ湪杩愯鏁伴噺,鍒濆瑷�鐐�
		task.setTaskRunNumber(TaskDescription);
		
		/*
		 * make TaskCreateTime  and TaskChangeTime
		 */
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String TaskCreateTime = sdf.format(now);
		//浠诲姟鍒涘缓鏃堕棿
		String TaskChangeTime = TaskCreateTime;
		//浠诲姟淇敼鏃堕棿
		
		task.setTaskCreateTime(TaskCreateTime);
		task.setTaskChangeTime(TaskChangeTime);
		
		// 缂備礁瀚幃搴ㄥ棘閺夋鏉籗QL
		
		String TaskResultPath = null;
		
		String sql = "select MAX(TaskID) as max_id FROM task";
				
		try {
			sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
		} catch (Exception e) {
			
		}
				
		System.out.println("sql = " + sql);
		
		ResultSet rs = DBQuery.query(sql);
		int taskid = 1;
		if(rs.next()){
			taskid = rs.getInt("max_id") + 1;
			 
			//浠诲姟缁撴灉鐩綍锛屾牴鎹産asepath銆乸rojectname銆乽serid銆乵odule
		}else{
			taskid = 1;
		}
		
		DBQuery.closeDB();
		
		task.setTaskID(String.valueOf(taskid));
				
				
//		System.out.println("taskid = " + taskid);
		
		/*
		 * windows涓嬮厤缃矾寰�
		 */
		TaskResultPath = basePath + "/" + UserID + "/" + "Task" + "/" + taskid ;
		//閰嶇疆缁撴灉璺緞
		String TaskConfiguration = TaskResultPath + "/" + "paraments.xml";
		//浠诲姟閰嶇疆浠诲姟鎵�湁绠楁硶鐨勫弬鏁版枃浠惰矾寰�
		
		/*
		 * 鍐欏叆浠诲姟鎵�敤绠楁硶鐨勯厤缃枃浠�濡傛灉鍐欏叆澶辫触鍒欒繑鍥�
		 */
		int iscreateXML = XMLAcessBean.createXMLFile(TaskConfiguration, hashmap);
		if(iscreateXML != 0){
			System.out.println(" XMLAcessBean.createXMLFile() fail !");
			
		}
		
		String sql_insert = "insert into task (TaskName, UserID,TaskConfiguration,TaskDSID,TaskCreateTime,"+
				"TaskChangeTime,TaskDescription,TaskPriority,AlgorithmID,TaskRunNumber, TaskResultPath) ";
		sql_insert	+= " values('"  + TaskName + "'," 
		+ UserID+ ",'" 
		+ TaskConfiguration+ "',"
		+  TaskDSID+ ",'" 
		+ TaskCreateTime+ "','" 
		+ TaskChangeTime+ "','" 
		+ TaskDescription + "'," 
		+ TaskPriority + ","
		+  Integer.parseInt(AlgorithmID)+ "," 
		+ TaskRunNumber + ",'"
		+ TaskResultPath + "')";
		
		System.out.println("sql_insert:" + sql_insert);

		// 閺夌儐鍓氬畷鏌ュ矗閸屾稒娈剁紓鍌涚墱閿燂拷
		try {
			sql_insert = new String(sql_insert.getBytes("ISO8859-1"), "UTF-8");
		} catch (Exception e) {
//					return -1;
		}

		// 闁圭瑳鍡╂斀闁圭粯甯掗敓锟�
		ResultSet rs_insert = DBQuery.Update(sql_insert);
		
		DBQuery.closeDB();
		System.out.println(" AddTaskBean.addTask() sucess !" );
		
		return task;
	}
		
			
	
	
	public Task checkTask(int taskID) throws NumberFormatException, SQLException{
		/*
		 * 鏌ョ湅浠诲姟
		 */
		Task task = new Task();
		String sql = "select * from task , algorithm ,  dataset, user  " 
		+ "where task.algorithmID = algorithm.algorithmID and task.TaskDSID= dataset.DSID " 
		+ "and task.userID = user.userID and TaskID =" + taskID ;
		
		System.out.println("sql = " + sql);
		
		try {
			sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
		} catch (Exception e) {
			
		}
		
		ResultSet rs = DBQuery.query(sql);
		while (rs.next()) {
											
			// 闁哄被鍎撮妤�掕箛姘兼斀闁轰胶澧楀畵渚�儍閸曨偅鍊楀☉鎿冧簻閻⊙冣枔閸偅娈堕柟鐧告嫹
						
			if(rs.getString("TaskID") != null){
				task.setTaskID(rs.getString("TaskID").toString());
			}
			if(rs.getString("TaskName") != null){
				task.setTaskName(rs.getString("TaskName").toString());
			}
			if(rs.getString("task.UserID") != null){
				task.setUserID(rs.getString("task.UserID").toString());
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
			}else{
				task.setTaskRunNumber("0");
			}
			if(rs.getString("TaskResultPath") != null){
				task.setTaskResultPath(rs.getString("TaskResultPath").toString());
			}
			if(rs.getString("task.AlgorithmID") != null){
				task.setAlgorithmID(rs.getString("task.AlgorithmID").toString());
			}
			if(rs.getString("AlgorithmName") != null){
				task.setAlgorithmName(rs.getString("AlgorithmName").toString());
			}
			if(rs.getString("task.TaskDSID") != null){
				task.setTaskDSID(rs.getString("task.TaskDSID").toString());
			}
			if(rs.getString("DSName") != null){
				task.setTaskDSName(rs.getString("DSName").toString());
			}
			if(rs.getString("task.UserID") != null){
				task.setUserID(rs.getString("task.UserID").toString());
			}
			if(rs.getString("UserName") != null){
				task.setUserName(rs.getString("UserName").toString());
			}
		}
		DBQuery.closeDB();
		System.out.println("DBQuery.closeDB();" );
		return task;
	}//checkTask
	
	public int editTask(int userID, Task task , HashMap<String,String> hashmap) throws NumberFormatException, SQLException, IOException{
		/*
		 * renturn 0 is sucess
		 * return 1 is 缂哄皯TaskName
		 * return 2 is 缂哄皯AlgorithmID
		 * return 3 is write parameters of algorithm  false
		 * return 4 鍐欎换鍔″弬鏁版枃浠跺嚭閿�
		 * return -1 is 鏈煡閿欒
		*/

		
		System.out.println("TaskBean.editTask() Start !");
		
//		String basePath = "C:\\Users\\wangjian\\Desktop\\git澶囦唤\\dataPath";
		//define basePath
		String TaskName = null;
		if(task.getTaskName() != null){
			 TaskName = task.getTaskName();
			//浠诲姟鍚�
		}
		
		
		//鐢ㄦ埛id
		String TaskID = null;
		if(task.getTaskID() != null){
			TaskID = task.getTaskID();
			//浠诲姟鎵�敤鏁版嵁闆唅d
		}
		
		String UserID  = Integer.toString(userID);
		//鐢ㄦ埛id
		String TaskDSID = null;
		if(task.getTaskDSID() != null){
			 TaskDSID = task.getTaskDSID();
			//浠诲姟鎵�敤鏁版嵁闆唅d
		}
		
		String TaskDescription = null;
		if(task.getTaskDescription() != null){
			 TaskDescription = task.getTaskDescription();
			//浠诲姟鎻忚堪
		}
		
		String TaskPriority = "5";
		if(task.getTaskPriority() != null){
			TaskPriority = task.getTaskPriority();
			
		}
		String AlgorithmID = null ;
		//浠诲姟浼樺厛绾�
		if(task.getAlgorithmID() != null){
			 AlgorithmID = task.getAlgorithmID();
			//浠诲姟鎵�敤绠楁硶id
		}
		
		/*
		 * make TaskCreateTime  and TaskChangeTime
		 */
		String TaskCreateTime;
		if(task.getTaskCreateTime() != null){
			TaskCreateTime = task.getTaskCreateTime();
			//浠诲姟鍒涘缓鏃堕棿
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = new Date();
			TaskCreateTime = sdf.format(now);
			//浠诲姟鍒涘缓鏃堕棿
		}
		String TaskChangeTime;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		TaskChangeTime = sdf.format(now);
//		System.out.println("TaskChangeTime = " + TaskChangeTime);
			 
			//浠诲姟淇敼鏃堕棿
		
		
		
		
		System.out.println("TaskID = " + TaskID);
		

	
				String sql = "update task set TaskName='" + TaskName 
						+ "', UserID=" + Integer.parseInt(UserID)
						+ ", TaskDSID=" + Integer.parseInt(TaskDSID)
						+ ", TaskCreateTime='" + TaskCreateTime 
						+ "', TaskChangeTime='" + TaskChangeTime 
						+ "', TaskDescription='" + TaskDescription 
						+ "', TaskPriority=" + Integer.parseInt(TaskPriority)
						+ ", AlgorithmID=" + Integer.parseInt(AlgorithmID)
						+ " where TaskID=" + TaskID;
				
				
				System.out.println("sql:" + sql);

				// 閺夌儐鍓氬畷鏌ュ矗閸屾稒娈剁紓鍌涚墱閿燂拷
				try {
					sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
				} catch (Exception e) {
//					return -1;
				}

				// 闁圭瑳鍡╂斀闁圭粯甯掗敓锟�
				ResultSet rs = DBQuery.Update(sql);
				DBQuery.closeDB();
				
				
				String TaskConfiguration = null;
				String sql_taskconfig = "select * from task where TaskID =" + TaskID ;
				try {
					sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
				} catch (Exception e) {
					
				}
				
				ResultSet rs_taskconfig = DBQuery.query(sql_taskconfig);
				while (rs_taskconfig.next()) {
					TaskConfiguration = rs_taskconfig.getString("TaskConfiguration");
				}
				
				DBQuery.closeDB();	
				System.out.println("TaskConfiguration = " + TaskConfiguration);
				
				/*
				 * 鍐欏叆浠诲姟鎵�敤绠楁硶鐨勯厤缃枃浠�濡傛灉鍐欏叆澶辫触鍒欒繑鍥�
				 */
				int iscreateXML = XMLAcessBean.createXMLFile(TaskConfiguration, hashmap);
				if(iscreateXML != 0){
//					System.out.println(" XMLAcessBean.createXMLFile() fail !");
					return 4;
				}
				System.out.println(" TaskBean.editTask() sucess !" );
				
				return Integer.parseInt(TaskID);
			}
	
	public int deleteTask(int taskID) throws NumberFormatException, SQLException{
		String sql = "delete from task where TaskID=" + taskID;
		try {
			sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
		} catch (Exception e) {
			
		}
		
		ResultSet rs = DBQuery.Update(sql);
		return 0;
	}
		
			
	
		
	

}
