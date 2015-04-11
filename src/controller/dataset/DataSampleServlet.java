package controller.dataset;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataset.*;


public class DataSampleServlet extends HttpServlet implements Servlet{	
	public DataSampleServlet() {
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

		String datasetID = (String)request.getSession().getAttribute("datasetID");
		String sampleFormat = ToChi.toChi(request.getParameter("sampleFormat"));
		String sampleNumber = ToChi.toChi(request.getParameter("sampleNumber"));
		DataSample dataSample = new DataSample();
		int format;
		if("topN".equals(sampleFormat))
		{
			format = 1;
		}
		else
			if("perN".equals(sampleFormat))
			{
				format = 2;
			}
			else
			{
				format = 3;
			}
		int result = dataSample.dataSample(Integer.parseInt(datasetID), 
				format, Integer.parseInt(sampleNumber));
		DatasetBeanCl dbc = new DatasetBeanCl();
		DatasetBean db = dbc.searchDsDescription(result);
		if(result >0)
		{
			request.getSession ( ).setAttribute("datasetID", String.valueOf(result));
			request.getSession ( ).setAttribute("dsDescription", db);
			response.getWriter().write("<script>alert(\"data sampling success!\");" +
					"window.location.href='view/dataset/modifyPage.jsp'</script>");
			return;
		}
		else
		{
			response.getWriter().write("<script>alert(\"data sampling failure!\");" +
					"window.location.href='ManageDataset.do'</script>");
			return;
		}
	}
	private static final long serialVersionUID = 1L;
}

