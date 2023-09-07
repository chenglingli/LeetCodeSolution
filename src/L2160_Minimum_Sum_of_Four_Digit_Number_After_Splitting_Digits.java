import java.util.Arrays;

public class L2160_Minimum_Sum_of_Four_Digit_Number_After_Splitting_Digits {

    public int minimumSum(int num) {

        int [] digitList = new int[4];
        digitList[0] = num / 1000;
        digitList[1] = (num / 100) % 10;
        digitList[2] = (num / 10) % 10;
        digitList[3] = num % 10;

        Arrays.sort(digitList);

        int a = digitList[0] * 10 + digitList[2];
        int b = digitList[1] * 10 + digitList[3];

        return a + b;
    }

    public static void main(String[] args) {

        L2160_Minimum_Sum_of_Four_Digit_Number_After_Splitting_Digits s =
                new L2160_Minimum_Sum_of_Four_Digit_Number_After_Splitting_Digits();
        long sysDate1 = System.currentTimeMillis();

//        int nums = 2293;
        int nums = 1007;
        int res = s.minimumSum(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}