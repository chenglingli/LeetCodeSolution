import java.util.ArrayList;
import java.util.List;

public class L345_Reverse_Vowels_of_a_String {

    public String reverseVowels(String s) {

        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        char[] vowelCharList = {'a', 'e', 'i', 'o', 'u', 'A', 'I', 'E', 'O', 'U'};
        List<Character> vowelList = new ArrayList<>();
        for (char c : vowelCharList) {
            vowelList.add(c);
        }

        StringBuilder resPre = new StringBuilder();
        StringBuilder resPost = new StringBuilder();

        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {

            while (!vowelList.contains(s.charAt(i)) && i < j) {
                resPre.append(s.charAt(i));
                i++;
            }

            while (!vowelList.contains(s.charAt(j)) && i < j) {
                resPost.append(s.charAt(j));
                j--;
            }

            if (i != j) {
                resPre.append(s.charAt(j));
                resPost.append(s.charAt(i));
            } else {
                resPost.append(s.charAt(i));
            }
            i++;
            j--;
        }

        return resPre.append(resPost.reverse()).toString();
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
                || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }

    // Function to swap characters at index x and y
    void swap(char[] chars, int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }

    public String reverseVowels2(String s) {
        int start = 0;
        int end = s.length() - 1;
        // Convert String to char array as String is immutable in Java
        char[] sChar = s.toCharArray();

        // While we still have characters to traverse
        while (start < end) {
            // Find the leftmost vowel
            while (start < s.length() && !isVowel(sChar[start])) {
                start++;
            }
            // Find the rightmost vowel
            while (end >= 0 && !isVowel(sChar[end])) {
                end--;
            }
            // Swap them if start is left of end
            if (start < end) {
                swap(sChar, start++, end--);
            }
        }

        // Converting char array back to String
        return new String(sChar);
    }


    public static void main(String[] args) {

        L345_Reverse_Vowels_of_a_String s = new L345_Reverse_Vowels_of_a_String();
        long sysDate1 = System.currentTimeMillis();
        // String input = "leetcode"; // leotcede
        String input = "a a"; // leotcede
        String res = s.reverseVowels(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}