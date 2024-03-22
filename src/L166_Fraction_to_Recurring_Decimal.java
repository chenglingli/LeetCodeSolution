import java.util.HashMap;
import java.util.Map;

public class L166_Fraction_to_Recurring_Decimal {


    /*
    解法
    1. 除法的本质是减法，所以我们可以用减法来模拟除法的过程。
    2. 用一个哈希表记录余数出现的位置，当发现重复的余数时，就找到了循环节。
    3. 注意负数的处理，以及溢出的处理。

     */
    public String fractionToDecimal(int numerator, int denominator) {

        // 被除数为0的情况
        if (numerator == 0) {
            return "0";
        }

        // 返回体
        StringBuilder res = new StringBuilder();

        // 处理负号
        if (numerator < 0 ^ denominator < 0) {
            res.append("-");
        }

        // 处理 -2147483648
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // 整除情况
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // 小数部分，需要识别循环节
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());

        while (num != 0) {

            num *= 10;
            res.append(num / den);
            num %= den;

            // 找到循环节
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }

        return res.toString();
    }


    StringBuilder sb;

    public String fractionToDecimal2(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        sb = new StringBuilder();
        addSign(numerator, denominator);
        divideNumbers(numerator, denominator);
        return sb.toString();
    }

    private void addSign(int a, int b) {
        if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
            return;
        }
        sb.append("-");
    }

    private void divideNumbers(int a, int b) {

        long num = Math.abs((long) a);
        long den = Math.abs((long) b);

        sb.append(num / den);
        num %= den;
        if (num == 0) {
            return;
        }
        appendDecimalPart(num, den);
    }

    private void appendDecimalPart(long num, long den) {

        HashMap<Long, Integer> map = new HashMap<>();
        sb.append(".");
        while (num != 0) {

            num *= 10;
            sb.append(num / den);
            num %= den;

            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                return;
            } else {
                map.put(num, sb.length());
            }
        }
    }


    public static void main(String[] args) {

        L166_Fraction_to_Recurring_Decimal s = new L166_Fraction_to_Recurring_Decimal();
        long sysDate1 = System.currentTimeMillis();

        int numerator = 10000000;
        int denominator = -2147483648;
        String res = s.fractionToDecimal(numerator, denominator);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}