public class L2810_Faulty_Keyboard {

    /*
        1 <= s.length <= 100
        s consists of lowercase English letters.
        s[0] != 'i'
     */

    public String finalString(String s) {

        StringBuilder res = new StringBuilder();
        char[] charArray = s.toCharArray();

        for (char x : charArray) {
            if (x == 'i') {
                res.reverse();
            } else {
                res.append(x);
            }
        }

        return res.toString();
    }

    public String finalString2(String s) {

        char[] result = new char[s.length()];
        int index = 0;

        for (char c : s.toCharArray()) {
            if (c == 'i') {

                int start = 0;
                int end = index - 1;

                while (start < end) {
                    char temp = result[start];
                    result[start] = result[end];
                    result[end] = temp;
                    start++;
                    end--;
                }
            } else {
                result[index] = c;
                index++;
            }
        }

        return new String(result, 0, index);
    }

    public static void main(String[] args) {

        L2810_Faulty_Keyboard s = new L2810_Faulty_Keyboard();
        long sysDate1 = System.currentTimeMillis();

        String input = "poiinter";
        String res = s.finalString(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}