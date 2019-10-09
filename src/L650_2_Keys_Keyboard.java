public class L650_2_Keys_Keyboard {

    /**
     Initially on a notepad only one character 'A' is present.
     You can perform two operations on this notepad for each step:

     Copy All: You can copy all the characters present on the
     notepad (partial copy is not allowed).
     Paste: You can paste the characters which are copied last time.


     Given a number n. You have to get exactly n 'A' on the
     notepad by performing the minimum number of steps permitted.
     Output the minimum number of steps to get n 'A'.

     Example 1:

     Input: 3
     Output: 3
     Explanation:
     Intitally, we have one character 'A'.
     In step 1, we use Copy All operation.
     In step 2, we use Paste operation to get 'AA'.
     In step 3, we use Paste operation to get 'AAA'.


     Note:

     The n will be in the range [1, 1000].
     */

    public int minSteps(int n) {

        if (n == 1) return 0;
        if (n == 2) return 2;

        int factor = findFactor(n);

        if (factor == 0) return n;
        else return minSteps(n / factor) + factor;
    }

    int findFactor(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) return i;
        }

        return 0;
    }

    public static void main(String[] args) {

        L650_2_Keys_Keyboard s = new L650_2_Keys_Keyboard();
        long sysDate1 = System.currentTimeMillis();

        int res = s.minSteps(9);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}