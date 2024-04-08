import java.util.*;

public class L347_Top_K_Frequent_Elements {

    /*
    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.

    普通解法，统计频率，找最大的k个
    24ms
     */
    public int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];

        // 统计频率
        int[] freq = new int[20001];
        for (int num : nums) {
            freq[num + 10000]++;
        }

        // 找最大的k个
        for (int i = 0; i < k; i++) {

            int max = 0;
            for (int j = 1; j < freq.length; j++) {
                if (freq[j] > freq[max]) {
                    max = j;
                }
            }

            res[i] = max - 10000;
            freq[max] = 0;
        }

        return res;
    }

    /*
    使用堆排序，排序基于频次
    初次：4ms

     */
    public int[] topKFrequent2(int[] nums, int k) {

        int[] res = new int[k];

        // 找最大值和最小值
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }

        // 统计频次
        int len = max - min + 1;
        int[] freq = new int[len];
        for (int num : nums) {
            freq[num - min]++;
        }

        // 找最大的k个，使用堆排序，最大的k个，使用小顶堆
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(numComparator);

        // 加入小顶堆
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                continue;
            }

            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(freq[i]);
            minHeap.add(temp);

            // 如果堆的大小大于k，弹出堆顶元素（最小的那个）
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int i = 0;
        for (List<Integer> x : minHeap) {
            res[i++] = x.get(0) + min;
        }

        return res;
    }

    private Comparator<List<Integer>> numComparator = new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> s1, List<Integer> s2) {
            return s1.get(1) - s2.get(1);
        }
    };

    /*
    14 ms
     */
    public int[] topKFrequent3(int[] nums, int k) {

        // 返回结果
        int[] res = new int[k];

        // 统计频率
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 找最大的k个，使用堆排序，最大的k个，使用小顶堆
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(numComparator3);

        // 加入小顶堆
        for (Map.Entry<Integer, Integer> x : freqMap.entrySet()) {

            List<Integer> temp = new ArrayList<>();
            temp.add(x.getKey());
            temp.add(x.getValue());
            minHeap.add(temp);

            // 如果堆的大小大于k，弹出堆顶元素（最小的那个）
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int i = 0;
        for (List<Integer> x : minHeap) {
            res[i++] = x.get(0);
        }

        return res;
    }

    private Comparator<List<Integer>> numComparator3 = new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> s1, List<Integer> s2) {
            return s1.get(1) - s2.get(1);
        }
    };


    /*
    最优解！
    2ms
     */
    public int[] topKFrequent4(int[] nums, int k) {

        // 返回体
        int[] output = new int[k];

        // 找最大值和最小值
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }

        // 统计频次
        int maxUniqueValues = max - min + 1;
        int[] frequencies = new int[maxUniqueValues];
        for (int num : nums) {
            frequencies[num - min]++;
        }

        // 转化频次数组 为 排序数组
        // 数组的index == 频次，数组的值 == 对应的数字
        // 譬如， 1 1 1 2 2 3 4
        // 频次数组为
        //  0  1       2  3  4
        // [0, {3, 4}, 2, 1, 0]
        List<Integer>[] sortedFrequencies = new ArrayList[nums.length + 1];
        for (int i = 0; i < frequencies.length; i++) {
            if (sortedFrequencies[frequencies[i]] == null) {
                sortedFrequencies[frequencies[i]] = new ArrayList<Integer>();
            }
            sortedFrequencies[frequencies[i]].add(i + min);
        }

        // 从后往前遍历，直到找到k个最高频次的数字
        int index = 0;
        for (int j = sortedFrequencies.length - 1; j >= 0; j--) {
            if (sortedFrequencies[j] == null) {
                continue;
            }
            if (k == 0) {
                break;
            }

            for (Integer eachInput : sortedFrequencies[j]) {
                output[index++] = eachInput;
                k--;
                if (k == 0)
                    break;
            }

        }

        // 返回结果
        return output;
    }


    public static void main(String[] args) {

        L347_Top_K_Frequent_Elements s = new L347_Top_K_Frequent_Elements();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 1;
        int[] res = s.topKFrequent2(nums, k);

        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}