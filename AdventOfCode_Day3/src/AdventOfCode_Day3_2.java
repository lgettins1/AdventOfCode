public class AdventOfCode_Day3_2 {
    public static void main(String[] args) throws Exception {
        int [][] grid = new int[600][600];
        int TargetVal = 312051;
        int StartX = 300;
        int StartY = 300;
        int CurrX = 300;
        int CurrY = 300;
        int sqsize = 1;
        int curval = 1;
       for(int ql = 1; ql < 600; ql ++){
            for(int ql2 =1; ql2 < 600; ql2 ++){
                grid[ql][ql2] = 0;
            }
        }
        grid[StartX][StartY] = 1;
        while(curval < TargetVal){
            for(int sides = 1; sides <=2; sides ++){
                for(int walk = 1; walk <=sqsize; walk ++) {
                    curval = 0;
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
                    for(int ql = 0; ql < 3; ql ++) {
                        for (int ql2 = 0; ql2 < 3; ql2++) {
                            curval = curval + grid[CurrX - 1 + ql][CurrY - 1 + ql2];
                        }
                    }
                    grid[CurrX][CurrY] = curval;
                    if(curval > TargetVal) {
                        System.out.println(CurrX + " " + CurrY + " " + sqsize + " " + curval);
                    }
                }
            }
            sqsize ++;
                    }


    }
}
