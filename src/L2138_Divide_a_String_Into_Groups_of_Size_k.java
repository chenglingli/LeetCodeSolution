import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2138_Divide_a_String_Into_Groups_of_Size_k {

    /*

    1 <= s.length <= 100
    s consists of lowercase English letters only.
    1 <= k <= 100
    fill is a lowercase English letter.

     */
    public String[] divideString(String s, int k, char fill) {

        List<String> resList = new ArrayList<>();
        int n = s.length();
        int curIndex = 0;

        while (curIndex < n) {
            if (curIndex + k <= n) {
                resList.add(s.substring(curIndex, curIndex + k));
            }
            curIndex += k;
        }

        if (curIndex > n) {
            curIndex -= k;
            StringBuilder temp = new StringBuilder();
            temp.append(s, curIndex, n);

            for (int i = 0; i < k - n + curIndex; i++) {
                temp.append(fill);
            }

            resList.add(temp.toString());
        }


        String[] res = new String[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public String[] divideString2(String s, int k, char fill) {

        int full = s.length() / k;
        int last = s.length() % k;

        int size = last == 0 ? full : full + 1;
        String[] res = new String[size];

        for (int i = 0; i < full; i++) {
            res[i] = s.substring(i * k, i * k + k);
        }

        if (last != 0) {
            StringBuilder temp = new StringBuilder(s.substring(full * k, s.length()));
            for (int i = 1; i <= k - last; i++) temp.append(fill);
            res[res.length - 1] = temp.toString();
        }
        return res;
    }

    public static void main(String[] args) {

        L2138_Divide_a_String_Into_Groups_of_Size_k s = new L2138_Divide_a_String_Into_Groups_of_Size_k();
        long sysDate1 = System.currentTimeMillis();

        //        String title = "abcdefghij";
        String title = "abcd";
        int k = 3;
        char fill = 'x';
        String[] res = s.divideString(title, k, fill);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}