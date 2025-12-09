public class L3591_Check_if_Any_Element_Has_Prime_Frequency {

    /*
    You are given an integer array nums.

    Return true if the frequency of any element of the array is prime, otherwise, return false.

    The frequency of an element x is the number of times it occurs in the array.

    A prime number is a natural number greater than 1 with only two factors, 1 and itself.



    Example 1:

    Input: nums = [1,2,3,4,5,4]

    Output: true

    Explanation:

    4 has a frequency of two, which is a prime number.

    Example 2:

    Input: nums = [1,2,3,4,5]

    Output: false

    Explanation:

    All elements have a frequency of one.

    Example 3:

    Input: nums = [2,2,2,4,4]

    Output: true

    Explanation:

    Both 2 and 4 have a prime frequency.



    Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 100
     */
    public boolean checkPrimeFrequency(int[] nums) {
        int[] freq = new int[101];

        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 1 && isPrime(freq[i])) {
                return true;
            }
        }

        return false;

    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L3591_Check_if_Any_Element_Has_Prime_Frequency s = new L3591_Check_if_Any_Element_Has_Prime_Frequency();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4, 5, 5};

        boolean res = s.checkPrimeFrequency(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}