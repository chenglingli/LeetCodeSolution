import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L500_Keyboard_Row {

    public String[] findWords(String[] words) {

        String[] s = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> res = new ArrayList<>();

        for (String word : words) {

            String cur = word.toLowerCase();

            if (cur.length() == 1) {
                res.add(word);
                continue;
            }

            // 定位第一个字符
            int index = -1;
            for (int j = 0; j < s.length; j++) {
                if (s[j].indexOf(cur.charAt(0)) != -1) {
                    index = j;
                    break;
                }
            }

            int k = 0;
            for (k = 1; k < cur.length(); k++) {
                if (s[index].indexOf(cur.charAt(k)) == -1) {
                    break;
                }
            }
            if (k == cur.length()) {
                res.add(word);
            }

        }

        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {

        L500_Keyboard_Row s = new L500_Keyboard_Row();
        long sysDate1 = System.currentTimeMillis();
        // int input = 101;
        // String[] input = {"Hello","Alaska","Dad","Peace"};
        String[] input = {"a","b"};

        String[] res = s.findWords(input);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}