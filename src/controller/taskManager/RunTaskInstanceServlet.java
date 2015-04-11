package controller.taskManager;

import model.algorithm.utils.AlgorithmLoad;
import model.platform.DBQuery;
import model.platform.FrontProcess;
import model.result.RESULT;
import model.result.ResultBean;
import model.taskManager.TaskInstance;
import model.taskManager.TaskInstanceBean;
import org.jdom2.JDOMException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class RunTaskInstanceServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public RunTaskInstanceServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     * <p/>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    /**
     * The doPost method of the servlet. <br>
     * <p/>
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("textml;charset=utf-8");

        System.out.println("RunTaskInstanceServlet start ! ");

        HttpSession session = request.getSession();

        HashMap<String, String> hashmap = new HashMap<String, String>();
        hashmap = FrontProcess.toHashMap(request.getParameter("hashmap"));
        TaskInstance taskInstance = new TaskInstance();

        String TaskInstanceName = null;
        String TaskID = null;
        //娴犺濮烮D
        String TaskName = null;
        //娴犺濮烮D
        String TaskDescription = null;
        //娴犺濮熺�鐐扮伐閻ㄥ嫭寮挎潻甯礉鏉╂瑤閲滈崣顖欎簰閸滃奔鎹㈤崝锛勬畱閹诲繗鍫稉锟界壉閿涘奔绡冮崣顖欎簰閺勵垰鐔�禍搴濇崲閸旓紕娈戦幓蹇氬牚閻ㄥ嫪鎱ㄩ弨锟�
        String TaskPriority = null;
        //娴犺濮烮D
        String UserID = null;
        //娴犺濮烮D
        String TaskDSID = null;
        //娴犺濮烮D
        String AlgorithmID = null;
        //缁犳纭禝D
        String AlgorithmName = null;
        //缁犳纭禝D
        String TaskInstanceDSID = null;
        //娴犺濮熺�鐐扮伐閹碉拷鏁ら弫鐗堝祦闂嗗棛娈慖D
        String TaskResultPath = null;
        //娴犺濮熼惃鍕勾閸э拷绱濈亸杈ㄦЦ娴犺濮熺悰銊よ厬閻ㄥ嚲askResultPath鐎涙顔岄惃鍕拷閵嗭拷
        String TaskRunNumber;
        //娴犺濮熸潻鎰攽濞嗏剝鏆�
        String TIDescription = null;
        //娴犺濮熸潻鎰攽濞嗏剝鏆�

        if (request.getParameter("TIName") != null) {
            TaskInstanceName = (String) request.getParameter("TIName");
        }
        if (request.getParameter("TaskID") != null) {
            TaskID = (String) request.getParameter("TaskID");
        }
        if (request.getParameter("TaskName") != null) {
            TaskName = (String) request.getParameter("TaskName");
        }
        if (request.getParameter("TaskDescription") != null) {
            TaskDescription = (String) request.getParameter("TaskDescription");
        }
        if (request.getParameter("TaskPriority") != null) {
            TaskPriority = (String) request.getParameter("TaskPriority");
        }
        if (request.getParameter("UserID") != null) {
            UserID = (String) request.getParameter("UserID");
        }
        if (request.getParameter("TaskDSID") != null) {
            TaskInstanceDSID = (String) request.getParameter("TaskDSID");
        }
        if (request.getParameter("AlgorithmID") != null) {
            AlgorithmID = (String) request.getParameter("AlgorithmID");
        }
        if (request.getParameter("AlgorithmName") != null) {
            AlgorithmName = (String) request.getParameter("AlgorithmName");
        }
        if (request.getParameter("TaskResultPath") != null) {
            TaskResultPath = (String) request.getParameter("TaskResultPath");
        }
        if (request.getParameter("TaskRunNumber") != null) {
            TaskRunNumber = (String) request.getParameter("TaskRunNumber");
        } else {
            TaskRunNumber = "0";
        }
        if (request.getParameter("TIDescription") != null) {
            TIDescription = (String) request.getParameter("TIDescription");
        }
//		if(request.getParameter("AlgorithmName") != null){
//			AlgorithmName = (String) request.getParameter("AlgorithmName");
//		}

		
		/*
         * 娴犮儰绗呴弰顖滄晸閹存劒鎹㈤崝鈥崇杽娓氬娈戠紒鎾寸亯鐎涙ɑ鏂侀崷鏉挎絻閸滃奔鎹㈤崝鈥崇杽娓氬娈戠粻妤佺《闁板秶鐤嗛崣鍌涙殶閸︽澘娼�
		 */
        String TaskInstanceResultPath;
        String TaskInstanceConfiguration;
        int runNumber = Integer.valueOf(TaskRunNumber);
        TaskInstanceResultPath = TaskResultPath + "/" + (++runNumber);
        TaskInstanceConfiguration = TaskInstanceResultPath + "/" + "paraments.xml";

        System.out.println("TaskInstanceResultPath = " + TaskInstanceResultPath);
        System.out.println("TaskInstanceConfiguration = " + TaskInstanceConfiguration);

		
		
		/*
		 * 娴犮儰绗呴弰顖滅舶taskInstance鐎电懓顕挒陇绁撮崐绗猴拷
		 */
        if (TaskInstanceName != null) {
            taskInstance.setTaskInstanceName(TaskInstanceName);
        }
        if (TaskID != null) {
            taskInstance.setTaskID(TaskID);
        }
        if (TaskName != null) {
            taskInstance.setTaskName(TaskName);
        }

        if (TaskDescription != null) {
            taskInstance.setTaskDescription(TaskDescription);
        }
        if (TaskPriority != null) {
            taskInstance.setTaskPriority(TaskPriority);
        }
        if (UserID != null) {
            taskInstance.setUserID(UserID);
        }
        if (TaskInstanceDSID != null) {
            taskInstance.setTaskInstanceDSID(TaskInstanceDSID);
        }
        if (AlgorithmID != null) {
            taskInstance.setAlgorithmID(AlgorithmID);
        }


        if (TaskRunNumber != null) {
            taskInstance.setTaskRunTime(TaskRunNumber);
        }
        if (TaskInstanceResultPath != null) {
            taskInstance.setTaskInstanceResultPath(TaskInstanceResultPath);
        }
        if (TaskInstanceConfiguration != null) {
            taskInstance.setTaskInstanceConfiguration(TaskInstanceConfiguration);
        }

        int processID = 0;
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
        int index = name.indexOf("@");
        if (index != -1) {
            processID = Integer.parseInt(name.substring(0, index));
        }
        taskInstance.setProcessID(String.valueOf(processID));
		 
		 
		/*
		 * 娴犮儰绗呴弰顖濈殶閻⑩晲askInstanceBean.addTaskInstance(taskInstance,hashmap),閸︺劋鎹㈤崝鈥崇杽娓氬銆冩稉顓熷絻閸忋儰绔撮弶鈩冩殶閹诡喓锟�
		 */
        TaskInstanceBean taskInstanceBean = new TaskInstanceBean();

        try {
            taskInstanceBean.addTaskInstance(taskInstance, hashmap, TaskInstanceConfiguration);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		/*
		 * 娴犮儰绗呴弰顖濆箯閸欐潒nput閻ㄥ嫬婀撮崸锟界礉閸楃绱濋弫鐗堝祦闂嗗棛娈戦崷鏉挎絻
		 */
        String datapath = null;
        String sql = "select * from dataset  where DSID  = " + Integer.parseInt(TaskInstanceDSID);

        System.out.println("sql = " + sql);

        try {
            sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
        } catch (Exception e) {

        }

        ResultSet rs = DBQuery.query(sql);
        try {
            while (rs.next()) {
                datapath = rs.getString("DSPath");
                System.out.println("datapath = " + datapath);


            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            DBQuery.closeDB();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        String TIEndTime;
        //娴犺濮熺�鐐扮伐閻ㄥ嫮绮撳銏℃闂傦拷
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        TIEndTime = sdf.format(now);
        taskInstance.setTaskInstanceEndTime(TIEndTime);

        taskInstance.setTIState("1");
        String sql_TIupdate = "update taskInstance set TIState =" + 1
                + ", TIEndTime='" + TIEndTime
                + "' where TIResultPath= '" + TaskInstanceResultPath + "'";
        System.out.println("sql_TIupdate = " + sql_TIupdate);

        try {
            sql_TIupdate = new String(sql_TIupdate.getBytes("ISO8859-1"), "UTF-8");
        } catch (Exception e) {
//			return -1;
        }

        // 闂佸湱鐟抽崱鈺傛杸闂佸湱绮敮鎺楁晸閿燂拷
        ResultSet rs_TIupdate = DBQuery.Update(sql_TIupdate);

        try {
            DBQuery.closeDB();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		/*
		 * Task鐞涖劋鑵戠�鐟扮安閺佺増宓侀惃鍕箥鐞涘本顐奸弫鏉垮1
		 */

        String TaskLatestRunTime;
        SimpleDateFormat sdf_task = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now_task = new Date();
        TaskLatestRunTime = sdf_task.format(now_task);
        String sql_Task = "update task set TaskRunNumber = TaskRunNumber +1 "
                + ", TaskLatestRunTime='" + TaskLatestRunTime
                + "' where TaskID=" + TaskID;
        try {
            sql = new String(sql.getBytes("ISO8859-1"), "UTF-8");
        } catch (Exception e) {
//			return -1;
        }

        System.out.println("sql_Task = " + sql_Task);
        // 闂佸湱鐟抽崱鈺傛杸闂佸湱绮敮鎺楁晸閿燂拷
        ResultSet rs_task = DBQuery.Update(sql_Task);
        try {
            DBQuery.closeDB();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


//			String sql_TIID = "select * from TaskInstance where TIresultPath = '" +  TaskInstanceResultPath +"'"  ;
        String sql_TIID = "select max(TIID) as max_tiid from TaskInstance ";

        System.out.println("sql_TIID = " + sql_TIID);

        try {
            sql_TIID = new String(sql_TIID.getBytes("ISO8859-1"), "UTF-8");
        } catch (Exception e) {

        }

        ResultSet rs_TIID = DBQuery.query(sql_TIID);

        int TIID = 0;
        try {
            while (rs_TIID.next()) {
                TIID = rs_TIID.getInt("max_tiid");

            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            DBQuery.closeDB();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        RESULT result = new RESULT();
        result.setResultName("");
        result.setResultPath(TaskInstanceResultPath);
        result.setTaskID(Integer.parseInt(TaskID));
        result.setTIID(TIID);

        ResultBean resultBean = new ResultBean();
        resultBean.insert(result);


//		rd.forward(request, response);
        try {

            TaskInstanceResultPath = TaskInstanceResultPath + "/result.txt";
            System.out.println("start AlgorithmLoad.run(AlgorithmName, datapath, TaskInstanceResultPath, hashmap)");
            System.out.println("@@@@@@@@@@@@@@" + AlgorithmName + datapath + TaskInstanceResultPath + hashmap.toString());
            System.err.println(AlgorithmName);
            AlgorithmLoad.run(AlgorithmName, datapath, TaskInstanceResultPath, hashmap);
            System.out.println("end AlgorithmLoad.run(AlgorithmName, datapath, TaskInstanceResultPath, hashmap)");

        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JDOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String topage = "/TaskInstanceIndex.do";
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher(topage);
        rd.forward(request, response);
        System.out.println("RunTaskInstancesServlet sucess !");


    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }

}
