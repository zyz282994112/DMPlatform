package controller.algorithm;

import model.algorithm.utils.ServletConstants;
import model.platform.DBQuery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author: csy
 * date: 14-1-2
 * description: Update algorithm information.
 */
public class UpdateAlgorithmServlet extends HttpServlet {
    public static final String SUCCESSINFO = "<script>alert(\"modify success!\")</script>";
    public static final String FALUREINFO = "<script>alert(\"modify failure!\")</script>";


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

        request.setCharacterEncoding(ServletConstants.CHN_ENCODING);
        String aName = request.getParameter("algorithmIdSelect").trim();
        String aDes = request.getParameter("algorithmDescription").trim();
        if (aDes.equals("")) {
            response.getWriter().println("description must be not null!");
            return;
        }
        String sql = "update algorithm  set AlgorithmDescription=\"" + aDes + "\"" + " where AlgorithmName=\"" + aName + "\"";
        DBQuery.Update(sql);


    }
}
