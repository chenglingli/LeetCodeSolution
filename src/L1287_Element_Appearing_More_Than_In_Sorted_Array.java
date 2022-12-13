public class L1287_Element_Appearing_More_Than_In_Sorted_Array {

    public int findSpecialInteger(int[] arr) {

        int count = 0;
        int i = 0;
        int pre = arr[i];
        while (i < arr.length) {

            if (i == 0 || arr[i] != pre) {
                count = 1;
            } else {
                count++;

                if (count > arr.length / 4.0) {
                    return arr[i];
                }
            }

            pre = arr[i];
            i++;
        }

        return arr[i - 1];
    }

    private int lower(int[] arr, int val) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int upper(int[] arr, int val) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r - 1;
    }

    public int findSpecialInteger2(int[] arr) {
        int n = arr.length;
        for (int i = n / 4; i < n; i += n / 4) {
            for (int d = -2; d <= 2; d++) {
                int pos = i + d;
                if (pos >= 0 && pos < n) {
                    int l = lower(arr, arr[pos]), r = upper(arr, arr[pos]);
                    int total = r - l + 1;
                    if (total * 4 > n) {
                        return arr[pos];
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        L1287_Element_Appearing_More_Than_In_Sorted_Array s = new L1287_Element_Appearing_More_Than_In_Sorted_Array();
        long sysDate1 = System.currentTimeMillis();

        //        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] arr = {1, 1, 2, 2, 3, 3, 3, 3};
        int res = s.findSpecialInteger(arr);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}