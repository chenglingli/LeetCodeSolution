import java.util.ArrayList;
import java.util.List;

public class L2427_Number_of_Common_Factors {

    public int commonFactors(int a, int b) {

        int res = 0;

        // 取的小的那个值
        if (b > a) {
            int temp = b;
            b = a;
            a = temp;
        }

        if (b == 1) {
            return 1;
        }

        // 获得 小值的 质因子
        List<Integer> factorList = getFactors(b);

        // 如果 大值 可以整除 小值
        if (a % b == 0) {
            return factorList.size() + 2;
        }

        // 如果 大值 不可以整除 小值 ： 分别看 小值 是否是质数
        if (factorList.size() == 0) {
            if (a % b == 0) {
                return 2;
            } else {
                return 1;
            }
        } else {
            for (Integer f : factorList) {
                if (a % f == 0) {
                    res++;
                }
            }
        }

        res += 1;

        return res;
    }

    public List<Integer> getFactors(int x) {

        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                res.add(i);
                if (x / i != i) {
                    res.add(x / i);
                }
            }
        }
        return res;
    }

    public int commonFactorsSlow(int a, int b) {

        int count = 0;
        int c = Math.min(a, b);

        for (int i = 1; i <= c; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        L2427_Number_of_Common_Factors s = new L2427_Number_of_Common_Factors();
        long sysDate1 = System.currentTimeMillis();

        int a = 1;
        int b = 1;
        int res = s.commonFactors(a, b);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}