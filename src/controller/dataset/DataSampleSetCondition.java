package controller.dataset;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataset.ToChi;


public class DataSampleSetCondition extends HttpServlet implements Servlet {
	public DataSampleSetCondition() {
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
		String selectedDs = ToChi.toChi(request.getParameter("selectdataset"));
		int id = Integer.parseInt(selectedDs);
		if(id > 0)
		{
		request.getSession().setAttribute("datasetID",selectedDs);
		response.getWriter().write("<script>window.location.href='view/dataset/dataSample.jsp'</script>");
		return;
		}
		else
		{
			response.getWriter().write("<script>alert(\"data sampling failure!\");" +
					"window.location.href='index.jsp'</script>");
			return;
		}

	}
	private static final long serialVersionUID = 1L;
}

