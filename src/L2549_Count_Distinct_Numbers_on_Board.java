public class L2549_Count_Distinct_Numbers_on_Board {

    public int distinctIntegers(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n - 1;
        }
    }

    public static void main(String[] args) {

        L2549_Count_Distinct_Numbers_on_Board s = new L2549_Count_Distinct_Numbers_on_Board();
        long sysDate1 = System.currentTimeMillis();

        int num = 10;
        int res = s.distinctIntegers(num);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}