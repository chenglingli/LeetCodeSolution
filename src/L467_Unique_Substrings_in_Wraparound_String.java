public class L467_Unique_Substrings_in_Wraparound_String {

    /*

    一种方法，
    取出每一个子串，判断是否重复，然后判断是否是符合递增序列，时间复杂度O(n^2)

    另一种办法：
    所有满足条件的子串都是以a-z中的某个字符结尾的，
    所以我们可以遍历字符串，找到以每个字符结尾的最长子串，然后把这个子串的长度加到结果中。
    为了避免重复，我们只需要记录以每个字符结尾的最长子串的长度即可。

    这样我们只需要遍历一次字符串，时间复杂度O(n)。

     */
    public int findSubstringInWraproundString(String s) {

        char[] str = s.toCharArray();
        int[] count = new int[26];

        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        count[s.charAt(0) - 'a'] = 1;

        for (int i = 1; i < n; i++) {
            char cur = str[i];
            char pre = str[i - 1];

            if ((cur - pre == 1) || (pre - cur == 25)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }

            int key = cur - 'a';
            count[key] = Math.max(count[key], dp[i]);
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += count[i];
        }

        return res;
    }

    public int findSubstringInWraproundString2(String s) {

        char[] str = s.toCharArray();
        int n = str.length;
        int ans = 0;
        int len = 1;
        int[] max = new int[256];
        max[str[0]] = 1;

        for (int i = 1; i < n; i++) {
            char cur = str[i];
            char pre = str[i - 1];
            if ((cur == 'a' && pre == 'z') || cur == pre + 1) {
                len++;
            } else {
                len = 1;
            }
            max[cur] = Math.max(max[cur], len);
        }

        for (int j : max) {
            ans += j;
        }

        return ans;
    }

    public static void main(String[] args) {

        L467_Unique_Substrings_in_Wraparound_String s = new L467_Unique_Substrings_in_Wraparound_String();

        long sysDate1 = System.currentTimeMillis();

        //        String s1 = "acb", s2 = "ab";
        //        int n1 = 4, n2 = 2;

        String s1 = "zab";
        int res = s.findSubstringInWraproundString(s1);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}