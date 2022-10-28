import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class L929_Unique_Email_Addresses {

    public int numUniqueEmails(String[] emails) {

        List<String> res = new ArrayList<>();
        for (String email : emails) {
            String cur = preProcess(email);
            //            System.out.println(cur);
            if (!res.contains(cur)) {
                res.add(cur);
            }
        }

        return res.size();
    }

    private String preProcess(String s) {

        int index = s.indexOf('@');
        String first = s.substring(0, index);
        String second = s.substring(index);

        StringBuilder fsb = new StringBuilder();

        for (int i = 0; i < first.length(); i++) {

            char cur = first.charAt(i);

            if (cur == '+') {
                break;
            }

            if (cur != '.') {
                fsb.append(cur);
            }
        }

        return fsb + second;
    }

    // 权值计算法
    public int numUniqueEmails2(String[] emails) {

        HashSet<Integer> unique = new HashSet<>();

        for (String email : emails) {
            int hash = calcPowValue(email);
            unique.add(hash);
        }
        return unique.size();
    }

    private Integer calcPowValue(String s) {

        int res = 0;
        int i = 0;

        while (i < s.length()) {

            char c = s.charAt(i);

            // 过滤 点
            if (c == '.') {
                i++;
                continue;
            }

            // 遇到+，循环到 at
            if (c == '+') {
                while (s.charAt(i) != '@') {
                    i++;
                }
                break;
            }

            // at，需要break，单独计算
            if (c == '@') {
                break;
            }

            res = (res * 31) + c;
            i++;
        }

        // at后的单独计算
        while (i < s.length()) {
            char c = s.charAt(i);
            res = (res * 31) + c;
            i++;
        }

        return res;
    }

    public static void main(String[] args) {

        L929_Unique_Email_Addresses s = new L929_Unique_Email_Addresses();
        long sysDate1 = System.currentTimeMillis();

        String[] emails = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "teste+mail+david@lee.tcode.com"};
        int res = s.numUniqueEmails2(emails);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}