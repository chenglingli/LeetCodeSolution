import java.util.ArrayList;
import java.util.List;

public class L1408_String_Matching_in_an_Array {


    public List<String> stringMatching(String[] words) {

        List<String> res = new ArrayList<>();

        for (int i = 0 ; i < words.length; i++) {
            String cur = words[i];

            for (int j = 0 ; j < words.length ; j++) {
                if (i == j) {
                    continue;
                }
                String target = words[j];
                if (target.length() <= cur.length()) {
                    continue;
                }

                if (target.contains(cur)) {
                    res.add(cur);
                    break;
                }
            }
        }

        return res;
    }

    public List<String> stringMatching2(String[] words) {

        String total = String.join(" ", words);

        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (total.indexOf(word) != total.lastIndexOf(word)) {
                res.add(word);
            }
        }

        return res;
    }


    public static void main(String[] args) {

        L1408_String_Matching_in_an_Array s = new L1408_String_Matching_in_an_Array();
        long sysDate1 = System.currentTimeMillis();

        String[] words = {"mass","as","hero","superhero"};

        List<String> res = s.stringMatching(words);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}