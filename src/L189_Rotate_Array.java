// Reverse bits of a given 32 bits unsigned integer.

public class L189_Rotate_Array {

    // use more space
    public void rotate(int[] nums, int k) {

        int len = nums.length;
        k = k % len;
        if (k == 0) {
            return;
        }

        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[(i + k) % len ] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }
    }


    // in place
    public void reverse(int[] nums, int l, int r)
    {
        while(l<r)
        {
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
    public void rotate2(int[] nums, int k) {
        int n=nums.length;
        k%=n;
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }

    public static void main(String[] args) {

        L189_Rotate_Array s = new L189_Rotate_Array();

        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        s.rotate2(nums, k);

        System.out.println(nums);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}