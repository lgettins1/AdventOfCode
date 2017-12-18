import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day8_1 {
    public static void main(String[] args) throws Exception {
        String[] sa;
        String line;
        String probinput[][] = new String[7][1001];
        int linecount = 0;
        String varlist[] = new String [1000];
        int varvals[] = new int [1000];
        int varcount = 1;

        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("/home/lance/AdventOfCode_Day8/Input/AdventOfCode_Day8_Input.txt"));
            while ((line = br.readLine()) != null) {
                sa = line.split("\\s+");
                for(int ql = 0; ql <=6; ql ++){
                    probinput[ql][linecount] = sa[ql];
                }
                linecount ++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        varlist[1] = probinput[0][0];
        varvals[1] = 0;
        for(int sfv = 1; sfv <linecount; sfv ++){
            int seen = 0;
            for(int il = 1; il <= varcount; il ++){
                if(probinput[0][sfv].equals(varlist[il])){
                    seen ++;
                }
            }
            if(seen == 0){
                varcount ++;
                varlist[varcount] = probinput[0][sfv];
                varvals[varcount] = 0;
            }
        }
        String condvar;
        int condval = 0;
        int maxval = 0;
        for(int procInst = 0; procInst < linecount; procInst ++) {
            int condTrue = 0;

            condvar = probinput[4][procInst];
            for (int ck = 1; ck <= varcount; ck++) {
                if (condvar.equals(varlist[ck])) {
                    condval = varvals[ck];
                }
            }
            String casePick = probinput[5][procInst];

            switch (casePick) {
                case "==":
                    if (condval == Integer.parseInt(probinput[6][procInst])) {
                        condTrue = 1;
                    }
                    break;
                case ">=":
                    if (condval >= Integer.parseInt(probinput[6][procInst])) {
                        condTrue = 1;
                    }
                    break;
                case ">":
                    if (condval > Integer.parseInt(probinput[6][procInst])) {
                        condTrue = 1;
                    }
                    break;
                case "<=":
                    if (condval <= Integer.parseInt(probinput[6][procInst])) {
                        condTrue = 1;
                    }
                    break;
                case "<":
                    if (condval < Integer.parseInt(probinput[6][procInst])) {
                        condTrue = 1;
                    }
                    break;
                case "!=":
                    if (condval != Integer.parseInt(probinput[6][procInst])) {
                        condTrue = 1;
                    }
                    break;
            }
            int vvi = 0;
            int modval = 0;

            if (condTrue == 1) {
                String modvar = probinput[0][procInst];
                for (int ck = 1; ck <= varcount; ck++) {
                    if (modvar.equals(varlist[ck])) {
                        vvi = ck;
                        modval = varvals[ck];
                    }
                }
                int moddelta = Integer.parseInt(probinput[2][procInst]);
                String Up_or_down = probinput[1][procInst];

                switch(Up_or_down){
                    case "inc":
                        varvals[vvi] = modval + moddelta;
                        break;
                    case "dec":
                        varvals[vvi] = modval - moddelta;
                        break;
                }
            }
            for(int ql = 1; ql <= varcount; ql ++){
                if (varvals[ql] > maxval){
                    maxval = varvals[ql];
                }
            }
        }
           System.out.println(" max variable value was " + maxval);
    }
}