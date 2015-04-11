package controller.algorithm;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import model.algorithm.utils.PathConstant;
import model.algorithm.utils.ServletConstants;
import model.algorithm.utils.XmlParser;
import model.platform.DBQuery;
import org.apache.mahout.common.Pair;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * author: csy
 * date: 14-1-2
 * description: Add algorithm, in this class, one param filePath should be modified.
 */
public class AddAlgorithmServlet extends HttpServlet {
    public static final String SUCCESSINFO = "<script>alert(\"add success!\")</script>";
    public static final String FALUREINFO = "<script>alert(\"add failure!\")</script>";

    public void destroy() {
        try {
            DBQuery.closeDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected boolean isNull(String name, String value, HttpServletResponse response) throws IOException {

        if (value == null || value.equals("")) {
            response.getWriter().println("error! " + name + " is null");
            return false;
        }
        return true;
    }

    protected boolean checkSame(HttpServletResponse response, String aName) throws SQLException, IOException {

        String checkSameNameSql = "select count(*) from algorithm where AlgorithmName=\"" + aName + "\"";
        DBQuery.query(checkSameNameSql);
        ResultSet rs = DBQuery.query(checkSameNameSql);
        int rowCount = 0;
        if (rs.next()) {
            rowCount = rs.getInt(1);
        }
        if (rowCount > 0) {
            response.getWriter().println("error! database has the same name algorithm!");
            return true;
        }
        return false;
    }

    public void upload(String aName, SmartUpload smartUpload) throws IOException, ServletException, SmartUploadException {

        Files files = smartUpload.getFiles();
        for (int i = 0; i < files.getCount(); i++) {
            com.jspsmart.upload.File singlefile = files.getFile(i);
            if (!singlefile.isMissing()) {
                String ext = singlefile.getFileExt();
                if (ext.equals("jar")) {
                    String filedirs = new String(PathConstant.LIBPATH + aName + "." + ext);
                    singlefile.saveAs(filedirs, File.SAVEAS_AUTO);

                } else {
                    String filedirs = new String(PathConstant.CONFPATH + aName + "." + ext);
                    singlefile.saveAs(filedirs, File.SAVEAS_AUTO);
                }

            }
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding(ServletConstants.CHN_ENCODING);
            com.jspsmart.upload.SmartUpload smartUpload = new com.jspsmart.upload.SmartUpload();
            smartUpload.initialize(this.getServletConfig(), request, response);
            smartUpload.setAllowedFilesList("xml,jar");
            smartUpload.upload();


            String aName = smartUpload.getRequest().getParameter("algorithmname").trim();
            String aDescription = smartUpload.getRequest().getParameter("algorithmdescription").trim();
            String aType = smartUpload.getRequest().getParameter("algorithmtype").trim();

            if (!isNull("algorithmname", aName, response) || !isNull("algorithmdescription", aDescription, response) || !isNull("algorithmtype", aType, response)) {
                return;
            }
            if (checkSame(response, aName)) {
                return;
            }
            upload(aName, smartUpload);
            String JarPath = PathConstant.LIBPATH + aName + ".jar";
            String ConfPath = PathConstant.CONFPATH + aName + ".xml";
            	
            List<Pair<String, String>> paramList = XmlParser.paramParser(aName);

            List<Pair<String, String>> tmpParamList = paramList.subList(0, paramList.size() - 2);

            String aParams = "";
            for (Pair<String, String> arg : tmpParamList) {
                System.out.println(arg.getFirst());
                aParams += arg.getFirst() + ",";
            }
            aParams = aParams.substring(0, aParams.length() - 1);

            String sql = "insert into algorithm(AlgorithmName,AlgorithmType,AlgorithmPath,AlgorithmParameter,AlgorithmParameterPath,AlgorithmDescription) " +
                    "values(\"" + aName + "\"," + "\"" + aType + "\"," + "\"" + JarPath + "\"," + "\"" + aParams + "\"," + "\"" + ConfPath + "\"," + "\"" + aDescription + "\")";
            DBQuery.Update(sql);
            response.getWriter().println(SUCCESSINFO);


        } catch (SQLException e) {
            response.getWriter().println(FALUREINFO);
        } catch (Exception e) {
            response.getWriter().println(FALUREINFO);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}