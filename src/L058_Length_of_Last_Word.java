/**
 * 检查两棵树是否长得一样
 * <p>
 * 采用递归的方式判断
 */

public class L058_Length_of_Last_Word {

    public int lengthOfLastWord(String s) {
        int res = 0;
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int j = i;

        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                break;
            }
            i--;
        }

        if (j == i) {
            res = 0;
        } else {
            res = j - i;
        }
        return res;
    }

    public static void main(String[] args) {

        L058_Length_of_Last_Word s = new L058_Length_of_Last_Word();

        long sysDate1 = System.currentTimeMillis();

        // String input = "hello world";
        // String input = "hello world   ";
        String input = "solo";

        int res = s.lengthOfLastWord(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}