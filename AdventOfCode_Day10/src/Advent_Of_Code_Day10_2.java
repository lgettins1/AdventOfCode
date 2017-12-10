import java.io.BufferedReader;
import java.io.FileReader;

public class Advent_Of_Code_Day10_2 {
    public static void main(String[] args) throws Exception {
        String line;
        int lengthCount;
        int circleList [] = new int[256];
        int skipDist;
        int curpos = 0;

        BufferedReader br = new BufferedReader(new FileReader
                ("/home/lance/AdventOfCode_Day10/Input/AdventOfCode_Day10_Input.txt"));
        line = br.readLine();
        lengthCount = (line.trim()).length();
        lengthCount += 5;
        int lengths[] = new int[lengthCount];
        for(int ql = 0; ql < lengthCount - 5; ql++) {
            char c = line.charAt(ql);
            lengths[ql] = (int) c;
        }

        lengths[lengthCount - 5] = 17;
        lengths[lengthCount - 4] = 31;
        lengths[lengthCount - 3] = 73;
        lengths[lengthCount - 2] = 47;
        lengths[lengthCount - 1] = 23;


        for(int ql2 = 0; ql2 <256; ql2 ++){
            circleList[ql2] = ql2;
        }
        // ok, we're done initializing stuff

        for(int outloop = 0; outloop < 64; outloop ++) {
            for (skipDist = 0; skipDist < lengthCount; skipDist++) {
                int cps[] = new int[lengths[skipDist]];
                for (int ql3 = 0; ql3 < lengths[skipDist]; ql3++) {
                    int cpos = curpos + ql3;
                    if (cpos > 255) {
                        cpos -= 256;
                    }
                    cps[ql3] = circleList[cpos];
                }
                for (int ql3 = 0; ql3 < lengths[skipDist]; ql3++) {
                    int cpos = curpos + ql3;
                    if (cpos > 255) {
                        cpos -= 256;
                    }
                    circleList[cpos] = cps[lengths[skipDist] - (ql3 + 1)];
                }
                curpos += lengths[skipDist] + skipDist + (outloop * lengthCount);
                while (curpos >= 256) {
                    curpos -= 256;
                }
            }
        }
        String hexhash = "";
        String x;
        int hash;

        for(int ol = 0; ol < 16; ol ++) {
            hash = circleList[ol * 16];
            for(int il = 1; il < 16; il ++){
                hash = hash ^ circleList[(ol * 16) + il];
            }
            x = Integer.toHexString(hash);
            if (x.length() < 2){
                x = "0" + x;
            }
            hexhash += x;
        }
        System.out.println(hexhash);
    }
}
