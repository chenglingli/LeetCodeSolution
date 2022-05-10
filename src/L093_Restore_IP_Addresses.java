import java.util.ArrayList;
import java.util.List;

public class L093_Restore_IP_Addresses {

    List<String> res = new ArrayList<String>();

    void backtrack(String s, String tmp, int n) {

        if (s.length() > 3 * (4 - n)) {
            return;
        }

        if (n == 4 && s.length() == 0) {
            res.add(tmp.substring(0, tmp.length() - 1));
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (s.length() < i) {
                break;
            }

            String number = s.substring(0, i);
            int val = Integer.parseInt(number);
            if (Integer.toString(val).length() != i) {
                break;
            }
            if (val > 255) {
                break;
            }

            tmp += number + '.';
            backtrack(s.substring(i), tmp, n + 1);
            tmp = tmp.substring(0, tmp.length() - i - 1);
        }
    }

    public List<String> restoreIpAddresses2(String s) {

        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }

        backtrack(s, "", 0);

        return res;
    }


    List<String> rt = new ArrayList<String>();
    String[] stack = new String[4];

    public List<String> restoreIpAddresses(String s) {

        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        dfs(s, 0, 0);
        return rt;
    }

    /**
     * @param s
     * @param p      :指针
     * @param pstack :stack的下标
     */
    public void dfs(String s, int p, int pstack) {

        if (pstack == 4) {

            // 如果stack长度为4，且s的字符全部用上
            // 则stack[0...3]存了一个结果
            if (p >= s.length()) {
                String ip = String.join(".", stack);
                rt.add(ip);
            }
            return;
        }

        // 获取1~3个字符
        for (int i = 1; i <= 3; i++) {

            // 如果超过字符串长度，返回
            if (p + i > s.length()) {
                return;
            }

            // 若选取的第一个字符是0，则停止选取
            if (i > 1 && s.charAt(p) == '0') {
                continue;
            }

            String number = s.substring(p, p + i);

            // 如果number<=255，递归
            if (Integer.parseInt(number) <= 255) {
                stack[pstack] = number;
                dfs(s, p + i, pstack + 1);
            }
        }
    }

    public static void main(String[] args) {

        L093_Restore_IP_Addresses s = new L093_Restore_IP_Addresses();

        long sysDate1 = System.currentTimeMillis();

        String t = "010010";

        List<String> x = s.restoreIpAddresses2(t);

        for (String l : x) {
            System.out.println(l);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}