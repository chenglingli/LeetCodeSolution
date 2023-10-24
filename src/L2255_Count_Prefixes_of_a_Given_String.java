public class L2255_Count_Prefixes_of_a_Given_String {

    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for (String cur : words) {
            if (s.indexOf(cur) == 0) {
                ans++;
            }
        }

        return ans;
    }

    public int countPrefixes2(String[] words, String s) {
        int count = 0;
        for (String cur : words) {
            if (s.startsWith(cur)) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {

        L2255_Count_Prefixes_of_a_Given_String s =
                new L2255_Count_Prefixes_of_a_Given_String();
        long sysDate1 = System.currentTimeMillis();

        String[] words = {"a", "b", "c", "ab", "bc", "abc"};
        String ss = "abc";
        int res = s.countPrefixes(words, ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}