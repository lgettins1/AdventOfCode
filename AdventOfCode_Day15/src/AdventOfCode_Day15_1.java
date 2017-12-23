public class AdventOfCode_Day15_1 {
    public static void main(String[] args){
        long genA = 722;
        long genB = 354;
        int genAfactor = 16807;
        int genBfactor = 48271;
        int divisor = 2147483647;
        int score = 0;
        for(int ol = 0; ol < 40000000; ol ++) {
            genA = (genA * genAfactor) % divisor;
            genB = (genB * genBfactor) % divisor;
            String binA = getBinString(genA);
            String binB = getBinString(genB);
            if (binA.equals(binB)) {
               score++;
            }
        }
        System.out.println(score);
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
