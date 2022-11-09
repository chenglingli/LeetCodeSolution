import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class L1005_Maximize_Sum_Of_Array_After_K_Negations {

    // 小顶堆维护绝对值最大n个负数
    //
    public int largestSumAfterKNegations(int[] nums, int k) {

        int sum = 0;
        int count = 0;
        // 记录全局绝对值最小值
        int min = 101;
        // 记录小顶堆的总和
        int negativeSum = 0;

        // 小顶堆，存储绝对值最大的k个负数
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> (x - y));

        // 遍历数组，建立小顶堆，计算sum，计算min
        for (int num : nums) {
            sum += num;

            if (num < 0) {
                if (queue.size() < k) {
                    queue.offer(Math.abs(num));
                } else {
                    if (Math.abs(num) > queue.peek()) {
                        queue.poll();
                        queue.offer(Math.abs(num));
                    }
                }
                count++;
            }

            min = Math.min(min, Math.abs(num));
        }

        for (int x : queue) {
            negativeSum += x;
        }

        // 不存在负数
        if (count == 0) {
            if (k % 2 == 0) {
                return sum;
            } else {
                return sum - min * 2;
            }
        }

        // 存在负数
        if (count > k) {
            // 负数较多
            // 寻找绝对值最大的k个负数
            return sum + negativeSum * 2;
        } else {
            // 负数较少
            // 寻找最小的那个数字（含负数的绝对值）
            if (k - count % 2 == 0) {
                return sum + negativeSum * 2;
            } else {
                return sum + negativeSum * 2 - min * 2;
            }
        }
    }

    public int largestSumAfterKNegations2(int[] nums, int k) {

        int sum = 0;
        int[] arr = new int[201];

        // 正值散列化
        for (int j : nums) {
            arr[j + 100]++;
        }

        int max = -100;
        for (int i = 0; i < 100; i++) {
            if (arr[i] == 0)
                continue;
            int num = i - 100;
            max = Math.max(max, num);

            if (k > 0) {
                int min = Math.min(arr[i], k);
                sum += num * -min;
                k -= arr[i];
                arr[i] -= min;
            }
            sum += num * arr[i];
        }


        if (k % 2 == 0)
            k = 0;

        for (int i = 100; i < arr.length; i++) {
            if (arr[i] == 0)
                continue;
            int num = i - 100;
            if (k > 0) {
                if (num + max > 0) {
                    sum += 2 * max;
                } else {
                    sum -= num;
                    arr[i]--;
                }
                k = 0;
            }
            sum += arr[i] * num;
        }

        if (k > 0) {
            sum += 2 * max;
        }
        return sum;
    }


    // 排序做法，相对直观，但是需要排序
    // nlog(n) + k + n

    public int largestSumAfterKNegations3(int[] nums, int k) {

        Arrays.sort(nums);

        for (int i = 0; k > 0 && i < nums.length && nums[i] < 0; ++i, --k) {
            nums[i] = -nums[i];
        }

        int res = 0, min = Integer.MAX_VALUE;
        for (int a : nums) {
            res += a;
            min = Math.min(min, a);
        }
        return res - (k % 2) * min * 2;
    }

    public static void main(String[] args) {

        L1005_Maximize_Sum_Of_Array_After_K_Negations s = new L1005_Maximize_Sum_Of_Array_After_K_Negations();

        long sysDate1 = System.currentTimeMillis();

        int[] nums = {2, -3, -1, 5, -4};
        int k = 2;

        //        int[] nums = {3,-1,0,2};
        //        int k = 3;

        //        int [] nums = {-2,9,9,8,4};
        //        int k = 5;

        int res = s.largestSumAfterKNegations(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}