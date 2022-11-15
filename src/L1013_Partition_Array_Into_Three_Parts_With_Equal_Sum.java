public class L1013_Partition_Array_Into_Three_Parts_With_Equal_Sum {

    public boolean canThreePartsEqualSum(int[] arr) {

        int totalSum = 0;
        for (int num : arr) totalSum += num;
        if (totalSum % 3 != 0) return false;
        int periodSum = totalSum / 3;

        int i = 0;
        int frontSum = 0;
        frontSum += arr[i++];
        while (frontSum != periodSum && i < arr.length) {
            frontSum += arr[i];
            i++;
        }
        if (i == arr.length) {
            return false;
        }

        int j = arr.length - 1;
        int rearSum = 0;
        rearSum += arr[j--];
        while (rearSum != periodSum && j >= 0) {
            rearSum += arr[j];
            j--;
        }
        if (j < 0 || j < i) {
            return false;
        }

        return true;
    }

    public boolean canThreePartsEqualSum2(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        if (sum % 3 != 0) return false;

        int average = sum / 3;
        int subSum = 0;
        int counter = 0;

        for (int j : arr) {
            subSum += j;
            if (subSum == average) {
                subSum = 0;
                counter++;
            }
        }

        return counter >= 3;
    }

    public static void main(String[] args) {

        L1013_Partition_Array_Into_Three_Parts_With_Equal_Sum s = new L1013_Partition_Array_Into_Three_Parts_With_Equal_Sum();

        long sysDate1 = System.currentTimeMillis();

        //        int[] arr = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        int[] arr = {1,-1,1,-1};
        boolean res = s.canThreePartsEqualSum(arr);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}