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
 * author: csy
 * date: 14-1-2
 * description: Show algorithm information.
 */

public class ShowADesInfoServlet extends HttpServlet {


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
            String sql = "select AlgorithmDescription from algorithm where AlgorithmName=\"" + aName + "\"";
            ResultSet rs = DBQuery.query(sql);
            String aDesInfo = "";
            if (rs.next()) {
                aDesInfo += rs.getString("AlgorithmDescription");
            }
            response.setHeader("content-type", "text/html;charset=UTF-8");

            response.getWriter().println(aDesInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
