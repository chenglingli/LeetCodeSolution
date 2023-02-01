public class L1539_Kth_Missing_Positive_Number {


    /*
    1 <= arr.length <= 1000

    1 <= arr[i] <= 1000
    1 <= k <= 1000

    arr[i] < arr[j] for 1 <= i < j <= arr.length

    Could you solve this problem in less than O(n) complexity?

    解法：
        两个数组齐驱并驾，寻找在第二个数组却不在第一个数组的第k个元素
        如果第一个数组走到头，则直接计算出第k个元素（ cur + k - count）

     */
    public int findKthPositive(int[] arr, int k) {

        int x1 = 0;
        int x2 = 1;
        int count = 0;

        while (count < k) {

            if (x1 < arr.length) {
                while (x2 < arr[x1] && count < k) {
                    x2++;
                    count++;
                }
            } else {
                x2 = x2 + (k - count);
                count = k;
            }

            if (count == k) {
                return x2 - 1;
            }

            x1++;
            x2++;
        }

        return x2 - 1;
    }

    public static void main(String[] args) {

        L1539_Kth_Missing_Positive_Number s =
                new L1539_Kth_Missing_Positive_Number();
        long sysDate1 = System.currentTimeMillis();

        int[] indices = {2, 3, 4, 7, 11};

        //        int res = s.findKthPositive(indices, 8);
        //        System.out.println(res);

        for (int i = 1; i < 10; i++) {
            int res = s.findKthPositive(indices, i);
            System.out.println(res);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}