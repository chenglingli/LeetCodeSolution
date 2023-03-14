import java.util.Arrays;

public class L1460_Make_Two_Arrays_Equal_by_Reversing_Subarrays {

    /*

    target.length == arr.length
    1 <= target.length <= 1000
    1 <= target[i] <= 1000
    1 <= arr[i] <= 1000

     */
    public boolean canBeEqual(int[] target, int[] arr) {
        int [] count = new int[1001];
        for (int j : target) {
            count[j]++;
        }

        for (int j : arr) {
            count[j]--;
        }

        for (int j : count) {
            if (j != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L1460_Make_Two_Arrays_Equal_by_Reversing_Subarrays s = new L1460_Make_Two_Arrays_Equal_by_Reversing_Subarrays();
        long sysDate1 = System.currentTimeMillis();

        int[] target = {4, 8, 5, 2, 3};
        int[] arr = {8, 4, 6, 2, 3};
        boolean res = s.canBeEqual(target, arr);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}