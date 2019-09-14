import java.util.Objects;

public class L043_Multiply_Strings {

    /**
     Given two non-negative integers num1 and num2 represented as strings,
     return the product of num1 and num2, also represented as a string.

     Example 1:

     Input: num1 = "2", num2 = "3"
     Output: "6"
     Example 2:

     Input: num1 = "123", num2 = "456"
     Output: "56088"
     Note:

     The length of both num1 and num2 is < 110.
     Both num1 and num2 contain only digits 0-9.
     Both num1 and num2 do not contain any leading zero,
     except the number 0 itself.
     You must not use any built-in BigInteger library or
     convert the inputs to integer directly.
     */

    public String multiply(String num1, String num2) {

        int[] n1 = new int[120];
        int[] n2 = new int[120];
        int[] n3 = new int[250];

        // 转化
        for (int i = num1.length() - 1, k = 0; i >= 0; i--)
            n1[k++] = num1.charAt(i) - '0';
        for (int i = num2.length() - 1, k = 0; i >= 0; i--)
            n2[k++] = num2.charAt(i) - '0';

        // 乘积运算
        for (int i = 0; i < num1.length(); i++)
            for (int j = 0; j < num2.length(); j++)
                n3[i + j] += n1[i] * n2[j];

        // 现在进位
        for (int i = 0; i < 249; i++)
        {
            if (n3[i] > 9) {
                n3[i + 1] += n3[i] / 10;
                n3[i] %= 10;
            }
        }

        // 倒置
        int i;
        for (i = 249; i >= 0; i--) {
            if (n3[i] != 0)
                break;
        }
        StringBuilder res = new StringBuilder();
        for (; i >= 0; i--) {
            res.append(n3[i]);
        }

        // 返回
        if (Objects.equals(res.toString(), "")) {
            return "0";
        }
        return res.toString();
    }

    public static void main(String[] args) {

        L043_Multiply_Strings s = new L043_Multiply_Strings();
        long sysDate1 = System.currentTimeMillis();

        String s1 = "23";
        String s2 = "46";
        String res = s.multiply(s1, s2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}