import java.util.Arrays;

public class L977_Squares_of_a_Sorted_Array {

    public int[] sortedSquares(int[] nums) {

        int l = nums.length;
        int[] res = new int[l];

        int i = 0;
        int j = l - 1;
        int k = 0;

        while (i < l && j >= 0 && nums[i] <= 0 && nums[j] > 0) {

            int temp1 = nums[i] * nums[i];
            int temp2 = nums[j] * nums[j];

            if (temp1 > temp2) {
                res[k++] = temp1;
                i++;
            } else {
                res[k++] = temp2;
                j--;
            }
        }

        if (nums[i] > 0) {
            while (j >= i) {
                res[k++] = nums[j] * nums[j];
                j--;
            }
        } else {
            while (j >= i) {
                res[k++] = nums[i] * nums[i];
                i++;
            }
        }

        k = 0;
        while (k < l / 2) {

            int temp = res[k];
            res[k] = res[l - k - 1];
            res[l - k - 1] = temp;

            k++;
        }

        return res;
    }

    public static void main(String[] args) {

        L977_Squares_of_a_Sorted_Array s = new L977_Squares_of_a_Sorted_Array();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {1};

        int[] res = s.sortedSquares(input);

        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}