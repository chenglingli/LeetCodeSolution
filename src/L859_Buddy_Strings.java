import sun.font.CreatedFontTracker;

public class L859_Buddy_Strings {

    public boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        // a == b
        // a 至少有两位字符一模一样
        if (s.equals(goal)) {
            int [] letter = new int[26];
            for (int i = 0 ; i < s.length() ; i++) {
                int tempIndex = s.charAt(i) - 'a';
                letter[tempIndex] ++;
                if (letter[tempIndex] >= 2) {
                    return true;
                }
            }

            return false;
        }

        // a != b
        // 只能有两位index 不一样，且可以交换

        int[] swapIndex = new int[3];
        int j = 0;
        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                swapIndex[j++] = i;
            }
            if (j == 3) {
                return false;
            }
        }

        if (s.charAt(swapIndex[0]) == goal.charAt(swapIndex[1])
                && s.charAt(swapIndex[1]) == goal.charAt(swapIndex[0])) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        L859_Buddy_Strings s = new L859_Buddy_Strings();
        long sysDate1 = System.currentTimeMillis();

        String ss = "abcd";
        String gg = "abdc";

        boolean res = s.buddyStrings(ss, gg);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}