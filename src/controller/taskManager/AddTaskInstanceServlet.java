package controller.taskManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.taskManager.Task;
import model.taskManager.TaskBean;

import model.taskManager.TaskInstanceBean;
import model.taskManager.XMLAcessBean;

public class AddTaskInstanceServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddTaskInstanceServlet() {
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
		System.out.println("AddTaskInstanceServlet start ! " );
		
//		int taskID = 2;
		int taskID = Integer.valueOf( (String) request.getParameter("taskID"));
		
//		System.out.println("taskID" + taskID );
	
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userid");
		
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
			System.out.println("task null");
		}else{
//			System.out.println("XMLAcessBean.parseXML(taskConfiguration) Start !");
			String taskConfiguration = task.getTaskConfiguration();
			hashmap = XMLAcessBean.parseXML(taskConfiguration);
//			System.out.println("XMLAcessBean.parseXML(taskConfiguration) Sucess !");
		}
		
		if(hashmap == null){
			System.out.println("hashmap null");
		}else{
			request.setAttribute("task", task);
			request.setAttribute("hashmap", hashmap);
			String topage = "/view/taskManage/runtask.jsp";		
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
					topage);
			rd.forward(request, response);
			System.out.println("CheckTaskServlet sucess !");
		}
		
		
		
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
