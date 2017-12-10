import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day10_1 {
    public static void main(String[] args) throws Exception {
        String[] sa;
        String line;
        int lengthCount;
        int circleList [] = new int[256];
        int skipDist;
        int curpos = 0;

        BufferedReader br = new BufferedReader(new FileReader
                    ("/home/lance/AdventOfCode_Day10/Input/AdventOfCode_Day10_Input.txt"));
            line = br.readLine();
            sa = line.split(",");
            lengthCount = sa.length;
            int lengths[] = new int[lengthCount];
            for(int ql = 0; ql < lengthCount; ql++) {
                lengths[ql] = Integer.parseInt(sa[ql]);
            }
            for(int ql2 = 0; ql2 <256; ql2 ++){
                circleList[ql2] = ql2;
            }
            for(skipDist = 0; skipDist < lengthCount; skipDist ++){
                System.out.println(lengths[skipDist] + " " + curpos);
                int cps[] = new int[lengths[skipDist]];
                for(int ql3 = 0; ql3 < lengths[skipDist]; ql3 ++){
                    int cpos = curpos + ql3;
                    if(cpos > 255){
                        cpos -= 256;
                    }
                    cps[ql3] = circleList[cpos];
                }
                for(int ql3 = 0; ql3 < lengths[skipDist]; ql3 ++){
                    int cpos = curpos + ql3;
                    if(cpos > 255){
                        cpos -= 256;
                    }
                    circleList[cpos] = cps[lengths[skipDist] - (ql3 + 1)];
                }
                curpos += lengths[skipDist] + skipDist;
                while (curpos >= 256){
                    curpos -= 256;
                }

            }
            int ans = circleList[0] * circleList[1];
            System.out.println(ans);

    }
}
