public class AdventOfCode_Day25_1 {
    public static void main(String[] args){
        int steps = 12523873;
        String tape = "00000";
        int curpos = 2;
        int tapelen = 5;
        int state = 0;
        int rules[][] = {{1,1,1,1,-1,4},{1,1,2,1,1,5},{1,-1,3,0,1,1},{1,1,4,0,-1,2},{1,-1,0,0,1,3},{1,1,0,1,1,2}};
        int nextval;
        for(int ql = 0; ql < steps; ql++){
           nextval = 1;
           if(tape.charAt(curpos) == '0') {
               nextval = 0;
           }
           tape = tape.substring(0,curpos) + rules[state][nextval * 3] +tape.substring(curpos + 1);
           curpos += rules[state][(nextval * 3) + 1];
           if (curpos < 1){
               curpos ++;
               tape = "0" + tape;
               tapelen ++;
           }
           if(curpos > tapelen -2){
               tape +=  "0";
               tapelen ++;
           }
           state = rules[state][(nextval * 3) + 2];
        }
        int csum= 0;
        for(int i = 0; i < tape.length(); i++){
            if(tape.charAt(i) == '1'){
                csum ++;
            }
        }
        System.out.println (csum);
    }
}
