package controller.dataset;

import java.io.IOException;
import java.util.*;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataset.DatasetBean;
import model.dataset.DatasetBeanCl;


public class DataSampleSelectDs extends HttpServlet implements Servlet {
	public DataSampleSelectDs() {
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
		DatasetBeanCl dbc = new DatasetBeanCl();
		ArrayList<DatasetBean> al=new ArrayList<DatasetBean>();
		al = dbc.searchAll();			
		if(al.size() != 0)
		{
		request.getSession().setAttribute("arrayList",al);
		response.getWriter().write("<script>window.location.href='view/dataset/dataSampleSelectDs.jsp'</script>");
		return;
		}
		else
		{
			response.getWriter().write("<script>alert(\"There are no datasets now or something is wrong with the database!\");" +
					"window.location.href='index.jsp'</script>");
			return;
		}

	}
	private static final long serialVersionUID = 1L;
}

