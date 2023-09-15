import java.util.Arrays;

public class L2164_Sort_Even_and_Odd_Indices_Independently {

    /*
        1 <= nums.length <= 100
        1 <= nums[i] <= 100
     */
    public int[] sortEvenOdd(int[] nums) {

        int[] oddList = new int[(nums.length + 1) / 2];
        int[] evenList = new int[nums.length / 2];

        int j = 0;
        for (int i = 0; i < nums.length; i = i + 2) oddList[j++] = nums[i];

        j = 0;
        for (int i = 1; i < nums.length; i = i + 2) evenList[j++] = nums[i];

        Arrays.sort(oddList);
        Arrays.sort(evenList);

        int[] ans = new int[nums.length];
        int x = evenList.length - 1;
        int y = 0;
        int z = 0;
        while (z < nums.length) {
            ans[z] = oddList[y++];
            z++;
            if (z < nums.length) {
                ans[z] = evenList[x--];
                z++;
            }
        }

        return ans;
    }

    /*
        1 <= nums.length <= 100
        1 <= nums[i] <= 100
     */
    public int[] sortEvenOdd2(int[] nums) {

        int[] countOdd = new int[101];
        int[] countEven = new int[101];

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                countEven[nums[i]]++;
            } else {
                countOdd[nums[i]]++;
            }
        }

        int indexOdd = countOdd.length - 1;
        int indexEven = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != 0) {

                while (countOdd[indexOdd] == 0) {
                    indexOdd--;
                }
                nums[i] = indexOdd;
                countOdd[indexOdd]--;

            } else {

                while (countEven[indexEven] == 0) {
                    indexEven++;
                }
                nums[i] = indexEven;
                countEven[indexEven]--;

            }
        }

        return nums;
    }

    public static void main(String[] args) {

        L2164_Sort_Even_and_Odd_Indices_Independently s =
                new L2164_Sort_Even_and_Odd_Indices_Independently();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {4, 1, 2, 3};
        int[] res = s.sortEvenOdd(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}