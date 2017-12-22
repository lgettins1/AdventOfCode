import java.io.BufferedReader;
import java.io.FileReader;

public class AdentOfCode_Day19_1 {

    public static void main(String[] args) throws Exception {
        String line = null;
        String maze[] = new String[202];
        int lineCount = 0;

        BufferedReader br = new BufferedReader(new FileReader
                ("/Users/lance/AdventOfCode/AdventOfCode_Day19/Input/AdventOfCode_Day19_Input.txt"));
        while((line = br.readLine()) != null) {
            maze[lineCount] = line;
            lineCount ++;
        }
        char nextchar;
        int curX = 0;
        int curY = 0;
        int XD = 0;
        int YD = 1;
        String word ="";
        for(int ql = 0; ql < maze[0].length(); ql ++){
            if(maze[0].charAt(ql) == '|'){
                curX = ql;
            }
        }
        int exit = 0;

        while(exit == 0){
            curX += XD;
            curY += YD;
            nextchar = maze[curY].charAt(curX);
            System.out.println(curX + "," + curY + " " + nextchar);

            switch(nextchar){
            case '|':
                break;

            case '-':
                break;

            case ' ':
                System.out.println(word);
                exit = 1;
            case '+':
                int XC = XD * XD;
                int YC = YD * YD;
                char c1 = maze[curY + XC].charAt(curX + YC);
                if(c1 == ' '){
                    XD = -YC;
                    YD = - XC;
                } else {
                    XD = YC;
                    YD = XC;
                }
                break;

            default:
                word += nextchar;
                System.out.println(word);

                break;
        }

        }
    }
}
