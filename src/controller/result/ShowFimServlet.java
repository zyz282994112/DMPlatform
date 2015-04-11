package controller.result;

import model.algorithm.utils.ServletConstants;
import model.result.JavaCallPython;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: chengsiyuan
 * Date: 14-3-18
 * Time: 下午6:18
 * To change this template use File | Settings | File Templates.
 */
public class ShowFimServlet extends HttpServlet {

    public String getInputPath(String input) {
        return "/Users/chengsiyuan/IdeaProjects/SPMF/output_fpgrowth.txt";

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            request.setCharacterEncoding(ServletConstants.CHN_ENCODING);
            String input = request.getParameter("inputfile");
            input = getInputPath(input);
            String output = JavaCallPython.runFimResultTopK(new String[]{input});
            response.setHeader("content-type", "text/html;charset=UTF-8");
            response.getWriter().println(output.trim());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
