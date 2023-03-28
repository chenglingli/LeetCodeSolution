public class L1748_Sum_of_Unique_Elements {


    /*
    1 <= nums.length <= 100
    1 <= nums[i] <= 100
     */
    public int sumOfUnique(int[] nums) {

        int[] mark = new int[101];
        int sum = 0;

        for (int x : nums) {
            if (mark[x] == 1) {
                sum -= x;
                mark[x] = 2;
            } else if (mark[x] == 0) {
                mark[x] = 1;
                sum += x;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        L1748_Sum_of_Unique_Elements s = new L1748_Sum_of_Unique_Elements();
        long sysDate1 = System.currentTimeMillis();

        int[] boxTypes = {1, 1, 1, 1, 1};
        int res = s.sumOfUnique(boxTypes);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}