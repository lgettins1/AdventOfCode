import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class AdventOfCode_Day2_2 {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new FileReader(
                    "c:/Users/lance/AdventOfCode/AdventOfCode_Day2/input/AdventOfCode_Day2_input.txt"));
            String line = null;
            String[] wordarray;
            int[] numberArray;
            int checksum = 0;
            int difference = 0;
            int numerator = 0;
            int denominator = 0;
            numberArray = new int[16];

            while ((line = br.readLine()) != null) {
                wordarray = line.split("\t");

                for (int ql = 0; ql < 16; ql++) {
                    numberArray[ql] = Integer.parseInt(wordarray[ql]);
                }
                Arrays.sort(numberArray);
                for( numerator = 15; numerator >=0; numerator --) {
                    for( denominator = numerator - 1; denominator >= 0 ; denominator -- ){
                        if((numberArray[numerator] % numberArray [denominator]) == 0  ){
                            difference = numberArray[numerator] / numberArray[denominator];
                            System.out.println(numberArray[numerator] + " " + numberArray[denominator]);
                            checksum = checksum + difference;
                        }
                }
            }
            System.out.println(" Checksum is " + checksum);
        }
    }
}
