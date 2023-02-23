import java.util.ArrayList;
import java.util.List;

public class L1417_Reformat_The_String {

    public String reformat(String s) {

        if (s.length() == 0) return "";

        List<Character> numList = new ArrayList<>();
        List<Character> alphaList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numList.add(c);
            } else {
                alphaList.add(c);
            }
        }

        if (Math.abs(alphaList.size() - numList.size()) > 1) return "";

        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < numList.size() && i < alphaList.size()) {
            res.append(numList.get(i));
            res.append(alphaList.get(i));
            i++;
        }

        if (i < numList.size()) res.append(numList.get(i));
        if (i < alphaList.size()) res.insert(0, alphaList.get(i));

        return res.toString();
    }


    private boolean isDigit(char c) {
        return (c >= '0') && (c <= '9');
    }

    public String reformat2(String s) {

        int chCount = 0;
        int digitCount = 0;

        int len = s.length();
        char[] input = s.toCharArray();
        for (int i = 0; i < len; ++i) {
            char current = input[i];
            if (isDigit(current))
                ++digitCount;
            else
                ++chCount;
        }

        if (Math.abs(chCount - digitCount) > 1)
            return "";

        boolean moreDigits = digitCount > chCount;

        int evenPtr = 0;
        int oddPtr = 1;

        while ((evenPtr < len) && (oddPtr < len)) {
            char evenVal = input[evenPtr];
            char oddVal = input[oddPtr];

            if (moreDigits) {
                if (!isDigit(evenVal)) {
                    if (isDigit(oddVal)) {
                        input[evenPtr] = oddVal;
                        input[oddPtr] = evenVal;

                        evenPtr += 2;
                    }
                    oddPtr += 2;
                } else {
                    evenPtr += 2;
                }
            } else {
                if (isDigit(evenVal)) {
                    if (!isDigit(oddVal)) {
                        input[evenPtr] = oddVal;
                        input[oddPtr] = evenVal;

                        evenPtr += 2;
                    }
                    oddPtr += 2;
                } else {
                    evenPtr += 2;
                }
            }
        }

        return String.valueOf(input);
    }

    public static void main(String[] args) {

        L1417_Reformat_The_String s = new L1417_Reformat_The_String();
        long sysDate1 = System.currentTimeMillis();

        //        String input = "123abc";
        //        String input = "12abc";
        //        String input = "123ab";
        //        String input = "1abc";
        //        String input = "abc";
        String input = "";

        String res = s.reformat(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}