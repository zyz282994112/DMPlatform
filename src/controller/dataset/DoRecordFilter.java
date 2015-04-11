package controller.dataset;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataset.RecordFilter;
import model.dataset.ToChi;


public class DoRecordFilter extends HttpServlet implements Servlet {
	public DoRecordFilter() {
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

		String field = ToChi.toChi(request.getParameter("selectField"));
		String operator = ToChi.toChi(request.getParameter("selectOperator"));
		String value = ToChi.toChi(request.getParameter("value"));
		int id = Integer.parseInt((String)request.getSession().getAttribute("datasetID"));		
		int newID = RecordFilter.doRecordFilter(id, field, operator, value, ",");
		if(newID > 0)
		{		
			response.getWriter().write("<script>alert(\"Record filtering success!\");" +
					"window.location.href='ManageDataset.do'</script>");
			return;
		}
		else
		{
			response.getWriter().write("<script>alert(\"There is something wrong with the dataset you have choosed.Record filtering failure!\");" +
					"window.location.href='ManageDataset.do'</script>");
			return;
		}

	}
	private static final long serialVersionUID = 1L;
}

