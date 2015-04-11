package controller.dataset;

//public class ModifyDatasetDescriptionServlet {

//}

import java.io.IOException;
//import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataset.*;
public class ModifyDatasetDescriptionServlet extends HttpServlet implements Servlet
{
 public ModifyDatasetDescriptionServlet ()
 {
  // TODO Auto-generated constructor stub

 }
 /*
  * (non-Javadoc)
  *
  * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
  * javax.servlet.http.HttpServletResponse)
  */
 @Override
 protected void doGet ( HttpServletRequest request, HttpServletResponse response )
   throws ServletException, IOException
 {
	 doPost(request,response);
 }
 /*
  * (non-Javadoc)
  *
  * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
  * javax.servlet.http.HttpServletResponse)
  */
 @Override
 protected void doPost ( HttpServletRequest request, HttpServletResponse response )
   throws ServletException, IOException
 {
  //response.setContentType ( "text/html" );
  
  String id = (String) request.getSession().getAttribute("datasetID");
  String name = ToChi.toChi(request.getParameter ( "name" ));
  if(Check.cheakFilenameExist(name, Integer.parseInt(id)))
  {
 	 response.getWriter().write("<script>alert(\"There exists a file with the same name!Please rename your file.\");" +
				"window.location.href='ModifyDsDscrptPre.do?datasetID=" +id+
				"'</script>");
		 System.out.println("import failure!");
		 return;
  }
  String file_format = ToChi.toChi(request.getParameter ( "file_format" ));
  String source = ToChi.toChi(request.getParameter ( "source" ));
  String creator = ToChi.toChi(request.getParameter ( "creator" ));
  String creator_company = ToChi.toChi(request.getParameter ( "creator_company" ));
  String creator_address = ToChi.toChi(request.getParameter ( "creator_address" ));
  String creator_zipcode = ToChi.toChi(request.getParameter ( "creator_zipcode" ));
  String creator_telephone = ToChi.toChi(request.getParameter ( "creator_telephone" ));
  String creator_email = ToChi.toChi(request.getParameter ( "creator_email" ));
  String relational_category = ToChi.toChi(request.getParameter ( "relational_category" ));
  String metadata_description = ToChi.toChi(request.getParameter ( "metadata_description" ));
  String uploader = ToChi.toChi(request.getParameter ( "uploader" ));
  String uploader_company = ToChi.toChi(request.getParameter ( "uploader_company" ));
  String uploader_address = ToChi.toChi(request.getParameter ( "uploader_address" ));
  String uploader_zipcode = ToChi.toChi(request.getParameter ( "uploader_zipcode" ));
  String uploader_telephone = ToChi.toChi(request.getParameter ( "uploader_telephone" ));
  String uploader_email = ToChi.toChi(request.getParameter ( "uploader_email" ));
  //format date
  Date date = new Date();
 SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
  String last_modification_time = df.format(date);
  String description = ToChi.toChi(request.getParameter ( "description" ));
  DatasetBeanCl dbc = new DatasetBeanCl();
  DatasetBean db = new DatasetBean();
  db = dbc.searchDsDescription(Integer.parseInt(id));
  String records_no = db.getRecordsNo();
  String fields_no = db.getFieldsNo();
  String size = db.getSize();
  String saving_path = db.getSavingPath();
  String create_time = db.getCreateTime();
  String upload_time = db.getUploadTime();
  db.setAll(Integer.parseInt(id), name, file_format, saving_path, source, creator, 
		  creator_company, creator_address, creator_zipcode, creator_telephone, creator_email, 
		  records_no, fields_no, size, 
		  relational_category, metadata_description, uploader, 
		  uploader_company, uploader_address, uploader_zipcode, uploader_telephone, 
		  uploader_email, create_time, upload_time, last_modification_time, description);
  boolean a = dbc.modify(Integer.parseInt(id), db);
  if(a){
	  	request.getSession().setAttribute("dsDescription",db);
	  	response.getWriter().write("<script>alert(\"modify success!\");" +
				"window.location.href='view/dataset/catDataSetDscrpt.jsp'</script>");
	  	return;
		}else{
			response.getWriter().write("<script>alert(\"modify failure!\");" +
					"window.location.href='ModifyDsDscrptPre.do?datasetID=" +id+
					"'</script>");
			return;
			}
 	}
  
 private static final long serialVersionUID = 1L;
}