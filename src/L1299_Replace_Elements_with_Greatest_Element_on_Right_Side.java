import java.util.Arrays;

public class L1299_Replace_Elements_with_Greatest_Element_on_Right_Side {

    public int[] replaceElements(int[] arr) {

        int n = arr.length;
        int[] maxValue = new int[n];
        int curMax = -1;

        for (int i = n - 1; i >= 1; i--) {
            curMax = Math.max(arr[i], curMax);
            maxValue[i - 1] = curMax;
        }

        maxValue[n - 1] = -1;

        return maxValue;
    }

    public static void main(String[] args) {

        L1299_Replace_Elements_with_Greatest_Element_on_Right_Side s = new L1299_Replace_Elements_with_Greatest_Element_on_Right_Side();
        long sysDate1 = System.currentTimeMillis();

//        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] arr = {17};
        int[] res = s.replaceElements(arr);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}