public class L1385_Find_the_Distance_Value_Between_Two_Arrays {


    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int count = 0;
        for (int k : arr1) {

            int j = 0;
            for (; j < arr2.length; j++) {
                if (Math.abs(k - arr2[j]) <= d) {
                    break;
                }
            }
            if (j == arr2.length) {
                count++;
            }

        }

        return count;
    }

    /*
    -1000 <= arr1[i], arr2[j] <= 1000
    1 <= arr1.length, arr2.length <= 500
     */

    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {

        int[] counts = new int[2001];
        for (int a2 : arr2) {
            counts[a2 + 1000]++;
        }

        //d = 5
        //a1 = 20 => a2 != 15..25
        int total = 0;
        for (int a1 : arr1) {

            int from = Math.max(0, a1 - d + 1000);
            int to = Math.min(a1 + d + 1000, 2000);

            boolean found = false;
            for (int i = from; i <= to; i++) {
                if (counts[i] > 0) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                total++;
            }
        }
        return total;

    }

    public static void main(String[] args) {

        L1385_Find_the_Distance_Value_Between_Two_Arrays s = new L1385_Find_the_Distance_Value_Between_Two_Arrays();
        long sysDate1 = System.currentTimeMillis();

        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int d = 2;

        int res = s.findTheDistanceValue(arr1, arr2, d);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}