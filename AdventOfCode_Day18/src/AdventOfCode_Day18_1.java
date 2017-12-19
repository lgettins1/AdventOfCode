import java.io.BufferedReader;
import java.io.FileReader;


public class AdventOfCode_Day18_1 {
    public static String varArray[] = new String [30];
    public static long varVals[] = new long [30];
    public static int varCount = 0;


    public static void main(String[] args) {
        String[] sa;
        String line;
        int lineCount = 0;
        int fields;
        long oper;
        long lastFreq = 0;
        int exitCrit = 0;
        String programArray[][] = new String [3][41];
        int curpos = 0;
        int vf;
        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("/home/lance/AdventOfCode_Day18/Input/AdventOfCode_Day18_Input.txt"));
            while ((line = br.readLine()) != null) {
                sa = line.split("\\s+");
                fields = sa.length;
                for(int rp = 0; rp < fields; rp ++) {
                    programArray[rp][lineCount] = sa[rp];
                }
                lineCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(exitCrit == 0){
            String command = programArray[0][curpos];
            vf = checkVar(programArray[1][curpos]);


            switch(command){
                case "set":
                    oper = getVal(programArray[2][curpos]);
                    varVals[vf] = oper;
                    curpos ++;
                    break;


                case "mul":
                    oper = getVal(programArray[2][curpos]);
                    varVals[vf] = varVals[vf] * oper;
                    curpos ++;
                    break;


                case "jgz":
                    oper = getVal(programArray[2][curpos]);
                    if(varVals[vf] > 0){
                        curpos += oper;
                    } else {
                        curpos ++;
                    }
                    break;


                case "add":
                    oper = getVal(programArray[2][curpos]);
                    varVals[vf] = varVals[vf] + oper;
                    curpos ++;
                    break;


                case "mod":
                    oper = getVal(programArray[2][curpos]);
                    varVals[vf] = varVals[vf] % oper;
                    curpos ++;
                    break;


                case "snd":
                    lastFreq = varVals[vf];
                    curpos ++;
                    break;


                case "rcv":
                    if(varVals[vf] > 0){
                        System.out.println("Last Freq is " + lastFreq );
                        exitCrit = 1;
                    }
                    curpos ++;

                    break;
            }

            if((curpos < 0) | (curpos > lineCount - 1)){
                System.out.println(" break " + curpos);
            }

        }
    }
    public static int checkVar(String vbl){
        int vf1 = 0;
        if(varCount > 0){
            for(int ql = 1; ql <= varCount; ql ++){
                if(vbl.equals(varArray[ql])){
                    vf1 = ql;
                }
            }
        }
        if(vf1 == 0){
            varCount ++;
            vf1 = varCount;
            varArray[vf1] = vbl;
            varVals[vf1] = 0;
        }
        return vf1;
    }
    public static long getVal(String vbl){
        long vf1 = 0;
        if( (int) (vbl.trim()).charAt(0)  > 95){
            for(int ql = 1; ql <= varCount; ql++){
                if(vbl.equals(varArray[ql])){
                    vf1 = varVals[ql];
                }
            }
        } else {
            vf1  = (long) Integer.parseInt(vbl);
        }
        return vf1;
    }
}
