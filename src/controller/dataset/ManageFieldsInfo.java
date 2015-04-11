package controller.dataset;

import java.io.IOException;
import java.util.*;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataset.DSMetadataBean;
import model.dataset.DSMetadataBeanCl;
import model.dataset.DatasetBean;
import model.dataset.DatasetBeanCl;
import model.dataset.FieldInfo;
import model.dataset.ToChi;


public class ManageFieldsInfo extends HttpServlet implements Servlet {
	public ManageFieldsInfo() {
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

		int id = Integer.parseInt(ToChi.toChi(request.getParameter("datasetID")));		
		DatasetBean db = new DatasetBean();
		DatasetBeanCl dbc = new DatasetBeanCl();
		db = dbc.searchDsDescription(id);
		int fieldsNo = Integer.parseInt(db.getFieldsNo());
		
		DSMetadataBean dsmb = null;
		DSMetadataBeanCl dsmbc = new DSMetadataBeanCl();
		dsmb = dsmbc.read(id);
		String tableHeadDefined = dsmb.getTableHeadDefined();
		
		ArrayList<FieldInfo> fields= new ArrayList<FieldInfo>();
		if("Y".equals(tableHeadDefined))
		{
			fields = dsmb.extractFieldsInfo();
		}
		else
		{
			//if table head is not defined,use the default value
			for(int i=0;i<fieldsNo;i++)
			{
				FieldInfo fieldInfo =new FieldInfo("field"+(i+1),"String","-");
				fields.add(fieldInfo);
			}
		}
		
		request.getSession().setAttribute("fields",fields);
		request.getSession().setAttribute("id",String.valueOf(id));
		request.getSession().setAttribute("name",db.getName());
		response.sendRedirect(request.getContextPath()+
    			"/view/dataset/manageFieldsInfo.jsp");

	}
	private static final long serialVersionUID = 1L;
}

