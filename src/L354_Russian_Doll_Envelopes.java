import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class L354_Russian_Doll_Envelopes {

    /**
     * You have a number of envelopes with widths and heights given as a
     * pair of integers (w, h). One envelope can fit into another
     * if and only if both the width and height of one envelope
     * is greater than the width and height of the other envelope.
     * <p>
     * What is the maximum number of envelopes can you Russian doll?
     * (put one inside other)
     * <p>
     * Example:
     * Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of
     * envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
     */

    public int maxEnvelopes2(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0)
            return 0;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                else return a[1] - b[1];
            }
        });

        int max = 1;
        int[] arr = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            arr[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0]
                        && envelopes[i][1] > envelopes[j][1]) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    public int maxEnvelopes(int[][] envelopes) {

        Comparator c = Comparator.comparing((int[] arr) -> arr[0])
                .thenComparing((int[] arr) -> arr[1], Comparator.reverseOrder());
        Arrays.sort(envelopes, c);

        ArrayList<Integer> list = new ArrayList<>();

        for (int[] arr : envelopes) {
            int target = arr[1];

            if (list.isEmpty() || target > list.get(list.size() - 1)) {
                list.add(target);
            } else {
                int i = 0;
                int j = list.size() - 1;

                while (i < j) {
                    int m = i + (j - i) / 2;
                    if (list.get(m) >= target) {
                        j = m;
                    } else {
                        i = m + 1;
                    }
                }

                list.set(j, target);
            }
        }

        return list.size();
    }

    /**
     * We can sort the envelopes by height in ascending order and width in descending order. Then look at the
     * width and find the longest increasing subsequence.
     * This problem is then converted to the problem of finding Longeset Increasing Subsequence.
     */
    public int maxEnvelopes3(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;

        // sort the width increasing order and height in decreasing order
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });

        // store the increasing heights
        int len = 0;

        int[] dp = new int[envelopes.length];

        for (int[] e : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, e[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = e[1];
            if (index == len) {
                len++;
            }
        }

        return len;
    }


    public static void main(String[] args) {

        L354_Russian_Doll_Envelopes s = new L354_Russian_Doll_Envelopes();
        long sysDate1 = System.currentTimeMillis();

        int[][] matrix = {{1, 1}};
        // int[][] matrix = {{1, 3}, {3, 5}, {6, 7}, {6, 8}, {8, 4}, {9, 5}};
        // int[][] matrix = {{5,4},{6,4},{6,7},{2,3}};
        int res2 = s.maxEnvelopes(matrix);
        System.out.println(res2);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}