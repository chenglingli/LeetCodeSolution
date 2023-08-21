public class L2108_Find_First_Palindromic_String_in_Array {

    public String firstPalindrome(String[] words) {
        for (String cur : words) {
            if (palindrome(cur)) {
                return cur;
            }
        }

        return "";
    }

    private boolean palindrome(String input) {
        int i = 0;
        int j = input.length() - 1;
        while (i < j) {
            if (!(input.charAt(i) == input.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {

        L2108_Find_First_Palindromic_String_in_Array s = new L2108_Find_First_Palindromic_String_in_Array();
        long sysDate1 = System.currentTimeMillis();

        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        String res = s.firstPalindrome(words);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}