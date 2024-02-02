import java.util.ArrayList;
import java.util.List;

public class L022_Generate_Parentheses {

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<String>();

        generateParenthesisDFS(n, n, "", res);

        return res;
    }

    /**
     * 深度搜索
     * @param left 左括号剩余个数
     * @param right 右括号剩余个数
     * @param tempStr 临时字符串
     * @param res 结果集
     */
    void generateParenthesisDFS(int left, int right, String tempStr, List<String> res) {

        // 剪枝，当 剩余左括号 大于 剩余右括号 时则停止
        if (left < 0 || right < 0 || left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            res.add(tempStr);
            return;
        }

        generateParenthesisDFS(left - 1, right, tempStr + "(", res);
        generateParenthesisDFS(left, right - 1, tempStr + ")", res);
    }

    /*
    * 动态规划
    * dp[i] 表示使用i对括号可以生成的组合list
    * dp[2] = { "(())", "()()"}
    *
    * dp[i] = "(" + dp[可能的括号对数] + ")" + dp[剩余的括号对数]
    * dp[i] = "(" + dp[j] + ")" + dp[i - j - 1] , 0 <= j < i
     */
    public List<String> generateParenthesis2(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        List<List<String>> dp = new ArrayList<>(n);
        List<String> dp0 = new ArrayList<>();

        dp0.add("");
        dp.add(dp0);

        for(int i = 1; i<= n; i++) {
            List<String> tempRes = new ArrayList<>();

            for(int j = 0 ;j < i ;j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);

                for(String pre : str1) {
                    for(String post : str2) {
                        tempRes.add("(" + pre + ")" + post);
                    }
                }
            }

            dp.add(tempRes);
        }

        return dp.get(n);
    }

    public static void main(String[] args) {

        L022_Generate_Parentheses s = new L022_Generate_Parentheses();

        long sysDate1 = System.currentTimeMillis();

        List<String> res = s.generateParenthesis(3);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}