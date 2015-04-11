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
 * description: Show algorithm's name.
 */
public class ShowAlgorithmServlet extends HttpServlet {


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
            String sql = "select AlgorithmName from algorithm";
            ResultSet rs =  DBQuery.query(sql);
            String aloSet = "";
            while (rs.next()){
                 aloSet += rs.getString("AlgorithmName")+" ";
            }
            aloSet = aloSet.trim();
            response.setHeader("content-type", "text/html;charset=UTF-8");

            response.getWriter().println(aloSet);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
