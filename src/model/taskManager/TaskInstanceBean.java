package model.taskManager;

import model.platform.DBQuery;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TaskInstanceBean {


    public List<TaskInstance> getAllTaskInstance(int UserID) throws SQLException {
        List<TaskInstance> list = new ArrayList<TaskInstance>();

        String sql = "select * from taskInstance,task,algorithm,dataset,user  where taskInstance.Taskid = task.taskid " +
                "and  taskInstance.algorithmID = algorithm.AlgorithmID  and taskInstance.TIdsid = dataset.DSID" +
                " and task.userID = user.userID  and   task.UserID =" + UserID;

        System.out.println("sql = " + sql);

        try {
            sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
        } catch (Exception e) {

        }

        ResultSet rs = DBQuery.query(sql);
        if (rs != null)
            while (rs.next()) {

                TaskInstance taskInstance = new TaskInstance();

                if (rs.getString("TIID") != null) {
                    taskInstance.setTaskInstanceID(rs.getString("TIID"));
                }
                if (rs.getString("TIName") != null) {
                    taskInstance.setTaskInstanceName(rs.getString("TIName"));
                }
                if (rs.getString("task.TaskID") != null) {
                    taskInstance.setTaskID(rs.getString("task.TaskID"));
                }
                if (rs.getString("task.TaskName") != null) {
                    taskInstance.setTaskName(rs.getString("task.TaskName"));
                }
                if (rs.getString("user.UserID") != null) {
                    taskInstance.setUserID(rs.getString("user.UserID"));
                }
                if (rs.getString("TaskConfiguration") != null) {
                    taskInstance.setTaskConfiguration(rs.getString("TaskConfiguration"));
                }
                if (rs.getString("TaskDSID") != null) {
                    taskInstance.setTaskDSID(rs.getString("TaskDSID"));
                }
                if (rs.getString("TIResultID") != null) {
                    taskInstance.setTaskInstanceResultID(rs.getString("TIResultID"));
                }
                if (rs.getString("TIStartTime") != null) {
                    taskInstance.setTaskInstanceStartTime(rs.getString("TIStartTime"));
                }
                if (rs.getString("TISuspendTime") != null) {
                    taskInstance.setTaskInstanceSuspendTime(rs.getString("TISuspendTime"));
                }
                if (rs.getString("TIEndTime") != null) {
                    taskInstance.setTaskInstanceEndTime(rs.getString("TIEndTime"));
                }
                if (rs.getString("TIDescription") != null) {
                    taskInstance.setTIDescription(rs.getString("TIDescription"));
                }
                if (rs.getString("TIState") != null) {
                    taskInstance.setTIState(rs.getString("TIState"));
                }

//				if(rs.getString("ProcessID") != null){
//					taskInstance.setProcessID(rs.getString("ProcessID"));
//				}
                if (rs.getString("TaskCreateTime") != null) {
                    taskInstance.setTaskCreateTime(rs.getString("TaskCreateTime"));
                }
                if (rs.getString("TaskChangeTime") != null) {
                    taskInstance.setTaskChangeTime(rs.getString("TaskChangeTime"));
                }
                if (rs.getString("TaskDescription") != null) {
                    taskInstance.setTaskDescription(rs.getString("TaskDescription"));
                }
                if (rs.getString("TaskPriority") != null) {
                    taskInstance.setTaskPriority(rs.getString("TaskPriority"));
                }
                if (rs.getString("AlgorithmID") != null) {
                    taskInstance.setAlgorithmID(rs.getString("AlgorithmID"));
                }
                //
                if (rs.getString("algorithm.AlgorithmName") != null) {
                    taskInstance.setAlgorithmName(rs.getString("algorithm.AlgorithmName"));
                }
                if (rs.getString("TaskLatestRunTime") != null) {
                    taskInstance.setTaskLatestRunTime(rs.getString("TaskLatestRunTime"));
                }


//				if(rs.getString("algorithm.AlgorithmName") != null){
//					taskInstance.setAlgorithmName(rs.getString("algorithm.AlgorithmName"));
//				}
//				if(rs.getString("dataset.DSName") != null){
//					taskInstance.setTaskDSName(rs.getString("dataset.DSName"));
//				}
//				if(rs.getString("user.UserName") != null){
//					taskInstance.setUserName(rs.getString("user.UserName"));
//				}

                list.add(taskInstance);

//				System.out.println("list.add(task)" );
            }
//			request.setAttribute("list", list);
        DBQuery.closeDB();
//			 System.out.println(" return TaskIndexBean sucess!");

        return list;
    }

    /*
     * 鏂板浠诲姟瀹炰緥锛岃繑鍥�琛ㄧず鎴愬姛銆�
     */
    public int addTaskInstance(TaskInstance taskInstance, Map<String, String> map, String TaskInstanceConfiguration) throws IOException, SQLException {
        System.out.println("addTaskInstance() start ! ");

		/*
         * 鍏堝皢Map<String,String> map涓殑鍙傛暟鍐欏埌鍦板潃涓篢askInstanceConfiguration鐨勬枃浠朵腑锛岀劧鍚庡悜TaskInstance鏁版嵁琛ㄤ腑鎻掑叆涓�潯鏁版嵁銆�
		 */
        XMLAcessBean.createXMLFile(TaskInstanceConfiguration, map);

        String TIName = taskInstance.getTaskInstanceName();
        //浠诲姟瀹炰緥鍚�
        String UserID = taskInstance.getUserID();
        //UserID
        String TaskID = taskInstance.getTaskID();
        //浠诲姟ID
        String TIConfiguration = TaskInstanceConfiguration;
        //浠诲姟瀹炰緥鐨勯厤缃弬鏁板湴鍧�
        String TIDSID = taskInstance.getTaskInstanceDSID();
        //浠诲姟瀹炰緥鎵�敤鏁版嵁闆嗙殑ID
        String TIState = "1";
        String TIDescription = taskInstance.getTaskDescription();
        //浠诲姟瀹炰緥鐨勬弿杩�
        String TIResultPath = taskInstance.getTaskInstanceResultPath();
        //浠诲姟瀹炰緥鐨勭粨鏋滆矾寰�
        String AlgorithmID = taskInstance.getAlgorithmID();
        String ProcessID = taskInstance.getProcessID();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String TIStartTime = sdf.format(now);

        String sql_insert = "insert into taskInstance (TIName,TaskID, UserID ,TIConfiguration , TIDSID , TIState ," +
                "TIDescription ,TIResultPath ,AlgorithmID,ProcessID,TIStartTime ) ";
        sql_insert += " values('" + TIName + "',"
                + Integer.parseInt(TaskID) + ","
                + Integer.parseInt(UserID) + ",'"
                + TIConfiguration + "',"
                + Integer.parseInt(TIDSID) + ","
                + Integer.parseInt(TIState) + ",'"
                + TIDescription + "','"
                + TIResultPath + "',"
                + Integer.parseInt(AlgorithmID) + ","
                + Integer.parseInt(ProcessID) + ",'"
                + TIStartTime + "')";


        // 閺夌儐鍓氬畷鏌ュ矗閸屾稒娈剁紓鍌涚墱閿燂拷
        try {
            sql_insert = new String(sql_insert.getBytes("ISO8859-1"), "UTF-8");
        } catch (Exception e) {
//			return -1;
        }

        System.out.println("sql_insert = " + sql_insert);

        // 闁圭瑳鍡╂斀闁圭粯甯掗敓锟�
        ResultSet rs_insert = DBQuery.Update(sql_insert);

        DBQuery.closeDB();
        System.out.println(" TaskBean.addTaskInstance() sucess !");


        return 0;
    }

    public TaskInstance checkTaskInstance(int TIID) throws NumberFormatException, SQLException {
		/*
		 * 鏌ョ湅浠诲姟
		 */
        TaskInstance taskInstance = new TaskInstance();
        String sql = "select * from taskInstance,task,algorithm,dataset,user  where taskInstance.Taskid = task.taskid " +
                "and  taskInstance.algorithmID = algorithm.AlgorithmID  and taskInstance.TIdsid = dataset.DSID" +
                " and task.userID = user.userID  and TIID =" + TIID;

        System.out.println("sql = " + sql);

        try {
            sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
        } catch (Exception e) {

        }
        System.out.println("aaaaaaa");
        ResultSet rs = DBQuery.query(sql);

        System.out.println("aaaaaaa");
        while (rs.next()) {

            // 闁哄被鍎撮妤�掕箛姘兼斀闁轰胶澧楀畵渚�儍閸曨偅鍊楀☉鎿冧簻閻⊙冣枔閸偅娈堕柟鐧告嫹


            if (rs.getString("TIID") != null) {
                taskInstance.setTaskInstanceID(rs.getString("TIID"));
            }
            if (rs.getString("TIName") != null) {
                taskInstance.setTaskInstanceName(rs.getString("TIName"));
            }
            if (rs.getString("task.TaskID") != null) {
                taskInstance.setTaskID(rs.getString("task.TaskID"));
            }
            if (rs.getString("task.TaskName") != null) {
                taskInstance.setTaskName(rs.getString("task.TaskName"));
            }
            if (rs.getString("user.UserID") != null) {
                taskInstance.setUserID(rs.getString("user.UserID"));
            }
            if (rs.getString("TaskConfiguration") != null) {
                taskInstance.setTaskConfiguration(rs.getString("TaskConfiguration"));
            }
            if (rs.getString("TiConfiguration") != null) {
                taskInstance.setTaskInstanceConfiguration(rs.getString("TiConfiguration"));
            }

            if (rs.getString("TaskDSID") != null) {
                taskInstance.setTaskDSID(rs.getString("TaskDSID"));
            }
            if (rs.getString("TIResultID") != null) {
                taskInstance.setTaskInstanceResultID(rs.getString("TIResultID"));
            }
            if (rs.getString("TIStartTime") != null) {
                taskInstance.setTaskInstanceStartTime(rs.getString("TIStartTime"));
            }
            if (rs.getString("TIEndTime") != null) {
                taskInstance.setTaskInstanceEndTime(rs.getString("TIEndTime"));
            }
            if (rs.getString("TIDescription") != null) {
                taskInstance.setTIDescription(rs.getString("TIDescription"));
            }
            if (rs.getString("TISuspendTime") != null) {
                taskInstance.setTaskInstanceSuspendTime(rs.getString("TISuspendTime"));
            }
//			if(rs.getString("ProcessID") != null){
//			taskInstance.setProcessID(rs.getString("ProcessID"));
//			}
            if (rs.getString("TaskCreateTime") != null) {
                taskInstance.setTaskCreateTime(rs.getString("TaskCreateTime"));
            }
            if (rs.getString("TaskChangeTime") != null) {
                taskInstance.setTaskChangeTime(rs.getString("TaskChangeTime"));
            }
            if (rs.getString("TaskDescription") != null) {
                taskInstance.setTaskDescription(rs.getString("TaskDescription"));
            }
            if (rs.getString("TaskPriority") != null) {
                taskInstance.setTaskPriority(rs.getString("TaskPriority"));
            }
            if (rs.getString("AlgorithmID") != null) {
                taskInstance.setAlgorithmID(rs.getString("AlgorithmID"));
            }
            if (rs.getString("TaskLatestRunTime") != null) {
                taskInstance.setTaskLatestRunTime(rs.getString("TaskLatestRunTime"));
            }


            if (rs.getString("algorithm.AlgorithmName") != null) {
                taskInstance.setAlgorithmName(rs.getString("algorithm.AlgorithmName"));
            }
            if (rs.getString("dataset.DSName") != null) {
                taskInstance.setTaskDSName(rs.getString("dataset.DSName"));
            }
            if (rs.getString("user.UserName") != null) {
                taskInstance.setUserName(rs.getString("user.UserName"));
            }

        }
        DBQuery.closeDB();
        System.out.println("DBQuery.closeDB();");
        return taskInstance;
    }//checkTask

    public int editTaskInstance(TaskInstance taskInstance, String state) throws NumberFormatException, SQLException, IOException {
		/*
		 * renturn 0 is sucess
		 * return 1 is 缂哄皯TaskName
		 * return 2 is 缂哄皯AlgorithmID
		 * return 3 is write parameters of algorithm  false
		 * return 4 鍐欎换鍔″弬鏁版枃浠跺嚭閿�
		 * return -1 is 鏈煡閿欒
		*/


        System.out.println("TaskBean.editTask() Start !");
        String TIID = taskInstance.getTaskInstanceID();
        String TIName = taskInstance.getTaskInstanceName();
        //浠诲姟瀹炰緥鍚�
        String TaskID = taskInstance.getTaskID();
        //浠诲姟ID
        String TIConfiguration = taskInstance.getTaskInstanceConfiguration();
        //浠诲姟瀹炰緥鐨勯厤缃弬鏁板湴鍧�
        String TIDSID = taskInstance.getTaskInstanceDSID();
        String TIResultID = taskInstance.getTaskInstanceResultID();
        //浠诲姟瀹炰緥鎵�敤鏁版嵁闆嗙殑ID
        String TIState = taskInstance.getTIState();
        String TIEndtime = taskInstance.getTaskInstanceEndTime();
        String TIDescription = taskInstance.getTIState();
        //浠诲姟瀹炰緥鐨勬弿杩�
        String TIResultPath = taskInstance.getTaskInstanceResultPath();
        //浠诲姟瀹炰緥鐨勭粨鏋滆矾寰�
        String AlgorithmID = taskInstance.getAlgorithmID();

        String sql = "update taskInstance set TIName='" + TIName
                + "', TaskID='" + TaskID
                + "', TIConfiguration='" + TIConfiguration
                + "', TIDSID='" + TIDSID
                + "', TIResultID='" + TIResultID
                + "', TIState='" + TIState
                + "', TIEndtime='" + TIEndtime
                + "', AlgorithmID='" + AlgorithmID
                + "', TIDescription='" + TIDescription
                + "', TIResultPath='" + TIResultPath
                + "', AlgorithmID='" + AlgorithmID
                + "' where TIID=" + TIID;

//				System.out.println("sql:" + sql);

        // 閺夌儐鍓氬畷鏌ュ矗閸屾稒娈剁紓鍌涚墱閿燂拷
        try {
            sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
        } catch (Exception e) {
//					return -1;
        }

        // 闁圭瑳鍡╂斀闁圭粯甯掗敓锟�
        ResultSet rs = DBQuery.Update(sql);
        DBQuery.closeDB();
				
				/*
				 * 鍐欏叆浠诲姟鎵�敤绠楁硶鐨勯厤缃枃浠�濡傛灉鍐欏叆澶辫触鍒欒繑鍥�
				 */

        System.out.println(" TaskBean.editTask() sucess !");

        return 0;
    }


    public int deleteTaskInstance(int TIID) throws NumberFormatException, SQLException {
        String sql = "delete from taskinstance where TIID=" + TIID;
        try {
            sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
        } catch (Exception e) {

        }

        ResultSet rs = DBQuery.Update(sql);
        return 0;
    }


    /*
     * 缁堟浠诲姟瀹炰緥鐨勮繍琛�
     */
    public int stopTaskInstance(int tiId) {

        int tistate = -1;
        String TISuspendTime;
        SimpleDateFormat sdf_task = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now_task = new Date();
        TISuspendTime = sdf_task.format(now_task);

        int ProcessID = -1;

        String sql = "update taskInstance set tistate= " + tistate + ",ProcessID = " + ProcessID + ",TISuspendTime= '"
                + TISuspendTime + "' where tiId=" + tiId;
        try {
            sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
        } catch (Exception e) {
//			return -1;
        }

        System.out.println("sql = " + sql);

        // 闁圭瑳鍡╂斀闁圭粯甯掗敓锟�
        ResultSet rs = DBQuery.Update(sql);

        return 0;
    }

    public int runTaskInstance(TaskInstance taskInstance) throws SQLException {
        return 0;

    }
}
