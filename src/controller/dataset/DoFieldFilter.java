package controller.dataset;

import java.io.IOException;
import java.util.*;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataset.FieldFilter;
import model.dataset.ToChi;


public class DoFieldFilter extends HttpServlet implements Servlet {
	public DoFieldFilter() {
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
		int id = Integer.parseInt((String)request.getSession().getAttribute("datasetID"));		
		//ArrayList<FieldInfo> fields= new ArrayList<FieldInfo>();
		//boolean checkFields = true;
		ArrayList<String> fieldsName = new ArrayList<String>(); //save all the fields' name choosen
		for(int i=1;i<=fieldsNo;i++)
		{
			String name = ToChi.toChi(request.getParameter("name"+i));
			//fieldsName.add(name);
			//String type = ToChi.toChi(request.getParameter("type"+i));
			//String meaning = ToChi.toChi(request.getParameter("meaning"+i));
			String judge = ToChi.toChi(request.getParameter("select"+i));
			    if(judge != null)
			    {
			    	fieldsName.add(name);
			    }
		}
		if(fieldsName.size() == 0)
		{
			response.getWriter().write("<script>alert(\"You have choosed no field!\");" +
					"window.location.href='view/dataset/etlindex.jsp'</script>");
			return;
		}
		int newID = FieldFilter.fieldFilter(id, fieldsName, ",");
		if(newID > 0)
		{		
			response.getWriter().write("<script>alert(\"Field filtering success!\");" +
					"window.location.href='ManageDataset.do'</script>");
			return;
		}
		else
		{
			response.getWriter().write("<script>alert(\"There is something wrong with the dataset you have choosed.Field filtering failure!\");" +
					"window.location.href='ManageDataset.do'</script>");
			return;
		}

	}
	private static final long serialVersionUID = 1L;
}

