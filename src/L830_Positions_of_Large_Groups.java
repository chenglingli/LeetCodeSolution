import java.util.ArrayList;
import java.util.List;

public class L830_Positions_of_Large_Groups {

    /*

    1 <= s.length <= 1000
    s contains lowercase English letters only.

     */
    public List<List<Integer>> largeGroupPositions(String s) {

        int i = 0;
        char[] sCharArray = s.toCharArray();
        int j = 1;
        List<List<Integer>> res = new ArrayList<>();

        while (i < sCharArray.length) {

            if (i + j < sCharArray.length && sCharArray[i + j] == sCharArray[i]) {
                j++;
            } else {
                if (j >= 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(i + j - 1);
                    res.add(temp);
                }

                i += j;
                j = 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L830_Positions_of_Large_Groups s = new L830_Positions_of_Large_Groups();
        long sysDate1 = System.currentTimeMillis();

        // String input = "abcdddeeeeaabbbcd";
        // [[3,5],[6,9],[12,14]]

        String input = "aaaabbbb";
        //


        List<List<Integer>> res = s.largeGroupPositions(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}