import java.util.Arrays;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {

        int i = 0, j = A.length - 1;

        while (i < j) {

            while (i < j && A[i] % 2 == 0) {
                i++;
            }

            while (j > i && A[j] % 2 != 0) {
                j--;
            }

            // swap a[i] a[j]
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;

        }
        return A;
    }

    public static void main(String[] args) {

        SortArrayByParity s = new SortArrayByParity();

        long sysDate1 = System.currentTimeMillis();
        // int [] nums = {2, 5, 4, 8, 10, 9, 15};
        // int [] nums = {3,1,2,4};
        int[] nums = {2, 1};
        int[] res = s.sortArrayByParity(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}