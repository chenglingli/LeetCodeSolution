public class L1925_Count_Square_Sum_Triples {

    /*
    a2 + b2 = c2
    1 <= a, b, c <= n
    寻找完全平方和

    1 <= n <= 250
     */
    public int countTriples(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (i * i + j * j == k * k) {
                        count += 2;
                    }
                }
            }
        }

        return count;
    }

    public int countTriples2(int n) {

        int c = 0;
        for (int i = 1; i <= n; i++) {
            c = c + trip(i);
        }

        return c * 2;
    }

    int trip(int k) {

        int c = 0;
        int k2 = k * k;

        int i = 1, j = k - 1;
        while (i < j) {
            if ((i * i + j * j) == k2) {
                c++;

                i++;
                j--;
            } else if ((i * i + j * j) < k2) {
                i++;
            } else {
                j--;
            }
        }

        return c;
    }

    public static void main(String[] args) {

        L1925_Count_Square_Sum_Triples s = new L1925_Count_Square_Sum_Triples();
        long sysDate1 = System.currentTimeMillis();

        int num = 10;
        int res = s.countTriples2(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}