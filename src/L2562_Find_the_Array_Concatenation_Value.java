public class L2562_Find_the_Array_Concatenation_Value {

    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            res += ConcVal(nums[i], nums[j]);
            i++;
            j--;
        }
        if (i == j) {
            res += nums[i];
        }

        return res;
    }

    private long ConcVal(int a, int b) {
        StringBuilder temp = new StringBuilder();
        temp.append(a);
        temp.append(b);
        return Long.parseUnsignedLong(temp.toString());
    }

    public long concat2(int n1, int n2) {
        int x = n2;
        while (n2 != 0) {
            n1 = n1 * 10;
            n2 = n2 / 10;
        }
        return n1 + x;
    }

    public static void main(String[] args) {

        L2562_Find_the_Array_Concatenation_Value s = new L2562_Find_the_Array_Concatenation_Value();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {5, 14, 13, 8, 12};
        long res = s.findTheArrayConcVal(nums);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}