import java.util.Arrays;

public class L3545_Minimum_Deletions_for_At_Most_K_Distinct_Characters {

    /*
    You are given a string s consisting of lowercase English letters, and an integer k.

    Your task is to delete some (possibly none) of the characters in the string so that the number of distinct characters in the resulting string is at most k.

    Return the minimum number of deletions required to achieve this.



    Example 1:

    Input: s = "abc", k = 2

    Output: 1

    Explanation:

    s has three distinct characters: 'a', 'b' and 'c', each with a frequency of 1.
    Since we can have at most k = 2 distinct characters, remove all occurrences of any one character from the string.
    For example, removing all occurrences of 'c' results in at most k distinct characters. Thus, the answer is 1.
    Example 2:

    Input: s = "aabb", k = 2

    Output: 0

    Explanation:

    s has two distinct characters ('a' and 'b') with frequencies of 2 and 2, respectively.
    Since we can have at most k = 2 distinct characters, no deletions are required. Thus, the answer is 0.
    Example 3:

    Input: s = "yyyzz", k = 1

    Output: 2

    Explanation:

    s has two distinct characters ('y' and 'z') with frequencies of 3 and 2, respectively.
    Since we can have at most k = 1 distinct character, remove all occurrences of any one character from the string.
    Removing all 'z' results in at most k distinct characters. Thus, the answer is 2.


    Constraints:

    1 <= s.length <= 16
    1 <= k <= 16
    s consists only of lowercase English letters.
     */
    public int minDeletion(String s, int k) {
        // 先统计每个字母的count，假设m个字母
        // 再按照count排序
        // 然后按照count从小到大遍历，使得剩余distinct字母个数为k，累积count个数即为所求

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Arrays.sort(count);


        int i = 0;
        while (count[i] == 0) {
            i++;
        }
        int distinctCharCount = 26 - i;

        int res = 0;
        while (i < 26 && distinctCharCount > k) {
            res += count[i];
            i++;
            distinctCharCount--;
        }

        return res;
    }

    public int minDeletion2(String s, int k) {
        int d = 0, res = 0;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 0)
                d++;
            count[s.charAt(i) - 'a']++;
        }

        // 不断找最小的count，然后减去最小的count，直到distinctCharCount为k
        while (d > k) {
            int min = Integer.MAX_VALUE, idx = -1;
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0 && count[i] < min) {
                    min = count[i];
                    idx = i;
                }
            }
            res += min;
            count[idx] = 0;
            d--;
        }

        return res;
    }

    public static void main(String[] args) {

        L3545_Minimum_Deletions_for_At_Most_K_Distinct_Characters s = new L3545_Minimum_Deletions_for_At_Most_K_Distinct_Characters();
        long sysDate1 = System.currentTimeMillis();

        String ss = "abc";
        int k = 2;

        int res = s.minDeletion(ss, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}