public class AdventOfCode_Day17_2 {
    public static void main(String[] args){
        int puzzleInput = 394;
        int curpos = 0;
        int answer = 0;
        for(int insertions = 1; insertions <= 50000000; insertions ++) {
            for (int steps = 0; steps < puzzleInput; steps++) {
                curpos++;
                if (curpos >= insertions) {
                    curpos = 0;
                }
            }
            curpos ++;
            if(curpos == 1) {
                answer = insertions;
            }
        }
        System.out.println("The answer is " + answer);
    }
}
