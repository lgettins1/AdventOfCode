import java.io.BufferedReader;
import java.io.FileReader;

public class AdventOfCode_Day22_2 {
        public static void main(String[] args)throws Exception {
            String line;
            String map[] = new String [25];
            int gridsize = 1001;
            String grid[] = new String[gridsize];
            for(int i = 0; i < gridsize; i++){
                grid[i] = "";
                for(int j = 0; j < gridsize; j++){
                    grid[i] += ".";
                }
            }
            int mapsize = 0;
            int burstcount = 0;
            BufferedReader br = new BufferedReader(new FileReader
                    ("/home/lance/AdventOfCode_Day22/Input/AdventOfCode_Day22_Input.txt"));
            while((line = br.readLine())!=null){
                map[mapsize] = line;
                mapsize ++;
            }
            int startpos = (gridsize -1)/2 -(mapsize - 1)/2;

            for(int i = 0; i < mapsize; i ++){
                grid[i + startpos] = grid[i+startpos].substring(0, startpos)+ map[i] + grid[i + startpos].substring(startpos + mapsize);
            }
            int curX = (gridsize -1) /2;
            int curY = (gridsize -1) /2;
            int xd = 0;
            int yd = -1;
            int nxd;
            int nyd;


            for (int loop = 0; loop < 10000000; loop ++){
                char curChar = grid[curY].charAt(curX);

                switch(curChar){
                    case '#':
                        nxd = -yd;
                        nyd = xd;
                        xd = nxd;
                        yd = nyd;
                        grid[curY] = grid[curY].substring(0, curX) + "F" + grid[curY].substring(curX + 1);
                        break;
                    case '.':
                        nxd = yd;
                        nyd = -xd;
                        xd = nxd;
                        yd = nyd;
                        grid[curY] = grid[curY].substring(0, curX) + "W" + grid[curY].substring(curX + 1);
                        break;
                    case 'W':
                        grid[curY] = grid[curY].substring(0, curX) + "#" + grid[curY].substring(curX + 1);
                        burstcount++;
                        break;
                    case 'F':
                        xd = -xd;
                        yd = -yd;
                        grid[curY] = grid[curY].substring(0, curX) + "." + grid[curY].substring(curX + 1);
                        break;

                }
                curX += xd;
                curY += yd;
            }
            for(int i = 0; i < gridsize; i ++){
                System.out.println(grid[i]);
            }
            System.out.println();
            System.out.println(burstcount);
        }
}

