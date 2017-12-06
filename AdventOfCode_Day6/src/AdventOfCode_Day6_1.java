import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day6_1 {
    public static void main(String[] args) throws Exception {
        int[][] BnB = new int[16][300000];
        String[] sa;
        String line;
        int bankCount = 0;
        int rcycles = 0;
        int match = 0;
        int curcell = 0;
        int scancell;
        int redistval;
        int matchcount = 0;
        int firstmatch;

        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("/home/lance/AdventOfCode_Day6/Input/AdventOfCode_Day6_Input.txt"));
            line = br.readLine();
            sa = line.split("\t");
            bankCount = sa.length;
            for (int ql = 0; ql < sa.length; ql++) {
                BnB[ql][0] = Integer.parseInt(sa[ql]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (match == 0) {
            redistval = 0;
            for (int ql2 = 0; ql2 < bankCount; ql2 ++) {
                BnB[ql2][rcycles + 1] = BnB[ql2][rcycles];
                if (redistval < BnB[ql2][rcycles] ) {
                    redistval = BnB[ql2][rcycles];
                    curcell = ql2;
                }
            }

                rcycles++;
                BnB[curcell][rcycles] = 0;
                scancell = curcell;

                for (int ql3 = redistval; ql3 > 0; ql3--) {
                    scancell++;
                    if (scancell == bankCount) {
                        scancell = 0;
                    }
                    BnB[scancell][rcycles]++;
                }

                for (int ql4 = 0; ql4 < rcycles; ql4++) {
                    matchcount = 0;
                    for (int ql5 = 0; ql5 < bankCount; ql5++) {
                        if (BnB[ql5][ql4] == BnB[ql5][rcycles]) {
                            matchcount++;
                        }
                    }
                    if (matchcount == bankCount) {
                        match = 1;
                        firstmatch = ql4;
                        System.out.println(rcycles + " redistribution cycles matching " + firstmatch);
                        System.out.println( "loop size " +(rcycles - firstmatch));
                        break;
                    }

                }

            }

        }
    }

