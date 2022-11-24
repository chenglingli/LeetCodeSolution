import java.util.HashSet;

public class L575_Distribute_Candies {


    public int distributeCandies(int[] candyType) {

        if (candyType.length % 2 != 0) {
            return 0;
        }

        HashSet<Integer> existMap = new HashSet<>();

        for (int j : candyType) {
            existMap.add(j);
            if (existMap.size() >= candyType.length / 2) {
                return candyType.length / 2;
            }
        }

        return existMap.size();
    }

    public int distributeCandies2(int[] candyType) {

        boolean[] type = new boolean[200001];
        int count = 0, max = candyType.length / 2;
        for (int candy : candyType) {
            int t = candy + 100000;
            if (!type[t]) {
                if (++count == max)
                    return max;
                type[t] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        L575_Distribute_Candies s = new L575_Distribute_Candies();

        long sysDate1 = System.currentTimeMillis();

        int[] nums = {2, 5, 4, 8, 10, 9};
        int res = s.distributeCandies(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}