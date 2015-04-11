package model.result;

import model.algorithm.utils.PathConstant;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaCallPython {

    public static String runFimResultTopK(String[] args) throws IOException, InterruptedException {
        String path = PathConstant.SCRIPTPATH + "FimResultShow.py";
        String python = "python";
        String input = args[0];
        String output = args[1];
        String[] runparam = new String[]{python, path, input, output};

        String run = StringUtils.join(runparam, " ");
//        run = python + " " + path + " \\\n" + "  " + input + " " + output;

        System.out.println(run);

        Process pr = Runtime.getRuntime().exec(run.trim());

        BufferedReader in = new BufferedReader(new
                InputStreamReader(pr.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            break;
        }
        in.close();
        pr.waitFor();
        return line;
    }

    public static String runRuleResultTopK(String[] args) throws IOException, InterruptedException {
        String path = PathConstant.SCRIPTPATH + "RuleResultShow.py";
        String python = "python";
        String input = args[0];
        String output = args[1];

        String[] runparam = new String[]{python, path, input, output};
        String run = StringUtils.join(runparam, " ");
        Process pr = Runtime.getRuntime().exec(run);

        BufferedReader in = new BufferedReader(new
                InputStreamReader(pr.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            break;
        }
        in.close();
        pr.waitFor();
        return line;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        runFimResultTopK(new String[]{"/usr/local/tomcat7/webapps/platform/TaskM/10/Task/55/1/result.txt", "/usr/local/tomcat7/webapps/platform/web/public/images/result/fim/"});
//        runRuleResultTopK(new String[]{"/Users/chengsiyuan/IdeaProjects/SPMF/output_rulegrowth.txt"});
    }
}
