package controller.dataset;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataset.DatasetBean;
import model.dataset.DatasetBeanCl;
import model.dataset.ToChi;


public class AddDatasetRecord extends HttpServlet{
    public static final String FAILURE = "<script>alert(\"failure!\")</script>";
	
	public AddDatasetRecord() {
		// TODO Auto-generated constructor stub

	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try
		{
		String datasetID = ToChi.toChi(request.getParameter("datasetID"));
		//String recordLine = ToChi.toChi(request.getParameter("recordLine"));
		//response.sendRedirect("modifyDatasetDescription.jsp");
		DatasetBeanCl dbc = new DatasetBeanCl();
		DatasetBean db = new DatasetBean();
		db = dbc.searchDsDescription(Integer.parseInt(datasetID));			
			
		request.getSession().setAttribute("datasetBean",db);
		response.sendRedirect(request.getContextPath()+
    			"/view/dataset/fillInDsRecord.jsp");
		return;
		}
		catch(Exception e)
		{
			response.getWriter().println(FAILURE);
		}
			
	}
	private static final long serialVersionUID = 1L;
}

