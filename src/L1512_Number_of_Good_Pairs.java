public class L1512_Number_of_Good_Pairs {

    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        int[] count = new int[101];

        for (int x : nums) {
            count[x]++;
        }

        for (int cur : count) {
            if (cur > 0) {
                res += countCTwo(cur);
            }
        }

        return res;
    }

    private int countCTwo(int x) {
        return x * (x - 1) / 2;
    }

    public static void main(String[] args) {

        L1512_Number_of_Good_Pairs s = new L1512_Number_of_Good_Pairs();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 1, 1, 3};
        int res = s.numIdenticalPairs(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}