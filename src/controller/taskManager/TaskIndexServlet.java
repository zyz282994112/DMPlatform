package controller.taskManager;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.taskManager.Task;
import model.taskManager.TaskBean;


/*
 * �г���ǰ�û�����������
 * request��userid  (request.getParameter("userid"));
 * response��List<Task> (request.setAttribute("alltask", list);)
 */
public class TaskIndexServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TaskIndexServlet() {
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
		System.out.println("TaskIndexServlet start ! " );

		HttpSession session = request.getSession();
		int userID = (Integer) session.getAttribute("userid");
		
//		int userID = Integer.parseInt(request.getParameter("userid"));

//		int userID = 1;

		TaskBean taskBean = new TaskBean();

		List<Task> list = null;
		try {
			list = taskBean.getAllTask( userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("alltask", list);
		
		String topage = "/view/taskManage/tasklist.jsp";// 璺宠浆椤靛湴鍧�

		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
				topage);
		rd.forward(request, response);
			
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








