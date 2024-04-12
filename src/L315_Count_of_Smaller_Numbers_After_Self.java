import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L315_Count_of_Smaller_Numbers_After_Self {

    /*
        1 <= nums.length <= 10^5
        -10^4 <= nums[i] <= 10^4

        方法1，使用 二进制索引树，亦即树状数组

        先求出数组中的最小值，然后将所有的数都加上这个最小值，这样就可以保证所有的数都是正数了
        然后定义一个数组，长度是最大值加1，然后遍历数组，将每个数出现的次数记录到这个数组中
        然后遍历这个数组，将每个数的次数累加起来，这样就可以得到每个数的前缀和了

        这个前缀和就是大于 这个数 个数

        时间复杂度O(nlog(M−m))，空间复杂度 O(M−m) ，m和M分别是数组最小和最大值。
    */
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int n = nums.length;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // 先求出nums的最小值
        for (int num : nums) {
            min = Math.min(min, num);
        }

        // 向右平移成非负数
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= min;
            max = Math.max(max, nums[i]);
        }

        // 构造树状数组，第0位不用，所以长度为max + 1
        BIT bit = new BIT(max + 1);
        for (int i = n - 1; i >= 0; i--) {
            // 求出比nums[i]小的数的个数
            res.add(bit.sum(nums[i]));
            // 将数组的第nums[i] + 1个数增加1
            bit.add(nums[i] + 1, 1);
        }

        Collections.reverse(res);

        return res;
    }

    class BIT {

        int[] tree;

        // 对于长度为n的数组，构造其对应的树状数组
        public BIT(int n) {
            tree = new int[n + 1];
        }

        // 在原数组的第i个（i从1开始取）数上加上x，对应的树状数组的操作
        // 时间复杂度O(log(n))
        public void add(int i, int x) {
            while (i < tree.length) {
                tree[i] += x;
                i += lowBit(i);
            }
        }

        // 求原数组的前i个（i也是从1开始取）数的和
        // 时间复杂度O(log(n))
        public int sum(int i) {
            int res = 0;
            while (i > 0) {
                res += tree[i];
                i -= lowBit(i);
            }

            return res;
        }

        // 求x的最后一个1的位置
        // 时间复杂度O(1)
        private int lowBit(int x) {
            return x & -x;
        }
    }


    /*
    方法2

    这题实际上是在求以 每个位置为第一个数 的逆序对的个数是多少
    这题稍微复杂一些，它需要把每个位置的逆序对数量都求出来。
    可以先开一个数组e,
        e = [ 0 , 1 , 2 , . . . , n − 1 ]
        接着对 e 数组按照A[e[i]]来排序，即最后要使得:
            A[e[0]] ≤ A[e[1]] ≤ A[e[2]] ≤ . . . ≤ A[e[n−1]]

        这样在归并排序的过程中，我们就能不但知道每个位置的数值，还能知道它的下标，这样就方便统计每个位置的逆序对的数量了。

    归并排序
        时间复杂度O(nlog(n))，空间复杂度O(n)
        步骤：
            1. 对数组的下标进行归并排序，排序的依据是数组的值
            2. 在归并排序的过程中，统计逆序对的数量

    */
    public List<Integer> countSmaller2(int[] nums) {

        int n = nums.length;

        // cnt[i]是以nums[i]为第一个数的逆序对的数量
        // e 是待排序的数组
        int[] cnt = new int[n], e = new int[n];
        for (int i = 0; i < n; i++) {
            e[i] = i;
        }

        mergeSort(0, n - 1, cnt, e, nums, new int[n]);

        List<Integer> res = new ArrayList<>();
        for (int x : cnt) {
            res.add(x);
        }

        return res;
    }

    // 对idxs[l:r]按照nums[l:r]的大小关系来从小到大排序，并且累加这一段区间的逆序对数量。
    // 由于归并排序需要一个额外数组，tmp便是该数组
    private void mergeSort(int l, int r, int[] cnt, int[] e, int[] nums, int[] tmp) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l >> 1);
        mergeSort(l, mid, cnt, e, nums, tmp);
        mergeSort(mid + 1, r, cnt, e, nums, tmp);
        merge(l, r, mid, e, cnt, nums, tmp);
    }

    private void merge(int l, int r, int mid, int[] e, int[] cnt, int[] nums, int[] tmp) {
        int i = l, j = mid + 1, pos = l;

        while (i <= mid && j <= r) {
            // 如果nums[e[i]] <= nums[e[j]]，那么从mid + 1到j - 1都能与i产生逆序对，个数是j - mid - 1
            if (nums[e[i]] <= nums[e[j]]) {
                cnt[e[i]] += j - mid - 1;
                tmp[pos++] = e[i++];
            } else {
                tmp[pos++] = e[j++];
            }
        }

        while (i <= mid) {
            cnt[e[i]] += j - mid - 1;
            tmp[pos++] = e[i++];
        }
        while (j <= r) {
            tmp[pos++] = e[j++];
        }

        // 归并排序里要把数组从tmp里重新填回待排序数组e中
        for (int k = l; k <= r; k++) {
            e[k] = tmp[k];
        }
    }


    public static void main(String[] args) {

        L315_Count_of_Smaller_Numbers_After_Self s = new L315_Count_of_Smaller_Numbers_After_Self();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {5, 2, 6, 1};
        List<Integer> res = s.countSmaller2(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}