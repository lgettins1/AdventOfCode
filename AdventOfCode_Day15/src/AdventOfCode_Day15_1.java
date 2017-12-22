public class AdventOfCode_Day15_1 {
    public static void main(String[] args) throws Exception {
        int genA = 722;
        int genB = 354;
        int genAfactor = 16807;
        int genBfactor = 48271;
        int divisor = 2147483647;

        genA = (genA * genAfactor) % divisor;
        genB = (genB * genBfactor) % divisor;



    }
}
