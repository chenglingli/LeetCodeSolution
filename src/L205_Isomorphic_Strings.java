import java.util.HashMap;
import java.util.Map;

public class L205_Isomorphic_Strings {

    public boolean isIsomorphic(String s, String t) {

        if (s == null || t==null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        return convert(s).equals(convert(t));
    }

    public String convert(String s) {
        Map<Character, Integer> m = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (m.containsKey(temp)) {
                sb.append(m.get(temp).toString());
            }
            else {
                m.put(temp, count);
                count ++;
                sb.append(m.get(temp).toString());
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        L205_Isomorphic_Strings s = new L205_Isomorphic_Strings();

        long sysDate1 = System.currentTimeMillis();

        boolean res = s.isIsomorphic("paper", "title");
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}