import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L3692_Majority_Frequency_Characters {

    /*
    You are given a string s consisting of lowercase English letters.

    The frequency group for a value k is the set of characters that appear exactly k times in s.

    The majority frequency group is the frequency group that contains the largest number of distinct characters.

    Return a string containing all characters in the majority frequency group, in any order.
    If two or more frequency groups tie for that largest size, pick the group whose frequency k is larger.



    Example 1:

    Input: s = "aaabbbccdddde"

    Output: "ab"

    Explanation:

    Frequency (k)	Distinct characters in group	Group size	Majority?
    4	{d}	1	No
    3	{a, b}	2	Yes
    2	{c}	1	No
    1	{e}	1	No
    Both characters 'a' and 'b' share the same frequency 3, they are in the majority frequency group.
    "ba" is also a valid answer.

    Example 2:

    Input: s = "abcd"

    Output: "abcd"

    Explanation:

    Frequency (k)	Distinct characters in group	Group size	Majority?
    1	{a, b, c, d}	4	Yes
    All characters share the same frequency 1, they are all in the majority frequency group.

    Example 3:

    Input: s = "pfpfgi"

    Output: "fp"

    Explanation:

    Frequency (k)	Distinct characters in group	Group size	Majority?
    2	{p, f}	2	Yes
    1	{g, i}	2	No (tied size, lower frequency)
    Both characters 'p' and 'f' share the same frequency 2, they are in the majority frequency group.
    There is a tie in group size with frequency 1, but we pick the higher frequency: 2.


    Constraints:

    1 <= s.length <= 100
    s consists only of lowercase English letters.
     */
    public String majorityFrequencyGroup(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxFreq = 0;
        int maxFreqIndex = 0;

        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                continue;
            }

            List<Character> list;

            if (!map.containsKey(freq[i])) {
                list = new ArrayList<>();
            } else {
                list = map.get(freq[i]);
            }
            list.add((char) ('a' + i));
            map.put(freq[i], list);

            if (list.size() > maxFreq) {
                maxFreq = list.size();
                maxFreqIndex = freq[i];
            }

            if (list.size() == maxFreq && freq[i] > maxFreqIndex) {
                maxFreqIndex = freq[i];
            }
        }

        return map.get(maxFreqIndex).toString().replaceAll("[^a-z]", "");
    }


    public static void main(String[] args) {

        L3692_Majority_Frequency_Characters s = new L3692_Majority_Frequency_Characters();
        long sysDate1 = System.currentTimeMillis();

        // String xx = "aaabbbccdddde";
        String xx = "pfpfgi";

        String res = s.majorityFrequencyGroup(xx);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}