public class L504_Base_7 {

    public String convertToBase7(int num) {

        if (num == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();

        String negative = num < 0 ? "-" : "";
        num = Math.abs(num);
        while (num > 0) {
            int cur = num % 7;
            num = num / 7;
            res.append(cur);
        }

        res.append(negative);

        return res.reverse().toString();
    }

    public static void main(String[] args) {

        L504_Base_7 s = new L504_Base_7();
        long sysDate1 = System.currentTimeMillis();
        // int input = 101;
        int input = -7;

        String res = s.convertToBase7(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}