import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day7_1 {
    public static void main(String[] args) throws Exception {
        String[] sa = new String[10];
        String line;
        int branchCount;
        int lineCount = 0;
        String[][] branchArray = new String[10][1200];
        int weight [][] = new int[2][1200];


        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("/home/lance/AdventOfCode_Day7/input/AdventOfCode_Day7_input.txt"));
            while((line = br.readLine()) != null) {
                sa = line.split("\\s+");
                branchCount = sa.length;
                branchArray[0][lineCount] = sa[0];
                if(branchCount > 2) {
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
        String bp ="";
        String cs;
        String checkingString;
        for(int a = 0; a < lineCount; a++) {
            cs = branchArray[0][a];
            int found = 0;
            for (int il = 0; il < lineCount; il++) {
                if(weight[0][il] > 0) {
                    for (int b = 1; b <= weight[0][il]; b++) {
                        checkingString = branchArray[b][il];
                        if (checkingString.equals(cs)) {
                            found = 1;
                        }
                    }
                }
            }
            if(found == 0){
                if(bp != ""){
                    System.out.println("!!!" + bp);
                }
                bp = cs;
            }
        }
        System.out.println(bp);
    }
}
