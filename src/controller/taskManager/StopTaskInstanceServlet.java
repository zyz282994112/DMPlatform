package controller.taskManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.algorithm.utils.ProcessKill;
import model.taskManager.TaskInstance;
import model.taskManager.TaskInstanceBean;

public class StopTaskInstanceServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StopTaskInstanceServlet() {
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
//		int tiId = 1;
        System.out.println("StopTaskInstance start!");
		int TIID = Integer.parseInt(request.getParameter("TIID"));
		TaskInstanceBean taskInstanceBean = new TaskInstanceBean();

        int ProcessID;
        try {
            TaskInstance taskinstance = taskInstanceBean.checkTaskInstance(TIID);
            ProcessID = Integer.parseInt(taskinstance.getProcessID());
            ProcessKill.KillPro(ProcessID);

        } catch (NumberFormatException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
			taskInstanceBean.stopTaskInstance(TIID);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String topage = "/TaskInstanceIndex.do";// 璺宠浆椤靛湴鍧�
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
				topage);
		rd.forward(request, response);
		
		System.out.println("StopTaskServlet sucess !");
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
