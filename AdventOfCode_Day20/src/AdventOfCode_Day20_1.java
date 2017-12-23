import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day20_1 {
    public static void main(String[] args) throws Exception {
        String line;
        String sa[];
        String sa1[];
        int allvals[][] = new int[9][1001];
        int particle = 0;

        BufferedReader br = new BufferedReader(new FileReader
                ("/Users/lance/AdventOfCode/AdventOfCode_Day20/Input/AdventOfCode_Day20_Input.txt"));
        while ((line = br.readLine()) != null) {
            sa = line.split(">,");
            for (int i = 0; i < 3; i++) {
                sa[i] = (sa[i].trim()).substring(3);
            }
            sa[2] = sa[2].substring(0, sa[2].length() -1);
            for(int i1 = 0; i1 < 3; i1 ++){
                sa1 = sa[i1].split(",");
                for(int i2 = 0; i2 < 3; i2 ++){
                    allvals[i1 *3 + i2][particle] = Integer.parseInt(sa1[i2]);
                }
            }
            particle ++;
        }
        int minacc = 10000;
        int winner = -1;
        for(int i = 0; i < particle; i++){
            int acc = 0;
            for(int cart = 0; cart <3; cart ++){
                int a = allvals[6 + cart][i];
                acc += (a*a);
            }
            if(acc < minacc){
                minacc = acc;
                winner = i;
            }
        }
        System.out.println("winner is " + winner + " acceleration is " + minacc);
    }
}
