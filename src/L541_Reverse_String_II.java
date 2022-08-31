public class L541_Reverse_String_II {

    public String reverseStr(String s, int k) {

        StringBuilder res = new StringBuilder();

        int count = 0;

        for (int i = 0; i < s.length(); i += k) {

            StringBuilder temp = new StringBuilder();
            for (int j = i; j < i+k && j < s.length(); j++) {
                temp.append(s.charAt(j));
            }
            if (count % 2 != 0) {
                res.append(temp);
            } else {
                res.append(temp.reverse());
            }
            count++;
        }

        return res.toString();
    }

    public String reverseStr2(String s, int k) {

        char temp[] = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2 * k) {
            reverse(temp, i, Math.min(i + k - 1, temp.length - 1));

        }

        return String.valueOf(temp);

    }

    static void reverse(char a[], int l, int r) {

        while (l <= r) {
            char t = a[l];
            a[l] = a[r];
            a[r] = t;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {

        L541_Reverse_String_II s = new L541_Reverse_String_II();
        long sysDate1 = System.currentTimeMillis();
        String input = "abcdefw";
        // bacdef
        String res = s.reverseStr(input, 8);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}