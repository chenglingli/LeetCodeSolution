import java.util.Objects;

public class L032_Longest_Valid_Parentheses {


    /*
    动态规划
    f[i] 表示以i结尾的最长合法序列

    1,如果当前为'('
    f[i] = 0

    2,如果当前为')'
        需要check i-1位置：
        如果i-1位置是'(', 则f[i] = f[i-2] + 2
        如果i-1位置是')', 则需要检查 x = i-f[i-1]-1位置是什么？
            如果x位置是'(', 则 f[i] = f[i-1] + f[i-f[i-1]-2] + 2
            如果x位置是')', 则 f[i] = 0

     */

    public int longestValidParentheses(String s) {

        int max = 0;
        if (Objects.equals(s, "") || s.length() <= 1) {
            return 0;
        }

        int[] f = new int[s.length()];
        f[0] = 0;

        for (int i = 1 ;i < s.length(); i++) {

            //  '('
            if (s.charAt(i) == '(') {
                f[i] = 0;
            }

            // ')'
            else {

                // '()'
                if(s.charAt(i-1) == '(') {
                    f[i] = i-2 >=0 ?
                            f[i-2] + 2 :
                            2;
                }

                // '))'
                else if (i-f[i-1]-1 >=0 && s.charAt(i-f[i-1]-1) == '(') {
                        f[i] = i-f[i-1]-2 >= 0 ?
                                f[i-1] + f[i-f[i-1]-2] + 2 :
                                f[i-1] + 2;
                }

                else {
                    f[i] = 0;
                }
            }

            // update max
            if (f[i] > max) {
                max = f[i];
            }

        }

        return max;
    }

    public static void main(String[] args) {

        L032_Longest_Valid_Parentheses s = new L032_Longest_Valid_Parentheses();

        long sysDate1 = System.currentTimeMillis();
        String xx = "(()())";
        // String xx = "()(())";
        int res = s.longestValidParentheses(xx);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}