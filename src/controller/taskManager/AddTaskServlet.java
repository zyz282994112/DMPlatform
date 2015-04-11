package controller.taskManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.platform.FrontProcess;
import model.taskManager.Task;
import model.taskManager.TaskBean;

public class AddTaskServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddTaskServlet() {
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
		System.out.println("AllTaskServlet start!");
		
		HttpSession session = request.getSession();
		Integer userID = (Integer) session.getAttribute("userid");
		
		System.out.println("userID = " + userID);
		
	//	String UserID = String.valueOf(userID);
		

		Task task = new Task();
		task.setUserID(userID.toString());
		if(request.getParameter("TaskName") != null){
			task.setTaskName(request.getParameter("TaskName").toString());
		}
		
		if(request.getParameter("TaskDSID") != null){
			task.setTaskDSID(request.getParameter("TaskDSID").toString());
		}
//		if(request.getParameter("AlgorithmID") != null){
//			task.setAlgorithmID(request.getParameter("AlgorithmID").toString());
//		}
		task.setAlgorithmName(request.getParameter("algorithmList"));
		if(request.getParameter("TaskDescription") != null){
			task.setTaskDescription(request.getParameter("TaskDescription").toString());
		}
		if(request.getParameter("TaskPriority") != null){
			task.setTaskPriority(request.getParameter("TaskPriority").toString());
		}

		
		HashMap<String, String> hashmap = new HashMap<String, String>();
//    	hashmap.put("key1", "value1");
//    	hashmap.put("key2", "value2"); 
		
		hashmap = FrontProcess.toHashMap(request.getParameter("hashmap"));
		TaskBean taskBean = new TaskBean();
		System.out.println("taskBean.addTask() start !");
		
		try {
			Task taskNew  = taskBean.addTask( userID,  task ,  hashmap);
			
			/*
			 * renturn 0 is sucess
			  * return 1 createXML fail
			 * return -1 is δ֪����
			*/
			request.setAttribute("task", task);
			request.setAttribute("hashmap", hashmap);
		
//			else {
//				request.setAttribute("issucess","no defined" );
//			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("when insert sql find  NumberFormatException");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("when insert sql find  SQLException");
			e.printStackTrace();
		}
		
		System.out.println("addTaskBean.addTask() return sucess!");
		
		String topage = "/view/taskManage/taskinfo.jsp";
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
				topage);
		rd.forward(request, response);
		
		System.out.println("AddTaskServlet sucess!");
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
