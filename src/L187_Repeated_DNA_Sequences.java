import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L187_Repeated_DNA_Sequences {


    /*
        超时
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        if (s == null || s.length() < 10) {
            return res;
        }

        int i = 0;
        while (i + 10 <= s.length()) {
            String sub = s.substring(i, i + 10);
            if (!set.contains(sub) && s.indexOf(sub, i + 1) != -1) {
                res.add(sub);
                set.add(sub);
            }
            i++;
        }

        return res;
    }

    /*
    优化，使用两个set
    一个set保存已经出现的字符串
    一个set保存重复的字符串

     */
    public List<String> findRepeatedDnaSequences2(String s) {

        int length = s.length();
        if (length <= 10) {
            return new ArrayList<>();
        }

        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }

    public static void main(String[] args) {

        L187_Repeated_DNA_Sequences s = new L187_Repeated_DNA_Sequences();

        long sysDate1 = System.currentTimeMillis();

        String ss = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res = s.findRepeatedDnaSequences2(ss);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}