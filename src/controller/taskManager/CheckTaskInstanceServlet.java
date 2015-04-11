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
import model.taskManager.TaskInstance;
import model.taskManager.TaskInstanceBean;
import model.taskManager.XMLAcessBean;

public class CheckTaskInstanceServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckTaskInstanceServlet() {
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
		System.out.println("CheckTaskServlet start ! " );
		
//		int taskID = 2;
		int TIID = Integer.valueOf( (String) request.getParameter("TIID"));
		
		System.out.println("TIID = " + TIID );
	
		
		HttpSession session = request.getSession();
		TaskInstanceBean taskInstanceBean = new TaskInstanceBean();
		TaskInstance taskInstance = null;
		HashMap hashmap = null;
		try {
			 taskInstance = taskInstanceBean.checkTaskInstance(TIID);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(taskInstance == null){
			System.out.println("���Taskʧ�ܣ�");
		}else{
			System.out.println("XMLAcessBean.parseXML(taskConfiguration) Start !");
			String TIConfiguration = taskInstance.getTaskInstanceConfiguration();
			
			System.out.println("task.getTaskConfiguration() = " + taskInstance.getTaskConfiguration());
            System.out.println("TIConfiguration = " + TIConfiguration);
			if(TIConfiguration != null){
				hashmap = XMLAcessBean.parseXML(TIConfiguration);
                System.out.println("XMLAcessBean.parseXML(taskConfiguration) Sucess !");

            }
		}
        System.out.println("这阵子"+hashmap.toString());
		
			
		System.out.println("CheckTaskServlet sucess !");

		request.setAttribute("taskinstance", taskInstance);
		request.setAttribute("hashmap", hashmap);
		String topage = "/view/taskManage/taskinstanceinfo.jsp";// 璺宠浆椤靛湴鍧�
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
				topage);
		rd.forward(request, response);
		System.out.println("CheckTaskServlet sucess !");
				
		
		
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
