import java.util.Comparator;
import java.util.PriorityQueue;

public class L378_Kth_Smallest_Element_in_a_Sorted_Matrix {

    /**
     * Given a n x n matrix where each of the rows and columns are
     * sorted in ascending order,
     * find the kth smallest element in the matrix.
     * <p>
     * Note that it is the kth smallest element in the sorted order,
     * not the kth distinct element.
     * <p>
     * Example:
     * <p>
     * matrix = [
     * [ 1,  5,  9],
     * [10, 11, 13],
     * [12, 13, 15]
     * ],
     * k = 8,
     * <p>
     * return 13.
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ n2.
     */

    public int kthSmallest2(int[][] matrix, int k) {

        int N = matrix.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(numComparator);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                priorityQueue.add(matrix[i][j]);
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
        }
        return priorityQueue.peek();
    }

    private Comparator<Integer> numComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer s1, Integer s2) {
            return s2 - s1;
        }
    };


    public int kthSmallest(int[][] matrix, int k) {

        int N = matrix.length, left = matrix[0][0], right = matrix[N - 1][N - 1];

        while (left < right) {
            int mid = (left + right) / 2;
            int count = searchLessEqual(matrix, mid);
            if (count < k) left = mid + 1;
            else right = mid;

        }
        return left;
    }

    // 查找 <= t 的元素个数
    int binarySearch(int[] list, int t) {

        if (t > list[list.length - 1]) return list.length;
        if (t < list[0]) return 0;

        int left = 0;
        int right = list.length - 1;
        if (t == 40) {
            System.out.println("\n");
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (list[mid] <= t) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (list[left] == t) {
            return left + 1;
        } else {
            return left;
        }
    }

    // 查找 <= t 的元素个数
    int searchLessEqual(int[][] matrix, int target) {
        int n = matrix.length, i = n - 1, j = 0, res = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= target) {
                res += i + 1;
                ++j;
            } else {
                --i;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        L378_Kth_Smallest_Element_in_a_Sorted_Matrix s = new L378_Kth_Smallest_Element_in_a_Sorted_Matrix();
        long sysDate1 = System.currentTimeMillis();

        int[][] matrix = {
                {2, 6, 6, 7, 10, 14, 18},
                {6, 11, 14, 14, 15, 20, 23},
                {11, 11, 17, 21, 25, 30, 30},
                {11, 12, 20, 25, 25, 35, 37},
                {16, 16, 20, 29, 34, 35, 39},
                {16, 18, 22, 33, 37, 37, 40},
                {17, 23, 26, 36, 38, 41, 42}
        };

        for (int i = 1; i <= 49; i++) {
            int res2 = s.kthSmallest2(matrix, i);
            int res = s.kthSmallest(matrix, i);
            if (res2 != res) {
                System.out.println("i:" + i + ": " + res2 + " " + res);
            }
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}