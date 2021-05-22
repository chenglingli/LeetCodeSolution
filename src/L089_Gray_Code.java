import java.util.ArrayList;
import java.util.List;

public class L089_Gray_Code {

    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        if (n == 0) {
            ret.add(0);
            return ret;
        }

        List<String> res = new ArrayList<>();

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append('0');
        }

        res.add(s.toString());
        generateGray(res, s.toString());

        for (int i = 0; i < res.size(); i++) {
            Integer x = convert(res.get(i));
            ret.add(x);
        }
        return ret;
    }

    Integer convert(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans *= 2;
            ans += s.charAt(i) == '1' ? 1 : 0;
        }
        return ans;
    }


    void generateGray(List<String> res, String cur) {

        String option = getOptions(res, cur);

        if (option == null) {
            return;
        }

        res.add(option);
        generateGray(res, option);
    }

    String getOptions(List<String> res, String cur) {

        for (int i = 0; i < cur.length(); i++) {
            StringBuilder temp = new StringBuilder(cur);
            if (cur.charAt(i) == '0') {
                temp.setCharAt(i, '1');
            } else {
                temp.setCharAt(i, '0');
            }

            if (!res.contains(temp.toString())) {
                return temp.toString();
            }
        }
        return null;
    }

    public List<Integer> grayCode2(int n) {

        List<Integer> rt = new ArrayList<>();

        if (n < 0) {
            return rt;
        }

        for (int i = 0; i < Math.pow(2, n); i++) {
            rt.add((i >> 1) ^ i);
        }

        return rt;
    }

    public static void main(String[] args) {

        L089_Gray_Code s = new L089_Gray_Code();

        long sysDate1 = System.currentTimeMillis();
        List<Integer> res = s.grayCode2(4);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}