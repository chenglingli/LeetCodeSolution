
//Given an array of size n, find the majority element.
// The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
// You may assume that the array is non-empty and the majority element always exist in the array.

public class MajorityElement {

    public int majorityElement(int[] nums) {

            int count = 1, major = nums[0];

            for (int i = 1; i < nums.length; i++) {

                if (count == 0) {
                    major = nums[i];
                    count ++;
                }
                else {
                    if (major == nums[i]) {
                        count ++;
                    }
                    else {
                        count --;
                    }
                }
            }

            return major;
    }


    public static void main(String[] args) {

        MajorityElement s = new MajorityElement();

        long sysDate1 = System.currentTimeMillis();

        int [] x = {1, 1, 2, 3, 1};

        int res = s.majorityElement(x);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}