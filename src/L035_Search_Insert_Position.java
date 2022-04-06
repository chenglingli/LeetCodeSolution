public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] >= target) return i;
            i++;
        }
        return i;
    }

    public static void main(String[] args) {

        SearchInsert s = new SearchInsert();

        long sysDate1 = System.currentTimeMillis();
//        int[] inputNums = {1,2,3,4};
//        int target = 5;

//        int[] inputNums = { };
//        int target = 5;

        int[] inputNums = {1, 2, 3, 4};
        int target = 0;

//        int[] inputNums = {1,2,3,4};
//        int target = 5;

        int res = s.searchInsert(inputNums, target);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }

}