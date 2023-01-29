import java.util.ArrayList;
import java.util.List;

public class L1556_Thousand_Separator {


    public String thousandSeparator(int n) {

        if (n == 0) {
            return "0";
        }

        List<Character> array = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        int copy = n;
        int count = 0;
        while (copy > 0) {

            if (count != 0 && count % 3 == 0) {
                sb.append('.');
            }

            int cur = copy % 10;
            sb.append((char) ('0' + cur));
            copy = copy / 10;
            count++;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        L1556_Thousand_Separator s =
                new L1556_Thousand_Separator();
        long sysDate1 = System.currentTimeMillis();

        int n = 123456;
        //        int n = 0;
        String res = s.thousandSeparator(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}