public class L2391_Minimum_Amount_of_Time_to_Collect_Garbage {

    /*

    You are given a 0-indexed array of strings garbage where garbage[i] represents the assortment of garbage at the ith house.
    garbage[i] consists only of the characters 'M', 'P' and 'G' representing one unit of metal, paper and glass garbage respectively.
    Picking up one unit of any type of garbage takes 1 minute.

    You are also given a 0-indexed integer array travel where travel[i] is the number of minutes needed to go from house i to house i + 1.

    There are three garbage trucks in the city, each responsible for picking up one type of garbage.
    Each garbage truck starts at house 0 and must visit each house in order; however, they do not need to visit every house.

    Only one garbage truck may be used at any given moment. While one truck is driving or picking up garbage, the other two trucks cannot do anything.

    Return the minimum number of minutes needed to pick up all the garbage.



    Example 1:

    Input: garbage = ["G","P","GP","GG"], travel = [2,4,3]
    Output: 21
    Explanation:
    The paper garbage truck:
    1. Travels from house 0 to house 1
    2. Collects the paper garbage at house 1
    3. Travels from house 1 to house 2
    4. Collects the paper garbage at house 2
    Altogether, it takes 8 minutes to pick up all the paper garbage.
    The glass garbage truck:
    1. Collects the glass garbage at house 0
    2. Travels from house 0 to house 1
    3. Travels from house 1 to house 2
    4. Collects the glass garbage at house 2
    5. Travels from house 2 to house 3
    6. Collects the glass garbage at house 3
    Altogether, it takes 13 minutes to pick up all the glass garbage.
    Since there is no metal garbage, we do not need to consider the metal garbage truck.
    Therefore, it takes a total of 8 + 13 = 21 minutes to collect all the garbage.

    Example 2:
    Input: garbage = ["MMM","PGM","GP"], travel = [3,10]
    Output: 37
    Explanation:
    The metal garbage truck takes 7 minutes to pick up all the metal garbage.
    The paper garbage truck takes 15 minutes to pick up all the paper garbage.
    The glass garbage truck takes 15 minutes to pick up all the glass garbage.
    It takes a total of 7 + 15 + 15 = 37 minutes to collect all the garbage.


    Constraints:

    2 <= garbage.length <= 10^5
    garbage[i] consists of only the letters 'M', 'P', and 'G'.
    1 <= garbage[i].length <= 10
    travel.length == garbage.length - 1
    1 <= travel[i] <= 100

     */

    public int garbageCollection(String[] garbage, int[] travel) {
        int[] lastIndex = new int[3];
        for (int i = 0; i < garbage.length; ++i) {
            int mIndex = garbage[i].indexOf('M');
            if (mIndex != -1) lastIndex[0] = i;

            int pIndex = garbage[i].indexOf('P');
            if (pIndex != -1) lastIndex[1] = i;

            int gIndex = garbage[i].indexOf('G');
            if (gIndex != -1) lastIndex[2] = i;
        }

        int res = 0;
        for (int i = 0; i < 3; ++i) {
            int tempCost = 0;
            for (int j = 1; j <= lastIndex[i]; ++j) {
                if (j > 0) {
                    tempCost += travel[j - 1];
                }
            }
            res += tempCost;
        }

        for (String g : garbage) {
            res += g.length();
        }

        return res;
    }

    /*

    对比小结
    部分	            garbageCollection	        garbageCollection2
    找最后出现位置     一次正向遍历，O(n)             三次反向遍历，最坏 O(3n)
    计算路程          每种垃圾重复累加，最坏 O(3n)   前缀和 O(n) + 3 次 O(1)
    捡垃圾时间       遍历 garbage 累加长度         相同

    整体上，路程计算从「重复累加」变成「前缀和」 是主要提速点；在 n 较大（本题可达 10⁵）时差距会更明显。
     */
    public int garbageCollection2(String[] garbage, int[] travel) {
        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }

        int mIndex = lastIndex(garbage, 'M');
        int pIndex = lastIndex(garbage, 'P');
        int gIndex = lastIndex(garbage, 'G');

        int totalTime = (mIndex <= 0 ? 0 : travel[mIndex - 1])
                + (pIndex <= 0 ? 0 : travel[pIndex - 1])
                + (gIndex <= 0 ? 0 : travel[gIndex - 1]);
        for (String gr : garbage) {
            totalTime += gr.length();
        }

        return totalTime;
    }

    private int lastIndex(String[] garbage, char ch) {
        for (int i = garbage.length - 1; i >= 0; i--) {
            if (garbage[i].indexOf(ch) != -1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        L2391_Minimum_Amount_of_Time_to_Collect_Garbage s = new L2391_Minimum_Amount_of_Time_to_Collect_Garbage();
        long sysDate1 = System.currentTimeMillis();

        String[] garbage = {"G", "P", "GP", "GG"};
        int[] travel = {2, 4, 3};

        int res = s.garbageCollection(garbage, travel);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}