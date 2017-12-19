public class AdventOfCode_Day17_1 {
    public static void main(String[] args){
        int puzzleInput = 394;
        int spinlock[] = new int[2019];
        spinlock[0] = 0;
        int curpos = 0;
        int answer = 0;
        for(int insertions = 1; insertions <= 2017; insertions ++) {
            for (int steps = 0; steps < puzzleInput; steps++) {
                curpos++;
                if (curpos >= insertions) {
                    curpos = 0;
                }
            }
            if (curpos + 1 < insertions) {
                for (int sb = insertions; sb > curpos; sb--) {
                    spinlock[sb] = spinlock [ sb-1];
                }
                answer = spinlock[curpos + 2];
            }
            curpos ++;
            spinlock[curpos] = insertions;

        }
        System.out.println("The answer is " + answer);
    }
}
