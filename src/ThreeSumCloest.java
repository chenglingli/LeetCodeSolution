import java.util.Arrays;

public class ThreeSumCloest {


    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums); // {-1,-1,0,1,2,4}

        int res = Integer.MAX_VALUE/2;

        for (int i = 0; i < length - 2; i++) {
            int head = i + 1, tail = length - 1;
            while (head < tail) {
                int temp = nums[head] + nums[tail] + nums[i];

                if (temp > target) {
                    tail--;
                } else {
                    head++;
                }
                if (Math.abs(temp - target) < Math.abs(res - target)) {
                    res = temp;
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {

        ThreeSumCloest s = new ThreeSumCloest();

        long sysDate1 = System.currentTimeMillis();


        int[] nums = {1,1,-1,-1,3};

        int res = s.threeSumClosest(nums, -1);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}