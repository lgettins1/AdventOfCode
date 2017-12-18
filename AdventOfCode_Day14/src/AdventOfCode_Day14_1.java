public class AdventOfCode_Day14_1 {
    public static void main(String [] args){
    String line;
    int lengthCount;
    int circleList [] = new int[256];
    int skipDist;
    int usedSquares = 0;
    String lineb = "jzgqcdpd-";
    for(int rowloop = 0; rowloop <= 127; rowloop++) {
        String rn = Integer.toString(rowloop);
        line = lineb + rn.trim();
        int curpos = 0;
        lengthCount = (line.trim()).length() + 5;

        int lengths[] = new int[lengthCount];
        for (int ql = 0; ql < lengthCount - 5; ql++) {
            char c = line.charAt(ql);
            lengths[ql] = (int) c;
        }
        lengths[lengthCount - 5] = 17;
        lengths[lengthCount - 4] = 31;
        lengths[lengthCount - 3] = 73;
        lengths[lengthCount - 2] = 47;
        lengths[lengthCount - 1] = 23;

        for (int ql2 = 0; ql2 < 256; ql2++) {
            circleList[ql2] = ql2;
        }
        // ok, we're done initializing stuff

        for (int outloop = 0; outloop < 64; outloop++) {
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

        String x;
        int hash;

        for (int ol = 0; ol < 16; ol++) {
            hash = circleList[ol * 16];
            for (int il = 1; il < 16; il++) {
                hash = hash ^ circleList[(ol * 16) + il];
            }
            x = Integer.toHexString(hash);
            if (x.length() < 2) {
                x = "0" + x;
            }
            String ctb = hexToBin(x);
            for(int pb = 0; pb <8; pb++){
               if(ctb.charAt(pb) == '1'){
                   usedSquares ++;
               }
            }
            System.out.println(line + " " + ctb + " " + usedSquares);

        }
    }
}
    private static String hexToBin (String hex){
        int i = Integer.parseInt(hex, 16);
        int il = hex.length();
        int bl = il * 4;
        String bin = Integer.toBinaryString(i);
        if(bin.length() < bl){
            String s = "";
            for(int ql = 1; ql <= bl - bin.length(); ql ++){
                s = s + "0";
            }
            bin = s + bin;
        }
        return bin;

    }
}
