public class L1641_Count_Sorted_Vowel_Strings {


    /*
    Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

    A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

    Example 1:

    Input: n = 1
    Output: 5
    Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].

    Example 2:
    Input: n = 2
    Output: 15
    Explanation: The 15 sorted strings that consist of vowels only are
    ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
    Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.

    Example 3:
    Input: n = 33
    Output: 66045


    Constraints:

    1 <= n <= 50
    */
    public int countVowelStrings(int n) {
        /*
        题意：
        5个字母，构成n位的字符串，要求字典序排序，求有多少种组合

        思路1， 动态规划

        dp[len][k] 表示 用前k个元素组成长度为len的组合数

        dp[len][k] = dp[len][k−1] + dp[len−1][k]

        dp[len][k−1] 表示不用第k个元素
        dp[len−1][k] 表示用第k个元素（其实只能用一次）

        两个加起来，就是长度为len的组合数，用k个元素的组合数

         */

        // dp[k]：使用前 k 个元音（k=1..5）组成当前长度的方案数
        // 长度 0 时每种元音集合只有「空串」1 种
        int[] dp = new int[]{0, 1, 1, 1, 1, 1};
        for (int len = 1; len <= n; len++) {
            for (int k = 1; k <= 5; k++) {
                dp[k] += dp[k - 1];
            }
        }
        return dp[5];
    }

    /*
    数学方法
    用前k个元素组成长度为n的组合数
    C(n + k - 1, k - 1)

    就是长度为n的时候，需要插入4块板子，可以插入的位置是n+4

    */
    public int countVowelStrings2(int n) {
        return C(n + 4, 4);
    }

    public int C(int n, int k) {
        // C(n, k) = n*(n-1)*...*(n-k+1) / k!
        // 每乘一项就除掉对应的分母，结果始终是整数，也不会先把 n! 算爆
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - k + i) / i;
        }
        return (int) res;
    }

    public static void main(String[] args) {

        L1641_Count_Sorted_Vowel_Strings s = new L1641_Count_Sorted_Vowel_Strings();
        long sysDate1 = System.currentTimeMillis();

        int n = 33;

        int res = s.countVowelStrings2(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}