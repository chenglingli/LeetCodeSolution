import java.util.ArrayList;
import java.util.List;

public class L2899_Last_Visited_Integers {

    /*
    1 <= words.length <= 100
    words[i] == "prev" or 1 <= int(words[i]) <= 100
     */
    public List<Integer> lastVisitedIntegers(List<String> words) {

            List<Integer> res = new ArrayList<>();

            int[] nums = new int[101];
            int last = -1;
            int i = 0;

            for (String cur : words) {
                if (cur.equals("prev")) {
                    if (last == -1) {
                        res.add(-1);
                    }
                    else {
                        res.add(nums[last]);
                        last--;
                    }
                } else {
                    int curNum = Integer.parseInt(cur);
                    nums[i] = curNum;
                    last = i;
                    i++;
                }
            }

            return res;
    }

    public static void main(String[] args) {

        L2899_Last_Visited_Integers s = new L2899_Last_Visited_Integers();
        long sysDate1 = System.currentTimeMillis();

//        List<String> words = new ArrayList<>();
//        words.add("1");
//        words.add("prev");
//        words.add("2");
//        words.add("prev");
//        words.add("prev");

        List<String> words = new ArrayList<>();
        words.add("prev");
        words.add("prev");
        words.add("prev");
        words.add("27");

        List<Integer> res = s.lastVisitedIntegers(words);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}