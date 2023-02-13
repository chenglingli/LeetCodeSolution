public class L1624_Largest_Substring_Between_Two_Equal_Characters {


    /*

    abcda

    abcabdc


    1 <= s.length <= 300
    s contains only lowercase English letters.

     */
    public int maxLengthBetweenEqualCharacters(String s) {

        int ans = -1;
        int[] leeterLocation = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int letterInt = cur - 'a';

            if (leeterLocation[letterInt] == 0) {
                leeterLocation[letterInt] = i + 1;

            } else {
                int duration = i - leeterLocation[letterInt];
                ans = Math.max(duration, ans);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L1624_Largest_Substring_Between_Two_Equal_Characters s = new L1624_Largest_Substring_Between_Two_Equal_Characters();
        long sysDate1 = System.currentTimeMillis();

        // String input = "abcabdc";
        // String input = "aa";
        String input = "mgntdygtxrvxjnwksqhxuxtrv";
        int res = s.maxLengthBetweenEqualCharacters(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}