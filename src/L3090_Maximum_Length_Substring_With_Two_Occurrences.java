import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L3090_Maximum_Length_Substring_With_Two_Occurrences {

    /*

    Given a string s, return the maximum length of a substring such that it contains at most two occurrences of each character.


    Example 1:

    Input: s = "bcbbbcba"

    Output: 4

    Explanation:
    The following substring has a length of 4 and contains at most two occurrences of each character: "bcbbbcba".

    Example 2:

    Input: s = "aaaa"

    Output: 2

    Explanation:

    The following substring has a length of 2 and contains at most two occurrences of each character: "aaaa".

    Constraints:

    2 <= s.length <= 100
    s consists only of lowercase English letters.

    3090. Maximum Length Substring With Two Occurrences
    */
    public int maximumLengthSubstring(String s) {
        int ans = 0;

        int left = 0;
        int right = 0;
        int len = s.length();

        while (left < len) {

            Map<Character, Integer> tempMap = new HashMap<>();
            while (right < len) {
                char c = s.charAt(right);
                //                System.out.println(left + " " + right + " cur: " + c);
                tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
                if (tempMap.get(c) > 2) {
                    ans = Math.max(ans, right - left);
                    //                    System.out.println("break: " + left + " " + right);
                    break;
                }
                right++;
            }
            if (right == len) {
                ans = Math.max(ans, right - left);
                // System.out.println("break: " + left + " " + right);
            }

            left++;
            right = left;
        }

        return ans;
    }

    /*

    双指针法，用一个数组记录每个字符的出现次数，当出现超过2次时，移动左指针。

     */
    public int maximumLengthSubstring2(String s) {
        int ans = 0;
        int[] freq = new int[26];

        for (int right = 0, left = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 97]++;

            while (freq[s.charAt(right) - 97] == 3)
                freq[s.charAt(left++) - 97]--;

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {

        L3090_Maximum_Length_Substring_With_Two_Occurrences s = new L3090_Maximum_Length_Substring_With_Two_Occurrences();
        long sysDate1 = System.currentTimeMillis();

        String ss = "aaaa";

        int res = s.maximumLengthSubstring(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}