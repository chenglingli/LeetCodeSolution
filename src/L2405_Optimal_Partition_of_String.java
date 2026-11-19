public class L2405_Optimal_Partition_of_String {

    /*

    Given a string s, partition the string into one or more substrings such that the characters in each substring are unique.
    That is, no letter appears in a single substring more than once.

    Return the minimum number of substrings in such a partition.

    Note that each character should belong to exactly one substring in a partition.



    Example 1:

    Input: s = "abacaba"
    Output: 4
    Explanation:
    Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
    It can be shown that 4 is the minimum number of substrings needed.

    Example 2:
    Input: s = "ssssss"
    Output: 6
    Explanation:
    The only valid partition is ("s","s","s","s","s","s").

    Constraints:
    1 <= s.length <= 10^5
    s consists of only English lowercase letters.

     */
    public int partitionString(String s) {
        int i = 0;
        int res = 0;
        int n = s.length();

        while (i < n) {

            int[] freq = new int[26];
            while (i < n && freq[s.charAt(i) - 'a'] == 0) {
                freq[s.charAt(i) - 'a']++;
                i++;
            }
            res++;
        }

        return res;
    }

    public int partitionString2(String s) {
        int mask = 0;
        int answer = 1;

        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');

            if ((mask & bit) != 0) {
                answer++;
                mask = 0;
            }

            mask |= bit;
        }

        return answer;
    }

    public static void main(String[] args) {

        L2405_Optimal_Partition_of_String s = new L2405_Optimal_Partition_of_String();
        long sysDate1 = System.currentTimeMillis();

        String ss = "abacaba";

        int res = s.partitionString(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}