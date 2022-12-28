import java.util.Arrays;
import java.util.Comparator;

public class L1356_Sort_Integers_by_The_Number_of_1_Bits {


    public int[] sortByBits(int[] arr) {

        Integer[] arrCopy = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrCopy[i] = arr[i];
        }

        Arrays.sort(arrCopy, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                } else {
                    int t1 = countOne(o1);
                    int t2 = countOne(o2);
                    if (t1 != t2) {
                        return t1 - t2;
                    } else {
                        return o1 - o2;
                    }
                }
            }

        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrCopy[i];
        }

        return arr;
    }

    public int[] sortByBits2(int[] arr) {
        int val = 10001;
        for (int i = 0; i < arr.length; i++)
            arr[i] += Integer.bitCount(arr[i]) * val;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++)
            arr[i] %= val;

        return arr;
    }

    private int countOne(int x) {
        int res = 0;
        while (x > 0) {
            res += x % 2;
            x /= 2;
        }
        return res;
    }


    public static void main(String[] args) {

        L1356_Sort_Integers_by_The_Number_of_1_Bits s = new L1356_Sort_Integers_by_The_Number_of_1_Bits();
        long sysDate1 = System.currentTimeMillis();

        int[] arr = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        int[] res = s.sortByBits(arr);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}