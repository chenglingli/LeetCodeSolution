public class L2185_Counting_Words_With_a_Given_Prefix {

    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String s : words) {
            if (s.indexOf(pref) == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        L2185_Counting_Words_With_a_Given_Prefix s =
                new L2185_Counting_Words_With_a_Given_Prefix();
        long sysDate1 = System.currentTimeMillis();

        String[] words = {"pay", "attention", "practice", "attend"};
        String pref = "at";
        int res = s.prefixCount(words, pref);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}