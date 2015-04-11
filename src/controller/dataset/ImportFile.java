package controller.dataset;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataset.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class ImportFile extends HttpServlet implements Servlet {
	public ImportFile() {
		// TODO Auto-generated constructor stub
        
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
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
	 protected void doPost ( HttpServletRequest request, HttpServletResponse response )
	   throws ServletException, IOException
	 {
		 //response.sendRedirect("modifyDatasetDescription.jsp");
		 response.setCharacterEncoding("UTF-8");       
         request.setCharacterEncoding("UTF-8");       
         
       
         DiskFileItemFactory factory = new DiskFileItemFactory();
         
         String temp = System.getProperty("java.io.tmpdir");          
         factory.setSizeThreshold(1024*1024);        
         factory.setRepository(new File(temp));       
         ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
         
         int recordsNo = 0;
         int fieldsNo = 0;
         long size = 0;
         String filename = null;
         String nameWithoutFormat = new String();
         String format = new String();
         try {
                 @SuppressWarnings("unchecked")
				List<FileItem> list = servletFileUpload.parseRequest(request);      
                 for(FileItem item : list){
                         String name = item.getFieldName();
                         
                         if(item.isFormField()){       
                                String value = item.getString();
                                request.setAttribute(name, value);
                         }
                         else{
                                filename = item.getName();
                                int lastIndex = filename.lastIndexOf(".");
                                if(lastIndex == -1)
                                {
                                	nameWithoutFormat = filename;
                                	format = "";
                                }
                                else
                                {
                                nameWithoutFormat = filename.substring(0,lastIndex);
                                format = filename.substring(lastIndex+1);
                                }
                                if(Check.cheakFilenameExist(nameWithoutFormat, -1))
                                {
                               	 response.getWriter().write("<script>alert(\"There exists a file with the same name!Please rename your file.\");" +
                          					"window.location.href='view/dataset/importFile.jsp'</script>");
                             		 System.out.println("import failure!");
                             		return;
                                }
                                InputStream in = item.getInputStream();
                                FileOutputStream outs = new FileOutputStream(new File(SystemConstants.UPLOADDIRECTORY,filename));
                                int len = 0;
                                byte[] buffer = new byte[1024];              
                                System.out.println("size:" + item.getSize()+" B");
                                size = item.getSize();
                                while((len = in.read(buffer)) != -1){
                                        outs.write(buffer, 0, len);
                                }
                                in.close();
                                outs.close();
                         }
                 }
         }
         catch (FileUploadException e) 
         {
         // TODO Auto-generated catch block
        
         e.printStackTrace();
         request.getSession ( ).setAttribute("importFile_failed", "true");
         response.sendRedirect(request.getContextPath()+
 				"/view/dataset/importFile.jsp");
         return;
         }
         Date date = new Date();
         SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
         String create_time = df.format(date);
         String upload_time = df.format(date);
         String last_modification_time = df.format(date);
         DatasetBeanCl dbc = new DatasetBeanCl();
         DatasetBean db = new DatasetBean();
         db.setCreateTime(create_time);
         db.setUploadTime(upload_time);
         db.setLastModificationTime(last_modification_time);
         recordsNo = CalRecordsFieldsNo.calculateRecordsNo(SystemConstants.UPLOADDIRECTORY,filename);
         fieldsNo = CalRecordsFieldsNo.calculateFieldsNo(SystemConstants.UPLOADDIRECTORY,filename);
         db.setRecordsNo(String.valueOf(recordsNo));
         db.setFieldsNo(String.valueOf(fieldsNo));
         db.setSize(String.valueOf(size));
         db.setSavingPath(SystemConstants.UPLOADDIRECTORY);
         db.setName(nameWithoutFormat);
         db.setFileFormat(format);
         int a = dbc.addDataset(db);
         if(a>0)
         {      	 
        	 request.getSession().setAttribute("datasetID", String.valueOf(a));
        	 request.getSession().setAttribute("dsDescription", db);
        	 response.getWriter().write("<script>alert(\"import success!\");" +
 					"window.location.href='view/dataset/modifyPage.jsp'</script>");
        	 return;
     	}
         else
         {
        	 response.getWriter().write("<script>alert(\"import failure!\");" +
  					"window.location.href='view/dataset/importFile.jsp'</script>");
     		 System.out.println("import failure!");
     		return;
     	}
	 }
	private static final long serialVersionUID = 1L;
}
