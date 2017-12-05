public class AdventOfCode_Day3 {
    public static void main(String[] args) throws Exception {
        int TargetVal = 312051;
        int StartX = 300;
        int StartY = 300;
        int CurrX = 300;
        int CurrY = 300;
        int sqsize = 1;
        int curval = 1;
        while(curval < TargetVal){
            for(int sides = 1; sides <=2; sides ++){
                for(int walk = 1; walk <=sqsize; walk ++) {
                    if ((sqsize & 1) == 0) {
                        if (sides == 1) {
                            CurrX = CurrX - 1;
                        } else {
                            CurrY = CurrY - 1;
                        }
                    } else {

                        if (sides == 1) {
                            CurrX = CurrX + 1;
                        } else {
                            CurrY = CurrY + 1;
                        }
                    }
                    curval++;
                    int xdist = Math.abs(CurrX - StartX);
                    int ydist = Math.abs(CurrY - StartY);
                    int ManDist = xdist + ydist;
                    if (curval == TargetVal) {
                        System.out.println(CurrX + " " + CurrY + " " + sqsize + " " + curval + " " + ManDist);
                    }
                }
            }
            sqsize ++;
        }


    }
    }
