import java.util.Objects;

public class L521_Longest_Uncommon_Subsequence_I {

    public int findLUSlength(String a, String b) {

        if (Objects.equals(a, b)) {
            return -1;
        }

        if (a.length() < b.length()) {
            return b.length();
        }

        return a.length();
    }

    public static void main(String[] args) {

        L521_Longest_Uncommon_Subsequence_I s = new L521_Longest_Uncommon_Subsequence_I();
        long sysDate1 = System.currentTimeMillis();
        String a = "abcf";
        String b = "aebdc";
        int res = s.findLUSlength(a, b);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}