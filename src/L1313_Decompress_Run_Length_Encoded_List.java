import java.util.Arrays;

public class L1313_Decompress_Run_Length_Encoded_List {

    public int[] decompressRLElist(int[] nums) {

        int size = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            size += nums[i];
        }
        int[] res = new int[size];

        int x = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int a = nums[i];
            int b = nums[i + 1];
            for (int k = 0; k < a; k++) {
                res[x++] = b;
            }
        }

        return res;
    }


    public static void main(String[] args) {

        L1313_Decompress_Run_Length_Encoded_List s = new L1313_Decompress_Run_Length_Encoded_List();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4};

        int[] res = s.decompressRLElist(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}