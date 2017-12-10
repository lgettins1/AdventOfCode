import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class AdventOfCode_Day9_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream
                ("/home/lance/AdventOfCode_Day9/Input/AdventOfCode_Day9_Input.txt"), Charset.forName("UTF-8")));
        int c;
        int intrash = 0;
        int grpDepth = 0;
        int score = 0;

        while ((c = br.read()) != -1) {
            char readchar = ( char ) c;
                if(readchar == '!'){
                    c = br.read();
                }
                if(intrash == 1) {
                    if (readchar == '>') {
                        intrash = 0;
                    }
                } else {
                        if(readchar == '<'){
                            intrash = 1;
                        }
                        if(readchar == '{'){
                            grpDepth ++;
                        }
                        if(readchar == '}'){
                            score += grpDepth;
                            grpDepth --;
                        }
                }
        }
        System.out.println(score);
    }
}
