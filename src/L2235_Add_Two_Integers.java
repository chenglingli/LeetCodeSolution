public class L2235_Add_Two_Integers {

    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {

        L2235_Add_Two_Integers s =
                new L2235_Add_Two_Integers();
        long sysDate1 = System.currentTimeMillis();

        int num1 = 1;
        int num2 = 2;
        int res = s.sum(num1, num2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}