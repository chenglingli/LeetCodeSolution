public class L1342_Number_of_Steps_to_Reduce_a_Number_to_Zero {

    public int numberOfSteps(int num) {
        int cur = num;
        int count = 0;
        while (cur != 0) {
            if (cur % 2 == 0) {
                cur /= 2;
            } else {
                cur--;
            }
            count++;
        }
        return count;
    }


    public static void main(String[] args) {

        L1342_Number_of_Steps_to_Reduce_a_Number_to_Zero s = new L1342_Number_of_Steps_to_Reduce_a_Number_to_Zero();
        long sysDate1 = System.currentTimeMillis();

        int num = 100000;
        int res = s.numberOfSteps(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}