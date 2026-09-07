public class L4043_Count_Rotations_With_Exactly_K_Equal_Adjacent_Pairs {

    /*
    You are given a string s of length n and an integer k.

    A cyclic rotation of s is obtained by choosing a prefix of s whose length is between 0 and n - 1 (inclusive),
    and moving it to the end of the string while preserving the order of all characters.

    For every cyclic rotation of s, let its score be the number of indices i
    such that 0 <= i < n - 1 and the characters at positions i and i + 1 are equal.

    Return the number of cyclic rotations of s whose score equals k.



    Example 1:

    Input: s = "aab", k = 1

    Output: 2

    Explanation:

    The cyclic rotations of s are:

    "aab": The characters at positions 0 and 1 are equal, so score = 1.
    "aba": No two adjacent characters are equal, so score = 0.
    "baa": The characters at positions 1 and 2 are equal, so score = 1.

    Since score equals k for 2 cyclic rotations of s, the answer is 2.

    Example 2:
    Input: s = "abca", k = 0
    Output: 1

    Explanation:
    The cyclic rotations of s are:
    "abca": No two adjacent characters are equal, so score = 0.
    "bcaa": The characters at positions 2 and 3 are equal, so score = 1.
    "caab": The characters at positions 1 and 2 are equal, so score = 1.
    "aabc": The characters at positions 0 and 1 are equal, so score = 1.
    Since score equals k for only 1 cyclic rotation of s, the answer is 1.



    Constraints:

    2 <= n == s.length <= 100
    s only consists of lowercase English letters.
    0 <= k <= n - 1

     */
    // score 只统计线性相邻，不统计首尾。把 s 看成环，共 n 对相邻；
    // 起点为 r 的旋转，恰好丢掉环上的一对 (s[r-1], s[r])。
    // 设环上相等对数为 C，则 score(r) = C 或 C-1。
    public int countRotations(String s, int k) {
        int n = s.length();
        int circularEqual = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s.charAt((i + 1) % n)) {
                circularEqual++;
            }
        }

        if (k == circularEqual) {
            return n - circularEqual;
        }
        if (k == circularEqual - 1) {
            return circularEqual;
        }
        return 0;
    }

    public static void main(String[] args) {

        L4043_Count_Rotations_With_Exactly_K_Equal_Adjacent_Pairs s = new L4043_Count_Rotations_With_Exactly_K_Equal_Adjacent_Pairs();
        long sysDate1 = System.currentTimeMillis();

        String ss = "aab";
        int k = 1;

        int res = s.countRotations(ss, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}