import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_day13_1 {
    public static int lineCount = 0;
    public static int layers[][] = new int[4][45];
    public static void main(String[] args) {
        String[] sa;
        String line;
        int layerCount = 0;
        int maxRange = 0;
        int severity;

        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("/home/lance/AdventOfCode_Day13/Input/AdventOfCode_Day13_Input.txt"));
            while ((line = br.readLine()) != null) {
                sa = line.split(":");
                layers[0][lineCount] = Integer.parseInt(sa[0]);
                if(layers[0][lineCount] > layerCount){
                    layerCount = layers[0][lineCount];
                }
                layers[1][lineCount] = Integer.parseInt(sa[1].trim());
                if(layers[1][lineCount] > maxRange){
                    maxRange = layers[1][lineCount];
                }
                lineCount++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        int delay = 9;
        int maxSeverity = 2000;
        while(maxSeverity > 0 ) {
            int passZero = 0;
            for(int a = 0; a < 45; a ++){
                for(int b = 2; b < 4; b ++){
                    layers[b][a] = 1;
                }
            }
            severity = 0;
            if(delay > 0){
                for(int ql = 1; ql <=delay; ql ++){
                    advanceScanners();
                }
            }
            for (int move = 0; move <= layerCount; move++) {

                //advance and see if we step on a scanner
                for (int scan = 0; scan < lineCount; scan++) {
                     if (move == layers[0][scan]) {
                        if (layers[2][scan] == 1) {
                             if(scan == 0){
                                 passZero = 1;
                             }
                             severity += (layers[0][scan] * layers[1][scan]);
                        }
                    }
                }
                // scanners advance
                advanceScanners();
            }
            if (maxSeverity > severity){
                if(passZero == 0) {
                    maxSeverity = severity;
                }
            }
            delay ++;
        }
        System.out.println((delay - 1) + " " +  " " + maxSeverity);

    }


    public static void advanceScanners(){
        for (int ql = 0; ql < lineCount; ql++) {
            if (layers[2][ql] == 1) {
                layers[3][ql] = 1;
            }
            if (layers[2][ql] == layers[1][ql]) {
                layers[3][ql] = -1;
            }
            layers[2][ql] += layers[3][ql];
        }
    }

}