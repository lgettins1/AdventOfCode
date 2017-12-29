import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day21_1 {
    public static String[][] rulearray = new String[140][2];
    public static int c2 = 0;

    public static void main(String[] args) throws Exception{
        String[] curray = new String[30];
        String line;
        String[] sa;
        String sInput = ".#./..#/###";
 //     String sInput = ".#/..";

       BufferedReader br = new BufferedReader(new FileReader(
                "c:/Users/Lance/AdventOfCode/AdventOfCode_Day21/Input/AdventOfCode_Day21_Input.txt"));
       while(( line = br.readLine()) != null){
           sa = line.split("=>");
           for(int i = 0; i < 2; i++){
                rulearray[c2][i] = sa[i];
           }
           c2 ++;
       }
       String results[] = new String[20];
       String r1[];
       r1 = sInput.split("/");
       for(int q = 0; q < r1.length; q++){
           results[q] = r1[q];
       }

       for(int loop = 0; loop < 5; loop++){
           int modval;
           for(int copyarray = 0; copyarray < results[0].length(); copyarray++) {
               curray[copyarray] = results[copyarray];
           }
           int size = curray[0].length();
           if(size % 2 == 0){
               modval = 2;
           } else {
               modval = 3;
           }
           for(int i = 0; i<results.length; i++){
               results[i] = "";
           }
           String sa4[];
           for(int a1 = 0; a1 < (size / modval) ; a1 ++){
               for(int a2 = 0; a2 < (size / modval) ; a2 ++){
                   String newInput ="";
                   for(int ql = 0; ql < modval; ql ++){
                       newInput += curray[a1  * modval + ql].substring(a2*modval, (a2 +1) *modval) + "/";
                   }
                   newInput = newInput.substring(0, newInput.length() -1);
                   String s5 = match(newInput);
                   sa4 = (s5.trim()).split("/");
                   int ns = sa4[0].length();
                   for(int ql2 = 0; ql2 < ns; ql2 ++){
                      results[a1 * ns + ql2] += sa4[ql2];
                   }
               }
           }
       }
       int litcount = 0;
       for(int y = 0; y < results[0].length(); y ++){
           System.out.println(results[y]);
           for( int x = 0; x < results[0].length(); x ++) {
               if (results[y].charAt(x) == '#'){
                   litcount ++;
               }
           }
       }
       System.out.println("The number of lit pixels is " + litcount);
    }



    private static String match(String ss) {
        String[] sa1;
        String[] sa2;
        String ret = "";
        ss = ss.trim();
        sa1 = ss.split("/");
        int found = -1;
        int sz = sa1.length;
            for (int loop = 0; loop < c2; loop++) {
                for (int flip = 0; flip < 2; flip++) {
                    for (int rot = 0; rot < 4; rot++) {
                        sa2 = rulearray[loop][0].split("/");
                        int mc = 0;
                        if (sa2.length == sz) {
                            for (int i = 0; i < sz; i++) {
                                if (sa2[i].trim().equals(sa1[i])) {
                                    mc++;
                                }
                            }
                            if (mc == sz) {
                                found = loop;
                            }
                       }

                        sa1 = mrotate(sa1, sz);
                    }
                    sa1 = mflip(sa1, sz);
                }
            }
            if(found >= 0) {
                ret = rulearray[found][1];
            } else {
                System.out.println("can't find " + ss);
            }
        return ret;
    }


    private static String [] mrotate(String [] sa1, int sz){
        char sa3[][] = new char[sz][sz];
        for (int i1 = 0; i1 < sz; i1++) {
            for (int i2 = 0; i2 < sz; i2++) {
                sa3[i1][i2] = sa1[i2].charAt(sz - 1 -i1);
            }
        }
        for (int i1 = 0; i1 < sz; i1++) {
            sa1[i1] = "";
            for (int i2 = 0; i2 < sz; i2++) {
                sa1[i1] = sa1[i1] + sa3[i1][i2];
            }
        }
        return sa1;
    }

    private static String[] mflip(String [] sa1, int sz){
        char sa3[][] = new char[sz][sz];
        for (int i1 = 0; i1 < sz; i1++) {
            for (int i2 = 0; i2 < sz; i2++) {
                sa3[i1][i2] = sa1[i1].charAt(sz - 1 - i2);
            }
        }
        for (int i1 = 0; i1 < sz; i1++) {
            sa1[i1] = "";
            for (int i2 = 0; i2 < sz; i2++) {
                sa1[i1] = sa1[i1] + sa3[i1][i2];
            }
        }
        return sa1;
    }
}
