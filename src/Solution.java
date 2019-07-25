import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generateParenthesisDFS(n, n, "", res);
        return res;
    }

    void generateParenthesisDFS(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right) return;
        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }
        generateParenthesisDFS(left - 1, right, out + "(", res);
        generateParenthesisDFS(left, right - 1, out + ")", res);
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        long sysDate1 = System.currentTimeMillis();

        List<String> res = s.generateParenthesis(3);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}