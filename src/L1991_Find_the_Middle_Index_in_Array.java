public class L1991_Find_the_Middle_Index_in_Array {


    /*
    Return the leftmost middleIndex that satisfies the condition, or -1 if there is no such index.

    1 <= nums.length <= 100
    -1000 <= nums[i] <= 1000

     */
    public int findMiddleIndex(int[] nums) {

        int leftSum = 0;
        int rightSum = 0;

        int sum = 0;
        int i = 0;
        while (i < nums.length) {
            sum += nums[i];
            i++;
        }

        for (i = 0 ; i < nums.length ; i++) {
            rightSum = sum - leftSum - nums[i];
            if (leftSum == rightSum) {
                break;
            }

            leftSum += nums[i];
        }

        if (i == nums.length) {
            return -1;
        }
        else {
            return i;
        }
    }

    public static void main(String[] args) {

        L1991_Find_the_Middle_Index_in_Array s = new L1991_Find_the_Middle_Index_in_Array();
        long sysDate1 = System.currentTimeMillis();

        // int[] patterns = {2, 3, -1, 8, 4};
//        int[] patterns = {1,-1,4};
        int[] patterns = {2,5};
        int res = s.findMiddleIndex(patterns);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}