package model.algorithm.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chengsiyuan
 * Date: 14-3-13
 * Time: 下午2:38
 * To change this template use File | Settings | File Templates.
 */
public class AlgorithmMap {

    public Map<String, String> getAlgomap() {
        return algomap;
    }

    private Map<String, String> algomap = null;

    public AlgorithmMap() {
        algomap = new HashMap<String, String>();
        algomap.put("prefixspan", "csy.prefixspan.PrefixSpan");
        algomap.put("fpgrowth", "csy.fpgrowth.FPGrowth");
        algomap.put("clasp", "csy.clasp.ClaSP");
        algomap.put("apriori", "csy.apriori.Apriori");
        algomap.put("charm", "csy.charm.Charm");
        algomap.put("trulegrowth", "csy.trulegrowth.TRuleGrowth");
        algomap.put("rulegrowth", "csy.rulegrowth.RuleGrowth");
        algomap.put("assorules", "csy.assorules.AssoRules");
        algomap.put("closedassorules", "csy.assorules.ClosedAssoRules");
    }


}
