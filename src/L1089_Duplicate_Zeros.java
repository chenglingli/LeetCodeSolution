import java.util.Arrays;

public class L1089_Duplicate_Zeros {

    public void duplicateZeros(int[] arr) {

        int l = arr.length;
        int[] copy = new int[l];

        int i = 0;
        int j = 0;

        while (i < l && j < l) {
            if (arr[i] != 0) {
                copy[j++] = arr[i++];
            } else {
                copy[j] = 0;
                if (j + 1 < l) {
                    copy[j + 1] = 0;
                }
                i++;
                j+=2;
            }
        }

        for (i = 0; i < l; i++) {
            arr[i] = copy[i];
        }

    }

    public static void main(String[] args) {

        L1089_Duplicate_Zeros s = new L1089_Duplicate_Zeros();

        long sysDate1 = System.currentTimeMillis();

        //                int[] arr = {1, 0, 2, 0, 3, 4};
        //        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        // {1, 0, 0, 2, 3, 0, 0, 4};
                int[] arr = {8, 4, 5, 0, 0, 0, 0, 7};
//        int[] arr = {1, 1, 0, 0, 0};

        s.duplicateZeros(arr);

        System.out.println(Arrays.toString(arr));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}