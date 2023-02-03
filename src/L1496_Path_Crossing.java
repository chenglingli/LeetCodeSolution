import java.util.HashSet;

public class L1496_Path_Crossing {

    /*
    1 <= path.length <= 10^4
    path[i] is either 'N', 'S', 'E', or 'W'.
     */
    public boolean isPathCrossing(String path) {

        int[][] map = new int[1000][1000];

        int offset = 500;

        int x = 0;
        int y = 0;
        map[x + offset][y + offset] = 1;

        for (int i = 0; i < path.length(); i++) {
            char cur = path.charAt(i);
            switch (cur) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                default:
                    x--;
            }
            if (map[x + offset][y + offset] == 1) {
                return true;
            }
            map[x + offset][y + offset] = 1;
        }
        return false;
    }

    public boolean isPathCrossing2(String path) {

        HashSet<Integer> seen = new HashSet<>();
        int x = 0;
        int y = 0;
        seen.add(0);
        int len = path.length();

        for (int i = 0; i < len; ++i) {
            char c = path.charAt(i);
            if (c == 'N') {
                --x;
            } else if (c == 'S') {
                ++x;
            } else if (c == 'E') {
                ++y;
            } else {
                --y;
            }
            if (!seen.add(x * 10000 + y)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        L1496_Path_Crossing s = new L1496_Path_Crossing();
        long sysDate1 = System.currentTimeMillis();

        String xx = "NES";
        boolean res = s.isPathCrossing(xx);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}