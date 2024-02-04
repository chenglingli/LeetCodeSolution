public class L1967_Number_of_Strings_That_Appear_as_Substrings_in_Word {


    public int numOfStrings(String[] patterns, String word) {

        int ans = 0;
        for (String s : patterns) {
            if (word.contains(s)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        L1967_Number_of_Strings_That_Appear_as_Substrings_in_Word s = new L1967_Number_of_Strings_That_Appear_as_Substrings_in_Word();
        long sysDate1 = System.currentTimeMillis();

        String word = "abc";
        String[] patterns = {"a", "abc", "bc", "d"};
        int res = s.numOfStrings(patterns, word);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}