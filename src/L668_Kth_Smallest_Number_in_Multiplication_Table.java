public class L668_Kth_Smallest_Number_in_Multiplication_Table {

    /**
     *
     Nearly every one have used the Multiplication Table.
     But could you find out the k-th smallest number quickly from the multiplication table?

     Given the height m and the length n of a m * n Multiplication Table,
     and a positive integer k, you need to return the k-th smallest number in this table.

     Example 1:
     Input: m = 3, n = 3, k = 5
     Output:
     Explanation:
     The Multiplication Table:
     1	2	3
     2	4	6
     3	6	9

     The 5-th smallest number is 3 (1, 2, 2, 3, 3).
     Example 2:
     Input: m = 2, n = 3, k = 6
     Output:
     Explanation:
     The Multiplication Table:
     1	2	3
     2	4	6

     The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
     Note:
     The m and n will be in the range [1, 30000].
     The k will be in the range [1, m * n]
     */


    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;

        while (left < right) {
            int mid = left + (right - left) / 2, cnt = 0;
            for (int i = 1; i <= m; i++) {
                cnt += (mid > n * i) ? n : (mid / i);
            }

            if (cnt < k)
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }

    public int findKthNumber2(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2, cnt = 0, i = m, j = 1;
            while (i >= 1 && j <= n) {
                if (mid >= i * j) {
                    cnt += i;
                    ++j;
                } else {
                    --i;
                }
            }
            if (cnt < k)
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }

    public int findKthNumber3(int m, int n, int k) {
        int left = 1, right = m * n;

        while (left < right) {
            int mid = left + (right - left) / 2, cnt = 0, i = m, j = 1;

            while (i >= 1 && j <= n) {
                int t = j;
                j = (mid > n * i) ? n + 1 : (mid / i + 1);
                cnt += (j - t) * i;
                i = mid / j;
            }

            if (cnt < k)
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }

    public static void main(String[] args) {

        L668_Kth_Smallest_Number_in_Multiplication_Table s = new L668_Kth_Smallest_Number_in_Multiplication_Table();
        long sysDate1 = System.currentTimeMillis();

        int res = s.findKthNumber(3, 3, 5);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}