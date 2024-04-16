import java.util.ArrayList;
import java.util.List;

public class L386_Lexicographical_Numbers {

    /*
    1 <= n <= 5 * 10^4
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            dfs(i, n, res);
        }

        return res;
    }

    /*
        算法：
        1. 递归
        2. 1 -> 10 -> 100 -> 1000 -> 10000 -> 100000
        3. 100000 -> 100001 -> 100002 -> 100003 -> 100004
        4. 100010 -> 100011 -> 100012 -> 100013 -> 100014

     */
    void dfs(int start, int n, List<Integer> res) {
        if (start > n) {
            return;
        }

        res.add(start);
        for (int j = 0; j < 10; j++) {
            int temp = start * 10 + j;
            if (temp > n)
                return;
            else
                dfs(temp, n, res);
        }
    }

    public static void main(String[] args) {

        L386_Lexicographical_Numbers s = new L386_Lexicographical_Numbers();
        long sysDate1 = System.currentTimeMillis();

        int n = 105;
        List<Integer> res = s.lexicalOrder(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}