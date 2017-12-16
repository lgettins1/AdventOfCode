import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class AdventOfCode_Day12_1 {
    static String programArray[][] = new String[15][3000];
    static int seenPrograms[] = new int[3000];
    static int count = 0;

    public static void main(String[] args){
        String[] sa;
        String line;
        int groupCount = 0;
        int connections;
        int lineCount = 0;
        for(int ql = 0; ql <3000; ql ++){
            seenPrograms[ql] = 2001;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("/home/lance/AdventOfCode_Day12/Input/AdventOfCode_Day12_Input.txt"));
            while ((line = br.readLine()) != null) {
                sa = line.split("\\s+");
                connections = sa.length;
                programArray[0][lineCount] = sa[0];
                for (int ql = 2; ql < connections - 1; ql++) {
                    programArray[ql - 1][lineCount] = sa[ql].substring(0, sa[ql].length() - 1);
                }
                programArray[connections - 2][lineCount] = sa[connections - 1];
                lineCount++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        while(count < lineCount) {
            int scan = 0;
                Arrays.sort(seenPrograms);
                while(seenPrograms[scan] == scan) {
                    scan++;
                }
            groupCount ++;
            procLine(programArray[0][scan]);
            System.out.println(scan + " was seed for group " + groupCount + " bringing total to " + count);
        }
    }




    public static void procLine(String baseName) {
        int found = 0;
        for(int a = 0; a <= count; a++){
            if(Integer.parseInt(baseName) == seenPrograms[a]){
                found = 1;
            }
        }
        if(found == 0){
            seenPrograms[count] = Integer.parseInt(baseName);
            count ++;
            int progRow = Integer.parseInt(baseName);
            int progCol = 1;
            while(programArray[progCol][progRow] != null){
                procLine(programArray[progCol][progRow]);
                progCol ++;
            }
        }
    }
}

