import java.util.HashSet;
import java.util.Set;

public class L3823_Reverse_Letters_Then_Special_Characters_in_a_String {

    /*
    You are given a string s consisting of lowercase English letters and special characters.

    Your task is to perform these in order:

    Reverse the lowercase letters and place them back into the positions originally occupied by letters.
    Reverse the special characters and place them back into the positions originally occupied by special characters.
    Return the resulting string after performing the reversals.



    Example 1:

    Input: s = ")ebc#da@f("

    Output: "(fad@cb#e)"

    Explanation:

    The letters in the string are ['e', 'b', 'c', 'd', 'a', 'f']:
    Reversing them gives ['f', 'a', 'd', 'c', 'b', 'e']
    s becomes ")fad#cb@e("
    The special characters in the string are [')', '#', '@', '(']:
    Reversing them gives ['(', '@', '#', ')']
    s becomes "(fad@cb#e)"


    Example 2:

    Input: s = "z"

    Output: "z"

    Explanation:

    The string contains only one letter, and reversing it does not change the string. There are no special characters.

    Example 3:

    Input: s = "!@#$%^&*()"

    Output: ")(*&^%$#@!"

    Explanation:

    The string contains no letters. The string contains all special characters, so reversing the special characters reverses the whole string.



    Constraints:

    1 <= s.length <= 100
    s consists only of lowercase English letters and the special characters in "!@#$%^&*()".

     */
    public String reverseByType(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (chars[left] >= 'a' && chars[left] <= 'z' && left < right) {
                left++;
            }
            while (chars[right] >= 'a' && chars[right] <= 'z' && left < right) {
                right--;
            }

            if (left >= right) {
                break;
            }

            swap(chars, left, right);
            left++;
            right--;
        }

        left = 0;
        right = s.length() - 1;
        while (left < right) {
            while (!(chars[left] >= 'a' && chars[left] <= 'z') && left < right) {
                left++;
            }
            while (!(chars[right] >= 'a' && chars[right] <= 'z') && left < right) {
                right--;
            }

            if (left >= right) {
                break;
            }

            swap(chars, left, right);
            left++;
            right--;
        }

        return String.valueOf(chars);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        L3823_Reverse_Letters_Then_Special_Characters_in_a_String s = new L3823_Reverse_Letters_Then_Special_Characters_in_a_String();
        long sysDate1 = System.currentTimeMillis();

        String ss = "!@#$%^&*()";
        String res = s.reverseByType(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}