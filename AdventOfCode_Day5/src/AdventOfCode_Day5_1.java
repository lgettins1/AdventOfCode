import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day5_1 {
    public static void main(String[] args) throws Exception {

        String thisLine;
        int mazeArray[];
        mazeArray = new int [1100];
        int mazeEnd = 0;
        int sp = 0;
        int stepCount = 0;
        int readVal;

        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("/home/lance/AdventOfCode_Day5/Input/AdventOfCode_Day5_Input.txt"));
            while ((thisLine = br.readLine()) != null) {
                   mazeArray[mazeEnd] = Integer.valueOf(thisLine);
                   mazeEnd++;
            }
            mazeEnd --;

        } catch (Exception e) {
            e.printStackTrace();
        }
        while( sp >= 0 && sp <= mazeEnd){
            readVal = mazeArray[sp];
            mazeArray[sp] ++;
            sp = sp + readVal;

            stepCount ++;
        }
        System.out.println("The number of steps is " + stepCount);
    }
}
