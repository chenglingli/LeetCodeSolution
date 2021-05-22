public class PlusOne {

    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;

        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] > 9) {
                digits[i] = digits[i] % 10;
                digits[i - 1] += 1;
            }
        }

        if (digits[0] == 10) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i <= digits.length; i++) {
                newDigits[i] = 0;
            }
            return newDigits;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {

        PlusOne s = new PlusOne();

        long sysDate1 = System.currentTimeMillis();

        //int [] digits = {1, 2, 3};
        int[] digits = {9, 9, 9};
        int[] res = s.plusOne(digits);
        for (int i = 0; i < res.length; i++) System.out.println(res[i]);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}