package model.algorithm.utils;

import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: csy
 */

public interface Algorithm {

    public String sAlgorithmDescription(Integer choiceTag);

    public Map<String, String> sLoadParams();

    public Integer iRunAlgorithm(String[] args);

    public Integer iAlgorithmInitialize();

    public Integer iReadDataBase(String url, String uname, String pwd, String driver);

    public Integer iReadDataFille(String inputPath);

    public Integer iControlJob(String sJobControl);

    public Integer iQueryJob(String sQueryJob);

    public Integer iResultCollect(String filePath);
}
