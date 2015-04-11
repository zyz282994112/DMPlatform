package controller.dataset;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataset.*;


public class SubmitAddDsRecord extends HttpServlet implements Servlet {
	public SubmitAddDsRecord() {
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

		//String datasetID = ToChi.toChi(request.getParameter("datasetID"));
		DatasetBean db = (DatasetBean)request.getSession().getAttribute("db");
		String record = "";
		int fieldsNo = Integer.parseInt(db.getFieldsNo());
		for(int i=0;i<fieldsNo;i++)
		{
			if(i == 0)
			{
				record += ToChi.toChi(request.getParameter("fields1"));
			}
			else
			{
				record += ";";
				String temp = "fields" + String.valueOf(i+1);
				record += ToChi.toChi(request.getParameter(temp));
			}
		}
		record += "\r\n";
		//String recordLine = ToChi.toChi(request.getParameter("recordLine"));
		//response.sendRedirect("modifyDatasetDescription.jsp");		
		DatasetRecordManagement drm = new DatasetRecordManagement();
		int a = drm.addDatasetRecord(db.getId(),record );
		if(a == 0)
		{
		request.getSession().setAttribute("add_record","true");
		response.sendRedirect(request.getContextPath()+
    			"/view/dataset/fillInDsRecord.jsp");
		return;
		}
			
	}
	private static final long serialVersionUID = 1L;
}

