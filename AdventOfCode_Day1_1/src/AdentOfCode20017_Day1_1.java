import java.io.BufferedReader;
import java.io.FileReader;

public class AdentOfCode20017_Day1_1 {
    public static void main(String[] args) throws Exception {
        String CapchaInput;
        int Solution = 0;
        int StringPosition;
        int PreviousPosition;
        int StringLength;
        String CurrentChar;
        String PreviousChar;
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

                CurrentChar = CapchaInput.substring(StringPosition,StringPosition + 1);
                PreviousChar = CapchaInput.substring(PreviousPosition, PreviousPosition +1);
                if(CurrentChar.equals(PreviousChar)){
                    CurrentVal=Integer.parseInt(CurrentChar);
                    Solution = Solution + CurrentVal;
                }
            }

            System.out.println("The solution is " + Solution);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}