public class L318_Maximum_Product_of_Word_Lengths {

    /*
    2 <= words.length <= 1000
    1 <= words[i].length <= 1000
    words[i] consists only of lowercase English letters.
     */
    public int maxProduct(String[] words) {

        // 参数判断
        if (words.length == 1) {
            return 0;
        }

        // 变量定义
        int n = words.length;
        int ans = 0;
        int[][] exist = new int[n][26];

        // 预处理为26位 存在数组
        for (int i = 0; i < n; i++) {
            char[] wordArray = words[i].toCharArray();
            for (char c : wordArray) {
                exist[i][c - 'a'] = 1;
            }
        }

        // 基于存在数组计算当前最大ans
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (noCommonLetters(exist, i, j)) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        // 返回结果
        return ans;
    }

    /*
        判断i和j是否存在公共字符
     */
    private boolean noCommonLetters(int[][] exist, int i, int j) {

        for (int k = 0; k < 26; k++) {
            if (exist[i][k] == 1 && exist[j][k] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L318_Maximum_Product_of_Word_Lengths s = new L318_Maximum_Product_of_Word_Lengths();
        long sysDate1 = System.currentTimeMillis();

        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        int res = s.maxProduct(words);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}