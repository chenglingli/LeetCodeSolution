import java.util.Arrays;

public class L3074_Apple_Redistribution_into_Boxes {

    /*

    You are given an array apple of size n and an array capacity of size m.

    There are n packs where the ith pack contains apple[i] apples.
    There are m boxes as well, and the ith box has a capacity of capacity[i] apples.

    Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.

    Note that, apples from the same pack can be distributed into different boxes.



    Example 1:

    Input: apple = [1,3,2], capacity = [4,3,1,5,2]
    Output: 2
    Explanation: We will use boxes with capacities 4 and 5.
    It is possible to distribute the apples as the total capacity is greater than or equal to the total number of apples.
    Example 2:

    Input: apple = [5,5,5], capacity = [2,4,2,7]
    Output: 4
    Explanation: We will need to use all the boxes.


    Constraints:

    1 <= n == apple.length <= 50
    1 <= m == capacity.length <= 50
    1 <= apple[i], capacity[i] <= 50
    The input is generated such that it's possible to redistribute packs of apples into boxes.
     */

    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalAppleSize = 0;
        for (int x : apple) {
            totalAppleSize += x;
        }

        Arrays.sort(capacity);
        int i = capacity.length - 1;
        while (i >= 0 && totalAppleSize > 0) {
            totalAppleSize -= capacity[i];
            i--;
        }

        return capacity.length - i - 1;
    }

    public int minimumBoxes2(int[] apple, int[] capacity) {
        int total = 0;
        for (int a : apple)
            total += a;

        int[] freq = new int[51];
        for (int c : capacity)
            ++freq[c];

        int ans = 0, c = 50;
        while (total > 0) {
            while (freq[c] == 0)
                --c;
            total -= c;
            --freq[c];
            ++ans;
        }

        return ans;
    }

    public static void main(String[] args) {

        L3074_Apple_Redistribution_into_Boxes s = new L3074_Apple_Redistribution_into_Boxes();
        long sysDate1 = System.currentTimeMillis();

        int[] apple = {1, 3, 2};
        int[] capacity = {3, 1, 1, 1, 2};

        int res = s.minimumBoxes(apple, capacity);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}