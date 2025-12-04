public class L3442_Maximum_Difference_Between_Even_and_Odd_Frequency_I {

    /*
    You are given a string s consisting of lowercase English letters.

    Your task is to find the maximum difference diff = freq(a1) - freq(a2) between the frequency of characters a1 and a2 in the string such that:

    a1 has an odd frequency in the string.
    a2 has an even frequency in the string.
    Return this maximum difference.



    Example 1:

    Input: s = "aaaaabbc"

    Output: 3

    Explanation:

    The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2.
    The maximum difference is 5 - 2 = 3.
    Example 2:

    Input: s = "abcabcab"

    Output: 1

    Explanation:

    The character 'a' has an odd frequency of 3, and 'c' has an even frequency of 2.
    The maximum difference is 3 - 2 = 1.


    Constraints:

    3 <= s.length <= 100
    s consists only of lowercase English letters.
    s contains at least one character with an odd frequency and one with an even frequency.
     */
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                continue;
            }
            for (int j = 0; j < freq.length; j++) {
                if (i == j) {
                    continue;
                }
                if (freq[j] == 0) {
                    continue;
                }
                if (freq[i] % 2 != 0 && freq[j] % 2 == 0) {
                    maxDiff = Math.max(maxDiff, freq[i] - freq[j]);
                }
            }
        }

        return maxDiff;
    }

    public int maxDifference2(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int n : freq) {
            if (n != 0) {
                if (n % 2 == 0) {
                    minEven = Math.min(minEven, n);
                } else {
                    maxOdd = Math.max(maxOdd, n);
                }
            }
        }

        return maxOdd - minEven;
    }


    public static void main(String[] args) {

        L3442_Maximum_Difference_Between_Even_and_Odd_Frequency_I s = new L3442_Maximum_Difference_Between_Even_and_Odd_Frequency_I();
        long sysDate1 = System.currentTimeMillis();

        String ss = "mmsmsym";

        int res = s.maxDifference(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}