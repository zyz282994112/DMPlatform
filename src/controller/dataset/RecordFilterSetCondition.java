package controller.dataset;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataset.DSMetadataBean;
import model.dataset.DSMetadataBeanCl;
import model.dataset.FieldInfo;
import model.dataset.ToChi;


public class RecordFilterSetCondition extends HttpServlet implements Servlet {
	public RecordFilterSetCondition() {
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
		DSMetadataBeanCl dsmbc = new DSMetadataBeanCl();
		DSMetadataBean dsmb = dsmbc.read(id);
		String tableHeadDefined = dsmb.getTableHeadDefined();		
		ArrayList<FieldInfo> fields= new ArrayList<FieldInfo>();
		if("Y".equals(tableHeadDefined))
		{
			fields = dsmb.extractFieldsInfo();
		}
		else
		{
			response.getWriter().write("<script>alert(\"fields information not defined!\");" +
					"window.location.href='RecordFilterSelectDs.do'</script>");
			return;
		}
		if(id > 0)
		{
		request.getSession().setAttribute("datasetID",selectedDs);
		request.getSession().setAttribute("fields",fields);
		response.getWriter().write("<script>window.location.href='view/dataset/recordFilter.jsp'</script>");
		return;
		}
		else
		{
			response.getWriter().write("<script>alert(\"field filtering failure!\");" +
					"window.location.href='index.jsp'</script>");
			return;
		}

	}
	private static final long serialVersionUID = 1L;
}

