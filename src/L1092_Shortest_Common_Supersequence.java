import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/*

    Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
    If there are multiple valid strings, return any of them.

    A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.



    Example 1:

    Input: str1 = "abac", str2 = "cab"
    Output: "cabac"
    Explanation:
    str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
    str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
    The answer provided is the shortest such string that satisfies these properties.


    Example 2:

    Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
    Output: "aaaaaaaa"


    Constraints:

    1 <= str1.length, str2.length <= 1000
    str1 and str2 consist of lowercase English letters.

 */
public class L1092_Shortest_Common_Supersequence {

    public String shortestCommonSupersequence(String str1, String str2) {
        // 先或者str1和str2的公共子序列
        // 然后根据公共子序列拼接出最短超序列

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < str2.length(); j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = str1.length(), j = str2.length();

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();

    }


    public String shortestCommonSupersequence2(String str1, String str2) {
        String res = "";
        try {
            // 创建一个Callable任务，该任务调用generateLCS方法计算最短公共超序列
            Callable<String> task = () -> generateLCS(str1, str2);

            // 使用Callable任务创建一个FutureTask对象
            FutureTask<String> future = new FutureTask<>(task);

            // 创建一个新线程，并将FutureTask对象作为该线程的任务
            new Thread(future).start();

            // 调用future.get()方法等待任务完成并获取结果，结果存储在res变量中
            res = future.get();
        } catch (Exception e) {
            // 捕获并忽略所有异常
        } // 等待线程完成

        // 返回计算得到的最短公共超序列
        return res;
    }


    /*
     * 生成最短公共超序列
     */
    public String generateLCS(String str1, String str2) {
        // 获取字符串str1的长度
        int l1 = str1.length();
        // 获取字符串str2的长度
        int l2 = str2.length();

        // 创建一个二维数组lcsMatrix，用于存储最长公共子序列的长度
        // 其中lcsMatrix[i][j]表示 str1的前i个字符 和 str2的前j个字符 的最长公共子序列的长度
        // i 表示行索引，j 表示列索引
        int[][] lcsMatrix = new int[l1 + 1][l2 + 1];

        /*

        0 1 2 3 4                   l1
        2
        3
        4
        5                           (l1, l2-1)
        l2          (l1-1,l2)       (l1, l2)


         */

        // 填充lcsMatrix数组，计算最长公共子序列的长度
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                // 如果str1和str2的当前字符相等，则最长公共子序列长度加1
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
                } else {
                    // 否则，取左下方、右上方的最大值作为当前位置的值
                    lcsMatrix[i][j] = Math.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
                }
            }
        }

        // 初始化行索引和列索引
        int row = l1;
        int col = l2;

        // 用于存储最长公共子序列的StringBuilder对象
        String lcs = "";
        StringBuilder ans = new StringBuilder();
        // 从lcsMatrix的右下角开始回溯，构建最长公共子序列
        while (row != 0 && col != 0) {
            if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                // 如果当前字符相等，则添加到结果中，并移动行索引和列索引
                ans.append(str1.charAt(row - 1));
                row--;
                col--;
            } else if (lcsMatrix[row - 1][col] > lcsMatrix[row][col - 1]) {
                // 如果左下方值大于右上方值，则从str1中取字符，并移动行索引
                ans.append(str1.charAt(row - 1));
                row--;
            } else {
                // 否则，从str2中取字符，并移动列索引
                ans.append(str2.charAt(col - 1));
                col--;
            }
        }

        // 处理剩余字符（如果有的话），从str1中取剩余字符
        for (int i = l1 - row; i < l1; i++) {
            ans.append(str1.charAt(row - 1));
            row--;
        }

        // 处理剩余字符（如果有的话），从str2中取剩余字符
        for (int i = l2 - col; i < l2; i++) {
            ans.append(str2.charAt(col - 1));
            col--;
        }

        // 反转StringBuilder对象，得到最终的最长公共子序列
        return ans.reverse().toString();
    }


    public static void main(String[] args) {

        L1092_Shortest_Common_Supersequence s = new L1092_Shortest_Common_Supersequence();

        long sysDate1 = System.currentTimeMillis();

        String str1 = "abac";
        String str2 = "cab";

        String res = s.shortestCommonSupersequence(str1, str2);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}