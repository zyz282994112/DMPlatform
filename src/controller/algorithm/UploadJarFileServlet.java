package controller.algorithm;

import model.algorithm.utils.PathConstant;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * author: csy
 * date: 14-1-2
 * description: Upload Jar File.
 */
public class UploadJarFileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            response.getWriter().write("Not file upload request");
            return;
        }

        // Create a factory for disk-based file items.
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensuere a secure temp location is used)
        File repository = (File) this.getServletConfig().getServletContext()
                .getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> itemList = null;
        try {
            itemList = upload.parseRequest(request);
        } catch (FileUploadException e) {
            return;
        }

        for (FileItem item : itemList) {

            if (item.getName() == null || item.getName().equals(""))
                continue;
            String fileName = PathConstant.LIBPATH+item.getName();
            File fileDel = new File(fileName);
            if(fileDel.exists()){
                fileDel.delete();
            }
            File file = new File(fileName);
            try {
                item.write(file);
                response.getWriter().println("Jar file upload success!");
            } catch (Exception e) {
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
