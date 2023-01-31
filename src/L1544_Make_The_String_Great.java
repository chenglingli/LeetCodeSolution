import java.util.ArrayList;
import java.util.List;

public class L1544_Make_The_String_Great {


    public String makeGood(String s) {

        List<Character> array = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            array.add(s.charAt(i));
        }

        int duration = Math.abs('a' - 'A');
        int i = 0;
        int exeMark = 2;

        while (exeMark > 0 && array.size() > 0) {

            i = 0;
            exeMark = 0;

            while (i < array.size() - 1) {
                if (Math.abs(array.get(i) - array.get(i + 1)) == duration) {
                    exeMark = 1;
                    array.remove(i);
                    array.remove(i);
                }

                i++;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (Character character : array) {
            sb.append(character);
        }

        return sb.toString();
    }

    public String makeGood2(String s) {

        StringBuilder sb = new StringBuilder(s);

        int duration = Math.abs('a' - 'A');
        int i = 0;
        int exeMark = 2;

        while (exeMark > 0 && sb.length() > 0) {

            i = 0;
            exeMark = 0;

            while (i < sb.length() - 1) {
                if (Math.abs(sb.charAt(i) - sb.charAt(i + 1)) == duration) {
                    exeMark = 1;
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                }

                i++;
            }
        }

        return sb.toString();
    }

    public String makeGood3(String s) {

        StringBuilder sb = new StringBuilder();
        int duration = Math.abs('a' - 'A');

        for (int i = 0; i < s.length(); i++) {

            char cur = s.charAt(i);

            if (sb.length() == 0) {
                sb.append(cur);
            } else {
                if (Math.abs(sb.charAt(sb.length() - 1) - cur) == duration) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(cur);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        L1544_Make_The_String_Great s =
                new L1544_Make_The_String_Great();
        long sysDate1 = System.currentTimeMillis();

        // String ss = "abBAcC";
        String ss = "abBAbcdD";
        String res = s.makeGood3(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}