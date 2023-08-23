public class L2119_A_Number_After_a_Double_Reversal {

    /*
    0 <= num <= 106

    123

    1230
    0
    1
    1002
     */
    public boolean isSameAfterReversals(int num) {

        if (num == 0) {
            return true;
        }

        if (num % 10 == 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        L2119_A_Number_After_a_Double_Reversal s = new L2119_A_Number_After_a_Double_Reversal();
        long sysDate1 = System.currentTimeMillis();

        int num = 526;
        boolean res = s.isSameAfterReversals(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}