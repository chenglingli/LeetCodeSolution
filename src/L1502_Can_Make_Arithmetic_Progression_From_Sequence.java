import java.util.Arrays;

public class L1502_Can_Make_Arithmetic_Progression_From_Sequence {

    /*
    2 <= arr.length <= 1000
     */
    public boolean canMakeArithmeticProgression(int[] arr) {

        Arrays.sort(arr);
        int duration = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != duration) {
                return false;
            }
        }
        return true;
    }

    /*
    算法复杂度是 n*3
    前一个需要排序，则为nlogn
     */
    public boolean canMakeArithmeticProgression2(int[] arr) {

        int n = arr.length;
        int min1 = 9999998;
        int min2 = 9999999;

        // 得到最小的两个值
        for (int j : arr) {
            if (j <= min1) {
                min2 = min1;
                min1 = j;
            } else if (j <= min2) {
                min2 = j;
            }
        }

        // 得到间距差
        int duration = min2 - min1;

        // 间距为0的单独处理
        if (duration == 0) {
            for (int j : arr) {
                if (j != arr[0])
                    return false;
            }
            return true;
        }

        // 设置每个段落值，如果存在则为true
        boolean[] pres = new boolean[n];
        for (int j : arr) {
            int idx = (j - min1) / duration;

            if (idx >= 0 && idx < n)
                pres[idx] = true;
        }

        // 检查每个段落值是否存在，一个不存在则false
        for (int i = 0; i < n; i++)
            if (!pres[i])
                return false;

        // 满足条件
        return true;
    }

    public static void main(String[] args) {

        L1502_Can_Make_Arithmetic_Progression_From_Sequence s = new L1502_Can_Make_Arithmetic_Progression_From_Sequence();
        long sysDate1 = System.currentTimeMillis();

        int[] arr = {2, 4, 1};
        boolean res = s.canMakeArithmeticProgression2(arr);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}