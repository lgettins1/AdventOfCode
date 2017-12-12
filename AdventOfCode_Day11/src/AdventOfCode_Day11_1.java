import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day11_1 {
    public static void main(String[] args) throws Exception {
        String line;
        String sa[];
        int X = 0;
        int Y = 0;
        int steps = 0;
        int nX;
        int nY;
        int maxSteps = 0;


        BufferedReader br = new BufferedReader(new FileReader
                ("/home/lance/AdventOfCode_Day11/Input/AdventOfCode_Day11_Input.txt"));
        line = br.readLine();

        sa = line.split(",");
        for(int ql = 0; ql < sa.length; ql ++){
            switch(sa[ql]){
                case "n":
                    Y -= 2;
                    break;
                case "s":
                    Y += 2;
                    break;
                case "ne":
                    X += 1;
                    Y -= 1;
                    break;
                case "se":
                    X += 1;
                    Y += 1;
                    break;
                case "nw":
                    X -= 1;
                    Y -= 1;
                    break;
                case "sw":
                    X -= 1;
                    Y += 1;
                    break;
            }
            nX = Math.abs(X);
            nY = Math.abs(Y);
            if(nX > nY) {
                steps = nX;
            } else {
                steps = (nX + nY) /2;
            }
            if(steps > maxSteps){
                maxSteps = steps;
            }

        }

        System.out.println(steps + " steps");
        System.out.println(maxSteps + " is the furthest distance");

    }
}
