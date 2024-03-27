public class L334_Increasing_Triplet_Subsequence {


    /*
       1 <= nums.length <= 5 * 10^5
       -2^31 <= nums[i] <= 2^31 - 1

       TLE O(n^3)

     */
    public boolean increasingTriplet(int[] nums) {

        int n = nums.length;
        if (n <= 2) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /*
    遍历数组，记录到目前为止的最小值和次小值，如果当前元素大于次小值，那么就找到了一个递增的triplet

    Time: O(n)
    针对 1 4 -1 5 可以给出true
    针对 1 4 -1， 则是false

    因为，他先更新了small，然后更新了mid，如果mid更新了，那么说明mid之前的元素都比mid小，所以不会影响结果

    如果我们要输出一组答案，则不能用这个方法。可以用方法3: O(3n)
     */
    public boolean increasingTriplet2(int[] nums) {

        if (nums.length < 3)
            return false;

        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int big : nums) {
            if (big <= small) {
                small = big;
            } else if (big <= mid) {
                mid = big;
            } else {
                return true;
            }
        }

        return false;
    }

    /*
    从左向右遍历，计算最小值min，如果当前元素大于min，那么就找到了一个递增的pair
    从右向左遍历，计算最大值max，如果当前元素小于max，那么就找到了一个递增的pair
     */
    public boolean increasingTriplet3(int[] nums) {

        int n = nums.length;
        if (n <= 2) {
            return false;
        }
        int[] existSmaller = new int[n];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= min) {
                min = nums[i];
                existSmaller[i] = 0;
            } else {
                existSmaller[i] = 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                if (existSmaller[i] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        L334_Increasing_Triplet_Subsequence s = new L334_Increasing_Triplet_Subsequence();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {2, 1, 5, 0, 4, 6};
        // int[] nums = {20, 100, 10, 12, 5, 13};
        int[] nums = {20, 100, 10, 5};
        boolean res = s.increasingTriplet2(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}