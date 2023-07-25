public class L1128_Number_of_Equivalent_Domino_Pairs {

    /*
    1 <= dominoes.length <= 4 * 10^4
    dominoes[i].length == 2
    1 <= dominoes[i][j] <= 9

    Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length
     and dominoes[i] is equivalent to dominoes[j]

     */
    public int numEquivDominoPairs(int[][] dominoes) {

        int[][] map = new int[10][10];

        for (int[] point : dominoes) {
            if (point[0] <= point[1]) map[point[0]][point[1]]++;
            else map[point[1]][point[0]]++;
        }

        int ans = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = i; j <= 9; j++) {
                if (map[i][j] > 0) ans += map[i][j] * (map[i][j] - 1) / 2;
            }
        }

        return ans;
    }

    public int numEquivDominoPairs2(int[][] dominoes) {
        int result = 0;
        int[] primes = new int[]{1, 2, 3, 5, 7, 9, 11, 13, 17, 19};
        int[] array = new int[1 + 19 * 19];

        for (int[] d : dominoes) {
            result += array[primes[d[0]] * primes[d[1]]]++;
        }
        return result;
    }

    public static void main(String[] args) {

        L1128_Number_of_Equivalent_Domino_Pairs s = new L1128_Number_of_Equivalent_Domino_Pairs();
        long sysDate1 = System.currentTimeMillis();

        //        int[][] dominoes = {{1, 2}, {2, 1}, {1, 1}, {1, 2}};
        int[][] dominoes = {{1, 1}, {2, 2}, {1, 1}, {1, 2}, {1, 2}, {1, 1}};
        // [[1,2],[1,2],[1,1],[1,2],[2,2]]
        // 1 1 - 1
        // 1 1 1 - 2 + 1 = 3
        // 1 1 1 1  - 3 + 2 + 1 = 6
        // 1 1 1 1 1 - 4 + 3 + 2 + 1 = 10

        int res = s.numEquivDominoPairs(dominoes);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}