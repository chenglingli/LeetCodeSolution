
public class L409_Longest_Palindrome {

    public int longestPalindrome(String s) {

        int[] chatCount = new int['z' - 'A' + 1];
        for (int i = 0 ; i< s.length(); i++) {
            chatCount[s.charAt(i) - 'A'] += 1;
        }

        int res = 0;
        boolean additionalTag = false;

        for (int count : chatCount) {

            if (count == 0) continue;

            if (count % 2 == 0) res += count;
            if (count % 2 != 0 && count > 2) res += count - 1;
            if (count % 2 != 0) additionalTag = true;
        }

        if (additionalTag) {
            res += 1;
        }

        return res;
    }

    public static void main(String[] args) {

        L409_Longest_Palindrome s = new L409_Longest_Palindrome();
        long sysDate1 = System.currentTimeMillis();

        String input = "zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez";

        int res = s.longestPalindrome(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}