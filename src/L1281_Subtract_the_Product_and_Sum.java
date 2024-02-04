public class L1281_Subtract_the_Product_and_Sum {

    public int subtractProductAndSum(int n) {

        if (n <= 9) {
            return 0;
        }

        int copy = n;
        int sum = 0;
        int product = 1;
        while (copy > 0) {
            int temp = copy % 10;
            sum += temp;
            product *= temp;
            copy /= 10;
        }
        return product - sum;
    }

    public static void main(String[] args) {

        L1281_Subtract_the_Product_and_Sum s = new L1281_Subtract_the_Product_and_Sum();
        long sysDate1 = System.currentTimeMillis();

        int input = 114;
        int res = s.subtractProductAndSum(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}