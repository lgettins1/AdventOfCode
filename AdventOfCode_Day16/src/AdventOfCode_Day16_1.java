import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day16_1 {
    public static void main(String[] args) throws Exception {
        String line;
        String sa[];
        String ex[];
        String order = "abcdefghijklmnop";
     //   String order = "abcde";
        String orderCopy;
        int poscount = order.length();

        int moveCount;

        BufferedReader br = new BufferedReader(new FileReader
                ("/home/lance/AdventOfCode_Day16/Input/AdventOfCode_Day16_Input.txt"));
        line = br.readLine();
        sa = line.split(",");
        moveCount = sa.length;
        for(int ol = 0; ol <1000000; ol ++) {
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
                            order = order.substring(0, a) + order.substring(b, b + 1) + order.substring(a + 1, b)
                                    + order.substring(a, a + 1) + order.substring(b + 1);
                        } else {
                            order = order.substring(0, b) + order.substring(a, a + 1) + order.substring(b + 1, a)
                                    + order.substring(b, b + 1) + order.substring(a + 1);
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
                        }
                        for (int qly = 0; qly < poscount; qly++) {
                            if (ex[1].equals(order.substring(qly, qly + 1))) {
                                b = qly;
                            }
                        }
                        if (a < b) {
                            order = order.substring(0, a) + order.substring(b, b + 1) + order.substring(a + 1, b)
                                    + order.substring(a, a + 1) + order.substring(b + 1);
                        } else {
                            order = order.substring(0, b) + order.substring(a, a + 1) + order.substring(b + 1, a)
                                    + order.substring(b, b + 1) + order.substring(a + 1);
                        }

                        break;
                }
            }
        }
        System.out.println(order);
    }
}
