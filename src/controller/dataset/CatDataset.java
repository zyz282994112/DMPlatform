package controller.dataset;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataset.*;


public class CatDataset extends HttpServlet implements Servlet {
	public CatDataset() {
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

		String datasetID = ToChi.toChi(request.getParameter("datasetID"));
		String recordLine = ToChi.toChi(request.getParameter("recordLine"));
		//response.sendRedirect("modifyDatasetDescription.jsp");
		if ("-1".equals(recordLine)) {
			DatasetBeanCl dbc = new DatasetBeanCl();
			DatasetBean db = new DatasetBean();
			db = dbc.searchDsDescription(Integer.parseInt(datasetID));			
			
			request.getSession().setAttribute("dsDescription",db);
			response.sendRedirect(request.getContextPath()+
    				"/view/dataset/catDataSetDscrpt.jsp");
			return;
		}
		else
		{
//			int id = Integer.parseInt(datasetID);
//			int line = Integer.parseInt(recordLine);
//			DatasetRecordManagement drm = new DatasetRecordManagement();
//			String record = drm.readDatasetRecord(id, (long)line);
//			if ("".equals(record))
//			{
//				record ="NULL";
//			}
//			request.getSession().setAttribute("record",record);
//			request.getSession().setAttribute("findRecord","true");
//			response.sendRedirect(request.getContextPath()+
//    				"/view/dataset/catDataset.jsp");
		}
	}
	private static final long serialVersionUID = 1L;
}
