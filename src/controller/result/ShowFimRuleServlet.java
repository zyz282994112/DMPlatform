package controller.result;

import model.algorithm.utils.PathConstant;
import model.platform.DBQuery;
import model.result.JavaCallPython;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: chengsiyuan
 * Date: 14-4-2
 * Time: 下午3:58
 * To change this template use File | Settings | File Templates.
 */
public class ShowFimRuleServlet extends HttpServlet {
    protected void selectShowResult(String alo, String input, String outputPaht, HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = null;
        if (alo.equals("fim")) {
            String rs = JavaCallPython.runFimResultTopK(new String[]{input, outputPaht + "fim/"});
            rd = sc.getRequestDispatcher("/view/result/showFim.jsp");
            System.out.print(rs);
            request.setAttribute("imgsrc", rs);
            rd.forward(request, response);

        } else if (alo.equals("rule")) {
            String rs = JavaCallPython.runRuleResultTopK(new String[]{input, outputPaht + "rule/"});
            rd = sc.getRequestDispatcher("/view/result/showRule.jsp");
            request.setAttribute("imgsrc", rs);
            rd.forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            int taskInstanceId = Integer.parseInt(request.getParameter("tiid"));
            String sql = "SELECT tiresultpath,algorithmid FROM taskinstance where tiid=\"" + taskInstanceId + "\"";
            ResultSet rs = DBQuery.query(sql);
            String resultPath = "";
            int algorithm = 0;
            while (rs.next()) {
                resultPath = rs.getString(1);
                algorithm = rs.getInt(2);
            }
            System.out.println(resultPath);
            System.out.println(algorithm);

            String result = resultPath + "/result.txt";
            System.out.println(result);

            String sqlGetAlgClas = "SELECT algorithmtype FROM algorithm where algorithmid=\"" + algorithm + "\"";
            ResultSet rs2 = DBQuery.query(sqlGetAlgClas);
            String algoType = "";
            while (rs2.next()) {
                algoType = rs2.getString(1);
            }
            System.out.println(algoType);
            selectShowResult(algoType, result, PathConstant.IMAGEPATH, request, response);
//            selectShowResult("fim", "/Users/chengsiyuan/IdeaProjects/SPMF/output_fpgrowth.txt", "/usr/local/tomcat7/webapps/platform/public/images/result/fim/", request, response);
//            selectShowResult("rule", "/Users/chengsiyuan/IdeaProjects/SPMF/output_rulegrowth.txt", "/Users/chengsiyuan/", request, response);


//        } catch (SQLException e) {
//            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
