public class L3492_Maximum_Containers_on_a_Ship {

    /*
    You are given a positive integer n representing an n x n cargo deck on a ship.
    Each cell on the deck can hold one container with a weight of exactly w.

    However, the total weight of all containers, if loaded onto the deck, must not exceed the ship's maximum weight capacity, maxWeight.

    Return the maximum number of containers that can be loaded onto the ship.



    Example 1:

    Input: n = 2, w = 3, maxWeight = 15

    Output: 4

    Explanation:

    The deck has 4 cells, and each container weighs 3. The total weight of loading all containers is 12,
    which does not exceed maxWeight.

    Example 2:

    Input: n = 3, w = 5, maxWeight = 20

    Output: 4

    Explanation:

    The deck has 9 cells, and each container weighs 5. The maximum number of containers that can be loaded without exceeding maxWeight is 4.



    Constraints:

    1 <= n <= 1000
    1 <= w <= 1000
    1 <= maxWeight <= 109
     */
    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(maxWeight / w, n * n);
    }

    public static void main(String[] args) {

        L3492_Maximum_Containers_on_a_Ship s = new L3492_Maximum_Containers_on_a_Ship();
        long sysDate1 = System.currentTimeMillis();

        int n = 50;
        int w = 10;
        int maxWeight = 100;

        int res = s.maxContainers(n, w, maxWeight);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}