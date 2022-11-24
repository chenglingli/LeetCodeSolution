public class L415_Add_Strings {

    public String addStrings(String num1, String num2) {

        StringBuilder res = new StringBuilder("");

        int curry = 0;
        int i = 0;
        for (i = 0; i < num1.length() && i < num2.length(); i++) {

            char ch1 = num1.charAt(num1.length() - i - 1);
            char ch2 = num2.charAt(num2.length() - i - 1);

            int tempDigit = (ch1 - '0') + (ch2 - '0') + curry;
            curry = tempDigit / 10;
            tempDigit = tempDigit % 10;
            res.append(tempDigit);
        }

        while (i < num1.length()) {

            char ch1 = num1.charAt(num1.length() - i - 1);
            int tempDigit = (ch1 - '0') + curry;
            curry = tempDigit / 10;
            tempDigit = tempDigit % 10;
            res.append(tempDigit);

            i++;
        }

        while (i < num2.length()) {
            char ch2 = num2.charAt(num2.length() - i - 1);
            int tempDigit = (ch2 - '0') + curry;
            curry = tempDigit / 10;
            tempDigit = tempDigit % 10;
            res.append(tempDigit);

            i++;
        }

        if (curry > 0) {
            res.append(curry);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {

        L415_Add_Strings s = new L415_Add_Strings();
        long sysDate1 = System.currentTimeMillis();

        String num1 = "1";
        String num2 = "9";

        String res = s.addStrings(num1, num2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}