import java.util.HashMap;
import java.util.Map;

public class L387_First_Unique_Character_in_a_String {

    public int firstUniqChar(String s) {

        int len = s.length();
        int[] markList = new int[len];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                int firstIndex = map.get(cur);
                markList[firstIndex] = 1;
                markList[i] = 1;
            } else {
                map.put(cur, i);
            }
        }

        for (int i = 0; i < len; i++) {
            if (markList[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public int firstUniqChar2(String s) {
        int ans = Integer.MAX_VALUE;

        for (char c = 'a'; c <= 'z'; c++) {
            int left = s.indexOf(c);
            if (left != -1 && left == s.lastIndexOf(c)) {
                ans = Math.min(left, ans);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {

        L387_First_Unique_Character_in_a_String s = new L387_First_Unique_Character_in_a_String();
        long sysDate1 = System.currentTimeMillis();

        String a = "loveleetcode";
        int res = s.firstUniqChar(a);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}