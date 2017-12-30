import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day23_1 {
    public static void main(String[] args) throws Exception {
        String line;
        String rules[][] = new String[3][32];
        String as[];
        int ruleCount = 0;
        int vars[] = new int[8];
        for(int i = 0; i < 8; i ++){
            vars[i] = 0;
        }
        int X;
        int Y;
        int curpos = 0;
        BufferedReader br = new BufferedReader(new FileReader
                ("/home/lance/AdventOfCode_Day23/Input/AdventOfCode_Day23_Input.txt"));
        while((line = br.readLine()) !=null){
            as = line.split(" ");
            for(int i = 0; i < 3; i ++){
                rules[i][ruleCount] = as[i];
            }
            ruleCount++;
        }
        int mulcount = 0;
        while(curpos >= 0 && curpos < ruleCount){
            if((int) rules[1][curpos].charAt(0) < 96){
                X = Integer.parseInt(rules[1][curpos]);
            } else {
                X = vars[(int) rules[1][curpos].charAt(0) - 97];
            }
            if((int) rules[2][curpos].charAt(0) < 96){
                Y = Integer.parseInt(rules[2][curpos]);
            } else {
                Y = vars[(int) rules[2][curpos].charAt(0) - 97];
            }
            System.out.println(curpos + " " + rules[0][curpos] + " " + rules[1][curpos] + " " + X + " "
                    +rules[2][curpos] + " " + Y);
            switch(rules[0][curpos]){
                case "set":
                    vars[(int) rules[1][curpos].charAt(0) - 97] = Y;
                    curpos ++;
                    break;
                case "sub":
                    vars[(int) rules[1][curpos].charAt(0) - 97] -= Y;
                    curpos ++;
                    break;
                case "mul":
                    vars[(int) rules[1][curpos].charAt(0) - 97] = vars[(int) rules[1][curpos].charAt(0) - 97] * Y;
                    curpos ++;
                    mulcount ++;
                    break;
                case "jnz":

                    if(X != 0){
                        curpos += Y;
                    } else {
                        curpos ++;
                    }
                    break;
            }
        }
        System.out.println(mulcount);
    }
}
