import java.util.ArrayList;
import java.util.List;

public class L412_Fizz_Buzz {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {

        L412_Fizz_Buzz s = new L412_Fizz_Buzz();

        long sysDate1 = System.currentTimeMillis();

        int m = 100;

        List<String> res = s.fizzBuzz(m);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}