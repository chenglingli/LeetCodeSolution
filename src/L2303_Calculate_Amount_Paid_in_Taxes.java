public class L2303_Calculate_Amount_Paid_in_Taxes {

    public double calculateTax(int[][] brackets, int income) {

        double res = 0;

        for (int i = 0; i < brackets.length; i++) {
            if (income > brackets[i][0]) {
                if (i >= 1) {
                    res += (brackets[i][0] - brackets[i - 1][0]) * brackets[i][1] * 0.01;
                } else {
                    res += brackets[i][0] * brackets[i][1] * 0.01;
                }
            } else {
                if (i >= 1) {
                    res += (income - brackets[i - 1][0]) * brackets[i][1] * 0.01;
                } else {
                    res += income * brackets[i][1] * 0.01;
                }
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L2303_Calculate_Amount_Paid_in_Taxes s =
                new L2303_Calculate_Amount_Paid_in_Taxes();
        long sysDate1 = System.currentTimeMillis();

        //        int[][] brackets = {{3, 50}, {7, 10}, {12, 25}};
        int[][] brackets = {{1, 0}, {4, 25}, {5, 50}};
        int income = 2;
        double res = s.calculateTax(brackets, income);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}