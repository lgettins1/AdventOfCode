public class AdventOfCode_Day23_2 {
    public static void main(String[] args)  {
        int b = 106500;
        int c = 123500;
        int h = 0;
        int f;
        for(int g = b; g <= c; g+=17) { //b increments in chunks of 17
            f = 1;
            for(int e = 2; e < g; e++ ){
                if(g % e == 0) {  //f gets set to 0 when g is non-prime
                    f = 0;
                }
            }
            if(f == 0){
                h++;
            }
        }
        System.out.println(h);
    }
}
