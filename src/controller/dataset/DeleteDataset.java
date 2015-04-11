package controller.dataset;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataset.DatasetBeanCl;
import model.dataset.ToChi;


public class DeleteDataset extends HttpServlet implements Servlet {
	public DeleteDataset() {
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
		//response.sendRedirect("modifyDatasetDescription.jsp");
		DatasetBeanCl dbc = new DatasetBeanCl();
		boolean a = dbc.deleteDataset(Integer.parseInt(datasetID));			
        if(a){
        	response.getWriter().write("<script>alert(\"delete success!\");" +
					"window.location.href='ManageDataset.do'</script>");
        	return;
    		}else{
    			response.getWriter().write("<script>alert(\"delete failure!\");" +
    					"window.location.href='ManageDataset.do'</script>");
    			return;
    			}
	}
	private static final long serialVersionUID = 1L;
}
