import java.io.BufferedReader;
import java.io.FileReader;

public class AdveintOfCode2017_Day1_2 {
    public static void main(String[] args) throws Exception {
        String CapchaInput;
        int Solution1 = 0;
        int Solution2 = 0;
        int StringPosition;
        int PreviousPosition;
        int OppoPosition;
        int StringLength;
        String CurrentChar;
        String PreviousChar;
        String OppoChar;
        int CurrentVal;

        try {
            // open input stream  for reading purpose.
            BufferedReader br = new BufferedReader(new FileReader("c:/Users/Lance/AdventOfCode/" +
                    "AdventOfCode_Day1_1/Input/AdventOfCode_Day1_1_input.txt"));
            CapchaInput = br.readLine();
            StringLength = CapchaInput.length();
            for(StringPosition = 0; StringPosition < StringLength; StringPosition ++){

                if (StringPosition == 0){
                    PreviousPosition = StringLength - 1;
                } else {
                    PreviousPosition = StringPosition - 1;
                }
                if (StringPosition < StringLength /2){
                    OppoPosition =  StringPosition + StringLength /2;
                } else {
                    OppoPosition = StringPosition - StringLength /2;
                }

                CurrentChar = CapchaInput.substring(StringPosition,StringPosition + 1);
                PreviousChar = CapchaInput.substring(PreviousPosition, PreviousPosition +1);
                OppoChar = CapchaInput.substring(OppoPosition, OppoPosition + 1);
                CurrentVal=Integer.parseInt(CurrentChar);
                if(CurrentChar.equals(PreviousChar)){
                    Solution1 = Solution1 + CurrentVal;
                }
                if(CurrentChar.equals(OppoChar)){
                    Solution2 = Solution2 +CurrentVal;
                }
            }

            System.out.println("The Part 1 solution is " + Solution1);
            System.out.println("The Part 2 solution is " + Solution2);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
