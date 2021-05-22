public class L275_H_Index_II {

    /**
     * Given an array of citations sorted in ascending order (each citation is a non-negative integer)
     * of a researcher, write a function to compute the researcher's h-index.
     * <p>
     * According to the definition of h-index on Wikipedia:
     * "A scientist has index h if h of his/her N papers have at least h citations each,
     * and the other N − h papers have no more than h citations each."
     * <p>
     * Example:
     * <p>
     * Input: citations = [0,1,3,5,6]
     * Output: 3
     * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
     * received 0, 1, 3, 5, 6 citations respectively.
     * Since the researcher has 3 papers with at least 3 citations each and the remaining
     * two with no more than 3 citations each, her h-index is 3.
     * Note:
     * <p>
     * If there are several possible values for h, the maximum one is taken as the h-index.
     * <p>
     * Follow up:
     * <p>
     * This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
     * Could you solve it in logarithmic time complexity?
     */

    public int hIndex(int[] citations) {

        int len = citations.length, left = 0, right = len - 1;
        while (left <= right) {
            int mid = (int) (0.5 * (left + right));
            if (citations[mid] == len - mid) return len - mid;
            else if (citations[mid] > len - mid) right = mid - 1;
            else left = mid + 1;
        }
        return len - left;
    }

    public static void main(String[] args) {

        L275_H_Index_II s = new L275_H_Index_II();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {0, 1};
        int res = s.hIndex(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}