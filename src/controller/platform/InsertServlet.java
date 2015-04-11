package controller.platform;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.platform.User;
import model.platform.UserBean;

public class InsertServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public InsertServlet() {
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

		doPost(request,response);
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
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter(); 
		User user = new User();
		user.setUserName(request.getParameter("UserName"));
		user.setProfession(request.getParameter("Profession"));
		user.setCompany(request.getParameter("Company"));
		user.setCAddress(request.getParameter("CAddress"));
		user.setCPhone(request.getParameter("CPhone"));
		user.setCEmail(request.getParameter("CEmail"));
		user.setUserEmail(request.getParameter("UserEmail"));
		user.setUserMSN(request.getParameter("UserMSN"));
		user.setUserQQ(request.getParameter("UserQQ"));
		user.setUserMobile(request.getParameter("UserMobile"));
		user.setUserPhone(request.getParameter("UserPhone"));
		user.setPassword(request.getParameter("Password"));
		user.setImagePath(request.getParameter("image"));
		
		try {
			user = UserBean.insert(user);
			request.setAttribute("user", user);
			RequestDispatcher view = request.getRequestDispatcher("view/platform/userinfo.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.write("<script> alert(\"Your Username had already registered by others!\");window.location.href='index.jsp'</script>");
			e.printStackTrace();
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
