import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_dday18_2 {

        public static String varArray[] = new String [30];
        public static long varVals[][] = new long [30][2];
        public static int varCount;


        public static void main(String[] args) {
            String[] sa;
            String line;
            int lineCount = 0;
            int fields;
            long oper;
            int exitCrit = 0;
            String programArray[][] = new String [3][41];
            int curpos[] = new int [2];
            int vf;
            int qdepth[] = new int [2];
            long queue[][] = new long[200][2];
            int deadlock[] = new int [2];
            int p1send = 0;
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
            for(int initloop = 0; initloop <= 1; initloop++) {
                varCount = 1;
                varArray[1] = "p";
                varVals[1][initloop] = initloop;
                curpos[initloop] = 0;
                qdepth[initloop] = 0;
                deadlock[initloop] = 0;
            }
            while(exitCrit == 0){
                for(int mloop = 0; mloop <=1; mloop ++) {
                    String command = programArray[0][curpos[mloop]];
                    switch (command) {
                        case "set":
                            vf = checkVar(programArray[1][curpos[mloop]]);
                            oper = getVal(programArray[2][curpos[mloop]], mloop);
                            varVals[vf][mloop] = oper;
                            curpos[mloop]++;
                            break;


                        case "mul":
                            vf = checkVar(programArray[1][curpos[mloop]]);
                            oper = getVal(programArray[2][curpos[mloop]], mloop);
                            varVals[vf][mloop] = varVals[vf][mloop] * oper;
                            curpos[mloop]++;
                            break;


                        case "jgz":
                            int ck = (int) getVal(programArray[1][curpos[mloop]], mloop);
                            oper = getVal(programArray[2][curpos[mloop]], mloop);
                            if (ck > 0) {
                                curpos[mloop] += oper;
                            } else {
                                curpos[mloop]++;
                            }
                            break;


                        case "add":
                            vf = checkVar(programArray[1][curpos[mloop]]);
                            oper = getVal(programArray[2][curpos[mloop]], mloop);
                            varVals[vf][mloop] = varVals[vf][mloop] + oper;
                            curpos[mloop]++;
                            break;


                        case "mod":
                            vf = checkVar(programArray[1][curpos[mloop]]);
                            oper = getVal(programArray[2][curpos[mloop]], mloop);
                            varVals[vf][mloop] = varVals[vf][mloop] % oper;
                            curpos[mloop]++;
                            break;


                        case "snd":
                            oper = getVal(programArray[1][curpos[mloop]], mloop);
                            qdepth[1 - mloop]++;
                            queue[qdepth[1 - mloop]][1 - mloop] = oper;
                            if (mloop == 1) {
                                p1send++;
                            }
                            curpos[mloop]++;
                            break;


                        case "rcv":
                            vf = checkVar(programArray[1][curpos[mloop]]);
                            if (qdepth[mloop] == 0) {
                                deadlock[mloop] = 1;
                            } else {

                                varVals[vf][mloop] = queue[1][mloop];
                                if (qdepth[mloop] > 1) {
                                    for (int ql = 1; ql < qdepth[mloop]; ql++) {
                                        queue[ql][mloop] = queue[ql + 1][mloop];
                                    }
                                }
                                queue[qdepth[mloop]][mloop] = 0;
                                qdepth[mloop]--;
                                curpos[mloop]++;
                            }

                            break;
                    }

                    if ((curpos[mloop] < 0) | (curpos[mloop] > lineCount - 1)) {
                        System.out.println(" break " + curpos[mloop] + " program 1 sent  " + p1send);
                        exitCrit = 1;
                    }

                }
                    if((deadlock[0] == 1) && (deadlock[1] == 1)){
                        System.out.println(" deadlock program 1 sent " + p1send);
                        exitCrit = 1;
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
                varVals[vf1][0] = 0;
                varVals[vf1][1] = 0;
            }
            return vf1;
        }
        public static long getVal(String vbl, int prog){
            long vf1 = 0;
            if( (int) (vbl.trim()).charAt(0)  > 95){
                for(int ql = 1; ql <= varCount; ql++){
                    if(vbl.equals(varArray[ql])){
                        vf1 = varVals[ql][prog];
                    }
                }
            } else {
                vf1  = (long) Integer.parseInt(vbl);
            }
            return vf1;
        }
    }


