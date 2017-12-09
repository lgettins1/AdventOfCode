import java.io.BufferedReader;
import java.io.FileReader;


public class AdventOfCode_Day7_2 {
    static int lineCount = 0;
    static String[][] branchArray = new String[10][1200];
    static int weight[][] = new int[2][1200];

    public static void main(String[] args) throws Exception {
        String[] sa = new String[10];
        String line;
        int branchCount;


        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("/home/lance/AdventOfCode_Day7/input/AdventOfCode_Day7_input.txt"));
            while ((line = br.readLine()) != null) {
                sa = line.split("\\s+");
                branchCount = sa.length;
                branchArray[0][lineCount] = sa[0];
                if (branchCount > 2) {
                    branchArray[branchCount - 3][lineCount] = sa[branchCount - 1];

                    for (int ql = 3; ql < branchCount - 1; ql++) {
                        branchArray[ql - 2][lineCount] = sa[ql].substring(0, sa[ql].length() - 1);
                    }
                    weight[0][lineCount] = branchCount - 3;
                } else {
                    weight[0][lineCount] = 0;
                }
                weight[1][lineCount] = Integer.parseInt(sa[1].substring(1, sa[1].length() - 1));

                lineCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String bp = "";
        String cs;
        String checkingString;
        for (int a = 0; a < lineCount; a++) {
            cs = branchArray[0][a];
            int found = 0;
            for (int il = 0; il < lineCount; il++) {
                if (weight[0][il] > 0) {
                    for (int b = 1; b <= weight[0][il]; b++) {
                        checkingString = branchArray[b][il];
                        if (checkingString.equals(cs)) {
                            found = 1;
                        }
                    }
                }
            }
            if (found == 0) {
                bp = cs;
            }
        }
        int f = returnWeight(bp);


    }
    public static int returnWeight(String baseName){
        int treematch = 0;

            for (int sc = 0; sc < lineCount; sc++) {
                if (branchArray[0][sc].equals(baseName)) {
                    treematch = sc;
                }
            }
                int returnweight = weight[1][treematch];
                if(weight[0][treematch] > 0){
                    int branchWeights[] = new int [10];
                    int branchWt = weight[1][treematch];

                    for(int branches = 1; branches <= weight[0][treematch]; branches ++){
                        branchWeights[branches] = returnWeight(branchArray[branches][treematch]);
                        branchWt += branchWeights[branches];
                    }
                    int sum = 0;
                    int foundbranch = 0;
                    for(int i: branchWeights)
                        sum +=i;
                    if((sum/ weight[0][treematch]) != branchWeights[1]){
                        int tv;
                        if(branchWeights[1] == branchWeights[2]){
                            tv = branchWeights[1];
                        } else {
                            if (branchWeights[1] == branchWeights[3]) {
                                tv = branchWeights[1];
                            } else {
                                tv = branchWeights[2];
                            }
                        }
                        for(int ql2 = 1; ql2 <= weight[0][treematch]; ql2 ++){
                            if (branchWeights[ql2] != tv) {
                                for(int ql3 = 0; ql3 < lineCount; ql3 ++){
                                    if (branchArray[0][ql3] .equals(branchArray[ql2][treematch])){
                                         foundbranch = ql3;
                                    }
                                }
                                System.out.println(baseName + " " + branchWeights[ql2] + " " + ql2 + " " +
                                        tv + " " + branchArray[ql2][treematch] + " "
                                        + (weight[1][foundbranch] + tv - branchWeights[ql2]));
                            }
                        }
                    }
                    returnweight = branchWt;

            }

        return returnweight;
    }
}