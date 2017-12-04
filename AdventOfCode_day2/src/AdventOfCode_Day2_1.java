import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day2_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(
                "c:/Users/lance/AdventOfCode/AdventOfCode_Day2/input/AdventOfCode_Day2_input.txt"));
        String line = null;
        String[] wordarray;
        int checksum = 0;
        int minval = 0;
        int maxval = 0;

        while ((line = br.readLine()) != null) {
            wordarray = line.split("\t");
            minval = Integer.parseInt(wordarray[0]);
            maxval = Integer.parseInt(wordarray[0]);
            for (int ql = 0; ql < 16; ql++) {
                if (Integer.parseInt(wordarray[ql]) < minval) {
                    minval = Integer.parseInt(wordarray[ql]);
                }
                if (Integer.parseInt(wordarray[ql]) > maxval) {
                    maxval = Integer.parseInt(wordarray[ql]);
                }
            }
            checksum = checksum + maxval - minval;
        }
        System.out.println(" Checksum is " + checksum);
    }
}