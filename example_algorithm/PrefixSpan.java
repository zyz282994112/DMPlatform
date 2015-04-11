package csy.prefixspan;

import ca.pfv.spmf.algorithms.sequentialpatterns.BIDE_and_prefixspan_with_strings.AlgoPrefixSpan_with_Strings;
import ca.pfv.spmf.algorithms.sequentialpatterns.BIDE_and_prefixspan_with_strings.SequentialPattern;
import ca.pfv.spmf.algorithms.sequentialpatterns.BIDE_and_prefixspan_with_strings.SequentialPatterns;
import ca.pfv.spmf.input.sequence_database_list_strings.SequenceDatabase;
import csy.util.Algorithm;

import java.io.IOException;
import java.util.*;

/**
 * User: chengsiyuan
 * Date: 14-3-7
 */
public class PrefixSpan implements Algorithm {
    private double minsupport;
    private String inputPath;
    private String outputPath;
    private int databaseSize;
    private String seq = "::::";

    private AlgoPrefixSpan_with_Strings psAlgo = null;
    private SequenceDatabase sequenceDatabase = null;
    private SequentialPatterns patterns = null;

    public PrefixSpan(){
        this.psAlgo = new AlgoPrefixSpan_with_Strings();
        this.sequenceDatabase = new SequenceDatabase();

    }


    public PrefixSpan(double minsupport, String inputPath, String outputPath) {
        this.minsupport = minsupport;
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.psAlgo = new AlgoPrefixSpan_with_Strings();
        this.sequenceDatabase = new SequenceDatabase();
    }

    public SequentialPatterns getPatterns() {
        return this.patterns;
    }

    public List<String> getTopkPatterns(int k) {
        Map<String, Double> itemset_sup = new HashMap<String, Double>();
        for (List<SequentialPattern> pattern : this.patterns.getLevels()) {
            for (SequentialPattern itemset : pattern) {
                int sup = itemset.getAbsoluteSupport();
                String itemStr = itemset.itemsetsToString();
                itemset_sup.put(itemStr, (sup * 1.0) / databaseSize);
            }
        }
        List<Map.Entry<String, Double>> tmp = new ArrayList<Map.Entry<String, Double>>(itemset_sup.entrySet());
        Collections.sort(tmp, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return (o2.getValue() - o1.getValue()) > 0 ? 1 : -1;
            }
        });

        int index = 0;
        if (k == 0 || k > tmp.size())
            index = itemset_sup.size();
        else
            index = k;

        List<Map.Entry<String, Double>> topK = tmp.subList(0, index);
        List<String> rs = new ArrayList<String>();
        for (Map.Entry<String, Double> e : topK) {
            rs.add(e.getKey() + seq + e.getValue());
        }

        return rs;

    }

    @Override
    public String sAlgorithmDescription(Integer choiceTag) {
        return null;
    }

    @Override
    public Map<String, String> sLoadParams() {
        return null;
    }

    @Override
    public Integer iRunAlgorithm(String[] args) {
        try {
            this.minsupport = Double.parseDouble(args[0]);
            this.inputPath  = args[1];
            this.outputPath = args[2];
            iReadDataFille(this.inputPath);
            this.patterns = psAlgo.runAlgorithm(this.sequenceDatabase, this.outputPath, this.minsupport);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer iAlgorithmInitialize() {
        return null;
    }

    @Override
    public Integer iReadDataBase(String url, String uname, String pwd, String driver) {
        return 0;
    }

    @Override
    public Integer iReadDataFille(String inputPath) {
        try {
            sequenceDatabase.loadFile(inputPath);
            sequenceDatabase.printDatabase();
            databaseSize = sequenceDatabase.size();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public Integer iControlJob(String sJobControl) {
        return null;
    }

    @Override
    public Integer iQueryJob(String sQueryJob) {
        return null;
    }

    @Override
    public Integer iResultCollect(String filePath) {
        return null;
    }

    public static void main(String[] args) {
        String[] arg = new String[]{"0.2","/Users/chengsiyuan/IdeaProjects/SPMF/src/ca/pfv/spmf/test/contextPrefixSpanStrings.txt","/Users/chengsiyuan/IdeaProjects/SPMF/output_prefix.txt"};
        PrefixSpan ps = new PrefixSpan();
        ps.iRunAlgorithm(arg);



    }
}
