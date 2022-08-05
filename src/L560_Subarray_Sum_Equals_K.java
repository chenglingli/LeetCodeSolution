import java.util.HashMap;

public class L560_Subarray_Sum_Equals_K {

    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;

        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (preSum[j + 1] - preSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }


    /*
     * 事实上，我们不需要去计算出具体是哪两项的前缀和之差等于k，
     * 只需要知道等于 k 的前缀和之差出现的次数 count，
     *
     * 所以我们可以在遍历数组过程中，先去计算以 nums[i] 结尾的前缀和 pre，
     * 然后再去判断之前有没有存储 pre - k 这种前缀和，
     * 如果有，
     * 那么 pre - k 到 pre 这中间的元素和就是 k 了。
     *
     */

    public int subarraySum(int[] nums, int k) {

        int len = nums.length;

        int pre = 0;
        int count = 0;

        // 利用哈希表，以前缀和为键，出现次数为对应的值，记录 pre[i] 出现的次数
        HashMap<Integer,Integer> mp = new HashMap <>();
        mp.put(0, 1);

        for (int i = 0; i < len; i++) {

            // 存储索引为 i 的这个元素时，前缀和的值是多少
            pre += nums[i];

            // 判断之前有没有存储 pre - k 这种前缀和
            if (mp.containsKey(pre - k)) {
                // 如果有，说明 pre - k 到 pre 之间的那些元素值之和就是 k
                // 找到了一组，累加到 count 上
                count += mp.get(pre - k);
            }

            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        L560_Subarray_Sum_Equals_K s = new L560_Subarray_Sum_Equals_K();
        long sysDate1 = System.currentTimeMillis();

        int [] nums = {1, 1, 2, 4, 1, 3};
        int k = 4;
        int res = s.subarraySum(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}