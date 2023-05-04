import java.util.ArrayList;
import java.util.List;

public class L824_Goat_Latin {

    public String toGoatLatin(String sentence) {

        List<Character> vowelList = new ArrayList<>();
        vowelList.add('a');
        vowelList.add('e');
        vowelList.add('i');
        vowelList.add('o');
        vowelList.add('u');
        vowelList.add('A');
        vowelList.add('E');
        vowelList.add('I');
        vowelList.add('O');
        vowelList.add('U');

        StringBuilder AStr = new StringBuilder();
        AStr.append('a');

        StringBuilder res = new StringBuilder();
        String[] sentenceList = sentence.split(" ");

        for (String curStr : sentenceList) {
            StringBuilder cur = new StringBuilder();
            if (vowelList.contains(curStr.charAt(0))) {
                cur.append(curStr);
            } else {
                cur.append(curStr.substring(1));
                cur.append(curStr.charAt(0));
            }

            cur.append("ma");
            cur.append(AStr);

            res.append(cur);
            res.append(" ");

            AStr.append('a');
        }

        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }


    public static void main(String[] args) {

        L824_Goat_Latin s = new L824_Goat_Latin();
        long sysDate1 = System.currentTimeMillis();

        String ss = "I speak Goat Latin";
        String res = s.toGoatLatin(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}