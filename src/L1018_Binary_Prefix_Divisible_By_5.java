import java.util.ArrayList;
import java.util.List;

public class L1018_Binary_Prefix_Divisible_By_5 {

    /* 二进制表示能被5整除的格式

    十进制能被5整除的格式是：0结尾或者5结尾

     */

    public List<Boolean> prefixesDivBy5(int[] nums) {

        List<Boolean> res = new ArrayList<>();
        int curNum = 0;

        for (int c : nums) {
            curNum += c;
            //            System.out.println(curNum);

            curNum = curNum % 10000;

            if (curNum % 5 == 0) {
                res.add(true);
            } else {
                res.add(false);
            }

            curNum = curNum << 1;
        }

        return res;
    }

    public List<Boolean> prefixesDivBy52(int[] nums) {
        List<Boolean> res = new ArrayList<>();

        int n = 0;
        for (int i : nums) {
            n = (2 * n + i) % 5;
            res.add(n == 0);
        }

        return res;
    }

    public static void main(String[] args) {

        L1018_Binary_Prefix_Divisible_By_5 s = new L1018_Binary_Prefix_Divisible_By_5();

        long sysDate1 = System.currentTimeMillis();

        int[] arr = {1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1};
        List<Boolean> res = s.prefixesDivBy5(arr);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}