import java.util.*;

public class L050_Pow_x_n {

    public double myPow(double x, int n) {

        //排除特殊情况
        if (n == 0)
            return 1;

        //一定要转化为long型，防止表示-n时溢出
        long tmpN = n;
        if (n < 0)
        {
            x = 1 / x;
            tmpN = -(long)n;;
        }
        return quickPow(x, tmpN);
    }

    double quickPow(double x, long n)
    {
        //递归出口
        if (n == 1)
            return x;

        //递归主体
        long tmp = n / 2;
        double res = quickPow(x, tmp);

        //返回情况
        if (n % 2 == 0)
            return res * res;
        else
            return res * res * x;
    }

    public static void main(String[] args) {

        L050_Pow_x_n s = new L050_Pow_x_n();

        long sysDate1 = System.currentTimeMillis();

        Double res = s.myPow(2, 3);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}