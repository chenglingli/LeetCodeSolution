public class L3541_Find_Most_Frequent_Vowel_and_Consonant {

    /*
    You are given a string s consisting of lowercase English letters ('a' to 'z').

    Your task is to:

    Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
    Find the consonant (all other letters excluding vowels) with the maximum frequency.
    Return the sum of the two frequencies.

    Note: If multiple vowels or consonants have the same maximum frequency,
    you may choose any one of them.
    If there are no vowels or no consonants in the string, consider their frequency as 0.

    The frequency of a letter x is the number of times it occurs in the string.


    Example 1:

    Input: s = "successes"

    Output: 6

    Explanation:

    The vowels are: 'u' (frequency 1), 'e' (frequency 2). The maximum frequency is 2.
    The consonants are: 's' (frequency 4), 'c' (frequency 2). The maximum frequency is 4.
    The output is 2 + 4 = 6.
    Example 2:

    Input: s = "aeiaeia"

    Output: 3

    Explanation:

    The vowels are: 'a' (frequency 3), 'e' ( frequency 2), 'i' (frequency 2). The maximum frequency is 3.
    There are no consonants in s. Hence, maximum consonant frequency = 0.
    The output is 3 + 0 = 3.


    Constraints:

    1 <= s.length <= 100
    s consists of lowercase English letters only.
     */
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxVowelFreq = 0;
        int maxConsonantFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20) { // vowels: 'a', 'e', 'i', 'o', 'u'
                maxVowelFreq = Math.max(maxVowelFreq, freq[i]);
            } else {
                maxConsonantFreq = Math.max(maxConsonantFreq, freq[i]);
            }
        }

        return maxVowelFreq + maxConsonantFreq;
    }

    public static void main(String[] args) {

        L3541_Find_Most_Frequent_Vowel_and_Consonant s = new L3541_Find_Most_Frequent_Vowel_and_Consonant();
        long sysDate1 = System.currentTimeMillis();

        String ss = "aeiaeia";

        int res = s.maxFreqSum(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}