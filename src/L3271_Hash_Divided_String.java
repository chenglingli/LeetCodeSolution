public class L3271_Hash_Divided_String {

    /*

    You are given a string s of length n and an integer k, where n is a multiple of k.
    Your task is to hash the string s into a new string called result, which has a length of n / k.

    First, divide s into n / k substrings, each with a length of k. Then, initialize result as an empty string.

    For each substring in order from the beginning:

    The hash value of a character is the index of that character in the English alphabet (e.g., 'a' → 0, 'b' → 1, ..., 'z' → 25).
    Calculate the sum of all the hash values of the characters in the substring.
    Find the remainder of this sum when divided by 26, which is called hashedChar.
    Identify the character in the English lowercase alphabet that corresponds to hashedChar.
    Append that character to the end of result.
    Return result.



    Example 1:

    Input: s = "abcd", k = 2

    Output: "bf"

    Explanation:

    First substring: "ab", 0 + 1 = 1, 1 % 26 = 1, result[0] = 'b'.

    Second substring: "cd", 2 + 3 = 5, 5 % 26 = 5, result[1] = 'f'.

    Example 2:

    Input: s = "mxz", k = 3

    Output: "i"

    Explanation:

    The only substring: "mxz", 12 + 23 + 25 = 60, 60 % 26 = 8, result[0] = 'i'.



    Constraints:

    1 <= k <= 100
    k <= s.length <= 1000
    s.length is divisible by k.
    s consists only of lowercase English letters.

     */
    public String stringHash(String s, int k) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i += k) {
            String substring = s.substring(i, i + k);
            int sum = 0;
            for (char c : substring.toCharArray()) {
                sum += c - 'a';
            }
            int hashedChar = sum % 26;
            result.append((char) ('a' + hashedChar));
        }

        return result.toString();
    }

    public String stringHash2(String s, int k) {

        int n = s.length();
        char[] res = new char[n / k];

        int idx = 0; // for res array indexing

        for (int i = 0; i < n; i += k) { // loop is incrementing by i+k
            int hashval = 0;
            for (int j = i; j < i + k; j++) {
                hashval += (s.charAt(j) - 'a');
            }

            int hashedChar = hashval % 26;
            res[idx++] = (char) ('a' + hashedChar);
        }

        return new String(res);
    }

    public static void main(String[] args) {

        L3271_Hash_Divided_String s = new L3271_Hash_Divided_String();
        long sysDate1 = System.currentTimeMillis();

        String ss = "abcd";
        int k = 2;

        String res = s.stringHash(ss, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}