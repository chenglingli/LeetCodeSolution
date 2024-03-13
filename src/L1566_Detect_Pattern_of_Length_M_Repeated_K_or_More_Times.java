import java.util.Arrays;

public class L1566_Detect_Pattern_of_Length_M_Repeated_K_or_More_Times {


    /*
    2 <= arr.length <= 100
    1 <= arr[i] <= 100
    1 <= m <= 100
    2 <= k <= 100
     */
    public boolean containsPattern(int[] arr, int m, int k) {

        for (int i = 0; i < arr.length - m; i++) {

            int[] currentArray = Arrays.copyOfRange(arr, i, i + m);

            int repeat = 1;

            for (int j = i + m; j < arr.length; j += m) {

                int[] nextArray = Arrays.copyOfRange(arr, j, j + m);

                if (Arrays.equals(currentArray, nextArray)) {
                    repeat += 1;
                } else {
                    break;
                }

                if (repeat >= k) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        L1566_Detect_Pattern_of_Length_M_Repeated_K_or_More_Times s =
                new L1566_Detect_Pattern_of_Length_M_Repeated_K_or_More_Times();
        long sysDate1 = System.currentTimeMillis();

        int[] arr = {1, 2, 1, 2, 1, 3, 1, 2, 1};
        int m = 2;
        int k = 3;
        boolean res = s.containsPattern(arr, m, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}