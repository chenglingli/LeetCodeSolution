import java.util.Arrays;

public class L821_Shortest_Distance_to_a_Character {

    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == c) {
                res[i] = 0;
            } else {
                int index = s.indexOf(c, i);
                if (index == -1) {
                    index = Integer.MAX_VALUE;
                }
                int lastIndex = s.lastIndexOf(c, i);
                if (lastIndex == -1) {
                    lastIndex = Integer.MAX_VALUE;
                }
                res[i] = Math.min(Math.abs(index - i), Math.abs(i - lastIndex));
            }

            i++;
        }

        return res;
    }

    // 两个方向扫描法
    public int[] shortestToChar2(String s, char c) {

        int[] res = new int[s.length()];
        int i = 0;

        while (i < s.length()) {
            res[i] = Integer.MAX_VALUE;

            if (s.charAt(i) == c) {
                res[i] = 0;
            } else {
                int nextIndex = s.indexOf(c, i);
                if (nextIndex == -1) {
                    i++;
                    continue;
                }
                int duration = nextIndex - i;
                res[i] = duration;
            }

            i++;
        }

        i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == c) {
                i--;
                continue;
            } else {
                int preIndex = s.lastIndexOf(c, i);
                if (preIndex == -1) {
                    i--;
                    continue;
                }
                int duration = i - preIndex;
                res[i] = Math.min(duration, res[i]);
            }

            i--;
        }

        return res;
    }

    public int[] shortestToChar3(String s, char c) {
        int[] res = new int[s.length()];

        int i = 0;
        int index = -1;
        int lastIndex = Integer.MAX_VALUE;

        while (i < s.length()) {

            if (s.charAt(i) == c) {
                index = i;
                res[i] = 0;
                i++;
                continue;
            }

            // 无需重新定位
            if (i < index) {
                res[i] = Math.min(Math.abs(index - i), Math.abs(i - lastIndex));
                i++;
                continue;
            }

            // 需要重新定位
            lastIndex = index != -1 ? index : Integer.MAX_VALUE;
            index = s.indexOf(c, i);
            if (index == -1) {
                index = Integer.MAX_VALUE;
            }
            res[i] = Math.min(Math.abs(index - i), Math.abs(i - lastIndex));
            i++;
        }

        return res;
    }

    // 两个方向扫描法
    public int[] shortestToChar4(String s, char c) {

        int n = s.length();
        int[] arr = new int[n];
        int c_position = -n;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                c_position = i;
            }
            arr[i] = i - c_position;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                c_position = i;
            }
            arr[i] = Math.min(arr[i], Math.abs(i - c_position));
        }

        return arr;
    }

    public static void main(String[] args) {

        L821_Shortest_Distance_to_a_Character s = new L821_Shortest_Distance_to_a_Character();
        long sysDate1 = System.currentTimeMillis();

        String ss = "loveleetcode";
        // [3,2,1,0,1,0,0,1,2,2,1,0]
        char c = 'e';

        //        String ss = "baaa" ;
        //        char c = 'b' ;

        int[] res = s.shortestToChar4(ss, c);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}