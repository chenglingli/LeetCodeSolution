public class L088_Merge_Sorted_Array {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] numsRes = new int[10000];
        int i = 0, j = 0, k = 0;
        while (i < m || j < n) {
            if (i == m) {
                numsRes[k++] = nums2[j++];
            } else if (j == n) {
                numsRes[k++] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                numsRes[k++] = nums1[i++];
            } else {
                numsRes[k++] = nums2[j++];
            }
        }
        for (i = 0; i < k; i++) {
            nums1[i] = numsRes[i];
        }
    }

    public static void main(String[] args) {

        L088_Merge_Sorted_Array s = new L088_Merge_Sorted_Array();

        long sysDate1 = System.currentTimeMillis();

        int nums1[] = {1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        s.merge(nums1, 3, nums2, 3);

        System.out.println("nums:");
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}