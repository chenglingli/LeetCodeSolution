public class L2169_Count_Operations_to_Obtain_Zero {

    /*
    0 <= num1, num2 <= 10^5

    100 3
    97 3
    ...
    4 3

    1 3
    1 2
    1 1
    0 1


    100 90
    10 90
    。。。
    10 20
    10 10
    0 10


    10 3
    7 3
    4 3
    1 3
    1 2
    1 1
    0

     */
    public int countOperations(int num1, int num2) {

        int count = 0;

        while (num1 > 0 && num2 > 0) {

            // 保持 num1 >= num2
            if (num1 < num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }

            if (num1 / num2 > 1) {
                // 二者差距过大时，快速累加
                int temp = num1 % num2;
                count += num1 / num2;
                num1 = temp;
            } else {
                // 二者差距不大时，一步操作
                num1 = num1 - num2;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        L2169_Count_Operations_to_Obtain_Zero s =
                new L2169_Count_Operations_to_Obtain_Zero();
        long sysDate1 = System.currentTimeMillis();

        int num1 = 10;
        int num2 = 9;
        int res = s.countOperations(num1, num2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}