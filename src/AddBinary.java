
public class AddBinary {

    public String addBinary(String a, String b) {

        int [] res = new int[1000];

        int i = a.length() - 1, j = b.length() - 1, k = 0;

        while (i >= 0 || j >= 0) {

            if (j < 0) {
                res[k] = (a.charAt(i) - '0');
                i--;
                k++;
                continue;
            }

            if (i < 0) {
                res[k] = (b.charAt(j) - '0');
                j--;
                k++;
                continue;
            }

            char ai = a.charAt(i);
            char bi = b.charAt(j);

            res[k] = (ai - '0') + (bi - '0');
            k++;
            i--;
            j--;
        }

        int resLen = k;
        for (i = 0; i < resLen ; i++) {
            if (res[i] >= 2) {
                res[i] -= 2;
                res[i+1] += 1;
            }
        }

        if (res[resLen] == 1) resLen += 1;

        for (i = 0; i < resLen/2 ; i++) {
            int temp = res[i];
            res[i] = res[resLen - i - 1];
            res[resLen - i - 1] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < resLen; i++) sb.append(res[i]);

        return sb.toString();
    }

    public static void main(String[] args) {

        AddBinary s = new AddBinary();

        long sysDate1 = System.currentTimeMillis();

        //int [] digits = {1, 2, 3};
        String a = "110111";
        String b = "101";
        String res = s.addBinary(a, b);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}