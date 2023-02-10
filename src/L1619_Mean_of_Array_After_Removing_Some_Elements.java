import java.util.PriorityQueue;
import java.util.Queue;

public class L1619_Mean_of_Array_After_Removing_Some_Elements {


    /*
    20 <= arr.length <= 1000
    arr.length is a multiple of 20.
    0 <= arr[i] <= 105

    return the mean of the remaining integers
        after removing the smallest 5% and the largest 5% of the elements.
     */
    public double trimMean(int[] arr) {

        // 小顶堆，存储最大的k个负数
        Queue<Integer> smallQueue = new PriorityQueue<>((x, y) -> (x - y));

        // 大顶堆，存储最小的k个负数
        Queue<Integer> bigQueue = new PriorityQueue<>((x, y) -> (y - x));

        int n = arr.length;
        int k = (int) (n * 0.05);
        int sum = 0;
        int deduct = 0;

        for (int cur : arr) {

            sum += cur;

            if (smallQueue.size() < k) {
                smallQueue.offer(Math.abs(cur));
                deduct += cur;
            } else {
                if (cur > smallQueue.peek()) {
                    int tmp = smallQueue.poll();
                    smallQueue.offer(cur);
                    deduct -= tmp;
                    deduct += cur;
                }
            }

            if (bigQueue.size() < k) {
                bigQueue.offer(Math.abs(cur));
                deduct += cur;
            } else {
                if (cur < bigQueue.peek()) {
                    int tmp = bigQueue.poll();
                    bigQueue.offer(cur);
                    deduct -= tmp;
                    deduct += cur;
                }
            }
        }

        return (sum - deduct) / (n * 0.9);
    }


    public double trimMean2(int[] arr) {

        int fivePerLen = arr.length * 5 / 100;

        quickSelect(arr, fivePerLen - 1, arr.length - 1, 0);
        quickSelect(arr, arr.length - fivePerLen - 1, arr.length - 1, fivePerLen);

        double totalSum = 0.0;
        for (int i = fivePerLen; i < arr.length - fivePerLen; i++) {
            totalSum += arr[i];
        }

        return totalSum / (arr.length - (fivePerLen * 2));
    }

    public void quickSelect(int[] arr, int target, int hi, int lo) {
        int pos = partialSort(arr, hi, lo);
        if (pos > target) {
            quickSelect(arr, target, pos - 1, lo);
        } else if (pos < target) {
            quickSelect(arr, target, hi, pos + 1);
        }
    }

    public int partialSort(int[] arr, int hi, int lo) {
        int pivotVal = arr[hi];
        int pivot = hi;

        while (lo <= hi) {
            if (arr[hi] < pivotVal) {
                swap(arr, lo, hi);
                lo++;
            } else {
                hi--;
            }
        }
        swap(arr, lo, pivot);
        return lo;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        L1619_Mean_of_Array_After_Removing_Some_Elements s = new L1619_Mean_of_Array_After_Removing_Some_Elements();
        long sysDate1 = System.currentTimeMillis();

        int[] prices = {6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0};
        double res = s.trimMean(prices);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}