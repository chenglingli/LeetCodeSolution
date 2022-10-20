public class L917_Reverse_Only_Letters {


    /*
     *
     * Input: s = "Test1ng-Leet=code-Q!"
     * Output: "Qedo1ct-eeLg=ntse-T!"
     */

    public String reverseOnlyLetters(String s) {

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (!(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'
                    || s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    && i < j) {
                left.append(s.charAt(i));
                i++;
            }

            while (!(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z'
                    || s.charAt(j) >= 'a'
                    && s.charAt(j) <= 'z') && i < j) {
                right.append(s.charAt(j));
                j--;
            }

            if (i < j) {
                left.append(s.charAt(j));
                right.append(s.charAt(i));
                i++;
                j--;
            }
        }

        if (i == j) {
            right.append(s.charAt(i));
        }

        return left.append(right.reverse()).toString();
    }

    public static void main(String[] args) {

        L917_Reverse_Only_Letters s = new L917_Reverse_Only_Letters();

        long sysDate1 = System.currentTimeMillis();

        //        String input = "Test1ng-Leet=code-Q!";
        String input = "7_28]";

        String res = s.reverseOnlyLetters(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}