public class L509_Fibonacci_Number {

    int r[] = new int[31];

    public int fib(int n) {

        if (n == 0) {
            r[0] = 0;
            return 0;
        }

        if (n == 1) {
            r[1] = 1;
            return 1;
        }

        int temp1 = 0;
        if (r[n-1] == 0) {
            temp1 = fib(n-1);
            r[n-1] = temp1;
        } else {
            temp1 = r[n-1];
        }

        int temp2 = 0;
        if (r[n-2] == 0) {
            temp2 = fib(n-2);
            r[n-2] = temp2;
        } else {
            temp2 = r[n-2];
        }

        r[n] = temp1 + temp2;

        return r[n];
    }

    public int fib2(int n) {

        if(n==0)
            return 0;

        if(n==1)
            return 1;

        int sum=1;
        int prevSum=1;
        for(int x=2; x < n; x++  )
        {
            int s=sum;
            sum=sum+prevSum;
            prevSum=s;
        }
        return sum;
    }

    public static void main(String[] args) {

        L509_Fibonacci_Number s = new L509_Fibonacci_Number();
        long sysDate1 = System.currentTimeMillis();
        int res = s.fib(10);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}