import java.util.Arrays;

public class L922_Sort_Array_By_ParityII {

    /*

    偶数放在偶数位置，奇数放在奇数位置

     */

    // copy法
    public int[] sortArrayByParityII(int[] nums) {

        int[] res = new int[nums.length];

        int i = 0;
        int j1 = 0;
        int j2 = 1;

        while (i < nums.length) {

            if ((nums[i] & 1) == 0) {
                res[j1] = nums[i];
                j1 += 2;
            } else {
                res[j2] = nums[i];
                j2 += 2;
            }

            i++;
        }

        return res;
    }

    // 置换法
    public int[] sortArrayByParityII2(int[] nums) {

        int evenIndex = 0;

        for (int oddIndex = 1; oddIndex < nums.length; oddIndex += 2) {

            if ((nums[oddIndex] & 1) == 0) {  //is 偶数

                while ((nums[evenIndex] & 1) == 0)// 找到不是偶数的位置
                    evenIndex += 2;

                int temp = nums[oddIndex];
                nums[oddIndex] = nums[evenIndex];
                nums[evenIndex] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {

        L922_Sort_Array_By_ParityII s = new L922_Sort_Array_By_ParityII();
        long sysDate1 = System.currentTimeMillis();


        int[] nums = {4, 2, 5, 7};
        int[] res = s.sortArrayByParityII2(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}