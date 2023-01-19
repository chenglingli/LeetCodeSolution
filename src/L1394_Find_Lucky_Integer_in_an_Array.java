public class L1394_Find_Lucky_Integer_in_an_Array {


    /*
    1 <= arr.length <= 500
    1 <= arr[i] <= 500
     */
    public int findLucky(int[] arr) {
        int[] valueCount = new int[501];

        int maxValue = -1;
        for (int j : arr) {
            valueCount[j]++;
            maxValue = Math.max(maxValue, j);
        }

        for (int i = maxValue; i >= 1; i--) {
            if (valueCount[i] == i) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        L1394_Find_Lucky_Integer_in_an_Array s = new L1394_Find_Lucky_Integer_in_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] arr1 = {1, 2, 2, 3, 3, 3};

        int res = s.findLucky(arr1);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}