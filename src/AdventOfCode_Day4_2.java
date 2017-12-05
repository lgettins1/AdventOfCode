import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class AdventOfCode_Day4_2 {

        public static void main(String[] args) throws Exception {

            String thisLine;
            int size;
            int match;
            int line = 0;
            int matchcount = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader
                        ("/home/lance/AdventOfCode_Day4/AdventOfCode_Day4_input.txt"));
                while ((thisLine = br.readLine()) != null) {
                    String [] sa = thisLine.split("\\s+");
                    size = sa.length;

                    // take each string, convert to array, sort, convert back to string, then replace in the sa array
                    for(int modchar = 0; modchar < size; modchar ++) {
                        Character chars[] = new Character[sa[modchar].length()];
                        for(int i =0;  i < chars.length; i ++) {
                            chars[i] = sa[modchar].charAt(i);
                        }
                        Arrays.sort(chars);
                        StringBuilder sb = new StringBuilder(chars.length);
                        for(char c : chars) sb.append(c);
                        sa[modchar] = sb.toString();
                    }

                    match = 0;
                    Arrays.sort(sa);
                    for(int ql = 1; ql < size; ql ++) {
                        if (sa[ql].equals(sa[ql - 1])) {
                            match  = 1;
     //                       System.out.println(line + " " + sa[ql]);
                        }
                    }

                    if (thisLine.length() > 0) {
                        line ++;
                        if(match == 0){
                            matchcount++;
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(line + " lines processed. " + matchcount + "  valid passphrases.");
        }
}

