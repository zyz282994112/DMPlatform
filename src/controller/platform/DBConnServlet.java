package controller.platform;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import model.platform.DBQuery;

public class DBConnServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7697248818391010389L;
	private String className = null;
    private String username = null;
    private String url = null;
    private String password = null;
    private String useUnicode = "true";
	private String characterEncoding = "UTF-8";
	/**
	 * Constructor of the object.
	 */
	public DBConnServlet() {
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
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		this.className = this.getInitParameter("className");
		this.url = this.getInitParameter("url");
		this.username = this.getInitParameter("username");
		this.password = this.getInitParameter("password");
		this.characterEncoding = this.getInitParameter("characterEncoding");
		this.useUnicode = this.getInitParameter("useUnicode");
		DBQuery.init(className, url,characterEncoding,useUnicode, username, password);
		
	}

}
