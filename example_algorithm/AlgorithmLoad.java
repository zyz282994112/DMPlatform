package model.algorithm.utils;

import com.google.common.collect.Lists;
import csy.util.Algorithm;
import org.apache.mahout.common.Pair;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AlgorithmLoad {

    public static int run(String aName, String input, String output, Map<String, String> configs) throws ClassNotFoundException, IllegalAccessException, InstantiationException, JDOMException, IOException {

        AlgorithmMap algorithmMap = new AlgorithmMap();
        Map<String, String> algoMap = algorithmMap.getAlgomap();
        Algorithm algo = (Algorithm) Class.forName(algoMap.get(aName)).newInstance();
        List<Pair<String, String>> paramList = null;
        List<String> param = Lists.newArrayList();

        paramList = XmlParser.paramParser(aName);

        for (Pair<String, String> arg : paramList) {
            String key = arg.getFirst();
            if (configs.containsKey(key)) {
                String value = configs.get(key);
                param.add(value);
            }
        }
        param.add(input);
        param.add(output);
        String[] args = (String[]) param.toArray(new String[0]);
        int ret = algo.iRunAlgorithm(args);
        return ret;

    }


}
