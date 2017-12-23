public class AdventOfCode_Day15_2 {
    public static void main(String[] args) {
        long genA = 722;
        long genB = 354;
        int genAfactor = 16807;
        int genBfactor = 48271;
        int divisor = 2147483647;
        int score = 0;
        int acount = 0;
        int bcount = 0;
        String bps[][] = new String[2][5000000];
        int paircount = 0;

        while(paircount <5000000) {
            genA = (genA * genAfactor) % divisor;
            String binA = "";
            String binB = "";
            if(genA % 4 == 0) {
                binA = getBinString(genA);
                if(acount < 5000000){
                    bps[0][acount] = binA;
                }
                acount ++;
            }

            genB = (genB * genBfactor) % divisor;
            if(genB % 8 == 0){
                binB = getBinString(genB);
                if (bcount < 5000000) {
                    bps[1][bcount] = binB;
                }
                bcount++;
            }
            if(bcount < acount){
                paircount = bcount;
            } else {
                paircount = acount;
            }
        }

        for(int i = 0; i < 5000000; i ++){
            if(bps[0][i].equals(bps[1][i])){
                score++;
            }
        }
        System.out.println("The score is " + score);
    }


    private static String getBinString(long  a){
        String binA = Integer.toBinaryString((int) a);
        int b = binA.length();
        if(b < 16){
            for(int i = 1; i <= (16 - b); i++){
                binA = "0" + binA ;
            }
        }
        binA = binA.substring(binA.length() - 16);
        return binA;
    }
}
