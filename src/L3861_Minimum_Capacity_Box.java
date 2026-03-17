public class L3861_Minimum_Capacity_Box {

    /*
    You are given an integer array capacity, where capacity[i] represents the capacity of the ith box, and an integer itemSize representing the size of an item.

    The ith box can store the item if capacity[i] >= itemSize.

    Return an integer denoting the index of the box with the minimum capacity that can store the item. If multiple such boxes exist, return the smallest index.

    If no box can store the item, return -1.



    Example 1:

    Input: capacity = [1,5,3,7], itemSize = 3

    Output: 2

    Explanation:

    The box at index 2 has a capacity of 3, which is the minimum capacity that can store the item. Thus, the answer is 2.

    Example 2:

    Input: capacity = [3,5,4,3], itemSize = 2

    Output: 0

    Explanation:

    The minimum capacity that can store the item is 3, and it appears at indices 0 and 3. Thus, the answer is 0.

    Example 3:

    Input: capacity = [4], itemSize = 5

    Output: -1

    Explanation:

    No box has enough capacity to store the item, so the answer is -1.



    Constraints:

    1 <= capacity.length <= 100
    1 <= capacity[i] <= 100
    1 <= itemSize <= 100

     */
    public int minimumIndex(int[] capacity, int itemSize) {
        int n = capacity.length;
        int minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (capacity[i] >= itemSize) {
                if (minIndex == -1 || capacity[i] < capacity[minIndex]) {
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {

        L3861_Minimum_Capacity_Box s = new L3861_Minimum_Capacity_Box();
        long sysDate1 = System.currentTimeMillis();

        int[] capacity = {1, 5, 3, 7};
        int itemSize = 3;

        int res = s.minimumIndex(capacity, itemSize);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}