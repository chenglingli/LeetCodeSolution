public class L258_Add_Digits {

    public int addDigits(int num) {

        while (num >= 10) {
            int tempSum = 0;

            while (num > 0) {
                tempSum += num % 10;
                num /= 10;
            }

            num = tempSum;
        }


        return num;
    }

    public int addDigits2(int num) {
        //get digital root: 数根能被3或9整除，则原来的数也能被3或9整除。
        //一个数的digital root就是num % 9
        if (num == 0) {
            return 0;
        }
        if (num % 9 == 0) {
            return 9;
        }

        return num % 9;
    }

    public static void main(String[] args) {

        L258_Add_Digits s = new L258_Add_Digits();
        long sysDate1 = System.currentTimeMillis();

        int res = s.addDigits(38);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}