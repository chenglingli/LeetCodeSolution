import java.util.ArrayList;
import java.util.List;

public class L241_Different_Ways_to_Add_Parentheses {

    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);

            if (c == '-' || c == '+' || c == '*') {
                String a = expression.substring(0, i);
                String b = expression.substring(i + 1);

                List<Integer> a1 = diffWaysToCompute(a);
                List<Integer> b1 = diffWaysToCompute(b);

                for (int x : a1) {
                    for (int y : b1) {
                        if (c == '-')
                            res.add(x - y);
                        if (c == '+')
                            res.add(x + y);
                        if (c == '*')
                            res.add(x * y);
                    }
                }
            }
        }

        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }

        return res;
    }


    public static void main(String[] args) {

        L241_Different_Ways_to_Add_Parentheses s = new L241_Different_Ways_to_Add_Parentheses();

        long sysDate1 = System.currentTimeMillis();

        String expression = "2-1-1";

        List<Integer> res = s.diffWaysToCompute(expression);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}