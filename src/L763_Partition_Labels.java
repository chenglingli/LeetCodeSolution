import java.util.ArrayList;
import java.util.List;

public class L763_Partition_Labels {

    /*

    You are given a string s.
    We want to partition the string into as many parts as possible so that each letter appears in at most one part.

    For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.

    Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

    Return a list of integers representing the size of these parts.



    Example 1:
    Input: s = "ababcbacadefegdehijhklij"
    Output: [9,7,8]

    Explanation:
    The partition is "ababcbaca", "defegde", "hijhklij".
    This is a partition so that each letter appears in at most one part.
    A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

    Example 2:
    Input: s = "eccbbbbdec"
    Output: [10]


    Constraints:
    1 <= s.length <= 500
    s consists of lowercase English letters.

     */
    public List<Integer> partitionLabels(String s) {
        // 题目目的：将字符串s分割成尽可能多的部分，使得每个字母只出现在一个部分中。
        /*
        解法：
        1, 遍历字符串s，记录每个字母最后出现的位置。
        2, 再次遍历字符串，维护当前遇到的所有字母最后位置的最大值
        3, 如果当前坐标等于这个最大值，则可以分割一次
        4，分割后，更新start为end+1

        时间复杂度：O(n)
        贪心算法
         */

        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L763_Partition_Labels s = new L763_Partition_Labels();

        long sysDate1 = System.currentTimeMillis();

        String ss = "ababcbacadefegdehijhklij";

        List<Integer> res = s.partitionLabels(ss);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}