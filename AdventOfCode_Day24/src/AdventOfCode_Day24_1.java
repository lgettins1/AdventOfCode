import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day24_1 {
    public static int comps[][] = new int[58][3];
    public static int compCount = 0;
    public static int maxScore = 0;
    public static int maxLen = 0;

    public static void main(String [] args) throws Exception {
        String line;
        String as[];

        BufferedReader br = new BufferedReader(new
                FileReader("/home/lance/AdventOfCode_Day24/Input/AdventOfCode_Day24_Input.txt"));
        while ((line = br.readLine()) != null) {
            as = line.split("/");
            comps[compCount][0] = Integer.parseInt(as[0]);
            comps[compCount][1] = Integer.parseInt(as[1]);
            comps[compCount][2] = 1;
            compCount++;
        }
        build("", 0, 0, 0);
        System.out.println("Maximum score is: " + maxScore + "  (Max Length is " + maxLen + ")");
    }


    private static void  build(String pv, int a, int sc, int len){
        for(int ends = 0; ends < 2; ends ++){
            for(int pcs = 0; pcs < compCount; pcs++){
                if(a == comps[pcs][ends] && comps[pcs][2] ==1){
                    String nv = pv + " - " + comps[pcs][ends] + "/" + comps[pcs][1-ends];
                    comps[pcs][2] = 0;
                    sc += comps[pcs][0] + comps[pcs][1];
                    len ++;
                    if(len > maxLen){
                        maxLen = len;
                        maxScore = sc;
                    } else {
                        if (len == maxLen) {
                            if (sc > maxScore) {
                                maxScore = sc;
                            }
                        }
                    }
                    System.out.println(a + " "+ nv + "  ->  " + sc);
                    build(nv, comps[pcs][1 - ends], sc, len);
                    comps[pcs][2] = 1;
                    sc -= comps[pcs][0] + comps[pcs][1];
                    len --;
                }
            }
        }
    }
}
