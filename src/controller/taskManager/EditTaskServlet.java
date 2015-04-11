package controller.taskManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.taskManager.Task;
import model.taskManager.TaskBean;
import model.taskManager.XMLAcessBean;

public class EditTaskServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EditTaskServlet() {
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
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost( request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("textml;charset=utf-8");
		System.out.println("EditTaskServlet start !");
		HttpSession session = request.getSession();
		String method = request.getParameter("method");// 鎿嶄綔鏂规硶
		
		///////////////////////////////////////////////////////////////////
		if(method.equals("getTaskInfo")){
			int taskID = Integer.valueOf( (String) request.getParameter("taskID"));
			
			System.out.println("taskID = " + taskID );
		
			TaskBean taskBean = new TaskBean();
			Task task = null;
			HashMap hashmap = null;
			try {
				 task = taskBean.checkTask(taskID);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(task == null){
				System.out.println("���Taskʧ�ܣ�");
			}else{
				System.out.println("XMLAcessBean.parseXML(taskConfiguration) Start !");
				String taskConfiguration = task.getTaskConfiguration();
				
				System.out.println("task.getTaskConfiguration() = " + task.getTaskConfiguration());
				if(taskConfiguration != null){
					hashmap = XMLAcessBean.parseXML(taskConfiguration);
				}
				
				System.out.println("XMLAcessBean.parseXML(taskConfiguration) Sucess !");
			}
			
			if(hashmap == null){
				System.out.println("���Hashmapʧ�ܣ�");
			}else{
				
				System.out.println("CheckTaskServlet sucess !");
				
				request.setAttribute("task", task);
				request.setAttribute("hashmap", hashmap);
//				String topage = "/view/taskManage/taskinfo.jsp";// 璺宠浆椤靛湴鍧�
				String topage = "/view/taskManage/edittask.jsp";// 璺宠浆椤靛湴鍧�
				
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
						topage);
				rd.forward(request, response);
				System.out.println("CheckTaskServlet sucess !");
			}
		}else if(method.equals("editTask")){
			int userID = (Integer) session.getAttribute("userid");
			
			System.out.println("userID = " + userID);
			
			String UserID = String.valueOf(userID);
			

			Task task = new Task();
			task.setUserID(UserID);
			if(request.getParameter("TaskID") != null){
				task.setTaskID(request.getParameter("TaskID").toString());
			}
			if(request.getParameter("TaskName") != null){
				task.setTaskName(request.getParameter("TaskName").toString());
			}
			
			if(request.getParameter("TaskDSID") != null){
				task.setTaskDSID(request.getParameter("TaskDSID").toString());
			}
			if(request.getParameter("AlgorithmID") != null){
				task.setAlgorithmID(request.getParameter("AlgorithmID").toString());
			}
//			if(request.getParameter("algorithmList") != null){
//			task.setAlgorithmName(request.getParameter("algorithmList").toString());
//			}
			if(request.getParameter("TaskDescription") != null){
				task.setTaskDescription(request.getParameter("TaskDescription").toString());
			}
			if(request.getParameter("TaskPriority") != null){
				task.setTaskPriority(request.getParameter("TaskPriority").toString());
			}
			
//			HashMap<String, String> hashmap = request.getParameter("hashmap");

			
			HashMap<String, String> hashmap = new HashMap<String, String>();
//	    	hashmap.put("key1", "value1");
//	    	hashmap.put("key2", "value2"); 
			
			
			TaskBean taskBean = new TaskBean();
			System.out.println("taskBean.addTask() start !" );
			
			try {
				int  TaskID = taskBean.editTask( userID,  task ,  hashmap);
				Task task_new = taskBean.checkTask(TaskID);
				request.setAttribute("task", task_new);
				request.setAttribute("hashmap",hashmap);
				
				/*
				 * renturn 0 is sucess
				  * return 1 createXML fail
				 * return -1 is δ֪����
				*/
//				if(isSucess == 0){
//					request.setAttribute("issucess","sucess" );
//				}else if(isSucess == 1){
//					request.setAttribute("issucess","false" );
//				}
//				else {
//					request.setAttribute("issucess","no defined" );
//				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("when insert sql find  NumberFormatException");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("when insert sql find  SQLException");
				e.printStackTrace();
			}
			
			System.out.println("TaskBean.editTask() return sucess!");
			
			String topage = "/view/taskManage/taskinfo.jsp";
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
					topage);
			rd.forward(request, response);
			
			System.out.println("EditTaskServlet sucess!");
		}
		
	}//

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		
		
	}

}
