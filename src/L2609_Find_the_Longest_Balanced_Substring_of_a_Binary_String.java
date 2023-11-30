public class L2609_Find_the_Longest_Balanced_Substring_of_a_Binary_String {

    /*
    1 <= s.length <= 50
    '0' <= s[i] <= '1'
     */
    public int findTheLongestBalancedSubstring(String s) {

        int i = 0;
        int ans = 0;
        int j = 0;

        int tempAns = 0;

        /*
           000111
           0001111
           00011

         */
        while (i < s.length()) {

            j = 0;
            while (i + j < s.length() && s.charAt(i + j) == '0') j++;
            tempAns = j;
            i += j;

            j = 0;
            while (i + j < s.length() && s.charAt(i + j) == '1') j++;

            tempAns = Math.min(tempAns, j);
            ans = Math.max(ans, tempAns * 2);

            i += j;
        }

        return ans;
    }

    public static void main(String[] args) {

        L2609_Find_the_Longest_Balanced_Substring_of_a_Binary_String s = new L2609_Find_the_Longest_Balanced_Substring_of_a_Binary_String();
        long sysDate1 = System.currentTimeMillis();

        //        String input = "010011000111111";
        String input = "01000111";
        int res = s.findTheLongestBalancedSubstring(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}