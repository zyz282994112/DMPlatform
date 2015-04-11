package controller.algorithm;

import model.algorithm.utils.ServletConstants;
import model.platform.DBQuery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * author: csy
 * date: 14-1-2
 * description: Delete algorithm.
 */
public class DelAlgorithmServlet extends HttpServlet {
    public static final String SUCCESSINFO = "<script>alert(\"del success!\")</script>";
    public static final String FALUREINFO = "<script>alert(\"del failure!\")</script>";


    public void destroy() {
        try {
            DBQuery.closeDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean delFile(String filePath) {

        File delFile = new File(filePath);
        boolean delSuccess = false;
        if (delFile.exists()) {
            delSuccess = delFile.delete();
        }
        return delSuccess;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding(ServletConstants.CHN_ENCODING);
            String aName = request.getParameter("algorithmIdSelect").trim();
            if (aName == null || aName.equals("")) {
                response.getWriter().println("error!");
                return;
            }
            String sqlQuery = "select AlgorithmParameterPath,AlgorithmPath from algorithm where AlgorithmName=\"" + aName + "\"";
            ResultSet rs = DBQuery.query(sqlQuery);
            String jarPath = "";
            String confPath = "";
            if (rs.next()) {
                jarPath = rs.getString("AlgorithmPath");
                confPath = rs.getString("AlgorithmParameterPath");
            }

            String sql = "delete from algorithm where AlgorithmName=\"" + aName + "\"";
            DBQuery.Update(sql);
            delFile(jarPath);
            delFile(confPath);
            response.getWriter().println(SUCCESSINFO);

        } catch (SQLException e) {
            response.getWriter().println(FALUREINFO);
        } catch (Exception e) {
            response.getWriter().println(FALUREINFO);
        }

    }
}
