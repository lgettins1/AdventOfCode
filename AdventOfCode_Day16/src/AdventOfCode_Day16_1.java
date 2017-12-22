import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day16_1 {
    public static void main(String[] args) throws Exception {
        String line;
        String sa[];
        String order = "abcdefghijklmnop";
        //   String order = "abcde";
        String orderCopy;
        int poscount = order.length();

        int moveCount;

        BufferedReader br = new BufferedReader(new FileReader
                ("/Users/lance/AdventOfCode/AdventOfCode_Day16/Input/AdventOfCode_Day16_Input.txt"));
        line = br.readLine();
        sa = line.split(",");
        moveCount = sa.length;
        String origorder = order;
        int loopcount = 0;
        int match = 0;
        while (match < 1) {
            order = (processLoop(order, sa, moveCount, poscount));
            if(order.equals(origorder)){
                match ++;
            }
            loopcount ++;
       }
        int newloop = 1000000000 % loopcount;
        System.out.println(loopcount + " " + newloop);
        for(int ql = 0; ql < newloop; ql ++){
            order = (processLoop(order, sa, moveCount, poscount));
        }
        System.out.println(order);

    }






    private static String processLoop(String order, String sa[], int moveCount, int poscount){
        String ex[];
        for (int dance = 0; dance < moveCount; dance++) {
            String step = sa[dance];
            switch (step.charAt(0)) {
                case 's':
                    int spin = Integer.parseInt(step.substring(1));
                    order = order.substring(poscount - spin) + order.substring(0, poscount - spin);
                    break;

                case 'x':
                    ex = step.substring(1).split("/");
                    int a = Integer.parseInt(ex[0]);
                    int b = Integer.parseInt(ex[1]);
                    if (a < b) {
                        order = reorder(order, a, b);
                    } else {
                        order = reorder(order, b, a);
                    }
                    break;

                case 'p':
                    a = 0;
                    b = 0;
                    ex = step.substring(1).split("/");
                    for (int qlx = 0; qlx < poscount; qlx++) {
                        if (ex[0].equals(order.substring(qlx, qlx + 1))) {
                            a = qlx;
                        }
                        if (ex[1].equals(order.substring(qlx, qlx + 1))) {
                            b = qlx;
                        }
                    }
                    if (a < b) {
                       order = reorder(order, a, b);
                    } else {
                       order = reorder(order, b, a);
                    }
                    break;
            }
        }
    return order;
    }

    private static String reorder(String o, int a, int b){
        o = o.substring(0, a) + o.substring(b, b + 1) + o.substring(a + 1, b)
                + o.substring(a, a + 1) + o.substring(b + 1);
        return o;
    }
}
