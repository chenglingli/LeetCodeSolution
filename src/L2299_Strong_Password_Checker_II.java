public class L2299_Strong_Password_Checker_II {

    /*
    It has at least 8 characters.
    It contains at least one lowercase letter.
    It contains at least one uppercase letter.
    It contains at least one digit.
    It contains at least one special character.
        The special characters are the characters in the following string:
            "!@#$%^&*()-+".

    It does not contain 2 of the same character in adjacent positions
     */
    public boolean strongPasswordCheckerII(String password) {

        if (password.length() < 8) {
            return false;
        }

        String specialString = "!@#$%^&*()-+";
        boolean existLower = false;
        boolean existUpper = false;
        boolean existDigit = false;
        boolean existSpec = false;

        for (int i = 0; i < password.length(); i++) {

            if (!existLower) {
                if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') existLower = true;
            }

            if (!existUpper) {
                if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') existUpper = true;
            }

            if (!existDigit) {
                if (password.charAt(i) >= '0' && password.charAt(i) <= '9') existDigit = true;
            }

            if (!existSpec) {
                if (specialString.indexOf(password.charAt(i)) != -1) existSpec = true;
            }

            if (i >= 1) {
                if (password.charAt(i) == password.charAt(i - 1)) return false;
            }
        }

        return existLower && existUpper && existDigit && existSpec;
    }

    public static void main(String[] args) {

        L2299_Strong_Password_Checker_II s =
                new L2299_Strong_Password_Checker_II();
        long sysDate1 = System.currentTimeMillis();

        String password = "Me+You--IsMyDream";
        boolean res = s.strongPasswordCheckerII(password);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}