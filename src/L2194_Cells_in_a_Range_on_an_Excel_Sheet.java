import java.util.ArrayList;
import java.util.List;

public class L2194_Cells_in_a_Range_on_an_Excel_Sheet {

    /*
    Input: s = "K1:L2"
    Output: ["K1","K2","L1","L2"]

    s.length == 5
    'A' <= s[0] <= s[3] <= 'Z'
    '1' <= s[1] <= s[4] <= '9'
    s consists of uppercase English letters, digits and ':'.
     */
    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();

        int x = s.charAt(0);
        int y = s.charAt(3);
        int a = s.charAt(1);
        int b = s.charAt(4);

        for (int i = x; i <= y; i++) {
            for (int j = a; j <= b; j++) {
                StringBuilder temp = new StringBuilder();
                temp.append((char) (i));
                temp.append((char) j);
                res.add(temp.toString());
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L2194_Cells_in_a_Range_on_an_Excel_Sheet s =
                new L2194_Cells_in_a_Range_on_an_Excel_Sheet();
        long sysDate1 = System.currentTimeMillis();

        String input = "K1:L2";
        List<String> res = s.cellsInRange(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}