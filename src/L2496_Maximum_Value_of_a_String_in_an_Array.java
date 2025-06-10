public class L2496_Maximum_Value_of_a_String_in_an_Array {

    /*
    The value of an alphanumeric string can be defined as:
    The numeric representation of the string in base 10, if it comprises of digits only.
    The length of the string, otherwise.

    Given an array strs of alphanumeric strings, return the maximum value of any string in strs.

    Example 1:
    Input: strs = ["alic3","bob","3","4","00000"]
    Output: 5
    Explanation:
    - "alic3" consists of both letters and digits, so its value is its length, i.e. 5.
    - "bob" consists only of letters, so its value is also its length, i.e. 3.
    - "3" consists only of digits, so its value is its numeric equivalent, i.e. 3.
    - "4" also consists only of digits, so its value is 4.
    - "00000" consists only of digits, so its value is 0.
    Hence, the maximum value is 5, of "alic3".


    Example 2:
    Input: strs = ["1","01","001","0001"]
    Output: 1
    Explanation:
    Each string in the array has value 1. Hence, we return 1.


    Constraints:
        1 <= strs.length <= 100
        1 <= strs[i].length <= 9
        strs[i] consists of only lowercase English letters and digits.
     */
    public int maximumValue(String[] strs) {
        int ans = 0;

        for (String str : strs) {
            if (str.matches("[0-9]+")) {
                ans = Math.max(ans, Integer.parseInt(str));
            } else {
                ans = Math.max(ans, str.length());
            }
        }

        return ans;
    }

    public int maximumValue2(String[] strs) {
        int max = 0;

        for (String s : strs) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    i = i * 10 + c - '0';
                } else {
                    i = s.length();
                    break;
                }
            }

            if (max < i) {
                max = i;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        L2496_Maximum_Value_of_a_String_in_an_Array s = new L2496_Maximum_Value_of_a_String_in_an_Array();
        long sysDate1 = System.currentTimeMillis();

        //        String sentence = "lee exercises sound delightful";
        //        String sentence = "eetcode";
        String[] strs = {"alic3", "bob", "3", "4", "00000"};
        int res = s.maximumValue(strs);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}