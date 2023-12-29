import java.util.ArrayList;
import java.util.List;

public class L2788_Split_Strings_by_Separator {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {

        List<String> res = new ArrayList<>();
        StringBuilder sepBuild = new StringBuilder();
        sepBuild.append("\\");
        sepBuild.append(separator);

        String sep = sepBuild.toString();

        for (String s : words) {
            String[] temp = s.split(sep);
            for (String cur : temp) {
                if (cur.length() > 0) {
                    res.add(cur);
                }
            }
        }

        return res;
    }

    public List<String> splitWordsBySeparator2(List<String> words, char separator) {

        int n = words.size();
        List<String> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String s = words.get(i);
            int l = s.length();
            int start = 0;

            for (int j = 0; j < l; j++) {
                if (s.charAt(j) == separator) {
                    if (j == 0 || start == j) start++;
                    else {
                        ans.add(s.substring(start, j));
                        start = j + 1;
                    }
                }
            }
            if (s.charAt(l - 1) != separator)
                ans.add(s.substring(start, l));
        }

        return ans;
    }

    public static void main(String[] args) {

        L2788_Split_Strings_by_Separator s = new L2788_Split_Strings_by_Separator();
        long sysDate1 = System.currentTimeMillis();

        List<String> words = new ArrayList<>();
        words.add("one.two.three.");
        words.add("four.five");

        char separator = '.';
        List<String> res = s.splitWordsBySeparator(words, separator);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}