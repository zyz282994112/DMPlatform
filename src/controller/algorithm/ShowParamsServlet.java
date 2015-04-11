package controller.algorithm;

import model.algorithm.utils.ServletConstants;
import model.platform.DBQuery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * Created with IntelliJ IDEA.
 * User: chengsiyuan
 * Date: 14-3-17
 * Time: 下午6:45
 * To change this template use File | Settings | File Templates.
 */
public class ShowParamsServlet extends HttpServlet {

    public void destroy() {
        try {
            DBQuery.closeDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding(ServletConstants.CHN_ENCODING);
            String aName = request.getParameter("alName").trim();
            String sql = "select AlgorithmParameter from algorithm where AlgorithmName=\"" + aName + "\"";
            ResultSet rs = DBQuery.query(sql);
            String aParams = "";
            if (rs.next()) {
                aParams += rs.getString("AlgorithmParameter");
            }
            response.setHeader("content-type", "text/html;charset=UTF-8");

            response.getWriter().println(aParams);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
