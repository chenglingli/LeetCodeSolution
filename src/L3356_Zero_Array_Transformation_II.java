import java.util.Arrays;

public class L3356_Zero_Array_Transformation_II {

    /*
    You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri, vali].

    Each queries[i] represents the following action on nums:

    Decrement the value at each index in the range [li, ri] in nums by at most vali.
    The amount by which each value is decremented can be chosen independently for each index.
    A Zero Array is an array with all its elements equal to 0.

    Return the minimum possible non-negative value of k, such that after processing the first k queries in sequence,
     nums becomes a Zero Array. If no such k exists, return -1.



    Example 1:

    Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]

    Output: 2

    Explanation:

    For i = 0 (l = 0, r = 2, val = 1):
    Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
    The array will become [1, 0, 1].

    For i = 1 (l = 0, r = 2, val = 1):
    Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
    The array will become [0, 0, 0], which is a Zero Array. Therefore, the minimum value of k is 2.


    Example 2:

    Input: nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]

    Output: -1

    Explanation:

    For i = 0 (l = 1, r = 3, val = 2):
    Decrement values at indices [1, 2, 3] by [2, 2, 1] respectively.
    The array will become [4, 1, 0, 0].

    For i = 1 (l = 0, r = 2, val = 1):
    Decrement values at indices [0, 1, 2] by [1, 1, 0] respectively.
    The array will become [3, 0, 0, 0], which is not a Zero Array.


    Constraints:

    1 <= nums.length <= 10^5
    0 <= nums[i] <= 5 * 10^5
    1 <= queries.length <= 10^5
    queries[i].length == 3
    0 <= li <= ri < nums.length
    1 <= vali <= 5


     */

    // 暴力解法，超时
    public int minZeroArray2(int[] nums, int[][] queries) {

        // 遍历queries，对nums进行操作
        // 每次操作后，检查是否可以变为0数组

        boolean needToCheck = true;

        for (int i = 0; i < queries.length; i++) {

            if (needToCheck && Arrays.stream(nums).allMatch(x -> x <= 0)) {
                return i;
            }

            needToCheck = true;
            // 每次操作，对nums进行操作
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (nums[j] <= 0) {
                    continue;
                }
                nums[j] -= queries[i][2];
                if (needToCheck && nums[j] > 0) {
                    needToCheck = false;
                }
            }
        }

        if (Arrays.stream(nums).allMatch(x -> x <= 0)) {
            return queries.length;
        }

        return -1;
    }


    // 优化 - 二分查找
    public int minZeroArray(int[] nums, int[][] queries) {

        // 判断是否可以变为0数组
        if (Arrays.stream(nums).allMatch(x -> x == 0))
            return 0;

        // 二分查找
        int left = 1, right = queries.length;
        if (!canMakeZeroArray(right, nums, queries)) {
            return -1;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canMakeZeroArray(mid, nums, queries)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // 返回最小的k值
        return left;
    }

    // 判断是否可以变为0数组
    /*
    差分数组的含义是 [left, right]区间减去val，那么差分数组在left位置加上val，right+1位置减去val
    例如：
    [0, 2]区间减去1，那么差分数组在0位置加上1，3位置减去1
    那么差分数组的前缀和就是原数组的值

    为什么差分数组前缀和可以计算是否满足呢？
    因为差分数组的前缀和就是原数组的值，如果某个位置的前缀和小于原数组的值，那么就不能满足条件

    譬如 0 2 3
    会收到 3 0 0 -3
    那么
    sum(0, 2) == 3
    sum(0, 3) == 0

     */
    private boolean canMakeZeroArray(int k, int[] nums, int[][] queries) {

        // 初始化差分数组
        int n = nums.length;
        int[] diff = new int[n + 1];

        // 构建 差分数组
        for (int i = 0; i < k; i++) {
            // 差分数组，左闭右开区间[left, right+1]
            int left = queries[i][0], right = queries[i][1], val = queries[i][2];
            diff[left] += val;
            diff[right + 1] -= val;
        }

        // 判断是否可以变为0数组，从左到右遍历差分数组，累加值应该大于等于原数组的值
        int currVal = 0;
        for (int i = 0; i < n; i++) {
            currVal += diff[i];
            if (currVal < nums[i])
                return false;
        }

        return true;
    }


    // 优化2
    public int minZeroArray3(int[] nums, int[][] queries) {

        // 获取nums数组的长度
        int n = nums.length;

        // 初始化差分数组，长度为nums数组长度加1
        int[] differenceArray = new int[n + 1];

        // 初始化差分数组的前缀和
        int differentArrayPrefixSum = 0;

        // 初始化查询计数器
        int q = 0;

        // 遍历nums数组
        for (int i = 0; i < n; i++) {

            // 当差分数组的前缀和小于nums数组的当前元素时，进入循环
            while (differentArrayPrefixSum + differenceArray[i] < nums[i]) {
                // 查询计数器加1
                q++;

                // 如果查询计数器超过了queries数组的长度，则返回-1
                if (q > queries.length)
                    return -1;

                // 获取下一个查询
                int[] nextQuery = queries[q - 1];
                int left = nextQuery[0], right = nextQuery[1], val = nextQuery[2];

                // 如果当前索引i在查询范围内（right >= i），则更新差分数组
                if (right >= i) {
                    // 在left和i的较大值处增加val
                    differenceArray[Math.max(left, i)] += val;
                    // 在right+1处减少val
                    differenceArray[right + 1] -= val;
                }
            }

            // 更新差分数组的前缀和
            differentArrayPrefixSum += differenceArray[i];
        }

        // 返回查询计数器q的值
        return q;
    }


    public static void main(String[] args) {

        L3356_Zero_Array_Transformation_II s = new L3356_Zero_Array_Transformation_II();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {2, 0, 2};
        int[][] queries = {{0, 2, 1}, {0, 2, 1}, {1, 1, 3}};

        int res = s.minZeroArray(nums, queries);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}