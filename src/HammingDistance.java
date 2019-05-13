

public class HammingDistance {


    public int hammingDistance(int x, int y) {
        int c =  x^y;

        int count = 0;
        while (c!= 0) {
            count += c%2;
            c = c/2;
        }
        return count;
    }

    public static void main(String[] args) {

        HammingDistance s = new HammingDistance();

        long sysDate1 = System.currentTimeMillis();

        int res = s.hammingDistance(1, 4);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}