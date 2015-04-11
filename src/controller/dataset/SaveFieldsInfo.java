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
import model.dataset.FieldInfo;
import model.dataset.ToChi;


public class SaveFieldsInfo extends HttpServlet implements Servlet {
	public SaveFieldsInfo() {
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

		int fieldsNo = Integer.parseInt((String)request.getSession().getAttribute("fieldsNo"));
		int id = Integer.parseInt((String)request.getSession().getAttribute("id"));		
		ArrayList<FieldInfo> fields= new ArrayList<FieldInfo>();
		boolean checkFields = true;
		ArrayList<String> fieldsName = new ArrayList<String>(); //save all the fields' name
		for(int i=1;i<=fieldsNo;i++)
		{
			String name = ToChi.toChi(request.getParameter("name"+i));
			fieldsName.add(name);
			String type = ToChi.toChi(request.getParameter("type"+i));
			String meaning = ToChi.toChi(request.getParameter("meaning"+i));
			FieldInfo field = new FieldInfo(name, type, meaning);
			fields.add(field);
		}
		//make sure there are no same fields
		for(int i=1;i<fieldsName.size();i++)
		{
			for(int j=0;j<i;j++)
			{
				if(fieldsName.get(i).equals(fieldsName.get(j)))
				{
					checkFields = false;
				}
			}
		}
		if(false == checkFields)
		{
			response.getWriter().write("<script>alert(\"fields cannot have same names!\");" +
					"window.location.href='ManageFieldsInfo.do?datasetID=" +
					String.valueOf(id)+
					"'</script>");
			return;
		}
		DSMetadataBean dsmb = new DSMetadataBean(id,fields);
		DSMetadataBeanCl dsmbc = new DSMetadataBeanCl();
		boolean modified;
		modified = dsmbc.modify(id, dsmb);
		if(modified == true)
		{		
			response.getWriter().write("<script>alert(\"modify success!\");" +
					"window.location.href='ManageDataset.do'</script>");
			return;
		}
		else
		{
			response.getWriter().write("<script>alert(\"modify failure!\");" +
					"window.location.href='ManageDataset.do'</script>");
			return;
		}

	}
	private static final long serialVersionUID = 1L;
}

