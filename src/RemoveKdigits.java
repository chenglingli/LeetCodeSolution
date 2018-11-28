
/*
Given a non-negative integer num represented as a string,
remove k digits from the number so that the new number
is the smallest possible.

*/


public class RemoveKdigits {


    public String removeKdigits(String num, int k) {

        if (k == 0) {
            return num;
        }
        if (k >= num.length()) {
            return "0";
        }

        StringBuilder numNew = new StringBuilder(num);

        // from left to right
        // remove all digits before the 0 when indexOfZero <= k
        int index = numNew.indexOf("0");
        while (index != -1 && index <= k) {
            k = k - index;
            numNew.delete(0, index + 1);

            // delete leading zeros
            while (numNew.length() > 0 && numNew.charAt(0) == '0')
                numNew.deleteCharAt(0);

            index = numNew.indexOf("0");
        }

        // now for the remaining k times, remove any occurrence of
        // str[i]>str[i+1]
        while (k > 0) {
            int i = 0;
            while (i < numNew.length() - 1 && numNew.charAt(i) <= numNew.charAt(i + 1)) {
                i++;
            }
            numNew.deleteCharAt(i);
            k--;
        }

        // delete leading zeroes
        while (numNew.length() > 0 && numNew.charAt(0) == '0') {
            numNew.deleteCharAt(0);
        }

        return numNew.toString().equals("") ? "0" : numNew.toString();
    }

    public String removeKdigits1(String num, int k) {

        String numNew = num;
        int j = 0;
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;

            for (; j < numNew.length() - 1; j++) {
                if (numNew.charAt(j) > numNew.charAt(j + 1)) {
                    numNew = numNew.substring(0, j) + numNew.substring(j + 1, numNew.length());
                    hasCut = true;
                    break;
                }
            }

            if (!hasCut) {
                numNew = numNew.substring(0, numNew.length() - 1);
            }

            numNew = removeZero(numNew);
        }

        if (numNew.length() == 0) {
            return "0";
        }
        return numNew;
    }

    public String removeZero(String input) {

        int i = 0;
        while (i < input.length() && input.charAt(i) == '0') {
            i++;
        }
        if (i == input.length()) {
            return "0";
        }
        return input.substring(i, input.length());
    }

    public String removeKdigits2(String num, int k) {
        if (k == 0)
            return num;
        if (k >= num.length())
            return "0";

        StringBuilder b = new StringBuilder(num);

        // from left to right
        // remove all digits before the 0 when ndexOfZero <= k
        int index = b.indexOf("0");
        while (index != -1 && index <= k) {
            k = k - index;
            b.delete(0, index + 1);

            // delete leading zeoes
            while (b.length() > 0 && b.charAt(0) == '0')
                b.deleteCharAt(0);

            index = b.indexOf("0");
        }

        // now for the remaining k times, remove any occurance of
        // str[i]>str[i+1]
        while (k > 0) {

            int i = 0;
            for (; i < b.length() - 1 && b.charAt(i) <= b.charAt(i + 1); i++) {

            }
            b.deleteCharAt(i);
            k--;
        }

        // delete leading zeroes
        while (b.length() > 0 && b.charAt(0) == '0') {
            b.deleteCharAt(0);
        }

        return b.toString().equals("") ? "0" : b.toString();
    }

    public static void main(String[] args) {

        RemoveKdigits s = new RemoveKdigits();

        long sysDate1 = System.currentTimeMillis();

        // String input = "MCMXCIV";
        String input = "1432219";
        int k = 3;

        String res = s.removeKdigits(input, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}