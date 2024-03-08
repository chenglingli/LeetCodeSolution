public class L458_Poor_Pigs {

    /*

    每头猪在 minutesToTest 时间范围内，有x种状态
        x = minutesToTest / minutesToDie + 1
    譬如 minutesToTest = 60, minutesToDie = 15, 那么 x = 5
        意思是，可以是15，30，45，60分钟时死亡，或者最后活着

    每种状态都可以对应一瓶水，所以每头猪可以测试x瓶水
    有res头猪，可以测试x^res瓶水
    所以 x^res >= buckets
    也就是 res >= log(x, buckets)
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int x = minutesToTest / minutesToDie + 1;
        int res = 0;

        while (Math.pow(x, res) < buckets) {
            res++;
        }

        return res;
    }

    public static void main(String[] args) {

        L458_Poor_Pigs s = new L458_Poor_Pigs();

        long sysDate1 = System.currentTimeMillis();

        int buckets = 1000;
        int minutesToDie = 15;
        int minutesToTest = 15;

        int res = s.poorPigs(buckets, minutesToDie, minutesToTest);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}