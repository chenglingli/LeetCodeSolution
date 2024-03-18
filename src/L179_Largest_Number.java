import java.util.Arrays;
import java.util.Comparator;

public class L179_Largest_Number {

    /*
    按照各位数字大值排列，然后拼接
     */
    public String largestNumber(int[] nums) {

        Integer[] arrCopy = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arrCopy[i] = nums[i];
        }

        // 字符串比较
        /*
        5 和 34 比
        a = 5
        b = 34
        s1 = 534
        s2 = 345
        s2.compareTo(s1) = -1
        所以 5 在前
         */
//        Arrays.sort(arrCopy, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                String s1 = o1 + "" + o2;
//                String s2 = o2 + "" + o1;
//                return s2.compareTo(s1);
//            }
//        });

        // 数字比较
        /*
        5 和 34 比
        a = 5
        b = 34

        ax = 10
        bx = 100

        (b * ax + a) - (a * bx + b) =
        (34 * 10 + 5) - (5 * 100 + 34) =
        (340 + 5) - (500 + 34) =
        -155

        所以 5 在前

         */
        Arrays.sort(arrCopy, (a, b) -> {
            int ax = 10, bx = 10;
            while (ax <= a)
                ax *= 10;
            while (bx <= b)
                bx *= 10;
            return (int) ((b * ax + a) - (a * bx + b));
        });

        if (arrCopy[0] == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arrCopy) {
            sb.append(num);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        L179_Largest_Number s = new L179_Largest_Number();

        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 30, 34, 5, 9};
        String res = s.largestNumber(nums);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}