public class L1913_Maximum_Product_Difference_Between_Two_Pairs {

    /*
    4 <= nums.length <= 104
    1 <= nums[i] <= 104
     */
    public int maxProductDifference(int[] nums) {

        int max1 = 0, max2 = 0;
        int min1 = 10001, min2 = 10001;
        for (int x : nums) {
            if (x > max2) {
                if (x > max1) {
                    max2 = max1;
                    max1 = x;
                } else {
                    max2 = x;
                }
            }

            if (x < min2) {
                if (x < min1) {
                    min2 = min1;
                    min1 = x;
                } else {
                    min2 = x;
                }
            }
        }

        return max1 * max2 - min1 * min2;
    }


    public static int max_numbers(int nums[], int index){
        int max = Integer.MIN_VALUE;
        int ind =0;
        for(int i =0; i<nums.length; i++){
            if(nums[i] > max && i != index){
                max = nums[i];
                ind = i;
            }
        }
        return ind;
    }


    public static int min_numbers(int nums[], int index){
        int min = Integer.MAX_VALUE;
        int ind =0;
        for(int i =0; i<nums.length; i++){
            if(nums[i] < min && i != index){
                min = nums[i];
                ind = i;
            }
        }
        return ind;
    }


    public int maxProductDifference2(int[] nums) {
        int max1 = max_numbers(nums, -1);
        int max2 = max_numbers(nums, max1);
        int min1 = min_numbers(nums, -1);
        int min2 = min_numbers(nums, min1);
        return (nums[max1]*nums[max2]) - (nums[min1]*nums[min2]);
    }


    public static void main(String[] args) {

        L1913_Maximum_Product_Difference_Between_Two_Pairs s = new L1913_Maximum_Product_Difference_Between_Two_Pairs();
        long sysDate1 = System.currentTimeMillis();

        int[] num = {4, 2, 5, 9, 7, 4, 8};
        int res = s.maxProductDifference(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}