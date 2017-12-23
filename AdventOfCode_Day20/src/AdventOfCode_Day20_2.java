import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day20_2 {

    public static void main(String[] args) throws Exception {
        String line;
        String sa[];
        String sa1[];
        int allvals[][] = new int[9][1001];
        int cpvANDs[][] = new int[7][1001];
        int particle = 0;

        BufferedReader br = new BufferedReader(new FileReader
                ("/Users/lance/AdventOfCode/AdventOfCode_Day20/Input/AdventOfCode_Day20_Input.txt"));
        while ((line = br.readLine()) != null) {
            sa = line.split(">,");
            for (int i = 0; i < 3; i++) {
                sa[i] = (sa[i].trim()).substring(3);
            }
            sa[2] = sa[2].substring(0, sa[2].length() - 1);
            for (int i1 = 0; i1 < 3; i1++) {
                sa1 = sa[i1].split(",");
                for (int i2 = 0; i2 < 3; i2++) {
                    allvals[i1 * 3 + i2][particle] = Integer.parseInt(sa1[i2]);
                }
            }
            particle++;
        }
        for (int b = 0; b < 1001; b++){
            cpvANDs[0][b] = 0;
            for(int c = 0; c <=5; c++){
                cpvANDs[c+1][b] = allvals[c][b];
            }
        }
        int still = particle;

        for(int trialloop = 0; trialloop < 10000; trialloop ++) {
            for (int acclp = 0; acclp < particle; acclp++) {
                if (cpvANDs[0][acclp] == 0) {
                    for (int b = 0; b < 3; b++) {
                        cpvANDs[b + 4][acclp] += allvals[b + 6][acclp];
                        cpvANDs[b + 1][acclp] += cpvANDs[b + 4][acclp];
                    }
                }
            }
             for (int ck = 0; ck < particle - 1; ck++) {
                if (cpvANDs[0][ck] == 0) {
                    for (int comp = ck + 1; comp < particle; comp++) {
                        if ((cpvANDs[1][ck] == cpvANDs[1][comp]) && (cpvANDs[2][ck] == cpvANDs[2][comp])
                                && (cpvANDs[3][ck] == cpvANDs[3][comp])) {
                            cpvANDs[0][ck] = 1;
                            cpvANDs[0][comp] = 1;
                            cpvANDs[1][comp] = -999999999;
                            cpvANDs[2][comp] = -999999999;
                            cpvANDs[3][comp] = -999999999;
                            still--;
                        }
                    }
                    if (cpvANDs[0][ck] == 1) {
                        cpvANDs[1][ck] = -999999999;
                        cpvANDs[2][ck] = -999999999;
                        cpvANDs[3][ck] = -999999999;
                        still--;
                    }
                }
            }
            System.out.println(still);
        }
    }
}


