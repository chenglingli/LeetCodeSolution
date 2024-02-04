public class L2011_Final_Value_of_Variable_After_Performing_Operations {


    /*
    1 <= operations.length <= 100
    operations[i] will be either "++X", "X++", "--X", or "X--".
     */
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String cur : operations) {
            if (cur.charAt(1) == '+') {
                res++;
            } else {
                res--;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L2011_Final_Value_of_Variable_After_Performing_Operations s = new L2011_Final_Value_of_Variable_After_Performing_Operations();
        long sysDate1 = System.currentTimeMillis();

        String[] ops = {"++X", "++X", "X++"};
        int res = s.finalValueAfterOperations(ops);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}